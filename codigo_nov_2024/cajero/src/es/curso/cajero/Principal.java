package es.curso.cajero;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Validar el importe:
		int importe;

		do {
			System.out.print("Importe:> ");
			importe = Teclado.readint();
			if (importe % 10 != 0) {
				System.err.println("\nImporte incorrecto, teclear múltiplo de 10");
			}
		} while (importe % 10 != 0);
		

	}

}
