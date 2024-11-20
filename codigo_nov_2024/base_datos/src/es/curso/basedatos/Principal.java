package es.curso.basedatos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import es.curso.beans.Empleado;
import es.curso.dao.DaoException;
import es.curso.dao.EmpleadoDao;
import es.curso.dao.IEmpleadoDao;

public class Principal {

	private static final String URL_BD = "jdbc:mysql://localhost:3306/empresa3?serverTimezone=UTC";

	private static final String PATH_BD = "bd/empresa3.db";
	private static final String URL_BD_SQLITE3 = "jdbc:sqlite:" + PATH_BD;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ejecutarQuery();
		// pruebasEmpleadoDao();
		// borrarPedido(10249);
		ejecutarFuncion(10248);
	}

	private static void ejecutarFuncion(int numPedido) {
		// TODO Auto-generated method stub
		Connection conexion = null;
		String sql;
		CallableStatement cs = null;	
		double importe;

		try {
			conexion = DriverManager.getConnection(URL_BD, "root", "antonio");	
			sql = "{? = call sumarPedido(?)}";
			cs = conexion.prepareCall(sql);
			
			cs.setInt(2, numPedido);
			cs.registerOutParameter(1, java.sql.Types.FLOAT);
			
			cs.executeUpdate();
			importe = cs.getFloat(1);
			
			System.out.println("El importe del pedido: "+importe);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error: " + e.getMessage());
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} finally {

			try {
				
				if (cs != null)
					cs.close();							

				if (conexion != null)
					conexion.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	}

	private static void borrarPedido(int idPedido) {
		// Borrar un pedido que tiene filas dependientes (detalles de pedido).
		// El borrado está en Restrict.

		// Con una transacción borrar los detalles de pedido y luego el pedido. 1 Pedido
		// -> N Detalles de pedido
		Connection conexion = null;
		String sql, sql2;
		PreparedStatement ps = null, ps2 = null;
		int resul = 0;

		try {
			conexion = DriverManager.getConnection(URL_BD, "root", "antonio");			
			System.out.println("AUTOCOMMIT: " + conexion.getAutoCommit());
			
			// Desactivar autocommit:
			conexion.setAutoCommit(false);
			
			// Lanzar las setencias de SQL
			sql = "delete from detallespedido where idpedido = ?";
			ps = conexion.prepareStatement(sql);
			ps.setInt(1, idPedido);			
			resul += ps.executeUpdate();
			
			sql2 = "delete from pedidos where idpedido = ?";
			ps2 = conexion.prepareStatement(sql2);
			ps2.setInt(1, idPedido);			
			resul += ps2.executeUpdate();			
						
			// Confirmar cambios:
			conexion.commit();
			
			System.out.println("Número de registros borrados: "+resul);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error: " + e.getMessage());
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} finally {

			try {
				
				if (ps != null)
					ps.close();
				
				if (ps2 != null)
					ps2.close();

				if (conexion != null)
					conexion.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	private static void pruebasEmpleadoDao() {
		// TODO Auto-generated method stub
		IEmpleadoDao dao = null;
		List<Empleado> empleados;

		try {
			dao = new EmpleadoDao("src/es/curso/dao/sqlite3.properties");
			System.out.println("ok");

			Empleado emp = dao.read(1);
			System.out.println(emp);

			emp.setNombre("Roberto Sanz");
			emp.setCargo("Director");

			if (dao.update(emp)) {
				System.out.println("Empleado actualizado");
			} else {
				System.out.println("No se ha podido actualizar ...");
			}

			// emp = dao.read(34);
			empleados = dao.select(null);
			for (Empleado e : empleados)
				System.out.println(e);

			// Borrar un empleado:
			if (dao.delete(100)) {
				System.out.println("Empleado borrado ...");

			} else {
				System.out.println("No se ha podido borrar");
			}

			// Crear empleado:
			Empleado nuevo = new Empleado(100, "Jose Sanz", "Gerente de Ventas");
			if (dao.create(nuevo)) {
				System.out.println("Empleado: " + nuevo);

			} else {
				System.out.println("No se ha podido grabar ...");
			}

		} catch (DaoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());

		} finally {
			if (dao != null) {
				try {
					((EmpleadoDao) dao).close();
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
			// conexion = DriverManager.getConnection(URL_BD, "root", "antonio");
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
								System.out.print(rstmt.getColumnLabel(i) + "\t");
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
