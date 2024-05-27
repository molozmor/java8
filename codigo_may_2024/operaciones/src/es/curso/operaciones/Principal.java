package es.curso.operaciones;

public class Principal {

	public static void main(String[] args) {

		pruebaOperadores();
		//calcularEcuGrado2();
		
		
	}

	private static void calcularEcuGrado2() {
		// TODO Auto-generated method stub

		int a, b, c; // 1,2,3 no tiene solución
		double x1, x2, raiz;

		// Potencia:
		System.out.println(Math.pow(2, 3));

		// Raíz
		System.out.println(Math.sqrt(25));

		a = 1;
		b = 2;
		c = 3;

		raiz = Math.pow(b, 2.0) - 4 * a * c;

		if (raiz > 0) {
			x1 = (-b + Math.sqrt(raiz)) / (2 * a);
			x2 = (-b - Math.sqrt(raiz)) / (2 * a);

			System.out.println("x1: " + x1 + " x2: " + x2);
			
		} else {
			System.out.println("No hay solución");
		}

	}

	private static void pruebaOperadores() {
		// TODO Auto-generated method stub

		int a, b;

		a = 10;
		b = ++a;
		System.out.println("a: " + a + " b:" + b);

		a = 10;
		b = a++;
		System.out.println("a: " + a + " b:" + b);
		
		// Calcular el iva de un importe:
		double importe = 1200.56;
		double iva;
		
		iva = importe * 0.21;
		System.out.println("importe: "+importe + " iva: " + iva);
		
		
		// DEfinición de letras o char:
		char letra = 'A';
		letra++;
		System.out.println("Letra: "+ letra + " numero: " + (int) letra);
		
		letra = (char) (letra + 5);
		
		// Obtener la parte entera de un número real:
		double horas = 2.5; // h = 2, m = 30
		double minutos;
		int h, m;
		
		h = (int) horas;
		minutos = horas - h;
		m = (int) (minutos * 60.0);
		System.out.println("h: " + h + " m:" + m );
		
		// Convertir h y m a double:
		double horas2 = h + (m / 60.0);
		System.out.println("horas2: "+horas2);
		
		double horas3 = h + (m / 60);
		System.out.println("horas3: "+horas3);
		
		// Convertir un numero a char:
		int num = 67;
		letra = (char) num;
		System.out.println("Letra: " + letra);
		
		
				
	}
}
