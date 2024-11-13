package es.curso.herencia.aplicacion;

import es.curso.herencia.Empleado;
import es.curso.herencia.Persona;

public class Principal {
	

	private static final int PERSONA = 0;
	private static final int EMPLEADO = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		pruebaEmpleado();
	}
	
	private static void imprimir(Persona p) {
		// Sustitución de la clase Hija por la clase Padre: Liskow
		System.out.println("Clase: "+ p.getClass().getName());
		System.out.println("Objeto: " + p);
	}
	
	private static Persona crear(String nombre, int tipo) {
		
		switch (tipo) {
		case PERSONA:
			return new Persona(nombre);

		case EMPLEADO:
			return new Empleado(nombre, "", 0.0);
					
		}
		
		return null;
	}

	private static void pruebaEmpleado() {
		// TODO Auto-generated method stub
		
		// Podemos referenciar la clase hija con la padre
		Persona empleado;		
		empleado = new Empleado("Javier", "Accenture", 2000.0);
		
		// Al revés no. No podemos referenciar un objeto de la clase padre con uno de la clase hija
		//Empleado persona = new Persona("Miguel");
		
		System.out.println("nombre: "+empleado.getNombre());		
		System.out.println(empleado);
		
		Persona persona = new Persona("Miguel");
		
		imprimir(persona);
		imprimir(empleado);
		
		Persona p = crear("Gema", PERSONA);
		Empleado e = (Empleado) crear("Olga", EMPLEADO);
		
		imprimir(p);
		imprimir(e);
		
	}

}
