package es.curso.dao.lambda;

import java.util.function.Consumer;

import es.curso.dao.beans.Pedido;

public class ConsumerPedido implements Consumer<Pedido> {

	@Override
	public void accept(Pedido pedido) {
		System.out.println(pedido);		
	}

}
