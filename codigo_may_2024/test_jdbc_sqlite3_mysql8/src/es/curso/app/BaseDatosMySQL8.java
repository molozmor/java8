package es.curso.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDatosMySQL8 {

	private static BaseDatosMySQL8 instance = null;
	private Connection conexion;
	
	public static final String URL_BD = "jdbc:mysql://localhost:3306/empresa3?serverTimezone=UTC";

	public static BaseDatosMySQL8 getInstance() throws SQLException, ClassNotFoundException {
		if (instance == null)
			instance = new BaseDatosMySQL8();

		return instance;
	}

	private BaseDatosMySQL8() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.conexion = DriverManager.getConnection(URL_BD, "root","antonio");
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
