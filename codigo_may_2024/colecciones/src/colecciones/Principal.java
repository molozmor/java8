package colecciones;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//pruebaListas();
		pruebaMapas();
	}

	private static void pruebaMapas() {
		// Definir, crear, añadir claves, recuperar valores, recorridos, ...
		
		// Ni ordena por clave y tampoco mantiene el orden de inserción
		Map<String, Integer> gastos = new HashMap<String, Integer>();
		gastos.put("Lunes", 230);
		gastos.put("Viernes", 12);
		gastos.put("Jueves", 145);
		gastos.put("Sabado", 500);
		
		System.out.println(gastos);
				
		
		for (String key : gastos.keySet()) {
			System.out.println(key + " " + gastos.get(key) + " " + key.hashCode());
		}
		
		gastos.put("Viernes", 222);
		System.out.println(gastos);
		
		// Con el orden de inserción:
		Map<String, Integer> gastos2 = new LinkedHashMap<String, Integer>();
		gastos2.put("Lunes", 230);
		gastos2.put("Viernes", 12);
		gastos2.put("Jueves", 145);
		gastos2.put("Sabado", 500);
	
		System.out.println(gastos2);
		
		// Mantiendo un orden personalizado:
		Map<String, Integer> gastos3 = new TreeMap<String, Integer>();
		gastos3.put("Lunes", 230);
		gastos3.put("Viernes", 12);
		gastos3.put("Jueves", 145);
		gastos3.put("Sabado", 500);
	
		System.out.println(gastos3);
		
		
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
