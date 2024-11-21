package es.curso.ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import es.curso.ficheros.beans.Pedido;
import es.curso.ficheros.funciones.ConsumerPedido;
import es.curso.ficheros.funciones.ConsumerPedidoOut;

public class GestorPedidos {

	private Map<String, List<Pedido>> mapaPaises;
	private String path;
	private String cabeceras;

	public GestorPedidos(String path) {
		this.path = path;
		this.mapaPaises = new TreeMap<String, List<Pedido>>();
		this.cabeceras = null;

		this.cargarMapa();
	}

	public void borrarFicheros(String carpeta) {
		File file;
		File filePais;
		String[] ficheros;

		file = new File(carpeta);
		ficheros = file.list();
		for (String fich : ficheros) {
			filePais = new File(carpeta + fich);
			filePais.delete();

			System.out.println(fich + " borrado");
		}
	}

	private void grabarFichero(String carpeta, String pais) {
		FileOutputStream fichero;
		String pathDestino;

		fichero = null;

		try {
			pathDestino = carpeta + pais + ".csv";
			fichero = new FileOutputStream(pathDestino);

			// Grabar cabeceras:
			fichero.write(cabeceras.getBytes());
			fichero.write("\n".getBytes());

			for (Pedido pedido : this.mapaPaises.get(pais)) {
				fichero.write(pedido.toCSV(";").getBytes());
				fichero.write("\n".getBytes());
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			if (fichero != null) {
				try {
					fichero.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void generarFicheros(String carpeta, String... paises) {

		for (String pais : paises) {
			this.grabarFichero(carpeta, pais);
		}
	}

	public void generarFicheros(String carpeta) {

		for (String pais : this.mapaPaises.keySet()) {
			this.grabarFichero(carpeta, pais);
		}
	}

	public List<String> getNombrePaises() {
		List<String> paises;

		paises = new ArrayList<String>();
		paises.addAll(mapaPaises.keySet());

		return paises;
	}

	public int getNumPaises() {
		return this.mapaPaises.size();
	}

	public int getNumPedidosPais(String pais) {
		return this.mapaPaises.get(pais).size();
	}

	private void cargarMapa() {
		Scanner scan = null;
		String linea, pais;
		String[] campos;
		List<Pedido> pedidos;

		try {
			scan = new Scanner(new File(path));

			// Lectura del fichero: byte a byte!
			while (scan.hasNextLine()) {
				linea = scan.nextLine();
				if (cabeceras == null) {
					cabeceras = linea;
					continue;
				}

				campos = linea.split(";");
				pais = campos[campos.length - 1].replace(' ', '_');

				// Colocar el pais en el mapa y añadir el pedido a su colección;
				if (mapaPaises.containsKey(pais)) {
					// Recuperamos la lista de pedidos de ese pais:
					pedidos = mapaPaises.get(pais);

				} else {
					// Es la primera vez, hay que crear la colección
					pedidos = new ArrayList<Pedido>();
				}

				// Añadir el pedido a la colección:
				pedidos.add(new Pedido(linea));

				// Modificar el mapa:
				mapaPaises.put(pais, pedidos);
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());

		} finally {

			if (scan != null) {
				scan.close();
			}
		}

	}

	public void imprimirPedidos(String pais) {

		/*
		 * System.out.println("Bucle for:"); for (Pedido p : this.mapaPaises.get(pais))
		 * { System.out.println(p); }
		 */

		System.out.println("forEach:"); // Con una expresión lambda -> función anónima
		this.mapaPaises.get(pais).forEach(p -> System.out.println(p));

		System.out.println("forEach2:"); // Con una clase anónima
		this.mapaPaises.get(pais).forEach(new Consumer<Pedido>() {

			@Override
			public void accept(Pedido p) {
				// TODO Auto-generated method stub
				System.out.println(p);
			}

		});

		System.out.println("forEach3:"); // Con una clase Externa
		ConsumerPedido consumer = new ConsumerPedido();
		this.mapaPaises.get(pais).forEach(consumer);
	}

	public void grabarPedidosPais(String path, String pais) {
		FileOutputStream fOut = null;
		ConsumerPedidoOut consumer;

		try {
			fOut = new FileOutputStream(path);
			consumer = new ConsumerPedidoOut(fOut); // Para lanzar a un fichero!
			// consumer = new ConsumerPedidoOut(System.out); // Para lanzar a la consola!
			this.mapaPaises.get(pais).forEach(consumer);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			if (fOut != null) {
				try {
					fOut.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * Filtrar pedidos de un país y que superen el importe mínimo:
	 * 
	 * @param pais
	 * @param importeMinimo
	 */
	public void filtrarPedidos(String pais, double importeMinimo) {

		// En el filter aplicamos una expresión lambda
		this.mapaPaises.get(pais).stream().filter(p -> p.getImporte() > importeMinimo)
				.forEach(p -> System.out.println(p));

		// Lo mismo de antes pero aplicando una interface funcional: Predicate
		Predicate<Pedido> filtro = new Predicate<Pedido>() {

			@Override
			public boolean test(Pedido p) {
				// TODO Auto-generated method stub
				return p.getImporte() > importeMinimo;
			}
		};
		System.out.println("-------------");

		// El filter aplicamos un predicado creado con una clase anónima
		this.mapaPaises.get(pais).stream().filter(filtro).forEach(p -> System.out.println(p));
	}

	/**
	 * REcuperar los pedidos de un país con un importe superior al importe mínimo:
	 * 
	 * @param pais
	 * @param importeMinimo
	 * @return
	 */
	public List<Pedido> getPedidosPaisImporte(String pais, double importeMinimo) {
		
		// Recupera la colección de pedidos de un país, filtra los que tienen un importe superior al mínimo
		// y resultado lo guarda en otra colección de pedidos:
		return this.mapaPaises.get(pais).stream().filter(p -> p.getImporte() > importeMinimo).collect(Collectors.toList());
	}
	
	/**
	 * Recuperar los ids de los pedidos de un país con un importe superior al importe mínimo:
	 * @param pais
	 * @param importeMinimo
	 * @return
	 */
	public List<Integer> getIdPedidosPaisImporte(String pais, double importeMinimo) {
		
		// La función que recupera el id del pedido a partir del pedido
		Function<Pedido, Integer> extraerId = new Function<Pedido, Integer>() {
			
			@Override
			public Integer apply(Pedido p) {
				// TODO Auto-generated method stub
				return p.getIdPedido();
			}
		};
		
		// Utilizando la función anterior: aplica la función "extraerId" a cada pedido que supera el filtro.
		//return this.mapaPaises.get(pais).stream().filter(p -> p.getImporte() > importeMinimo).map(extraerId).collect(Collectors.toList());
		
		// Con la expresión lambda:
		return this.mapaPaises.get(pais).stream().filter(p -> p.getImporte() > importeMinimo).map(p->p.getIdPedido()).collect(Collectors.toList());
		
	}
	
	/**
	 * Imprimir un listado de todos los países con el número de pedidos de cada país.
	 */
	public void listadoPaisNumPedidos() {
		
		BiConsumer<String, List<Pedido>> biConsumer = new BiConsumer<String, List<Pedido>>() {
			
			@Override
			public void accept(String pais, List<Pedido> pedidos) {
				// TODO Auto-generated method stub
				System.out.println(pais + " " + pedidos.size()+ " pedidos");				
			}
		};
		
		// Aplicar el biconsumer a cada par (clave, valor) del mapa:
		this.mapaPaises.forEach(biConsumer);
		
		System.out.println("--------------");
		
		// Con la expresión lambda:
		this.mapaPaises.forEach((pais, pedidos)->System.out.println(pais + " " + pedidos.size()+ " pedidos"));
		
	}
	
	

}
