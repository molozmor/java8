package es.curso.aplicacion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import es.curso.objetos.Empleado;
import es.curso.objetos.Grupo;
import es.curso.objetos.Persona;

public class Principal {
	
	private static void modificarEdad(int edad) {
		// Los tipos primitivos pasan por copia:
		edad++;
	}
	
	private static void modificarEdad(Persona persona) {
		persona.cumpleaños();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//pruebasPersona();
		//pruebasGrupo();
		//pruebasEmpleado();
		pruebasCompararPersonas();
		
		/*
		int edad = 10;
		modificarEdad(edad);
		System.out.println("edad: "+edad);
		
		Persona p = new Persona("Jose", 10);
		System.out.println(p);
		modificarEdad(p);
		System.out.println(p);
		*/
		
		
	}
	
	private static void pruebasCompararPersonas() {
		Persona persona, persona2;

		// Contruir la persona con el constructor por defecto
		persona = new Persona("Jose Miguel", 44, 1.8, true);
		persona2 = new Persona("Javier", 33, 1.81, false);

		int resul = persona.compareTo(persona2);
		switch (resul) {
		case 0:
			System.out.println("Tienen la misma edad");
			break;
			
		case -1:
			System.out.println(persona.getNombre()+" es menor");
			break;

		default:
			System.out.println(persona2.getNombre()+" es menor");
			break;
		}
		
		// Prueba ordenar una colección de personas:
		Empleado emp1 = new Empleado("Eva", 21,1.77,true, "Siemens", 2000.0);
		
		
		Empleado emp2 = new Empleado("Sandra",53,1.76,true, "Accenture", 2500.0);
		
		
		ArrayList<Persona> personas = new ArrayList<Persona>();
		
		personas.add(persona);
		personas.add(persona2);
		personas.add(emp2);
		personas.add(emp1);
		
		System.out.println(personas);
		
		// Ordenar la colección de personas: la Persona implementa Comparable
		Collections.sort(personas);
		
		System.out.println(personas);			
			
	}

	private static void imprimir(Persona p) {
		System.out.println(p);
		
		if (p instanceof Empleado) {
			// Opcion1 con una variable auxiliar:
			Empleado e = (Empleado) p;
			System.out.println("Sueldo:" + e.getSueldo());
			
			// Opcion2: con un casting directamente:
			System.out.println("Empresa:" +  ((Empleado) p).getEmpresa()  );
		}
	}

	private static void pruebasEmpleado() {
		// TODO Auto-generated method stub
		
		Empleado emp1 = new Empleado("Eva", "Siemens", 2000.0);
		emp1.cumpleaños();
		
		Empleado emp2 = new Empleado("Sandra", "Accenture", 2500.0);
		emp2.setSueldo(3000.0);
		
		
		System.out.println(emp1);
		System.out.println(emp2);
		emp1.hablarCon(emp2);
		
		// Un objeto Empleado ES UN objeto Persona:
		Persona p = new Empleado("Juan", "Accenture", 2000.0);
		System.out.println(p);
		
		// Array de Personas y Empleados:
		Persona[] personal = new Persona[5];
		personal[0] = emp1;
		personal[1] = emp2;
		personal[2] = new Persona("Tomás", 33, 1.8, true);
		personal[3] = new Persona("Miguel", 31, 1.77, false);
		personal[4] = p;
		
		System.out.println("\nListado de personal");		
		for (Persona per : personal) {
			//System.out.println(per);
			imprimir(per);
		}
					
	}

	private static void pruebasGrupo() {
		// TODO Auto-generated method stub
		// Prueba con el grupo:

		Persona persona, persona2;

		// Contruir la persona con el constructor por defecto
		persona = new Persona("Jose Miguel", 44, 1.8, true);
		persona2 = new Persona("Javier", 33, 1.81, false);

		Grupo grupo = new Grupo("Java", 10);
		grupo.addPersona(persona);
		grupo.addPersona(persona2);
		System.out.println("Plazas libres: " + grupo.getPlazasLibres());
		grupo.print();
	}

	private static void pruebasPersona() {
		// TODO Auto-generated method stub
		// Clase objeto
		Persona persona, persona2;
		
		System.out.println("Num Personas creadas: "+Persona.getN());

		// Contruir la persona con el constructor por defecto
		persona = new Persona("Jose Miguel", 44, 1.8, true);
		persona2 = new Persona("Javier", 33, 1.81, false);

		System.out.println("Num Personas creadas: "+Persona.getN());
		
		persona.hablarCon(persona2);
		persona2.hablarCon(persona);

		System.out.println(persona);
		persona.cumpleaños(5);
		System.out.println(persona);
		// System.out.println(persona.toString());

		// persona.nombre = "Juan"; Error tiene acceso privado!

		if (persona == persona2) {
			System.out.println("Son iguales persona y persona2");
		} else {
			System.out.println("Son distintos persona y persona2");
		}

		Persona persona3 = new Persona("Javier", 32, 1.81, false);
		if (persona3 == persona2) {
			System.out.println("Son iguales persona3 y persona2");
		} else {
			System.out.println("Son distintos persona3 y persona2");
		}

		System.out.println("equals entre persona2 y persona3:" + persona2.equals(persona3));
		System.out.println("hashCode de persona2 y persona3:" + persona2.hashCode() + " " + persona3.hashCode());

		String nombre1 = "Ana";
		String nombre2 = "Ana";

		System.out.println("Comparar nombres: " + nombre1 == nombre2);
		System.out.println("con equals: " + nombre1.equals(nombre2));

		int n1 = 10, n2 = 10;
		System.out.println("numeros iguales: " + (n1 == n2));
		System.out.println(persona.equals(persona));
		System.out.println(persona.getClass());
		persona.equals(nombre1);
	}

}
