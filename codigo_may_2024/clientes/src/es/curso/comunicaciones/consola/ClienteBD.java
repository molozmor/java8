package es.curso.comunicaciones.consola;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import es.curso.dao.beans.Empleado;

/**
 * Enviar un empleado al servidor por el socket
 * Espera como respuesta el mismo empleado con el id asignado
 * en la BD.
 */
public class ClienteBD {
	
	public static final String HOST = "127.0.0.1";
	public static final int PUERTO = 4545;

	public static void main(String[] args) {
		Socket cliente = null;
		
		// Para leer / escribir
		ObjectInputStream canalEntrada = null;
		ObjectOutputStream canalSalida = null;
			
		String texto, respuesta;
		Scanner scanner;
		Empleado empleado, empRespuesta;
		
		try {
			// Crear el socket:
			cliente = new Socket(HOST, PUERTO);
			System.out.println("cliente conectado ...");
			System.out.println("Vamos a abrir canales de entrada / salida:");
			
			// Inicializar canales de E/S con el socket.
			canalSalida = new ObjectOutputStream(cliente.getOutputStream());
			canalEntrada = new ObjectInputStream(cliente.getInputStream());
			
			System.out.println("Se han creado los canales ...");
			
			// Crear el scanner para leer de teclado:
			scanner = new Scanner(System.in);
			System.out.println("Scanner creado ...");
			
			do {
				empleado = leerEmpleado(scanner);
				
				// Enviar al servidor:
				canalSalida.writeObject(empleado);
				
				// Esperar la respuesta del servidor:
				empRespuesta = (Empleado) canalEntrada.readObject();
				System.out.println("Empleado resp: "+empRespuesta);
				
				System.out.print("Salir <fin>: ");
				texto = scanner.nextLine();
				
			} while (!texto.equalsIgnoreCase("fin"));
			
			
		} catch (IOException | ClassNotFoundException e) {
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

	private static Empleado leerEmpleado(Scanner scanner) {
		Empleado emp = new Empleado();
		String nombre, cargo;
		
		System.out.println("Datos del nuevo empleado:");
		
		System.out.print("Nombre: ");
		nombre = scanner.nextLine();
		System.out.println("Cargo: ");
		cargo = scanner.nextLine();
		
		emp.setNombre(nombre);
		emp.setCargo(cargo);
		
		return emp;
	}

}
