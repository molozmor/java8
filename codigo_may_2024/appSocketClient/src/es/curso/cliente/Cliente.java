package es.curso.cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		Socket socket = null;
		DataInputStream entrada = null;
		DataOutputStream salida = null;
		String cadena, cadena2;
		Scanner scan = new Scanner(System.in);
		ObjectOutputStream objSalida;
		ObjectInputStream objEntrada;
		Empleado e, e2;

		try {
			// Crear el socket, en este caso TCP
			socket = new Socket("localhost", 7887);

			System.out.println("conectado ...");
			// Habilitar canales de E/S con el Servidor
			objEntrada = new ObjectInputStream(socket.getInputStream());
			objSalida = new ObjectOutputStream(socket.getOutputStream());
			
			cadena = "";

			while (!cadena.equalsIgnoreCase("fin")) {
				System.out.println("Teclea mensaje: ");
				cadena = scan.nextLine();
				
				 e = new Empleado(cadena, cadena);

				objSalida.writeObject(e);
				e2 = (Empleado) objEntrada.readObject();
				
				cadena = e2.getNombre();

				System.out.println("Resp. del server: " + e2.toString());
			}

		} catch (IOException | ClassNotFoundException ex) {
			System.out.println("Cliente: ERROR " + ex.getMessage());

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

			} catch (IOException ex) {
				System.out.println("Cliente: ERROR " + ex.getMessage());
			}

		}

	}

}
