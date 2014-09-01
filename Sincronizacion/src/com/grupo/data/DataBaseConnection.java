package com.grupo.data;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;

public class DataBaseConnection {
  private static DataBaseConnection instance = null;

  private boolean bConnectOk = false;

  private Connection connectionDB = null;

  private DataBaseConnection() {
    OpenConnectionDB();
  }

  public static DataBaseConnection getInstance() {
    if (instance == null) {
      instance = new DataBaseConnection();
    }
    return instance;
  }

  public boolean OpenConnectionDB() {
    String host = "localhost";
    int port = 1433;
    String baseDatos = "mastersoft";
    String instanceName = "sqlexpress";
    String user = "cursor";
    String password = "_l2j1rs2";
    try {
      InputStream inStream = DataBaseConnection.class.getResourceAsStream("/sqlserver.properties");
      if (inStream != null) {
        Properties props = new Properties();
        props.load(inStream);
        host = props.getProperty("host", "localhost");
        instanceName = props.getProperty("instance", "sqlexpress");
        port = Integer.parseInt(props.getProperty("port", "1433"));
        baseDatos = props.getProperty("basedatos", "mastersoft");

        user = props.getProperty("user", "cursor");
        password = props.getProperty("password", "_l2j1rs2");

        inStream.close();
        props = null;
      }

      Class.forName("net.sourceforge.jtds.jdbc.Driver");
      String strUrl =
          String.format("jdbc:jtds:sqlserver://%s:%d/%s;instance=%s", host, port, baseDatos,
              instanceName);

      if (this.connectionDB != null) {
        this.connectionDB.close();
        this.connectionDB = null;
      }
      this.connectionDB = DriverManager.getConnection(strUrl, user, password);
      this.bConnectOk = true;
    } catch (Exception e) {
      e.printStackTrace();
      String strError =
          String.format("Error al conectarse a la base de datos.\nusuario=%s\nhost=%s:%d", user,
              host, port);
      JOptionPane.showMessageDialog(null, strError, "Error conexión Base de datos",
          JOptionPane.ERROR_MESSAGE);
      this.bConnectOk = false;
      System.exit(0);
    }
    return this.bConnectOk;
  }

  public boolean CloseConnectionDB() {
    boolean bExito = false;
    try {
      if (this.connectionDB != null) {
        this.connectionDB.close();
      }
      this.connectionDB = null;
      this.bConnectOk = false;
      bExito = true;
    } catch (Exception e) {
      this.connectionDB = null;
      this.bConnectOk = false;
      bExito = false;
    }
    return bExito;
  }

  public boolean isConnectDB() {
    return this.bConnectOk;
  }

  public Connection getConnectionDB() {
    if ((this.bConnectOk) && (this.connectionDB != null)) {
      return this.connectionDB;
    }

    return null;
  }

  private static final String SQL_FND_MSOCLIENTES = "select rut from msoclientes where rut = ?";

  public static void main(String[] args) {
    try {

      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

      String url = "jdbc:sqlserver://181.160.227.146:1433;databaseName=mastersoft";
      Connection con = DriverManager.getConnection(url, "sa", "");
      if (con != null) {
        System.out.println("Connection Successful");
        try {
          PreparedStatement pstmt = con.prepareStatement(SQL_FND_MSOCLIENTES);
          pstmt.clearParameters();
          pstmt.setString(1, "0150577039");
          ResultSet r = pstmt.executeQuery();
          r.close();
          pstmt.close();
        } catch (SQLException localSQLException) {
          localSQLException.printStackTrace();
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}

/*
 * Location: C:\Users\cursor\ventaserver\ Qualified Name: com.grupo.data.DataBaseConnection JD-Core
 * Version: 0.5.4
 */
