package es.curso.principios_solid.liskov;

public class FacturaImpresion {
	
	Factura factura;

	public FacturaImpresion(Factura factura) {
		super();
		this.factura = factura;
	}
	
	public void imprimirFactura() {
		System.out.println(factura.toString());
	}

}
