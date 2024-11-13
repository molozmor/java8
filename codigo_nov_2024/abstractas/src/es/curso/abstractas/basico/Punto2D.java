package es.curso.abstractas.basico;

import java.util.Objects;

public class Punto2D {

	protected double x;
	protected double y;

	public Punto2D() {

		x = 0;
		y = 0;
	}

	public Punto2D(double x1, double y1) {

		x = x1;
		y = y1;
	}

	public Punto2D(Punto2D otroPunto) {

		x = otroPunto.getX();
		y = otroPunto.getY();

	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(double x1) {
		x = x1;
	}

	public void setY(double y1) {
		y = y1;
	}

	public void desplazar(double escalar) {

		x *= escalar;
		y *= escalar;
	}
	
	public void desplazar(Punto2D p) {
		this.x += p.x;
		this.y += p.y;
	}

	

	public Punto2D sumar(Punto2D p) {
		// crea un nuevo punto que representa la suma.
		double x2, y2;

		x2 = x + p.getX();
		y2 = y + p.getY();

		return (new Punto2D(x2, y2));

	}

	public Punto2D restar(Punto2D p) {
		// crea un nuevo punto que representa la resta.
		double x2, y2;

		x2 = x - p.getX();
		y2 = y - p.getY();

		return (new Punto2D(x2, y2));

	}

	public double distancia(Punto2D p) {
		// Calcula la distnacia de un punto a otro.

		double d;

		d = Math.sqrt((Math.pow(x, 2) - Math.pow(p.getX(), 2)) + (Math.pow(y, 2) - Math.pow(p.getY(), 2)));
		return (d);
	}

	public String toString() {
		return ("(" + x + ", " + y + ")");
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto2D other = (Punto2D) obj;
		return Double.doubleToLongBits(x) == Double.doubleToLongBits(other.x)
				&& Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y);
	}

}