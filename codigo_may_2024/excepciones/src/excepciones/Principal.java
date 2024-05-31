package excepciones;

import java.util.Arrays;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// test1();
		//test2();
		//test3();
		//test4();
		test5();

	}
	
	private static void test5() {
		// Capturar dos excepciones concretas y otras posibles excepciones.
		// Para las dos excepciones concretas suponemos que queremos hacer el mismo
		// tratamiento --> multicatch
		// Capturar dos excepciones concretas.
		// 1) Colocar las excepciones concretas
		// 2) La excepción mas general: la superclase

		try {
			int array[] = new int[5];
			
			String texto = "123H";

			// Conversión a número con un error:
			int numero = Integer.parseInt(texto);
			array[10] = numero;
			
			System.out.println("El array es: " + Arrays.toString(array));
			
		} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
			System.err.println(e.getClass() + " " +  e.getMessage());
			
		} catch (Exception e) {
			System.err.println("ERROR: "+e.getMessage());
			
		}
		
	}

	private static void test4() {
		// Capturar dos excepciones concretas.

		try {
			int array[] = new int[5];
			
			String texto = "123H";

			// Conversión a número con un error:
			int numero = Integer.parseInt(texto);
			array[10] = numero;
			
			System.out.println("El array es: " + Arrays.toString(array));
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("ERROR en el array: " + e.getMessage());
			
		} catch (NumberFormatException e) {
			System.err.println("ERROR: "+e.getMessage());
			
		}					
	}

	private static void test3() {
		// Capturar una excepción concreta, pero se genera otra distinta y MV aborta la ejecución.

		try {
			int array[] = new int[5];
			
			String texto = "123";

			// Conversión a número con un error:
			int numero = Integer.parseInt(texto);
			array[10] = numero;
			
			System.out.println("El array es: " + Arrays.toString(array));
			
		} catch (NumberFormatException e) {
			System.err.println("ERROR: "+e.getMessage());
		}
		
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
