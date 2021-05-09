package vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
				CardLayout c=(CardLayout)(contentPane.getLayout());
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
				CardLayout c=(CardLayout)(contentPane.getLayout());
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
		
		JPanel pConsultar = new JPanel();
		contentPane.add(pConsultar, "t2");
		pConsultar.setLayout(null);
		
		JLabel lblTituloConsultar = new JLabel("Seleccione un par\u00E1metro de b\u00FAsqueda para la consulta");
		lblTituloConsultar.setBounds(10, 11, 290, 14);
		pConsultar.add(lblTituloConsultar);
		
		JRadioButton rdbtnTituloObra = new JRadioButton("T\u00EDtulo de la obra");
		buttonGroup.add(rdbtnTituloObra);
		rdbtnTituloObra.setBounds(10, 32, 109, 23);
		pConsultar.add(rdbtnTituloObra);
		
		JRadioButton rdbtnTipoObra = new JRadioButton("Tipo de obra");
		buttonGroup.add(rdbtnTipoObra);
		rdbtnTipoObra.setBounds(121, 32, 109, 23);
		pConsultar.add(rdbtnTipoObra);
		
		JRadioButton rdbtnFecha = new JRadioButton("Fecha");
		buttonGroup.add(rdbtnFecha);
		rdbtnFecha.setBounds(232, 32, 109, 23);
		pConsultar.add(rdbtnFecha);
		
		JRadioButton rdbtnUbicacion = new JRadioButton("Ubicaci\u00F3n de la obra");
		buttonGroup.add(rdbtnUbicacion);
		rdbtnUbicacion.setBounds(343, 32, 135, 23);
		pConsultar.add(rdbtnUbicacion);
		
		JPanel pSalir = new JPanel();
		contentPane.add(pSalir, "t3");
		pSalir.setLayout(null);
	}
}
