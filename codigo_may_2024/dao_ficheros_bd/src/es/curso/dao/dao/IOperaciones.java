package es.curso.dao.dao;

import java.util.List;

import es.curso.dao.beans.Pedido;

public interface IOperaciones {
	
	public Pedido read(int pk) throws PedidoException;
	public List<Pedido> select() throws PedidoException;

}
