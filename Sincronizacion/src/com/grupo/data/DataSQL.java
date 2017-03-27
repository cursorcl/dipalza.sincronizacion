package com.grupo.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import org.apache.log4j.Logger;

import com.grupo.basedatos.Cliente;
import com.grupo.basedatos.EncabezadoVenta;
import com.grupo.basedatos.ItemVenta;
import com.grupo.basedatos.ItemesVenta;
import com.grupo.basedatos.Producto;
import com.grupo.basedatos.RangoEspeciales;
import com.grupo.basedatos.Venta;
import com.grupo.biblioteca.VectorClientes;
import com.grupo.biblioteca.VectorProductos;
import com.grupo.biblioteca.VectorVenta;
import com.grupo.constantes.Constantes;
import com.grupo.forms.FacturaItemModel;
import com.grupo.forms.FrmFacturasEmitidas;
import com.grupo.forms.ResultDetalle;
import com.grupo.forms.SincronizacionMMI;
import com.grupo.forms.report.ListadoCreditos;
import com.grupo.forms.report.RegistroVentaCredito;
import com.grupo.numerados.ListaCorrelativos;
import com.grupo.numerados.ProductosNumerados;
import com.grupo.util.EventEmisor;
import com.grupo.utilitarios.FechaFormateada;
import com.grupo.utilitarios.FormatoNumeros;
import com.grupo.utilitarios.IProcessor;
import com.grupo.utilitarios.ReceptorProcesador;

public class DataSQL extends EventEmisor implements IProcessor {

	private Logger log = Logger.getLogger(DataSQL.class);
	private ReceptorProcesador recProc;
	private static final String SQL_INS_MSOCLIENTES = "insert into msoclientes(razon, direccion, ciudad, comuna, telefono, rut, vendedor, cobrador, ruta, frecuencia, ingreso) values (?, ?, ?, ?, ?, ?, ?, ?, ?, '002', ?)";
	private static final String SQL_UPD_MSOCLIENTES = "update msoclientes set razon = ?, direccion= ?, ciudad = ?, comuna = ?, telefono = ? where rut = ?";
	private static final String SQL_FND_MSOCLIENTES = "select rut from msoclientes where rut = ?";
	private Connection con;
	private String strSelect;
	private FacturaSQL factura;
	private FrmFacturasEmitidas mmiFaturas = new FrmFacturasEmitidas();

	private static DataSQL instance = null;

	final String QRY_ZERO = "SELECT E.id FROM ENCABEZADOCUMENTO AS E where E.numero = ?";
	final String QRY_ONE = "select * from EncabezaDocumento E, TotalDocumento T where E.ID = ? and E.id = T.id";
	final String QRY_TWO = "select * from DETALLEDOCUMENTO WHERE ID = ?";

	private DataSQL() {
		getConnectionDB();
		factura = new FacturaSQL();
		recProc = new ReceptorProcesador(this);
	}

	public static DataSQL getInstance() {
		if (instance == null) {
			instance = new DataSQL();
		}
		return instance;
	}

