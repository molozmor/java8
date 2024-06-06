package es.curso.comunicaciones.consola;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ClienteFile {
	
	public static final String HOST = "127.0.0.1";
	public static final int PUERTO = 4545;

	public static void main(String[] args) {
		Socket cliente = null;
		
		// Para leer / escribir
		DataInputStream canalEntrada = null;
		DataOutputStream canalSalida = null;
			
		String texto, respuesta;
			
		try {
			// Crear el socket:
			cliente = new Socket(HOST, PUERTO);
			System.out.println("cliente conectado ...");
			
			// Inicializar canales de E/S con el socket.
			canalEntrada = new DataInputStream(cliente.getInputStream());
			canalSalida = new DataOutputStream(cliente.getOutputStream());
			
			// Esperar envio del servidor:
			respuesta = canalEntrada.readUTF();
			//System.out.println("SERVER: "+respuesta);
			
			grabarFichero(respuesta);
				
			// Enviar al servidor:
			canalSalida.writeUTF("bytes recibidos: "+respuesta.length());
				
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			
		} finally {
			
				try {
					if (canalEntrada != null) canalEntrada.close();
					if (canalSalida != null) canalSalida.close();
					if (cliente!= null) cliente.close();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
		}
		
	}

	private static void grabarFichero(String contenido) throws IOException {
		Date ahora = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		String path;
		FileOutputStream fichero;
		
		path = "ficheros/"+sdf.format(ahora)+".txt";
		fichero = new FileOutputStream(path);
		fichero.write(contenido.getBytes());
		fichero.close();
		System.out.println("Fichero descargado: "+path);
	}

}
