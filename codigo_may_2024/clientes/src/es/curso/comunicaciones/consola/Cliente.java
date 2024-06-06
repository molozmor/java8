package es.curso.comunicaciones.consola;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {
	
	public static final String HOST = "127.0.0.1";
	public static final int PUERTO = 4545;

	public static void main(String[] args) {
		Socket cliente;
		
		// Para leer / escri
		DataInputStream canalEntrada;
		DataOutputStream canalSalida;
			
		
		try {
			// Crear el socket:
			cliente = new Socket(HOST, PUERTO);
			
			// Inicializar canales de E/S con el socket.
			canalEntrada = new DataInputStream(cliente.getInputStream());
			canalSalida = new DataOutputStream(cliente.getOutputStream());
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
