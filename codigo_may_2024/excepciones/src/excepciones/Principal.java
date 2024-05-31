package excepciones;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// test1();
		test2();

	}

	private static void test2() {
		// Capturar una excepción concreta

		try {
			String texto = "123G";

			// Conversión a número con un error:
			int numero = Integer.parseInt(texto);
			System.out.println("El número es: " + numero);
			
		} catch (NumberFormatException e) {
			System.err.println("ERROR: "+e.getMessage());
		}
	}

	private static void test1() {
		// Generar un error que no se captura:
		String texto = "123G";

		// Conversión a número con un error:
		int numero = Integer.parseInt(texto);
		System.out.println("El número es: " + numero);

	}

}
