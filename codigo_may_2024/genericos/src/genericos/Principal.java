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

	}

}
