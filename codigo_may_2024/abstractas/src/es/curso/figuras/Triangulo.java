package es.curso.figuras;

public class Triangulo extends Figura {
	
	private double base;
	private double altura;
	
	

	public Triangulo(double base, double altura) {
		super();
		this.base = base;
		this.altura = altura;
	}



	public Triangulo(String color, String etiqueta, double base, double altura) {
		super(color, etiqueta);
		this.base = base;
		this.altura = altura;
	}



	public double getBase() {
		return base;
	}



	public void setBase(double base) {
		this.base = base;
	}



	public double getAltura() {
		return altura;
	}



	public void setAltura(double altura) {
		this.altura = altura;
	}



	@Override
	public String toString() {
		return super.toString() +  ", base=" + base + ", altura=" + altura;
	}



	@Override
	public void dibujar() {
		System.out.println("TRIANGULO");
		System.out.println(toString());
	}

}
