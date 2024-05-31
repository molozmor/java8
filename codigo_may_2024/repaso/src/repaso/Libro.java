package repaso;

import java.util.Objects;

public class Libro implements Comparable<Libro>, IOperaciones {
	
	private String titulo;
	private double precio;
	private String autor;
	
	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Libro(String titulo, double precio, String autor) {
		super();
		this.titulo = titulo;
		this.precio = precio;
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(autor, precio, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
	
		Libro other = (Libro) obj;
		return Objects.equals(autor, other.autor)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio)
				&& Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", precio=" + precio + ", autor=" + autor + "]";
	}

	@Override
	public int compareTo(Libro libro) {
		// TODO Auto-generated method stub
		
		Double precio1 = this.precio;
		Double precio2 = libro.precio;
		
		return precio1.compareTo(precio2);
	}

	@Override
	public void grabarAudio() {
		// TODO Auto-generated method stub
		System.out.println("Generar fichero de audio");
	}

	@Override
	public void convertirAPDF() {
		// TODO Auto-generated method stub
		System.out.println("Generar fichero PDF");
	}
	
	

}
