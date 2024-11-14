package es.curso.operaciones.modelo.dao;

import es.curso.operaciones.modelo.beans.Empleado;

/**
 * Implementación de las operaciones CRUD para un empleado:
 * C --> Create insert into
 * R --> Read select
 * U --> Update (update)
 * D --> Delete (delete)
 */
public interface IEmpleadoDAO {
	
	public void create(Empleado e);
	public Empleado read(int id);
	public void update(Empleado e);
	public void delete(int id);
}
