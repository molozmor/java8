package hilos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Principal {

	public static void main(String[] args) {
		
		//lanzar2Hilos();
		coleccionHilos();

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
		List<Mensajes> hilos;
		Mensajes hilo;
		Random random = new Random();
		
		hilos = new ArrayList<Mensajes>();
		for (int i = 0 ; i < 4 ; i++) {
			hilo = new Mensajes(random.nextInt() % 15, "H-"+(i+1));
			hilo.start();
			hilos.add(hilo);
			//hilo.join(); ojo secualizamos el programa!
		}
		for (Mensajes h : hilos) {
			try {
				h.join();
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
		System.out.println("Hilo actual: "+Thread.currentThread().getName());
		System.out.println("Hilo activos: "+Thread.activeCount());
	}

}
