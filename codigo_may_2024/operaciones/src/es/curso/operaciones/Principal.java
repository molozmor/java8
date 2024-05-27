package es.curso.operaciones;

public class Principal {

	public static void main(String[] args) {
		
		pruebaOperadores();
		calcularEcuGrado2();
	}

	private static void calcularEcuGrado2() {
		// TODO Auto-generated method stub
		
		// Potencia:
		System.out.println(Math.pow(2, 3));
		System.out.println(Math.sqrt(25));
		
		int a,b,c; // 1,2,3 no tiene solución
		
		a = 1;
		b = 5; 
		c = 4;
		
		double x1, x2;
		
		//x1 = -b +
		//x2 = -b - 
		
	}

	private static void pruebaOperadores() {
		// TODO Auto-generated method stub
		
		int a, b;
		
		a = 10;
		b = ++a;
		System.out.println("a: "+a +" b:"+b);
		
		a = 10;
		b = a++;
		System.out.println("a: "+a +" b:"+b);
		
		
	}
}
