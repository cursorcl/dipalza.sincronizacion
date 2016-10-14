package com.grupo.numerados.balanza;

import java.util.EventObject;

public class ScaleEvent extends EventObject {

  private static final long serialVersionUID = 1L;

  public ScaleEvent(Object source, PLU plu) {
    super(source);
  }

}
