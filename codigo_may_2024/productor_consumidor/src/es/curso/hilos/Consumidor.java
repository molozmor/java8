package es.curso.hilos;

public class Consumidor extends Thread {
	
	private int numMuestras;
	private Buffer buf;

	public Consumidor(int numMuestras, Buffer buf) {
		super("Consumidor");
		this.numMuestras = numMuestras;
		this.buf = buf;
	}

	@Override
	public void run() {
		char letra;
		
		for (int i = 0 ; i < numMuestras ; i++) {
			letra = buf.recoger();
			
			System.out.println(getName()+ " CONSUME: "+letra);
			
			try {
				Thread.sleep((int)(Math.random()*100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		
}
