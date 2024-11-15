package es.curso.operaciones.modelo.beans;

public class Empleado {
	
	private int id;
	private String nombre;
	private String cargo;
	
	
	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Empleado(int id, String nombre, String cargo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cargo = cargo;
	}
	
	public Empleado(String csv) {}
	
	public String toCSV(char delim) {
		return null;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @return the cargo
	 */
	public String getCargo() {
		return cargo;
	}


	/**
	 * @param cargo the cargo to set
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", cargo=" + cargo + "]";
	}

}
