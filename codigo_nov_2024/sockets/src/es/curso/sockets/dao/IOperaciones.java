package es.curso.sockets.dao;

import java.util.List;

import es.curso.sockets.beans.Pedido;



public interface IOperaciones {
	
	public boolean create(Pedido pedido) throws PedidoException;
	public Pedido read(int pk) throws PedidoException;
	public List<Pedido> select() throws PedidoException;
	public boolean update(Pedido pedido) throws PedidoException;
	public boolean delete(int pk) throws PedidoException;
	public void close() throws PedidoException;
}
