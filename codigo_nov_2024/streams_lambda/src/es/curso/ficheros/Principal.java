package es.curso.ficheros;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		pruebasFunciones("ficheros/pedidos.csv");
	}

	private static void pruebasFunciones(String path) {
		// TODO Auto-generated method stub
		GestorPedidos gestorPedidos = new GestorPedidos(path);
		
		gestorPedidos.imprimirPedidos("Suiza");
		
	}

}