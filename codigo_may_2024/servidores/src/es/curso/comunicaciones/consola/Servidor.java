package es.curso.comunicaciones.consola;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	
	public static final int PUERTO = 4545;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket server = null;
		Socket cliente = null;
		String texto;
		
		// Para leer / escribir
		DataInputStream canalEntrada = null;
		DataOutputStream canalSalida = null;
		
		try {
			// Crear el socket para atender a los clientes:			
			server = new ServerSocket(PUERTO);
			System.out.println("Servidor ok!");
			
			// Aceptar clientes:
			System.out.println("Esperando clientes ...");
			cliente = server.accept();			
			System.out.println("cliente conectado: "+cliente.getLocalAddress());
			
			// Habilitar canales de E/S:
			canalEntrada = new DataInputStream(cliente.getInputStream());
			canalSalida = new DataOutputStream(cliente.getOutputStream());
			
			do {
				// Esperar el mensaje del cliente:
				texto = canalEntrada.readUTF();
				
				// Enviar respuesta al cliente:
				canalSalida.writeUTF(texto.toUpperCase());
				
			} while (!texto.equalsIgnoreCase("fin"));
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			
		}  finally {
			
			try {
				if (canalEntrada != null) canalEntrada.close();
				if (canalSalida != null) canalSalida.close();
				if (cliente!= null) cliente.close();
				if (server != null) server.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
	}
	}

}
