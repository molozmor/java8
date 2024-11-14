package es.curso.excepciones;

public class CapturarExcepciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		pruebas();

	}

	private static void pruebas() {
		// TODO Auto-generated method stub
		//prueba1(1);
		//prueba2(1);
		//prueba3(12);
		//prueba4(44);
		prueba5(2);
		
	}

	private static void prueba1(int i) {
		int[] numeros2 = { 1, 2, 3, 4, 5 };
		// Capturar una excepcion concreta.

		try {
			System.out.println(numeros2[i]);
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("ERROR al acceder al array, índice fuera: "+e.getMessage());
		}
	}
	
	private static void prueba2(int i) {
		int[] numeros = { 1, 2, 3, 4, 5 };
		int numero;
		// Capturar una excepcion concreta, pero se produce otra distinta:

		try {
			numero = Integer.parseInt("123.6");
			System.out.println(numeros[i]);
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("ERROR al acceder al array, índice fuera: "+e.getMessage());
		}
		System.out.println("fin");
	}
	
	private static void prueba3(int i) {
		int[] numeros = { 1, 2, 3, 4, 5 };
		int numero;
		// Capturar dos excepciones concretas, aplicando un tratamiento distinto para cada una:

		try {
			numero = Integer.parseInt("1236");
			System.out.println(numeros[i]);
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("ERROR al acceder al array, índice fuera: "+e.getMessage());
			
		} catch (NumberFormatException e) {
			System.err.println("ERROR al convertir un texto a int: "+e.getMessage());
			
		}
		System.out.println("fin");
	}
	
	private static void prueba4(int i) {
		int[] numeros = { 1, 2, 3, 4, 5 };
		int numero;
		String nombre = null;
		
		// Capturar dos excepciones concretas, aplicando un tratamiento común y utizamos multicatch, pero si salta otra excepción
		// distinta. La máquina virtual aborta la ejecución.

		try {
			numero = Integer.parseInt("1236");
			System.out.println(nombre.toUpperCase());
			System.out.println(numeros[i]);
			
		} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
			System.err.println("ERROR: "+e.getClass().getName()+" "+e.getMessage());					
			
		}
		System.out.println("fin");
	}

	private static void prueba5(int i) {
		int[] numeros = { 1, 2, 3, 4, 5 };
		int numero;
		String nombre = null;
		
		// Capturar dos excepciones concretas, aplicando un tratamiento común y utizamos multicatch. El resto de posible excepciones
		// se captura a nivel de exception

		try {
			numero = Integer.parseInt("1236");
			System.out.println(nombre.toUpperCase());
			System.out.println(numeros[i]);
			
		} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
			System.err.println("ERROR: "+e.getClass().getName()+" "+e.getMessage());					
			
		} catch (Exception e) {
			System.err.println("ERROR: "+e.getClass().getName()+" "+e.getMessage());	
		}
		System.out.println("fin");
	}
}
