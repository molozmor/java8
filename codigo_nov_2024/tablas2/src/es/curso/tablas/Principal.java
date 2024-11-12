package es.curso.tablas;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double matriz[][] = { { 1.0, 2.4, 3.8 }, { 4.1, 5.6, 6.2 }, { 7.1, 8.9, 9.4 } };

		imprimirMatriz(matriz);

		// Reservando y rellenarla con números aleatorios:
		int m[][] = crearMatriz(3, 6);

		System.out.println();
	}

	private static int[][] crearMatriz(int filas, int cols) {
		// TODO Auto-generated method stub
		int m2[][] = new int[filas][cols];

		for (int i = 0; i < m2.length; i++) {

			for (int j = 0; j < m2[i].length; j++) {

				m2[i][j] = (int) (10 * Math.random());
			}
		}

		return m2;
	}

	private static void imprimirMatriz(double[][] matriz) {
		// TODO Auto-generated method stub
		for (double[] fila : matriz) {

			for (double i : fila) {
				System.out.print(i + "\t");

			}

			System.out.println();
		}
	}

}
