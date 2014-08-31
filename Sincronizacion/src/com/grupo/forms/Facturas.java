 package com.grupo.forms;
 
 import java.awt.BorderLayout;
 import java.awt.Dimension;
 import java.awt.FlowLayout;
 import java.awt.Frame;
 import java.awt.GridBagLayout;
 import javax.swing.JButton;
 import javax.swing.JPanel;
 import javax.swing.JScrollPane;
 import javax.swing.JTable;
 
 public class Facturas extends Frame
 {
   private static final long serialVersionUID = 1L;
   private JPanel pnlNorte = null;
   private JPanel pnlSur = null;
   private JPanel pnlEste = null;
   private JPanel pnlOeste = null;
   private JPanel pnlCentro = null;
   private JScrollPane scrlTable = null;
   private JTable tblFacturas = null;
   private JButton btnOk = null;
 
   private JPanel getPnlNorte()
   {
     if (this.pnlNorte == null) {
       this.pnlNorte = new JPanel();
       this.pnlNorte.setLayout(new GridBagLayout());
     }
     return this.pnlNorte;
   }
 
   private JPanel getPnlSur()
   {
     if (this.pnlSur == null) {
       this.pnlSur = new JPanel();
       this.pnlSur.setLayout(new FlowLayout());
       this.pnlSur.setPreferredSize(new Dimension(50, 50));
       this.pnlSur.add(getBtnOk(), null);
     }
     return this.pnlSur;
   }
 
   private JPanel getPnlEste()
   {
     if (this.pnlEste == null) {
       this.pnlEste = new JPanel();
       this.pnlEste.setLayout(new GridBagLayout());
     }
     return this.pnlEste;
   }
 
   private JPanel getPnlOeste()
   {
     if (this.pnlOeste == null) {
       this.pnlOeste = new JPanel();
       this.pnlOeste.setLayout(new GridBagLayout());
     }
     return this.pnlOeste;
   }
 
   private JPanel getPnlCentro()
   {
     if (this.pnlCentro == null) {
       this.pnlCentro = new JPanel();
       this.pnlCentro.setLayout(new BorderLayout());
       this.pnlCentro.add(getScrlTable(), "Center");
     }
     return this.pnlCentro;
   }
 
   private JScrollPane getScrlTable()
   {
     if (this.scrlTable == null) {
       this.scrlTable = new JScrollPane();
       this.scrlTable.setViewportView(getTblFacturas());
     }
     return this.scrlTable;
   }
 
   private JTable getTblFacturas()
   {
     if (this.tblFacturas == null) {
       this.tblFacturas = new JTable();
     }
     return this.tblFacturas;
   }
 
   private JButton getBtnOk()
   {
     if (this.btnOk == null) {
       this.btnOk = new JButton();
       this.btnOk.setText("Aceptar");
     }
     return this.btnOk;
   }
 
   public static void main(String[] args)
   {
   }
 
   public Facturas()
   {
     initialize();
   }
 
   private void initialize()
   {
     setSize(566, 342);
     setTitle("Facturas Generadas");
 
     add(getPnlNorte(), "North");
     add(getPnlSur(), "South");
     add(getPnlEste(), "East");
     add(getPnlOeste(), "West");
     add(getPnlCentro(), "Center");
   }
 }