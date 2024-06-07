package es.curso.dao.lambda;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import es.curso.dao.beans.Pedido;
import es.curso.dao.dao.PedidoBD;
import es.curso.dao.dao.PedidoException;

public class Principal {

	public static void main(String[] args) {
		
		// Pruebas con funciones lambda:
		//pruebasConsumer();
		
		//pruebasBiConsumer();
		
		//pruebasSupplier();
		
		//pruebaPredicate();
		
		//pruebaFunction();
		
		mapasConFunciones();

	}

	private static void mapasConFunciones() {
		
		Map<String, BiFunction<Integer, Integer, Integer>> funciones;
		
		funciones = new HashMap<String, BiFunction<Integer,Integer,Integer>>();
		funciones.put("Suma", (n1, n2)->n1+n2);
		funciones.put("Resta", (n1, n2)->n1-n2);
		funciones.put("Mul", (n1, n2)->n1*n2);
		funciones.put("Div", (n1, n2)->n1/n2);
		
		int n2 = 12;
		int n1 = 34;
		
		System.out.println(funciones.get("Mul").apply(n1, n2));
		for (String op : funciones.keySet()) {
			System.out.println(op + " " + funciones.get(op).apply(n1, n2));
		}
		
	}

	private static void pruebaFunction() {
		// Crear una función que devuelva el importe de cada pedido y
		// dejar los importes en una colección o sumarlos.
		Function<Pedido, Double> calcularImporte = new Function<Pedido, Double>() {

			@Override
			public Double apply(Pedido pedido) {
				// TODO Auto-generated method stub
				return pedido.getImporte();
			}
			
		};
		
		List<Pedido> pedidos = getPedidos();
		
		List<Double> precios = pedidos.stream().map(calcularImporte).
				collect(Collectors.toList());
		
		System.out.println("precios: "+precios);
	}

	private static void pruebaPredicate() {
		// Sirve para crear filtros sobre streams de colecciones:
		Predicate<Pedido> filtro = p -> p.getImporte() > 100.0;
		
		Predicate<Pedido> filtro2 = new PredicatePais("Suiza");
		
		List<Pedido> pedidos = getPedidos();
		
		// Filtrar pedidos de un determinado país y un importe y contarlos:
		long numPedidosPais = pedidos.stream().filter(filtro2).count();
		System.out.println("pedidos: Suiza -> " + numPedidosPais);
		
		numPedidosPais = pedidos.stream().filter(filtro2).filter(filtro).count();
		System.out.println("pedidos: Suiza con importe > 100 -> " + numPedidosPais);
		
		// Filtrar y recuperar los pedidos de Suiza:
		List<Pedido> pedidos2 = pedidos.stream().filter(filtro2).collect(Collectors.toList());
		pedidos2.forEach(new ConsumerPedido());
		
		// Filtrar y contar los pedidos con un importe superior a 100
		// con un Predicado
		double importe = 100.0;
		numPedidosPais = pedidos.stream().filter(p -> p.getImporte() > importe).count();
		System.out.println("pedidos: Suiza con importe > 100 -> " + numPedidosPais);
	}

	private static void pruebasSupplier() {
		// Pruebas con proveedores:
		
		Supplier<String> ahora = new Supplier<String>() {
			
			@Override
			public String get() {
				Date d = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
				return sdf.format(d);
			}
		};
		
		System.out.println("Ahora: "+ahora.get());
		try {
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Ahora: "+ahora.get());
	}

	private static void pruebasBiConsumer() {
		// TODO Auto-generated method stub
		
		Map<String, String> paises = new HashMap<String, String>();
		paises.put("España", "Madrid");
		paises.put("Francia", "París");
		paises.put("Alemania", "Berlín");
		
		// Con la expresión lambda: 2 parámetros (k, v)
		paises.forEach((pais, capital)->System.out.println(pais+" => "+capital));
		
		paises.forEach(new BiConsumer<String, String>() {

			@Override
			public void accept(String t, String u) {
				// TODO Auto-generated method stub
				System.out.println(t + " " + u);
			}
		});
		
	}
	
	private static List<Pedido> getPedidos(){
		PedidoBD bd;
		List<Pedido> pedidos = null;
		
		try {
			bd = new PedidoBD("bd/empresa3.db");
			pedidos = bd.select();
			
			
		} catch (PedidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return pedidos;
	}

	private static void pruebasConsumer() {		
		List<Pedido> pedidos;
		FileOutputStream fich = null;
		
		try {
			fich = new FileOutputStream("ficheros/pedidos.csv");			
			pedidos = getPedidos();
			
			// Imprimir los pedidos:
			pedidos.forEach(pedido -> System.out.println(pedido));
						
			pedidos.forEach(new ConsumerPedido());
			
			pedidos.forEach(new ConsumerPedidoFile(fich));					
			
			pedidos.forEach(new ConsumerPedidoFile(System.out));
			
			pedidos.forEach(new Consumer<Pedido>() {

				@Override
				public void accept(Pedido pedido) {
					// TODO Auto-generated method stub
					System.out.println(pedido.getPais());
				}
			});
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			if (fich != null)
				try {
					fich.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}

}
