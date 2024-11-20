package es.curso.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import es.curso.beans.Empleado;

public class EmpleadoDao implements IEmpleadoDao {

	private Connection conexion;

	public EmpleadoDao(String pathProperties) throws DaoException {
		Properties properties;
		FileInputStream fichero = null;

		try {
			fichero = new FileInputStream(pathProperties);
			properties = new Properties();
			properties.load(fichero);

			if (pathProperties.contains("mysql")) {

				// Abrir la conexion con mysql
				this.conexion = DriverManager.getConnection(properties.getProperty("url"), properties);
				
			} else {
				// Abrir la conexión con sqlite3
				this.conexion = DriverManager.getConnection(properties.getProperty("url"));
				
			}

		} catch (Exception e) {
			throw new DaoException(e.getMessage());

		} finally {
			if (fichero != null)
				try {
					fichero.close();
				} catch (IOException e) {
					throw new DaoException(e.getMessage());
				}
		}

	}

	@Override
	public Empleado read(int pk) throws DaoException {
		String sql = "select * from empleados where id=?";
		PreparedStatement ps = null;
		Empleado empleado;
		ResultSet rst = null;

		try {
			// Crear prepared
			ps = this.conexion.prepareStatement(sql);
			ps.setInt(1, pk);
			rst = ps.executeQuery();

			if (rst.next()) {
				empleado = new Empleado();
				empleado.setId(rst.getInt("id"));
				empleado.setNombre(rst.getString("nombre"));
				empleado.setCargo(rst.getString("cargo"));
				return empleado;

			} else {
				throw new DaoException("El empleado con pk: " + pk + " no existe en la BD");
			}

		} catch (Exception e) {
			throw new DaoException(e.getMessage());

		} finally {

			try {
				if (rst != null)
					rst.close();
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new DaoException(e.getMessage());
			}
		}
	}

	@Override
	public List<Empleado> select(String cargo) throws DaoException {
		String sql = "select * from empleados";
		PreparedStatement ps = null;
		Empleado empleado;
		ResultSet rst = null;
		List<Empleado> empleados = new ArrayList<Empleado>();

		try {
			if (cargo != null)
				sql += " where cargo like ?";

			// Crear prepared
			ps = this.conexion.prepareStatement(sql);

			if (cargo != null) {
				ps.setString(1, "%" + cargo + "%");
			}

			rst = ps.executeQuery();

			while (rst.next()) {
				empleado = new Empleado();
				empleado.setId(rst.getInt("id"));
				empleado.setNombre(rst.getString("nombre"));
				empleado.setCargo(rst.getString("cargo"));

				// Añadir el empleado a la colección
				empleados.add(empleado);
			}

			return empleados;

		} catch (Exception e) {
			throw new DaoException(e.getMessage());

		} finally {

			try {
				if (rst != null)
					rst.close();
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new DaoException(e.getMessage());
			}
		}
	}

	public void close() throws DaoException {
		// TODO Auto-generated method stub
		if (conexion != null)
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new DaoException(e.getMessage());
			}
	}

}
