package es.curso.principios_solid.pac_ok;

public class FacturaPersistenciaBD implements IFacturaPersistencia {

	@Override
	public void guardar(Factura factura) {
		// TODO Auto-generated method stub
		System.out.println("En BD:"+factura.toString());
	}

}
