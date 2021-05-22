package modelo;

/**
 * Clase Obra para establecer sus atributos y constructores
 * 
 * @author vmcd7
 * @version 1.0
 */
public class Obra {
	private int idAutor;
	private String nombreAutor;

	/**
	 * Constructor por defecto
	 */
	public Obra() {
		this.idAutor = 0;
		this.nombreAutor = "";
	}

	/**
	 * Constructor por par�metros
	 * 
	 * @param idAutor
	 * @param nombreAutor
	 */
	public Obra(int idAutor, String nombreAutor) {
		this.idAutor = idAutor;
		this.nombreAutor = nombreAutor;
	}

	/**
	 * M�todo para poder recoger el dato guardado del atributro idAutor
	 * 
	 * @return idAutor
	 */
	public int getIdAutor() {
		return idAutor;
	}

	/**
	 * M�todo para establecer el atributo idAutor mediante un dato pasado por
	 * par�metro
	 * 
	 * @param idAutor
	 */
	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	/**
	 * M�todo para poder recoger el dato guardado del atributro nombreAutor
	 * 
	 * @return nombreAutor
	 */
	public String getNombreAutor() {
		return nombreAutor;
	}

	/**
	 * M�todo para establecer el atributo nombreAutor mediante un dato pasado por
	 * par�metro
	 * 
	 * @param nombreAutor
	 */
	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}

}
