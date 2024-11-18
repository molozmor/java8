package es.curso.ficheros;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//leerFichero("src/es/curso/datos/Empleados.txt");
		grabarFichero("ficheros/resultados/texto.txt");
	}

	private static void grabarFichero(String path) {
		// TODO Auto-generated method stub
		FileOutputStream fichero = null;
		List<String> meses = Arrays.asList("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto",
				"Septiembre", "Octubre", "Noviembre", "Diciembre");

		try {
			// Modo w: write, si el fichero existe lo machaca
			//fichero = new FileOutputStream(path);
			
			// Modo a: append, añadir contenido al final del fichero
			fichero = new FileOutputStream(path, true);
			
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
