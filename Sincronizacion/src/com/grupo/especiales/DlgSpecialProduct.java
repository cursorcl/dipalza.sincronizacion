package com.grupo.especiales;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import com.grupo.basedatos.RangoEspeciales;
import com.grupo.util.WindowsUtil;

import net.miginfocom.swing.MigLayout;

public class DlgSpecialProduct extends JDialog {
  private static final long serialVersionUID = 1L;
  private JPanel panelNorth;
  private JPanel panelSouth;
  private JPanel pnlWest;
  private JPanel panel_2;
  private JLabel lblExistentes;
  private JScrollPane scrollPane;
  private JList<RangoEspeciales> listExistentes;
  private JPanel pnlInput;
  private JButton btnAdd;
  private JButton btnDel;
  private JLabel lblInicial;
  private JTextField txtInicial;
  private JTextField txtFinal;
  private JLabel lblFinal;
  private JLabel lblRangos;
  private JButton btnAceptar;
  private JButton btnCancelar;
  private JPanel panel_1;
  private JPanel panel_3;
  private JPanel panel_4;
  private JPanel panel_5;
  private SpecialProductControl control;

  /**
   * Contiene la lista de los numerados existentes.
   */
  private DefaultListModel<RangoEspeciales> model = new DefaultListModel<>();

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          DlgSpecialProduct dialog = new DlgSpecialProduct();
          dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
          dialog.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the dialog.
   */
  public DlgSpecialProduct() {
    setTitle("Productos Especiales");
    setSize(499, 268);
    setAlwaysOnTop(true);
    getContentPane().add(getPanel_4(), BorderLayout.EAST);
    getContentPane().add(getPanelNorth(), BorderLayout.NORTH);
    getContentPane().add(getPanelSouth(), BorderLayout.SOUTH);
    getContentPane().add(getPnlWest(), BorderLayout.WEST);
    getContentPane().add(getPanel_3(), BorderLayout.CENTER);
    this.control = null;
    Point center = WindowsUtil.getScreenCenter();
    
    setLocation(center.x - this.getWidth() / 2, center.y - this.getHeight() / 2);
    
  }

  /**
   * Create the dialog.
   */
  public DlgSpecialProduct(SpecialProductControl control) {
    this();
    this.control = control;
    initialize();
      

  }

  private void initialize() {
    setModel(control.especiales);
  }

  private JPanel getPanelNorth() {
    if (panelNorth == null) {
      panelNorth = new JPanel();
    }
    return panelNorth;
  }

  private JPanel getPanelSouth() {
    if (panelSouth == null) {
      panelSouth = new JPanel();
    }
    return panelSouth;
  }

