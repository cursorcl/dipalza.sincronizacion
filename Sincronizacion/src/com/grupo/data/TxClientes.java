 package com.grupo.data;
 
 import java.io.DataOutputStream;
 import java.io.FileNotFoundException;
 import java.io.FileOutputStream;
 import java.io.IOException;
 import java.util.Vector;
 
 public class TxClientes
 {
   public void setDataClientes(Vector v)
   {
     try
     {
       FileOutputStream outFile = new FileOutputStream("clientes.dat");
       DataOutputStream outputStream = new DataOutputStream(outFile);
       for (int i = 0; i < v.size(); ++i) {
         outputStream.writeUTF(((DataCliente)v.elementAt(i)).getRut());
         outputStream.writeUTF(((DataCliente)v.elementAt(i)).getRazon());
         outputStream.writeUTF(((DataCliente)v.elementAt(i)).getDireccion());
         outputStream.writeUTF(((DataCliente)v.elementAt(i)).getComuna());
         outputStream.writeUTF(((DataCliente)v.elementAt(i)).getCiudad());
         outputStream.writeUTF(((DataCliente)v.elementAt(i)).getTelefono());
         outputStream.writeUTF(((DataCliente)v.elementAt(i)).getVendedor());
         outputStream.writeUTF(((DataCliente)v.elementAt(i)).getRuta());
       }
       outputStream.close();
     } catch (FileNotFoundException e) {
       e.printStackTrace();
     }
     catch (IOException ioe) {
       ioe.printStackTrace();
     }
   }
 
   public void setDataArticulos(Vector v)
   {
     try
     {
       FileOutputStream outFile = new FileOutputStream("articulos.dat");
       DataOutputStream outputStream = new DataOutputStream(outFile);
       for (int i = 0; i < v.size(); ++i);
       outputStream.close();
     } catch (FileNotFoundException e) {
       e.printStackTrace();
     }
     catch (IOException ioe) {
       ioe.printStackTrace();
     }
   }
 }
