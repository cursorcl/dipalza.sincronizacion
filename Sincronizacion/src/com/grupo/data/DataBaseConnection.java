package com.grupo.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	try {
//	     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//	     String url = "jdbc:odbc:master";

	    


	    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    String url = "jdbc:sqlserver://181.160.140.38:1433;databaseName=mastersoft";

//	    String url = "jdbc:sqlserver://camarasdipalza.dynalias.com:1433;databaseName=mastersoft";
	    if (this.connectionDB != null) {
		this.connectionDB.close();
		this.connectionDB = null;
	    }
//	    this.connectionDB = DriverManager.getConnection(url, "master", "");
	    this.connectionDB = DriverManager.getConnection(url, "cursor", "_l2j1rs2");
	    this.bConnectOk = true;
	} catch (Exception e) {
	    e.printStackTrace();
	    this.bConnectOk = false;
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
		    PreparedStatement pstmt = con
			    .prepareStatement(SQL_FND_MSOCLIENTES);
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
 * Location: C:\Users\cursor\ventaserver\ Qualified Name:
 * com.grupo.data.DataBaseConnection JD-Core Version: 0.5.4
 */