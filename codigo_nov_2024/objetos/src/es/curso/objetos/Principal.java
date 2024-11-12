package es.curso.objetos;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		pruebasPersona();
	}

	private static void pruebasPersona() {
		// TODO Auto-generated method stub
		
		Persona p1 = new Persona();
		System.out.println(p1);
		System.out.println(p1.toCSV());
		
	}

}
