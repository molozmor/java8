package es.curso.ficheros.dao;

import java.io.File;
import java.io.FileNotFoundException;
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


	@Override
	public List<Pedido> select() throws PedidoException {
		// Recuperar la lista de pedidos del fichero
		Pedido pedido;
		Scanner scanner = null;
		String linea;
		List<Pedido> pedidos = new ArrayList<Pedido>();
		
		try {
			scanner = new Scanner(new File(this.pathFichero));
			while (scanner.hasNextLine()) {
				linea = scanner.nextLine();
				pedido = new Pedido(linea);
				pedidos.add(pedido);
			}
			
		} catch (FileNotFoundException e) {
			throw new PedidoException(e.getMessage());
			
		} finally {
			if (scanner != null) scanner.close();
		}
		return pedidos;
	}

}
