package es.curso.abstractas.figuras;

import es.curso.abstractas.basico.Punto2D;

public class Circulo extends Figura2D {
	
	private int radio;
		

	public Circulo() {
		this("Circulo", 0, new Punto2D(0,0), 0);
	}
		

	public Circulo(String texto, int color, Punto2D centro, int radio) {
		super(texto, color, centro);
		this.radio = radio;
	}



	/**
	 * @return the radio
	 */
	public int getRadio() {
		return radio;
	}


	/**
	 * @param radio the radio to set
	 */
	public void setRadio(int radio) {
		this.radio = radio;
	}

		
	@Override
	public String toString() {
		return super.toString() + ", radio=" + radio;
	}


	@Override
	public double calcularArea() {
		// TODO Auto-generated method stub
		return Math.PI * Math.pow(radio, 2.0);
	}
		

}
