package com.grupo.forms.report;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JFrame;

import com.grupo.data.DataBaseConnection;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;

public class ListadoCreditos {

	private static Vector<RegistroVentaCredito> collection = new Vector<RegistroVentaCredito>();
	private static ListadoCreditos instance = null;

	public static ListadoCreditos getInstance() {
		if (instance == null) {
			instance = new ListadoCreditos();
		}
		return instance;
	}

	public void construirReporte(Calendar fecha) {
		Connection con = DataBaseConnection.getInstance().getConnectionDB();
		PreparedStatement pstmt;
		collection.clear();
		try {
			pstmt = con.prepareStatement("SELECT MSOCLIENTES.Ruta, MSOCLIENTES.Vendedor, MSOCLIENTES.Rut, MSOCLIENTES.Razon, ENCABEZADOCUMENTO.Numero, TOTALDOCUMENTO.Total, ENCABEZADOCUMENTO.Fecha FROM MSOCLIENTES INNER JOIN (ENCABEZADOCUMENTO INNER JOIN TOTALDOCUMENTO ON ENCABEZADOCUMENTO.Id = TOTALDOCUMENTO.Id) ON MSOCLIENTES.Rut = ENCABEZADOCUMENTO.Rut WHERE [Vence]-[Fecha] > 0 AND ENCABEZADOCUMENTO.Fecha = ? ORDER BY MSOCLIENTES.Ruta, MSOCLIENTES.Vendedor");
			pstmt.clearParameters();
			pstmt.setDate(1, new java.sql.Date(fecha.getTime().getTime()));
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				RegistroVentaCredito r = new RegistroVentaCredito();
				r.setFecha(res.getDate("fecha"));
				r.setNombre(res.getString("Razon"));
				r.setNumeroFactura(res.getString("Numero"));
				r.setRut(res.getString("Rut"));
				r.setRuta(res.getString("Ruta"));
				r.setVendedor(res.getString("Vendedor"));
				r.setVenta(res.getFloat("Total"));
				collection.add(r);
			}
			pstmt.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		URL urlMaestro = getClass().getResource("ventasCredito.jasper");
		JasperReport masterReport = null;
		try {
			masterReport = (JasperReport) JRLoader.loadObject(urlMaestro);
		} catch (JRException e) {
			e.printStackTrace();
		}
		JasperPrint masterPrint = null;
		try {
			HashMap<String, Object> params = new HashMap<String, Object>();
			params.put("fechaCredito", fecha.getTime());
			masterPrint = JasperFillManager.fillReport(masterReport, params, new JRBeanCollectionDataSource(collection));

		} catch (JRException e) {
			e.printStackTrace();
		}

		JRViewer report = new JRViewer(masterPrint);
		JFrame pnlReporte = new JFrame();
		pnlReporte.setDefaultCloseOperation(2);
		pnlReporte.setSize(252, 316);
		pnlReporte.setContentPane(report);
		pnlReporte.setVisible(true);
	}

	public static java.util.Collection<RegistroVentaCredito> generateCollection() {
		return collection;
	}

	public void add(RegistroVentaCredito registro) {
		collection.add(registro);
	}

	public void delete(RegistroVentaCredito registro) {
		collection.remove(registro);
	}

	public void clear() {
		collection.clear();
	}

}
