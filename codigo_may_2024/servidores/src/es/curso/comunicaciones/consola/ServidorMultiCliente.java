package es.curso.comunicaciones.consola;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorMultiCliente {
	
	public static final int PUERTO = 4545;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket server = null;
		Socket cliente = null;
		String texto;
		HiloCliente hiloCliente;
		
		// Para leer / escribir
		DataInputStream canalEntrada = null;
		DataOutputStream canalSalida = null;
		
		try {
			// Crear el socket para atender a los clientes:			
			server = new ServerSocket(PUERTO);
			System.out.println("Servidor ok!");
			
			while (true) {
				// Aceptar clientes:
				System.out.println("Esperando clientes ...");
				cliente = server.accept();
				
				System.out.println("cliente conectado: "+cliente.getLocalAddress()+
						" puerto:" + cliente.getPort());
				
				// Arrancamos un hilo por cada cliente que se conecta:
				// Y le pasamos el socket:
				hiloCliente = new HiloCliente(cliente);
				hiloCliente.start();
			}
			
			
			
			
			// Habilitar canales de E/S:
			canalEntrada = new DataInputStream(cliente.getInputStream());
			canalSalida = new DataOutputStream(cliente.getOutputStream());
			
			do {
				// Esperar el mensaje del cliente:
				texto = canalEntrada.readUTF();
				
				System.out.println("CLIENTE: "+texto);
				
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
