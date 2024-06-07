package es.curso.principios_solid.pac;

public class Libro {
	
	// Acceso package --> las clases que estén en el mismo paquete pueden acceder a los att.
	String titulo;
	double precio;
	String autor;
	
	public Libro(String titulo, double precio, String autor) {
		super();
		this.titulo = titulo;
		this.precio = precio;
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", precio=" + precio + ", autor=" + autor + "]";
	}
}
