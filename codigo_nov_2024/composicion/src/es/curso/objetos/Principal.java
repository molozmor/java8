package es.curso.objetos;

/**
 * Clase principal de la aplicación
 */
public class Principal {

	private static int a = 10;
	private static int b;

	/**
	 * La función principal.
	 * 
	 * @param args los argumentos de main
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Principal principal = new Principal();
		// principal.pruebasDireccion(); // Si no fuera static

		pruebaB();

		pruebasPersona();
		pruebasDireccion();

	}

	private static void pruebaB() {
		System.out.println("b: " + b);
	}

	static {
		// PARA INICIALIZACIONES DE PROPIEDADES QUE PODAMOS NECESITAR Y NO CAMBIARAN
		System.out.println("Bloque static: a = " + a);
		b = a * 1000;
	}

	private static void modificarDireccion(Direccion dir) {
		dir.setCp(29999);
	}

	private static void pruebasDireccion() {
		// TODO Auto-generated method stub
		Direccion dir1, dir2, dir3;

		System.out.println("Num instancias: " + Direccion.getNumInstancias());

		dir1 = new Direccion("Calle 1", 10, 28000, "Ciudad1");
		dir2 = new Direccion("Calle 1", 10, 28000, "Ciudad1");

		if (dir1.equals(dir2)) {
			System.out.println("son iguales");

		} else {
			System.out.println("son distintas");
		}

		System.out.println("Dir1: " + dir1.hashCode());
		System.out.println("Dir2: " + dir2.hashCode());

		System.out.println(dir1);
		dir3 = new Direccion(dir1);
		modificarDireccion(dir1);
		System.out.println("dir1: " + dir1);
		System.out.println("dir3: " + dir3);
	}

	private static void pruebasPersona() {
		// TODO Auto-generated method stub

		Persona p1;
		try {
			p1 = new Persona("Miguel",-3, 1.77, 80);
			if (p1.comprarCasa(new Direccion("Gran Via", 1, 28001, "Madrid")))
				System.out.println("Casa comprada ...");
			else
				System.out.println("No hay compra");

			System.out.println(p1);
			
		} catch (PersonaException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}

	}
}
