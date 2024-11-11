package es.curso.operadores;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numero1, numero2;
		double media;
		
		System.out.println("Teclear número1: ");
		numero1 = Teclado.readint();
		
		System.out.println("Teclear número2: ");
		numero2 = Teclado.readint();
		
		media = (numero1+numero2) / 2.0;
		System.out.println("La media es: "+media);
		
		// Validar si una variable es múltiplo de 10:
		int importe;
		
		System.out.println("Teclear importe: ");
		importe = Teclado.readint();
		
		if (importe % 10 == 0)
			System.out.println("múltiplo de 10");
		else
			System.out.println("no es múltiplo de 10");
		
		// Operadores postfijo y prefijo:
		int a = 10, b, c;
		
		b = ++a; // ++a; b = a;
		System.out.println("b: "+b);
		
		c = a++; // c = a; a++;
		System.out.println("c: " + c);
		
	}

}
