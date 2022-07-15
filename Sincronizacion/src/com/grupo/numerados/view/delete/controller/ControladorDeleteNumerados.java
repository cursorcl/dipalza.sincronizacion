package com.grupo.numerados.view.delete.controller;

import java.util.List;

import com.grupo.data.DataSQL;
import com.grupo.data.results.NumeradosSinDetalleDTO;
import com.grupo.forms.MostrarProgreso;
import com.grupo.numerados.ProductosNumerados;
import com.grupo.numerados.view.delete.DialogDeleteNumerados;

public class ControladorDeleteNumerados {


  private DialogDeleteNumerados view;
  private MostrarProgreso progreso = new MostrarProgreso();

  public ControladorDeleteNumerados() {}

  // Falta validar que pasa cuando hay mas de 99
  public int getNextIndex(String articulo) {
    return DataSQL.getInstance().getIndex(articulo);
  }


  public void grabarNumerado(ProductosNumerados numerado) {
    DataSQL.getInstance().addNumerado(numerado);
  }

  public void eliminarNumerado(NumeradosSinDetalleDTO numerado) {
    DataSQL.getInstance().eliminarNumeradoSinDetalle(numerado);
  }

  public List<NumeradosSinDetalleDTO> obtenerNumerados() {
    progreso.setVisible(true);
    List<NumeradosSinDetalleDTO> list = DataSQL.getInstance().obtenerNumeradosSinDetalle();
    progreso.setVisible(false);
    return list;
  }

  public String getNombreProducto(String articulo) {
    return DataSQL.getInstance().getProductName(articulo);
  }

  public DialogDeleteNumerados getView() {
    if (view == null) {
      view = new DialogDeleteNumerados(this);
    }
    return view;
  }

  public void grabarNumerado(String codigo, float peso) {
    ProductosNumerados numerado = new ProductosNumerados(codigo, getNextIndex(codigo), peso);
    grabarNumerado(numerado);
  }

  public void eliminarTodos() {
    progreso.setVisible(true);
    List<NumeradosSinDetalleDTO> aBorrar = obtenerNumerados();
    for (NumeradosSinDetalleDTO producto : aBorrar) {
      eliminarNumerado(producto);
    }
    progreso.setVisible(false);
  }
  
  public List<NumeradosSinDetalleDTO> obtenerNumeradosSinDetalle() {
	  return DataSQL.getInstance().obtenerNumeradosSinDetalle();
  }
}
