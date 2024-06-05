package genericos;

public class Principal {

	public static void main(String[] args) {
		ObjectWrapper obj;
		
		obj = new ObjectWrapper("cadena");
		String cad = (String) obj.get();
		
		obj.set(new Integer(100));
		int num = (int) obj.get();

	}

}
