package es.curso.aplicacion;

import es.curso.objetos.Persona;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Clase objeto
		Persona persona, persona2;
		
			
		// Contruir la persona con el constructor por defecto
		persona = new Persona("Jose Miguel", 44, 1.8, true);
		persona2 = new Persona("Javier", 33, 1.81, false);
		
		persona.hablarCon(persona2);
		persona2.hablarCon(persona);
		
		
		System.out.println(persona);
		persona.cumpleaños(5);
		System.out.println(persona);
		//System.out.println(persona.toString());
		
		//persona.nombre = "Juan"; Error tiene acceso privado!
		
		if (persona == persona2) {
			System.out.println("Son iguales persona y persona2");
		} else {
			System.out.println("Son distintos persona y persona2");
		}
		
		Persona persona3 = new Persona("Javier", 33, 1.81, false);
		if (persona3 == persona2) {
			System.out.println("Son iguales persona3 y persona2");
		} else {
			System.out.println("Son distintos persona3 y persona2");
		}
		
		String nombre1 = "Ana";
		String nombre2 = "Ana";
		
		System.out.println("Comparar nombres: "+ nombre1==nombre2);
		System.out.println("con equals: "+nombre1.equals(nombre2));
	}

}
