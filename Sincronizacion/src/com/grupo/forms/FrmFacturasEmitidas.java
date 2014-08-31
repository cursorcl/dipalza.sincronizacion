 package com.grupo.forms;
 
 import java.awt.BorderLayout;
 import java.awt.Color;
 import java.awt.Dimension;
 import java.awt.Font;
 import java.awt.GridBagConstraints;
 import java.awt.GridBagLayout;
 import java.awt.Insets;
 import java.awt.SystemColor;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.text.DecimalFormat;
 import javax.swing.BorderFactory;
 import javax.swing.DefaultListModel;
 import javax.swing.JButton;
 import javax.swing.JFrame;
 import javax.swing.JLabel;
 import javax.swing.JList;
 import javax.swing.JOptionPane;
 import javax.swing.JPanel;
 import javax.swing.JScrollPane;
 import javax.swing.JTable;
 import javax.swing.table.TableColumn;
 
 public class FrmFacturasEmitidas extends JFrame
 {
   private static final long serialVersionUID = 1L;
   private JPanel jContentPane = null;
   private JPanel pnlTop = null;
   private JPanel pnlSouth = null;
   private JPanel pnlCenter = null;
   private JLabel lblVendedor = null;
   private JLabel lblNombreVendedor = null;
   private JLabel lblFecha = null;
   private JLabel lblFechaDia = null;
   private JScrollPane scrlVentas = null;
   private JTable tblVentas = null;
   private JLabel lblTotal = null;
   private JLabel lblTotalVenta = null;
   private FacturasModel defaultTableModel = null;
   private JLabel lblIva = null;
   private JLabel lblIvaValue = null;
   private JLabel jLabel1 = null;
   private JLabel lblValueBruto = null;
 
   private float neto = 0.0F;
   private float iva;
   private JButton btnOK = null;
   private JList lstMalos = null;
   private JLabel jLabel2 = null;
   private JLabel lblTitle = null;
   private JScrollPane jScroll;
 
   public FrmFacturasEmitidas()
   {
     initialize();
   }
 
   private void initialize()
   {
     setSize(699, 439);
     setMaximumSize(new Dimension(479, 700));
     setMinimumSize(new Dimension(479, 700));
     setPreferredSize(new Dimension(479, 700));
     setTitle("Facturas Emitidas");
     setContentPane(getJContentPane());
   }
 
   private JPanel getJContentPane()
   {
     if (jContentPane == null) {
       BorderLayout borderLayout = new BorderLayout();
       borderLayout.setHgap(1);
       borderLayout.setVgap(2);
       jContentPane = new JPanel();
       jContentPane.setLayout(borderLayout);
       jContentPane.add(getPnlTop(), "North");
       jContentPane.add(getPnlSouth(), "South");
       jContentPane.add(getPnlCenter(), "Center");
     }
     return jContentPane;
   }
 
   private JPanel getPnlTop()
   {
     if (pnlTop == null) {
       GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
       gridBagConstraints11.anchor = 14;
       gridBagConstraints11.insets = new Insets(5, 2, 5, 5);
       gridBagConstraints11.gridwidth = 1;
       gridBagConstraints11.gridx = 2;
       gridBagConstraints11.gridy = 0;
       gridBagConstraints11.ipadx = 3;
       gridBagConstraints11.weightx = 0.0D;
       gridBagConstraints11.gridheight = 2;
       gridBagConstraints11.fill = 0;
       GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
       gridBagConstraints3.gridx = 1;
       gridBagConstraints3.fill = 0;
       gridBagConstraints3.ipadx = 2;
       gridBagConstraints3.ipady = 6;
       gridBagConstraints3.anchor = 17;
       gridBagConstraints3.weightx = 3.0D;
       gridBagConstraints3.insets = new Insets(1, 1, 1, 1);
       gridBagConstraints3.gridy = 2;
       lblFechaDia = new JLabel();
       lblFechaDia.setText("");
       lblFechaDia.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
       lblFechaDia.setMaximumSize(new Dimension(120, 25));
       lblFechaDia.setMinimumSize(new Dimension(120, 16));
       lblFechaDia.setPreferredSize(new Dimension(120, 16));
       GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
       gridBagConstraints2.gridx = 0;
       gridBagConstraints2.fill = 0;
       gridBagConstraints2.ipadx = 2;
       gridBagConstraints2.ipady = 2;
       gridBagConstraints2.anchor = 17;
       gridBagConstraints2.weightx = 1.0D;
       gridBagConstraints2.insets = new Insets(0, 20, 0, 0);
       gridBagConstraints2.gridy = 2;
       lblFecha = new JLabel();
       lblFecha.setText("Fecha");
       GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
       gridBagConstraints1.gridx = 1;
       gridBagConstraints1.gridwidth = 1;
       gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
       gridBagConstraints1.weightx = 3.0D;
       gridBagConstraints1.weighty = 0.0D;
       gridBagConstraints1.ipadx = 2;
       gridBagConstraints1.ipady = 2;
       gridBagConstraints1.anchor = 17;
       gridBagConstraints1.insets = new Insets(1, 1, 1, 15);
       gridBagConstraints1.gridy = 1;
       lblNombreVendedor = new JLabel();
       lblNombreVendedor.setText("");
       lblNombreVendedor.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
       lblNombreVendedor.setMinimumSize(new Dimension(120, 16));
       lblNombreVendedor.setMaximumSize(new Dimension(120, 16));
       lblNombreVendedor.setPreferredSize(new Dimension(120, 16));
       GridBagConstraints gridBagConstraints = new GridBagConstraints();
       gridBagConstraints.gridx = 0;
       gridBagConstraints.ipadx = 2;
       gridBagConstraints.ipady = 2;
       gridBagConstraints.fill = 0;
       gridBagConstraints.anchor = 17;
       gridBagConstraints.weightx = 1.0D;
       gridBagConstraints.insets = new Insets(0, 20, 0, 0);
       gridBagConstraints.gridy = 1;
       lblVendedor = new JLabel();
       lblVendedor.setText("Vendedor");
       pnlTop = new JPanel();
       pnlTop.setLayout(new GridBagLayout());
       pnlTop.setPreferredSize(new Dimension(50, 60));
       pnlTop.add(lblVendedor, gridBagConstraints);
       pnlTop.add(lblNombreVendedor, gridBagConstraints1);
       pnlTop.add(lblFecha, gridBagConstraints2);
       pnlTop.add(lblFechaDia, gridBagConstraints3);
       pnlTop.add(getBtnOK(), gridBagConstraints11);
     }
     return pnlTop;
   }
 
   private JPanel getPnlSouth()
   {
     if (pnlSouth == null) {
       GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
       gridBagConstraints12.gridx = 6;
       gridBagConstraints12.weightx = 3.0D;
       gridBagConstraints12.gridy = 0;
       lblTitle = new JLabel();
       lblTitle.setText("Elementos que no tienen stock suficiente");
       GridBagConstraints gridBagConstraints16 = new GridBagConstraints();
       gridBagConstraints16.gridx = 5;
       gridBagConstraints16.gridy = 8;
       jLabel2 = new JLabel();
       jLabel2.setText("");
       GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
       gridBagConstraints14.fill = 1;
       gridBagConstraints14.gridy = 1;
       gridBagConstraints14.weightx = 2.0D;
       gridBagConstraints14.weighty = 5.0D;
       gridBagConstraints14.ipady = 5;
       gridBagConstraints14.gridheight = 8;
       gridBagConstraints14.gridwidth = 2;
       gridBagConstraints14.ipadx = 2;
       gridBagConstraints14.insets = new Insets(0, 5, 5, 5);
       gridBagConstraints14.anchor = 11;
       gridBagConstraints14.gridx = 6;
 
       GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
       gridBagConstraints10.gridx = 3;
       gridBagConstraints10.anchor = 17;
       gridBagConstraints10.insets = new Insets(1, 0, 0, 0);
       gridBagConstraints10.gridwidth = 2;
       gridBagConstraints10.weightx = 2.0D;
       gridBagConstraints10.fill = 2;
       gridBagConstraints10.gridy = 3;
       lblValueBruto = new JLabel();
       lblValueBruto.setText("0");
       lblValueBruto.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
       lblValueBruto.setHorizontalAlignment(4);
       lblValueBruto.setPreferredSize(new Dimension(120, 16));
       GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
       gridBagConstraints9.gridx = 2;
       gridBagConstraints9.anchor = 17;
       gridBagConstraints9.insets = new Insets(0, 5, 0, 0);
       gridBagConstraints9.gridy = 3;
       jLabel1 = new JLabel();
       jLabel1.setText("Total Bruto");
       GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
       gridBagConstraints8.gridx = 3;
       gridBagConstraints8.weightx = 2.0D;
       gridBagConstraints8.anchor = 17;
       gridBagConstraints8.insets = new Insets(1, 0, 0, 0);
       gridBagConstraints8.gridwidth = 2;
       gridBagConstraints8.fill = 2;
       gridBagConstraints8.gridy = 2;
       lblIvaValue = new JLabel();
       lblIvaValue.setText("0");
       lblIvaValue.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
       lblIvaValue.setHorizontalAlignment(4);
       lblIvaValue.setPreferredSize(new Dimension(120, 16));
       GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
       gridBagConstraints7.gridx = 2;
       gridBagConstraints7.anchor = 17;
       gridBagConstraints7.insets = new Insets(0, 5, 0, 0);
       gridBagConstraints7.gridy = 2;
       GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
       gridBagConstraints6.gridx = 3;
       gridBagConstraints6.weightx = 2.0D;
       gridBagConstraints6.anchor = 17;
       gridBagConstraints6.insets = new Insets(1, 0, 0, 0);
       gridBagConstraints6.gridwidth = 2;
       gridBagConstraints6.fill = 2;
       gridBagConstraints6.gridy = 1;
       lblTotalVenta = new JLabel();
       lblTotalVenta.setText("0");
       lblTotalVenta.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
       lblTotalVenta.setHorizontalAlignment(4);
       lblTotalVenta.setPreferredSize(new Dimension(120, 16));
       GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
       gridBagConstraints5.gridx = 2;
       gridBagConstraints5.weightx = 0.0D;
       gridBagConstraints5.anchor = 17;
       gridBagConstraints5.insets = new Insets(0, 5, 0, 0);
       gridBagConstraints5.gridy = 1;
       lblTotal = new JLabel();
       lblTotal.setText("Total Venta Neto");
       pnlSouth = new JPanel();
       pnlSouth.setLayout(new GridBagLayout());
       pnlSouth.setPreferredSize(new Dimension(50, 150));
       pnlSouth.setMinimumSize(new Dimension(158, 90));
       pnlSouth.add(lblTotal, gridBagConstraints5);
       pnlSouth.add(lblTotalVenta, gridBagConstraints6);
       pnlSouth.add(getLblIva(), gridBagConstraints7);
       pnlSouth.add(lblIvaValue, gridBagConstraints8);
       pnlSouth.add(jLabel1, gridBagConstraints9);
       pnlSouth.add(lblValueBruto, gridBagConstraints10);
       pnlSouth.add(getJScrollPane(), gridBagConstraints14);
       pnlSouth.add(jLabel2, gridBagConstraints16);
       pnlSouth.add(lblTitle, gridBagConstraints12);
     }
     return pnlSouth;
   }
 
   private JPanel getPnlCenter()
   {
     if (pnlCenter == null) {
       GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
       gridBagConstraints4.fill = 1;
       gridBagConstraints4.gridy = 0;
       gridBagConstraints4.weightx = 1.0D;
       gridBagConstraints4.weighty = 1.0D;
       gridBagConstraints4.insets = new Insets(0, 5, 0, 5);
       gridBagConstraints4.gridx = 0;
       pnlCenter = new JPanel();
       pnlCenter.setLayout(new GridBagLayout());
       pnlCenter.add(getScrlVentas(), gridBagConstraints4);
     }
     return pnlCenter;
   }
 
   private JScrollPane getScrlVentas()
   {
     if (scrlVentas == null) {
       scrlVentas = new JScrollPane();
       scrlVentas.setViewportView(getTblVentas());
     }
     return scrlVentas;
   }
 
   private JTable getTblVentas()
   {
     if (tblVentas == null)
     {
       defaultTableModel = new FacturasModel();
 
       tblVentas = new JTable();
 
       tblVentas.setBackground(SystemColor.controlHighlight);
       tblVentas.setIntercellSpacing(new Dimension(2, 2));
       tblVentas.setRowHeight(18);
       tblVentas.setRowSelectionAllowed(false);
       tblVentas.setSelectionMode(0);
       tblVentas.setShowGrid(true);
       tblVentas.setShowVerticalLines(false);
       tblVentas.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
       tblVentas.setModel(defaultTableModel);
       tblVentas.setFont(new Font("Dialog", 0, 10));
 
       TableColumn tc = tblVentas.getColumn(tblVentas.getColumnName(0));
       tc.setPreferredWidth(100);
       tc.setResizable(false);
       tc = tblVentas.getColumn(tblVentas.getColumnName(1));
       tc.setPreferredWidth(300);
       tc.setResizable(false);
 
       tc = tblVentas.getColumn(tblVentas.getColumnName(5));
       tc.setPreferredWidth(50);
       tc.setResizable(false);
     }
     return tblVentas;
   }
 
   public void addItemVenta(FacturaItemModel item) {
     defaultTableModel.add(item);
   }
 
   public void addItemFallido(String item) {
     ((DefaultListModel)lstMalos.getModel()).addElement(item);
   }
 
   public void setVendedor(String vendedor) {
     lblNombreVendedor.setText(vendedor);
   }
 
   public void setFecha(String fecha) {
     lblFechaDia.setText(fecha);
   }
 
   public void seTotalVenta(String valor) {
     lblTotalVenta.setText(valor);
   }
 
   private JLabel getLblIva()
   {
     if (lblIva == null) {
       lblIva = new JLabel();
       lblIva.setText("Total Iva");
     }
     return lblIva;
   }
 
   public void setIva(float value) {
     iva = value;
   }
 
   public void addNeto(float value) {
     neto += value;
     float totalIva = iva / 100.0F * neto;
     float totalBruto = neto + totalIva;
     DecimalFormat df = new DecimalFormat("###,##0");
 
     lblTotalVenta.setText(df.format(neto));
     lblIvaValue.setText(df.format(totalIva));
     lblValueBruto.setText(df.format(totalBruto));
     repaint();
   }
 
   private JButton getBtnOK()
   {
     if (btnOK == null) {
       btnOK = new JButton();
       btnOK.setText("Cerrar");
       btnOK.setPreferredSize(new Dimension(100, 26));
       btnOK.setMaximumSize(new Dimension(100, 26));
       btnOK.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	dispose();
         }
       });
     }
     return btnOK;
   }
 
   private JList getLstMalos()
   {
     if (lstMalos == null) {
       lstMalos = new JList();
       lstMalos.setModel(new DefaultListModel());
       lstMalos.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
     }
     return lstMalos;
   }
 
   private JScrollPane getJScrollPane()
   {
     if (jScroll == null) {
       jScroll = new JScrollPane();
       jScroll.setViewportView(getLstMalos());
     }
     return jScroll;
   }
 
   public static void main(String[] args)
   {
     FrmFacturasEmitidas frm = new FrmFacturasEmitidas();
     frm.setDefaultCloseOperation(3);
     frm.setVisible(true);
   }
 
   public void message(String message, String title) {
     JOptionPane.showMessageDialog(this, message, title, 1);
   }
 }
