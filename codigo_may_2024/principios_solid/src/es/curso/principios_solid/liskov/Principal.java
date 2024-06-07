package es.curso.principios_solid.liskov;

/**
 * El principio de sustitución de liskov funciona entre jerarquia de clases y con interfaces
 */
public class Principal {
	
	
	public IFacturaPersistencia crearFacturaPersistencia(Persistencia p) {
		switch (p) {
		case FILE:
			return new FacturaPersistenciaFile();
			
		case BASE_DATOS:
			return new FacturaPersistenciaBD();
			
		default:
			return new FacturaPersistenciaBD();
		}
	}
	
	public void utilizarFacturaPersistencia(IFacturaPersistencia fp, Factura f) {
		fp.guardar(f);
	}
	
	
	public static void main(String[] args) {
		Principal prin = new Principal();

		IFacturaPersistencia fp = prin.crearFacturaPersistencia(Persistencia.BASE_DATOS);
		prin.utilizarFacturaPersistencia(fp, new Factura(new Libro(null, 0, null), 0, 0, 0));
	}

}
