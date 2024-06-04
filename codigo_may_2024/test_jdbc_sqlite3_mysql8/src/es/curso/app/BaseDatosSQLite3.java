package es.curso.app;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.ResultSetMetaData;

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
	
	public void exportarTabla(String tabla) throws Exception {
		String sql = "select * from " + tabla;
		ResultSet rs = null;
		PreparedStatement ps = null;
		ResultSetMetaData rsdata = null;
		int numCols;
		FileOutputStream fichero = null;
		String path;
		
		try {
			// Crear el fichero:
			path = "ficheros/"+tabla+".csv";
			fichero = new FileOutputStream(path);
			
			// Crear el statement a partir de la conexión:
			ps = this.conexion.prepareStatement(sql);
			
			// Ejecutar la consulta;
			rs = ps.executeQuery();
			
			// Obtener los metadatos de la consulta:
			rsdata = rs.getMetaData();
			
			// Obtener las columnas y los nombres:
			numCols = rsdata.getColumnCount();
			
			// Imprimir las cabeceras:
			String cabeceras = "";
			
			for (int i = 1 ; i <= numCols ; i++) {
				cabeceras += rsdata.getColumnLabel(i);
				
				if (i < numCols)
					cabeceras += ";";
			}
			cabeceras += "\n";
			
			// Grabar las cabeceras al fichero:
			fichero.write(cabeceras.getBytes());
			
			// Recuperar los resultados:		
			
			while (rs.next()) {			
				String fila = "";
				
				for (int i = 1 ; i <= numCols ; i++) {
					fila += rs.getString(i);
					
					if (i < numCols)
						fila += ";";
					
				}
				fila += "\n";
				fichero.write(fila.getBytes());
			}
			
			System.out.println("Se ha generado el fichero: "+path);
			
			
		} catch (SQLException | FileNotFoundException e) {
			throw e;

		} finally {
			if (fichero != null)
				fichero.close();			
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
		}
		
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
