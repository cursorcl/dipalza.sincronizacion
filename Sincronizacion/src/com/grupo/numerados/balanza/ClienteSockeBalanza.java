package com.grupo.numerados.balanza;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;

import com.grupo.biblioteca.server.events.Notificable;
import com.grupo.biblioteca.server.events.Notifier;
import com.grupo.numerados.controller.ControladorNumerados;

public class ClienteSockeBalanza extends Notifier implements Runnable {
  static Logger log = Logger.getLogger(ClienteSockeBalanza.class.getName());
  private BufferedWriter objectOutput = null;
  private BufferedReader objectIntput = null;
  private Socket socketClient = null;
  private boolean alive = true;

  private ControladorNumerados controlador;


  public ClienteSockeBalanza(String ip, Notificable notificable) {

    addNotificable(notificable);
    controlador = new ControladorNumerados();
    try {
      this.alive = false;
      socketClient = new Socket(ip, 7777);
      this.objectOutput =
          new BufferedWriter(new OutputStreamWriter(this.socketClient.getOutputStream()));
      this.objectIntput =
          new BufferedReader(new InputStreamReader(this.socketClient.getInputStream()));
      start();
      log.debug("Conectado al servidor e iniciado servicio");
    } catch (ConnectException e) {
      log.error("No es posible conectarse a " + ip);
    } catch (UnknownHostException e) {
      log.error("Host desconocido " + ip);
    } catch (IOException e) {
      log.error("Error de entrada/salida en " + ip);
    }
  }



  private void process(int messge) {
    controlador.grabarNumerado("001", 2.2f);
  }

  public void run() {
    while ((this.alive) && (this.objectIntput != null)) {
      try {
        int obj = this.objectIntput.read();
        process(obj);
      } catch (IOException ex) {
        ex.printStackTrace();
        this.alive = false;
        log.error("Conexión cerrada  desde el cliente.");
        log.fatal(ex.getLocalizedMessage());
        for (StackTraceElement stEl : ex.getStackTrace()) {
          log.fatal(stEl.toString());
        }
      }
    }
  }

  private void start() {
    if (this.socketClient != null) {
      this.alive = true;
      Thread t = new Thread(this);
      t.start();
    }
  }

  public void disconnect() {
    try {
      this.alive = false;
      this.socketClient.close();
      log.debug("Conexión cerrada");
    } catch (IOException e) {
      log.error("Error al cerrar la conexión.");
    }
  }

  public boolean isConnected() {
    return (this.socketClient != null) && (this.socketClient.isConnected());
  }

}
