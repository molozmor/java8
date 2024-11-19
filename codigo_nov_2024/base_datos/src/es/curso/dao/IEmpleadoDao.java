package es.curso.dao;

import java.util.List;

/**
 * Definir las operaciones CRUD contra un empleado:
 * 
 * Read -> select (pk)
 * Select --> select 
 */
public interface IEmpleadoDao {
	
	public Empleado read(int pk) throws DaoException;
	public List<Empleado> select(String cargo) throws DaoException;
	

}
