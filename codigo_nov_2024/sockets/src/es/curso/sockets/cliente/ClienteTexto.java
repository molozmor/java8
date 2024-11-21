package es.curso.sockets.cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteTexto {
	
	private static final String HOST = "127.0.0.1";
	private static final int PUERTO = 4500;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Socket socket = null;
		DataInputStream entrada = null;
		DataOutputStream salida = null;
		String texto;
		String mensajeServer;
		Scanner scan = null;
		
		try {
			scan = new Scanner(System.in);
			
			// Crear el socket para conectar con el servidor
			socket = new Socket(HOST, PUERTO);
			
			// Habilitar los canales de entrada / salida:
			entrada = new DataInputStream(socket.getInputStream());
			salida = new DataOutputStream(socket.getOutputStream());
			
			do {
				// Leer de teclado el mensaje
				System.out.print("Teclear mensaje:> ");
				texto = scan.nextLine();
				
				// Enviar al servidor el mensaje codificado en UTF:
				salida.writeUTF(texto);
				
				// Esperar la respuesta del Servidor:
				mensajeServer = entrada.readUTF();
				
				System.out.println("SERVER:> "+mensajeServer);
				
			} while (!texto.equalsIgnoreCase("fin"));
			
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
		} finally {
								
			try {
				
				if (scan != null) scan.close();
				if (entrada!=null) entrada.close();
				if (salida != null) salida.close();
				if (socket!=null) socket.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
