package com.grupo.forms.report;

import java.util.Date;

public class RegistroVentaCredito {
	private String rut;
	private String nombre;
	private Float venta;
	private String numeroFactura;
	private Date fecha;
	private String ruta;
	private String vendedor;
	
	public RegistroVentaCredito() {
	
	}
	
	
	
	public RegistroVentaCredito(String rut, String nombre, Float venta,
			String numeroFactura, Date fecha, String ruta, String vendedor) {
		super();
		this.rut = rut;
		this.nombre = nombre;
		this.venta = venta;
		this.numeroFactura = numeroFactura;
		this.fecha = fecha;
		this.ruta = ruta;
		this.vendedor = vendedor;
	}



	public void setVenta(Float venta) {
		this.venta = venta;
	}
	public Float getVenta() {
		return venta;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getRut() {
		return rut;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public String getNumeroFactura() {
		return numeroFactura;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getRuta() {
		return ruta;
	}



	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}



	public String getVendedor() {
		return vendedor;
	}
	
	
}
