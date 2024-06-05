package genericos;

public class Principal {

	public static void main(String[] args) {
		ObjectWrapper obj;
		
		obj = new ObjectWrapper("cadena");
		String cad = (String) obj.get();
		
		obj.set(new Integer(100));
		int num = (int) obj.get();
		
		// Con el tipo generico:
		Wrapper<String> texto = new Wrapper<String>("hola");
		cad = texto.getInstancia();			
		
		// Ya no lo permite:
		//texto = texto.setInstancia(new Integer(100));
		
		Wrapper<Integer> numero = new Wrapper<Integer>(new Integer(100));
		num = numero.getInstancia();
		
		////////////////////////////////
		
		Matriz<Integer> m1 = new Matriz<Integer>(5, 7, 0);
		m1.print();
		System.out.println();
		m1.set(3, 4, 99);
		m1.print();
		System.out.println();
		
		Matriz<String> m2 = new Matriz<String>(5, 7, "hola");
		m2.print();
		

	}

}
