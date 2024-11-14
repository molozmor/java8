package es.curso.excepciones;

public class ContarErrores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// int[] arr1 = solucion1(args);
		int[] arr2 = solucion2(args);
	}

	private static int[] solucion2(String[] args) {
		// TODO Auto-generated method stub
		int[] enteros = null;
		int i = 0;
		int numErrores = 0; 

		enteros = new int[args.length];
		for (String snum : args) {
			
			try {
				enteros[i] = Integer.parseInt(snum);
				i++;

			} catch (NumberFormatException e) {
				System.out.println("Error: " + e.getMessage());
				numErrores++;
			}
		}

		if (numErrores > 0) {
			System.out.println("No se han podido procesar: "+numErrores+" números");
		}
		return enteros;
	}

	private static int[] solucion1(String[] args) {
		// 1 2 3 A 5 6 4 2 B 10 11 12 H
		int[] enteros = null;
		int i = 0;

		try {
			enteros = new int[args.length];
			for (String snum : args) {
				enteros[i] = Integer.parseInt(snum);
				i++;
			}

		} catch (NumberFormatException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return enteros;
	}

}
