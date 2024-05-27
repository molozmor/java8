package bucles;


public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 3 tipos de bucles:
		 * 
		 * for -> conocemos el número de iteraciones o arrays o colecciones.
		 * 
		 * while -> NO conocemos el número de iteraciones. Puede que NO llegue a
		 * ejecutarse
		 * 
		 * 
		 * do while -> NO conocemos el número de iteraciones. siempre se ejecuta al
		 * menos 1 vez
		 */

		for (int i = 0; i <= 10; i++) {
			System.out.print(i + " ");
		}
		System.out.println();

		for (int i = 10; i > 0; i--) {
			System.out.print(i + " ");
		}

		System.out.println();
		for (int i = 0; i <= 50; i += 10) {
			System.out.print(i + " ");
		}

		for (int i = 1; i <= 10; i++) {

			for (int j = 1; j <= 10; j++) {
				System.out.print(j + " ");
			}

			System.out.println();
		}

		// Leer de teclado;

		int dinero;
		int numBilletes50, numBilletes20, numBilletes10;

		//while (true) {
			do {
				System.out.print("Teclear importe: ");
				dinero = Teclado.readint();

				if (dinero % 10 != 0) {
					System.out.println("Error, valor no válido");
				}

			} while (dinero % 10 != 0);
			System.out.println("Importe a retirar: " + dinero);

			if (dinero >= 50) {
				numBilletes50 = dinero / 50;
				System.out.println("num billetes 50:" + numBilletes50);
				dinero = dinero % 50;
			}

			if (dinero >= 20) {
				numBilletes20 = dinero / 20;
				dinero = dinero % 20;
				System.out.println("num billetes 20:" + numBilletes20);
			}

			if (dinero >= 10) {
				numBilletes10 = dinero / 10;
				dinero = dinero % 10; // dinero %= 10;
				System.out.println("num billetes 10:" + numBilletes10);
			}
		//}

		// System.out.println(i);

	}

}
