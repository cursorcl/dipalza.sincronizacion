package com.grupo.numerados.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FocusTraversalPolicy;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormatSymbols;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableColumn;

import com.grupo.numerados.ProductosNumerados;
import com.grupo.numerados.controller.ControladorNumerados;
import com.grupo.util.UtilEvent;

public class Numerados extends JPanel implements ActionListener, FocusListener {

	private static final long serialVersionUID = 1L;
	public static final String DELETE = "DELETE";
	public static final String ADD = "ADD";
	public static final String RESET = "RESET";
	public static final String EDIT = "EDIT";
	public static final String PRINT = "PRINT";
	public static final String ERASE_ALL = "ERASE ALL";
	private JPanel pnlCenter;
	private JScrollPane scrollPane;
	private JTable tblNumerados;
	private ModeloNumerado modeloNumerado;

	private ControladorNumerados controlador;

	private JPanel panel;
	private JLabel lblArticulo;
	private JTextField txtArticulo;
	private JLabel lblPeso;
	private JLabel lblNombre;
	private JButton btnSave;
	private JButton btnDrop;
	private JButton btnPrint;
	private JLabel lblIndex;
	private JToolBar toolBar;
	private JButton btnTrucate;
	private JLabel lblNewLabel;
	private JTextField ftxtPeso;
	private boolean keyPressed;

