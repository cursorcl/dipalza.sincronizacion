package com.grupo.forms.report;

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

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.grupo.data.DataBaseConnection;
import com.grupo.util.EventEmisor;

public class HojaRuta2003 extends EventEmisor {

  private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

  private class OTRegistro {
    String ruta;
    String articulo;
    String descripcion;
    Float cantidad;
    Float totalLinea;
  }


  /**
   * Query de todos las ventas de un día de numerados
   */
  private String query =
      "SELECT M.Ruta as ruta, D.Articulo as articulo, D.descripcion, D.Cantidad AS cantidad, D.TotalLinea AS totalLinea "
          + "FROM ENCABEZADOCUMENTO AS E, DETALLEDOCUMENTO AS D, MSOCLIENTES AS M "
          + "WHERE E.Id=D.Id AND  E.Rut = M.Rut AND D.Articulo in ( select articulo from numerados) and  E.Fecha = ?  "
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


  public static void main(String[] args) throws Exception {
    HojaRuta2003 hRuta = new HojaRuta2003();
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.YEAR, 2012);
    calendar.set(Calendar.MONTH, 11);
    calendar.set(Calendar.DAY_OF_MONTH, 14);
    hRuta.generarReport(calendar.getTime());
  }


  public HojaRuta2003() {
    con = DataBaseConnection.getInstance().getConnectionDB();
    rutas = new HashMap<String, String>();
    articulos = new HashMap<String, String>();

  }


  public void generarReport(Date fecha) throws Exception {
    initialize();
    registros = obtenerVentasDia(fecha);
    Workbook wbook = elaborarReporte(fecha);
    if(wbook != null)
    {
      //UtilReport.crearExcel(wbook, "HojaRuta-" + sdf.format(fecha) + ".xls");
      UtilReport.crearExcel(wbook, "HojaRuta.xls");
    }
  }

  /**
   * Inicializa el procesamiento estableciendo la lista de rutas y articulos existentes en el
   * sistema.
   * 
   * @throws SQLException
   */
  private void initialize() throws SQLException {

    PreparedStatement pstmt = con.prepareStatement(queryRutas);
    ResultSet result = pstmt.executeQuery();
    while (result.next()) {
      rutas.put(result.getString("codigo"), result.getString("descripcion"));
    }
    pstmt = con.prepareStatement(queryArticulos);
    result = pstmt.executeQuery();
    while (result.next()) {
      articulos.put(result.getString("articulo"), result.getString("descripcion"));
    }
  }

  private List<OTRegistro> obtenerVentasDia(Date fecha) throws SQLException {
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
    }
    return lRegistros;
  }


  private Workbook elaborarReporte(Date fecha) {
    String articulo = "";
    String ruta = "";
    float sumaCantidadArticulo = 0;
    float sumaCantidadArticuloRuta = 0;
    float sumaTotalLineaArticulo = 0;
    float sumaTotalLineaArticuloRuta = 0;
    String numeros = "";

    if (registros == null || registros.isEmpty()) {
      // No se generaron datos.
      return null;
    }

    final Workbook wbook = new HSSFWorkbook();
    sheet = wbook.createSheet(sdf.format(fecha));
    rowIndex = 0;
    agregarTituloReporte(fecha);
    numeros = "";
    ruta = registros.get(0).ruta;
    articulo = registros.get(0).articulo;
    agregarTituloRuta(ruta);
    for (OTRegistro registro : registros) {
      if (!registro.ruta.equals(ruta)) {
        agregarSumasRuta(sumaCantidadArticuloRuta, sumaTotalLineaArticuloRuta);
        agregarTituloRuta(ruta);
        sumaTotalLineaArticuloRuta = 0f;
        sumaCantidadArticuloRuta = 0f;
        ruta = registro.ruta;
        sumaCantidadArticulo = 0f;
        sumaTotalLineaArticulo = 0f;
        numeros = "";
        articulo = registro.articulo;
      }
      if (registro.articulo.equals(articulo)) {
        String desc = registro.descripcion;
        int index = desc.indexOf("-");
        if (index != -1) {
          String nums = desc.substring(index);
          numeros = numeros + (numeros.isEmpty() ? "" : "-") + nums;
        }
        sumaCantidadArticulo = registro.cantidad;
        sumaTotalLineaArticulo = registro.totalLinea;
        sumaTotalLineaArticuloRuta = registro.cantidad;
        sumaCantidadArticuloRuta = registro.totalLinea;
      } else {
        numeros = ordenarNumeros(numeros);
        agregarArticulo(registro.articulo, numeros, sumaCantidadArticulo, sumaTotalLineaArticulo);
        sumaCantidadArticulo = 0f;
        sumaTotalLineaArticulo = 0f;
        numeros = "";
        articulo = registro.articulo;
      }
    }
    return wbook;
  }

  private void agregarTituloReporte(Date fecha) {
    Row header = sheet.createRow(rowIndex++);
    header.setHeightInPoints(sheet.getDefaultRowHeightInPoints());
    Cell cell = header.createCell(0);
    cell.setCellValue("Hoja de Ruta");
    UtilReport.applySheetTitleStyle(cell);
    header = sheet.createRow(rowIndex++);
    header.setHeightInPoints(sheet.getDefaultRowHeightInPoints());
    cell = header.createCell(0);
    UtilReport.applySheetSubTitleStyle(cell);
    cell.setCellValue(sdf.format(fecha));
    
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



  private void agregarTituloRuta(String ruta) {
    Row header1 = sheet.createRow(rowIndex++);
    Cell cell1 = header1.createCell(0);
    UtilReport.applyTitleStyle(cell1);
    String nombreRtua = rutas.get(ruta);
    cell1.setCellValue(nombreRtua);
  }

  private void agregarSumasRuta( float sumaCantidadArticuloRuta,
      float sumaTotalLineaArticuloRuta) {
    
    Row header1 = sheet.createRow(rowIndex++);
    
    Cell cell = header1.createCell(0);
    cell.setCellValue("");
    cell = header1.createCell(1);
    cell.setCellValue("");
    cell = header1.createCell(2);
    cell.setCellValue("TOTAL");
    cell = header1.createCell(3);
    cell.setCellValue(sumaCantidadArticuloRuta);
    cell = header1.createCell(4);
    cell.setCellValue(sumaTotalLineaArticuloRuta);
    
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
    cell = header1.createCell(4);
    cell.setCellValue(sumaTotalLineaArticulo);

  }



}
