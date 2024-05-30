package es.curso.objetos;

/**
 * Implementación de la clase grupo
 */
public class Grupo {
	
	private String nombre;
	private Persona[] personas;
	private int index;
	
	
	public Grupo() {
		this("", 10);
	}


	public Grupo(String nombre, int n) {
		// TODO Auto-generated constructor stub
		this.nombre = nombre;
		this.personas = new Persona[n];
		this.index = 0;
	}
	
	


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getNumPersonas() {
		return index;
	}
	
	public int getNumMaxPersonas() {
		return personas.length;
	}
	
	public int getPlazasLibres() {
		return personas.length - index;
	}


	public boolean addPersona(Persona persona) {
		// TODO Auto-generated method stub
		
		if (index < personas.length) {
			personas[index] = persona;
			index++;
			return true;
			
		} else
			return false;		
	}


	public void print() {
		// TODO Auto-generated method stub
		System.out.println("GRUPO: "+nombre);
		for (int i = 0 ; i < index ; i++) {
			System.out.println(personas[i]);
		}
	}
	
	

}
