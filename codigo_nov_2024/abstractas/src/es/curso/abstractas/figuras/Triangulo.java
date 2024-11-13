package es.curso.abstractas.figuras;

import es.curso.abstractas.basico.Punto2D;

public class Triangulo extends Figura2D {

	private int base;
	private int altura;
	
	
    public Triangulo() {
    	this("Triangulo", 0, new Punto2D(0,0), 0, 0);
    }
	
	public Triangulo(String texto, int color, Punto2D centro, int base, int altura) {
		super(texto, color, centro);
		this.base = base;
		this.altura = altura;
	}
	
	

	/**
	 * @return the base
	 */
	public int getBase() {
		return base;
	}

	/**
	 * @param base the base to set
	 */
	public void setBase(int base) {
		this.base = base;
	}

	/**
	 * @return the altura
	 */
	public int getAltura() {
		return altura;
	}

	/**
	 * @param altura the altura to set
	 */
	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	

	@Override
	public String toString() {
		return super.toString() + ", base=" + base + ", altura=" + altura;
	}

	@Override
	public double calcularArea() {
		// TODO Auto-generated method stub
		return (base * altura) / 2.0;
	}


}
