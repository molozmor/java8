package es.curso.objetos;

public class Empleado extends Persona {
	
	private String empresa;
	private double sueldo;
	
	public Empleado() {}
	
	
	public Empleado(String nombre, String empresa, double sueldo) {
		super(nombre);
		this.empresa = empresa;
		this.sueldo = sueldo;
	}


	public Empleado(String nombre, int edad, double altura, boolean carnetConducir, String empresa, double sueldo) {
		super(nombre, edad, altura, carnetConducir);
		this.empresa = empresa;
		this.sueldo = sueldo;		
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


	@Override
	public String toString() {
		return super.toString() + " " + empresa + " " + sueldo;
	}
	
}
