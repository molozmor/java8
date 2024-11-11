package es.curso.controlflujo;

public class Principal {

	private static final int INICIO = 1;
	private static final int FIN = 50;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Comprobar si una variable está dentro de un intervalo
		int numero = -10;

		if (numero >= INICIO && numero <= FIN) {
			System.out.println("numero cumple el intervalo");

		} else {
			System.out.println("número NO cumple el intervalo");
		}

		if (numero < INICIO || numero > FIN) {
			System.out.println("número NO cumple el intervalo");

		} else {
			System.out.println("numero cumple el intervalo");
		}

		if (!(numero >= INICIO && numero <= FIN)) {
			System.out.println("número NO cumple el intervalo");

		} else {
			System.out.println("numero cumple el intervalo");
		}

	}

}
