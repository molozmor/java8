package es.curso.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;

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
	
	public double sumarPedido(int idPedido) throws SQLException {
		double n = 0;
		String sql;
		CallableStatement call = null;		
		
		try {
			sql = "{?=CALL sumarPedido(?)}";
			call = this.conexion.prepareCall(sql);
			call.setInt(2, idPedido);
			call.registerOutParameter(1, java.sql.Types.FLOAT);
			call.executeUpdate();
			
			// Recuperar el parámetro de salida del procedure:
			n = call.getFloat(1);			
			
		} catch (SQLException e) {
			throw e;
			
		} finally {
			if (call != null) {
				call.close();
			}
		}
		
		return n;
	}
	
	public int contarPedidos(String pais) throws SQLException {
		int n = 0;
		String sql;
		CallableStatement call = null;		
		
		try {
			sql = "{CALL contarPedidos(?, ?)}";
			call = this.conexion.prepareCall(sql);
			call.setString(1, pais);
			call.registerOutParameter(2, java.sql.Types.INTEGER);
			call.executeUpdate();
			
			// Recuperar el parámetro de salida del procedure:
			n = call.getInt(2);			
			
		} catch (SQLException e) {
			throw e;
			
		} finally {
			if (call != null) {
				call.close();
			}
		}
		
		return n;
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
