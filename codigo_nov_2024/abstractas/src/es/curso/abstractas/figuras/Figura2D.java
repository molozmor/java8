package es.curso.abstractas.figuras;

import es.curso.abstractas.basico.Punto2D;

public abstract class Figura2D extends Figura {
	
	// Atributos:
	protected Punto2D centro;
	

	public Figura2D() {
		super();
		this.centro = new Punto2D(0,0);
	}
	
	
	public Figura2D(String texto, int color, Punto2D centro) {
		super(texto, color);
		this.centro = centro;
	}

	

	/**
	 * @return the centro
	 */
	public Punto2D getCentro() {
		return centro;
	}


	/**
	 * @param centro the centro to set
	 */
	public void setCentro(Punto2D centro) {
		this.centro = centro;
	}


	@Override
	public String toString() {
		return super.toString() + ", centro=" + centro;
	}
	
	@Override
	public void dibujar() {
		// TODO Auto-generated method stub
		System.out.println(this.toString()+ " Area: "+this.calcularArea());
	}



	public abstract double calcularArea();

}
