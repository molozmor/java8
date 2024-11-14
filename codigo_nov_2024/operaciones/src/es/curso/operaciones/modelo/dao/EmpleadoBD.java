package es.curso.operaciones.modelo.dao;

import es.curso.operaciones.modelo.beans.Empleado;

public class EmpleadoBD implements IEmpleadoDAO {

	@Override
	public void create(Empleado e) {
		// TODO Auto-generated method stub
		System.out.println("insert en la BD: "+e);
	}

	@Override
	public Empleado read(int id) {
		// TODO Auto-generated method stub
		return new Empleado(1, "EmpleadoBD", "cargo");
	}

	@Override
	public void update(Empleado e) {
		// TODO Auto-generated method stub
		System.out.println("actualizar en la BD: "+e);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		System.out.println("Borrar en la BD: "+id);
	}

}
