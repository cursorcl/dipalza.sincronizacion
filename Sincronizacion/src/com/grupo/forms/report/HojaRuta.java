package com.grupo.forms.report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.grupo.data.DataBaseConnection;
import com.grupo.util.EventEmisor;

public class HojaRuta extends EventEmisor {

  private static final String TOKEN = "#[";
  private static SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");

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
          + "FROM ENCABEZADOCUMENTO AS E, DETALLEDOCUMENTO AS D, MSOCLIENTES AS M, NUMERADOS AS N "
          + "WHERE E.Id=D.Id AND E.Rut = M.Rut AND N.Articulo = D.Articulo AND E.Fecha = convert(datetime, '%s')  "
          + "ORDER BY M.Ruta, D.Articulo";

  /**
   * Query de todos los nombres de ruta.
   */
  private String queryRutas = "select M.codigo, M.descripcion from MSOSTTABLAS as M where M.tabla='017'";
  /**
   * Query de todos los productos del sistema.
   */
  private String queryArticulos = "SELECT articulo, descripcion FROM ARTICULO ORDER BY articulo";

  String s =
      "SELECT distinct m.Ruta, q.Articulo, d.Descripcion, a.descripcion as original "
          + "FROM Numerados AS q, detalledocumento AS d, msoclientes AS m, encabezadocumento AS e, articulo as a "
          + "WHERE q.Articulo=d.articulo AND m.Rut=e.rut AND e.Id=d.id and a.articulo = q.articulo and e.fecha = convert(datetime, '%s')  "
          + "ORDER BY m.Ruta, q.Articulo";


  private Connection con;
  private Map<String, String> rutas;
  private Map<String, String> articulos;
  private List<OTRegistro> registros;


  public static void main(String[] args) throws Exception {
      HojaRuta hRuta =  new HojaRuta();
      Date fecha =  new Date(2014,5,5);
      hRuta.generarReport(fecha);
  }
  

  public HojaRuta() {
    con = DataBaseConnection.getInstance().getConnectionDB();
    rutas = new HashMap<String, String>();
    articulos = new HashMap<String, String>();

  }


  public void generarReport(Date fecha) throws Exception {
    initialize();
    registros = obtenerVentasDia(fecha);
    elaborarReporte(fecha);
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
    String queryVentas = String.format(query, sdf.format(fecha));
    PreparedStatement pstmt = con.prepareStatement(queryVentas);
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


  private void elaborarReporte(Date fecha) {
    String articulo = "";
    String ruta = "";
    float sumaCantidadArticulo = 0;
    float sumaCantidadArticuloRuta = 0;
    float sumaTotalLineaArticulo = 0;
    float sumaTotalLineaArticuloRuta = 0;
    String numeros = "";
    
    if(registros == null || registros.isEmpty())
    {
      // No se generaron datos.
      return;
    }
    
    agregarEncabezado(fecha);
    numeros = "";
    ruta = registros.get(0).ruta;
    articulo = registros.get(0).articulo;
    agregarTituloRuta(ruta);
    for (OTRegistro registro : registros) {
      if (!registro.ruta.equals(ruta)) {
        agregarTituloRuta(ruta);
        agregarSumasRuta(ruta, sumaCantidadArticuloRuta, sumaTotalLineaArticuloRuta);
        sumaTotalLineaArticuloRuta = 0f;
        sumaCantidadArticuloRuta = 0f;
        ruta = registro.ruta;
        sumaCantidadArticulo = 0f;
        sumaTotalLineaArticulo = 0f;
        numeros = "";
        articulo = registro.articulo;
      }
      if (registro.articulo.equals(articulo)) {
        String[] partes = registro.descripcion.split("#");
        if (partes.length > 0) {
          int beginIndex = partes[1].indexOf("[");
          int endIndex = partes[1].indexOf("]");
          String nums = partes[1].substring(beginIndex, endIndex);
          numeros = numeros + (numeros.isEmpty() ? "" : "-") + nums;
        }
        sumaCantidadArticulo = registro.cantidad;
        sumaTotalLineaArticulo = registro.totalLinea;
        sumaTotalLineaArticuloRuta = registro.cantidad;
        sumaCantidadArticuloRuta = registro.totalLinea;
      } else {
        agregarArticulo(registro.articulo, numeros, sumaCantidadArticulo, sumaTotalLineaArticulo);
        sumaCantidadArticulo = 0f;
        sumaTotalLineaArticulo = 0f;
        numeros = "";
        articulo = registro.articulo;
      }
    }
  }


  private void agregarEncabezado(Date fecha) {
    System.out.println("Reporte del día" + fecha);
  }


  private void agregarTituloRuta(String ruta) {
    String nombreRtua = rutas.get(ruta);
    System.out.println(nombreRtua);
  }

  private void agregarSumasRuta(String ruta, float sumaCantidadArticuloRuta,
      float sumaTotalLineaArticuloRuta) {
    System.out.println(String.format("%4.2f, %4.2f", sumaCantidadArticuloRuta,
        sumaTotalLineaArticuloRuta));
  }

  private void agregarArticulo(String articulo, String numeros, float sumaCantidadArticulo,
      float sumaTotalLineaArticulo) {

    String nombreArticulo = articulos.get(articulo);
    System.out.println(String.format("%s %s %4.2f, %4.2f", nombreArticulo, numeros,
        sumaCantidadArticulo, sumaTotalLineaArticulo));

  }


}
