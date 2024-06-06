package es.curso.dao.beans;

import java.io.Serializable;

public class Empleado implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", cargo=" + cargo + "]";
	}

}
