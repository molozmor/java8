package es.curso.figuras;

public class Circulo extends Figura {
	
	private double radio;
	
	

	public Circulo(double radio) {
		super();
		this.radio = radio;
	}


	public Circulo(String color, String etiqueta, double radio) {
		super(color, etiqueta);
		this.radio = radio;
	}


	
	public double getRadio() {
		return radio;
	}


	public void setRadio(double radio) {
		this.radio = radio;
	}

		

	@Override
	public String toString() {
		return super.toString() + ", radio = " + radio;
	}


	@Override
	public void dibujar() {
		System.out.println("CIRCULO");
		System.out.println(toString());
	}

}
