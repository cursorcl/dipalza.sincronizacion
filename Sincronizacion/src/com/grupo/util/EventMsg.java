 package com.grupo.util;
 
 import java.util.EventObject;
 
 public class EventMsg extends EventObject
 {
   private int operation = 0;
   private String message = null;
   private static final long serialVersionUID = 1L;
 
   public EventMsg(Object arg0, int operation)
   {
     super(arg0);
     this.operation = operation;
     this.message = "";
   }
 
   public EventMsg(Object arg0, String msg) {
     super(arg0);
     this.message = msg;
   }
 
   public EventMsg(Object arg0, int operation, String msg) {
     super(arg0);
     this.message = msg;
     this.operation = operation;
   }
 
   public int getOperation()
   {
     return this.operation;
   }
 
   public String getMessage() {
     return this.message;
   }
 }
