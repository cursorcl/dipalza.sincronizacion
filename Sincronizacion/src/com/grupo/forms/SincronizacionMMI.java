package com.grupo.forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Date;
import java.util.EventObject;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.freixas.jcalendar.DateEvent;
import org.freixas.jcalendar.DateListener;
import org.freixas.jcalendar.JCalendarCombo;

import cl.eos.util.Utils;

import com.grupo.biblioteca.server.ConnectionServer;
import com.grupo.biblioteca.server.events.ConnectionServerEvent;
import com.grupo.biblioteca.server.events.Notificable;
import com.grupo.data.ProcessorServer;
import com.grupo.forms.report.HojaRutaExcel;
import com.grupo.numerados.controller.ControladorNumerados;
import com.grupo.numerados.view.DialogNumerados;
import com.grupo.util.EventMsg;
import com.grupo.util.EventMsgListener;
import com.grupo.utilitarios.FechaFormateada;

public class SincronizacionMMI extends JFrame implements EventMsgListener, Notificable {
  private static final long serialVersionUID = 1L;
  static Logger logger = Logger.getLogger(SincronizacionMMI.class);

  private JPanel jPanel = null;
  private JPanel jPanel2 = null;
  private JPanel jPanel3 = null;
  private ProcessorServer data = null;
  private JList<String> lstMessages = null;

  private DefaultListModel<String> model = new DefaultListModel<String>();
  private DlgClonarFactura dlg = null;
  private JButton btnClear = null;
  private JScrollPane jScrollPane = null;
  private JCalendarCombo cmbFechaFacturacion = null;
  private JLabel lblFecha = null;
  private JMenuBar mnuSistema = null;
  private JMenu mnuPPal = null;
  private JMenuItem mnuReporte = null;
  // private JMenuItem mnuCreditos = null;
  private JMenuItem mnuNumerados = null;
  private JMenuItem mnuClonar = null;
  private JMenuItem mnuSalir = null;
  private JSeparator jSeparator = null;

  public static Date fechaFacturacion = new Date(System.currentTimeMillis());
  public static Date fechaReporte = new Date(System.currentTimeMillis());

  public static Properties PROPERTIES;

  private DlgFecha dlgFecha = new DlgFecha();
  private Logger log = Logger.getLogger(SincronizacionMMI.class);
  public SincronizacionMMI() {
    setAlwaysOnTop(true);
    setTitle("VENTAS DIPALZA");
    initialize();
    Properties logProperties = new Properties();
    try {
      logProperties.load(super.getClass().getResourceAsStream("/log4j.properties"));
      PropertyConfigurator.configure(logProperties);


      PROPERTIES = new Properties();
      log.debug(Utils.getDefaultDirectory()  + "/sqlserver.properties");
      File fProp =  new File(Utils.getDefaultDirectory()  + "/sqlserver.properties");
      if (fProp.exists()) {
        log.debug("Archivo de propiedades encontrado correctamente");
        PROPERTIES.load(new FileReader(fProp));
      }
      else
      {
        log.debug("Archivo de propiedades NO encontrado");
      }
      

    } catch (IOException e) {
      BasicConfigurator.configure();
    }


    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    ConnectionServer server = new ConnectionServer(PROPERTIES);
    server.addNotificable(this);
    this.data =
        new ProcessorServer(new FechaFormateada(this.cmbFechaFacturacion.getDate()), server);
    this.data.addEventMsgListener(this);
    // HojaRuta.getInstance().addEventMsgListener(this);
  }

  private void initialize() {
    setSize(new Dimension(556, 410));
    this.setJMenuBar(getMnuSistema());
    setContentPane(getJPanel());
    graphicInit();
    setResizable(false);
  }

  private JPanel getJPanel() {
    if (this.jPanel == null) {
      this.jPanel = new JPanel();
      this.jPanel.setLayout(new BorderLayout());
      this.jPanel.add(getJPanel2(), BorderLayout.NORTH);
      this.jPanel.add(getJPanel3(), BorderLayout.CENTER);
    }
    return this.jPanel;
  }

