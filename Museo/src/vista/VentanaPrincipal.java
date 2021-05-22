package vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.BaseDeDatos;
import modelo.Autor;
import modelo.Obra;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private ArrayList<Obra> listadoObras = new ArrayList<Obra>();
	private BaseDeDatos bbdd = new BaseDeDatos();
	private JTextField txtBuscar;
	private JTable tablaConsultas;
	DefaultTableModel modeloTabla = new DefaultTableModel();
	private JButton btnTitulo;
	private JButton btnTipo;
	private JButton btnFecha;
	private JButton btnLugar;
	private JTextField txtTituloObra;
	private JTextField txtTipoObra;
	private JTextField txtLugarObra;
	private JTextField txtFechaObra;
	private JComboBox cmbAutores;
	private JTextField txtAutoresObra;
	private JTextField txtNuevoAutor;
	private JTextField txtIdAutoresObra;

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
		
		JMenuItem mntmAniadir = new JMenuItem("A\u00F1adir");
		mntmAniadir.setHorizontalAlignment(SwingConstants.LEFT);
		mntmAniadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout) (contentPane.getLayout());
				c.show(contentPane, "t1");
			}
		});
		mnPrincipal.add(mntmAniadir);
		
		JMenuItem mntmConsultar = new JMenuItem("Consultar");
		mntmConsultar.setHorizontalAlignment(SwingConstants.LEFT);
		mntmConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout) (contentPane.getLayout());
				c.show(contentPane, "t2");
			}
		});
		mnPrincipal.add(mntmConsultar);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setHorizontalAlignment(SwingConstants.LEFT);
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int siOno = JOptionPane.showConfirmDialog(null, "¿Seguro que quiere salir?","Salir", JOptionPane.YES_NO_OPTION);
				if(siOno==0) {
					dispose();
				}else {
					
				}
				
			}
		});
		mnPrincipal.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		JPanel pAnadir = new JPanel();
		contentPane.add(pAnadir, "t1");
		pAnadir.setLayout(null);

		JButton btnAnadir = new JButton("A\u00F1adir Obra");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Añadir();
			}
		});
		btnAnadir.setBounds(616, 170, 150, 23);
		pAnadir.add(btnAnadir);

		JButton btnLimpiar = new JButton("Limpiar ");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTituloObra.setText("");
				txtTipoObra.setText("");
				txtFechaObra.setText("");
				txtLugarObra.setText("");
				txtAutoresObra.setText("");
			}
		});
		btnLimpiar.setBounds(0, 359, 141, 23);
		pAnadir.add(btnLimpiar);

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
				ResultSet rs = null;
				Statement st = null;
				Connection con = null;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost/db_museo","root","");
					st = con.createStatement();
					String sql = "SELECT * FROM autores";
					rs = st.executeQuery(sql);
					while(rs.next()) {
						cmbAutores.addItem(rs.getString(1)+"."+rs.getString(2));
						txtIdAutoresObra.setText(rs.getString("idAutor"));
						txtAutoresObra.setText(rs.getString("autor"));
					}
					
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					try {
						st.close();
						rs.close();
						con.close();
					}catch(Exception e) {
						JOptionPane.showMessageDialog(null, "Error, cerrar");
					}
				}
			}
		});
		cmbAutores.setBounds(428, 61, 195, 20);
		pAnadir.add(cmbAutores);

		JLabel lblAutorObra = new JLabel("Autor de la obra");
		lblAutorObra.setBounds(428, 36, 150, 14);
		pAnadir.add(lblAutorObra);

		txtAutoresObra = new JTextField();
		txtAutoresObra.setEnabled(false);
		txtAutoresObra.setBounds(489, 117, 134, 20);
		pAnadir.add(txtAutoresObra);
		txtAutoresObra.setColumns(10);
		
		txtIdAutoresObra = new JTextField();
		txtIdAutoresObra.setEnabled(false);
		txtIdAutoresObra.setColumns(10);
		txtIdAutoresObra.setBounds(428, 117, 55, 20);
		pAnadir.add(txtIdAutoresObra);
		
		JLabel lblNuevoAutor = new JLabel("Nuevo autor/a");
		lblNuevoAutor.setBounds(20, 192, 79, 14);
		pAnadir.add(lblNuevoAutor);
		
		txtNuevoAutor = new JTextField();
		txtNuevoAutor.setBounds(20, 217, 150, 20);
		pAnadir.add(txtNuevoAutor);
		txtNuevoAutor.setColumns(10);
		
		JButton btnNuevoAutor = new JButton("A\u00F1adir nuevo/a autor/a");
		btnNuevoAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AñadirNuevoAutor();
			}
		});
		btnNuevoAutor.setBounds(616, 266, 150, 23);
		pAnadir.add(btnNuevoAutor);

		JPanel pConsultar = new JPanel();
		contentPane.add(pConsultar, "t2");
		pConsultar.setLayout(null);

		JLabel lblTituloConsultar = new JLabel(
				"Seleccione un par\u00E1metro de b\u00FAsqueda para la consulta y escriba su consulta");
		lblTituloConsultar.setBounds(10, 11, 415, 14);
		pConsultar.add(lblTituloConsultar);

		JRadioButton rdbtnTituloObra = new JRadioButton("T\u00EDtulo de la obra");
		rdbtnTituloObra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnTitulo.setVisible(true);
				btnTipo.setVisible(false);
				btnFecha.setVisible(false);
				btnLugar.setVisible(false);
				txtBuscar.setVisible(true);
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
		btnTipo.setBounds(170, 61, 89, 23);
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
		btnFecha.setBounds(170, 62, 89, 23);
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
		btnLugar.setBounds(170, 62, 89, 23);
		pConsultar.add(btnLugar);

		JPanel pSalir = new JPanel();
		contentPane.add(pSalir, "t3");
		pSalir.setLayout(null);

		// Oculto botones por las opciones de los radiobutton
		btnTitulo.setVisible(false);
		btnTipo.setVisible(false);
		btnFecha.setVisible(false);
		btnLugar.setVisible(false);
		txtBuscar.setVisible(false);
		cargandoComboPlatforms();
	}

	public void cargandoComboPlatforms() {

		ArrayList<Autor> arrRegistro;
		arrRegistro = bbdd.cargandoComboAutores();

		Iterator<Autor> iterador = arrRegistro.iterator();
		while (iterador.hasNext()) {
			Autor elemento = iterador.next();
			cmbAutores.addItem(elemento.getIdAutor() + ", " + elemento.getNombreAutor());
		}
	}
	
	public void Añadir() {
		
		int valor = JOptionPane.showConfirmDialog(null, "Desea insertar este elemento");
		
		if(JOptionPane.OK_OPTION == valor) {
			
			Obra a = new Obra();
			Autor au = new Autor();
			
			a.setFecha(txtFechaObra.getText());
			a.setTitulo(txtTituloObra.getText());
			a.setLugar(txtLugarObra.getText());
			a.setTipo(txtTipoObra.getText());
			a.setIdAutor(au.getIdAutor());
			au.setNombreAutor(txtAutoresObra.getText());
			try {
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_museo","root","");
				Statement aniadirObra = conexion.createStatement();
				
				aniadirObra.executeUpdate("insert into obras(fecha, titulo, lugar, idAutor,tipo) values("
						+ a.getFecha() + ",'" 
						+ a.getTitulo() +"',"
						+ a.getLugar() + ","
						+ a.getIdAutor() + ","
						+ a.getTipo() + "'"
						+ ")");
				
				conexion.close();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
	public void AñadirNuevoAutor() {
		int valor = JOptionPane.showConfirmDialog(null, "Desea insertar este elemento");
		if(JOptionPane.OK_OPTION == valor) {
			
			Autor au = new Autor();
			//
			
			au.setNombreAutor(txtNuevoAutor.getText());
			try {
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_museo","root","");
				
				Statement aniadirAutor = conexion.createStatement();
				aniadirAutor.executeUpdate("insert into autores(autor) values("
						+ au.getNombreAutor() + "'"
						+ ")");
				conexion.close();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
}
