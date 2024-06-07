package es.curso.dao.lambda;

import java.util.function.Predicate;

import es.curso.dao.beans.Pedido;

public class PredicatePais implements Predicate<Pedido> {
	
	private String pais;

	public PredicatePais(String pais) {
		this.pais = pais;
	}

	@Override
	public boolean test(Pedido pedido) {
		// TODO Auto-generated method stub
		return pedido.getPais().equalsIgnoreCase(pais);
	}

}
