package es.curso.objetos;

/**
 * Implementación de la clase Persona
 */
public class Persona {
	
	private String nombre;	
	private int edad;	
	private double altura;
	private double peso;
	
	private Direccion[] casas;
	private int numCasas;
	
	public static final int NUM_CASAS_MAX = 5;
	
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
		this.casas = new Direccion[NUM_CASAS_MAX];
		this.numCasas = 0;
	}


	/**
	 * Sólo inicializa el nombre de la persona.
	 * @param nombre el nombre de la persona
	 */
	public Persona(String nombre) {		
		this(nombre, 0,0.0,0.0);
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
	
	


	/**
	 * @return the numCasas
	 */
	public int getNumCasas() {
		return numCasas;
	}


	public void hablar(Persona persona) {
		System.out.println(this.nombre + " habla con " + persona.nombre);
	}
	
	@Override
	/**
	 * Devuelve una representación en texto del objeto
	 */
	public String toString() {
		String resul = "Persona [nombre=" + nombre + ", edad=" + edad + ", altura=" + altura + ", peso=" + peso + "]";
		
		for (int i = 0 ; i < numCasas ; i++) {
			resul += "\n" + casas[i];
		}
		
		return resul;
	}
	
	/**
	 * Retorna los datos del objeto en un formato CSV
	 * @return la cadena en CSV
	 */
	public String toCSV() {
		return nombre + ";" + edad + ";" + altura + ";" + peso;
	}


	public boolean comprarCasa(Direccion direccion) {
		// TODO Auto-generated method stub
		
		if (numCasas < NUM_CASAS_MAX) {
			casas[numCasas] = direccion;
			numCasas++;
			return true;
			
		} else {
			return false;
		}
		
	}
	
	
}
