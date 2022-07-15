package com.grupo.numerados.view.delete;

import java.awt.BorderLayout;
import java.awt.Point;

import javax.swing.JDialog;

import com.grupo.numerados.view.delete.controller.ControladorDeleteNumerados;
import com.grupo.util.WindowsUtil;

public class DialogDeleteNumerados extends JDialog {
  private static final long serialVersionUID = 1L;

  /**
   * Create the dialog.
   */
  public DialogDeleteNumerados(ControladorDeleteNumerados controlador) {
  	setType(Type.UTILITY);
  	setModalityType(ModalityType.APPLICATION_MODAL);
    setAlwaysOnTop(true);
    setSize(624, 550);
    getContentPane().setLayout(new BorderLayout());
    {
      DeleteNumerados numerados = new DeleteNumerados(controlador);
      getContentPane().add(numerados, BorderLayout.CENTER);

    }
    Point center = WindowsUtil.getScreenCenter();
    setLocation(center.x - this.getWidth() / 2, center.y - this.getHeight() / 2);
  }

}
