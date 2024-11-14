package es.curso.interfaces;

import java.util.Arrays;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer i1 = 100;
		Integer i2 = 120;
		
		System.out.println(i1.compareTo(i2));
		System.out.println("hola".compareTo("Hola"));
		
		Persona p1 = new Persona("Gema", 34, 1.75, 70.2);
		Persona p2 = new Persona("Pedro", 54, 1.78, 80.2);
		Persona p3 = new Persona("Juan", 14, 1.88, 60.2);
		
		Persona[] personas = {p1, p2, p3};
		System.out.println(Arrays.toString(personas));
		Arrays.sort(personas);
		System.out.println(Arrays.toString(personas));
		
		//int resul = p1.compareTo(p2);
		
		/*
		switch (resul) {
		case 0:
			System.out.println(p1.getNombre()+" misma edad "+p2.getNombre());
			break;
			
		case 1:
			System.out.println(p1.getNombre()+" es mayor que "+p2.getNombre());
			break;
			
		case -1:
			System.out.println(p1.getNombre()+" es mas joven que "+p2.getNombre());
			break;
		} 
		*/
	}

}
