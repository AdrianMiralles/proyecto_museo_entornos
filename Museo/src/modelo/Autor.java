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
	 * Constructor por parámetros
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
	 * Método para poder recoger el dato guardado del atributro idAutor
	 * 
	 * @return idAutor
	 */
	public int getIdAutor() {
		return idAutor;
	}

	/**
	 * Método para establecer el atributo idAutor mediante un dato pasado por
	 * parámetro
	 * 
	 * @param idAutor
	 */
	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	/**
	 * Método para poder recoger el dato guardado del atributro idObra
	 * 
	 * @return idObra
	 */
	public int getIdObra() {
		return idObra;
	}

	/**
	 * Método para establecer el atributo idObra mediante un dato pasado por
	 * parámetro
	 * 
	 * @param idObra
	 */
	public void setIdObra(int idObra) {
		this.idObra = idObra;
	}

	/**
	 * Método para poder recoger el dato guardado del atributro titulo
	 * 
	 * @return titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Método para establecer el atributo titulo mediante un dato pasado por
	 * parámetro
	 * 
	 * @param titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Método para poder recoger el dato guardado del atributro tipo
	 * 
	 * @return tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Método para establecer el atributo tipo mediante un dato pasado por parámetro
	 * 
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Método para poder recoger el dato guardado del atributro fecha
	 * 
	 * @return fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * Método para establecer el atributo fecha mediante un dato pasado por
	 * parámetro
	 * 
	 * @param fecha
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * Método para poder recoger el dato guardado del atributro lugar
	 * 
	 * @return lugar
	 */
	public String getLugar() {
		return lugar;
	}

	/**
	 * Método para establecer el atributo lugar mediante un dato pasado por
	 * parámetro
	 * 
	 * @param lugar
	 */
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

}
