package es.curso.comunicaciones.consola;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HiloCliente extends Thread {

	private Socket cliente;
	private DataInputStream canalEntrada;
	private DataOutputStream canalSalida;

	public HiloCliente(Socket cliente) throws IOException {
		// TODO Auto-generated constructor stub
		this.cliente = cliente;

		// Habilitar canales de E/S:
		canalEntrada = new DataInputStream(cliente.getInputStream());
		canalSalida = new DataOutputStream(cliente.getOutputStream());
	}

	@Override
	public void run() {
		String texto;

		try {
			do {
				// Esperar el mensaje del cliente:
				texto = canalEntrada.readUTF();
				System.out.println("CLIENTE: " + texto);

				// Enviar respuesta al cliente:
				canalSalida.writeUTF(texto.toUpperCase());

			} while (!texto.equalsIgnoreCase("fin"));

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
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
