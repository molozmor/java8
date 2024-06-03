package serializacion;

public class Principal {
	
	public static void main(String[] args) {
		
		Persona persona = new Persona("Jose Miguel", 34, 1.8, true);
		System.out.println(persona);
		
		Principal principal = new Principal();
		
		principal.serializar(persona);
		Persona persona2 = principal.deserializar();
		
		System.out.println(persona2);
		System.out.println("compareTo: "+persona.compareTo(persona2));
	}

	private Persona deserializar() {
		// TODO Auto-generated method stub
		return null;
	}

	private void serializar(Persona persona) {
		// TODO Auto-generated method stub
		
	}

}
