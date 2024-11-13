package es.curso.objetos;

/**
 * Clase principal de la aplicación
 */
public class Principal {

	/**
	 * La función principal.
	 * @param args los argumentos de main
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//pruebasPersona();
		//pruebasDireccion();
		pruebasArraysObjetos();
	}
	
	

	private static void pruebasArraysObjetos() {
		// TODO Auto-generated method stub
		//int[] numeros = {1,2,3,4};
		//int[] numero2 = new int[10];
				
		Direccion dir1 = new Direccion("Gran Vía",45, 28021, "Madrid");		
		Direccion[] direcciones = {dir1, new Direccion("Arenal",1, 95877, "Barcelona")};
		
		// Una Direccion ES UN Object
		// Una Persona ES UN Object
		Integer numero = 999;
		
		Object[] objetos = new Object[6];
		objetos[0] = new Direccion("Gran Vía",45, 28021, "Madrid");
		objetos[1] = new Persona("Miguel");
		objetos[2] = new Direccion("Arenal",1, 95877, "Barcelona");
		objetos[3] = new Persona("Eva", 34, 0.0, 0.0);
		objetos[4] = "Mensaje de prueba";
		objetos[5] = numero;
		
		for (Object o : objetos) {
			if (o instanceof Persona)
				System.out.println("Nombre de la persona: "+ ((Persona)o).getNombre());
			
			System.out.println("CLase: "+o.getClass().getCanonicalName());
			System.out.println(o.toString());
		}
		
		/*
		
		for (Direccion d : direcciones) {
			System.out.println("Dirección: "+d);
		}
		
		Direccion[] direcciones2 = new Direccion[2];
		direcciones2[0] = dir1;
		direcciones2[1] = new Direccion("Arenal",1, 95877, "Barcelona");
		
		for (int i = 0 ; i < direcciones2.length ; i++) {
			System.out.println("Dirección: "+direcciones2[i]);
		}*/	
	}



	private static void pruebasDireccion() {
		// TODO Auto-generated method stub
		
		Direccion dir1 = new Direccion("Gran Vía",45, 28021, "Madrid");
		System.out.println(dir1);
		dir1.setCp(28002);
		System.out.println(dir1);
	}

	/**
	 * Pruebas con la clase persona
	 */
	private static void pruebasPersona() {
		// TODO Auto-generated method stub
		
		Persona p1 = new Persona("Miguel");
		System.out.println(p1);
		System.out.println(p1.toCSV());
		p1.setNombre("Andrés");
		
		//p1.nombre = "Andrés"; //ERROR tiene acceso privado.
		
		Persona p2 = new Persona("Eva", 34, 0.0, 0.0);
		p1.hablar(p2);
	}

}
