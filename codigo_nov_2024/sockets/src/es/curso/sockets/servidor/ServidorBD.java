package es.curso.sockets.servidor;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import es.curso.sockets.beans.Pedido;

public class ServidorBD {

	private static final String HOST = "127.0.0.1";
	private static final int PUERTO = 4500;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ServerSocket servidor = null;
		Socket socketCliente = null;
		DataInputStream entrada = null;
		ObjectOutputStream salida = null;
		String strIdPedido;
		int idPedido;
		Pedido pedido = new Pedido(0, "ADERF", 1, 1, 450.0, "España");

		try {

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

					// Responder al cliente
					pedido.setIdPedido(idPedido);
					salida.writeObject(pedido);
				}

			} while (idPedido != 0);

		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());

		} finally {

			try {

				if (entrada != null)
					entrada.close();
				if (salida != null)
					salida.close();
				if (socketCliente != null)
					socketCliente.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
