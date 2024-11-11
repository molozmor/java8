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
		
		System.out.println(numeros[10]);
		
	}

}
