package es.curso.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDatosSQLite3 {

	private static BaseDatosSQLite3 instance = null;
	private Connection conexion;

	private static final String PATH_BD = "bd/empresa3.db";
	private static final String URL_BD = "jdbc:sqlite:" + PATH_BD;

	public static BaseDatosSQLite3 getInstance() throws SQLException, ClassNotFoundException {
		if (instance == null)
			instance = new BaseDatosSQLite3();

		return instance;
	}

	private BaseDatosSQLite3() throws SQLException, ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		this.conexion = DriverManager.getConnection(URL_BD);
	}

	public void getClientes() throws SQLException {
		String sql = "select nombre from clientes";
		ResultSet rs = null;
		PreparedStatement ps = null;
		String nombre;
		
		try {
			ps = this.conexion.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				nombre = rs.getString("nombre");
				System.out.println(nombre);				
			}
			
		} catch (SQLException e) {
			throw e;

		} finally {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
		}

	}

	public void close() throws SQLException {
		if (this.conexion != null) {
			this.conexion.close();
		}
	}
}
