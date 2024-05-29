package es.curso.objetos;

public class Grupo {
	
	private String nombre;
	private Persona[] personas;
	
	
	public Grupo() {
		this("", 10);
	}


	public Grupo(String nombre, int n) {
		// TODO Auto-generated constructor stub
		this.nombre = nombre;
		this.personas = new Persona[n];
	}
	
	

}
