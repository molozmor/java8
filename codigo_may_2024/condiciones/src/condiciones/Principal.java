package condiciones;

public class Principal {

	public static void main(String[] args) {
		int importe = 40;
						
		if (importe < 50) {
			System.out.println("No se pueden aplicar los de 50");
			
		} else {
			System.out.println("El importe es >= 50");
		}
		
		
		// Calcular el menor de dos números:
		int n1 = 30;
		int n2 = 30;
		int menor, menor2;
		
		if (n1 < n2) {
			menor = n1;
			
		} else if (n2 < n1) {
			menor = n2;
			
		} else {
			System.out.println("los dos valores son iguales");
			menor = n1;
		}
		
		System.out.println("El menor es: "+menor);
		
		// Operador ternario equivalente a un if-else
		menor2 = (n1 < n2) ? n1 : n2;
		System.out.println("El menor es: "+menor2);
		
		// Imprimir la palabra "par" si un numero es par, si no "impar"
		System.out.println((menor2 % 2 == 0) ? "par" : "impar");
		
		
		// Comprobar si una variable se encuentra dentro de un intervalo (cerrado):
		// Operadores lógicos: && and, || or, ! not
		int ini = 10;
		int fin = 50;
		int numero = 230;
		
		if (numero >= ini && numero <= fin) {
			System.out.println(numero+" dentro del intervalo");
		} else {
			System.out.println("No está dentro del intervalo");
		}
		
		// Invertir la condición:
		if (numero < ini || numero > fin) {
			System.out.println("No está dentro del intervalo");
			
		} else {
			System.out.println(numero+" dentro del intervalo");
		}
		
		// No está en el intervalo
		if (!(numero >= ini && numero <= fin)) {
			System.out.println("No está dentro del intervalo");
			
		} else {
			System.out.println(numero+" dentro del intervalo");
		}
		
		// Imprimir el nombre del dia de la semana a partir de una variable entera
		int dia = 6;
		
		switch (dia) {
		case 1:
			System.out.println("lunes");
			break;
			
		case 2:
			System.out.println("martes");
			break;
			
		case 3:
			System.out.println("miércoles");
			break;
			
		case 4:
			System.out.println("jueves");
			break;
			
		case 5:
			System.out.println("viernes");
			break;
			
		case 6:
		case 7:
			System.out.println("fin de semana");
			break;

		default:
			System.out.println("hay un error en el número del día:  de 1 a 7");
			break;
		}
		
		
	}

}
