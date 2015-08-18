package com.grupo.forms.report;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFPrintSetup;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import cl.eos.util.Utils;

import com.grupo.data.DataBaseConnection;
import com.grupo.util.EventEmisor;
import com.grupo.util.EventMsg;
import com.grupo.util.EventMsgListener;

public class HojaRutaExcel extends EventEmisor {

  private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
  private static HojaRutaExcel instance = null;
  private EventMsgListener listener;
  

  private class OTRegistro {
    String ruta;
    String articulo;
    String descripcion;
    Float cantidad;
    Float totalLinea;

    @Override
    public String toString() {
      return "[ruta=" + ruta + ", articulo=" + articulo + ", cantidad=" + cantidad
          + ", totalLinea=" + totalLinea + "]";
    }
  }


  /**
   * Query de todos las ventas de un día de numerados
   */
  private String query =
      "SELECT M.Ruta as ruta, D.Articulo as articulo, D.descripcion, D.Cantidad AS cantidad, D.TotalLinea AS totalLinea "
          + "FROM ENCABEZADOCUMENTO AS E, DETALLEDOCUMENTO AS D, MSOCLIENTES AS M "
          + "WHERE E.Id=D.Id AND  E.Rut = M.Rut AND E.codigo = M.codigo and E.tipo = '06' and E.vigente  = 1 AND D.Articulo in ( select articulo from articulosnumerados) and  E.Fecha = ?  "
          + "ORDER BY M.Ruta, D.Articulo";



  /**
   * Query de todos los nombres de ruta.
   */
  private String queryRutas =
      "select M.codigo, M.descripcion from MSOSTTABLAS as M where M.tabla='017'";
  /**
   * Query de todos los productos del sistema.
   */
  private String queryArticulos = "SELECT articulo, descripcion FROM ARTICULO ORDER BY articulo";


  private Connection con;
  private Map<String, String> rutas;
  private Map<String, String> articulos;
  private List<OTRegistro> registros;
  private Sheet sheet;
  private int rowIndex;



  private CellStyle numberFormat;


