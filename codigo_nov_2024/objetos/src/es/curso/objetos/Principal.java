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
		
		for (Direccion d : direcciones) {
			System.out.println("Dirección: "+d);
		}				
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
