package es.curso.figuras;

public abstract class Figura {
	
	// Atributos comunes a todas las figuras:
	private String color;
	private String etiqueta;
	
	
	public Figura() {
		this("black", "figura");
	}


	public Figura(String color, String etiqueta) {
		super();
		this.color = color;
		this.etiqueta = etiqueta;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getEtiqueta() {
		return etiqueta;
	}


	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}
	
	public abstract void dibujar();


	@Override
	public String toString() {
		return "color=" + color + ", etiqueta=" + etiqueta;
	}	

}
