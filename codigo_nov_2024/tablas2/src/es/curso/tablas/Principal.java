
package es.curso.tablas;

public class Principal {

	public static void main(String[] args) { // TODO Auto-generated method stub

		parametrosMain(args);

		int matriz[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		imprimirMatriz(matriz);

		// Reservando y rellenarla con números aleatorios:
		int m[][] = crearMatriz(3, 6);
		imprimirMatriz(m);

		System.out.println();
		
		int[] arr1 = {2,4,6,7,8,-1};
		int[] arr2 = {2,4,6,7,8,10};
		
		System.out.println("arr2:" + estaOrdenadoAsc(arr2));
		System.out.println("arr1:" + estaOrdenadoAsc(arr1));
	}
	
	private static boolean estaOrdenadoAsc(int[] numeros) {
		
		for (int i = 0 ;  i < numeros.length-1 ; i++) {
			
			if (numeros[i] > numeros[i+1])
				return false;
		}
		return true;
		
	}

	private static void parametrosMain(String[] parametros) {
		int numero;
		Integer total = 0;
		
		numero = Integer.parseInt("345");
		numero++;
		System.out.println("numero: "+numero);
		

		System.out.println("Tenemos: " + parametros.length);
		
		for (String param : parametros) {
			numero = Integer.parseInt(param);
			total += numero;
		}
		System.out.println("Total:"+total);
		
	}

	private static int[][] crearMatriz(int filas, int cols) { // TODO
		int m2[][] = new int[filas][cols];

		for (int i = 0; i < m2.length; i++) {

			for (int j = 0; j < m2[i].length; j++) {

				m2[i][j] = (int) (10 * Math.random());
			}
		}

		return m2;
	}

	private static void imprimirMatriz(int[][] matriz) { // TODO Auto-generated
		for (int[] fila : matriz) {

			for (int i : fila) {
				System.out.print(i + "\t");

			}

			System.out.println();
		}
	}

}
