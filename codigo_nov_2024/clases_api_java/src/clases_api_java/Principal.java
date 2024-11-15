package clases_api_java;

import java.util.Arrays;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		pruebaDeprecated();
	}

	private static void pruebaDeprecated() {
		byte[] bytes;
		String nombre = "nombre áñ";
		
		bytes = nombre.getBytes();
		System.out.println(Arrays.toString(bytes));
		
		// Contructor descatalogado!!
		String cad = new String(bytes, 0, bytes.length, 0);
		cad = new String(bytes);
		System.out.println(cad);
	}
	

}
