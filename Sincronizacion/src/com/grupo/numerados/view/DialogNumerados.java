package com.grupo.numerados.view;

import java.awt.BorderLayout;
import java.awt.Point;

import javax.swing.JDialog;

import com.grupo.numerados.controller.ControladorNumerados;
import com.grupo.util.WindowsUtil;
import java.awt.Dialog.ModalityType;
import java.awt.Window.Type;

public class DialogNumerados extends JDialog {
  private static final long serialVersionUID = 1L;

  /**
   * Create the dialog.
   */
  public DialogNumerados(ControladorNumerados controlador) {
  	setType(Type.UTILITY);
  	setModalityType(ModalityType.APPLICATION_MODAL);
    setAlwaysOnTop(true);
    setSize(624, 550);
    getContentPane().setLayout(new BorderLayout());
    {
      Numerados numerados = new Numerados(controlador);
      getContentPane().add(numerados, BorderLayout.CENTER);

    }
    Point center = WindowsUtil.getScreenCenter();
    setLocation(center.x - this.getWidth() / 2, center.y - this.getHeight() / 2);
  }

}
