package es.curso.operaciones.aplicacion;

import es.curso.operaciones.modelo.beans.Empleado;
import es.curso.operaciones.modelo.dao.EmpleadoBD;
import es.curso.operaciones.modelo.dao.EmpleadoFile;
import es.curso.operaciones.modelo.dao.IEmpleadoDAO;

public class AplicacionConsola {
	
	private IEmpleadoDAO dao;
	
	public static final int BD = 0;
	public static final int FILE = 1;
	
	public AplicacionConsola() {
		this(BD);
	}

	public AplicacionConsola(int tipo) {
		// TODO Auto-generated constructor stub
		
		switch (tipo) {
		case BD:
			dao = new EmpleadoBD();
			break;

		case FILE:
			dao = new EmpleadoFile();
			break;
						
		default:
			dao = new EmpleadoBD();
			break;
		}
	}
	
	public void run() {
		Empleado emp = new Empleado(1, "nombre", "cargo");
		Empleado emp2;

		dao.create(emp);
		dao.delete(1);
		dao.update(emp);
		emp2 = dao.read(1);
		System.out.println("read: " + emp2);
	}

	public static void main(String[] args) {
		AplicacionConsola app;

		app = new AplicacionConsola(FILE);
		app.run();
		
		// Clase anónima:Una interface no se puede instanciar a no ser que hagamos una clase anónima!
		IEmpleadoDAO dao2 = new IEmpleadoDAO() {
			
			@Override
			public void update(Empleado e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Empleado read(int id) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void delete(int id) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void create(Empleado e) {
				// TODO Auto-generated method stub
				System.out.println("Empleado anonimo");
			}
		};
		
		dao2.create(null);
	}

}
