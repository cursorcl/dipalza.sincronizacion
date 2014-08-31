package com.grupo.numerados.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

class ActionPanelEditorRenderer extends AbstractCellEditor implements
	TableCellRenderer, TableCellEditor {

    private JButton button = null;

    public ActionPanelEditorRenderer() {
	super();
	button = new JButton();
	button.setIcon(new ImageIcon(Numerados.class
		.getResource("/imagenes/_16/minus_16.png")));
	button.setSelectedIcon(new ImageIcon(Numerados.class
		.getResource("/imagenes/_16/minus_16.png")));
	button.setPressedIcon(new ImageIcon(Numerados.class
		.getResource("/imagenes/_16/minus_16.png")));
	button.setDisabledIcon(new ImageIcon(Numerados.class
		.getResource("/imagenes/_16/minus_16.png")));
	button.setDisabledSelectedIcon(new ImageIcon(Numerados.class
		.getResource("/imagenes/_16/minus_16.png")));

	button.setRolloverEnabled(true); // turn on before rollovers work
	button.setRolloverIcon(new ImageIcon(Numerados.class
		.getResource("/imagenes/_16/minus_16.png")));

	button.setRolloverSelectedIcon(new ImageIcon(Numerados.class
		.getResource("/imagenes/_16/minus_16.png")));

	button.addActionListener(new ActionListener() {

	    public void actionPerformed(ActionEvent e) {
		System.out.println("action");
	    }
	});
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
	    boolean isSelected, boolean hasFocus, int row, int column) {
	return button;
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
	    boolean isSelected, int row, int column) {
	System.out.println(row);
	return button;
    }

    public Object getCellEditorValue() {
	return null;
    }
}