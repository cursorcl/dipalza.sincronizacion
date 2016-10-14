package com.grupo.util;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

public class WindowsUtil {

  
  public static Point getScreenCenter()
  {
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      GraphicsDevice[] gs = ge.getScreenDevices();
      int n = 0;
      GraphicsDevice gd = gs[n];
      GraphicsConfiguration gc = gd.getDefaultConfiguration();
      

      int topX = (int) gc.getBounds().getCenterX();
      int topY = (int) gc.getBounds().getCenterY();

      return new Point(topX, topY);
  }
}
