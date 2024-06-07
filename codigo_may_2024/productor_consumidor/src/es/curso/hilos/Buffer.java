package es.curso.hilos;

public class Buffer {
	
	private char buffer[];
	private int siguiente; 
	
	private boolean estaLleno;
	private boolean estaVacio;
	
	public Buffer(int n) {
		buffer = new char[n];
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
		return 0;
	}
	
	/**
	 * Utilizado por el productor para colocar una letra 
	 * en el buffer.
	 * @param c
	 */
	public synchronized void lanzar(char c) {
		
	}
}
