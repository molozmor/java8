package es.curso.hilos;

public class Productor extends Thread {
	
	private int numMuestras;
	private Buffer buf;

	public Productor(int numMuestras, Buffer buf) {
		// TODO Auto-generated constructor stub
		super("Productor:");
		this.buf = buf;
		this.numMuestras = numMuestras;
	}
	
	private char generarChar() {
		// En la tabla ascii: A -> 65, B -> 66
		int pos = (int) (Math.random() * 26);
		pos += 65;
		
		return (char)pos;
	}

	@Override
	public void run() {
		char letra;
		
		for (int i = 0 ; i < this.numMuestras ; i++) {
			// Generar un item:
			letra = generarChar();
			System.out.println(getName()+ " GENERA: "+letra);
			
			// Escribir la letra en el buffer:
			buf.lanzar(letra);
			
			try {
				Thread.sleep((int)(Math.random()*100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		

}
