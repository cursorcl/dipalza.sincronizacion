package com.grupo.numerados.balanza;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.grupo.biblioteca.server.events.Notificable;
import com.grupo.biblioteca.server.events.Notifier;
import com.grupo.numerados.controller.ControladorNumerados;

/**
 * Runnable que se encarga de realizar la conversión de {@code byte[]} a un {@code PLU}.
 * 
 * @author cursor
 *
 */
public class ClienteProcesador extends Notifier implements Runnable {


  Logger log = Logger.getLogger(ClienteProcesador.class);
  public static final byte HEADER = 0;
  public static final byte FIRST_NUMBER = 1;
  public static final byte SECOND_NUMBER = 2;
  public static final byte UNIT_PRICE = 3;
  public static final byte SOLD_PRICE = 4;
  public static final byte PRODUCT_NAME = 5;
  public static final byte PLU = 6;
  public static final byte DB_CODE = 7;
  public static final byte FINISHED = 8;

  BlockingQueue<Object> queue;
  boolean isAlive;

  ControladorNumerados controlador = new ControladorNumerados();

  public ClienteProcesador(BlockingQueue<Object> queue, Notificable notificable) {
    this.queue = queue;
    addNotificable(notificable);
    Executors.newFixedThreadPool(1).execute(this);
  }


  /**
   * Realiza el procesamiento de un item de datos recibido desde la balanza. Se entiend corresponde
   * a un producto numerado.
   * 
   * @param receiveData Tira de bytes que proviene de la balanza.
   * @return PLU que corresponde a los datos procesados desde la balanza.
   */
  public PLU process(byte[] receiveData) {

    PLU plu = null;
    if (receiveData[0] == 2) {

      ByteBuffer buff = ByteBuffer.wrap(receiveData);

      plu = new PLU();
      byte b = 0;
      byte status = HEADER;
      byte[] tmp = new byte[512];
      Arrays.fill(tmp, (byte) 0);
      int n = 0;
      while (status != FINISHED) {
        b = buff.get();
        if (b == 2)
          continue;
        if (b == 31 || b == 3) {
          switch (status) {
            case HEADER:
              plu.header = new String(tmp, 0, n);
              status = FIRST_NUMBER;
              break;
            case FIRST_NUMBER:
              String fn = new String(tmp, 0, n);
              plu.firstNumber = Float.parseFloat(fn);
              status = SECOND_NUMBER;
              break;
            case SECOND_NUMBER:
              String sn = new String(tmp, 0, n);
              plu.secondNumber = Float.parseFloat(sn);
              status = UNIT_PRICE;
              break;
            case UNIT_PRICE:
              String up = new String(tmp, 0, n);
              plu.unitPrice = Float.parseFloat(up);
              status = SOLD_PRICE;
              break;
            case SOLD_PRICE:
              String sp = new String(tmp, 0, n);
              plu.soldPrice = Float.parseFloat(sp);
              status = PRODUCT_NAME;
              break;
            case PRODUCT_NAME:
              String pn = new String(tmp, 0, n);
              plu.productName = pn;
              status = PLU;
              break;
            case PLU:
              String pl = new String(tmp, 0, n);
              plu.plu = pl;
              status = DB_CODE;
              break;
            case DB_CODE:
              String dc = new String(tmp, 0, n);
              plu.dbCode = dc;
              status = FINISHED;
              break;
          }
          n = 0;
          Arrays.fill(tmp, (byte) 0);
        } else {
          tmp[n++] = b;
        }
      }
    }
    return plu;
  }



  @Override
  public void run() {
    while (isAlive) {
      try {
        Object poll = queue.poll(200, TimeUnit.MILLISECONDS);
        if (poll != null) {
          byte[] data = (byte[]) poll;
          PLU plu = process(data);
          if (plu.unitPrice != 0 && plu.soldPrice != 0) {
            controlador.grabarNumerado(plu.dbCode, plu.soldPrice / plu.unitPrice);
          }
          super.notify(new ScaleEvent(ClienteProcesador.this, plu));
        }
      } catch (InterruptedException e) {
        log.error("Se ha interrumpido la espera de la cola de Procesamiento");
      }
    }
  }
}
