package colecciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import es.curso.objetos.Persona;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// pruebasListas();
		// pruebaCalendarios();
		// pruebaMapas();
		pruebaMapaPersonas();
		//histogramaString(500, 20);
	}

	private static void pruebaListaPersonas() {
		// TODO Auto-generated method stub
		List<Persona> personal;

		personal = new ArrayList<Persona>();
		personal.add(new Persona("José", 30, 1.80, 80));
		personal.add(new Persona("Ana", 34, 1.70, 70));
		personal.add(new Persona("Miguel", 40, 1.60, 65));
		personal.add(new Persona("Eva", 32, 1.78, 77));

		for (Persona p : personal) {
			System.out.println(p);
		}
	}
	
	
	private static void pruebaMapaPersonas() {	
		Map<Persona, Integer> mapa = new TreeMap<Persona, Integer>();
		mapa.put(new Persona("José", 30, 1.80, 80),1);
		mapa.put(new Persona("Ana", 34, 1.70, 70),2);
		mapa.put(new Persona("Miguel", 40, 1.60, 65),3);
		mapa.put(new Persona("Eva", 32, 1.78, 77),4);
		
		for (Persona p : mapa.keySet()) {
			System.out.println(p+ " "+mapa.get(p));
			
		}
	}

	private static void pruebaMapas() {
		// TODO Auto-generated method stub

		// Map<String, Integer> mapa = new HashMap<String, Integer>(); // No mantiene el
		// orden de inserción
		// Map<String, Integer> mapa = new LinkedHashMap<String, Integer>(); // Mantiene
		// el orden
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

		System.out.println("Contains key dos: " + mapa.containsKey("dos"));
		System.out.println("Contains value 4: " + mapa.containsValue(4));

		// Map<String, List<String[]>> mapa2;

		// Utilizar un mapa para realizar un recuento de las veces que se repite un
		// valor en una lista
		// Histograma
		Random rd = new Random((new Date()).getTime());

		// Elegimos una implementación
		List<Integer> numeros = new ArrayList<>();

		for (int i = 0; i < 50; i++) {
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

	private static List<Calendario> crearCalendarios(int n) {
		List<String> meses = Arrays.asList("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto",
				"Septiembre", "Octubre", "Noviembre", "Diciembre");
		Random rd;
		List<Calendario> fechas = new ArrayList<Calendario>();
		Calendario cal;
		Date d = new Date();
		int dia, mes;

		rd = new Random(d.getTime());

		for (int i = 0; i < n; i++) {
			dia = 1 + rd.nextInt(30);
			mes = rd.nextInt(12);

			cal = new Calendario(dia, meses.get(mes));
			fechas.add(cal);
		}

		return fechas;
	}

	private static void histogramaString(int tam, int tope) {
		// Generar tam números aleatorios, se almacenan en una lista
		// Crear un histograma a partir de la lista: mapa
		List<Integer> numeros;
		Random rd;
		Date d = new Date();
		
		Map<String, Integer> histo = new TreeMap<String, Integer>(new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				// TODO Auto-generated method stub
				Integer i1, i2;
				
				i1 = Integer.parseInt(s1);
				i2 = Integer.parseInt(s2);
				
				return i1.compareTo(i2);
			}
						
		});
		int valor;
		
		rd = new Random(d.getTime());

		// Elegimos una implementación
		numeros = new ArrayList<>();

		for (int i = 0; i < tam; i++) {
			numeros.add(rd.nextInt(tope));
		}
		
		System.out.println(numeros);
		
		// Utilizar el mapa para crear un histograma. Cuantas veces se repite cada número.
		// Manteniendo el orden de los números (claves) --> TreeMap
		for (int numero : numeros) {
			if (histo.containsKey(numero+"")) {
				// Incrementar en uno el valor de la clave
				valor = histo.get(numero+"") + 1;
				
			} else {
				// Es la primera vez, se inicializa a 1 la clave:
				valor = 1;
			}
			
			histo.put(numero+"", valor);
		}
		
		// Recorrer el mapa:
		System.out.println("\n\nHISTOGRAMA:");
		for (String clave : histo.keySet()) {
			System.out.println("Número: "+clave+" se repite "+histo.get(clave)+" veces");
		}
		
		
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

		for (int i = 0; i < 50; i++) {
			numeros.add(rd.nextInt(30));
		}

		System.out.println(numeros);
		System.out.println(numeros.size() + " números");

		// Búsquedas
		numero = 23;
		if (numeros.contains(numero)) {
			System.out.println(numero + " existe en la pos: " + numeros.indexOf(numero)); // El primero de la izq.
			System.out.println(numero + " existe en la pos última: " + numeros.lastIndexOf(numero)); // El último (por
																										// la derecha)

		} else {
			System.out.println("No existe ...");
		}

		// Recorridos:
		System.out.println("\nPrimer recorrido:");
		for (int i = 0; i < numeros.size(); i++) {
			System.out.print(numeros.get(i) + " ");
		}
		System.out.println("\nSegundo recorrido:");
		for (int num : numeros) {
			System.out.print(num + " ");
		}
		System.out.println("\nTercer recorrido:");
		it = numeros.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();

		// Ordenar la colección:
		Collections.sort(numeros);
		System.out.println(numeros);

		// Como inicializar listas a valores:
		List<String> nombres = Arrays.asList("Ana", "Eva", "Pedro", "julián", "Alberto");
		Collections.sort(nombres);
		System.out.println(nombres);
	}

}
