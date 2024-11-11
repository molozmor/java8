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
		
		System.out.println((numero % 2 == 0) ? "par" : "impar");
		
		int a = 10, b = 9, menor;
		
		menor = (a < b) ? a : b;
		System.out.println("menor: "+menor);
		
		// Convertir 3.5 --> 3 h y 30 min
		double tiempo = 3.25, parteMinutos;
		int horas, minutos;
		
		horas = (int) tiempo;
		parteMinutos = tiempo - horas;
		minutos = (int) (parteMinutos * 60.0);
		
		System.out.println("h: "+horas+" m: "+minutos);
		
		// Secuencias de escape:
		String path = "C:/mis documentos/pruebas.csv";
		String path2 = "C:\\mis documentos\\pruebas.csv";
		
		System.err.println("El tiempo es: \"" + tiempo + "\"");
		
		int valor = -34;
		System.out.println("abs de valor: "+Math.abs(valor));
		
		int dia = 6;
		switch (dia) {
		case 1:
			System.out.println("L");
			break;
			
		case 2:
			System.out.println("M");
			break;
			
		case 3:
			System.out.println("X");
			break;
			
		case 4:
			System.out.println("J");
			break;

		case 5:
			System.out.println("V");
			break;
			
		case 6:
		case 7:
			System.out.println("finde");
			break;
			
		default:
			System.out.println("error");
			break;
		}
		
		// Bucle for:
		// for (;;); // bucle infinito.
		
		// do while infinito:
		// do { ... } while (true);
		
		for (int i = 0, j = 1 ; i < 10 && j < 10 ; i++, j+=3) {
			System.out.println("i: "+i + " j: "+j);			
		}
		
		for (int i = 0 ; i < 10 ; i++) {			
			if (i == 5)
				break; //continue; //break;
			System.out.println(i);
		}
		
		int k=0;
		while (k < 10) {
			k++;
			if (k == 5)
				continue;
			
			System.out.println(k);
			//k++;
		}
		
	}

}
