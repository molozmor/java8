package hilos;

public class Principal {

	public static void main(String[] args) {
		
		lanzar2Hilos();
		//coleccionHilos();

	}

	private static void lanzar2Hilos() {
		Mensajes h1, h2;
		
		
		try {
			h1 = new Mensajes(10, "H1");
			h2 = new Mensajes(8, "H2");
			
			h1.start();				
			h2.start();
			
			h1.join();
			h2.join();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("main termina");
	}

	private static void coleccionHilos() {
		// TODO Auto-generated method stub
		
	}

}
