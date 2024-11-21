package es.curso.sockets.servidor;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import es.curso.sockets.beans.Pedido;
import es.curso.sockets.dao.IOperaciones;
import es.curso.sockets.dao.PedidoBD;
import es.curso.sockets.dao.PedidoException;

public class ServidorBD {
	
	private static final int PUERTO = 4500;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ServerSocket servidor = null;
		Socket socketCliente = null;
		DataInputStream entrada = null;
		ObjectOutputStream salida = null;
		String strIdPedido;
		int idPedido;
		Pedido pedido;
		IOperaciones dao = null;

		try {
			
			// Crear el dao:
			dao = new PedidoBD("empresa3.db");

			// Crear el socket para conectar con el servidor
			servidor = new ServerSocket(PUERTO);
			System.out.println("Se ha iniciado el Servidor BD!");

			// Esperar cliente:
			System.out.println("Esperando clientes!");
			socketCliente = servidor.accept();

			System.out.println("Cliente conectado: " + socketCliente.toString());

			// Habilitar los canales de entrada / salida:
			entrada = new DataInputStream(socketCliente.getInputStream());
			salida = new ObjectOutputStream(socketCliente.getOutputStream());

			do {
				// Esperar la respuesta del Servidor:
				strIdPedido = entrada.readUTF();
				idPedido = Integer.parseInt(strIdPedido);

				if (idPedido != 0) {
					System.out.println("El cliente solicita el id: " + idPedido);
					
					// Buscar el pedido en la BD:
					pedido = dao.read(idPedido);

					// Responder al cliente					
					salida.writeObject(pedido);
				}

			} while (idPedido != 0);

		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());

		} catch (PedidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {

			try {

				if (dao != null)
					dao.close();
				
				if (entrada != null)
					entrada.close();
				if (salida != null)
					salida.close();
				if (socketCliente != null)
					socketCliente.close();

			} catch (IOException | PedidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
