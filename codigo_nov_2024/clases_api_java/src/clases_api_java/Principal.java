package clases_api_java;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.StringTokenizer;


public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//pruebaDeprecated();
		//pruebaSTK();
		//pruebasClasesEnvolventes();
		pruebaOtrasClases();
	}

	private static void pruebaOtrasClases() {
		Random rd;
		Date fecha;
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"); // "dd/MM/YYYY HH:mm:ss"
		
		fecha = new Date();
		// Tomamos como semilla el tiempo del sistema en milisg.
		rd = new Random(fecha.getTime());
		
		for (int i = 0 ; i < 10 ; i++) {
			System.out.println(rd.nextBoolean()+" "+rd.nextFloat()+" "+rd.nextInt(100));
		}
		
		System.out.println("Ahora: "+ sdf.format(fecha));
		
		Calendar cal = Calendar.getInstance();
		// Establecer la fecha de hoy
		cal.setTime(fecha);
		
		// Sumar 3 meses:
		cal.add(Calendar.DAY_OF_MONTH, -3);
		
		Date nuevaFecha = new Date(cal.getTimeInMillis());
		System.out.println("Nueva Fecha: "+ sdf.format(nuevaFecha));
		
	}

	private static void pruebasClasesEnvolventes() {
		// TODO Auto-generated method stub
		Double d = 34.78;
		Float f = 34.8F;
		Integer num = 90;
		Long largo = 100L;
		
		Float f2 = new Float("34.0");
		
		System.out.println("F2: "+f2);
		
		float f3 = f2.floatValue(); // No es obligatorio
		float f4 = f2; // Autoboxing igualar tipos primitivos y clases envolventes.
		
		// Prueba de comparación:
		float r1 = 2.44F;
		float r2 = 9.0F;
									// Comparamos directamente con los tipos primitivos.
		System.out.println("Compare: "+Float.compare(r1, r2));
		
		
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
