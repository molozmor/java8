package es.curso.ficheros.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import es.curso.ficheros.beans.Pedido;

public class PedidoFile implements IOperaciones {

	private String pathFichero;

	public PedidoFile(String pathFichero) {
		super();
		this.pathFichero = pathFichero;
	}

	public static void exportarPaises(String path) {
		// Generar un fichero por cada pais:
		Scanner scanner = null;
		String linea;
		String cabeceras = null;
		File fichero;
		String[] datos;
		String pais, pathPais;
		FileOutputStream ficheroPais;
		boolean existeFichero;

		try {
			scanner = new Scanner(new File(path));
			while (scanner.hasNextLine()) {
				linea = scanner.nextLine();

				if (cabeceras == null) {
					// Saltar las cabeceras:
					cabeceras = linea;
					continue;
				}

				// Partir la linea por el separador;
				datos = linea.split(";");

				// extraer el pais:
				pais = datos[datos.length - 1];

				// Comprobar de que pais es el pedido:
				pathPais = "paises/" + pais + ".csv";
				fichero = new File(pathPais);
				existeFichero = fichero.exists();
				ficheroPais = null;

				try {
					// Grabar la linea de pedido en un fichero para cada pais:
					ficheroPais = new FileOutputStream(pathPais);

					if (!existeFichero) {
						// Si no existe hay que poner cabeceras:
						ficheroPais.write(cabeceras.getBytes());
						ficheroPais.write("\n".getBytes());
					}
					
					// grabar la linea del pedido:
					ficheroPais.write(linea.getBytes());
					ficheroPais.write("\n".getBytes());

				} catch (IOException e) {
					System.out.println("error en el fichero: "+pathPais);
					System.out.println(e.getMessage());
					
				} finally {
					if (ficheroPais != null) {
						try {
							ficheroPais.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}

			}

		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());

		} finally {
			if (scanner != null)
				scanner.close();
		}
	}

	@Override
	public List<Pedido> select() throws PedidoException {
		// Recuperar la lista de pedidos del fichero
		Pedido pedido;
		Scanner scanner = null;
		String linea;
		List<Pedido> pedidos = new ArrayList<Pedido>();
		boolean primeraFila = true;

		try {
			scanner = new Scanner(new File(this.pathFichero));
			while (scanner.hasNextLine()) {
				linea = scanner.nextLine();

				if (primeraFila) {
					// Saltar las cabeceras:
					primeraFila = false;
					continue;
				}
				pedido = new Pedido(linea);
				pedidos.add(pedido);
			}

		} catch (FileNotFoundException e) {
			throw new PedidoException(e.getMessage());

		} finally {
			if (scanner != null)
				scanner.close();
		}
		return pedidos;
	}

}
