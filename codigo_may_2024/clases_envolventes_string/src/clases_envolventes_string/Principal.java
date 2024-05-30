package clases_envolventes_string;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//pruebaDeprecated();
		//pruebasConString();
		pruebasConEmpleado();
	}

	private static void pruebasConEmpleado() {
		// TODO Auto-generated method stub
		
		Empleado emp = new Empleado("1;Davolio;Representante de ventas",";");
		System.out.println(emp);
		System.out.println(emp.toCSV(";"));
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
		
		// Convertir de texto a número (entero):
		Integer i = 100;
		Integer j = 123;
		
		// Comparar dos integer:
		int resul = i.compareTo(j);
		if (resul == 0)
			System.out.println("son iguales");
		
		else if (resul == -1)
			System.out.println(i + " <  " + j);
	    
		else
			System.out.println(j + " <  " + i);
		
		// Podemos convertir de texto a número:
		String snumero = "1235";
		int n = Integer.parseInt(snumero);
		System.out.println(++n);
		
		
		
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
