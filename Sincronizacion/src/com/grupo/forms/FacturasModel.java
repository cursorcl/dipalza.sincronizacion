 package com.grupo.forms;
 
 import java.text.DecimalFormat;
 import java.util.Vector;
 import javax.swing.table.AbstractTableModel;
 
 public class FacturasModel extends AbstractTableModel
 {
  private static final long serialVersionUID = 7126031323775244990L;

 
   private Vector<FacturaItemModel> data = null;
 
   private String[] columnNames = { "Factura", "Cliente", "Neto", "Iva", "Bruto", "Todos" };
   private DecimalFormat df;
 
   public FacturasModel()
   {
     this.data = new Vector<FacturaItemModel>();
     this.df = ((DecimalFormat)DecimalFormat.getCurrencyInstance());
   }
 
   public int getColumnCount()
   {
     return 6;
   }
 
   public int getRowCount() {
     return (this.data != null) ? this.data.size() : 0;
   }
 
   public Object getValueAt(int rowIndex, int columnIndex) {
     Object result = null;
     FacturaItemModel model = (FacturaItemModel)this.data.elementAt(rowIndex);
     if (model != null) {
       switch (columnIndex)
       {
       case 0:
         result = Integer.valueOf(model.getNumero());
         break;
       case 1:
         result = model.getCliente();
         break;
       case 2:
         result = this.df.format(model.getMontoNeto());
         break;
       case 3:
         result = this.df.format(model.getMontoIva());
         break;
       case 4:
         result = this.df.format(model.getMonoBruto());
         break;
       case 5:
         result = (model.isAllProducts()) ? "SI" : "NO";
       case 6:
       }
 
     }
 
     return result;
   }
 
   public String getColumnName(int column) {
     return this.columnNames[column];
   }
 
   public void add(FacturaItemModel register) {
     this.data.add(register);
     fireTableDataChanged();
   }
 }