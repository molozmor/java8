package es.curso.herencia;

import java.util.Objects;

/**
 * Implementación clase empleado
 */
public class Empleado extends Persona {
	
	private String empresa;
	private double sueldo;
		
	
	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Empleado(String nombre, String empresa, double sueldo) {
		this(nombre, 0, 0.0, 0.0, empresa, sueldo);
	}

	public Empleado(String nombre, int edad, double altura, double peso, String empresa, double sueldo) {
		super(nombre, edad, altura, peso);
		this.empresa = empresa;
		this.sueldo = sueldo;
	}

	
	
	/**
	 * @return the empresa
	 */
	public String getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	/**
	 * @return the sueldo
	 */
	public double getSueldo() {
		return sueldo;
	}

	/**
	 * @param sueldo the sueldo to set
	 */
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(empresa, sueldo);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(empresa, other.empresa)
				&& Double.doubleToLongBits(sueldo) == Double.doubleToLongBits(other.sueldo);
	}

	@Override
	public String toString() {
		return super.toString() + ", empresa=" + empresa + ", sueldo=" + sueldo;
	}
	

}
