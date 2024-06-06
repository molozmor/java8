package es.curso.comunicaciones.consola;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * El servidor envia un fichero al cliente
 */
public class ServidorFile {

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

			// Establecer un timeout, para que el cliente pueda leer los datos:
			cliente.setSoLinger(true, 10);

			System.out.println("cliente conectado: " + cliente.getLocalAddress());

			// Habilitar canales de E/S:
			canalEntrada = new DataInputStream(cliente.getInputStream());
			canalSalida = new DataOutputStream(cliente.getOutputStream());

			texto = leerFichero("ficheros/Empleados.txt");

			// Enviar contenido del fichero al cliente:
			canalSalida.writeUTF(texto);

			// Esperar una confirmación del cliente:
			texto = canalEntrada.readUTF();

			System.out.println("CLIENTE: " + texto);

		} catch (IOException e) {
			System.out.println(e.getMessage());

		} finally {

			try {
				if (canalEntrada != null)
					canalEntrada.close();
				if (canalSalida != null)
					canalSalida.close();
				if (cliente != null)
					cliente.close();
				if (server != null)
					server.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static String leerFichero(String path) throws IOException {
		FileInputStream fichero = null;
		int numBytes;
		byte bytes[];
		String datos;

		fichero = new FileInputStream(path);
		numBytes = fichero.available(); // Tamaño en bytes del fichero.
		bytes = new byte[numBytes]; // El array de bytes tiene que estar previamente reservado
		fichero.read(bytes);
		datos = new String(bytes);
		fichero.close();
		return datos;
	}

}
