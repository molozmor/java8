package repaso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Principal {

	public static void main(String[] args) {		
		List<Libro> libros;
		
		libros = new ArrayList<Libro>();
		libros.add(new Libro("Java 8", 45, "Ceballos"));
		libros.add(new Libro("Java 11", 55, "Gomez"));
		libros.add(new Libro("PHP 7", 25, "Garcia"));
		libros.add(new Libro("Python", 48, "Ceballos"));
		
		Collections.sort(libros);
		for (Libro libro : libros) {
			System.out.println(libro);
			libro.convertirAPDF();
		}
		
	}

}
