package es.curso.objetos;

import java.util.Objects;

public class Persona {
	
	// Definición de atributos: 
	private String nombre;	
	private int edad;
	private double altura;
	private boolean carnetConducir;
	
	
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Persona(String nombre, int edad, double altura, boolean carnetConducir) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.altura = altura;
		this.carnetConducir = carnetConducir;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getEdad() {
		return edad;
	}



	public void setEdad(int edad) {
		this.edad = edad;
	}



	public double getAltura() {
		return altura;
	}



	public void setAltura(double altura) {
		this.altura = altura;
	}



	public boolean isCarnetConducir() {
		return carnetConducir;
	}



	public void setCarnetConducir(boolean carnetConducir) {
		this.carnetConducir = carnetConducir;
	}
	
	


	@Override
	public int hashCode() {
		return Objects.hash(altura, carnetConducir, edad, nombre);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Double.doubleToLongBits(altura) == Double.doubleToLongBits(other.altura)
				&& carnetConducir == other.carnetConducir && edad == other.edad && Objects.equals(nombre, other.nombre);
	}


	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", altura=" + altura + ", carnetConducir="
				+ carnetConducir + "]";
	}


	public void hablarCon(Persona otra) {
		// TODO Auto-generated method stub
		
		if (otra == null) {
			System.out.println("La persona está hablando sola");
			
		} else {
			System.out.println(this.nombre + " y " + otra.nombre + " están hablando");
		}
	}

	/* No sobrecarga correctamente solo con el tipo devuelto
	 * hay que cambiar el tipo o el número de los parámetros
	public int cumpleaños() {
		edad++;
		return edad;
	}*/

	
	public void cumpleaños() {
		// TODO Auto-generated method stub
		edad++;  // this.edad++;
	}

	/* METODO SOBRECARGADO CORRECTAMENTE! */
	public void cumpleaños(int valor) {
		edad += valor;
	}
	
}
