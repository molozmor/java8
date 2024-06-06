package es.curso.servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;



public class Servidor {

	public static void main(String[] args) {
		ServerSocket server = null;
		Socket cliente = null;
		
		ObjectOutputStream objSalida;
		ObjectInputStream objEntrada;
		Empleado e,e2;
		String cadena = null;
		
		try {
			// Crear un socket TCP
			server = new ServerSocket(7887);
			System.out.println("host:"+server.getInetAddress().getHostAddress());
			
			System.out.println("Esperando cliente: ");
			cliente = server.accept();
			System.out.println("cliente aceptado:" + 
			cliente.getInetAddress().getHostAddress()+" "+
			cliente.getLocalPort());
			
			objSalida = new ObjectOutputStream(cliente.getOutputStream());
			objEntrada = new ObjectInputStream(cliente.getInputStream());
			
			System.out.println("canales abiertos server ...");
			
			while (true){
				
				e2 = (Empleado) objEntrada.readObject();
				
				e2.setNombre(e2.getNombre().toUpperCase());
				e2.setNombre(e2.getCodigo().toUpperCase());
				
				objSalida.writeObject(e2);
				
				System.out.println("Datos leidos cliente: " + e2.toString());
				
				if (e2.getNombre().equalsIgnoreCase("fin"))
					break;
			}
			
		} catch (IOException | ClassNotFoundException ex) {
			System.out.println("SERVER ERROR: " + ex.getMessage());
		} finally {
			
				try {
					
					if (server != null) server.close();
					
				} catch (IOException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
		}
	}

}
