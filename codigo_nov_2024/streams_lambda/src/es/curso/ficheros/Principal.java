package es.curso.ficheros;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Supplier;

import es.curso.ficheros.beans.Pedido;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		pruebasFunciones("ficheros/pedidos.csv");
		//otrasPruebas();
		//pruebaSupplier();
		
	}

	private static void pruebaSupplier() {
		// TODO Auto-generated method stub
		
		// DEfinir un proveedor que nos da la fecha y la hora actual con un formato establecido:
		Supplier<String> ahora = new Supplier<String>() {
			
			@Override
			public String get() {
				// TODO Auto-generated method stub
				Date fecha = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
				return sdf.format(fecha);
			}
		};
		
		for (int i = 0 ; i < 10 ; i++) {
			System.out.println(ahora.get());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}						
	}

	private static void otrasPruebas() {
		// TODO Auto-generated method stub
				
		
		// Definir un mapa que tenga como clave un String y valor una ByFunction
		Map<String, BiFunction<Integer, Integer, Integer>> funciones = new HashMap<String, BiFunction<Integer,Integer,Integer>>();
		
		funciones.put("suma", (a, b)->a+b);
		funciones.put("resta", (a, b)->a-b);
		funciones.put("mul", (a, b)->a*b);
		funciones.put("div", (a, b)->a/b);
		
		int a = 123;
		int b = 56;
		
		// Aplicar una función que está en el mapa:
		System.out.println(funciones.get("mul").apply(a, b));
		
		// Aplicar todas las funciones:
		for (String operacion : funciones.keySet()) {
			System.out.println(operacion + " " + funciones.get(operacion).apply(a, b));
		}
		
		
	}

	private static void pruebasFunciones(String path) {
		// TODO Auto-generated method stub
		GestorPedidos gestorPedidos = new GestorPedidos(path);
		
		//gestorPedidos.imprimirPedidos("Suiza");
		//gestorPedidos.grabarPedidosPais("ficheros/resultados/Suiza.csv", "Suiza");
		// gestorPedidos.filtrarPedidos("Suiza", 100.0);
		
		//List<Pedido> pedidos = gestorPedidos.getPedidosPaisImporte("Suiza", 100.0);
		//System.out.println("Num pedidos: " + pedidos.size());
		
		//List<Integer> ids = gestorPedidos.getIdPedidosPaisImporte("Suiza", 100.0);
		//System.out.println(ids);
		
		gestorPedidos.listadoPaisNumPedidos();
	}

}