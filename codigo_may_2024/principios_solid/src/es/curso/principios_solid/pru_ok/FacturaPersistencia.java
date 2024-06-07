package es.curso.principios_solid.pru_ok;

public class FacturaPersistencia {
	
	Factura factura;

	public FacturaPersistencia(Factura factura) {
		super();
		this.factura = factura;
	}
	
	public void guardarArchivo() {
		System.out.println("En fichero: "+this.toString());
	}
}
