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
		System.out.println();
	}

	public boolean borrar(String etiqueta) {
		// Buscar en la colección de figura por el nombre de la etiqueta
		int pos = -1;
		
		for (int i = 0 ; i < figuras.size() ; i++) {
			if (figuras.get(i).getEtiqueta().equalsIgnoreCase(etiqueta)) {
				pos = i;
				break;
			}
		}
		
		if (pos != -1) {
			figuras.remove(pos);
			return true;
			
		} else 
			return false;
	}
	

}
