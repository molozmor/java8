package es.curso.sockets.servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


public class ServidorTexto {

	private static final String HOST = "127.0.0.1";
	private static final int PUERTO = 4500;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ServerSocket servidor = null;
		Socket socketCliente = null;
		DataInputStream entrada = null;
		DataOutputStream salida = null;
		String mensajeCliente;
			
		try {
						
			// Crear el socket para conectar con el servidor
			servidor = new ServerSocket(PUERTO);
			System.out.println("Se ha iniciado el Servidor!");
			
			// Esperar cliente:
			System.out.println("Esperando clientes!");
			socketCliente = servidor.accept();
			
			System.out.println("Cliente conectado: "+socketCliente.toString());
			
			// Habilitar los canales de entrada / salida:
			entrada = new DataInputStream(socketCliente.getInputStream());
			salida = new DataOutputStream(socketCliente.getOutputStream());
			
			do {
				// Esperar la respuesta del Servidor:
				mensajeCliente = entrada.readUTF();
				
				System.out.println("El cliente dice: "+mensajeCliente);
				
				// Responder al cliente
				salida.writeUTF(mensajeCliente.toUpperCase());
							
											
			} while (!mensajeCliente.equalsIgnoreCase("fin"));
			
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
		} finally {
								
			try {
								
				if (entrada!=null) entrada.close();
				if (salida != null) salida.close();
				if (socketCliente!=null) socketCliente.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
