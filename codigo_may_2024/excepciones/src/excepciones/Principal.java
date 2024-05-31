package excepciones;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// test1();
		// test2();
		// test3();
		// test4();
		// test5();
		//test7();
		//test8();
		//test9();
		//test10("123");
		test10_ok("123");
	}

	private static void test10_ok(Object cadena) {
		// ejemplo test10 bien!
		
		String cad = (String) cadena;
		Integer i = new Integer(cad);
		System.out.println("i: "+i);
		
	}

	private static void test10(Object cadena) {
		// Una excepcion al aplicar un casting
		
		Integer i = (Integer) cadena;
		System.out.println("i: " + i);						
	}
	
	

	private static void test9() {
		// Abrir y cerrar un fichero utilizando finally
		
		
		FileInputStream fichero = null;
		
		try {
			// Abrir
			fichero = new FileInputStream("ficheros/Empleados.txt");
			
			System.out.println("leer fichero");
			int n = 4/0;
			
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
		} finally {
			// Cerrar
			try {
				if (fichero != null) fichero.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	private static int test8() {
		// Uso de finally en las excepciones
		// finally se coloca al final de los catch
		// Se ejecuta siempre haya o no error!
		try {
			int numeros[] = {1,2,3,4,5};
			System.out.println(numeros[0]);
			return numeros[0];
			
		} catch (Exception e) {
			System.err.println(e.getClass() + " " + e.getMessage());
			
		} finally {
			System.out.println("Se ejecuta finally");
		}
		return 0;
		
	}

	private static void test7() {

		try {
			test6(22);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param numero
	 * @throws Exception
	 */
	private static void test6(int numero) throws Exception {
		// Lanzar una excepción: cuando el número no sea múltiplo de 10

		try {
			if (numero % 10 != 0) {
				// No es múltiplo de 10.
				throw new Exception("El número: " + numero + " no es múltiplo de 10");

			} else {
				System.out.println("El número: " + numero + " es correcto");
			}

		} catch (Exception e) {
			throw e;
		}

	}

	private static void test5() {
		// Capturar dos excepciones concretas y otras posibles excepciones.
		// Para las dos excepciones concretas suponemos que queremos hacer el mismo
		// tratamiento --> multicatch
		// Capturar dos excepciones concretas.
		// 1) Colocar las excepciones concretas
		// 2) La excepción mas general: la superclase

		try {
			int array[] = null;

			String texto = "123";

			// Conversión a número con un error:
			int numero = Integer.parseInt(texto);
			array[0] = numero;

			System.out.println("El array es: " + Arrays.toString(array));

		} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
			System.err.println(e.getClass() + " " + e.getMessage());

		} catch (Exception e) {
			System.err.println(e.getClass() + " " + e.getMessage());

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
			System.err.println("ERROR: " + e.getMessage());

		}
	}

	private static void test3() {
		// Capturar una excepción concreta, pero se genera otra distinta y MV aborta la
		// ejecución.

		try {
			int array[] = new int[5];

			String texto = "123";

			// Conversión a número con un error:
			int numero = Integer.parseInt(texto);
			array[10] = numero;

			System.out.println("El array es: " + Arrays.toString(array));

		} catch (NumberFormatException e) {
			System.err.println("ERROR: " + e.getMessage());
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
			System.err.println("ERROR: " + e.getMessage());
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
