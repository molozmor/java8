package colecciones;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//pruebasListas();
		//pruebaCalendarios();
		pruebaMapas();
	}

	private static void pruebaMapas() {
		// TODO Auto-generated method stub
		
		//Map<String, Integer> mapa = new HashMap<String, Integer>(); // No mantiene el orden de inserción
		// Map<String, Integer> mapa = new LinkedHashMap<String, Integer>(); // Mantiene el orden
		Map<String, Integer> mapa = new TreeMap<String, Integer>(); // Ordenar las claves
		
		mapa.put("uno", 1);
		mapa.put("dos", 2);
		mapa.put("cinco", 5);
		mapa.put("tres", 3);
		mapa.put("cuatro", 4);
		
		System.out.println(mapa);
		
		for (String key : mapa.keySet()) {
			System.out.println(key + " => " + mapa.get(key));
		}
		
		System.out.println("Contains key dos: "+mapa.containsKey("dos"));
		System.out.println("Contains value 4: "+mapa.containsValue(4));
		
		
		//Map<String, List<String[]>> mapa2;
		
		
		// Utilizar un mapa para realizar un recuento de las veces que se repite un valor en una lista
		// Histograma
		Random rd = new Random((new Date()).getTime());

		// Elegimos una implementación
		List<Integer> numeros = new ArrayList<>();
		
		for (int i = 0 ; i < 50 ; i++) {
			numeros.add(rd.nextInt(30));
		}
		
		Map<Integer, Integer> histograma = new HashMap<Integer, Integer>();
		
		
	}

	private static void pruebaCalendarios() {
		// TODO Auto-generated method stub
		List<Calendario> fechas = crearCalendarios(25);
		
		Collections.sort(fechas);
		
		for (Calendario c : fechas) {
			System.out.println(c);
		}
	}

	private static List<Calendario> crearCalendarios(int n){
		List<String> meses = Arrays.asList("Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre");		
		Random rd;
		List<Calendario> fechas = new ArrayList<Calendario>();
		Calendario cal;
		Date d = new Date();
		int dia, mes;
		
		rd = new Random(d.getTime());
		
		for (int i = 0 ; i < n ; i++) {
			dia = 1 + rd.nextInt(30);
			mes = rd.nextInt(12);
			
			cal = new Calendario(dia, meses.get(mes));
			fechas.add(cal);
		}	
		
		return fechas;
	}
	
	
	private static void pruebasListas() {
		// List<int> numeros; // No podemos utilizar tipos primitivos
		List<Integer> numeros;
		Random rd;
		Date d = new Date();
		int numero;
		Iterator<Integer> it;
		
		rd = new Random(d.getTime());

		// Elegimos una implementación
		numeros = new ArrayList<>();
		
		for (int i = 0 ; i < 50 ; i++) {
			numeros.add(rd.nextInt(30));
		}
		
		System.out.println(numeros);
		System.out.println(numeros.size()+" números");
		
		// Búsquedas
		numero = 23;
		if (numeros.contains(numero)) {
			System.out.println(numero + " existe en la pos: "+numeros.indexOf(numero)); // El primero de la izq.
			System.out.println(numero + " existe en la pos última: "+numeros.lastIndexOf(numero)); // El último (por la derecha)
			
		} else {
			System.out.println("No existe ..."); 
		}
		
		// Recorridos:
		System.out.println("\nPrimer recorrido:");
		for (int i = 0 ; i < numeros.size() ; i++) {
			System.out.print(numeros.get(i)+" ");
		}
		System.out.println("\nSegundo recorrido:");
		for (int num : numeros) {
			System.out.print(num+" ");
		}
		System.out.println("\nTercer recorrido:");
		it = numeros.iterator();
		while (it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		System.out.println();
		
		// Ordenar la colección:
		Collections.sort(numeros);
		System.out.println(numeros);
		
		// Como inicializar listas a valores:
		List<String> nombres = Arrays.asList("Ana","Eva","Pedro", "julián","Alberto");
		Collections.sort(nombres);
		System.out.println(nombres);
		
		
		
	}

}