	public Connection getConnectionDB() {
		con = DataBaseConnection.getInstance().getConnectionDB();
		try {
			con.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public void close() {
		recProc.setAlive(false);
		try {
			con.close();
		} catch (SQLException localSQLException) {
		}
	}

	public VectorClientes getClientes(String gVend, String gRuta, String gRutaAdicional) {
		VectorClientes v = new VectorClientes();
		String rut = null;
		String razon = null;
		String direccion = null;
		String ciudad = null;
		String comuna = null;
		String telefono = null;
		String vendedor = null;
		String ruta = null;
		strSelect = "select * from msoclientes where  vendedor= ? and (ruta = ? or ruta =  ?) order by razon";
		try {
			PreparedStatement pstmt = con.prepareStatement(strSelect);
			pstmt.setString(1, gVend);
			pstmt.setString(2, gRuta);
			pstmt.setString(3, gRutaAdicional);

			ResultSet res = pstmt.executeQuery();
			String cod = "";
			while (res.next()) {
				rut = res.getString("rut");
				cod = res.getString("codigo");
				razon = res.getString("razon") + " " + cod;
				direccion = res.getString("direccion");
				ciudad = res.getString("ciudad");
				comuna = res.getString("comuna");
				telefono = res.getString("telefono");
				vendedor = res.getString("vendedor");
				ruta = res.getString("ruta");
				Cliente c = new Cliente();
				c.setRut(rut);
				c.setRazonSocial(razon);
				c.setDireccion(direccion);
				c.setCiudad(ciudad);
				c.setComuna(comuna);
				c.setTelefono(telefono);
				c.setRuta(ruta);
				c.setVendedor(vendedor);
				c.setCodigo(cod);
				v.add(c);
			}
			res.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}

	public VectorProductos getProductos() {

		String sqlINVDETALLEPARTES = "select sum(cantidad) as stock from invdetallepartes  i, INVENCABEZAPARTES e where articulo = ?   and i.Id =  e.Id and i.Tipoid = 17 and i.Local ='000'";
		String sqlINVDETALLEPARTES_MINUS = "select sum(cantidad) as stock from invdetallepartes  i, INVENCABEZAPARTES e where articulo = ?   and i.Id =  e.Id  and i.Tipoid = 18 and i.Local ='000'";
		String sqlDETALLEDOCUMENTOCredito = "select sum(cantidad) as stock from detalledocumento  d, encabezadocumento e where d.articulo = ? and d.local = '000'  and d.tipoid = '09' and d.id = e.id  and e.vigente = 1";
		String sqlDETALLEDOCUMENTODebito = "select sum(cantidad) as stock from detalledocumento  d, encabezadocumento e where d.articulo = ? and d.local = '000'  and d.tipoid in ( '06', '10') and d.id = e.id  and e.vigente = 1 ";

		Vector<String> codes = null;
		VectorProductos vProductos = null;

		strSelect = "SELECT distinct articulo FROM Numerados";
		try {
			PreparedStatement pstmt = con.prepareStatement(strSelect);
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				if (codes == null) {
					codes = new Vector<String>();
				}
				codes.add(res.getString("articulo"));
			}
			res.close();
			pstmt.close();

			vProductos = new VectorProductos();
			String articulo = null;
			String descripcion = null;
			String unidad = null;
			float ventaNeta = 0.0F;
			float stock = 0.0F;
			float costo = 0.0F;
			float ila = 0.0F;

			Properties props = SincronizacionMMI.PROPERTIES;
			String lista = props.getProperty("lista", "000");
			strSelect = "select a.articulo,  a.descripcion, b.stock, c.ventaNeto, a.unidad, a.costo, a.porcIla from articulo a , artxlocal b , precios c  where c.articulo = a.articulo  and c.codigolista = '"
					+ lista
					+ "'  and a.articulo = b.articulo and b.local ='000' and len(a.articulo) = 3 order by left(a.articulo, 2), a.articulo";

			pstmt = con.prepareStatement(strSelect);
			res = pstmt.executeQuery();
			short idProducto = 1;
			while (res.next()) {
				articulo = res.getString("articulo");
				descripcion = res.getString("descripcion");
				ventaNeta = res.getFloat("ventaNeto");
				unidad = res.getString("unidad");
				costo = res.getFloat("costo");
				ila = res.getFloat("porcIla");

				if ((codes != null) && (codes.indexOf(articulo) != -1)) {
					unidad = "UNI";
				}

				PreparedStatement pstmt0 = this.con.prepareStatement(sqlINVDETALLEPARTES);
				pstmt0.setString(1, articulo);
				ResultSet res0 = pstmt0.executeQuery();
				stock = 0f;
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

				Producto p = new Producto(articulo, idProducto, descripcion, stock, ventaNeta, unidad, "", costo, ila);
				vProductos.add(p);
				idProducto = (short) (idProducto + 1);
			}
			res.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vProductos;
	}

	public List<ProductosNumerados> getArticulosNumerados() {
		List<ProductosNumerados> v = new LinkedList<ProductosNumerados>();
		strSelect = "select n.articulo, n.numero, a.descripcion, n.peso  from Numerados n, Articulo a where n.articulo = a.articulo order by n.articulo, n.numero";
		try {
			PreparedStatement pstmt = con.prepareStatement(strSelect);
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				ProductosNumerados pNumerado = new ProductosNumerados();
				pNumerado.setArticulo(res.getString("articulo"));
				pNumerado.setCorrelativo(res.getInt("numero"));
				pNumerado.setDescripcion(res.getString("descripcion"));
				pNumerado.setPesoQueso(res.getFloat("peso"));
				v.add(pNumerado);
			}
			res.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}

	public Vector<ListaCorrelativos> getCorrelaModificar() {
		Vector<ListaCorrelativos> v = new Vector<ListaCorrelativos>();
		strSelect = "select * from numerados";
		try {
			PreparedStatement pstmt = con.prepareStatement(strSelect);
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				v.addElement(
						new ListaCorrelativos(res.getString("articulo"), res.getInt("numero"), res.getFloat("peso")));
			}
			res.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}

	public void setCliente(Cliente cl, String gVend, String gRuta) {
		PreparedStatement pstmt = null;
		try {
			int estado = cl.getEstado();
			if ((estado == Constantes.CLIENTE_NUEVO) && (!isClienteInDB(cl.getRut())))
				pstmt = con.prepareStatement(SQL_INS_MSOCLIENTES);
			else {
				pstmt = con.prepareStatement(SQL_UPD_MSOCLIENTES);
			}
			pstmt.clearParameters();
			pstmt.setString(1, cl.getRazonSocial());
			pstmt.setString(2, cl.getDireccion());
			pstmt.setString(3, cl.getCiudad());
			pstmt.setString(4, cl.getComuna());
			pstmt.setString(5, cl.getTelefono());
			pstmt.setString(6, FormatoNumeros.putStrAtBegin(cl.getRut(), '0', 10));
			if (estado == Constantes.CLIENTE_NUEVO) {
				pstmt.setString(7, gVend);
				pstmt.setString(8, gVend);
				pstmt.setString(9, gRuta);
				pstmt.setDate(10, new java.sql.Date(System.currentTimeMillis()));
			}
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String setVentas(Vector<?> encabezado, Vector<?> itemes, FechaFormateada fecha) {
		mmiFaturas.setVisible(true);
		int nItemes = 0;
		int j = 0;
		String id = "";
		String rut = "";
		String nroFactura = "";
		String condicion = "";
		int dias = 0;
		float ila = 0.0F;
		float neto = 0.0F;
		EncabezadoVenta v = new EncabezadoVenta();
		if ((itemes != null) && (itemes.size() > 0)) {
			try {
				for (int n = 0; n < encabezado.size(); ++n) {
					v.decode((byte[]) encabezado.elementAt(n));
					v.setFecha(fecha);
					if (!v.isDroped()) {
						rut = v.getRut();

						mmiFaturas.setVendedor(v.getVendedor());
						mmiFaturas.setFecha(fecha.toString());

						ItemesVenta itemesV = new ItemesVenta();
						itemesV.decode((byte[]) itemes.elementAt(n));

						itemesV.add(getConduccion(rut));

						nItemes = 0;
						Vector<ItemVenta> filasV = itemesV.getAll();
						boolean allItems = true;

						// Limpio los valores para el reporte de deudores
						ListadoCreditos.getInstance().clear();
						while (nItemes < filasV.size()) {
							if (nItemes % SincronizacionMMI.nroLineas == 0) {
								ila = 0.0F;
								neto = 0.0F;
								id = factura.insertEncabezado(v);
								nroFactura = factura.getNumeroFactura(id);
								int nCondicion = v.getCondicionVenta() - 1;
								condicion = Constantes.COD_MODO_PAGO[nCondicion];
								dias = Constantes.DIA_MODO_PAGO[nCondicion];
								String strCondicion = Constantes.STR_MODO_PAGO[nCondicion];
								if (strCondicion.contains("CREDITO")) {
									RegistroVentaCredito registro = new RegistroVentaCredito();
									registro.setNumeroFactura(nroFactura);
									registro.setNombre(v.getNombreCliente());
									registro.setRut(v.getRut());
									registro.setRuta(factura.getRuta(rut));
									registro.setVendedor(v.getVendedor());
									registro.setVenta(v.getNeto() * (1 + v.getPorcentajeIva()));
									ListadoCreditos.getInstance().add(registro);
								}
							}
							for (j = 1; (j <= SincronizacionMMI.nroLineas) && (nItemes < filasV.size()); j++) {
								ItemVenta iv = (ItemVenta) filasV.elementAt(nItemes);
								ResultDetalle r = factura.insertDetalleVenta(iv, id, j);
								if ((r.getResult() == 1) || (r.getResult() == 2)) {
									allItems = false;
									Producto pr = factura.getDatosProducto(iv.getArticulo());
									mmiFaturas.addItemFallido(nroFactura + " : " + pr.getArticulo() + " "
											+ pr.getNombre() + " " + r.getFaltante());
								}
								if (r.getResult() != 2) {
									neto += r.getTotal();
								}
								++nItemes;
							}

							ila = factura.insertIla(nroFactura, id);
							factura.insertTotalDocumento(id, neto, v.getPorcentajeIva(), ila);
							factura.insertCtaDcto(nroFactura, v, neto, ila);
							factura.insertDatosCliente(rut, id, condicion, dias, v.getCodigoCliente()); // AQUI
							factura.insertFolios(nroFactura);

							FacturaItemModel fModel = getFacturaModel(nroFactura, allItems, v, neto);
							mmiFaturas.addItemVenta(fModel);
							mmiFaturas.setIva(v.getPorcentajeIva());
							mmiFaturas.addNeto(neto);
						}
					}
				}
				con.commit();
			} catch (SQLException e) {
				try {
					e.printStackTrace();
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}

		}

		mmiFaturas.message("Se ha concluido el ingreso de facturas", "FACTURAS");
		return nroFactura;
	}

	private String setVenta(EncabezadoVenta encabezado, ItemesVenta itemes, FechaFormateada fecha) {
		mmiFaturas.setVisible(true);
		int nItemes = 0;
		int j = 0;
		String id = "";
		String rut = "";
		String nroFactura = "";
		String condicion = "";
		int dias = 0;
		float ila = 0.0F;
		float neto = 0.0F;
		if ((itemes != null) && (itemes.size() > 0)) {
			try {
				encabezado.setFecha(fecha);
				rut = encabezado.getRut();

				mmiFaturas.setVendedor(encabezado.getVendedor());
				mmiFaturas.setFecha(fecha.toString());

				itemes.add(getConduccion(rut));
				nItemes = 0;
				boolean allItems = true;

				while (nItemes < itemes.size()) {
					if (nItemes % SincronizacionMMI.nroLineas == 0) {
						ila = 0.0F;
						neto = 0.0F;
						id = factura.insertEncabezado(encabezado);
						nroFactura = factura.getNumeroFactura(id);

						int nCondicion = encabezado.getCondicionVenta() - 1;
						condicion = Constantes.COD_MODO_PAGO[nCondicion];
						dias = Constantes.DIA_MODO_PAGO[nCondicion];
						String strCondicion = Constantes.STR_MODO_PAGO[nCondicion];

						if (strCondicion.contains("CREDITO")) {

							RegistroVentaCredito registro = new RegistroVentaCredito();
							registro.setNumeroFactura(nroFactura);
							registro.setNombre(encabezado.getNombreCliente());
							registro.setRut(rut);
							registro.setRuta(factura.getRuta(rut));
							registro.setVendedor(encabezado.getVendedor());
							registro.setVenta(encabezado.getNeto() * (1 + encabezado.getPorcentajeIva()));
							ListadoCreditos.getInstance().add(registro);
						}
					}

					for (j = 1; j <= SincronizacionMMI.nroLineas && nItemes < itemes.size(); ++nItemes, ++j) {
						ItemVenta itemLineaVenta = itemes.elementAt(nItemes);
						ResultDetalle r = factura.insertDetalleVenta(itemLineaVenta, id, j);
						if ((r.getResult() == 1) || (r.getResult() == 2)) {
							allItems = false;
							Producto pr = factura.getDatosProducto(itemLineaVenta.getArticulo());
							mmiFaturas.addItemFallido(nroFactura + " : " + pr.getArticulo() + " " + pr.getNombre() + " "
									+ r.getFaltante());
						}
						if (r.getResult() != 2) {
							neto += r.getTotal();
						}
					}
					ila = factura.insertIla(nroFactura, id);
					factura.insertTotalDocumento(id, neto, encabezado.getPorcentajeIva(), ila);

					factura.insertCtaDcto(nroFactura, encabezado, neto, ila);
					factura.insertDatosCliente(rut, id, condicion, dias, encabezado.getCodigoCliente()); // AQUI
					factura.insertFolios(nroFactura);
					FacturaItemModel fModel = getFacturaModel(nroFactura, allItems, encabezado, neto);
					mmiFaturas.addItemVenta(fModel);
					mmiFaturas.setIva(encabezado.getPorcentajeIva());
					mmiFaturas.addNeto(neto);
				}
				con.commit();
			} catch (SQLException e) {
				try {
					e.printStackTrace();
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}

		return nroFactura;
	}

	private FacturaItemModel getFacturaModel(String nroFactura, boolean allItems, EncabezadoVenta e, float neto) {
		FacturaItemModel fModel = new FacturaItemModel();
		fModel.setCliente(e.getNombreCliente() + " " + e.getCodigoCliente());
		fModel.setNumero(Integer.parseInt(nroFactura));
		float totalIva = e.getPorcentajeIva() / 100.0F * neto;
		fModel.setMontoNeto(neto);
		fModel.setMontoIva(totalIva);
		fModel.setMonoBruto(neto + totalIva);
		fModel.setAllProducts(allItems);
		return fModel;
	}

	private ItemVenta getConduccion(String rut) {
		Producto pr = factura.getConduccion(rut);

		return new ItemVenta((short) 0, pr.getArticulo(), 1.0F, pr.getPrecio(), 0.0F, 0.0F, pr.getPrecio());
	}

	private boolean isClienteInDB(String rut) {
		boolean value = false;
		try {
			PreparedStatement pstmt = con.prepareStatement(SQL_FND_MSOCLIENTES);
			pstmt.clearParameters();
			pstmt.setString(1, rut);
			ResultSet r = pstmt.executeQuery();
			value = r.next();
			r.close();
			pstmt.close();
		} catch (SQLException localSQLException) {
		}
		return value;
	}

	public void resetNumerados() {
		String strSel = "delete from correlativonumerados";
		try {
			PreparedStatement pstmt = con.prepareStatement(strSel);
			pstmt.executeUpdate();
			pstmt.close();

			strSel = "insert into correlativonumerados (correlativo) values (0)";

			pstmt = con.prepareStatement(strSel);
			pstmt.executeUpdate();
			pstmt.close();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String clonarFactura(String oFactura) {
		EncabezadoVenta encabezado = null;
		ItemesVenta itemesV = null;
		String nFactura = "";
		FechaFormateada fecha = new FechaFormateada(new java.util.Date().getTime());

		String oId = null;
		try {
			notify("Obteniendo Id asociado a factura");
			PreparedStatement pstmt = con
					.prepareStatement("SELECT E.id FROM ENCABEZADOCUMENTO AS E where E.numero = ?");
			pstmt.setString(1, oFactura);
			ResultSet r = pstmt.executeQuery();
			if (r.next()) {
				oId = r.getString(1);

				notify("Id asociado a factura = " + oId);
			} else {
				nFactura = "";
				notify("No existe la factura solicitada = " + oFactura);
			}
			r.close();
			pstmt.close();
			if (oId != null) {
				pstmt = con.prepareStatement(
						"select * from EncabezaDocumento E, TotalDocumento T where E.ID = ? and E.id = T.id");
				pstmt.setString(1, oId);
				r = pstmt.executeQuery();
				if (r.next()) {
					encabezado = new EncabezadoVenta();
					float neto = r.getFloat("totalneto");
					float totalIva = r.getFloat("TotalIva");
					float iva = totalIva / neto * 100.0F;

					java.util.Date d1 = r.getDate("fecha");
					java.util.Date d2 = r.getDate("vence");
					java.util.Date d3 = new java.util.Date(d2.getTime() - d1.getTime());
					fecha = new FechaFormateada(d1.getTime());
					Calendar c = Calendar.getInstance();
					c.setTime(d3);
					int n = c.get(Calendar.DAY_OF_YEAR);// (6);
					String codigo = factura.getCondicionVenta(n);
					n = Integer.parseInt(codigo);
					encabezado.setCondicionVenta((byte) n);
					encabezado.setFecha(d1);
					encabezado.setRut(r.getString("rut"));
					encabezado.setNeto(neto);
					encabezado.setPorcentajeIva(iva);
					encabezado.setNombreCliente("Cliente");
				}

				r.close();
				pstmt.close();

				notify("Generado Encabezado Documento con factura = " + oFactura);

				pstmt = con.prepareStatement("select * from DETALLEDOCUMENTO WHERE ID = ?");
				pstmt.setString(1, oId);
				r = pstmt.executeQuery();
				itemesV = new ItemesVenta();
				while (r.next()) {
					ItemVenta itm = new ItemVenta();
					String articulo = r.getString("articulo");
					if (articulo.length() > 2) {
						itm.setArticulo(articulo);
						itm.setCantidad(r.getFloat("cantidad"));
						itm.setCodigoProducto((short) 0);
						itm.setDescuento(r.getFloat("variacion"));
						itm.setNeto(r.getFloat("totalLinea"));
						itemesV.add(itm);
					}
				}

				r.close();
				pstmt.close();
				r = null;
				pstmt = null;

				notify("Generado Detalle Documento con factura = " + oFactura);
				Vector e = new Vector(1);
				Vector i = new Vector(1);
				e.add(encabezado.encode());
				i.add(itemesV.encode());
				nFactura = setVentas(e, i, fecha);
				notify("Proceso de generación de nueva Factura = " + nFactura + " finalizado");
			}
		} catch (SQLException e) {
			notify("Ha Fallado la generación de la factura = " + nFactura);
			e.printStackTrace();
			nFactura = "";
		}
		return nFactura;
	}

	public void process(Object element) {
		if (element instanceof Venta) {
			Venta e = (Venta) element;
			setVenta(e.getEncabezado(), e.getVentas(), e.getFecha());
		}
	}

	public void addVenta(EncabezadoVenta encabezado, ItemesVenta itemes, FechaFormateada fecha) {
		recProc.add(new Venta(encabezado, itemes, fecha));
	}

	public void addVentas(VectorVenta ventas) {
		for (Venta v : ventas.asVector()) {
			recProc.add(v);
		}
	}

	/*
	 * Administración de productos numerados
	 */
	public void removeNumerado(ProductosNumerados numerado) {
		String strDelete = "delete from numerados where articulo = ? and numero = ?";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(strDelete);
			pstmt.setString(1, numerado.getArticulo());
			pstmt.setInt(2, numerado.getCorrelativo());
			pstmt.executeUpdate();
			pstmt.close();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String strSelect = "select count(*) from numerados where articulo = ?";
		try {
			pstmt = con.prepareStatement(strSelect);
			pstmt.setString(1, numerado.getArticulo());
			ResultSet rSet = pstmt.executeQuery();
			int rows = -1;
			if (rSet.next()) {
				rows = rSet.getInt(1);
			}
			rSet.close();
			pstmt.close();
			if (rows == 0) {
				strDelete = "delete from articulosnumerados where articulo = ? ";
				pstmt = con.prepareStatement(strDelete);
				pstmt.setString(1, numerado.getArticulo());
				pstmt.executeUpdate();
				pstmt.close();
				con.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void addNumerado(ProductosNumerados numerado) {
		String strFindNumero = "select * from articulosnumerados where articulo = (?)";
		String strInsertNumero = "insert into articulosnumerados (articulo) values (?)";
		String strInsert = "insert into numerados (articulo, peso, numero, narticulo) values (?, ?, ?, ?)";

		try {
			PreparedStatement pstmt = con.prepareStatement(strFindNumero);
			pstmt.setString(1, numerado.getArticulo());
			ResultSet res = pstmt.executeQuery();
			if (!res.next()) {
				PreparedStatement pstmtInsert = con.prepareStatement(strInsertNumero);
				pstmtInsert.setString(1, numerado.getArticulo());
				pstmtInsert.executeUpdate();
				pstmtInsert.close();
			}
			pstmt.close();
			int narticulo = 0;
			try {
				narticulo = Integer.parseInt(numerado.getArticulo());
			} catch (Exception e) {
				narticulo = 0;
			}

			pstmt = con.prepareStatement(strInsert);
			pstmt.setString(1, numerado.getArticulo());
			pstmt.setFloat(2, numerado.getPesoQueso());
			pstmt.setInt(3, numerado.getCorrelativo());
			pstmt.setInt(4, narticulo);
			pstmt.executeUpdate();
			pstmt.close();
			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getProductName(String articulo) {
		String descripcion = "";

		String strSelect = "select descripcion from articulo a where articulo = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(strSelect);
			pstmt.setString(1, articulo);
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				descripcion = res.getString("descripcion");
			}
			res.close();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return descripcion;
	}

	public int getIndex(String articulo) {
		int min = 1;
		String strSel = "Select numero from numerados where articulo = ? order by numero";

		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(strSel);
			pstmt.setString(1, articulo);

			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				int numero = res.getInt(1);
				if (numero == min) {
					min++;
				}
			}
			res.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return min;
	}

	public void add(Object paramObject) {
		// TODO Auto-generated method stub
	}

	public List<RangoEspeciales> getEspeciales() {
		String sql = "select *   from especiales";

		List<RangoEspeciales> especiales = new ArrayList<>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				int id = res.getInt(1);
				String aInicial = res.getString(2);
				String aFinal = res.getString(3);
				RangoEspeciales esp = new RangoEspeciales(id, aInicial, aFinal);
				especiales.add(esp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return especiales;
	}

	public void setEspeciales(List<RangoEspeciales> rangos) {
		String sqlDel = "delete from especiales";
		String sqlIns = "insert into especiales values (?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sqlDel);
			pstmt.executeUpdate();
			con.commit();
			for (RangoEspeciales rng : rangos) {
				pstmt = con.prepareStatement(sqlIns);
				pstmt.setString(1, rng.getArticuloInicial());
				pstmt.setString(2, rng.getArticuloFinal());
				pstmt.executeUpdate();
				pstmt.close();
				con.commit();
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
		}

	}
}
