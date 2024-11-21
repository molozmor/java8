package es.curso.ficheros.funciones;

import java.util.function.Consumer;

import es.curso.ficheros.beans.Pedido;

public class ConsumerPedido implements Consumer<Pedido> {

	@Override
	public void accept(Pedido p) {
		// TODO Auto-generated method stub
		System.out.println(p);
	}

}
