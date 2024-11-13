package es.curso.herencia;

import java.util.Objects;

/**
 * Implementación de la clase Persona
 */
public class Persona {
	
	private String nombre;	
	private int edad;	
	private double altura;
	private double peso;
	
	/**
	 * Constructor por defecto. Inicializa el nombre a anónimo
	 */
	public Persona() {		
		this("anonimo", 0, 0.0, 0.0);
	}


	/**
	 * Inicializar una persona con información
	 * @param nombre el nombre de la persona
	 * @param edad la edad
	 * @param altura la altura
	 * @param peso el peso
	 */
	public Persona(String nombre, int edad, double altura, double peso) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.altura = altura;
		this.peso = peso;
	}


	/**
	 * Sólo inicializa el nombre de la persona.
	 * @param nombre el nombre de la persona
	 */
	public Persona(String nombre) {		
		this(nombre, 0,0.0,0.0);
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(altura, edad, nombre, peso);
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
		return Double.doubleToLongBits(altura) == Double.doubleToLongBits(other.altura) && edad == other.edad
				&& Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(peso) == Double.doubleToLongBits(other.peso);
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
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}


	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}


	/**
	 * @return the altura
	 */
	public double getAltura() {
		return altura;
	}


	/**
	 * @param altura the altura to set
	 */
	public void setAltura(double altura) {
		this.altura = altura;
	}


	/**
	 * @return the peso
	 */
	public double getPeso() {
		return peso;
	}


	/**
	 * @param peso the peso to set
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}


	public void hablar(Persona persona) {
		System.out.println(this.nombre + " habla con " + persona.nombre);
	}
	
	@Override
	/**
	 * Devuelve una representación en texto del objeto
	 */
	public String toString() {
		return "nombre=" + nombre + ", edad=" + edad + ", altura=" + altura + ", peso=" + peso;
	}
	
	/**
	 * Retorna los datos del objeto en un formato CSV
	 * @return la cadena en CSV
	 */
	public String toCSV() {
		return nombre + ";" + edad + ";" + altura + ";" + peso;
	}
	
	
}
