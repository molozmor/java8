package es.curso.hilos;

public class Principal {
	
	public static final int TAM_BUFFER = 6;
	public static final int NUM_MUESTRAS = 15;

	public static void main(String[] args) {
		
		// Crear el buffer, el productor y consumidor
		// Se ponen en marcha
		
		Buffer buf = new Buffer(TAM_BUFFER);
		
		Consumidor con = new Consumidor(NUM_MUESTRAS, buf);
		Productor pro = new Productor(NUM_MUESTRAS, buf);
		
		con.start();
		pro.start();
	}

}
