package colecciones;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		pruebasListas();
	}

	private static void pruebasListas() {
		// List<int> numeros; // No podemos utilizar tipos primitivos
		List<Integer> numeros;
		Random rd;
		Date d = new Date();
		
		rd = new Random(d.getTime());

		// Elegimos una implementación
		numeros = new ArrayList<>();
		
		for (int i = 0 ; i < 50 ; i++) {
			numeros.add(rd.nextInt(100));
		}
		
		System.out.println(numeros);

	}

}
