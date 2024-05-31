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
		//pruebaMapas();		
		//pruebaMapa2();
		
		pruebasListasMapas();
	}
	

	private static void pruebasListasMapas() {
		// TODO Auto-generated method stub
		
		// Definir un mapa que pueda almacenar el día de la semana y una lista con los gastos
		// de cada día:
		
		Contabilidad conta;
		
		try {
			conta = new Contabilidad();
			
			conta.addGasto("Lunes", 230);
			conta.addGasto("LUNES", 117);
			conta.addGasto("Jueves", 30);
			conta.addGasto("Sabado", 56);
			conta.addGasto("Domingo", 30);
			
			conta.print();
			
		} catch (ContabilidadException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}


	private static void pruebaMapa2() {
		// TODO Auto-generated method stub
		// Definir,añadir
		/*
		 * Map<String, Integer> gastos = new HashMap<String, Integer>();
		 *
		 * gastos.put("Lunes",230); gastos.put("Martes",30); gastos.put("Miercoles",12);
		 * gastos.put("Jueves",145); gastos.put("Viernes",500);
		 * System.out.println(gastos);
		 */
		// Definir, añadir
		Map<String, Integer> gastos = new LinkedHashMap<String, Integer>();
 
		    gastos.put("Jueves", 145);
	        gastos.put("Viernes", 500);
	        gastos.put("Lunes", 230);
	        gastos.put("Martes", 30);
	        gastos.put("Miercoles", 12);
 
	        // Imprimir el mapa original
	        System.out.println("Mapa original:");
	        for (Map.Entry<String, Integer> entry : gastos.entrySet()) {
	            System.out.println(entry.getKey() + ": " + entry.getValue());
	        }
 
	        // Lista predefinida del orden de los días de la semana
	        String[] diasSemana = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes"};
 
	        // Crear un nuevo LinkedHashMap para mantener el orden deseado
	        Map<String, Integer> gastosOrdenados = new LinkedHashMap<>();
 
	        // Añadir las entradas en el orden de la lista predefinida
	        for (String dia : diasSemana) {
	            if (gastos.containsKey(dia)) {
	                gastosOrdenados.put(dia, gastos.get(dia));
	            }
	        }
 
	        // Imprimir el mapa ordenado
	        System.out.println("\nMapa ordenado:");
	        for (Map.Entry<String, Integer> entry : gastosOrdenados.entrySet()) {
	            System.out.println(entry.getKey() + ": " + entry.getValue());
	        }
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
		
		// Ordena alfabeticamente
		Map<String, Integer> gastos3 = new TreeMap<String, Integer>();
		gastos3.put("Lunes", 230);
		gastos3.put("Viernes", 12);
		gastos3.put("Jueves", 145);
		gastos3.put("Sabado", 500);
	
		System.out.println(gastos3);
		
		// Ordenando por día de la semana:
		Map<String, Integer> gastos4 = new TreeMap<String, Integer>(new OrdenarDiaSemana());
		gastos4.put("Lunes", 230);
		gastos4.put("Viernes", 12);
		gastos4.put("Jueves", 145);
		gastos4.put("Sabado", 230);
	
		System.out.println(gastos4);		
		
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
