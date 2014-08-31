 package com.grupo.util;
 
 import java.util.Vector;
 
 public class EventEmisor
 {
   protected Vector<EventMsgListener> listeners;
 
   public synchronized void addEventMsgListener(EventMsgListener listener)
   {
     if (this.listeners == null) {
       this.listeners = new Vector();
     }
     this.listeners.add(listener);
   }
 
   public synchronized void removeEventMsgListener(EventMsgListener listener) {
     if (this.listeners != null)
       this.listeners.remove(listener);
   }
 
   public void notify(int operation)
   {
     notify(operation, "");
   }
 
   public void notify(String message) {
     notify(0, message);
   }
 
   public synchronized void notify(int operation, String message)
   {
     if ((this.listeners != null) && (this.listeners.size() > 0)) {
       EventMsg msg = new EventMsg(this, operation, message);
       Vector v = (Vector)this.listeners.clone();
       for (int n = 0; n < v.size(); ++n) {
         EventMsgListener lst = (EventMsgListener)v.elementAt(n);
         lst.onMessage(msg);
       }
     }
   }
 }