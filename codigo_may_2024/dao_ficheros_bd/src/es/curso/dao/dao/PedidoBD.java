package es.curso.dao.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;

import es.curso.dao.beans.Pedido;


/**
 * Clase que implementa las operaciones CRUD para un Pedido:
 * Create -> insert into
 * Read -> select pk
 * Update -> update
 * Delete -> delete
 * 
 */
public class PedidoBD implements IOperaciones {
	
	private static final String URL_BD = "jdbc:sqlite:";
	
	private Connection conexion;
	private String pathBD;
	private String cadConexion;
	
	public PedidoBD(String pathBD) throws PedidoException {
		File f;
		this.pathBD = pathBD;
		this.cadConexion = URL_BD + pathBD;
						
		try {
			// Comprobar si existe el fichero de la base de datos:
			f = new File(pathBD);
			if (!f.exists()) {
				throw new FileNotFoundException("No existe el fichero: " + pathBD);
			}
			
			// Abrir la conexion:
			Class.forName("org.sqlite.JDBC");
			this.conexion = DriverManager.getConnection(this.cadConexion);
			
		} catch (ClassNotFoundException | SQLException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new PedidoException(e.getMessage());
		}				
	}

	@Override
	public List<Pedido> select() throws PedidoException {
		// TODO Auto-generated method stub
		List<Pedido> pedidos;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Pedido pedido;
		String sql = "select * from pedidos";
		
		pedidos = new ArrayList<Pedido>();
		try {
			ps = this.conexion.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				pedido = this.cargaPedido(rs);											
				pedidos.add(pedido);
			}
			
		} catch (SQLException e) {
			throw new PedidoException(e.getMessage());
			
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
		return pedidos;
	}

	@Override
	public Pedido read(int pk) throws PedidoException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Pedido pedido;
		String sql = "select * from pedidos where idpedido = ?";
		
		try {
			ps = this.conexion.prepareStatement(sql);
			ps.setInt(0, pk);
			
			if (rs.next()) {
				// Cargar los datos del pedido
				pedido = this.cargaPedido(rs);
				
			} else {
				// Si no existe el pedido, lanzamos una excepción:
				throw new PedidoException("No existe el pedido: "+pk);
			}
			
		} catch (SQLException e) {
			throw new PedidoException(e.getMessage());
			
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
				
		return pedido;
	}

	private Pedido cargaPedido(ResultSet rs) throws SQLException {
		Pedido pedido = new Pedido();
		
		pedido.setIdPedido(rs.getInt("idpedido"));
		pedido.setIdCliente(rs.getString("idcliente"));
		pedido.setIdEmpleado(rs.getInt("idempleado"));
		pedido.setIdEmpresaEnvio(rs.getInt("idempresaenvio"));
		pedido.setPais(rs.getString("pais"));
		pedido.setImporte(rs.getDouble("importe"));
		return pedido;
	}

}
