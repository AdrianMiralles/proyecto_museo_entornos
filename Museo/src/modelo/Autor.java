package modelo;

/**
 * Clase Autor para establecer sus atributos y constructores
 * 
 * @author vmcd7
 * @version 1.0
 */
public class Autor {
	private int idAutor;
	private int idObra;
	private String titulo;
	private String tipo;
	private String fecha;
	private String lugar;

	/**
	 * Constructor por defecto
	 */
	public Autor() {
		this.idAutor = 0;
		this.idObra = 0;
		this.titulo = "";
		this.tipo = "";
		this.fecha = "";
		this.lugar = "";
	}

	/**
	 * Constructor por par�metros
	 * 
	 * @param idAutor
	 * @param idObra
	 * @param titulo
	 * @param tipo
	 * @param fecha
	 * @param lugar
	 */
	public Autor(int idAutor, int idObra, String titulo, String tipo, String fecha, String lugar) {
		this.idAutor = idAutor;
		this.idObra = idObra;
		this.titulo = titulo;
		this.tipo = tipo;
		this.fecha = fecha;
		this.lugar = lugar;
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
	 * M�todo para poder recoger el dato guardado del atributro idObra
	 * 
	 * @return idObra
	 */
	public int getIdObra() {
		return idObra;
	}

	/**
	 * M�todo para establecer el atributo idObra mediante un dato pasado por
	 * par�metro
	 * 
	 * @param idObra
	 */
	public void setIdObra(int idObra) {
		this.idObra = idObra;
	}

	/**
	 * M�todo para poder recoger el dato guardado del atributro titulo
	 * 
	 * @return titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * M�todo para establecer el atributo titulo mediante un dato pasado por
	 * par�metro
	 * 
	 * @param titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * M�todo para poder recoger el dato guardado del atributro tipo
	 * 
	 * @return tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * M�todo para establecer el atributo tipo mediante un dato pasado por par�metro
	 * 
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * M�todo para poder recoger el dato guardado del atributro fecha
	 * 
	 * @return fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * M�todo para establecer el atributo fecha mediante un dato pasado por
	 * par�metro
	 * 
	 * @param fecha
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * M�todo para poder recoger el dato guardado del atributro lugar
	 * 
	 * @return lugar
	 */
	public String getLugar() {
		return lugar;
	}

	/**
	 * M�todo para establecer el atributo lugar mediante un dato pasado por
	 * par�metro
	 * 
	 * @param lugar
	 */
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

}
