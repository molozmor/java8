package colecciones;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		pruebaListas();
	}

	private static void pruebaListas() {
		// Crear listas, comparar dos listas, recorrer con el iterador
		
		List<String> diasSemana = Arrays.asList("LU","MA","MI","JU","VI","SA","DO");				
		System.out.println(diasSemana);
		
		// Recorrer la lista con el iterador:
		Iterator<String> it = diasSemana.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		
		// Comparar listas:
		List<Integer> lista1 = Arrays.asList(1,2,3,4,6,7);
		List<Integer> lista2 = Arrays.asList(1,2,3,4,6,7);
		
		System.out.println("Listas iguales: "+ lista1.equals(lista2));
		
		// Prueba con linkedlist:
		List<String> nombres = new LinkedList<String>();
		
		nombres.add("Tomás");
		nombres.add("Ana");
		nombres.add("Raúl");
		nombres.add("Eva");
		nombres.add("Sofía");
		
		Collections.sort(nombres);
		System.out.println(nombres);
		
		
	}

}
