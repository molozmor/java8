package es.curso.dao.lambda;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.function.Consumer;

import es.curso.dao.beans.Pedido;

public class ConsumerPedidoFile implements Consumer<Pedido> {
	
	private FileOutputStream fichero;

	public ConsumerPedidoFile(FileOutputStream fich) {
		// TODO Auto-generated constructor stub
		this.fichero = fich;
	}

	@Override
	public void accept(Pedido pedido) {
		String csv = pedido.toCSV(";")+"\n";
		try {
			fichero.write(csv.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
