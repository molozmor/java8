package es.curso.dao.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
		this.pathBD = pathBD;
		this.cadConexion = URL_BD + pathBD;
				
		// Abrir la conexion:
		try {
			Class.forName("org.sqlite.JDBC");
			this.conexion = DriverManager.getConnection(this.cadConexion);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new PedidoException(e.getMessage());
		}				
	}

	@Override
	public List<Pedido> select() throws PedidoException {
		// TODO Auto-generated method stub
		List<Pedido> pedidos;
		PreparedStatement ps;
		ResultSet rs;
		Pedido pedido;
		String sql = "select * from pedidos";
		
		pedidos = new ArrayList<Pedido>();
		try {
			ps = this.conexion.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				pedido = new Pedido();
				
				pedido.setIdPedido(rs.getInt("idpedido"));
				pedido.setIdCliente(rs.getString("idcliente"));
				pedido.setIdEmpleado(rs.getInt("idempleado"));
				pedido.setIdEmpresaEnvio(rs.getInt("idempresaenvio"));
				pedido.setPais(rs.getString("pais"));
				pedido.setImporte(rs.getDouble("importe"));
								
				
				pedidos.add(pedido);
			}
			
		} catch (SQLException e) {
			throw new PedidoException(e.getMessage());
		}
		
		
		return pedidos;
	}

}
