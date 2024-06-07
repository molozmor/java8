package es.curso.dao.lambda;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import es.curso.dao.beans.Pedido;
import es.curso.dao.dao.PedidoBD;
import es.curso.dao.dao.PedidoException;

public class Principal {

	public static void main(String[] args) {
		
		// Pruebas con funciones lambda:
		pruebasFuncionesLambda();
		
		

	}

	private static void pruebasFuncionesLambda() {
		PedidoBD bd;
		List<Pedido> pedidos;
		FileOutputStream fich = null;
		
		try {
			fich = new FileOutputStream("ficheros/pedidos.csv");
			bd = new PedidoBD("bd/empresa3.db");
			pedidos = bd.select();
			
			// Imprimir los pedidos:
			pedidos.forEach(pedido -> System.out.println(pedido));
						
			pedidos.forEach(new ConsumerPedido());
			
			pedidos.forEach(new ConsumerPedidoFile(fich));
					
			
			
		} catch (PedidoException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			if (fich != null)
				try {
					fich.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}

}
