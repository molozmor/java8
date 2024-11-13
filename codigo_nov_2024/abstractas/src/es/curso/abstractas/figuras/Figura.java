package es.curso.abstractas.figuras;

public abstract class Figura {
	
	protected String texto;
	protected int color;
	
	
	public Figura() {
		this("", 0); 
	}


	public Figura(String texto, int color) {
		// TODO Auto-generated constructor stub
		this.texto = texto;
		this.color = color;		
	}


	/**
	 * @return the texto
	 */
	public String getTexto() {
		return texto;
	}


	/**
	 * @param texto the texto to set
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}


	/**
	 * @return the color
	 */
	public int getColor() {
		return color;
	}


	/**
	 * @param color the color to set
	 */
	public void setColor(int color) {
		this.color = color;
	}
	
	public abstract void dibujar();


	@Override
	public String toString() {
		return "texto=" + texto + ", color=" + color;
	}
}
