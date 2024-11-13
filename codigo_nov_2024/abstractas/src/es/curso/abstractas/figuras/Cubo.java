package es.curso.abstractas.figuras;

import es.curso.abstractas.basico.Punto3D;

public class Cubo extends Figura3D {
	
	private int lado;
		

	public Cubo() {
		this("Cubo", 0, new Punto3D(0,0,0), 0);
	}
	
	public Cubo(String texto, int color, Punto3D centro, int lado) {
		super(texto, color, centro);
		this.lado = lado;
	}

	

	/**
	 * @return the lado
	 */
	public int getLado() {
		return lado;
	}

	/**
	 * @param lado the lado to set
	 */
	public void setLado(int lado) {
		this.lado = lado;
	}

	@Override
	public double calcularVolumen() {
		// TODO Auto-generated method stub
		return Math.pow(lado, 3.0);
	}
	
	

	@Override
	public String toString() {
		return super.toString() + ", lado=" + lado;
	}


}
