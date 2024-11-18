package es.curso.ficheros;

import java.io.FileInputStream;
import java.io.IOException;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		leerFichero("ficheros/pedidos.csv");
	}

	private static void leerFichero(String path) {
		FileInputStream fichero = null;
		char car;
		
		try {
			fichero = new FileInputStream(path);
			
			while ((fichero.available()!=0)) {
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
