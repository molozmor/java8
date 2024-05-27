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
		int menor;
		
		if (n1 < n2) {
			menor = n1;
			
		} else if (n2 < n1) {
			menor = n2;
			
		} else {
			System.out.println("los dos valores son iguales");
			menor = n1;
		}
		
		System.out.println("El menor es: "+menor);
		
		
		// Comprobar si una variable se encuentra dentro de un intervalo (cerrado):
		int ini = 10;
		int fin = 50;
		int numero = 230;
		
		if (numero >= ini && numero <= fin) {
			System.out.println(numero+" dentro del intervalo");
		} else {
			System.out.println("No está dentro del intervalo");
		}
		
		
		

	}

}
