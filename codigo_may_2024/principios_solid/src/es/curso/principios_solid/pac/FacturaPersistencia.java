package es.curso.principios_solid.pac;


/**
 * Queremos añadir una nueva funcionalidad para grabar la factura
 * en una BD. Si el método lo añadimos en esta clase estamos
 * violando el principio de abierto / cerrado.
 * 
 * Deberíamos de refactorizar el código creando una clase para cada
 * soporte distinto.
 * 
 * Diseño MAL!
 */
public class FacturaPersistencia {
	
	Factura factura;

	public FacturaPersistencia(Factura factura) {
		super();
		this.factura = factura;
	}
	
	public void guardarArchivo() {
		System.out.println("En fichero: "+this.factura.toString());
	}
	
	public void guardarEnBaseDatos() {
		System.out.println("En BD: "+this.factura.toString());
	}
}
