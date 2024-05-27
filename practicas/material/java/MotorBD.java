package es.curso.analizador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MotorBD {

	private static Connection conexion;
	private static Statement sentenciaSQL;
	private static ResultSet rst;
	
	public static void conectar() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/empresa3";
		String user = "root";
		String password = "antonio";				
		conexion = DriverManager.getConnection(url, user, password);	
	}

	public static void desconectar() throws SQLException {
		// Desconecta la conexion a la BD.
		conexion.close();
	}
	
	public static ResultSet getResultSet(String sql) throws SQLException, ClassNotFoundException {
		// Devuelve el resultset obtenido a partir de la consulta.
		sentenciaSQL = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		rst = sentenciaSQL.executeQuery(sql);
		return rst;
	}
	
	public static int executeSQL(String sql)	throws SQLException {
		// Ejecuta una consulta y devuelve el numero de registros afectados.
		sentenciaSQL = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);		
		int n = sentenciaSQL.executeUpdate(sql);
		return(n);
	}
}