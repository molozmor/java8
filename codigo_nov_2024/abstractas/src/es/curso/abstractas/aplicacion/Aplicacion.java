package es.curso.abstractas.aplicacion;

import es.curso.abstractas.basico.Punto2D;
import es.curso.abstractas.basico.Punto3D;
import es.curso.abstractas.figuras.Figura;

public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Figura fig;
		
		//fig = new Figura(); Error es una clase Abstracta.
		
		desplazarPuntos();
	}

	private static void desplazarPuntos() {
		
		Punto2D[] puntos = {new Punto2D(1,1), new Punto3D(1,1,1), new Punto2D(10,10), new Punto3D(5,5,5)};
		
		for (Punto2D p : puntos) {
			System.out.println(p);
		}
		
		System.out.println();
		
		Punto2D desplazamiento2D = new Punto2D(5, 5);
		Punto3D desplazamiento3D = new Punto3D(5, 5, 5);
		
		/*
		puntos[0].desplazar(desplazamiento2D);
		puntos[0].desplazar(desplazamiento3D);
		
		// Funcionan ok
		puntos[1].desplazar(desplazamiento3D);
		puntos[1].desplazar(desplazamiento2D);*/
		
		
		// Desplazamiento con un Punto3D
		for (Punto2D p : puntos) {
			p.desplazar(desplazamiento3D);
		}
		
		for (Punto2D p : puntos) {
			System.out.println(p);
		}
		System.out.println();
		
		for (Punto2D p : puntos) {
			p.desplazar(desplazamiento2D);
		}
		
		for (Punto2D p : puntos) {
			System.out.println(p);
		}
	}

}
