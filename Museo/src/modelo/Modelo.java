package modelo;

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

public class Modelo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modelo frame = new Modelo();
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
	public Modelo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 802, 453);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c=(CardLayout)(contentPane.getLayout());
				c.show(contentPane, "t2");
			}
		});
		
		JMenu mnNewMenu_1 = new JMenu("New menu");
		mnNewMenu.add(mnNewMenu_1);
		
		JButton btnAnadirAutor = new JButton("A\u00F1adir Autor");
		mnNewMenu_1.add(btnAnadirAutor);
		
		JButton btnNewButton_1 = new JButton("A\u00F1adir Obra");
		mnNewMenu_1.add(btnNewButton_1);
		mnNewMenu.add(btnConsultar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c=(CardLayout)(contentPane.getLayout());
				c.show(contentPane, "t3");
			}
		});
		mnNewMenu.add(btnSalir);
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
		
		JPanel pSalir = new JPanel();
		contentPane.add(pSalir, "t3");
		pSalir.setLayout(null);
	}
}
