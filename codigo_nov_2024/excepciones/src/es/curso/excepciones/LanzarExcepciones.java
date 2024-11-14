package es.curso.excepciones;

/**
 * Lanzar excepciones y capturarlas en otras funciones.
 * 
 */
public class LanzarExcepciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			pruebas();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	// declara que el método lanza una excepción
	private static void pruebas() throws Exception {
		// TODO Auto-generated method stub

		try {
			prueba1(2);

		} catch (ArithmeticException e) {
			System.out.println("Capturada y relanzada en pruebas()");

			// Lanza una nueva excepcion
			throw new Exception(e.getMessage());
		}
	}

	private static void prueba1(int numero) {
		// TODO Auto-generated method stub

		if (numero % 2 == 0) {
			throw new ArithmeticException("El numero:" + numero + " no es correcto");

		} else {
			System.out.println("El número es válido ...");
		}

	}

}
