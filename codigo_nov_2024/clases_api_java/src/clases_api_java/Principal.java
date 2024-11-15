package clases_api_java;

import java.util.Arrays;
import java.util.StringTokenizer;

import javax.print.attribute.standard.JobImpressions;


public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//pruebaDeprecated();
		pruebaSTK();
	}

	private static void pruebaSTK() {
		// TODO Auto-generated method stub
		String csv = "1;Davolio;Representante de ventas";
		StringTokenizer stk;
		String[] datos;
		
		stk = new StringTokenizer(csv, ";");
		System.out.println("num Tokens: "+stk.countTokens());
		
		while (stk.hasMoreTokens()) {
			System.out.println(stk.nextToken());
		}
		
		datos = csv.split(";");
		System.out.println(Arrays.toString(datos));
		
		imprimir("hola","adios","palabra","texto");
		
		String todo = String.join(";", "hola","adios","palabra","texto");
		System.out.println("todo: "+todo);
		
	}
	
	private static void imprimir(String...datos) {
		// Recibir múltiples parámetros del mismo tipo
		
		System.out.println("Recibo: "+datos.length+" datos");
		for (String s : datos) {
			System.out.println(s);
		}
	}

	private static void pruebaDeprecated() {
		byte[] bytes;
		//String nombre = new String("nombre áñ"); // NO ES NECESARIO.
		String nombre = "nombre áñ";
		
		bytes = nombre.getBytes();
		System.out.println(Arrays.toString(bytes));
		
		// Contructor descatalogado!!
		String cad = new String(bytes, 0, bytes.length, 0);
		cad = new String(bytes);
		System.out.println(cad);
		
		java.util.Date fecha; // Fecha y hora del sistem
		java.sql.Date fechaSQL; // Una fecha en una tabla de la BD.
		
		fecha = new java.util.Date();
		System.out.println(fecha);
	}
	

}
