package com.grupo.forms;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;

import org.freixas.jcalendar.JCalendar;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class DlgFecha extends JDialog {

  private static final long serialVersionUID = 1L;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          DlgFecha dialog = new DlgFecha();
          dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
          dialog.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  private JCalendar calendar;

  /**
   * Create the dialog.
   */
  public DlgFecha() {
    setMinimumSize(new Dimension(350, 280));
    setMaximumSize(new Dimension(2147483647, 500));
    setSize(new Dimension(350, 280));
    setPreferredSize(new Dimension(350, 280));
    setAlwaysOnTop(true);
    setModal(true);
//    setType(Type.POPUP);
    setTitle("Seleccione Fecha");
    setBounds(100, 100, 320, 230);
    getContentPane().setLayout(new MigLayout("", "[32.00,grow]", "[149.00,grow,top][]"));
    
    calendar = new JCalendar();
    calendar.setFont(new Font("Tahoma", Font.PLAIN, 10));
    calendar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    calendar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
    getContentPane().add(calendar, "cell 0 0,grow");
    
    JPanel panel = new JPanel();
    FlowLayout flowLayout = (FlowLayout) panel.getLayout();
    flowLayout.setAlignment(FlowLayout.RIGHT);
    getContentPane().add(panel, "cell 0 1,grow");
    
    JButton btnCancelar = new JButton("Cancelar");
    panel.add(btnCancelar);
    
    JButton btnAceptar = new JButton("Aceptar");
    panel.add(btnAceptar);
    btnAceptar.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
      }
    });
    btnCancelar.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        calendar.setDate(null);
        setVisible(false);
      }
    });

  }

  public Date getDate()
  {
    return calendar.getDate();
  }
}
