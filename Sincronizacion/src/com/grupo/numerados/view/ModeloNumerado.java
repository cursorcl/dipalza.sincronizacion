package com.grupo.numerados.view;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.grupo.numerados.ProductosNumerados;



/**
 * Modelo para mantener la lista de elementos numerados ingresados.
 * @author cursor
 */
public class ModeloNumerado extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    private final String[] COLUMNAS = { "CODIGO", "PESO", "PRODUCTO", "NUMERO" };
    private List<ProductosNumerados> datos;

    public ModeloNumerado() {
	this.datos = new LinkedList<ProductosNumerados>();
    }

    public int getColumnCount() {
	return this.COLUMNAS.length;
    }

    public int getRowCount() {
	int size = 0;
	if(datos != null)
	{
	    size = this.datos.size();
	}
	return size;
    }

    public Object getValueAt(int row, int col) {
	Object res = null;
	if ((row >= 0) && (row < this.datos.size())) {
	    ProductosNumerados item = this.datos.get(row);
	    switch (col) {
	    case 0:
		res = item.getArticulo();
		break;
	    case 1:
		res = Float.valueOf(item.getPesoQueso());
		break;
	    case 2:
		res = item.getDescripcion();
		break;
	    case 3:
		res = Integer.valueOf(item.getCorrelativo());
		break;
	    }
	}

	return res;
    }

    public void setValueAt(Object v, int r, int c) {
	if ((r < 0) || (r >= this.datos.size()))
	    return;
	ProductosNumerados q = this.datos.get(r);
	switch (c) {
	case 0:
	    q.setArticulo((String) v);
	    break;
	case 1:
	    q.setPesoQueso(((Float) v).floatValue());
	    break;
	case 2:
	    q.setDescripcion((String) v);
	    break;
	case 3:
	    q.setCorrelativo(((Integer) v).intValue());
	    break;
	}
    }

    public void addItem(ProductosNumerados q) {
	this.datos.add(q);
	fireTableDataChanged();
    }
    
    /**
     * Obtiene el item desde el model.
     * @param index Indice 
     * @return
     */
    public ProductosNumerados getItem(final int index) 
    {
	return this.datos.get(index);
    }
    
    public void removeItem(int index)
    {
	this.datos.remove(index);
	fireTableDataChanged();
    }

    public Class<?> getColumnClass(int c) {
	Class<?> res = null;
	switch (c) {
	case 0:
	    res = String.class;
	    break;
	case 1:
	    res = Float.class;
	    break;
	case 2:
	    res = String.class;
	    break;
	case 3:
	    res = Integer.class;
	    break;
	}

	return res;
    }

    public String getColumnName(int c) {
	String res = null;
	if ((c >= 0) && (c < this.COLUMNAS.length))
	    res = this.COLUMNAS[c];
	return res;
    }

    public void setDatos(List<ProductosNumerados> numerados) {
	this.datos = numerados;
	fireTableDataChanged();
    }

    @Override
    public boolean isCellEditable(int row, int col) {
	return false;
    }
    
    
}
