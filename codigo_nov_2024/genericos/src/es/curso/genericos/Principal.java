package es.curso.genericos;

import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {

		//pruebasIniciales();
		pruebasMatriz();

	}

	private static void pruebasMatriz() {
		// TODO Auto-generated method stub
		int k = 0;

		// Crear una matriz de Integer;
		Matriz<Integer> m1 = new Matriz<Integer>(5, 5, 0);
		m1.print();
		System.out.println();
		
		for (int i = 0 ; i < 5 ; i++) {
			for (int j = 0 ; j < 5 ; j++, k++) {
				
				m1.set(i, j, k);
			}
		}
		
		m1.print();
		System.out.println();
		
		Matriz<Integer> t = m1.traspuesta();
		t.print();
		
		
		Matriz<String> m2 = new Matriz<String>(6, 4, "hola");
		m2.print();
	}

	private static void pruebasIniciales() {
		// TODO Auto-generated method stub

		List lista;

		lista = new ArrayList();
		lista.add(new Direccion("calle 1", 1, 28001, "Madrid"));
		lista.add(new Direccion("calle 2", 2, 28002, "Madrid"));
		lista.add(new Direccion("calle 3", 3, 28003, "Madrid"));

		Direccion d = (Direccion) lista.get(0);

		// Como no especificamos el tipo, se pueden cometer errores que escapan al
		// compilador
		// Cambiar el tipo del atributo y al hacer casting (el tipo no es compatible).
		ObjectWrapper obj = new ObjectWrapper("hola");
		String cad = (String) obj.get();
		System.out.println(cad);

		obj.set(new Integer(100));
		cad = (String) obj.get();
		System.out.println(cad);

		// Al utilizar el tipo genérico tenemos que indicar cual es el tipo del att.
		Wrapper<Integer> obj2 = new Wrapper<Integer>(100);
		int s = obj2.getInstancia();

	}

}
