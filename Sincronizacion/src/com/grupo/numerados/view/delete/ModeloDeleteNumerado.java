package com.grupo.numerados.view.delete;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.grupo.data.results.NumeradosSinDetalleDTO;



/**
 * Modelo para mantener la lista de elementos numerados ingresados.
 * @author cursor
 */
public class ModeloDeleteNumerado extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    private final String[] COLUMNAS = { "CODIGO", "PRODUCTO" };
    private List<NumeradosSinDetalleDTO> datos;

    public ModeloDeleteNumerado() {
	this.datos = new LinkedList<NumeradosSinDetalleDTO>();
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
		NumeradosSinDetalleDTO item = this.datos.get(row);
	    switch (col) {
	    case 0:
		res = item.getArticulo();
		break;
	    case 1:
		res = item.getDescripcion();
		break;
	    }
	}

	return res;
    }

    public void setValueAt(Object v, int r, int c) {
	if ((r < 0) || (r >= this.datos.size()))
	    return;
	NumeradosSinDetalleDTO q = this.datos.get(r);
	switch (c) {
	case 0:
	    q.setArticulo((String) v);
	    break;
	case 1:
	    q.setDescripcion((String) v);
	    break;
	}
    }

    public void addItem(NumeradosSinDetalleDTO q) {
	this.datos.add(q);
	fireTableDataChanged();
    }
    
    /**
     * Obtiene el item desde el model.
     * @param index Indice 
     * @return
     */
    public NumeradosSinDetalleDTO getItem(final int index) 
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
	    res = String.class;
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

    public void setDatos(List<NumeradosSinDetalleDTO> numerados) {
	this.datos = numerados;
	fireTableDataChanged();
    }

    @Override
    public boolean isCellEditable(int row, int col) {
	return false;
    }
    
    
}
