package com.grupo.numerados.balanza;

/**
 * Clase que representa un registro proveniente desde la balanza.
 * 
 * @author cursor
 *
 */
public class PLU {
  public String header;
  public Float firstNumber;
  public float secondNumber;
  public float unitPrice;
  public float soldPrice;
  public String productName;
  public String plu;
  public String dbCode;

  @Override
  public String toString() {
    return "PLU [header=" + header + ", firstNumber=" + firstNumber + ", secondNumber="
        + secondNumber + ", unitPrice=" + unitPrice + ", soldPrice=" + soldPrice + ", productName="
        + productName + ", plu=" + plu + ", dbCode=" + dbCode + "]";
  }

}
