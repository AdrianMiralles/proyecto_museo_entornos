package vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.BaseDeDatos;
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
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private ArrayList<Obra> listadoObras = new ArrayList<Obra>();
	private BaseDeDatos bbdd = new BaseDeDatos();
	private JTextField txtBuscar;
	private JTable tablaConsultas;
	DefaultTableModel modeloTabla = new DefaultTableModel();
	private JButton btnTitulo;
	private JButton btnTipoObra;
	private JButton btnFechaObra;
	private JButton btnUbicacionObra;
	private JTextField txtfIdObra;
	private JTextField textFAutor;
	private JTextField textFTitulo;
	private JTextField textFTipo;
	private JTextField textFFecha;
	private JTextField textFLugar;
	private JTextField textFNombreArtista;

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
		setBounds(100, 100, 802, 453);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnPrincipal = new JMenu("Menu");
		menuBar.add(mnPrincipal);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout) (contentPane.getLayout());
				c.show(contentPane, "t3");
			}
		});

		JMenu mnAnanirVar = new JMenu("A\u00F1adir");
		mnPrincipal.add(mnAnanirVar);

		JButton btnAnadirAutor = new JButton("A\u00F1adir Autor");
		btnAnadirAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout) (contentPane.getLayout());
				c.show(contentPane, "t2");
			}
		});
		mnAnanirVar.add(btnAnadirAutor);
		btnAnadirAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout) (contentPane.getLayout());
				c.show(contentPane, "t2");
			}
		});
		JButton btnAnadirObra = new JButton("A\u00F1adir Obra");
		btnAnadirObra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout) (contentPane.getLayout());
				c.show(contentPane, "t1");
			}
		});
		mnAnanirVar.add(btnAnadirObra);
		mnPrincipal.add(btnConsultar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		mnPrincipal.add(btnSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		JPanel pAnadirObra = new JPanel();
		contentPane.add(pAnadirObra, "t1");
		pAnadirObra.setLayout(null);

		JButton btnLimpiar = new JButton("A\u00F1adir");
		btnLimpiar.setBounds(687, 358, 89, 23);
		pAnadirObra.add(btnLimpiar);

		JButton btnAnadir = new JButton("Limpiar ");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtfIdObra.setText("");
				textFAutor.setText("");
				textFTitulo.setText("");
				textFTipo.setText("");
				textFFecha.setText("");
				textFLugar.setText("");
			}
		});
		btnAnadir.setBounds(0, 358, 89, 23);
		pAnadirObra.add(btnAnadir);

		JLabel lblNewLabel = new JLabel("Introduzca los datos a continuaci\u00F3n:");
		lblNewLabel.setBounds(10, 11, 181, 14);
		pAnadirObra.add(lblNewLabel);

		JLabel lblIdObra = new JLabel("ID Obra");
		lblIdObra.setBounds(10, 63, 46, 14);
		pAnadirObra.add(lblIdObra);

		txtfIdObra = new JTextField();
		txtfIdObra.setBounds(10, 78, 86, 20);
		pAnadirObra.add(txtfIdObra);
		txtfIdObra.setColumns(10);

		JLabel lblIdAutor = new JLabel("ID Autor");
		lblIdAutor.setBounds(10, 109, 46, 14);
		pAnadirObra.add(lblIdAutor);

		textFAutor = new JTextField();
		textFAutor.setBounds(10, 123, 86, 20);
		pAnadirObra.add(textFAutor);
		textFAutor.setColumns(10);

		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(10, 154, 46, 14);
		pAnadirObra.add(lblTitulo);

		textFTitulo = new JTextField();
		textFTitulo.setBounds(10, 166, 86, 20);
		pAnadirObra.add(textFTitulo);
		textFTitulo.setColumns(10);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(10, 197, 46, 14);
		pAnadirObra.add(lblTipo);

		textFTipo = new JTextField();
		textFTipo.setBounds(10, 211, 86, 20);
		pAnadirObra.add(textFTipo);
		textFTipo.setColumns(10);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 242, 46, 14);
		pAnadirObra.add(lblFecha);

		textFFecha = new JTextField();
		textFFecha.setBounds(10, 256, 86, 20);
		pAnadirObra.add(textFFecha);
		textFFecha.setColumns(10);

		JLabel lblLugar = new JLabel("Lugar");
		lblLugar.setBounds(10, 287, 46, 14);
		pAnadirObra.add(lblLugar);

		textFLugar = new JTextField();
		textFLugar.setBounds(10, 302, 86, 20);
		pAnadirObra.add(textFLugar);
		textFLugar.setColumns(10);

		JPanel pConsultar = new JPanel();
		contentPane.add(pConsultar, "t3");
		pConsultar.setLayout(null);

		JLabel lblTituloConsultar = new JLabel("Seleccione un par\u00E1metro de b\u00FAsqueda para la consulta");
		lblTituloConsultar.setBounds(10, 11, 290, 14);
		pConsultar.add(lblTituloConsultar);

		JRadioButton rdbtnTituloObra = new JRadioButton("T\u00EDtulo de la obra");
		rdbtnTituloObra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnTitulo.setVisible(true);
				btnTipoObra.setVisible(false);
				btnFechaObra.setVisible(false);
				btnUbicacionObra.setVisible(false);
			}
		});
		buttonGroup.add(rdbtnTituloObra);
		rdbtnTituloObra.setBounds(10, 32, 109, 23);
		pConsultar.add(rdbtnTituloObra);

		JRadioButton rdbtnTipoObra = new JRadioButton("Tipo de obra");
		rdbtnTipoObra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnTitulo.setVisible(false);
				btnTipoObra.setVisible(true);
				btnFechaObra.setVisible(false);
				btnUbicacionObra.setVisible(false);
			}
		});
		buttonGroup.add(rdbtnTipoObra);
		rdbtnTipoObra.setBounds(121, 32, 109, 23);
		pConsultar.add(rdbtnTipoObra);

		JRadioButton rdbtnFecha = new JRadioButton("Fecha");
		rdbtnFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnTitulo.setVisible(false);
				btnTipoObra.setVisible(false);
				btnFechaObra.setVisible(true);
				btnUbicacionObra.setVisible(false);
			}
		});
		buttonGroup.add(rdbtnFecha);
		rdbtnFecha.setBounds(232, 32, 109, 23);
		pConsultar.add(rdbtnFecha);

		JRadioButton rdbtnUbicacion = new JRadioButton("Ubicaci\u00F3n de la obra");
		rdbtnUbicacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnTitulo.setVisible(false);
				btnTipoObra.setVisible(false);
				btnFechaObra.setVisible(false);
				btnUbicacionObra.setVisible(true);
			}
		});
		buttonGroup.add(rdbtnUbicacion);
		rdbtnUbicacion.setBounds(343, 32, 135, 23);
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

					modeloTabla.setColumnIdentifiers(new Object[] { "Título", "Tipo", "Fecha", "Ubicación" });
					modeloTabla.setRowCount(0);
					tablaConsultas.setModel(modeloTabla);

					Iterator<Obra> iterador = listadoObras.iterator();
					while (iterador.hasNext()) {
						Obra elemento = iterador.next();
						modeloTabla.addRow(new Object[] { // carga la tabla con los elementos indicados
								elemento.getTitulo(), elemento.getTipo(), elemento.getFecha(), elemento.getLugar() });
					}
				}
			}
		});
		btnTitulo.setBounds(170, 61, 89, 23);
		pConsultar.add(btnTitulo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 93, 756, 278);
		pConsultar.add(scrollPane);

		tablaConsultas = new JTable();
		scrollPane.setColumnHeaderView(tablaConsultas);
		scrollPane.setViewportView(tablaConsultas);

		btnTipoObra = new JButton("Consultar");
		btnTipoObra.setBounds(170, 61, 89, 23);
		pConsultar.add(btnTipoObra);

		btnFechaObra = new JButton("Consultar");
		btnFechaObra.setBounds(170, 61, 89, 23);
		pConsultar.add(btnFechaObra);

		btnUbicacionObra = new JButton("Consultar");
		btnUbicacionObra.setBounds(170, 62, 89, 23);
		pConsultar.add(btnUbicacionObra);

		JPanel pAnadirArtista = new JPanel();
		pAnadirArtista.setLayout(null);
		contentPane.add(pAnadirArtista, "t2");

		JButton btnLimpiar_1 = new JButton("A\u00F1adir");
		btnLimpiar_1.setBounds(687, 358, 89, 23);
		pAnadirArtista.add(btnLimpiar_1);

		JButton btnAnadir_1 = new JButton("Limpiar ");
		btnAnadir_1.setBounds(0, 358, 89, 23);
		pAnadirArtista.add(btnAnadir_1);

		JLabel lblIntro = new JLabel("Introduzca los datos a continuaci\u00F3n:");
		lblIntro.setBounds(10, 11, 181, 14);
		pAnadirArtista.add(lblIntro);

		JLabel lblNombre = new JLabel("Nombre artista");
		lblNombre.setBounds(10, 73, 71, 14);
		pAnadirArtista.add(lblNombre);

		textFNombreArtista = new JTextField();
		textFNombreArtista.setBounds(10, 86, 86, 20);
		pAnadirArtista.add(textFNombreArtista);
		textFNombreArtista.setColumns(10);
		
		btnTitulo.setVisible(false);
		btnTipoObra.setVisible(false);
		btnFechaObra.setVisible(false);
		btnUbicacionObra.setVisible(false);
	}
}
