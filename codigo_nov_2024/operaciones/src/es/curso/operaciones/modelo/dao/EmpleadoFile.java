package es.curso.operaciones.modelo.dao;

import es.curso.operaciones.modelo.beans.Empleado;

public class EmpleadoFile implements IEmpleadoDAO {

	@Override
	public void create(Empleado e) {
		// TODO Auto-generated method stub
		System.out.println("Crear el empleado: "+e);
	}

	@Override
	public Empleado read(int id) {
		// TODO Auto-generated method stub
		return new Empleado(1, "EmpleadoFile","cargo");
	}

	@Override
	public void update(Empleado e) {
		// TODO Auto-generated method stub
		System.out.println("Actualizando el empleado: "+e);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		System.out.println("Borrando el empleado: "+id);
	}

	
}
