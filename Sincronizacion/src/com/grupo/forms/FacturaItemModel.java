 package com.grupo.forms;
 
 public class FacturaItemModel
 {
   private int numero = 0;
   private String cliente = null;
   private float montoNeto = 0.0F;
   private float montoIva = 0.0F;
   private float monoBruto = 0.0F;
   private boolean allProducts = false;
 
   public String getCliente()
   {
     return this.cliente;
   }
   public void setCliente(String cliente) {
     this.cliente = cliente;
   }
   public float getMontoNeto() {
     return this.montoNeto;
   }
   public void setMontoNeto(float montoNeto) {
     this.montoNeto = montoNeto;
   }
   public float getMontoIva() {
     return this.montoIva;
   }
   public void setMontoIva(float montoIva) {
     this.montoIva = montoIva;
   }
   public float getMonoBruto() {
     return this.monoBruto;
   }
   public void setMonoBruto(float monoBruto) {
     this.monoBruto = monoBruto;
   }
   public int getNumero() {
     return this.numero;
   }
   public void setNumero(int numero) {
     this.numero = numero;
   }
   public boolean isAllProducts() {
     return this.allProducts;
   }
   public void setAllProducts(boolean allProducts) {
     this.allProducts = allProducts;
   }
 }
