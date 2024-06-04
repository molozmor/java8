package es.curso.app;

import java.sql.SQLException;

public class Principal {

	public static void main(String[] args) {
		testSQLite3();
		//testMySQL8();
	}

	private static void testMySQL8() {
		// TODO Auto-generated method stub
		BaseDatosMySQL8 bd = null;

		try {
			bd = BaseDatosMySQL8.getInstance();
			System.out.println("\nConexión abierta con MySQL8 ...");
			
			bd.getClientes();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR: " + e.getMessage());

		} finally {
			if (bd != null)
				try {
					bd.close();
				} catch (SQLException e) {
					System.out.println("ERROR: " + e.getMessage());
				}
		}
	}

	private static void testSQLite3() {
		// TODO Auto-generated method stub
		BaseDatosSQLite3 bd = null;

		try {
			bd = BaseDatosSQLite3.getInstance();
			System.out.println("\nConexión abierta con SQLite3 ...");
			
			bd.getClientes();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR: " + e.getMessage());

		} finally {
			if (bd != null)
				try {
					bd.close();
				} catch (SQLException e) {
					System.out.println("ERROR: " + e.getMessage());
				}
		}
	}

}
