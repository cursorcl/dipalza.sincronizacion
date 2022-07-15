package com.grupo.numerados.view.delete;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.SwingWorker;
import javax.swing.table.TableColumn;

import com.grupo.data.results.NumeradosSinDetalleDTO;
import com.grupo.numerados.view.delete.controller.ControladorDeleteNumerados;

public class DeleteNumerados extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	public static final String DELETE = "DELETE";
	public static final String REFRESH = "REFRESH";
	private JPanel pnlCenter;
	private JScrollPane scrollPane;
	private JTable tblNumerados;
	private ModeloDeleteNumerado modeloNumerado;

	private ControladorDeleteNumerados controlador;

	private JPanel panel;
	private JButton btnDrop;
	private JToolBar toolBar;
	private JButton btnRefresh;

	/**
	 * Create the panel.
	 */
	public DeleteNumerados(ControladorDeleteNumerados controlador) {

		this.controlador = controlador;
		initialize();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		modeloNumerado = new ModeloDeleteNumerado();
		add(getPnlCenter(), BorderLayout.CENTER);
		fillProducts();

	}

	private JPanel getPnlCenter() {
		if (pnlCenter == null) {
			pnlCenter = new JPanel();
			pnlCenter.setLayout(new BorderLayout(0, 0));
			pnlCenter.add(getPanel(), BorderLayout.NORTH);
			pnlCenter.add(getScrollPane(), BorderLayout.CENTER);
		}
		return pnlCenter;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setFocusable(false);
			scrollPane.setViewportView(getTblNumerados());
		}
		return scrollPane;
	}

	private JTable getTblNumerados() {
		if (tblNumerados == null) {

			tblNumerados = new JTable();
			
			tblNumerados.setFocusable(false);
			tblNumerados.setFillsViewportHeight(true);
			tblNumerados.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			tblNumerados.getTableHeader().setReorderingAllowed(false);
			tblNumerados.getColumnModel().setColumnSelectionAllowed(false);
			tblNumerados.setRowHeight(20);
			tblNumerados.setRowSelectionAllowed(true);
			tblNumerados.setColumnSelectionAllowed(false);
			tblNumerados.setModel(modeloNumerado);
			TableColumn columna = tblNumerados.getColumnModel().getColumn(0);
			columna.setMaxWidth(75);
			columna.setMinWidth(75);
			columna.setPreferredWidth(75);
			tblNumerados.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

		}
		return tblNumerados;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setFocusable(false);
			panel.setPreferredSize(new Dimension(10, 30));
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 72, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			gbl_panel.rowHeights = new int[] { 0, 0 };
			gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
					Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
			panel.setLayout(gbl_panel);
			GridBagConstraints gbc_toolBar = new GridBagConstraints();
			gbc_toolBar.gridwidth = 11;
			gbc_toolBar.fill = GridBagConstraints.BOTH;
			gbc_toolBar.gridx = 0;
			gbc_toolBar.gridy = 0;
			panel.add(getToolBar(), gbc_toolBar);
		}
		return panel;
	}

	public void actionPerformed(final ActionEvent actionEvent) {

		if (DELETE.equals(actionEvent.getActionCommand())) {

			int rowCount = tblNumerados.getSelectedRowCount();
			int[] rows = tblNumerados.getSelectedRows();
			int resultado = JOptionPane.showConfirmDialog(this, "Confirma la eliminación de productos seleccionados.");
			if (resultado == JOptionPane.OK_OPTION) {
				for (int n = 0; n < rowCount; n++) {
					NumeradosSinDetalleDTO item = modeloNumerado.getItem(rows[n]);
					controlador.eliminarNumerado(item);
				}
			}
		} else if (REFRESH.equals(actionEvent.getActionCommand())) {
			int resultado = JOptionPane.showConfirmDialog(this, "Confirma que desea refrescar la lista de productos.");
			if (resultado == JOptionPane.OK_OPTION) {
				fillProducts();
			}
		}

		fillProducts();

	}

	public void fillProducts() {
		SwingWorker<List<NumeradosSinDetalleDTO>, Object> work = new SwingWorker<List<NumeradosSinDetalleDTO>, Object>() {
			@Override
			protected List<NumeradosSinDetalleDTO> doInBackground() throws Exception {
				List<NumeradosSinDetalleDTO> lNumerodos = controlador.obtenerNumeradosSinDetalle();

				return lNumerodos;
			}

			@Override
			protected void done() {
				try {
					modeloNumerado.setDatos(get());
					// lblIndex.setText("--");
				} catch (Exception ignore) {
				}
			}

		};
		work.execute();
	}

	private JButton getBtnDrop() {
		if (btnDrop == null) {
			btnDrop = new JButton("");
			btnDrop.setFocusable(false);
			btnDrop.setToolTipText("Eliminar productos.");
			btnDrop.setActionCommand(DELETE);
			btnDrop.addActionListener(this);
			btnDrop.setIcon(new ImageIcon(DeleteNumerados.class.getResource("/imagenes/delete.png")));
		}
		return btnDrop;
	}

	private JToolBar getToolBar() {
		if (toolBar == null) {
			toolBar = new JToolBar();
			toolBar.setFloatable(false);
			toolBar.setRollover(true);
			toolBar.add(getBtnDrop());
			toolBar.add(getBtnRefresh());
		}
		return toolBar;
	}

	private JButton getBtnRefresh() {
		if (btnRefresh == null) {
			btnRefresh = new JButton("");
			btnRefresh.setActionCommand(REFRESH);
			btnRefresh.setFocusable(false);
			btnRefresh.addActionListener(this);
			btnRefresh.setToolTipText("Vuelve a cargar todos los artículos numerados sin detalle.");
			btnRefresh.setIcon(new ImageIcon(DeleteNumerados.class.getResource("/imagenes/refresh.png")));
		}
		return btnRefresh;
	}

}
