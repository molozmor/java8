package es.curso.cliente;

import java.io.Serializable;

public class Empleado implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String codigo;
	private String empresa;
	private double sueldo;
	
	
	
	public Empleado() {
		this(null,null,null,0.0);
	}
	
	public Empleado(String nombre, String codigo){
		this(nombre, codigo, null, 0.0);
	}


	public Empleado(String nombre, String codigo, String empresa, double sueldo) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.empresa = empresa;
		this.sueldo = sueldo;
		
	}

	public Empleado(String linea) {
		// TODO Auto-generated constructor stub
	}

	private void init(){
		
	}
	

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", codigo=" + codigo + ", empresa=" + empresa + ", sueldo=" + sueldo
				+  "]";
	}

	
	@Override
	public int hashCode() {
		return codigo.hashCode();
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
//		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
//		result = prime * result + ((estadoCivil == null) ? 0 : estadoCivil.hashCode());
//		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
//		long temp;
//		temp = Double.doubleToLongBits(sueldo);
//		result = prime * result + (int) (temp ^ (temp >>> 32));
//		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (Double.doubleToLongBits(sueldo) != Double.doubleToLongBits(other.sueldo))
			return false;
		return true;
	}

	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}


	public String toCSV() {
		return nombre+";"+codigo+";"+empresa+";"+sueldo+";";
	}
}
