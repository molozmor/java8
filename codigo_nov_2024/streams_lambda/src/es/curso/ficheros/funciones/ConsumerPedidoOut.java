package es.curso.ficheros.funciones;

import java.io.IOException;
import java.io.OutputStream;
import java.util.function.Consumer;

import es.curso.ficheros.beans.Pedido;

public class ConsumerPedidoOut implements Consumer<Pedido> {
	
	private OutputStream salida;
		
	public ConsumerPedidoOut(OutputStream salida) {
		super();
		this.salida = salida;
	}


	@Override
	public void accept(Pedido p) {
		// TODO Auto-generated method stub
		try {
			salida.write(p.toCSV(";").getBytes());
			salida.write("\n".getBytes());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
