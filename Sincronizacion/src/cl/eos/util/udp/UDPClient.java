package cl.eos.util.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class UDPClient {

  public static final byte HEADER = 0;
  public static final byte FIRST_NUMBER = 1;
  public static final byte SECOND_NUMBER = 2;
  public static final byte UNIT_PRICE = 3;
  public static final byte SOLD_PRICE = 4;
  public static final byte PRODUCT_NAME = 5;
  public static final byte PLU = 6;
  public static final byte DB_CODE = 7;
  public static final byte FINISHED = 8;

  public static class PLU {
    String header;
    Float firstNumber;
    float secondNumber;
    float unitPrice;
    float soldPrice;
    String productName;
    String plu;
    String dbCode;

    @Override
    public String toString() {
      return "PLU [header=" + header + ", firstNumber=" + firstNumber + ", secondNumber="
          + secondNumber + ", unitPrice=" + unitPrice + ", soldPrice=" + soldPrice
          + ", productName=" + productName + ", plu=" + plu + ", dbCode=" + dbCode + "]";
    }

  }

  public static void main(String args[]) throws Exception {
    DatagramSocket clientSocket = new DatagramSocket(1921);
    byte[] receiveData = new byte[1024];
    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

    clientSocket.receive(receivePacket);
    

    if (receiveData[0] == 2) {
      
      ByteBuffer buff = ByteBuffer.wrap(receiveData);
      
      PLU plu = new PLU();
      byte b = 0;
      byte status = HEADER;
      byte[] tmp = new byte[512];
      Arrays.fill(tmp, (byte)0);
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
          n =0;
          Arrays.fill(tmp, (byte)0);
        } else {
          tmp[n++] = b;
        }
      }
      System.out.println(plu);
    }

    clientSocket.close();
  }
}
