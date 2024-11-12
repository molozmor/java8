package es.curso.objetos;

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

	public void hablar(Persona persona) {
		System.out.println(this.nombre + " habla con " + persona.nombre);
	}
	
	@Override
	/**
	 * Devuelve una representación en texto del objeto
	 */
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", altura=" + altura + ", peso=" + peso + "]";
	}
	
	/**
	 * Retorna los datos del objeto en un formato CSV
	 * @return la cadena en CSV
	 */
	public String toCSV() {
		return nombre + ";" + edad + ";" + altura + ";" + peso;
	}
	
	
}
