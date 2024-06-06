package genericos;

import java.util.Arrays;

public class Principal {
		
	public static <T extends Comparable<T>> void ordenar(T[] array) {
	    T aux;
	    for (int i = 0; i < array.length - 1; i++) {
	        for (int j = i + 1; j < array.length; j++) {
	            if (array[i].compareTo(array[j]) > 0) {
	               
	                aux = array[i];
	                array[i] = array[j];
	                array[j] = aux;
	            }
	        }
	    }
	}
	
	/*
	public static <T> void ordenar(T[] array) {
		T aux;
		
		for (int i = 0 ; i < array.length-1 ; i++) {
			for (int j = i+1 ; j < array.length ; j++) {
				if (compareTo(array[i], array[j]) > 0) {
					
				}
			}
		}
	}*/

	public static void main(String[] args) {
		ObjectWrapper obj;
		
		obj = new ObjectWrapper("cadena");
		String cad = (String) obj.get();
		
		obj.set(new Integer(100));
		int num = (int) obj.get();
		
		// Con el tipo generico:
		Wrapper<String> texto = new Wrapper<String>("hola");
		cad = texto.getInstancia();			
		
		// Ya no lo permite:
		//texto = texto.setInstancia(new Integer(100));
		
		Wrapper<Integer> numero = new Wrapper<Integer>(new Integer(100));
		num = numero.getInstancia();
		
		////////////////////////////////
		
		Matriz<Integer> m1 = new Matriz<Integer>(5, 7, 0);
		m1.print();
		System.out.println();
		m1.set(3, 4, 99);
		m1.print();
		System.out.println();
		
		Matriz<String> m2 = new Matriz<String>(5, 7, "hola");
		m2.set(0, 0, "XXX");
		m2.print();
		
		// Ordenar arrays:
		Integer numeros[] = {4,6,4,2,1,2,4,5};
		String nombres[] = {"Gema", "Ana","Raúl","Roberto"};
		
		ordenar(nombres);
		ordenar(numeros);
		System.out.println(Arrays.toString(nombres));
		System.out.println(Arrays.toString(numeros));
	}

}
