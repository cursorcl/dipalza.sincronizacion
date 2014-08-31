/*    */ package com.grupo.data;
/*    */ 
/*    */ public class DataCliente
/*    */ {
/* 10 */   private String rut = null;
/*    */ 
/* 12 */   private String razon = null;
/*    */ 
/* 14 */   private String direccion = null;
/*    */ 
/* 16 */   private String comuna = null;
/*    */ 
/* 18 */   private String ciudad = null;
/*    */ 
/* 20 */   private String telefono = null;
/*    */ 
/* 22 */   private String vendedor = null;
/*    */ 
/* 24 */   private String ruta = null;
/*    */ 
/*    */   public DataCliente(String rut, String razon, String direccion, String comuna, String ciudad, String telefono, String vendedor, String ruta)
/*    */   {
/* 28 */     this.rut = rut;
/* 29 */     this.razon = razon;
/* 30 */     this.direccion = direccion;
/* 31 */     this.comuna = comuna;
/* 32 */     this.ciudad = ciudad;
/* 33 */     this.telefono = telefono;
/* 34 */     this.vendedor = vendedor;
/* 35 */     this.ruta = ruta;
/*    */   }
/*    */ 
/*    */   public String getCiudad() {
/* 39 */     return this.ciudad;
/*    */   }
/*    */ 
/*    */   public void setCiudad(String ciudad) {
/* 43 */     this.ciudad = ciudad;
/*    */   }
/*    */ 
/*    */   public String getDireccion() {
/* 47 */     return this.direccion;
/*    */   }
/*    */ 
/*    */   public void setDireccion(String direccion) {
/* 51 */     this.direccion = direccion;
/*    */   }
/*    */ 
/*    */   public String getRazon() {
/* 55 */     return this.razon;
/*    */   }
/*    */ 
/*    */   public void setRazon(String razon) {
/* 59 */     this.razon = razon;
/*    */   }
/*    */ 
/*    */   public String getRut() {
/* 63 */     return this.rut;
/*    */   }
/*    */ 
/*    */   public void setRut(String rut) {
/* 67 */     this.rut = rut;
/*    */   }
/*    */ 
/*    */   public String getRuta() {
/* 71 */     return this.ruta;
/*    */   }
/*    */ 
/*    */   public void setRuta(String ruta) {
/* 75 */     this.ruta = ruta;
/*    */   }
/*    */ 
/*    */   public String getTelefono() {
/* 79 */     return this.telefono;
/*    */   }
/*    */ 
/*    */   public void setTelefono(String telefono) {
/* 83 */     this.telefono = telefono;
/*    */   }
/*    */ 
/*    */   public String getVendedor() {
/* 87 */     return this.vendedor;
/*    */   }
/*    */ 
/*    */   public void setVendedor(String vendedor) {
/* 91 */     this.vendedor = vendedor;
/*    */   }
/*    */ 
/*    */   public String getComuna() {
/* 95 */     return this.comuna;
/*    */   }
/*    */ 
/*    */   public void setComuna(String comuna) {
/* 99 */     this.comuna = comuna;
/*    */   }
/*    */ }

/* Location:           C:\Users\cursor\ventaserver\
 * Qualified Name:     com.grupo.data.DataCliente
 * JD-Core Version:    0.5.4
 */