package com.grupo.data;

public class DataCliente
{
  private String rut = null;

  private String razon = null;

  private String direccion = null;

  private String comuna = null;

  private String ciudad = null;

  private String telefono = null;

  private String vendedor = null;

  private String ruta = null;

  public DataCliente(String rut, String razon, String direccion, String comuna, String ciudad, String telefono, String vendedor, String ruta)
  {
    this.rut = rut;
    this.razon = razon;
    this.direccion = direccion;
    this.comuna = comuna;
    this.ciudad = ciudad;
    this.telefono = telefono;
    this.vendedor = vendedor;
    this.ruta = ruta;
  }

  public String getCiudad() {
    return this.ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  public String getDireccion() {
    return this.direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public String getRazon() {
    return this.razon;
  }

  public void setRazon(String razon) {
    this.razon = razon;
  }

  public String getRut() {
    return this.rut;
  }

  public void setRut(String rut) {
    this.rut = rut;
  }

  public String getRuta() {
    return this.ruta;
  }

  public void setRuta(String ruta) {
    this.ruta = ruta;
  }

  public String getTelefono() {
    return this.telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getVendedor() {
    return this.vendedor;
  }

  public void setVendedor(String vendedor) {
    this.vendedor = vendedor;
  }

  public String getComuna() {
    return this.comuna;
  }

  public void setComuna(String comuna) {
    this.comuna = comuna;
  }
}
