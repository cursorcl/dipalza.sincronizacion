package com.grupo.numerados.view;

import java.awt.BorderLayout;

import javax.swing.JDialog;

import com.grupo.numerados.controller.ControladorNumerados;

public class DialogNumerados extends JDialog {
  private static final long serialVersionUID = 1L;

  /**
   * Create the dialog.
   */
  public DialogNumerados(ControladorNumerados controlador) {
    setAlwaysOnTop(true);
    setBounds(100, 100, 624, 550);
    getContentPane().setLayout(new BorderLayout());
    {
      Numerados numerados = new Numerados(controlador);
      getContentPane().add(numerados, BorderLayout.CENTER);

    }
  }

}
