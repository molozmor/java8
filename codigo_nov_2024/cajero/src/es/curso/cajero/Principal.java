package es.curso.cajero;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Validar el importe:
		int importe;
		int billetes[] = { 50, 20, 10 };
		int numBilletes;

		while (true) {
			do {
				System.out.print("Importe:> ");
				importe = Teclado.readint();
				if (importe % 10 != 0) {
					System.err.println("\nImporte incorrecto, teclear múltiplo de 10");
				}
			} while (importe % 10 != 0);

			// Calcular el desglose de billetes:
			for (int billete : billetes) {
				if (importe >= billete) {
					numBilletes = importe / billete;
					System.out.println(numBilletes + " de " + billete);
					importe %= billete; // importe = importe % billete;
				}
				if (importe == 0)
					break;
			}
		}
	}

}
