package com.grupo.forms.report;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;

import com.grupo.data.DataBaseConnection;
import com.grupo.util.EventEmisor;

public class HojaRuta extends EventEmisor {
	private final String SQL_DELETE_REPORTE = "delete from ReporteRutaDiaria";

	private final String SQL_GENERA_REPORTE = "INSERT INTO ReporteRutaDiaria ( ruta, articulo, cantidad, total) SELECT M.Ruta, D.Articulo, Sum(D.Cantidad) AS SumaDeCantidad, Sum(D.TotalLinea) AS SumaDeTotalLinea FROM ENCABEZADOCUMENTO AS E, DETALLEDOCUMENTO AS D, MSOCLIENTES AS M, NUMERADOS AS N WHERE E.Id=D.Id AND E.Rut = M.Rut AND N.Articulo = D.Articulo AND E.Fecha = ? GROUP BY M.Ruta, D.Articulo";

	private static HojaRuta instance = null;

	public static HojaRuta getInstance() {
		if (instance == null) {
			instance = new HojaRuta();
		}
		return instance;
	}

	private boolean generaReporte(Date fecha) {
		boolean result = false;
		try {
			notify("Limpiando datos antiguos");
			Connection con = DataBaseConnection.getInstance().getConnectionDB();
			PreparedStatement pstmt;
			pstmt = con.prepareStatement(SQL_DELETE_REPORTE);
			pstmt.executeUpdate();
			pstmt.close();
			con.commit();
			notify("Generando datos nuevos");
			pstmt = con.prepareStatement(SQL_GENERA_REPORTE);
			pstmt.clearParameters();
			pstmt.setDate(1, new java.sql.Date(fecha.getTime()));
			pstmt.executeUpdate();
			pstmt.close();
			notify("Actualizando información de rutas");
			pstmt = con
					.prepareStatement("update ReporteRutaDiaria set nombreruta = M.descripcion, narticulo=cast(articulo as int) from MSOSTTABLAS As M where M.tabla = '017' and M.codigo = ruta");

			pstmt.executeUpdate();
			pstmt.close();
			notify("Actualizando información de artículos");
			pstmt = con
					.prepareStatement("update ReporteRutaDiaria  set descripcion = A.descripcion  from ARTICULO as A where A.articulo = ReporteRutaDiaria.articulo");
			pstmt.executeUpdate();
			pstmt.close();
			notify("Generando numeración de quesos");
			pstmt = con
					.prepareStatement("SELECT distinct m.Ruta, q.Articulo, d.Descripcion, a.descripcion as original FROM Numerados AS q, detalledocumento AS d, msoclientes AS m, encabezadocumento AS e, articulo as a WHERE q.Articulo=d.articulo AND m.Rut=e.rut AND e.Id=d.id and a.articulo = q.articulo and e.fecha = ? ORDER BY m.Ruta, q.Articulo");
			pstmt.clearParameters();
			pstmt.setDate(1, new java.sql.Date(fecha.getTime()));
			ResultSet r = pstmt.executeQuery();

			String ruta = "";
			String artclo = "";
			String descrp = "";
			String descOld = "";
			notify("Actualizando numeración de quesos");
			while (r.next()) {
				String codeRuta = r.getString(1);
				String articulo = r.getString(2);
				String descTotal = r.getString(3);
				String descOriginal = r.getString(4);
				if ((!ruta.equals(codeRuta)) || (!artclo.equals(articulo))) {
					if ((!"".equals(descrp)) || (!"".equals(artclo))) {

						descrp = ordenarNumeros(descrp, descOld);
						PreparedStatement pexec = con
								.prepareStatement("update ReporteRutaDiaria set descripcion = ? where articulo = ? and ruta = ?");
						pexec.clearParameters();
						pexec.setString(1, descrp);
						pexec.setString(2, artclo);
						pexec.setString(3, ruta);
						pexec.executeUpdate();
						pexec.close();
					}

					ruta = codeRuta;
					artclo = articulo;
					descrp = descTotal;
					descOld = descOriginal;
				} else {

					descrp = descrp + formarString(descOriginal, descTotal);
				}
			}
			r.close();
			pstmt.close();
			result = true;
			notify("Generación de datos de reporte concluida");
		} catch (SQLException e) {
			notify("Generación de datos de reporte ha fallado");
			e.printStackTrace();
		}
		return result;
	}

	private String ordenarNumeros(String descrp, String descOriginal) {

		String resultado = descOriginal;
		if (!descOriginal.trim().equalsIgnoreCase(descrp.trim())) {
			int l = descOriginal.length();
			String delta = descrp.trim().substring(l);
			String[] numeros = delta.trim().split("-");
			List<Integer> enteros = new ArrayList<Integer>();
			for (int n = 0; n < numeros.length; n++) {
				String numero = numeros[n].replaceAll("[^\\.0123456789]", "")
						.trim();
				if (isNumeric(numero)) {
					enteros.add(Integer.valueOf(numero));
				}
			}
			Collections.sort(enteros);
			for (Integer entero : enteros) {
				resultado = resultado + " " + entero;
			}
		}
		return resultado;
	}

	private String formarString(String descOriginal, String descTotal) {
		String resultado = "";
		int l = descOriginal.length();
		String delta = descTotal.substring(l);
		delta = delta.trim().replace('-', ' ');
		String[] numeros = delta.split(" ");
		for (String numero : numeros) {
			numero = numero.replaceAll("[^\\.0123456789]", "").trim();
			if (isNumeric(numero)) {
				resultado = resultado + ("".equals(resultado) ? "" : "-" ) + numero ;
			}
		}

		return resultado;
	}

	public void construirReporte(Date fecha) {
		if (generaReporte(fecha)) {
			notify("Obteniendo modelo del reporte");
			URL urlMaestro = super.getClass().getResource("ventas.jasper");
			JasperReport masterReport = null;
			try {
				masterReport = (JasperReport) JRLoader.loadObject(urlMaestro);
				notify("Reporte Cargado");
			} catch (JRException e) {
				notify("Error cargando el reporte maestro");
				e.printStackTrace();
			}
			Map<String, Object> masterParams = new HashMap<String, Object>();
			Timestamp t = new Timestamp(fecha.getTime());
			masterParams.put("FECHA_REPORTE", t);
			notify("Establecido parámetro fecha del reporte");

			JasperPrint masterPrint = null;
			try {
				notify("Cargando datos en el reporte");
				masterPrint = JasperFillManager.fillReport(masterReport,
						masterParams, DataBaseConnection.getInstance()
								.getConnectionDB());

				notify("Datos cargados en el reporte");
			} catch (JRException e) {
				notify("Error llenando el reporte maestro");
				e.printStackTrace();
			}

			notify("Construyendo la vista del reporte");
			JRViewer report = new JRViewer(masterPrint);
			JFrame pnlReporte = new JFrame();
			pnlReporte.setDefaultCloseOperation(2);
			pnlReporte.setSize(252, 316);
			pnlReporte.setContentPane(report);
			pnlReporte.setVisible(true);
		}
	}

	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?"); // match a number with optional
												// '-' and decimal.
	}
}
