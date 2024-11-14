package es.curso.interfaces;

import java.util.Comparator;

public class OrdenarPersonas implements Comparator<Persona> {
	
	// Criterios de ordenación
	public static final int POR_EDAD = 0;
	public static final int POR_ALTURA = 1;
	public static final int POR_NOMBRE = 2;
	
	// Sentido de la ordenación:
	public static final int ASC = 1;
	public static final int DESC = -1;
	
	
	private int criterio;
	private int sentido;
	
		
	public OrdenarPersonas() {
		this(POR_EDAD, ASC);
	}
	
	public OrdenarPersonas(int criterio) {
		this(criterio, ASC);
	}

	public OrdenarPersonas(int criterio, int sentido) {
		super();
		this.criterio = criterio;
		this.sentido = sentido;
	}

	@Override
	public int compare(Persona p1, Persona p2) {
		// TODO Auto-generated method stub
		int resul = 0;
		
		switch (criterio) {
		case POR_EDAD:
			Integer edad1 = p1.getEdad();
			Integer edad2 = p2.getEdad();
			resul = edad1.compareTo(edad2);
			break;
			
		case POR_ALTURA:
			Double h1 = p1.getAltura();
			Double h2 = p2.getAltura();
			resul = h1.compareTo(h2);
			break;
			
		case POR_NOMBRE:
			resul = p1.getNombre().compareTo(p2.getNombre());
			break;
		}
		
		return sentido * resul;
	}
	
}
