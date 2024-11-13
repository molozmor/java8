package es.curso.abstractas.figuras;

import es.curso.abstractas.basico.Punto3D;

public abstract class Figura3D extends Figura {
	
	protected Punto3D centro;
		
	public Figura3D() {
		super();
		this.centro = new Punto3D(0,0,0);
	}
		
	
	public Figura3D(String texto, int color, Punto3D centro) {
		super(texto, color);
		this.centro = centro;
	}


	/**
	 * @return the centro
	 */
	public Punto3D getCentro() {
		return centro;
	}


	/**
	 * @param centro the centro to set
	 */
	public void setCentro(Punto3D centro) {
		this.centro = centro;
	}


	@Override
	public String toString() {
		return super.toString() + ", centro=" + centro;
	}


	public abstract double calcularVolumen();

}
