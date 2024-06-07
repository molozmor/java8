package es.curso.principios_solid.pru;

public class Factura {
	
	Libro libro;
	int cantidad;
	double iva;
	double descuento;
	double total;
	
	public Factura(Libro libro, int cantidad, double iva, double descuento) {
		super();
		this.libro = libro;
		this.cantidad = cantidad;
		this.iva = iva;
		this.descuento = descuento;
		this.total = calcularTotal();
	}
	
	public double calcularTotal() {
		double resul;
		
		resul = libro.precio * cantidad * (1-descuento);
		resul *= (1+iva);
		return resul;
	}
	
		
	@Override
	public String toString() {
		return "Factura [libro=" + libro + ", cantidad=" + cantidad + ", iva=" + iva + ", descuento=" + descuento
				+ ", total=" + total + "]";
	}

	public void imprimirFactura() {
		System.out.println(this.toString());
	}
	
	public void guardarArchivo() {
		System.out.println("En fichero: "+this.toString());
	}

}
