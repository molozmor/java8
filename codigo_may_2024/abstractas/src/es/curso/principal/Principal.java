package es.curso.principal;

import java.util.ArrayList;

import es.curso.figuras.Circulo;
import es.curso.figuras.Escena;
import es.curso.figuras.Figura;
import es.curso.figuras.Triangulo;

public class Principal {

	public static void main(String[] args) {
		//pruebaFigura();
		//pruebaArrayList();
		pruebaEscena();
	}

	private static void pruebaEscena() {
		// TODO Auto-generated method stub
		
		Escena escena = new Escena();
		
		Figura circulo = new Circulo("red", "circulo1", 5);				
		Figura triangulo = new Triangulo("blue", "T1", 10.5, 5.0);
		Figura circulo2 = new Circulo("green", "circulo2", 15);
		Figura circulo3 = new Circulo("blue", "circulo3", 4);
		
		escena.addFigura(circulo, triangulo, circulo2);
		escena.addFigura(circulo3);
		escena.print();
		
		if (escena.borrar("circulo1")) {
			System.out.println("figura borrada");
			
		} else {
			System.out.println("No existe la figura");
			
		}
		
		escena.print();
	}

	private static void pruebaArrayList() {
		// TODO Auto-generated method stub
		
		ArrayList<String> nombres;
		
		nombres = new ArrayList<String>();
		nombres.add("Ana");
		nombres.add("Tomás");
		nombres.add("Gema");
		nombres.add(0, "Raúl");
		
		System.out.println(nombres);
		System.out.println("Tenemos: "+nombres.size()+" nombres");
		
		// Recuperar un nombre con la posición (índice):
		System.out.println("El primero es: " + nombres.get(0));
		
		System.out.println("\nBucle for 1:");
		for (int i = 0 ; i < nombres.size() ; i++) {
			System.out.println(nombres.get(i));
		}
		
		System.out.println("\nBucle for 2: ");
		for (String nombre : nombres) {
			System.out.println(nombre);
		}
		
		String nombre = "Raúl";
		if (nombres.contains(nombre)) {
			System.out.println(nombre + " si está");
		} else {
			System.out.println(nombre + " no está");
		}
		
		// Borrar por posición:
		nombres.remove(0);
		
		// Borrar por el valor:
		nombres.remove("Gema");
		
		System.out.println(nombres);
		
	}

	private static void pruebaFigura() {
		// TODO Auto-generated method stub
		Figura figura;
		Figura[] figuras;
		
		// Instanciar la clase Figura: NO
		//figura = new Figura();
		
		figuras = new Figura[10]; // En cada casilla del array irá un: Triangulo o un cubo o ....
		
		Figura c = new Circulo("red", "circulo1", 5);
		c.dibujar();
		
		Figura t = new Triangulo("blue", "T1", 10.5, 5.0);
		t.dibujar();
	}

}
