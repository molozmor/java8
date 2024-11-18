package es.curso.ficheros;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class GestorPedidos {

	private Map<String, List<String>> mapaPaises;
	private String path;
	private String cabeceras;

	public GestorPedidos(String path) {
		this.path = path;
		this.mapaPaises = new TreeMap<String, List<String>>();
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
			filePais = new File(carpeta+fich);
			filePais.delete();
			
			System.out.println(fich+" borrado");
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
			
			for (String pedido : this.mapaPaises.get(pais)) {
				fichero.write(pedido.getBytes());
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
	
	public void generarFicheros(String carpeta, String...paises) {
		
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
		List<String> pedidos;

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
					pedidos = new ArrayList<String>();
				}

				// Añadir el pedido a la colección:
				pedidos.add(linea);

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

}
