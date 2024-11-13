package es.curso.abstractas.aplicacion;

import es.curso.abstractas.basico.Punto2D;
import es.curso.abstractas.basico.Punto3D;
import es.curso.abstractas.figuras.Circulo;
import es.curso.abstractas.figuras.Cubo;
import es.curso.abstractas.figuras.Figura;
import es.curso.abstractas.figuras.Triangulo;

public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Figura fig;
		
		//fig = new Figura(); Error es una clase Abstracta.
		
		//desplazarPuntos();
		pruebaFiguras();
	}

	private static void pruebaFiguras() {
		// TODO Auto-generated method stub
		
		Figura cir = new Circulo("Circulo1", 5, new Punto2D(1,1), 5);
		cir.dibujar();
		
		Figura t = new Triangulo("Triangulo2", 2, new Punto2D(1,1), 10, 5);
		t.dibujar();
		
		Figura cubo = new Cubo("Cubo", 7, new Punto3D(1,2,0), 5);
		cubo.dibujar();
		
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
		System.out.println();
		
		for (Punto2D p : puntos) {
			p.desplazar(100);
		}
		
		for (Punto2D p : puntos) {
			System.out.println(p);
		}
	}

}
