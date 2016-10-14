package com.grupo.numerados.controller;

import java.util.List;

import com.grupo.data.DataSQL;
import com.grupo.forms.MostrarProgreso;
import com.grupo.numerados.ProductosNumerados;
import com.grupo.numerados.view.DialogNumerados;

public class ControladorNumerados {


  private DialogNumerados view;
  private MostrarProgreso progreso = new MostrarProgreso();

  public ControladorNumerados() {}

  // Falta validar que pasa cuando hay mas de 99
  public int getNextIndex(String articulo) {
    return DataSQL.getInstance().getIndex(articulo);
  }


  public void grabarNumerado(ProductosNumerados numerado) {
    DataSQL.getInstance().addNumerado(numerado);
  }

  public void eliminarNumerado(ProductosNumerados numerado) {
    DataSQL.getInstance().removeNumerado(numerado);
  }

  public List<ProductosNumerados> obtenerNumerados() {
    progreso.setVisible(true);
    List<ProductosNumerados> list = DataSQL.getInstance().getArticulosNumerados();
    progreso.setVisible(false);
    return list;
  }

  public String getNombreProducto(String articulo) {
    return DataSQL.getInstance().getProductName(articulo);
  }

  public DialogNumerados getView() {
    if (view == null) {
      view = new DialogNumerados(this);
    }
    return view;
  }

  public void grabarNumerado(String codigo, float peso) {
    ProductosNumerados numerado = new ProductosNumerados(codigo, getNextIndex(codigo), peso);
    grabarNumerado(numerado);
  }

  public void eliminarTodos() {
    progreso.setVisible(true);
    List<ProductosNumerados> aBorrar = obtenerNumerados();
    for (ProductosNumerados producto : aBorrar) {
      eliminarNumerado(producto);
    }
    progreso.setVisible(false);
  }
}
