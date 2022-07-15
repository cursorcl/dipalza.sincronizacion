package com.grupo.data.results;

public class NumeradosSinDetalleDTO {

	private String articulo;
	private String descripcion;

	public NumeradosSinDetalleDTO() {
	}
	
	public NumeradosSinDetalleDTO(String articulo, String descripcion) {
		super();
		this.articulo = articulo;
		this.descripcion = descripcion;
	}

	public String getArticulo() {
		return articulo;
	}

	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
