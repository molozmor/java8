package es.curso.sockets.cliente;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import es.curso.sockets.beans.Pedido;

public class ClienteBD {

	private static final String HOST = "127.0.0.1";
	private static final int PUERTO = 4500;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Socket socket = null;
		ObjectInputStream entrada = null;
		DataOutputStream salida = null;
		String texto;
		Scanner scan = null;
		Pedido pedido;

		try {
			scan = new Scanner(System.in);

			// Crear el socket para conectar con el servidor
			socket = new Socket(HOST, PUERTO);

			// Habilitar los canales de entrada / salida:

			// Leemos objetos
			entrada = new ObjectInputStream(socket.getInputStream());

			// Enviamos tipos básicos
			salida = new DataOutputStream(socket.getOutputStream());

			do {
				// Leer de teclado el mensaje
				System.out.print("Identificador del pedido:> ");
				texto = scan.nextLine();

				// Enviar al servidor el mensaje codificado en UTF:
				salida.writeUTF(texto);

				if (!texto.equals("0")) {
					// Esperar la respuesta del Servidor:
					pedido = (Pedido) entrada.readObject();

					System.out.println("Datos del pedido:> " + pedido);
				}

			} while (!texto.equalsIgnoreCase("0"));

		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());

		} finally {

			try {

				if (scan != null)
					scan.close();
				if (entrada != null)
					entrada.close();
				if (salida != null)
					salida.close();
				if (socket != null)
					socket.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
