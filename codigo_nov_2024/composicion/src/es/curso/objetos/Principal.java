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
		
	private static void pruebasPersona() {
		// TODO Auto-generated method stub
		
		Persona p1 = new Persona("Miguel");
		p1.comprarCasa(new Direccion("Gran Via", 1, 28001, "Madrid"));
		
		System.out.println(p1);
	}
}