  private JPanel getPnlWest() {
    if (pnlWest == null) {
      pnlWest = new JPanel();
      pnlWest.setBorder(
          new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
      pnlWest.setPreferredSize(new Dimension(150, 10));
      pnlWest.setLayout(new BorderLayout(0, 0));
      pnlWest.add(getPanel_5(), BorderLayout.EAST);
      pnlWest.add(getPanel_3_1(), BorderLayout.WEST);
      pnlWest.add(getPanel_2(), BorderLayout.NORTH);
      pnlWest.add(getScrollPane(), BorderLayout.CENTER);
    }
    return pnlWest;
  }

  private JPanel getPanel_2() {
    if (panel_2 == null) {
      panel_2 = new JPanel();
      panel_2.setBorder(null);
      panel_2.setPreferredSize(new Dimension(10, 25));
      panel_2.add(getLblExistentes());
    }
    return panel_2;
  }

  private JLabel getLblExistentes() {
    if (lblExistentes == null) {
      lblExistentes = new JLabel("Existentes");
    }
    return lblExistentes;
  }

  private JScrollPane getScrollPane() {
    if (scrollPane == null) {
      scrollPane = new JScrollPane();
      scrollPane.setViewportView(getListExistentes());
    }
    return scrollPane;
  }

  private JList<RangoEspeciales> getListExistentes() {
    if (listExistentes == null) {
      listExistentes = new JList<RangoEspeciales>();
    }
    return listExistentes;
  }

  private JPanel getPanel_3() {
    if (pnlInput == null) {
      pnlInput = new JPanel();
      pnlInput.setBorder(
          new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
      pnlInput.setLayout(new MigLayout("", "[grow][][grow][][grow]", "[][][][][][][][grow]"));
      pnlInput.add(getLblRangos(), "cell 0 0 5 1,growx");
      pnlInput.add(getLblInicial(), "cell 2 2,growx");
      pnlInput.add(getLblFinal(), "cell 4 2,growx");
      pnlInput.add(getBtnAdd(), "cell 0 3");
      pnlInput.add(getTxtInicial(), "cell 2 3,growx");
      pnlInput.add(getTxtFinal(), "cell 4 3,growx");
      pnlInput.add(getBtnDel(), "cell 0 4");
      pnlInput.add(getPanel_1_1(), "cell 0 7 5 1,grow");
    }
    return pnlInput;
  }

  private JButton getBtnAdd() {
    if (btnAdd == null) {
      btnAdd = new JButton("<-");
      btnAdd.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          if (txtFinal.getText() == null || txtFinal.getText().isEmpty()
              || txtInicial.getText() == null || txtInicial.getText().isEmpty()) {
            return;
          }
          RangoEspeciales rng = new RangoEspeciales(txtInicial.getText(), txtFinal.getText());
          model.addElement(rng);
          listExistentes.setModel(model);
          txtInicial.setText(null);
          txtFinal.setText(null);
          txtInicial.requestFocus();
        }
      });
    }
    return btnAdd;
  }

  private JButton getBtnDel() {
    if (btnDel == null) {
      btnDel = new JButton("->");
      btnDel.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          int idx = listExistentes.getSelectedIndex();
          if (idx > -1) {
            RangoEspeciales rng = model.getElementAt(idx);
            txtInicial.setText(rng.getArticuloInicial());
            txtFinal.setText(rng.getArticuloFinal());
            model.remove(idx);
            listExistentes.setModel(model);
            txtInicial.requestFocus();
          }
        }
      });
    }
    return btnDel;
  }

  private JLabel getLblInicial() {
    if (lblInicial == null) {
      lblInicial = new JLabel("Inicial");
      lblInicial.setHorizontalAlignment(SwingConstants.CENTER);
    }
    return lblInicial;
  }

  private JTextField getTxtInicial() {
    if (txtInicial == null) {
      txtInicial = new JTextField();
      txtInicial.setColumns(10);
      txtInicial.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent e) {
          txtInicial.select(0, txtInicial.getText().length());
        }});
    }
    return txtInicial;
  }

  private JTextField getTxtFinal() {
    if (txtFinal == null) {
      txtFinal = new JTextField();
      txtFinal.setColumns(10);
      txtFinal.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent e) {
          txtFinal.select(0, txtInicial.getText().length());
        }});
    }
    return txtFinal;
  }

  private JLabel getLblFinal() {
    if (lblFinal == null) {
      lblFinal = new JLabel("Final");
      lblFinal.setHorizontalAlignment(SwingConstants.CENTER);
    }
    return lblFinal;
  }

  private JLabel getLblRangos() {
    if (lblRangos == null) {
      lblRangos = new JLabel("Rango");
      lblRangos.setBorder(
          new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
      lblRangos.setFont(new Font("Tahoma", Font.BOLD, 11));
      lblRangos.setHorizontalAlignment(SwingConstants.CENTER);
    }
    return lblRangos;
  }

  private JButton getBtnAceptar() {
    if (btnAceptar == null) {
      btnAceptar = new JButton("Aceptar");
      btnAceptar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          if (!model.isEmpty()) {
            List<RangoEspeciales> lstRangos = new ArrayList<>();
            for(int n = 0; n < model.size(); n++)
            {
              lstRangos.add(model.getElementAt(n));
            }
            control.setEspeciales(lstRangos);
            control.save();
          }
          setVisible(false);
          dispose();

        }
      });
    }
    return btnAceptar;
  }

  private JButton getBtnCancelar() {
    if (btnCancelar == null) {
      btnCancelar = new JButton("Cancelar");
      btnCancelar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          int resp = JOptionPane.showConfirmDialog(DlgSpecialProduct.this,
              "Se perderán las cambios realizados.", "Confirma cancelar.",
              JOptionPane.OK_CANCEL_OPTION);
          if (resp == JOptionPane.OK_OPTION) {
            setVisible(false);
            dispose();
          }
        }
      });
    }
    return btnCancelar;
  }

  private JPanel getPanel_1_1() {
    if (panel_1 == null) {
      panel_1 = new JPanel();
      panel_1.setBorder(
          new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
      panel_1.add(getBtnCancelar());
      panel_1.add(getBtnAceptar());
    }
    return panel_1;
  }

  private JPanel getPanel_3_1() {
    if (panel_3 == null) {
      panel_3 = new JPanel();
    }
    return panel_3;
  }

  private JPanel getPanel_4() {
    if (panel_4 == null) {
      panel_4 = new JPanel();
    }
    return panel_4;
  }

  private JPanel getPanel_5() {
    if (panel_5 == null) {
      panel_5 = new JPanel();
    }
    return panel_5;
  }

  public void setModel(List<RangoEspeciales> especiales) {
    model.clear();
    for (RangoEspeciales rng : especiales) {
      model.addElement(rng);
    }
    listExistentes.setModel(model);
  }
}
