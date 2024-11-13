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
		pruebasDireccion();
	}
		
	private static void pruebasDireccion() {
		// TODO Auto-generated method stub
		Direccion dir1, dir2;
		
		dir1 = new Direccion("Calle 1", 10, 28000, "Ciudad1");
		dir2 = new Direccion("Calle 1", 10, 28000, "Ciudad1");
		
		if (dir1.equals(dir2)) {
			System.out.println("son iguales");
			
		} else {
			System.out.println("son distintas");
		}
		
		System.out.println("Dir1: "+dir1.hashCode());
		System.out.println("Dir2: "+dir2.hashCode());
	}

	private static void pruebasPersona() {
		// TODO Auto-generated method stub
		
		Persona p1 = new Persona("Miguel");
		if (p1.comprarCasa(new Direccion("Gran Via", 1, 28001, "Madrid")))
			System.out.println("Casa comprada ...");
		else
			System.out.println("No hay compra");
		
		System.out.println(p1);
	}
}
