package arrays;

import java.util.Arrays;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] numeros = {1,22,-3,44,15};
		int numeros2[];
		int numeros3[]=null;
		
		numeros2 = new int[10]; // Reserva espacio para 10 enteros.
		
		System.out.println("numeros tiene "+numeros.length+" elementos");
		
		if (numeros3 != null)
			System.out.println("numeros3 tiene "+numeros3.length+" elementos");
		else
			System.out.println("numeros3 está vacío");
		
		// Recorridos del array;
		for (int i = 0 ; i < numeros.length ; i++) {
			System.out.print(numeros[i]+"\t");
		}
		System.out.println();
		
		for (int item : numeros) {
			System.out.print(item + "\t");
		}
		System.out.println();
		
		Arrays.sort(numeros);
		System.out.println(Arrays.toString(numeros));
		
		//System.out.println(numeros[10]);
		
		// Copiar un array:
		numeros3 = new int[numeros.length];
		System.arraycopy(numeros, 0, numeros3, 0, numeros.length); // Antes de copiar reservar espacio.
		
		//numeros3 = numeros; OJO es una referencia al mismo array.
				
		numeros[0] = 1000;
		System.out.println(Arrays.toString(numeros3));
		
		if (Arrays.equals(numeros3, numeros)) {
			System.out.println("son iguales");
			
		} else {
			System.out.println("son distintos");
		}
			
		
	}

}
