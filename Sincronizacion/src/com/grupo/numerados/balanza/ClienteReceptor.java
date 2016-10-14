package com.grupo.numerados.balanza;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;

import com.grupo.biblioteca.server.events.Notificable;
import com.grupo.biblioteca.server.events.Notifier;

public class ClienteReceptor extends Notifier implements Runnable {
  static Logger log = Logger.getLogger(ClienteReceptor.class.getName());
  private boolean alive = true;

  private DatagramSocket clientSocket;


  private BlockingQueue<Object> queue = new LinkedBlockingQueue<Object>();
  /**
   * Construye el cliente que recibe los datos desde la balanza.
   * 
   * @param notificable Quien recibiré el evento que ha llegado información.
   * @param port puerta a la que debe conectarse el socket (5555).
   */
  public ClienteReceptor(Notificable notificable, int port) {

    addNotificable(notificable);
    try {
      
      new ClienteProcesador(queue, notificable);
      
      clientSocket = new DatagramSocket(port);
      clientSocket.setSoTimeout(500);
      
      this.alive = true;
      Executors.newFixedThreadPool(1).execute(this);
    } catch (SocketException e) {
      log.error("Error en la conexión del socket UDP a la balanza.");
    }
  }



  public void run() {
    byte[] receiveData = new byte[1024];
    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

    while (this.alive) {
      try {
        clientSocket.receive(receivePacket);
        queue.add(receiveData);
      } catch (SocketTimeoutException timeout) {
        // Esto sucede cada medio segundo, ya que eso es lo que le pedí que se bloqueara.
      } catch (IOException ex) {
        this.alive = false;
        log.error("Conexión cerrada  desde el cliente.");
        log.fatal(ex.getLocalizedMessage());
        for (StackTraceElement stEl : ex.getStackTrace()) {
          log.fatal(stEl.toString());
        }
      }
    }
    receivePacket = null;
    clientSocket.disconnect();
  }


  public void disconnect() {
    this.alive = false;
    log.debug("Conexión cerrada");
  }


}