  private JPanel getJPanel2() {
    if (this.jPanel2 == null) {
      GridBagConstraints gridBagConstraints41 = new GridBagConstraints();
      gridBagConstraints41.anchor = GridBagConstraints.CENTER;
      gridBagConstraints41.insets = new Insets(3, 3, 0, 5);
      gridBagConstraints41.gridheight = 3;
      gridBagConstraints41.gridwidth = 1;
      gridBagConstraints41.gridx = 4;
      gridBagConstraints41.gridy = 1;
      gridBagConstraints41.weightx = 1.0D;
      gridBagConstraints41.fill = GridBagConstraints.NONE;
      GridBagConstraints gridBagConstraints61 = new GridBagConstraints();
      gridBagConstraints61.gridx = 0;
      gridBagConstraints61.fill = GridBagConstraints.HORIZONTAL;
      gridBagConstraints61.gridwidth = 6;
      gridBagConstraints61.gridy = 0;
      GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
      gridBagConstraints13.gridx = 4;
      gridBagConstraints13.gridwidth = 1;
      gridBagConstraints13.anchor = 17;
      gridBagConstraints13.fill = 2;
      gridBagConstraints13.insets = new Insets(5, 0, 0, 0);
      gridBagConstraints13.gridy = 0;
      GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
      gridBagConstraints6.gridx = 6;
      gridBagConstraints6.ipadx = 4;
      gridBagConstraints6.ipady = 0;
      gridBagConstraints6.anchor = 17;
      gridBagConstraints6.insets = new Insets(5, 0, 0, 10);
      gridBagConstraints6.fill = 1;
      gridBagConstraints6.gridy = 1;
      GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
      gridBagConstraints5.gridx = 2;
      gridBagConstraints5.ipady = 0;
      gridBagConstraints5.gridwidth = 4;
      gridBagConstraints5.anchor = 17;
      gridBagConstraints5.fill = 1;
      gridBagConstraints5.insets = new Insets(5, 0, 0, 0);
      gridBagConstraints5.gridy = 1;
      GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
      gridBagConstraints4.gridwidth = 1;
      gridBagConstraints4.gridy = 1;
      gridBagConstraints4.ipadx = 0;
      gridBagConstraints4.anchor = 17;
      gridBagConstraints4.insets = new Insets(5, 9, 0, 0);
      gridBagConstraints4.fill = 1;
      gridBagConstraints4.gridx = 1;
      this.jPanel2 = new JPanel();
      GridBagLayout gbl_jPanel2 = new GridBagLayout();
      gbl_jPanel2.columnWeights = new double[] {1.0, 0.0, 1.0};
      gbl_jPanel2.columnWidths = new int[] {0, 100, 0};
      this.jPanel2.setLayout(gbl_jPanel2);
      this.jPanel2.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
      this.jPanel2.setMinimumSize(new Dimension(577, 75));
      this.jPanel2.setMaximumSize(new Dimension(577, 75));
      this.jPanel2.setPreferredSize(new Dimension(577, 75));
      GridBagConstraints gridBagConstraints71 = new GridBagConstraints();
      gridBagConstraints71.gridx = 1;
      gridBagConstraints71.fill = GridBagConstraints.NONE;
      gridBagConstraints71.insets = new Insets(3, 3, 5, 5);
      gridBagConstraints71.gridy = 0;
      this.lblFecha = new JLabel();
      this.lblFecha.setText("Fecha Facturación");
      jPanel2.add(lblFecha, gridBagConstraints71);
      GridBagConstraints gridBagConstraints = new GridBagConstraints();
      gridBagConstraints.fill = GridBagConstraints.BOTH;
      gridBagConstraints.gridy = 1;
      gridBagConstraints.weightx = 1.0D;
      gridBagConstraints.gridwidth = 1;
      gridBagConstraints.anchor = GridBagConstraints.CENTER;
      gridBagConstraints.insets = new Insets(3, 10, 0, 5);
      gridBagConstraints.gridx = 1;
      jPanel2.add(getCmbFechaFacturacion(), gridBagConstraints);
    }
    return this.jPanel2;
  }

