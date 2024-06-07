package es.curso.principios_solid.pac_ok;

public class FacturaPersistenciaFile implements IFacturaPersistencia {

	@Override
	public void guardar(Factura factura) {
		// TODO Auto-generated method stub
		System.out.println("En file:"+factura.toString());
	}

}
