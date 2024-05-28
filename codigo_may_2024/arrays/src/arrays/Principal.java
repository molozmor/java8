package arrays;

import java.util.Arrays;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Definición de arrays:
		int numeros[] = {1,2,3,4,5,6};
		double []reales = {1.8, 4.7, 2.9};
		
		
		System.out.println("numeros: " + numeros.length);
		for (int i = 0 ; i < numeros.length ; i++) {
			System.out.print(numeros[i]+" ");
		}
		System.out.println();
		
		for (double real : reales) {
			System.out.print(real + " ");
		}
		
		System.out.println();
		
		System.out.println("args: " + args.length);
		
		for (String argumento : args) {
			System.out.println(argumento);
		}
		  
		// Buscar un número dentro del array y obtener la posición:
		int []valores = {45,3,1,2,3,6,7,8,9,99,0, -1, -6 };
		int numero = 99;
		boolean existe = false;
		 
		for (int i = 0 ; i < valores.length && !existe ; i++) {
			if (numero == valores[i]) {
				System.out.println("el número: " + numero + " está en la posición: "+i);
				existe = true;
				//break; // Estamos buscando la primera ocurrencia.
			}
		}
		
		if (!existe) {
			System.out.println("No existe el número: "+numero);
		}
		
		// Calcular la suma de los elementos de un array:
		double numeros2[] = {55.6, 86.4, 12.6, 7.8, 9.9};
		double max = numeros2[0];
		double min = numeros2[0];
		double suma = 0.0;
		
		for (double valor : numeros2) {
			suma += valor;
			
			if (valor > max) max = valor;
			if (valor < min) min = valor;
		}
		
		System.out.println("Suma: "+suma);
		System.out.println("Media: "+(suma / numeros2.length) );
		System.out.println("Máximo: " + max);
		System.out.println("Mínimo: " + min);
		System.out.println("Recuento: " + numeros2.length);
		
		// Ordenar el array numeros2 e imprimirlo:
		Arrays.sort(numeros2);
		System.out.println(Arrays.toString(numeros2));
		
		
		
		// Leer 5 de teclado y almacenarlos en un array:
		int numeros3[] = new int[5];
		
		for (int i = 0 ; i < numeros3.length ; i++) {
			System.out.println("Teclear número: ");
			numeros3[i] = Teclado.readint();
			
		}
		
		Arrays.sort(numeros3);
		
		for (int n : numeros3) {
			System.out.println(n);
		}
		
		System.out.println(Arrays.toString(numeros3));
		
		// Arrays de dos dimensiones:
		int tablas[][] = {{1,2,3,0},{4,5,6,0},{7,8,9,0}};
		
		System.out.println("(0,0) " + tablas[0][0]);
		System.out.println("(2,2) " + tablas[2][2]);
		
		// Número de filas:
		System.out.println("num filas: "+tablas.length);
		System.out.println("num cols: "+tablas[0].length);
		
		for (int i = 0 ; i < tablas.length ; i++) {
			
			for (int j = 0 ; j < tablas[i].length ; j++ ) {
				System.out.print(tablas[i][j] + "  ");
			}
			System.out.println();
		}
		
		//Con el otro bucle for:
		for (int []fila  : tablas) {
			for (int num : fila) {
				System.out.print(num + "  ");
			}
			System.out.println();
		}
		
		for (int []fila  : tablas) {
			System.out.println(Arrays.toString(fila));
		}
	}

}
