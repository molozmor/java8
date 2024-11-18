package es.curso.ficheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// leerFichero("src/es/curso/datos/Empleados.txt");
		// grabarFichero("ficheros/resultados/texto.txt");
		// leerFicheroPorFilas("ficheros/pedidos.csv");
		generarPedidosPais("ficheros/pedidos.csv");
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
