package es.curso.objetos;

/**
 * Clase principal de la aplicación
 */
public class Principal {

	/**
	 * La función principal.
	 * @param args los argumentos de main
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		pruebasPersona();
	}

	/**
	 * Pruebas con la clase persona
	 */
	private static void pruebasPersona() {
		// TODO Auto-generated method stub
		
		Persona p1 = new Persona("Miguel");
		System.out.println(p1);
		System.out.println(p1.toCSV());
		//p1.nombre = "Andrés"; //ERROR tiene acceso privado.
		
		Persona p2 = new Persona("Eva", 34, 0.0, 0.0);
		p1.hablar(p2);
	}

}