	/**
	 * Create the panel.
	 */
	public Numerados(ControladorNumerados controlador) {

		addFocusListener(this);
		this.controlador = controlador;
		initialize();
		setFocusTraversalPolicy(new FocusTraversal());
		getTxtArticulo().requestFocus();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		modeloNumerado = new ModeloNumerado();
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
			scrollPane.setBorder(new CompoundBorder(
					new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
							TitledBorder.TOP, null, new Color(0, 0, 0)),
					new EtchedBorder(EtchedBorder.LOWERED, null, null)));
			scrollPane.setViewportView(getTblNumerados());
		}
		return scrollPane;
	}

	private JTable getTblNumerados() {
		if (tblNumerados == null) {

			tblNumerados = new JTable();
			tblNumerados.setFocusable(false);
			tblNumerados.setFillsViewportHeight(true);
			tblNumerados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tblNumerados.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			tblNumerados.getTableHeader().setResizingAllowed(false);

			tblNumerados.getTableHeader().setReorderingAllowed(false);
			tblNumerados.getColumnModel().setColumnSelectionAllowed(false);
			tblNumerados.setRowHeight(20);
			tblNumerados.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
			tblNumerados.setRowSelectionAllowed(true);
			tblNumerados.setColumnSelectionAllowed(false);
			tblNumerados.setModel(modeloNumerado);
			TableColumn columna = tblNumerados.getColumnModel().getColumn(0);
			columna.setPreferredWidth(90);
			columna.setResizable(false);

			columna = tblNumerados.getColumnModel().getColumn(1);
			columna.setPreferredWidth(90);
			columna.setResizable(false);

			columna = tblNumerados.getColumnModel().getColumn(2);
			columna.setPreferredWidth(300);
			columna.setResizable(false);

			columna = tblNumerados.getColumnModel().getColumn(3);
			columna.setPreferredWidth(90);
			columna.setResizable(false);

		}
		return tblNumerados;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setFocusable(false);
			panel.setPreferredSize(new Dimension(10, 100));
			panel.setBorder(new CompoundBorder(
					new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
							TitledBorder.TOP, null, new Color(0, 0, 0)),
					new EtchedBorder(EtchedBorder.LOWERED, null, null)));
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 72, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			gbl_panel.rowHeights = new int[] { 0, 0, 0, 0 };
			gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
					Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
			panel.setLayout(gbl_panel);
			GridBagConstraints gbc_toolBar = new GridBagConstraints();
			gbc_toolBar.gridwidth = 11;
			gbc_toolBar.fill = GridBagConstraints.BOTH;
			gbc_toolBar.insets = new Insets(0, 0, 5, 0);
			gbc_toolBar.gridx = 0;
			gbc_toolBar.gridy = 0;
			panel.add(getToolBar(), gbc_toolBar);
			GridBagConstraints gbc_lblArticulo = new GridBagConstraints();
			gbc_lblArticulo.anchor = GridBagConstraints.WEST;
			gbc_lblArticulo.insets = new Insets(5, 5, 5, 5);
			gbc_lblArticulo.gridx = 0;
			gbc_lblArticulo.gridy = 1;
			panel.add(getLblArticulo(), gbc_lblArticulo);
			GridBagConstraints gbc_lblPeso = new GridBagConstraints();
			gbc_lblPeso.insets = new Insets(5, 5, 5, 5);
			gbc_lblPeso.gridx = 1;
			gbc_lblPeso.gridy = 1;
			panel.add(getLblPeso(), gbc_lblPeso);
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel.gridwidth = 6;
			gbc_lblNewLabel.insets = new Insets(0, 5, 5, 5);
			gbc_lblNewLabel.gridx = 2;
			gbc_lblNewLabel.gridy = 1;
			panel.add(getLblNewLabel(), gbc_lblNewLabel);
			GridBagConstraints gbc_txtArticulo = new GridBagConstraints();
			gbc_txtArticulo.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtArticulo.insets = new Insets(0, 5, 0, 5);
			gbc_txtArticulo.gridx = 0;
			gbc_txtArticulo.gridy = 2;
			panel.add(getTxtArticulo(), gbc_txtArticulo);
			GridBagConstraints gbc_ftxtPeso = new GridBagConstraints();
			gbc_ftxtPeso.insets = new Insets(0, 0, 0, 5);
			gbc_ftxtPeso.fill = GridBagConstraints.HORIZONTAL;
			gbc_ftxtPeso.gridx = 1;
			gbc_ftxtPeso.gridy = 2;
			panel.add(getFtxtPeso(), gbc_ftxtPeso);
			GridBagConstraints gbc_lblNombre = new GridBagConstraints();
			gbc_lblNombre.fill = GridBagConstraints.BOTH;
			gbc_lblNombre.gridwidth = 6;
			gbc_lblNombre.insets = new Insets(0, 5, 0, 5);
			gbc_lblNombre.gridx = 2;
			gbc_lblNombre.gridy = 2;
			panel.add(getLblNombre(), gbc_lblNombre);
			GridBagConstraints gbc_lblIndex = new GridBagConstraints();
			gbc_lblIndex.gridheight = 2;
			gbc_lblIndex.gridwidth = 3;
			gbc_lblIndex.fill = GridBagConstraints.BOTH;
			gbc_lblIndex.gridx = 8;
			gbc_lblIndex.gridy = 1;
			panel.add(getLblIndex(), gbc_lblIndex);
		}
		return panel;
	}

	private JLabel getLblArticulo() {
		if (lblArticulo == null) {
			lblArticulo = new JLabel("Art\u00EDculo");
		}
		return lblArticulo;
	}

	private JTextField getTxtArticulo() {
		if (txtArticulo == null) {
			txtArticulo = new JTextField();
			txtArticulo.addKeyListener(new KeyListener() {

				public void keyPressed(KeyEvent kEvent) {

				}

				public void keyReleased(KeyEvent kEvent) {
					keyPressed = true;
					fillProduct(txtArticulo.getText());
				}

				public void keyTyped(KeyEvent kEvent) {
					UtilEvent.limitMaximunCharactersTyped(kEvent, 3);
				}

			});
			txtArticulo.addFocusListener(new FocusAdapter() {

				public void focusGained(FocusEvent arg0) {
					txtArticulo.setSelectionStart(0);
				}

				@Override
				public void focusLost(FocusEvent e) {
					if (!keyPressed) {
						fillProduct(txtArticulo.getText());
					}
					keyPressed = false;
				}

			});
			txtArticulo.setToolTipText("C\u00F3digo del producto");
			txtArticulo.setColumns(3);
		}
		return txtArticulo;
	}

	protected void fillProduct(String text) {

		if (txtArticulo.getText() != null && txtArticulo.getText().length() == 3) {

			lblNombre.setText(this.controlador.getNombreProducto(text));

			int indice = controlador.getNextIndex(text);
			if (indice > 99) {

				JOptionPane.showMessageDialog(this,
						"Cantidad de piezas del " + txtArticulo.getText() + " es mayor a 99.", "Número de piezas",
						JOptionPane.ERROR_MESSAGE);
				lblNombre.setText("");
				txtArticulo.setText("");
				txtArticulo.requestFocus();
			} else {
				if (lblNombre.getText() != null && !lblNombre.getText().equals("")) {
					ftxtPeso.requestFocus();
				}
				lblIndex.setText(String.valueOf(indice));

			}
		}
	}

	private JLabel getLblPeso() {
		if (lblPeso == null) {
			lblPeso = new JLabel("Peso [Kg]");
		}
		return lblPeso;
	}

	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Producto");
			lblNombre.setFocusable(false);
			lblNombre.setBorder(null);
		}
		return lblNombre;
	}

	private JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("");
			btnSave.setToolTipText("Grabar informaci\u00F3n del prodcuto.");
			btnSave.setActionCommand(ADD);
			btnSave.addActionListener(this);
			btnSave.setIcon(new ImageIcon(Numerados.class.getResource("/imagenes/save.png")));
			btnSave.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "DoClick");
			btnSave.getActionMap().put("DoClick", new AbstractAction() {
				private static final long serialVersionUID = 1L;

				@Override
				public void actionPerformed(ActionEvent e) {
					controlador.grabarNumerado(txtArticulo.getText(), getPeso());
					ftxtPeso.setText("");
				}

			});
		}
		return btnSave;
	}

	public void actionPerformed(final ActionEvent actionEvent) {
		if (ADD.equals(actionEvent.getActionCommand())) {

			controlador.grabarNumerado(txtArticulo.getText(), getPeso());
			ftxtPeso.setText("");
		} else if (DELETE.equals(actionEvent.getActionCommand())) {

			int rowCount = tblNumerados.getSelectedRowCount();
			int[] rows = tblNumerados.getSelectedRows();
			int resultado = JOptionPane.showConfirmDialog(this, "Confirma la eliminación de productos seleccionados.");
			if (resultado == JOptionPane.OK_OPTION) {
				for (int n = 0; n < rowCount; n++) {
					ProductosNumerados item = modeloNumerado.getItem(rows[n]);
					controlador.eliminarNumerado(item);
				}
			}
		} else if (ERASE_ALL.equals(actionEvent.getActionCommand())) {
			int resultado = JOptionPane.showConfirmDialog(this, "Confirma eliminación de todos los productos.");
			if (resultado == JOptionPane.OK_OPTION) {
				controlador.eliminarTodos();
			}
		} else if (PRINT.equals(actionEvent.getActionCommand())) {
			// HojaRuta.getInstance().construirReporte(SincronizacionMMI.fechaReporte);
		}

		fillProducts();
		getTxtArticulo().requestFocus();

	}

	public void fillProducts() {
		SwingWorker<List<ProductosNumerados>, Object> work = new SwingWorker<List<ProductosNumerados>, Object>() {
			@Override
			protected List<ProductosNumerados> doInBackground() throws Exception {
				List<ProductosNumerados> lNumerodos = controlador.obtenerNumerados();

				return lNumerodos;
			}

			@Override
			protected void done() {
				try {
					modeloNumerado.setDatos(get());
					lblIndex.setText("--");
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
			btnDrop.setIcon(new ImageIcon(Numerados.class.getResource("/imagenes/delete.png")));
		}
		return btnDrop;
	}

	private JButton getBtnPrint() {
		if (btnPrint == null) {
			btnPrint = new JButton("");
			btnPrint.setFocusable(false);
			btnPrint.setActionCommand("PRINT");
			btnPrint.addActionListener(this);
			btnPrint.setIcon(new ImageIcon(Numerados.class.getResource("/imagenes/printer.png")));
			btnPrint.setToolTipText("Imprimir reporte de carga.");
		}
		return btnPrint;
	}

	private JLabel getLblIndex() {
		if (lblIndex == null) {
			lblIndex = new JLabel("0");
			lblIndex.setFocusable(false);
			lblIndex.setForeground(new Color(0, 0, 139));
			lblIndex.setBorder(null);
			lblIndex.setHorizontalAlignment(SwingConstants.CENTER);
			lblIndex.setHorizontalTextPosition(SwingConstants.CENTER);
			lblIndex.setFont(new Font("Tahoma", Font.BOLD, 32));
		}
		return lblIndex;
	}

	private JToolBar getToolBar() {
		if (toolBar == null) {
			toolBar = new JToolBar();
			toolBar.setFloatable(false);
			toolBar.setRollover(true);
			toolBar.add(getBtnSave());
			toolBar.add(getBtnDrop());
			toolBar.add(getBtnTrucate());
			toolBar.add(getBtnPrint());
		}
		return toolBar;
	}

	private JButton getBtnTrucate() {
		if (btnTrucate == null) {
			btnTrucate = new JButton("");
			btnTrucate.setFocusable(false);
			btnTrucate.addActionListener(this);
			btnTrucate.setToolTipText("Elimina todos los registros de productos numerados.");
			btnTrucate.setIcon(new ImageIcon(Numerados.class.getResource("/imagenes/refresh.png")));
		}
		return btnTrucate;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Nombre del procucto");
		}
		return lblNewLabel;
	}

	private class FocusTraversal extends FocusTraversalPolicy {

		@Override
		public Component getComponentAfter(Container aContainer, Component aComponent) {

			Component rComponent = getTxtArticulo();

			if (aComponent.equals(getTxtArticulo())) {
				rComponent = getFtxtPeso();
			} else if (aComponent.equals(getFtxtPeso())) {
				rComponent = getBtnSave();
			} else if (aComponent.equals(getBtnSave())) {
				rComponent = getTxtArticulo();
			}

			return rComponent;
		}

		@Override
		public Component getComponentBefore(Container aContainer, Component aComponent) {
			Component rComponent = getTxtArticulo();

			if (aComponent.equals(getTxtArticulo())) {
				rComponent = getBtnSave();
			} else if (aComponent.equals(getFtxtPeso())) {
				rComponent = getTxtArticulo();
			} else if (aComponent.equals(getBtnSave())) {
				rComponent = getFtxtPeso();
			}

			return rComponent;
		}

		@Override
		public Component getDefaultComponent(Container aContainer) {
			return getTxtArticulo();
		}

		@Override
		public Component getFirstComponent(Container aContainer) {
			return getTxtArticulo();
		}

		@Override
		public Component getLastComponent(Container aContainer) {
			return getBtnSave();
		}

	}

	public void focusGained(final FocusEvent arg0) {
		getTxtArticulo().requestFocus();
	}

	public void focusLost(final FocusEvent arg0) {
	}

	private JTextField getFtxtPeso() {
		if (ftxtPeso == null) {
			ftxtPeso = new JTextField();
			ftxtPeso.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					UtilEvent.onlyNumbersAndPointTyped(e);
				}
			});
			ftxtPeso.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					ftxtPeso.selectAll();
				}

			});
			ftxtPeso.setToolTipText("Ingrese el peso del producto.");
		}
		return ftxtPeso;
	}

	private float getPeso() {
		String value = ftxtPeso.getText();
		float resultado = 0;
		char decimalPoint = DecimalFormatSymbols.getInstance().getDecimalSeparator();
		if (',' == decimalPoint) {
			value.replace('.', ',');
		}
		try {
			resultado = Float.parseFloat(value);
		} catch (Exception excep) {
			resultado = 0;
		}
		return resultado;
	}
}