  public static void main(String[] args) throws Exception {
    HojaRutaExcel hRuta = new HojaRutaExcel();
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.YEAR, 2012);
    calendar.set(Calendar.MONTH, 11);
    calendar.set(Calendar.DAY_OF_MONTH, 14);
    hRuta.generarReporte(calendar.getTime());
  }


  private HojaRutaExcel() {
    con = DataBaseConnection.getInstance().getConnectionDB();
    rutas = new HashMap<String, String>();
    articulos = new HashMap<String, String>();

  }


  public static HojaRutaExcel getInstance() {
    if (instance == null) {
      instance = new HojaRutaExcel();
    }
    return instance;
  }

  public void generarReporte(Date fecha, EventMsgListener listener) throws Exception
  {
    this.listener = listener; 
    initialize();
    registros = obtenerVentasDia(fecha);
    Workbook wbook = elaborarReporte(fecha);
    if (wbook != null) {
      crearDocExcel(wbook, fecha);
    }
  }
  
  public void generarReporte(Date fecha) throws Exception {
    generarReporte(fecha, null);
  }

  /**
   * Inicializa el procesamiento estableciendo la lista de rutas y articulos existentes en el
   * sistema.
   * 
   * @throws SQLException
   */
  private void initialize() throws SQLException {

    notificar("Inicializando reporte");
    notificar("Extrayendo Rutas");
    PreparedStatement pstmt = con.prepareStatement(queryRutas);
    ResultSet result = pstmt.executeQuery();
    while (result.next()) {
      rutas.put(result.getString("codigo"), result.getString("descripcion"));
    }
    notificar("Extrayendo Artículos");
    pstmt = con.prepareStatement(queryArticulos);
    result = pstmt.executeQuery();
    while (result.next()) {
      articulos.put(result.getString("articulo"), result.getString("descripcion"));
    }
  }

  private List<OTRegistro> obtenerVentasDia(Date fecha) throws SQLException {
    notificar("Obteniendo ventas del día:" + fecha.toString());
    List<OTRegistro> lRegistros = new ArrayList<OTRegistro>();
    String queryVentas = String.format(query, fecha);
    PreparedStatement pstmt = con.prepareStatement(queryVentas);
    pstmt.setDate(1, new java.sql.Date(fecha.getTime()));
    ResultSet result = pstmt.executeQuery();
    while (result.next()) {
      
      OTRegistro registro = new OTRegistro();
      registro.ruta = result.getString("ruta");
      registro.articulo = result.getString("articulo");
      registro.descripcion = result.getString("descripcion");
      registro.cantidad = result.getFloat("cantidad");
      registro.totalLinea = result.getFloat("totalLinea");
      lRegistros.add(registro);
      notificar("Agregando registro:" + registro);
    }
    notificar("Se han agregado :" + lRegistros.size() + " registros.");
    return lRegistros;
  }


  private Workbook elaborarReporte(Date fecha) throws InvalidFormatException, IOException {
    

    notificar("Elaborando el reporte.");
    String articulo = "";
    String ruta = "";
    float sumaCantidadArticulo = 0;
    float sumaCantidadArticuloRuta = 0;
    float sumaTotalLineaArticulo = 0;
    float sumaTotalLineaArticuloRuta = 0;
    String numeros = "";

    if (registros == null || registros.isEmpty()) {
      // No se generaron datos.
      notificar("No hay registros a procesar, se aborta el proceso.");
      return null;
    }


    final Workbook wbook = new HSSFWorkbook();
    notificar("Creando planilla Excel");
    sheet = wbook.createSheet(sdf.format(fecha));


    numberFormat = wbook.createCellStyle();
    numberFormat.setDataFormat(wbook.createDataFormat().getFormat("#####0.00"));
    rowIndex = 0;
    agregarTituloReporte(fecha);
    numeros = "";
    ruta = null;
    articulo = null;

    for (OTRegistro registro : registros) {
      Logger.getLogger(HojaRutaExcel.class).info(registro);
      if (!registro.ruta.equals(ruta)) {

        if (ruta != null) {
          if (articulo != null) {
            numeros = ordenarNumeros(numeros);
            agregarArticulo(articulo, numeros, sumaCantidadArticulo, sumaTotalLineaArticulo);
            articulo = null;
          }
          agregarSumasRuta(sumaCantidadArticuloRuta, sumaTotalLineaArticuloRuta);
          notificar("Procesada ruta " + ruta);
        }
        ruta = registro.ruta;
        agregarTituloRuta(ruta);
        sumaCantidadArticulo = 0f;
        sumaTotalLineaArticulo = 0f;
        sumaCantidadArticuloRuta = 0f;
        sumaTotalLineaArticuloRuta = 0f;
        numeros = "";
      }

      if (!registro.articulo.equals(articulo)) {
        if (articulo != null) {
          notificar("Procesado artículo " + articulo);
          numeros = ordenarNumeros(numeros);
          agregarArticulo(articulo, numeros, sumaCantidadArticulo, sumaTotalLineaArticulo);
        }
        sumaCantidadArticulo = 0f;
        sumaTotalLineaArticulo = 0f;
        numeros = "";
        articulo = registro.articulo;
      }
      if (registro.articulo.equals(articulo)) {
        String desc = registro.descripcion;
        
        if(desc.indexOf("#[")!= -1)
        {
          int start = desc.indexOf("#[");
          int end  = desc.lastIndexOf("]");
          String nums = desc.substring(start + 2, end);
            numeros = numeros + (numeros.isEmpty() ? "" : "-") + nums;
          
        }
        else
        {
          int index = desc.indexOf("-");
          if (index != -1) {
            String nums = desc.substring(index);
            numeros = numeros + (numeros.isEmpty() ? "" : "-") + nums;
          }
        }
        sumaCantidadArticulo += registro.cantidad;
        sumaTotalLineaArticulo += registro.totalLinea;

        sumaCantidadArticuloRuta += registro.cantidad;
        sumaTotalLineaArticuloRuta += registro.totalLinea;
        
        if(registro.equals(registros.get(registros.size() - 1)))
        {
          if (articulo != null) {
            notificar("Procesado artículo " + articulo);
            numeros = ordenarNumeros(numeros);
            agregarArticulo(articulo, numeros, sumaCantidadArticulo, sumaTotalLineaArticulo);
          }
        }
      }
    }
    notificar("Procesamiento de última ruta");
    agregarSumasRuta(sumaCantidadArticuloRuta, sumaTotalLineaArticuloRuta);

    sheet.autoSizeColumn(0);
    sheet.autoSizeColumn(1);
    sheet.autoSizeColumn(2);
    sheet.autoSizeColumn(3);
    sheet.autoSizeColumn(4);


    return wbook;
  }


  private void agregarTituloReporte(Date fecha) {
    Row header = sheet.createRow(rowIndex++);
    header.setHeightInPoints(36.75f);
    Cell cell = header.createCell(0);
    cell.setCellValue("Hoja de Ruta");
    UtilReport.applySheetTitleStyle(cell);
    header = sheet.createRow(rowIndex++);
    header.setHeightInPoints(27);
    cell = header.createCell(0);
    UtilReport.applySheetSubTitleStyle(cell);
    sheet.addMergedRegion(new CellRangeAddress(header.getRowNum(), header.getRowNum(), 0, 4));
    cell.setCellValue(sdf.format(fecha));
    sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));
    sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 4));
  }


  private void agregarTituloRuta(String ruta) {
    Row header1 = sheet.createRow(rowIndex++);
    Cell cell1 = header1.createCell(0);
    UtilReport.applyTitleStyle(cell1);
    String nombreRtua = rutas.get(ruta);
    cell1.setCellValue(nombreRtua);
    cell1 = header1.createCell(1);
    UtilReport.applyTitleStyle(cell1);
    cell1 = header1.createCell(2);
    UtilReport.applyTitleStyle(cell1);
    cell1 = header1.createCell(3);
    UtilReport.applyTitleStyle(cell1);
    cell1 = header1.createCell(4);
    UtilReport.applyTitleStyle(cell1);
    sheet.addMergedRegion(new CellRangeAddress(header1.getRowNum(), header1.getRowNum(), 0, 4));

  }

  private void agregarSumasRuta(float sumaCantidadArticuloRuta, float sumaTotalLineaArticuloRuta) {

    Row header1 = sheet.createRow(rowIndex++);

    Cell cell = header1.createCell(0);
    cell.setCellValue("");
    cell = header1.createCell(1);
    cell.setCellValue("");
    cell = header1.createCell(2);
    cell.setCellValue("TOTAL");
    cell = header1.createCell(3);
    cell.setCellValue(sumaCantidadArticuloRuta);
    cell.setCellStyle(numberFormat);
    cell = header1.createCell(4);
    cell.setCellValue(sumaTotalLineaArticuloRuta);
    cell.setCellStyle(numberFormat);

  }

  private void agregarArticulo(String articulo, String numeros, float sumaCantidadArticulo,
      float sumaTotalLineaArticulo) {


    String nombreArticulo = articulos.get(articulo);
    Row header1 = sheet.createRow(rowIndex++);
    Cell cell = header1.createCell(0);
    cell.setCellValue(articulo);
    cell = header1.createCell(1);
    cell.setCellValue(nombreArticulo.trim());
    cell = header1.createCell(2);
    cell.setCellValue(numeros);
    cell = header1.createCell(3);
    cell.setCellValue(sumaCantidadArticulo);
    cell.setCellStyle(numberFormat);
    cell = header1.createCell(4);
    cell.setCellValue(sumaTotalLineaArticulo);
    cell.setCellStyle(numberFormat);

  }


  private void formatWorkbook(final Workbook wb) {
    Sheet spreadsheet = wb.getSheetAt(0);
    wb.setPrintArea(0, // sheet index
        0, // start column
        5, // end column
        0, // start row
        rowIndex // end row
    );
    // set paper size
    spreadsheet.getPrintSetup().setPaperSize(HSSFPrintSetup.LETTER_PAPERSIZE);
    spreadsheet.getPrintSetup().setLandscape(false);
    spreadsheet.setDisplayGridlines(true);
    spreadsheet.setPrintGridlines(true);

  }

  private void crearDocExcel(final Workbook wbWork, Date fecha) {
    notificar("Formateando planilla Excel.");
    formatWorkbook(wbWork);
    String path =
        Utils.getDefaultDirectory().toString() + File.separator + "HojaRuta-"
            + System.currentTimeMillis() + ".xls";

    FileOutputStream fileOut = null;
    try {
      File archivo = new File(path);
      fileOut = new FileOutputStream(archivo);
      wbWork.write(fileOut);
      fileOut.flush();
      Runtime.getRuntime().exec("cmd /c start \"\" \"" + archivo.getAbsolutePath() + "\"");
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "No se pudo grabar archivo " + path,
          "Problemas al grabar", JOptionPane.ERROR_MESSAGE);
    } finally {
      try {
        fileOut.close();
      } catch (final IOException e) {
        JOptionPane.showMessageDialog(null, "No se pudo cerrar archivo " + path,
            "Problemas al cerrar archivo", JOptionPane.ERROR_MESSAGE);
      }
    }
    notificar("Proceso finalizado.");
  }

  private String ordenarNumeros(String strNumeros) {

    String resultado = "";
    String[] numeros = strNumeros.trim().split("-");
    List<Integer> enteros = new ArrayList<Integer>();
    for (int n = 0; n < numeros.length; n++) {
      String numero = numeros[n].replaceAll("[^\\.0123456789]", "").trim();
      if (isNumeric(numero)) {
        enteros.add(Integer.valueOf(numero));
      }
    }
    Collections.sort(enteros);
    for (Integer entero : enteros) {
      resultado = resultado + ("".equals(resultado) ? "" : "-") + entero;
    }
    return resultado;
  }

  public static boolean isNumeric(String str) {
    return str.matches("-?\\d+(\\.\\d+)?"); // match a number with optional
  }


  private void notificar(String value)
  {
    if(listener != null)
    {
      listener.onMessage(new EventMsg(this, value));
    }
  }

}
