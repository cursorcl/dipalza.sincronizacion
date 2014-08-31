package com.grupo.constantes;

public class Constantes
{
  public static String ENCABEZADO_VENTAS_DB = "eVentas";
  public static String DATOS_INICIALIZACION = "datosIncializacion";
  public static String CLIENTES_DB = "clientes";
  public static String ITEMES_VENTA_DB = "iVentas";
  public static String PRODUCTOS_DB = "productos";
  public static String CLIENTES_ELI = "eliminar";
  public static String CLIENTES_MOD = "modificar";

  public static byte CLIENTE_NUEVO = 1;
  public static byte CLIENTE_MODIFICADO = 2;
  public static final int LOCATION = 0;
  public static final String TBL_MSOCLIENTES = "msoclientes";
  public static final String TBL_ARTICULOS = "articulo";
  public static final String TBL_ARTXLOCAL = "artxlocal";
  public static final String TBL_PRECIOS = "precios";
  public static final String TBL_CORRELATIVO_NUMERADOS = "correlativonumerados";
  public static final String TBL_TNUMERADOS = "numerados";
  public static final String TBL_ENCABEZADO = "encabezadocumento";
  public static final String TBL_DETALLEDOCUMENTO = "detalledocumento";
  public static final String TBL_TOTAL_DOCUMENTO = "totaldocumento";
  public static final String TBL_MSOSTTABLES = "msosttablas";
  public static final String TBL_FOLIOS = "folios";
  public static final String TBL_MSOVENDEDOR = "msovendedor";
  public static final String TBL_CTADOCTO = "ctadocto";
  public static final String TBL_DATOSCLIENTE = "datoscliente";
  public static final String TBL_RUTA_DIARIA = "reporterutadiaria";
  public static final String[] STR_MODO_PAGO = { "CONTADO", "CREDITO 7", "CREDITO 15", "CHEQUE V. 30", "CHEQUE T. 15", "CHEQUE T. 20", "CHEQUE T. 30" };
  public static final String[] COD_MODO_PAGO = { "001", "002", "003", "004", "005", "006", "007" };
  public static final int[] DIA_MODO_PAGO = { 0, 7, 15, 30, 15, 20, 30 };
  public static final String SERVER_IP_DEFAULT = "192.168.0.2";
  public static final float IVA_DEFAULT = 19.0F;
  public static final float ILA_DEFAULT = 14.0F;
}
