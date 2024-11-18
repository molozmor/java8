package es.curso.ficheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// leerFichero("src/es/curso/datos/Empleados.txt");
		// grabarFichero("ficheros/resultados/texto.txt");
		// leerFicheroPorFilas("ficheros/pedidos.csv");
		// generarPedidosPais("ficheros/pedidos.csv");
		// generarPedidosPaisMapa("ficheros/pedidos.csv");
		
		pruebaGestorPedidos("ficheros/pedidos.csv");
	}

	private static void pruebaGestorPedidos(String path) {
		// TODO Auto-generated method stub
		
		GestorPedidos gestorPedidos = new GestorPedidos(path);
		
		System.out.println(gestorPedidos.getNombrePaises());
		System.out.println("Alemania:"+gestorPedidos.getNumPedidosPais("Alemania"));
		
		gestorPedidos.borrarFicheros("ficheros/resultados/");
		//gestorPedidos.generarFicheros("ficheros/resultados/");
		System.out.println("Ficheros generados ...");
		
		gestorPedidos.generarFicheros("ficheros/resultados/", "Alemania", "Dinamarca");
	}

	private static void grabarFichero(String path) {
		// TODO Auto-generated method stub
		FileOutputStream fichero = null;
		List<String> meses = Arrays.asList("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto",
				"Septiembre", "Octubre", "Noviembre", "Diciembre");

		try {
			// Modo w: write, si el fichero existe lo machaca
			fichero = new FileOutputStream(path);

			// Modo a: append, añadir contenido al final del fichero
			// fichero = new FileOutputStream(path, true);

			for (String mes : meses) {
				fichero.write(mes.getBytes());
				fichero.write("\n".getBytes());
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());

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

	private static void leerFicheroPorFilas(String path) {
		Scanner scan = null;

		try {
			scan = new Scanner(new File(path));

			// Lectura del fichero: byte a byte!
			while (scan.hasNextLine()) {
				System.out.println(scan.nextLine());
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());

		} finally {

			if (scan != null) {
				scan.close();
			}
		}

	}
	
	private static void generarPedidosPaisMapa(String path) {
		Scanner scan = null;
		String linea, pais;
		String[] campos;
		String pathDestino;
		FileOutputStream ficheroPais;
		String cabeceras = null;
		Map<String, List<String>> mapaPaises;
		List<String> pedidos;

		try {
			mapaPaises = new TreeMap<String, List<String>>();
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
					pedidos = new ArrayList<String>();
				}
				
				// Añadir el pedido a la colección:
				pedidos.add(linea);
				
				// Modificar el mapa:
				mapaPaises.put(pais, pedidos);				
			}	
			
			System.out.println();
			
		} catch (Exception e) {
			System.err.println(e.getMessage());

		} finally {

			if (scan != null) {
				scan.close();
			}
		}
	}
			

	private static void generarPedidosPais(String path) {
		Scanner scan = null;
		String linea, pais;
		String[] campos;
		String pathDestino;
		FileOutputStream ficheroPais;
		String cabeceras = null;
		File file;

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
				pathDestino = "ficheros/resultados/" + pais + ".csv";

				// Comprobar si el fichero destino ya existía:
				ficheroPais = null;
				try {
					
					file = new File(pathDestino);
					if (!file.isFile()) {
						// Es la primera vez que encontramos ese pais
						// Abrir el fichero y escribir las cabeceras:
						ficheroPais = new FileOutputStream(file, true);
						ficheroPais.write(cabeceras.getBytes());
						ficheroPais.write("\n".getBytes());

					} else {
						// Si ya existe solo se abre:
						ficheroPais = new FileOutputStream(file, true);
					}

					// Grabar el pedido:
					ficheroPais.write(linea.getBytes());
					ficheroPais.write("\n".getBytes());
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
					
				} finally {
					if (ficheroPais != null)
						ficheroPais.close();
				}

			}

			// System.out.println(cabeceras);

		} catch (Exception e) {
			System.err.println(e.getMessage());

		} finally {

			if (scan != null) {
				scan.close();
			}
		}

	}

	private static void leerFichero(String path) {
		FileInputStream fichero = null;
		char car;

		try {
			fichero = new FileInputStream(path);

			// Lectura del fichero: byte a byte!
			while ((fichero.available() != 0)) {
				car = (char) fichero.read();
				System.out.print(car);
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());

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

}
