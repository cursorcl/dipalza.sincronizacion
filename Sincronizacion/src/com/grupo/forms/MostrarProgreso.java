package com.grupo.forms;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

public class MostrarProgreso extends JDialog {

  private static final long serialVersionUID = 1L;
  private final JPanel contentPanel = new JPanel();
  private JLabel lblNewLabel;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    try {
      MostrarProgreso dialog = new MostrarProgreso();
      dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      dialog.setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Create the dialog.
   */
  public MostrarProgreso() {
    initialize();
  }

  private void initialize() {
    getContentPane().setBackground(new Color(255, 255, 255));
    setBackground(new Color(255, 255, 255));
    setUndecorated(true);
    setResizable(false);
    setBounds(100, 100, 66, 66);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setAlignmentY(0.0f);
    contentPanel.setAlignmentX(0.0f);
    contentPanel.setBackground(new Color(128, 128, 128));
    contentPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(128, 128, 128)));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(new BorderLayout(0, 0));
    contentPanel.add(getLblNewLabel(), BorderLayout.CENTER);
  }



  private JLabel getLblNewLabel() {
    if (lblNewLabel == null) {
      lblNewLabel = new JLabel("");
      lblNewLabel
          .setIcon(new ImageIcon(MostrarProgreso.class.getResource("/imagenes/balls64.gif")));
    }
    return lblNewLabel;
  }
}
