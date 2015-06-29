package com.grupo.forms.report;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;

import cl.eos.util.Utils;

public class UtilReport {

  public static void applySheetSubTitleStyle(Cell cell) {
    Font font = cell.getSheet().getWorkbook().createFont();
    font.setFontHeightInPoints((short) 20);
    font.setFontName("IMPACT");
    font.setItalic(true);
    font.setColor(HSSFColor.BLUE.index);

    CellStyle cStyle = cell.getSheet().getWorkbook().createCellStyle();
    cStyle.setBorderLeft(CellStyle.BORDER_MEDIUM);
    cStyle.setBorderRight(CellStyle.BORDER_MEDIUM);
    cStyle.setBorderTop(CellStyle.BORDER_MEDIUM);
    cStyle.setBorderBottom(CellStyle.BORDER_MEDIUM);
    cStyle.setAlignment(CellStyle.ALIGN_CENTER);
    cStyle.setFont(font);
    cStyle.setFillPattern(CellStyle.NO_FILL);
    cell.setCellStyle(cStyle);
  }

  public static void applySheetTitleStyle(Cell cell) {
    Font font = cell.getSheet().getWorkbook().createFont();
    font.setFontHeightInPoints((short) 30);
    font.setFontName("IMPACT");
    font.setItalic(true);
    font.setColor(HSSFColor.BLUE.index);

    CellStyle cStyle = cell.getSheet().getWorkbook().createCellStyle();
    cStyle.setBorderLeft(CellStyle.BORDER_MEDIUM);
    cStyle.setBorderRight(CellStyle.BORDER_MEDIUM);
    cStyle.setBorderTop(CellStyle.BORDER_MEDIUM);
    cStyle.setBorderBottom(CellStyle.BORDER_MEDIUM);
    cStyle.setAlignment(CellStyle.ALIGN_CENTER);
    cStyle.setFont(font);
    cStyle.setFillPattern(CellStyle.NO_FILL);
    cell.setCellStyle(cStyle);
  }

  public static void applyLeftFirstColumnStyle(Cell cell) {
    CellStyle cStyle = cell.getSheet().getWorkbook().createCellStyle();
    cStyle.setAlignment(CellStyle.ALIGN_LEFT);
    cStyle.setBorderLeft(CellStyle.BORDER_MEDIUM);
    cStyle.setBorderRight(CellStyle.BORDER_MEDIUM);
    cStyle.setBorderTop(CellStyle.BORDER_MEDIUM);
    cStyle.setBorderBottom(CellStyle.BORDER_MEDIUM);
    cStyle.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
    cStyle.setFillPattern(CellStyle.NO_FILL);
    cell.setCellStyle(cStyle);

  }

  public static void applyTitleStyle(Cell cell) {
    CellStyle cStyle = cell.getSheet().getWorkbook().createCellStyle();
    cStyle.setAlignment(CellStyle.ALIGN_CENTER);
    cStyle.setBorderLeft(CellStyle.BORDER_MEDIUM);
    cStyle.setBorderRight(CellStyle.BORDER_MEDIUM);
    cStyle.setBorderTop(CellStyle.BORDER_MEDIUM);
    cStyle.setBorderBottom(CellStyle.BORDER_MEDIUM);
    cStyle.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
    cStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
    cell.setCellStyle(cStyle);
  }

  public static void applyNormalStyle(Cell cell) {
    CellStyle cStyle = cell.getSheet().getWorkbook().createCellStyle();
    cStyle.setAlignment(CellStyle.ALIGN_CENTER);
    cStyle.setBorderLeft(CellStyle.BORDER_THIN);
    cStyle.setBorderRight(CellStyle.BORDER_THIN);
    cStyle.setBorderTop(CellStyle.BORDER_THIN);
    cStyle.setBorderBottom(CellStyle.BORDER_THIN);

    cell.setCellStyle(cStyle);
  }

  /**
   * Metodo que permite desplegar el documento de excel creado.
   * 
   * @param nombreDoc Nombre del documento.
   */
  public static void mostrarDocumentoExcel(final String nombreDoc) {
    final File archivo = new File(nombreDoc);
    try {
      Runtime.getRuntime().exec("cmd /c start \"\" \"" + archivo.getAbsolutePath() + "\"");
    } catch (final Exception e) {
      e.getMessage();
    }
  }


  public static void crearExcel(final Workbook wbWork, String name) {
    String path = Utils.getDefaultDirectory().toString() + File.separator + name;

    FileOutputStream fileOut = null;
    try {
      fileOut = new FileOutputStream(new File(path));
      wbWork.write(fileOut);
      fileOut.flush();
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "No se pudo grabar archivo " +  path, "Problemas al grabar", JOptionPane.ERROR_MESSAGE);
    }
    finally {
      try {
        fileOut.close();
      } catch (final IOException e) {
        JOptionPane.showMessageDialog(null, "No se pudo cerrar archivo " +  path, "Problemas al cerrar archivo", JOptionPane.ERROR_MESSAGE);
      }
    }
    mostrarDocumentoExcel(path);
  }
}
