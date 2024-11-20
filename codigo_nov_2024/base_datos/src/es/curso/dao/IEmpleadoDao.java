package es.curso.dao;

import java.util.List;

import es.curso.beans.Empleado;

/**
 * Definir las operaciones CRUD contra un empleado:
 * 
 * Read -> select (pk)
 * Select --> select 
 * Create --> insert into
 * Delete --> delete
 * Update --> update
 */
public interface IEmpleadoDao {
	
	public Empleado read(int pk) throws DaoException;
	public List<Empleado> select(String cargo) throws DaoException;
	public boolean create(Empleado empleado) throws DaoException;
	public boolean delete(int pk) throws DaoException;
	public boolean update(Empleado empleado) throws DaoException;

}
