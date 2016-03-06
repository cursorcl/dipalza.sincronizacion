package com.grupo.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.grupo.basedatos.EncabezadoVenta;
import com.grupo.basedatos.ItemVenta;
import com.grupo.basedatos.Producto;
import com.grupo.forms.ResultDetalle;
import com.grupo.forms.SincronizacionMMI;
import com.grupo.utilitarios.FechaFormateada;
import com.grupo.utilitarios.FormatoNumeros;

public class FacturaSQL {
  static Logger log = Logger.getLogger(FacturaSQL.class);
  public static final int NRO_FILAS = 25;
  public static final float paridad = 1.0F;
  public static final String TIPOID = "06";
  public static final String IDLOCAL = "000";
  public static final String ID_CONDICION_VENTA = "009";

  private Connection con = null;

  public FacturaSQL() {
    getConnectionDB();
  }

  public Connection getConnectionDB() {
    this.con = DataBaseConnection.getInstance().getConnectionDB();
    return this.con;
  }

  public Producto getDatosProducto(String articulo) {
    Producto p = null;
    short s = 0;

    String sqlINVDETALLEPARTES =
        "select sum(cantidad) as stock from invdetallepartes  i, INVENCABEZAPARTES e where articulo = ?   and i.Id =  e.Id and i.Tipoid = 17 and i.Local ='000'";
    String sqlINVDETALLEPARTES_MINUS =
        "select sum(cantidad) as stock from invdetallepartes  i, INVENCABEZAPARTES e where articulo = ?   and i.Id =  e.Id  and i.Tipoid = 18 and i.Local ='000'";
    String sqlDETALLEDOCUMENTOCredito =
        "select sum(cantidad) as stock from detalledocumento  d, encabezadocumento e where d.articulo = ? and d.local = '000'  and d.tipoid = '09' and d.id = e.id  and e.vigente = 1";
    String sqlDETALLEDOCUMENTODebito =
        "select sum(cantidad) as stock from detalledocumento  d, encabezadocumento e where d.articulo = ? and d.local = '000'  and d.tipoid = '06' and d.id = e.id  and e.vigente = 1 ";

    Properties props = SincronizacionMMI.PROPERTIES;
    String lista = props.getProperty("lista", "000");
    String strSelect =
        "Select a.descripcion, p.ventaneto, a.costo, a.porcIla from articulo as a, precios as p where a.articulo = ? and p.articulo = a.articulo and p.codigolista ='"
            + lista + "'";

    try {

      PreparedStatement pstmt0 = this.con.prepareStatement(sqlINVDETALLEPARTES);
      pstmt0.setString(1, articulo);
      ResultSet res0 = pstmt0.executeQuery();
      float stock = 0f;
      if (res0.next()) {
        stock = res0.getFloat("stock");
      }
      res0.close();
      pstmt0.close();

      PreparedStatement pstmt1 = this.con.prepareStatement(sqlINVDETALLEPARTES_MINUS);
      pstmt1.setString(1, articulo);
      ResultSet res1 = pstmt1.executeQuery();
      if (res1.next()) {
        stock = stock - res1.getFloat("stock");
      }
      res1.close();
      pstmt1.close();

      
      PreparedStatement pstmt2 = this.con.prepareStatement(sqlDETALLEDOCUMENTOCredito);
      pstmt2.setString(1, articulo);
      ResultSet res2 = pstmt2.executeQuery();
      if (res2.next()) {
        stock = stock + res2.getFloat("stock");
      }
      res2.close();
      pstmt2.close();

      PreparedStatement pstmt3 = this.con.prepareStatement(sqlDETALLEDOCUMENTODebito);
      pstmt3.setString(1, articulo);
      ResultSet res3 = pstmt3.executeQuery();
      if (res3.next()) {
        stock = stock - res3.getFloat("stock");
      }
      res3.close();
      pstmt3.close();

      if (stock < 0f)
        stock = 0f;

      PreparedStatement pstmt4 = this.con.prepareStatement(strSelect);
      pstmt4.setString(1, articulo);
      ResultSet res4 = pstmt4.executeQuery();
      if (res4.next())
      {
        p =
            new Producto(articulo, s, res4.getString("descripcion"), stock,
                res4.getFloat("ventaneto"), "", "", res4.getFloat("costo"), res4.getFloat("porcIla"));
      }
      res4.close();
      pstmt4.close();
      
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return p;
  }

  public String getId() {
    String result = null;
    String strUpdateParameter = "update PARAMETROS set FolioDocumento=?";
    String strSelect = "Select max(id) from encabezadocumento";
    try {
      PreparedStatement pstmt = this.con.prepareStatement(strSelect);
      ResultSet res = pstmt.executeQuery();
      Integer numero = new Integer(1);
      while (res.next()) {
        try {
          numero = Integer.valueOf(Integer.valueOf(res.getString(1)).intValue());
        } catch (NumberFormatException ex) {
          numero = new Integer(1);
        }
        result =
            FormatoNumeros.putZeroesAtBegin(
                (numero = Integer.valueOf(numero.intValue() + 1)).intValue(), 10);
      }
      pstmt = this.con.prepareStatement(strUpdateParameter);
      pstmt.setString(1, result);
      pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }

  public String getNumero() {
    String result = null;
    String strSelect = "Select max(numero) from encabezadocumento where tipo = '06'";
    try {
      PreparedStatement pstmt = this.con.prepareStatement(strSelect);
      ResultSet res = pstmt.executeQuery();
      while (res.next()) {
        Integer numero = new Integer(1);
        try {
          numero = Integer.valueOf(Integer.valueOf(res.getString(1)).intValue());
        } catch (NumberFormatException ex) {
          numero = new Integer(1);
        }
        result =
            FormatoNumeros.putZeroesAtBegin(
                (numero = Integer.valueOf(numero.intValue() + 1)).intValue(), 7);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }

  public String insertEncabezado(EncabezadoVenta pEncabezado) {
    String result = getId();
    if (result != null) {
      try {
        PreparedStatement pstmt =
            this.con
                .prepareStatement("insert into encabezadocumento (fecha, vence, afectoexento, rut, local, id, tipo, numero, codigo) values  (?, ?, ?, ?, ?, ?, ?, ?, ?)");

        // Timestamp dFecha = new Timestamp(pEncabezado.getFecha().getTime());
        // Timestamp dVence = new Timestamp(addDay(pEncabezado).getTime());
        pstmt.setDate(1, new Date(pEncabezado.getFecha().getTime()));
        pstmt.setDate(2, new Date(addDay(pEncabezado).getTime()));

        // pstmt.setTimestamp(1, dFecha);
        // pstmt.setTimestamp(2, dVence);

        pstmt.setString(3, "A");
        pstmt.setString(4, pEncabezado.getRut());
        pstmt.setString(5, "000");
        pstmt.setString(6, result);
        pstmt.setString(7, "06");
        pstmt.setString(8, getNumero());
        pstmt.setString(9, pEncabezado.getCodigoCliente() + " ");
        pstmt.executeUpdate();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return result;
  }

  private int getNumDiasCondicionVenta(byte condicionVenta) {
    int numDias = 0;
    try {
      PreparedStatement pstmt =
          this.con.prepareStatement("select valor from msosttablas where tabla = ? and codigo = ?");
      pstmt.setString(1, "009");
      pstmt.setString(2, FormatoNumeros.putZeroesAtBegin(condicionVenta, 3));
      ResultSet r = pstmt.executeQuery();
      if (r.next())
        numDias = r.getInt("valor");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return numDias;
  }

  public ResultDetalle insertDetalleVenta(ItemVenta pVenta, String id, int fila) {
    ResultDetalle result = new ResultDetalle(0.0F, 0, 0.0F);

    boolean procesa = true;
    boolean isNumerated = false;

    Producto pr = null;
    String articulo = null;

    int n = -1;

    String nombreProducto = null;

    float venta = pVenta.getCantidad();
    float ventNeto = pVenta.getNeto();
    try {
      articulo = pVenta.getArticulo();
      log.info("Procesando articulo:" + articulo);
      pr = getDatosProducto(articulo);

      if (pr != null) {
        String numeros = "";
        nombreProducto = pr.getNombre();
        int nVenta = (int) pVenta.getCantidad();
        int cantidadVenta = nVenta;

        // determinar si articulo es numerado.
        PreparedStatement stmNumerado =
            this.con.prepareStatement("select * from articulosnumerados where  articulo = ?");
        stmNumerado.setString(1, articulo);
        ResultSet r = stmNumerado.executeQuery();
        isNumerated = r.next();
        r.close();
        stmNumerado.close();

        if (isNumerated) {

          numeros = "";
          int m = 0;
          venta = 0.0f;
          int[] nV = new int[nVenta];
          Arrays.fill(nV, -1);


          stmNumerado = this.con.prepareStatement("select * from numerados where articulo = ?");
          stmNumerado.setMaxRows(nVenta);
          stmNumerado.setString(1, articulo);
          r = stmNumerado.executeQuery();
          while (r.next()) {
            nV[m] = r.getInt("correlativo");
            if (nV[m] == -1) {
              break;
            }
            n = r.getInt("numero");
            numeros = numeros + (numeros.isEmpty() ? "" : "-") + n;
            venta += r.getFloat("peso");
            ventNeto = venta * pr.getPrecio();
            ventNeto *= (1.0F - pVenta.getDescuento() / 100.0F);

            // insert into registroNumerados values(articulo,
            ++m;
            --nVenta;
          }
          r.close();
          stmNumerado.close();

          for (n = 0; n < nV.length; ++n) {
            if (nV[n] != -1) {
              stmNumerado =
                  this.con
                      .prepareStatement("delete from numerados where correlativo = ? and articulo = ?");
              stmNumerado.setInt(1, nV[n]);
              stmNumerado.setString(2, articulo);
              stmNumerado.execute();
              stmNumerado.close();
            }
          }
        }
        if (!isNumerated) {
          float difStock = pr.getStock() - venta;
          if (pr.getStock() <= 0.0F) {
            procesa = false;
            result.setFaltante(venta);
            result.setResult(2);
          } else {
            if (difStock < 0.0F) {
              result.setFaltante(venta - pr.getStock());
              venta = pr.getStock();
              ventNeto = venta * pr.getPrecio() * (1.0F - pVenta.getDescuento() / 100.0F);
              result.setResult(1);
            }
            procesa = true;
          }
        } else {
          procesa = true;
          result.setFaltante(nVenta);
          procesa = nVenta != cantidadVenta;
          if ((nVenta > 0) && (nVenta < cantidadVenta)) {
            result.setResult(1);
          } else if (!procesa) {
            result.setResult(2);
            procesa = false;
          }
        }

        if (procesa) {

          rebajaVenta(pVenta.getArticulo(), venta);
          PreparedStatement pstmt =
              this.con
                  .prepareStatement("insert into detalledocumento (precioventa, totallinea, paridad, preciocosto, cantidad, id, linea, tipoid, local, articulo, descripcion, variacion) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
          pstmt.setFloat(1, pr.getPrecio());
          pstmt.setFloat(2, ventNeto);
          pstmt.setFloat(3, 1.0F);
          pstmt.setFloat(4, pr.getCosto());
          pstmt.setFloat(5, venta);
          pstmt.setString(6, id);
          pstmt.setString(7, FormatoNumeros.putZeroesAtBegin(fila, 3));
          pstmt.setString(8, "06");
          pstmt.setString(9, "000");
          pstmt.setString(10, articulo);
          if (!numeros.isEmpty()) {
            nombreProducto = String.format("%s #[%s]", nombreProducto, numeros);
          }
          pstmt.setString(11, nombreProducto);
          pstmt.setFloat(12, -1.0F * pVenta.getDescuento());
          pstmt.executeUpdate();
          result.setTotal(ventNeto);
        }
      } else {
        log.error(String.format("El artículo %s no existe en la BD", articulo));
      }
    } catch (SQLException e) {
      e.printStackTrace();
      log.error("Un error ha ocurrido al procesar " + articulo);
      result.setResult(3);
    }
    return result;
  }

  public boolean insertConduccion(ItemVenta pVenta, String id, int fila) {
    boolean result = false;
    try {
      PreparedStatement pstmt =
          this.con
              .prepareStatement("insert into detalledocumento (precioventa, totallinea, paridad, preciocosto, cantidad, id, linea, tipoid, local, articulo, descripcion, variacion) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
      pstmt.setFloat(1, pVenta.getNeto());
      pstmt.setFloat(2, pVenta.getNeto());
      pstmt.setFloat(3, 1.0F);
      pstmt.setFloat(4, pVenta.getNeto());
      pstmt.setFloat(5, 1.0F);
      pstmt.setString(6, id);
      pstmt.setString(7, FormatoNumeros.putZeroesAtBegin(fila, 3));
      pstmt.setString(8, "06");
      pstmt.setString(9, "000");
      pstmt.setString(10, "000");
      pstmt.setString(11, pVenta.getArticulo());
      pstmt.setFloat(12, 0.0F);
      pstmt.executeUpdate();
      pstmt.close();
      result = true;
    } catch (SQLException e) {
      result = false;
    }
    return result;
  }

  public boolean insertTotalDocumento(String id, EncabezadoVenta e, float ila) {
    boolean result = false;
    float totalIva = e.getPorcentajeIva() / 100.0F * e.getNeto();
    try {
      PreparedStatement pstmt =
          this.con
              .prepareStatement("insert into totaldocumento (totaldetalle, totaliva, totalila, totalneto, total, id, tipoid) values (?, ?, ?, ?, ?, ?, ?)");
      pstmt.setFloat(1, e.getNeto());
      pstmt.setFloat(2, totalIva);
      pstmt.setFloat(3, ila);
      pstmt.setFloat(4, e.getNeto());
      pstmt.setFloat(5, e.getNeto() + totalIva + ila);
      pstmt.setString(6, id);
      pstmt.setString(7, "06");
      pstmt.executeUpdate();
      result = true;
    } catch (SQLException e1) {
      result = false;

      e1.printStackTrace();
    }

    return result;
  }

  public boolean insertTotalDocumento(String id, float total, float porIva, float ila) {
    boolean result = false;
    float totalIva = porIva / 100.0F * total;
    try {
      PreparedStatement pstmt =
          this.con
              .prepareStatement("insert into totaldocumento (totaldetalle, totaliva, totalila, totalneto, total, id, tipoid) values (?, ?, ?, ?, ?, ?, ?)");
      pstmt.setFloat(1, total);
      pstmt.setFloat(2, totalIva);
      pstmt.setFloat(3, ila);
      pstmt.setFloat(4, total);
      pstmt.setFloat(5, total + totalIva + ila);
      pstmt.setString(6, id);
      pstmt.setString(7, "06");
      pstmt.executeUpdate();
      result = true;
    } catch (SQLException e1) {
      result = false;

      e1.printStackTrace();
    }

    return result;
  }

  public boolean insertCtaDcto(String factura, EncabezadoVenta e, float neto, float ila) {
    boolean result = false;
    float comision = 0.0F;
    float iva = e.getPorcentajeIva() / 100.0F * neto;
    float bruto = neto + iva;
    try {
      PreparedStatement pstmtSel =
          this.con.prepareStatement("select comision from msovendedor where codigo = ?");
      pstmtSel.setString(1, e.getVendedor());
      ResultSet r = pstmtSel.executeQuery();
      if (r.next()) {
        comision = r.getFloat("comision");
      }
      r.close();
      pstmtSel.close();

      PreparedStatement pstmtIns =
          this.con
              .prepareStatement("insert into ctadocto (rut_cliente, fecha_vencimiento, comision, fecha_ingreso, vendedor, valor_bruto, valor_iva, valor_neto, tipo, numero, codigo_cliente, local_venta, valor_ila) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
      // Timestamp dVencimiento = new Timestamp(addDay(e).getTime());
      // Timestamp dIngreso = new Timestamp(e.getFecha().getTime());
      pstmtIns.setString(1, e.getRut());
      // pstmtIns.setTimestamp(2, dVencimiento);
      pstmtIns.setDate(2, new Date(addDay(e).getTime()));
      pstmtIns.setFloat(3, comision);
      // pstmtIns.setTimestamp(4, dIngreso);
      pstmtIns.setDate(4, new Date(e.getFecha().getTime()));
      pstmtIns.setString(5, e.getVendedor());
      pstmtIns.setFloat(6, bruto);
      pstmtIns.setFloat(7, iva);
      pstmtIns.setFloat(8, neto);
      pstmtIns.setString(9, "06");
      pstmtIns.setString(10, factura);
      pstmtIns.setString(11, e.getCodigoCliente());
      pstmtIns.setString(12, "000");
      pstmtIns.setFloat(13, ila);
      pstmtIns.executeUpdate();
      pstmtIns.close();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }

    return result;
  }

  public boolean insertDatosCliente(String rut, String id, String condicion, int dias, String codigo) {
    boolean result = false;
    try {

      Properties props = SincronizacionMMI.PROPERTIES;
      String lista = props.getProperty("lista", "000");

      PreparedStatement pstmt =
          this.con
              .prepareStatement("SELECT m.telefono, m.ruta, m.ciudad, m.comuna, m.razon, m.vendedor, v.comision, m.giro, m.vendedor as cobrador, m.direccion FROM msovendedor v, msoclientes m where v.codigo = m.Vendedor and m.rut = ? and m.codigo=?");
      pstmt.setString(1, rut);
      pstmt.setString(2, codigo);

      ResultSet r = pstmt.executeQuery();
      if (r.next()) {
        PreparedStatement pstmtIns =
            this.con
                .prepareStatement("insert into datoscliente (Telefono, Despacho, ComisionCobrador, Ruta, TipoVenta, Transporte, Ciudad, Comuna, Razon, Lista, Dias, CondicionVenta, tipoid, Vendedor, ComisionVendedor, Giro, Cobrador, Direccion, Id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        pstmtIns.clearParameters();
        pstmtIns.setString(1, r.getString("telefono"));
        pstmtIns.setString(2, "");
        pstmtIns.setFloat(3, 0.0F);
        pstmtIns.setString(4, r.getString("ruta"));
        pstmtIns.setString(5, "");
        pstmtIns.setString(6, "");
        pstmtIns.setString(7, r.getString("ciudad"));
        pstmtIns.setString(8, r.getString("comuna"));
        pstmtIns.setString(9, r.getString("razon"));
        pstmtIns.setString(10, lista);
        pstmtIns.setInt(11, dias);
        pstmtIns.setString(12, condicion);
        pstmtIns.setString(13, "06");
        pstmtIns.setString(14, r.getString("vendedor"));
        pstmtIns.setFloat(15, r.getFloat("comision"));
        pstmtIns.setString(16, r.getString("giro"));
        pstmtIns.setString(17, r.getString("cobrador"));
        pstmtIns.setString(18, r.getString("direccion"));
        pstmtIns.setString(19, id);
        pstmtIns.executeUpdate();
        pstmtIns.close();
      }
      r.close();
      pstmt.close();
    } catch (SQLException e1) {
      e1.printStackTrace();
    }

    return result;
  }

  public boolean insertFolios(String nroFactura) {
    boolean result = false;
    try {
      PreparedStatement pstmt =
          this.con.prepareStatement("INSERT INTO folios (NUMERO, TIPO) VALUES (? , ?)");
      pstmt.setString(1, nroFactura);
      pstmt.setString(2, "06");
      result = pstmt.executeUpdate() == 1;
    } catch (SQLException e1) {
      result = false;
      e1.printStackTrace();
    }
    return result;
  }

  public String getNumeroFactura(String id) {
    String nro = null;
    try {
      PreparedStatement pstmt =
          this.con.prepareStatement("select numero from encabezadocumento where id = ?");
      pstmt.setString(1, id);
      ResultSet r = pstmt.executeQuery();
      if (r.next())
        nro = r.getString("numero");
    } catch (SQLException e1) {
      nro = null;
      e1.printStackTrace();
    }

    return nro;
  }

  private void rebajaVenta(String articulo, float rebajaReal) throws SQLException {
    log.info(String.format("Actualizando stock articulo %s, rebaja %f", articulo, rebajaReal));
    PreparedStatement pstmt =
        this.con.prepareStatement("update artxlocal set stock = stock - ? where articulo = ?");
    pstmt.setFloat(1, rebajaReal);
    pstmt.setString(2, articulo);
    pstmt.executeUpdate();
  }

  private FechaFormateada addDay(EncabezadoVenta pEncabezado) {
    int numDiasCondicionVenta = getNumDiasCondicionVenta(pEncabezado.getCondicionVenta());
    Calendar c = Calendar.getInstance();
    c.setTime(pEncabezado.getFecha());
    c.add(5, numDiasCondicionVenta);
    FechaFormateada fecha = new FechaFormateada(c.getTime().getTime());
    return fecha;
  }

  public String getRuta(String rut) {
    String SQL_SEL_DATOS_CLIENTE = "SELECT m.ruta FROM msoclientes m where m.rut = ?";
    String ruta = "";
    try {
      PreparedStatement pstmt = this.con.prepareStatement(SQL_SEL_DATOS_CLIENTE);
      pstmt.setString(1, rut);
      ResultSet r = pstmt.executeQuery();
      if (r.next()) {
        ruta = r.getString(1);
      }
      r.close();
      pstmt.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return ruta;
  }

  public Producto getConduccion(String rut) {
    String SQL_SEL_DATOS_CLIENTE = "SELECT m.ruta FROM msoclientes m where m.rut = ?";

    String ruta = "";
    Producto p = null;
    short s = 0;
    try {
      PreparedStatement pstmt = this.con.prepareStatement(SQL_SEL_DATOS_CLIENTE);
      pstmt.setString(1, rut);
      ResultSet r = pstmt.executeQuery();
      if (r.next()) {
        ruta = r.getString(1);
      }
      r.close();
      pstmt.close();

      if (ruta.equals("001"))
        ruta = "9999";
      else if (ruta.equals("003"))
        ruta = "9998";
      else {
        ruta = "9997";
      }
      String strSelect =
          "Select a.codigo, a.descripcion, a.valor from msosttablas as a where a.tabla = '015' and a.codigo = ?";

      pstmt = this.con.prepareStatement(strSelect);
      pstmt.setString(1, ruta);
      ResultSet res = pstmt.executeQuery();
      if (res.next()) {
        String codigo = res.getString("codigo");
        String descripcion = res.getString("descripcion");
        float valor = res.getFloat("valor");
        p = new Producto(codigo, s, descripcion, 0.0F, valor, "", "", valor, 0.0F);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return p;
  }

  public float insertIla(String nroFactura, String id) {
    float ila = 0.0F;
    try {
      PreparedStatement pstmt =
          this.con
              .prepareStatement("SELECT A.CodigoIla, A.PorcIla, D.TipoId, sum([TotalLinea]*[PorcIla]/100) AS Valor FROM ARTICULO A, DETALLEDOCUMENTO D WHERE  A.Articulo = D.Articulo AND D.Id = ? and A.porcila > 0 Group by A.CodigoIla, A.PorcIla,D.TipoId");
      pstmt.setString(1, id);
      ResultSet r = pstmt.executeQuery();
      while (r.next()) {
        PreparedStatement pstmtInsert =
            this.con.prepareStatement("insert into MSOSTVENTASILA values (?, ?, ?, ?, ?, '', 0)");
        pstmtInsert.clearParameters();
        float valor = r.getFloat("Valor");
        ila += valor;
        pstmtInsert.setFloat(1, valor);
        pstmtInsert.setString(2, r.getString("TipoId"));
        pstmtInsert.setString(3, r.getString("CodigoIla"));
        pstmtInsert.setInt(4, r.getInt("PorcIla"));
        pstmtInsert.setString(5, nroFactura);
        pstmtInsert.executeUpdate();
        pstmtInsert.close();
      }
      r.close();
      pstmt.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return ila;
  }

  public String getCondicionVenta(int nDias) {
    String codigo = "001";
    try {
      PreparedStatement pstmt =
          this.con.prepareStatement("Select codigo from msosttablas where tabla = ? and valor = ?");
      pstmt.setString(1, "009");
      pstmt.setInt(2, nDias);
      ResultSet r = pstmt.executeQuery();
      if (r.next())
        codigo = r.getString("codigo");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return codigo;
  }
  
  
  public static void main(String[] args) {
    
    
      String articulo = "493";
      
      Connection con = DataBaseConnection.getInstance().getConnectionDB();
      
      Producto p = null;
      short s = 0;

      String sqlINVDETALLEPARTES =
          "select sum(cantidad) as stock from invdetallepartes  i, INVENCABEZAPARTES e where articulo = ?   and i.Id =  e.Id and i.Tipoid = 17 and i.Local ='000'";
      String sqlINVDETALLEPARTES_MINUS =
          "select sum(cantidad) as stock from invdetallepartes  i, INVENCABEZAPARTES e where articulo = ?   and i.Id =  e.Id  and i.Tipoid = 18 and i.Local ='000'";
      String sqlDETALLEDOCUMENTOCredito =
          "select sum(cantidad) as stock from detalledocumento  d, encabezadocumento e where d.articulo = ? and d.local = '000'  and d.tipoid = '09' and d.id = e.id  and e.vigente = 1";
      String sqlDETALLEDOCUMENTODebito =
          "select sum(cantidad) as stock from detalledocumento  d, encabezadocumento e where d.articulo = ? and d.local = '000'  and d.tipoid = '06' and d.id = e.id  and e.vigente = 1 ";

      String lista =  "001";
      String strSelect =
          "Select a.descripcion, p.ventaneto, a.costo, a.porcIla from articulo as a, precios as p where a.articulo = ? and p.articulo = a.articulo and p.codigolista ='"
              + lista + "'";

      try {

        PreparedStatement pstmt0 = con.prepareStatement(sqlINVDETALLEPARTES);
        pstmt0.setString(1, articulo);
        ResultSet res0 = pstmt0.executeQuery();
        float stock = 0f;
        if (res0.next()) {
          stock = res0.getFloat("stock");
        }
        res0.close();
        pstmt0.close();

        PreparedStatement pstmt1 = con.prepareStatement(sqlINVDETALLEPARTES_MINUS);
        pstmt1.setString(1, articulo);
        ResultSet res1 = pstmt1.executeQuery();
        if (res1.next()) {
          stock = stock - res1.getFloat("stock");
        }
        res1.close();
        pstmt1.close();

        
        PreparedStatement pstmt2 = con.prepareStatement(sqlDETALLEDOCUMENTOCredito);
        pstmt2.setString(1, articulo);
        ResultSet res2 = pstmt2.executeQuery();
        if (res2.next()) {
          stock = stock + res2.getFloat("stock");
        }
        res2.close();
        pstmt2.close();

        PreparedStatement pstmt3 = con.prepareStatement(sqlDETALLEDOCUMENTODebito);
        pstmt3.setString(1, articulo);
        ResultSet res3 = pstmt3.executeQuery();
        if (res3.next()) {
          stock = stock - res3.getFloat("stock");
        }
        res3.close();
        pstmt3.close();

        if (stock < 0f)
          stock = 0f;

        PreparedStatement pstmt4 = con.prepareStatement(strSelect);
        pstmt4.setString(1, articulo);
        ResultSet res4 = pstmt4.executeQuery();
        if (res4.next())
        {
          p =
              new Producto(articulo, s, res4.getString("descripcion"), stock,
                  res4.getFloat("ventaneto"), "", "", res4.getFloat("costo"), res4.getFloat("porcIla"));
        }
        res4.close();
        pstmt4.close();
        
      } catch (SQLException e) {
        e.printStackTrace();
      }
      System.out.println(p +  " " + p.getStock());
  }
}