  private JPanel getJPanel3() {
    if (this.jPanel3 == null) {
      GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
      gridBagConstraints21.fill = 1;
      gridBagConstraints21.weighty = 1.0D;
      gridBagConstraints21.insets = new Insets(5, 5, 5, 5);
      gridBagConstraints21.gridwidth = 1;
      gridBagConstraints21.weightx = 1.0D;
      GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
      gridBagConstraints12.gridx = 1;
      gridBagConstraints12.fill = 3;
      gridBagConstraints12.insets = new Insets(5, 5, 5, 5);
      gridBagConstraints12.gridy = 0;
      GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
      gridBagConstraints11.gridx = 0;
      gridBagConstraints11.gridheight = 3;
      gridBagConstraints11.gridy = 0;
      this.jPanel3 = new JPanel();
      this.jPanel3.setLayout(new GridBagLayout());
      this.jPanel3.setPreferredSize(new Dimension(510, 210));
      this.jPanel3.setMinimumSize(new Dimension(510, 60));
      this.jPanel3.setMaximumSize(new Dimension(510, 60));
      this.jPanel3.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
      jPanel3.add(getJScrollPane(), gridBagConstraints21);
      this.jPanel3.add(getBtnClear(), gridBagConstraints12);
    }
    return this.jPanel3;
  }

  private JList<String> getLstMessages() {
    if (this.lstMessages == null) {
      this.lstMessages = new JList<String>(this.model);
    }
    return this.lstMessages;
  }

