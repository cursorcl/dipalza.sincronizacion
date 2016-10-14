 package com.grupo.forms;
 
 import com.grupo.data.DataSQL;
import com.grupo.util.WindowsUtil;

import java.awt.Dimension;
 import java.awt.Font;
 import java.awt.Frame;
 import java.awt.GridBagConstraints;
 import java.awt.GridBagLayout;
 import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import javax.swing.JButton;
 import javax.swing.JDialog;
 import javax.swing.JFormattedTextField;
 import javax.swing.JLabel;
 import javax.swing.JPanel;
 
 public class DlgClonarFactura extends JDialog
 {
   private static final long serialVersionUID = 1L;
   private JPanel jContentPane = null;
 
   private JFormattedTextField txtOldFactura = null;
 
   private JLabel lblOldFactura = null;
 
   private JLabel lblNewFactura = null;
 
   private JFormattedTextField txtNewFactura = null;
 
   private JButton btnAceptar = null;
 
   private JButton btnCancelar = null;
 
   public DlgClonarFactura(Frame owner)
   {
     super(owner);
     initialize();
   }
 
   private void initialize()
   {
     setSize(340, 166);
     setTitle("Copia Factura");
     setContentPane(getJContentPane());
     Point center = WindowsUtil.getScreenCenter();
     setLocation(center.x - this.getWidth() / 2, center.y - this.getHeight() / 2);
   }
 
   private JPanel getJContentPane()
   {
     if (this.jContentPane == null) {
       GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
       gridBagConstraints5.gridx = 2;
       gridBagConstraints5.insets = new Insets(20, 0, 0, 15);
       gridBagConstraints5.gridy = 2;
       GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
       gridBagConstraints4.gridx = 1;
       gridBagConstraints4.insets = new Insets(20, 0, 0, 0);
       gridBagConstraints4.gridy = 2;
       GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
       gridBagConstraints3.fill = 1;
       gridBagConstraints3.gridy = 1;
       gridBagConstraints3.weightx = 1.0D;
       gridBagConstraints3.insets = new Insets(0, 3, 0, 15);
       gridBagConstraints3.gridwidth = 2;
       gridBagConstraints3.anchor = 17;
       gridBagConstraints3.gridx = 1;
       GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
       gridBagConstraints2.gridx = 0;
       gridBagConstraints2.insets = new Insets(0, 30, 0, 2);
       gridBagConstraints2.anchor = 17;
       gridBagConstraints2.fill = 2;
       gridBagConstraints2.gridy = 1;
       this.lblNewFactura = new JLabel();
       this.lblNewFactura.setText("Factura Generada");
       GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
       gridBagConstraints1.gridx = 0;
       gridBagConstraints1.insets = new Insets(0, 30, 0, 2);
       gridBagConstraints1.anchor = 17;
       gridBagConstraints1.fill = 2;
       gridBagConstraints1.gridy = 0;
       this.lblOldFactura = new JLabel();
       this.lblOldFactura.setText("Factura a Copiar");
       GridBagConstraints gridBagConstraints = new GridBagConstraints();
       gridBagConstraints.fill = 1;
       gridBagConstraints.gridy = 0;
       gridBagConstraints.weightx = 1.0D;
       gridBagConstraints.insets = new Insets(0, 3, 0, 15);
       gridBagConstraints.gridwidth = 2;
       gridBagConstraints.anchor = 17;
       gridBagConstraints.gridx = 1;
       this.jContentPane = new JPanel();
       this.jContentPane.setLayout(new GridBagLayout());
       this.jContentPane.add(getTxtOldFactura(), gridBagConstraints);
       this.jContentPane.add(this.lblOldFactura, gridBagConstraints1);
       this.jContentPane.add(this.lblNewFactura, gridBagConstraints2);
       this.jContentPane.add(getTxtNewFactura(), gridBagConstraints3);
       this.jContentPane.add(getBtnAceptar(), gridBagConstraints4);
       this.jContentPane.add(getBtnCancelar(), gridBagConstraints5);
     }
     return this.jContentPane;
   }
 
   private JFormattedTextField getTxtOldFactura()
   {
     if (this.txtOldFactura == null)
       try {
         this.txtOldFactura = new JFormattedTextField();
         this.txtOldFactura.setPreferredSize(new Dimension(150, 20));
         this.txtOldFactura.setMaximumSize(new Dimension(150, 20));
         this.txtOldFactura.setMinimumSize(new Dimension(150, 20));
       }
       catch (Throwable localThrowable)
       {
       }
     return this.txtOldFactura;
   }
 
   private JFormattedTextField getTxtNewFactura()
   {
     if (this.txtNewFactura == null)
       try {
         this.txtNewFactura = new JFormattedTextField();
         this.txtNewFactura.setMinimumSize(new Dimension(150, 20));
         this.txtNewFactura.setMaximumSize(new Dimension(150, 20));
         this.txtNewFactura.setEditable(false);
         this.txtNewFactura.setPreferredSize(new Dimension(150, 20));
       }
       catch (Throwable localThrowable)
       {
       }
     return this.txtNewFactura;
   }
 
   private JButton getBtnAceptar()
   {
     if (this.btnAceptar == null)
       try {
         this.btnAceptar = new JButton();
         this.btnAceptar.setPreferredSize(new Dimension(90, 26));
         this.btnAceptar.setMaximumSize(new Dimension(90, 26));
         this.btnAceptar.setText("Procesar");
         this.btnAceptar.setFont(new Font("Dialog", 1, 10));
         this.btnAceptar.setMinimumSize(new Dimension(90, 26));
         this.btnAceptar.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
             DlgClonarFactura.this.txtNewFactura.setText(DataSQL.getInstance().clonarFactura(DlgClonarFactura.this.txtOldFactura.getText()));
           }
         });
       }
       catch (Throwable localThrowable)
       {
       }
     return this.btnAceptar;
   }
 
   private JButton getBtnCancelar()
   {
     if (this.btnCancelar == null) {
       try {
         this.btnCancelar = new JButton();
         this.btnCancelar.setPreferredSize(new Dimension(90, 26));
         this.btnCancelar.setMaximumSize(new Dimension(90, 26));
         this.btnCancelar.setText("Cerrar");
         this.btnCancelar.setFont(new Font("Dialog", 1, 10));
         this.btnCancelar.setMinimumSize(new Dimension(90, 26));
         this.btnCancelar.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
             DlgClonarFactura.this.setVisible(false);
           }
         });
       }
       catch (Throwable localThrowable)
       {
       }
     }
     return this.btnCancelar;
   }
 
   public void clear() {
     this.txtNewFactura.setText("");
     this.txtOldFactura.setText("");
   }
 }
