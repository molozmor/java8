package es.curso.figuras;

import java.util.ArrayList;

public class Escena {
	
	private ArrayList<Figura> figuras;

	public Escena() {
		super();
		figuras = new ArrayList<Figura>();
	}
	
	public void addFigura(Figura... f) {
		// El método recibe varias figuras con la declaración ...
		// Se reciben como si fuera un array:
		
		// Cargar todas las figuras del array a la colección
		for (Figura fig : f) {
			figuras.add(fig);
		}		
	}
	
	public void print() {
		for (Figura f : figuras) {
			f.dibujar();
		}
	}

	public boolean borrar(String string) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
