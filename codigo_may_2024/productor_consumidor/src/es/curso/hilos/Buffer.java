package es.curso.hilos;

import java.util.Arrays;

public class Buffer {
	
	private char buffer[];
	private int siguiente; 
	
	private boolean estaLleno;
	private boolean estaVacio;
	
	public Buffer(int n) {
		buffer = new char[n];
		Arrays.fill(buffer, '_');
		
		siguiente = 0; // La primera casilla libre
		
		// Al inicio el buffer está vacío:
		estaLleno = false;
		estaVacio = true;
	}

	/**
	 * Utilizar el consumidor para recoger una letra
	 * @return
	 */
	public synchronized char recoger() {
		char letra;
		
		//  Si el buffer está vacío tiene que esperar:
		while (estaVacio == true) {
			try {
				// Esperar
				wait();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		//Decrementar el indice para recuperar la letra:
		siguiente--;
		
		if (siguiente == 0)
			// Ha vacíado el buffer:
			estaVacio = true;
		
		// El buffer no puede estar lleno:
		estaLleno = false;
		notify(); // Avisar que hemos consumido!
		
		// Recuperar la letra del buffer y marcar la casilla como
		// vacía:
		letra = buffer[siguiente];
		buffer[siguiente] = '_';
				
		System.out.println(Arrays.toString(buffer));
		
		return letra;
	}
	
	/**
	 * Utilizado por el productor para colocar una letra 
	 * en el buffer.
	 * @param c
	 */
	public synchronized void lanzar(char c) {
		
	}
}
