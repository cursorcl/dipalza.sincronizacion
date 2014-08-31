package com.grupo.numerados;

public class ProductosNumerados implements Comparable<ProductosNumerados> {
    private String articulo = null;

    private String descripcion = null;

    private int correlativo = 0;

    private float pesoQueso = 0.0F;
    
    public ProductosNumerados() {
    }
    
    public ProductosNumerados(String articulo, String descripcion) {
	this.articulo = articulo;
	this.descripcion = descripcion;
    }

    public ProductosNumerados(String articulo, String descripcion,
	    int correlativo, float pesoQueso) {
	this.articulo = articulo;
	this.descripcion = descripcion;
	this.correlativo = correlativo;
	this.pesoQueso = pesoQueso;
    }

    public ProductosNumerados(String articulo, int correlativo, float pesoQueso) {
	this.articulo = articulo;
	this.correlativo = correlativo;
	this.pesoQueso = pesoQueso;
    }

    public String getArticulo() {
	return this.articulo;
    }

    public void setArticulo(String articulo) {
	this.articulo = articulo;
    }

    public String getDescripcion() {
	return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
    }

    public String toString() {
	return this.articulo + " " + this.descripcion;
    }

    public int getCorrelativo() {
	return this.correlativo;
    }

    public void setCorrelativo(int correlativo) {
	this.correlativo = correlativo;
    }

    public float getPesoQueso() {
	return this.pesoQueso;
    }

    public void setPesoQueso(float pesoQueso) {
	this.pesoQueso = pesoQueso;
    }

    public boolean equals(Object obj) {
	boolean result = false;
	if ((obj instanceof ProductosNumerados)
		&& (((ProductosNumerados) obj).getArticulo()
			.equals(this.articulo))) {
	    result = true;
	}
	return result;
    }

    public int compareTo(ProductosNumerados producto) {
	int r = 0;
	int localCode;
	try {
	    localCode = Integer.parseInt(this.articulo);
	} catch (Exception e) {
	    localCode = -1;
	}

	int externCode;
	try {
	    externCode = Integer.parseInt(producto.getArticulo());
	} catch (Exception e) {
	    externCode = -1;
	}
	r = Math.abs(localCode - externCode);

	return r;
    }
}
