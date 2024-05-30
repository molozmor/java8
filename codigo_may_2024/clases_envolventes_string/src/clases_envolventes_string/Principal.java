package clases_envolventes_string;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//pruebaDeprecated();
		pruebasConString();
	}

	private static void pruebasConString() {
		// Pruebas con la clase String
		
		// Números a texto:
		int numero = 100;
		
		String snum1 = numero + "";
		System.out.println(snum1 + " " + snum1.getClass());
		
		String snum2 = String.valueOf(numero);
		System.out.println(snum2 + " " + snum2.getClass());
		
		// Partir cadenas con split:
		String empleado = "1;Davolio;Representante de ventas";
		String []campos = empleado.split(";");
		for (String s : campos)
			System.out.println(s);
		
		
		
	}

	private static void pruebaDeprecated() {
		// Probar un constructor de String que está descatalogado!
		
		// Con la clase String no es necesario llamar a new:
		String cad = new String("hola que tal");
		String cad3 = "hola que tal";
		
		// Extraer los bytes de la cadena:
		byte []bytes = cad.getBytes();
		
		// Crear un String a partir de los bytes:
		String cad2 = new String(bytes, bytes.length);
		
		System.out.println(cad2);
	}

}
