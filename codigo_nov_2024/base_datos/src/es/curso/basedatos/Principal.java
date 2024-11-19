package es.curso.basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import es.curso.dao.DaoException;
import es.curso.dao.Empleado;
import es.curso.dao.EmpleadoDao;
import es.curso.dao.IEmpleadoDao;

public class Principal {

	private static final String URL_BD = "jdbc:mysql://localhost:3306/empresa3?serverTimezone=UTC";
	
	private static final String PATH_BD = "bd/empresa3.db";
	private static final String URL_BD_SQLITE3 = "jdbc:sqlite:" + PATH_BD;


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//ejecutarQuery();
		pruebasEmpleadoDao();
	}

	private static void pruebasEmpleadoDao() {
		// TODO Auto-generated method stub
		IEmpleadoDao dao = null;
		List<Empleado> empleados;
		
		try {
			dao = new EmpleadoDao("src/es/curso/dao/mysql.properties");
			System.out.println("ok");
			
			Empleado emp = dao.read(1);
			System.out.println(emp);
			
			//emp = dao.read(34);
			empleados = dao.select("ventas");
			for (Empleado e : empleados)
				System.out.println(e);
			
			
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
		} finally {
			if (dao != null) {
				try {
					((EmpleadoDao)dao).close();
				} catch (DaoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private static void ejecutarQuery() {
		// TODO Auto-generated method stub

		Connection conexion = null;
		Scanner scan;
		String sql = null;
		Statement st = null;
		ResultSet rst = null;
		ResultSetMetaData rstmt;
		int cols;
		boolean flag = true;

		try {
			//conexion = DriverManager.getConnection(URL_BD, "root", "antonio");
			conexion = DriverManager.getConnection(URL_BD_SQLITE3);
			System.out.println("Conexión ok!");
			st = conexion.createStatement();

			scan = new Scanner(System.in);
			do {

				try {
					System.out.print("SQL:> ");
					sql = scan.nextLine();
					flag = true;

					// Ejecutar el SQL;
					rst = st.executeQuery(sql);
					rstmt = rst.getMetaData();
					cols = rstmt.getColumnCount();

					while (rst.next()) {
						
						if (flag) {
							for (int i = 1; i <= cols; i++) {
								System.out.print(rstmt.getColumnLabel(i)+"\t");
							}
							System.out.println();
							flag = false;
						}

						for (int i = 1; i <= cols; i++) {
							System.out.print(rst.getString(i) + "\t");
						}
						System.out.println();
					}
					
				} catch (Exception e) {
					System.out.println("error: " + e.getMessage());
				}

			} while (!sql.equals(""));

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error: " + e.getMessage());

		} finally {

			try {
				if (rst != null)
					rst.close();
				if (st != null)
					st.close();
				if (conexion != null)
					conexion.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
