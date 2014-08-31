package com.grupo.data;

public class DataArticulo
{
  private String articulo = null;
  private String descripcion = null;
  private String unidad = null;
  private float ventaNeta = 0.0F;

  public DataArticulo(String articulo, String descripcion, String unidad, float ventaNeta)
  {
    this.articulo = articulo;
    this.descripcion = descripcion;
    this.unidad = unidad;
    this.ventaNeta = ventaNeta;
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

  public String getUnidad() {
    return this.unidad;
  }

  public void setUnidad(String unidad) {
    this.unidad = unidad;
  }

  public float getVentaNeta() {
    return this.ventaNeta;
  }

  public void setVentaNeta(float ventaNeta) {
    this.ventaNeta = ventaNeta;
  }
}
