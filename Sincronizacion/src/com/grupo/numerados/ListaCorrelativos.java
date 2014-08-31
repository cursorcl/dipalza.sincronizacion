 package com.grupo.numerados;
 
 public class ListaCorrelativos
 {
   private String articulo = null;
 
   private int correlativo = 0;
 
   private float pesoQueso = 0.0F;
 
   public ListaCorrelativos(String articulo, int correlativo, float pesoQueso)
   {
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
 
   public String toString()
   {
     return String.valueOf(this.correlativo);
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
 }