  private JButton getBtnClear() {
    if (this.btnClear == null) {
      this.btnClear = new JButton();
      this.btnClear.setText("Limpiar");
      this.btnClear.setFont(new Font("Dialog", 1, 10));
      this.btnClear.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          model.clear();
        }
      });
    }
    return this.btnClear;
  }

  private JScrollPane getJScrollPane() {
    if (this.jScrollPane == null) {
      this.jScrollPane = new JScrollPane();
      this.jScrollPane.setViewportView(getLstMessages());
    }
    return this.jScrollPane;
  }

  private JCalendarCombo getCmbFechaFacturacion() {
    if (this.cmbFechaFacturacion == null) {
      this.cmbFechaFacturacion = new JCalendarCombo();
      cmbFechaFacturacion.setFont(new Font("Dialog", Font.BOLD, 10));
      cmbFechaFacturacion.setMaximumSize(new Dimension(161, 23));
      this.cmbFechaFacturacion.addDateListener(new DateListener() {
        public void dateChanged(DateEvent e) {
          if (SincronizacionMMI.this.data != null) {
            FechaFormateada f = new FechaFormateada();
            f.setTime(SincronizacionMMI.this.cmbFechaFacturacion.getDate().getTime());
            data.setFecha(f);
            fechaFacturacion = cmbFechaFacturacion.getDate();
          }
        }
      });
    }
    return this.cmbFechaFacturacion;
  }

  /**
   * This method initializes mnuSistema
   * 
   * @return javax.swing.JMenuBar
   */
  private JMenuBar getMnuSistema() {
    if (mnuSistema == null) {
      mnuSistema = new JMenuBar();
      mnuSistema.setPreferredSize(new Dimension(50, 20));
      mnuSistema.add(getMnuPPal());
    }
    return mnuSistema;
  }

  /**
   * This method initializes mnuPPal
   * 
   * @return javax.swing.JMenu
   */
  private JMenu getMnuPPal() {
    if (mnuPPal == null) {
      mnuPPal = new JMenu();
      mnuPPal.setText("Operaciones");
      mnuPPal.add(getMnuReporte());
      // mnuPPal.add(getMnuCreditos());
      mnuPPal.add(getMnuNumerados());
      mnuPPal.add(getMnuClonar());
      mnuPPal.add(getJSeparator());
      mnuPPal.add(getMnuSalir());
    }
    return mnuPPal;
  }

  /**
   * This method initializes mnuReporte
   * 
   * @return javax.swing.JMenuItem
   */
  private JMenuItem getMnuReporte() {
    if (mnuReporte == null) {
      mnuReporte = new JMenuItem();
      mnuReporte.setText("Reporte Ruta");
      mnuReporte.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          reporte();
        }
      });
    }
    return mnuReporte;
  }

  /**
   * This method initializes mnuCreditos
   * 
   * @return javax.swing.JMenuItem
   */
  // private JMenuItem getMnuCreditos() {
  // if (mnuCreditos == null) {
  // mnuCreditos = new JMenuItem();
  // mnuCreditos.setText("Créditos");
  // mnuCreditos.addActionListener(new ActionListener() {
  //
  // @Override
  // public void actionPerformed(ActionEvent e) {
  // creditos();
  // }
  // });
  // }
  // return mnuCreditos;
  // }

  /**
   * This method initializes mnuNumerados
   * 
   * @return javax.swing.JMenuItem
   */
  private JMenuItem getMnuNumerados() {
    if (mnuNumerados == null) {
      mnuNumerados = new JMenuItem();
      mnuNumerados.setText("Agregar Numerados");
      mnuNumerados.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          numerados();
        }
      });
    }
    return mnuNumerados;
  }

  /**
   * This method initializes mnuClonar
   * 
   * @return javax.swing.JMenuItem
   */
  private JMenuItem getMnuClonar() {
    if (mnuClonar == null) {
      mnuClonar = new JMenuItem();
      mnuClonar.setText("Clonar Factura");
      mnuClonar.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          clonarFactura();
        }
      });
    }
    return mnuClonar;
  }

  /**
   * This method initializes mnuSalir
   * 
   * @return javax.swing.JMenuItem
   */
  private JMenuItem getMnuSalir() {
    if (mnuSalir == null) {
      mnuSalir = new JMenuItem();
      mnuSalir.setText("Salir del Sistema");
      mnuSalir.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          salir();
        }
      });
    }
    return mnuSalir;
  }

  /**
   * This method initializes jSeparator
   * 
   * @return javax.swing.JSeparator
   */
  private JSeparator getJSeparator() {
    if (jSeparator == null) {
      jSeparator = new JSeparator();
    }
    return jSeparator;
  }

  public static void main(String[] args) {
    JFrame frame = new SincronizacionMMI();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public void onMessage(final EventMsg evt) {
    if (evt != null) {
      Runnable r = new Runnable() {

        @Override
        public void run() {
          model.addElement(evt.getMessage());
          lstMessages.repaint();
        }
      };
      SwingUtilities.invokeLater(r);
    }
  }

  public void graphicInit() {
    Rectangle virtualBounds = new Rectangle();
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice[] gs = ge.getScreenDevices();
    int n = 0;
    GraphicsDevice gd = gs[n];
    GraphicsConfiguration[] gc = gd.getConfigurations();

    virtualBounds = virtualBounds.union(gc[0].getBounds());

    int topX = (int) virtualBounds.getCenterX() - getWidth() / 2;
    int topY = (int) virtualBounds.getCenterY() - getHeight() / 2;

    if (topX < 0) {
      topX = 0;
    }
    if (topY < 0) {
      topY = 0;
    }

    setBounds(topX, topY, getWidth(), getHeight());
  }

  public void clonarFactura() {
    if (SincronizacionMMI.this.dlg == null) {
      dlg = new DlgClonarFactura(SincronizacionMMI.this);
    }
    dlg.clear();
    int topX = getLocation().x + getWidth() / 2 - dlg.getWidth() / 2;
    int topY = getLocation().y + getHeight() / 2 - dlg.getHeight() / 2;
    dlg.setLocation(topX, topY);
    dlg.setVisible(true);

  }

  public void numerados() {
    ControladorNumerados controlador = new ControladorNumerados();
    DialogNumerados frmQuesos = controlador.getView();
    frmQuesos.setVisible(true);

  }

  public void reporte() {
    dlgFecha.setLocation(getLocationOnScreen());
    dlgFecha.setVisible(true);
    fechaReporte = dlgFecha.getDate();
    if (fechaReporte != null) {
      try {
        HojaRutaExcel.getInstance().generarReporte(fechaReporte, this);
      } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
            "No se puede costruir reporte para la fecha solicitada.", "Error de reporte.",
            JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  public void creditos() {
    dlgFecha.setLocation(getLocationOnScreen());
    dlgFecha.setVisible(true);
    Date fecha = dlgFecha.getDate();
    if (fecha != null) {
      // ListadoCreditos.getInstance().construirReporte(fecha);
    }
  }

  public void salir() {
    if (SincronizacionMMI.this.data != null) {
      data.close();
    }
    System.exit(0);
  }

  public void handle(EventObject paramEventObject) {
    if (paramEventObject instanceof ConnectionServerEvent) {
      ConnectionServerEvent event = (ConnectionServerEvent) paramEventObject;
      InetAddress thisIp = event.getServer().getInetAddress();
      String ipAddress =
          String.format("%s:%d", thisIp.toString(), event.getServer().getLocalPort());
      setTitle("Ventas " + ipAddress);
    }
  }
} // @jve:decl-index=0:visual-constraint="19,27"
