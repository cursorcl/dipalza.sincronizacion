 package com.grupo.forms;
 
 public class ResultDetalle
 {
   float total;
   int result;
   float faltante;
 
   public ResultDetalle()
   {
     this.total = 0.0F;
     this.result = 0;
     this.faltante = 0.0F;
   }
 
   public ResultDetalle(float total, int result, float faltante) {
     this.total = total;
     this.result = result;
     this.faltante = faltante;
   }
 
   public float getFaltante() {
     return this.faltante;
   }
 
   public void setFaltante(float faltante) {
     this.faltante = faltante;
   }
 
   public float getTotal() {
     return this.total;
   }
 
   public void setTotal(float total) {
     this.total = total;
   }
 
   public int getResult() {
     return this.result;
   }
 
   public void setResult(int result) {
     this.result = result;
   }
 }
