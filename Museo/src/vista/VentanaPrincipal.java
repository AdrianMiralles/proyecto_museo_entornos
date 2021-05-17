package vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.BaseDeDatos;
import controlador.Fichero;
import modelo.Autor;
import modelo.Obra;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private ArrayList<Obra> listadoObras = new ArrayList<Obra>();
	private ArrayList<Autor> listadoAutores = new ArrayList<Autor>();
	private BaseDeDatos bbdd = new BaseDeDatos();
	private JTextField txtBuscar;
	private JTable tablaConsultas;
	DefaultTableModel modeloTabla = new DefaultTableModel();
	DefaultTableModel modeloTabla_1 = new DefaultTableModel();
	private JButton btnTitulo;
	private JButton btnTipo;
	private JButton btnFecha;
	private JButton btnLugar;
	private JButton btnGenerarXLS;
	private JTextField txtTituloObra;
	private JTextField txtTipoObra;
	private JTextField txtLugarObra;
	private JTextField txtFechaObra;
	private JComboBox cmbAutores;
	private JTextField txtAutoresObra;
	private JLabel lblImagen;
	private JLabel lblImagenAutor;
	private JTable table;
	private JTextField textNombreArchivo;
	private Fichero fichero = new Fichero();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 1000);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnPrincipal = new JMenu("Menu");
		menuBar.add(mnPrincipal);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout) (contentPane.getLayout());
				c.show(contentPane, "t2");
			}
		});

		JMenu mnAnanirVar = new JMenu("A\u00F1adir");
		mnPrincipal.add(mnAnanirVar);

		JButton btnAnadirAutor = new JButton("A\u00F1adir Autor");
		mnAnanirVar.add(btnAnadirAutor);

		JButton btnNewButton_1 = new JButton("A\u00F1adir Obra");
		mnAnanirVar.add(btnNewButton_1);
		mnPrincipal.add(btnConsultar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout) (contentPane.getLayout());
				c.show(contentPane, "t3");
			}
		});
		mnPrincipal.add(btnSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		JPanel pAnadir = new JPanel();
		contentPane.add(pAnadir, "t1");
		pAnadir.setLayout(null);

		JButton btnLimpiar = new JButton("A\u00F1adir");
		btnLimpiar.setBounds(687, 358, 89, 23);
		pAnadir.add(btnLimpiar);

		JButton btnAnadir = new JButton("Limpiar ");
		btnAnadir.setBounds(0, 358, 89, 23);
		pAnadir.add(btnAnadir);

		JLabel lblTituloVentanaAniadir = new JLabel(
				"Si desea a\u00F1adir una nueva obra rellene todos los campos correctamente.");
		lblTituloVentanaAniadir.setBounds(10, 11, 376, 14);
		pAnadir.add(lblTituloVentanaAniadir);

		JLabel lblTituloObra = new JLabel("T\u00EDtulo de la obra");
		lblTituloObra.setBounds(20, 36, 150, 14);
		pAnadir.add(lblTituloObra);

		txtTituloObra = new JTextField();
		txtTituloObra.setBounds(20, 61, 150, 20);
		pAnadir.add(txtTituloObra);
		txtTituloObra.setColumns(10);

		JLabel lblTipoObra = new JLabel("Tipo de obra");
		lblTipoObra.setBounds(20, 92, 150, 14);
		pAnadir.add(lblTipoObra);

		txtTipoObra = new JTextField();
		txtTipoObra.setBounds(20, 117, 150, 20);
		pAnadir.add(txtTipoObra);
		txtTipoObra.setColumns(10);

		JLabel lblFechaObra = new JLabel("Fecha de creaci\u00F3n");
		lblFechaObra.setBounds(220, 36, 150, 14);
		pAnadir.add(lblFechaObra);

		JLabel lblLugarObra = new JLabel("Ubicaci\u00F3n de la obra");
		lblLugarObra.setBounds(220, 92, 150, 14);
		pAnadir.add(lblLugarObra);

		txtLugarObra = new JTextField();
		txtLugarObra.setColumns(10);
		txtLugarObra.setBounds(220, 117, 150, 20);
		pAnadir.add(txtLugarObra);

		txtFechaObra = new JTextField();
		txtFechaObra.setColumns(10);
		txtFechaObra.setBounds(220, 61, 150, 20);
		pAnadir.add(txtFechaObra);

		cmbAutores = new JComboBox();
		cmbAutores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		cmbAutores.setBounds(20, 173, 150, 20);
		pAnadir.add(cmbAutores);

		JLabel lblAutorObra = new JLabel("Autor de la obra");
		lblAutorObra.setBounds(20, 148, 150, 14);
		pAnadir.add(lblAutorObra);

		txtAutoresObra = new JTextField();
		txtAutoresObra.setEnabled(false);
		txtAutoresObra.setBounds(20, 204, 150, 20);
		pAnadir.add(txtAutoresObra);
		txtAutoresObra.setColumns(10);

		JPanel pConsultar = new JPanel();
		contentPane.add(pConsultar, "t2");
		pConsultar.setLayout(null);

		JLabel lblTituloConsultar = new JLabel(
				"Seleccione un par\u00E1metro de b\u00FAsqueda para la consulta y escriba su consulta");
		lblTituloConsultar.setBounds(10, 11, 465, 14);
		pConsultar.add(lblTituloConsultar);

		JRadioButton rdbtnTituloObra = new JRadioButton("T\u00EDtulo de la obra");
		rdbtnTituloObra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnTitulo.setVisible(true);
				btnTipo.setVisible(false);
				btnFecha.setVisible(false);
				btnLugar.setVisible(false);
				txtBuscar.setVisible(true);
				textNombreArchivo.setVisible(false);
				btnGenerarXLS.setVisible(false);
				txtBuscar.setText("");
				textNombreArchivo.setText("");
			}
		});
		buttonGroup.add(rdbtnTituloObra);
		rdbtnTituloObra.setBounds(10, 32, 120, 23);
		pConsultar.add(rdbtnTituloObra);

		JRadioButton rdbtnTipoObra = new JRadioButton("Tipo de obra");
		rdbtnTipoObra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnTitulo.setVisible(false);
				btnTipo.setVisible(true);
				btnFecha.setVisible(false);
				btnLugar.setVisible(false);
				txtBuscar.setVisible(true);
				textNombreArchivo.setVisible(false);
				btnGenerarXLS.setVisible(false);
				txtBuscar.setText("");
				textNombreArchivo.setText("");
			}
		});
		buttonGroup.add(rdbtnTipoObra);
		rdbtnTipoObra.setBounds(132, 32, 109, 23);
		pConsultar.add(rdbtnTipoObra);

		JRadioButton rdbtnFecha = new JRadioButton("Fecha");
		rdbtnFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnTitulo.setVisible(false);
				btnTipo.setVisible(false);
				btnFecha.setVisible(true);
				btnLugar.setVisible(false);
				txtBuscar.setVisible(true);
				textNombreArchivo.setVisible(false);
				btnGenerarXLS.setVisible(false);
				txtBuscar.setText("");
				textNombreArchivo.setText("");
			}
		});
		buttonGroup.add(rdbtnFecha);
		rdbtnFecha.setBounds(243, 32, 80, 23);
		pConsultar.add(rdbtnFecha);

		JRadioButton rdbtnUbicacion = new JRadioButton("Ubicaci\u00F3n de la obra");
		rdbtnUbicacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnTitulo.setVisible(false);
				btnTipo.setVisible(false);
				btnFecha.setVisible(false);
				btnLugar.setVisible(true);
				txtBuscar.setVisible(true);
				textNombreArchivo.setVisible(false);
				btnGenerarXLS.setVisible(false);
				txtBuscar.setText("");
				textNombreArchivo.setText("");
			}
		});
		buttonGroup.add(rdbtnUbicacion);
		rdbtnUbicacion.setBounds(325, 32, 150, 23);
		pConsultar.add(rdbtnUbicacion);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(10, 62, 150, 20);
		pConsultar.add(txtBuscar);
		txtBuscar.setColumns(10);

		btnTitulo = new JButton("Consultar");
		btnTitulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtBuscar.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Compruebe que la caja de texto no esté vacía.", "Alerta",
							JOptionPane.WARNING_MESSAGE);
				} else {

					listadoObras = bbdd.consulta("titulo", txtBuscar.getText());// llamo al método
																				// pasándole un
																				// parámetro con el
																				// texto
					// específico y guardo el arraylist que devuelve para
					// despues volcarlo en un JTable

					modeloTabla
							.setColumnIdentifiers(new Object[] { "Título", "Tipo", "Fecha", "Ubicación", "IdAutor" });
					modeloTabla.setRowCount(0);
					tablaConsultas.setModel(modeloTabla);

					Iterator<Obra> iterador = listadoObras.iterator();
					while (iterador.hasNext()) {
						Obra elemento = iterador.next();
						modeloTabla.addRow(new Object[] { // carga la tabla con los elementos indicados
								elemento.getTitulo(), elemento.getTipo(), elemento.getFecha(), elemento.getLugar(),
								elemento.getIdAutor() });
					}
					tablaConsultas.getColumnModel().getColumn(4).setMaxWidth(80);
					textNombreArchivo.setVisible(true);
					btnGenerarXLS.setVisible(true);
				}
			}
		});
		btnTitulo.setBounds(170, 61, 120, 23);
		pConsultar.add(btnTitulo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 93, 756, 278);
		pConsultar.add(scrollPane);

		tablaConsultas = new JTable();
		tablaConsultas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() == 1) {// configuro un mousePressed y le indico que escriba en el txt el contenido
					// de la fila 0 donde hacemos clic
					ImageIcon icon = new ImageIcon("imagenes\\"
							+ tablaConsultas.getValueAt(tablaConsultas.getSelectedRow(), 0).toString() + ".jpg");
					Image conversion = icon.getImage();// recojo la imagen con icon, la guardo en conversion de manera
														// que podré modificar sus parámetros de tamaño y finalmente
														// asigno el tamaño a una imagenIcon y creo un objeto para
														// guardar la imagen completa modificada
					Image tamanio = conversion.getScaledInstance(756, 536, Image.SCALE_SMOOTH);
					ImageIcon fin = new ImageIcon(tamanio);
					lblImagen.setIcon(fin);
					lblImagen.setVisible(true);
				}

			}
		});
		scrollPane.setColumnHeaderView(tablaConsultas);
		scrollPane.setViewportView(tablaConsultas);

		btnTipo = new JButton("Consultar");
		btnTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtBuscar.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Compruebe que la caja de texto no esté vacía.", "Alerta",
							JOptionPane.WARNING_MESSAGE);
				} else {

					listadoObras = bbdd.consulta("tipo", txtBuscar.getText());// llamo al método
																				// pasándole un
																				// parámetro con el
																				// texto
					// específico y guardo el arraylist que devuelve para
					// despues volcarlo en un JTable

					modeloTabla
							.setColumnIdentifiers(new Object[] { "Título", "Tipo", "Fecha", "Ubicación", "IdAutor" });
					modeloTabla.setRowCount(0);
					tablaConsultas.setModel(modeloTabla);

					Iterator<Obra> iterador = listadoObras.iterator();
					while (iterador.hasNext()) {
						Obra elemento = iterador.next();
						modeloTabla.addRow(new Object[] { // carga la tabla con los elementos indicados
								elemento.getTitulo(), elemento.getTipo(), elemento.getFecha(), elemento.getLugar(),
								elemento.getIdAutor() });
					}
					tablaConsultas.getColumnModel().getColumn(4).setMaxWidth(80);
					textNombreArchivo.setVisible(true);
					btnGenerarXLS.setVisible(true);
				}
			}
		});
		btnTipo.setBounds(170, 61, 120, 23);
		pConsultar.add(btnTipo);

		btnFecha = new JButton("Consultar");
		btnFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtBuscar.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Compruebe que la caja de texto no esté vacía.", "Alerta",
							JOptionPane.WARNING_MESSAGE);
				} else {

					listadoObras = bbdd.consulta("fecha", txtBuscar.getText());// llamo al método
																				// pasándole un
																				// parámetro con el
																				// texto
					// específico y guardo el arraylist que devuelve para
					// despues volcarlo en un JTable

					modeloTabla
							.setColumnIdentifiers(new Object[] { "Título", "Tipo", "Fecha", "Ubicación", "IdAutor" });
					modeloTabla.setRowCount(0);
					tablaConsultas.setModel(modeloTabla);

					Iterator<Obra> iterador = listadoObras.iterator();
					while (iterador.hasNext()) {
						Obra elemento = iterador.next();
						modeloTabla.addRow(new Object[] { // carga la tabla con los elementos indicados
								elemento.getTitulo(), elemento.getTipo(), elemento.getFecha(), elemento.getLugar(),
								elemento.getIdAutor() });
					}
					tablaConsultas.getColumnModel().getColumn(4).setMaxWidth(80);
					textNombreArchivo.setVisible(true);
					btnGenerarXLS.setVisible(true);
				}
			}
		});
		btnFecha.setBounds(170, 62, 120, 23);
		pConsultar.add(btnFecha);

		btnLugar = new JButton("Consultar");
		btnLugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtBuscar.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Compruebe que la caja de texto no esté vacía.", "Alerta",
							JOptionPane.WARNING_MESSAGE);
				} else {

					listadoObras = bbdd.consulta("lugar", txtBuscar.getText());// llamo al método
																				// pasándole un
																				// parámetro con el
																				// texto
					// específico y guardo el arraylist que devuelve para
					// despues volcarlo en un JTable

					modeloTabla
							.setColumnIdentifiers(new Object[] { "Título", "Tipo", "Fecha", "Ubicación", "IdAutor" });
					modeloTabla.setRowCount(0);
					tablaConsultas.setModel(modeloTabla);

					Iterator<Obra> iterador = listadoObras.iterator();
					while (iterador.hasNext()) {
						Obra elemento = iterador.next();
						modeloTabla.addRow(new Object[] { // carga la tabla con los elementos indicados
								elemento.getTitulo(), elemento.getTipo(), elemento.getFecha(), elemento.getLugar(),
								elemento.getIdAutor() });
					}
					tablaConsultas.getColumnModel().getColumn(4).setMaxWidth(80);
					textNombreArchivo.setVisible(true);
					btnGenerarXLS.setVisible(true);
				}
			}
		});
		btnLugar.setBounds(170, 62, 120, 23);
		pConsultar.add(btnLugar);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(776, 93, 388, 278);
		pConsultar.add(scrollPane_1);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() == 1) {// configuro un mousePressed y le indico que escriba en el txt el contenido
					// de la fila 0 donde hacemos clic
					ImageIcon icon = new ImageIcon(
							"imagenes\\" + table.getValueAt(table.getSelectedRow(), 0).toString() + ".jpg");
					Image conversion = icon.getImage();// recojo la imagen con icon, la guardo en conversion de manera
														// que podré modificar sus parámetros de tamaño y finalmente
														// asigno el tamaño a una imagenIcon y creo un objeto para
														// guardar la imagen completa modificada
					Image tamanio = conversion.getScaledInstance(382, 388, Image.SCALE_SMOOTH);
					ImageIcon fin = new ImageIcon(tamanio);
					lblImagenAutor.setIcon(fin);
					lblImagenAutor.setVisible(true);
				}
			}
		});
		scrollPane_1.setColumnHeaderView(table);
		scrollPane_1.setViewportView(table);
		JButton btnCargarAutores = new JButton("Cargar Autores");
		btnCargarAutores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listadoAutores = bbdd.consultaAutores();

				modeloTabla_1.setColumnIdentifiers(new Object[] { "idAutor", "Autores" });
				modeloTabla_1.setRowCount(0);
				table.setModel(modeloTabla_1);

				Iterator<Autor> iterador = listadoAutores.iterator();
				while (iterador.hasNext()) {
					Autor elemento = iterador.next();
					modeloTabla_1.addRow(new Object[] { // carga la tabla con los elementos indicados
							elemento.getIdAutor(), elemento.getNombreAutor() });
				}
				table.getColumnModel().getColumn(1).setMinWidth(40);// Doy tamaño a la columnas
				table.getColumnModel().getColumn(0).setMaxWidth(80);
			}
		});
		btnCargarAutores.setBounds(776, 61, 150, 23);
		pConsultar.add(btnCargarAutores);

		btnGenerarXLS = new JButton("Generar XLS");
		btnGenerarXLS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textNombreArchivo.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Asegurese de dar un nombre a su archivo para generarlo",
							"Alerta", JOptionPane.WARNING_MESSAGE);
				} else {
					String nombre = textNombreArchivo.getText();
					fichero.generarXLS(listadoObras, nombre);
				}
				textNombreArchivo.setText("");
			}
		});
		btnGenerarXLS.setBounds(646, 61, 120, 23);
		pConsultar.add(btnGenerarXLS);

		textNombreArchivo = new JTextField();
		textNombreArchivo.setBounds(516, 62, 120, 20);
		pConsultar.add(textNombreArchivo);
		textNombreArchivo.setColumns(10);

		lblImagen = new JLabel(" ");
		lblImagen.setBounds(10, 382, 756, 536);
		lblImagen.setIcon(new ImageIcon("imagenes\\no-disponible.jpg"));
		pConsultar.add(lblImagen);

		lblImagenAutor = new JLabel(" ");
		lblImagenAutor.setBounds(776, 382, 388, 336);
		pConsultar.add(lblImagenAutor);
		
		JLabel lblNewLabel = new JLabel("(Sugerencia: buscar Guernica y autor 36, y hacer clic correspondiente a sus filas en la tabla)");
		lblNewLabel.setBounds(480, 11, 645, 14);
		pConsultar.add(lblNewLabel);

		JPanel pSalir = new JPanel();
		contentPane.add(pSalir, "t3");
		pSalir.setLayout(null);

		// Oculto botones por las opciones de los radiobutton
		btnTitulo.setVisible(false);
		btnTipo.setVisible(false);
		btnFecha.setVisible(false);
		btnLugar.setVisible(false);
		txtBuscar.setVisible(false);
		textNombreArchivo.setVisible(false);
		btnGenerarXLS.setVisible(false);
		lblImagen.setVisible(false);
		cargandoComboAutores();
	}

	/**
	 * Método para llamar a la base de datos y cargar un jCombobox con el registro
	 * resultante
	 */
	public void cargandoComboAutores() {

		ArrayList<Autor> arrRegistro;
		arrRegistro = bbdd.cargandoComboAutores();

		Iterator<Autor> iterador = arrRegistro.iterator();
		while (iterador.hasNext()) {
			Autor elemento = iterador.next();
			cmbAutores.addItem(elemento.getIdAutor() + ", " + elemento.getNombreAutor());
		}
	}
}
