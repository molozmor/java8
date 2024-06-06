package es.curso.comunicaciones.consola;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import es.curso.dao.beans.Empleado;
import es.curso.dao.dao.IOperaciones;
import es.curso.dao.dao.PedidoBD;
import es.curso.dao.dao.PedidoException;

public class ServidorBD {
	
	public static final int PUERTO = 4545;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket server = null;
		Socket cliente = null;
		String texto;
		PedidoBD dao = null;
		Empleado empleado;
		
		// Para leer / escribir
		ObjectInputStream canalEntrada = null;
		ObjectOutputStream canalSalida = null;
		
		try {
			// Crear el dao:
			dao = new PedidoBD("bd/empresa3.db");
			
			// Crear el socket para atender a los clientes:			
			server = new ServerSocket(PUERTO);
			System.out.println("Servidor ok!");
			
			// Aceptar clientes:
			System.out.println("Esperando clientes ...");
			cliente = server.accept();			
			System.out.println("cliente conectado: "+cliente.getLocalAddress());
			
			// Habilitar canales de E/S:
			canalEntrada = new ObjectInputStream(cliente.getInputStream());
			canalSalida = new ObjectOutputStream(cliente.getOutputStream());
			
			do {
				// Esperar el empleado del cliente:
				empleado = (Empleado) canalEntrada.readObject();
				
				System.out.println("Empleado del cliente: "+empleado);
				
				// Grabar en la BD:
				if (dao.createEmpleado(empleado)) {
					System.out.println("Empleado creado, id: "+empleado.getId());
				}
				
				// Enviar respuesta al cliente:
				canalSalida.writeObject(empleado);
				
			} while (true);
			
		} catch (Exception e) {
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
