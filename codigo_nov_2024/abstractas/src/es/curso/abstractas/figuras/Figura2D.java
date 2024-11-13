package es.curso.abstractas.figuras;

import es.curso.abstractas.basico.Punto2D;

public abstract class Figura2D extends Figura {
	
	// Atributos:
	protected Punto2D centro;
	
	// ¿Constructores?

	public abstract double calcularArea(); 
}
