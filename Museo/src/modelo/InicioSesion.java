package modelo;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

@SuppressWarnings("serial")
public class InicioSesion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton inicioButton;
	private JButton registroButton;
	private String usuario;
	private String password;
	private final ButtonGroup botonesTiposDeUsuario = new ButtonGroup();
	private File usuarios = new File("usuarios.txt");
	private ArrayList<String> guardaNombres = new ArrayList<>();
	private ArrayList<String> guardaContrasenias = new ArrayList<>();
	private ArrayList<String> guardaTipo = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InicioSesion dialog = new InicioSesion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Crea el panel de opciones para registro e inicio de sesión
	 */
	public InicioSesion() {
		setTitle("Panel de Inicio");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Galerias");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 44));
			lblNewLabel.setBounds(215, 11, 173, 54);
			contentPanel.add(lblNewLabel);
		}

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(31, 38, 123, 175);
		contentPanel.add(lblNewLabel_1);

		JPanel buttonPane = new JPanel();
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		{
			inicioButton = new JButton("Iniciar Sesi\u00F3n");
			inicioButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					iniciodeSesion();

				}
			});
			inicioButton.setActionCommand("OK");
			getRootPane().setDefaultButton(inicioButton);

			registroButton = new JButton("Registrarse");
			registroButton.setActionCommand("Cancel");
			registroButton.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					registro();

				}
			});

			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup().addGap(90).addComponent(inicioButton).addGap(30)
							.addComponent(registroButton).addGap(128)));
			gl_buttonPane.setVerticalGroup(gl_buttonPane.createParallelGroup(Alignment.LEADING).addGroup(gl_buttonPane
					.createParallelGroup(Alignment.BASELINE).addComponent(registroButton).addComponent(inicioButton)));
			buttonPane.setLayout(gl_buttonPane);
		}
	}

	public void registro() {

		JTextField usuarioTxt = new JTextField();
		JPasswordField contraseniaTxt = new JPasswordField();
		JPasswordField contraseniaConfirmacionTxt = new JPasswordField();
		JLabel imagen = new JLabel();
		char[] contraseniaAConvertir;
		char[] contraseniaConfirmacionAConvertir;
		String contraseniaConvertida;
		String contraseniaConfirmacionConvertida;
		boolean admin;
		JRadioButton radioAdmin = new JRadioButton("Administrador");
		botonesTiposDeUsuario.add(radioAdmin);
		radioAdmin.setBounds(240, 114, 111, 23);
		JRadioButton radioVisitante = new JRadioButton("Visitante");
		botonesTiposDeUsuario.add(radioVisitante);
		radioVisitante.setBounds(240, 190, 111, 23);
		Object[] campoDeDatos = { "Usuario", usuarioTxt, radioAdmin, radioVisitante, "Contraseña", contraseniaTxt,
				"Repita la contraseña", contraseniaConfirmacionTxt };
		Object[] opcionFormulario = { "Registrarse" };
		Object[] ok = { "OK" };

		usuarioTxt.setText(getUsuario());
		contraseniaTxt.setText(getPassword());
		contraseniaConfirmacionTxt.setText(null);
		setUsuario(null);
		setPassword(null);

		int option = JOptionPane.showOptionDialog(this, campoDeDatos, "Registro de Usuario", JOptionPane.OK_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, opcionFormulario, opcionFormulario[0]);

		contraseniaAConvertir = contraseniaTxt.getPassword();
		contraseniaConfirmacionAConvertir = contraseniaConfirmacionTxt.getPassword();
		contraseniaConvertida = String.valueOf(contraseniaAConvertir);
		contraseniaConfirmacionConvertida = String.valueOf(contraseniaConfirmacionAConvertir);
		System.out.println("Usuario: " + usuarioTxt.getText());
		System.out.println("Contraseña: " + contraseniaConvertida);
		System.out.println("Confirmación: " + contraseniaConfirmacionConvertida);
		if (usuarioTxt.getText().isEmpty() || contraseniaTxt.getText().isEmpty()
				|| contraseniaConfirmacionTxt.getText().isEmpty()
				|| !radioAdmin.isSelected() && !radioVisitante.isSelected()) {
			JOptionPane.showOptionDialog(this, "Rellene todos los campos antes de continuar", "Error",
					JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE, null, ok, ok[0]);
			setUsuario(usuarioTxt.getText());
			setPassword(contraseniaTxt.getText());
			registro();

		} else {
			if (!(contraseniaConvertida.equals(contraseniaConfirmacionConvertida))) {
				JOptionPane.showOptionDialog(this, "Las contraseñas no coinciden", "Error", JOptionPane.OK_OPTION,
						JOptionPane.ERROR_MESSAGE, null, ok, ok[0]);
				System.out.println("Primer If");

				setUsuario(usuarioTxt.getText());
				setPassword(contraseniaTxt.getText());
				registro();

			} else if ((contraseniaConvertida.equals(contraseniaConfirmacionConvertida))) {
				System.out.println("Segundo If");
				setUsuario(usuarioTxt.getText());
				setPassword(contraseniaConvertida);
				if (radioAdmin.isSelected()) {
					creacionUsuarioAdmin();

				} else if (radioVisitante.isSelected()) {
					creacionUsuarioVisitante();
				}

				setUsuario(null);
				setPassword(null);

			} else if (option == JOptionPane.CLOSED_OPTION) {

			}
		}

	}

	public void iniciodeSesion() {
		leeFichero();
		JTextField usuarioTxt = new JTextField();
		JPasswordField contraseniaTxt = new JPasswordField();
		char[] contraseniaAConvertir;
		String contraseniaConvertida;
		usuarioTxt.setText(getUsuario());
		contraseniaTxt.setText(getPassword());
		setUsuario(null);
		setPassword(null);
		Object[] opciones = { "Reintentar" };
		Object[] campoDeDatos = { "Usuario", usuarioTxt, "Contraseña", contraseniaTxt };
		Object[] opcionFormulario = { "OK" };
		int option = JOptionPane.showOptionDialog(this, campoDeDatos, "Iniciar Sesión", JOptionPane.OK_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, opcionFormulario, opcionFormulario[0]);
		contraseniaAConvertir = contraseniaTxt.getPassword();
		contraseniaConvertida = String.valueOf(contraseniaAConvertir);
		if (option == JOptionPane.CLOSED_OPTION) {
			setUsuario(null);
			setPassword(null);

		} else if (option == JOptionPane.OK_OPTION
				&& (usuarioTxt.getText().isEmpty() || contraseniaTxt.getText().isEmpty())) {
			JOptionPane.showOptionDialog(this, "Rellene todos los campos antes de continuar", "Error",
					JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE, null, opcionFormulario, opcionFormulario[0]);
			setUsuario(usuarioTxt.getText());
			setPassword(contraseniaTxt.getText());
			iniciodeSesion();

		} else {
			if (option == JOptionPane.OK_OPTION) {
				int numero;
				setUsuario(usuarioTxt.getText());
				setPassword(contraseniaConvertida);
				System.out.println(getUsuario());
				System.out.println(getPassword());
				for (int x = 0; x < guardaNombres.size(); x++) {
					if (guardaNombres.get(x).equals(getUsuario())) {
						numero = x;
						if (guardaNombres.get(numero).equals(getUsuario())
								&& guardaContrasenias.get(numero).equals(getPassword())) {
							JOptionPane.showOptionDialog(this, "Sesión Iniciada con exito", "Exito",
									JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionFormulario,
									opcionFormulario[0]);
							break;
						} else {
							JOptionPane.showOptionDialog(this,
									"La contraseña o el usuario introducido no son correctos", "Error",
									JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null, opcionFormulario,
									opcionFormulario[0]);
							iniciodeSesion();
							break;

						}

					}

				}

			}
		}

		// AQUÍ LE METO PARA QUE INICIE LA APLICACIÓN Y QUE LUEGO BLOQUEE LAS OPCIONES
		// SI ES UN USUARIO ADMIN O UN USUARIO VISITANTE

	}

	public Boolean admin(Boolean admin) {
		return admin;

	}

	public void creacionUsuarioAdmin() {
		System.out.println("Si que entro, pero no hago nada");
		Object[] opcionFormulario = { "OK" };
		if (!usuarios.exists()) {
			try {
				usuarios.createNewFile();
				FileWriter fw = new FileWriter(usuarios, true);
				fw.write(getUsuario() + ";" + getPassword() + ";" + "Admin\n");
				fw.close();
				JOptionPane.showOptionDialog(this, "Usuario creado con exito", "Registro", JOptionPane.OK_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, opcionFormulario, opcionFormulario[0]);

			} catch (IOException e) {

				e.printStackTrace();
			}
		} else {
			confirmacionNuevoUsuario();
			try {
				FileWriter fw = new FileWriter(usuarios, true);
				fw.write(getUsuario() + ";" + getPassword() + ";" + "Admin\n");
				fw.close();
				JOptionPane.showOptionDialog(this, "Usuario creado con exito", "Registro", JOptionPane.OK_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null, opcionFormulario, opcionFormulario[0]);
			} catch (IOException e1) {

				e1.printStackTrace();
			}

		}

	}

	public void creacionUsuarioVisitante() {
		Object[] opcionFormulario = { "OK" };
		if (!usuarios.exists()) {
			try {
				usuarios.createNewFile();
				try {
					FileWriter fw = new FileWriter(usuarios, true);
					fw.write(getUsuario() + ";" + getPassword() + ";" + "Visitante\n");
					fw.close();
					JOptionPane.showOptionDialog(this, "Usuario creado con exito", "Registro",
							JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionFormulario,
							opcionFormulario[0]);
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			} catch (IOException e) {

				e.printStackTrace();
			}
		} else {
			confirmacionNuevoUsuario();
			try {
				FileWriter fw = new FileWriter(usuarios, true);
				fw.write(getUsuario() + ";" + getPassword() + ";" + "Visitante\n");
				fw.close();
				JOptionPane.showOptionDialog(this, "Usuario creado con exito", "Registro", JOptionPane.OK_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null, opcionFormulario, opcionFormulario[0]);
			} catch (IOException e1) {

				e1.printStackTrace();
			}

		}

	}

	public void confirmacionNuevoUsuario() {
		try {
			FileReader fr = new FileReader(usuarios);
			BufferedReader bf = new BufferedReader(fr);
			String linea;
			try {
				while ((linea = bf.readLine()) != null) {
					System.out.println(linea);
//					GUARDA LOS DATOS DE LA LINEA EN UN STRING[], Y LOS DIVIDE SEGÚN USUARIO, CONTRASEÑA Y TIPO DE USUARIO
					String[] guardaDatos = linea.split(";");

					guardaNombres.add(guardaDatos[0]);
					guardaContrasenias.add(guardaDatos[1]);
					guardaTipo.add(guardaDatos[2]);

				}

				for (int x = 0; x < guardaNombres.size(); x++) {
					System.out.println("Usuario: " + guardaNombres.get(x));
					System.out.println("Contraseña: " + guardaContrasenias.get(x));
					System.out.println("Tipo: " + guardaTipo.get(x));
				}

				bf.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Que no está");
		}

	}

	public void leeFichero() {
		try {
			FileReader fr = new FileReader(usuarios);
			BufferedReader bf = new BufferedReader(fr);
			String linea;
			try {
				while ((linea = bf.readLine()) != null) {
					System.out.println(linea);
//				GUARDA LOS DATOS DE LA LINEA EN UN STRING[], Y LOS DIVIDE SEGÚN USUARIO, CONTRASEÑA Y TIPO DE USUARIO
					String[] guardaDatos = linea.split(";");

					guardaNombres.add(guardaDatos[0]);
					guardaContrasenias.add(guardaDatos[1]);
					guardaTipo.add(guardaDatos[2]);

				}

				for (int x = 0; x < guardaNombres.size(); x++) {
					System.out.println("Usuario: " + guardaNombres.get(x));
					System.out.println("Contraseña: " + guardaContrasenias.get(x));
					System.out.println("Tipo: " + guardaTipo.get(x));
				}

				bf.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Que no está");
		}

	}

	public void failConnectionBbdd() {
		Object[] opciones = { "Reintentar", "Abandonar" };
		int confirmacionConexion = JOptionPane.showOptionDialog(this,
				"La Base de datos no está conectada, conectelá, e intentelo de nuevo.", "Error",
				JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, opciones, opciones[0]);
		if (confirmacionConexion == JOptionPane.YES_OPTION) {

		} else if (confirmacionConexion == JOptionPane.NO_OPTION || confirmacionConexion == JOptionPane.CLOSED_OPTION) {
			setUsuario(null);
			setPassword(null);

		}

	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
