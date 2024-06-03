package es.curso.ficheros.principal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//pruebaLeerFichero();
		pruebaLeerScanner();
	}

	private static void pruebaLeerScanner() {
		Scanner scanner = null;
		String linea;
		
		try {
			scanner = new Scanner(new File("pedidos.csv"));
			while (scanner.hasNextLine()) {
				linea = scanner.nextLine();
				System.out.println(linea);
			}
			
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			
		} finally {
			if (scanner != null) scanner.close();
		}
		
	}

	private static void pruebaLeerFichero() {
		// Leer un fichero por bytes.
		
		FileInputStream fichero = null;
		String linea;
		byte[] bytes;
		
		try {
			fichero = new FileInputStream("pedidos.csv");
			
			// Ojo estamos leyendo en bytes. No es la mejor forma para leer un fichero
			// organizado en filas. Podemos perder la estructura de las filas del fichero.
			while (fichero.available() > 0) {
				bytes = new byte[100];
				fichero.read(bytes);
				
				linea = new String(bytes, 0, bytes.length);
				System.out.println(linea);
				System.out.println();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			if (fichero != null)
				try {
					fichero.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
	}

}
