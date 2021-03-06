package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Autor;
import modelo.Obra;

public class BaseDeDatos {
	public ArrayList<Obra> consulta(String campo, String dato) {
		ArrayList<Obra> listadoObras = new ArrayList<Obra>();

		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_museo", "root", "");
			Statement consulta = conexion.createStatement();

			/*
			 * ResultSet registro = consulta.executeQuery(
			 * "SELECT autor, obras.titulo, obras.tipo, obras.fecha, obras.lugar FROM autores, obras WHERE autores.idAutor=obras.idAutor and "
			 * + campo + " LIKE '%" + dato + "%'");
			 */

			ResultSet registro = consulta.executeQuery("select * from obras where " + campo + " like '%" + dato + "%'");
			boolean siguiente = registro.next();
			if (siguiente) {
				while (registro.next()) {
					siguiente = true;
					Obra nuevaObra = new Obra();

					int idAutor = Integer.parseInt(registro.getString("IdAutor"));
					int idObra = Integer.parseInt(registro.getString("IdObra"));
					nuevaObra.setIdAutor(idAutor);
					nuevaObra.setIdObra(idObra);
					nuevaObra.setTitulo(registro.getString("titulo"));
					nuevaObra.setTipo(registro.getString("tipo"));
					nuevaObra.setFecha(registro.getString("fecha"));
					nuevaObra.setLugar(registro.getString("lugar"));

					listadoObras.add(nuevaObra);

				}
				siguiente = false;
			}

		} catch (SQLException e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "La base de datos a la que intenta acceder no est? disponible",
					"Alerta", JOptionPane.WARNING_MESSAGE);
		}

		return listadoObras;
	}

	public ArrayList<Autor> cargandoComboAutores() {

		ArrayList<Autor> registroAutores = new ArrayList<>();

		try {

			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_museo", "games2021",
					"games2021");
			Statement consulta = conexion.createStatement();// guardamos en consulta la conexi?n

			ResultSet registro = consulta.executeQuery("SELECT DISTINCT * FROM autores ORDER BY idAutor");

			while (registro.next()) {
				Autor nuevoAutor = new Autor();
				int idAutor = Integer.parseInt(registro.getString("idAutor"));
				nuevoAutor.setIdAutor(idAutor);
				nuevoAutor.setNombreAutor(registro.getString("autor"));
				registroAutores.add(nuevoAutor);
			}

			conexion.close();// siempre cerrar conexi?n
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return registroAutores;
	}
}
