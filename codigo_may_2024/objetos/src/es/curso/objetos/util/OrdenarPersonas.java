package es.curso.objetos.util;

import java.util.Comparator;

import es.curso.objetos.Persona;

public class OrdenarPersonas implements Comparator<Persona> {
	
	public static final int ORD_NOMBRE = 0;
	public static final int ORD_ALTURA = 1;
	
	public static final int ASC = 1;
	public static final int DESC = -1;
	
	private int criterio;
	private int sentido;	
	

	public OrdenarPersonas() {
		// Por defecto ordena por nombre, ascendentemente.
		this(ORD_NOMBRE, ASC);
	}


	public OrdenarPersonas(int criterio, int sentido) {
		super();
		this.criterio = criterio;
		this.sentido = sentido;
	}


	@Override
	public int compare(Persona p1, Persona p2) {
		// TODO Auto-generated method stub
		String nombre1 = p1.getNombre();
		String nombre2 = p2.getNombre();
		double altura1, altura2;
		int resul;
		
		switch (criterio) {
		case ORD_NOMBRE:
			resul = nombre1.compareTo(nombre2);
			break;
			
		case ORD_ALTURA:
			altura1 = p1.getAltura();
			altura2 = p2.getAltura();
			
			if (altura1 == altura2)
				resul = 0;
			else if (altura1 < altura2)
				resul = -1;
			else
				resul = 1;			
			break;

		default: // Por defecto por nombre
			resul = nombre1.compareTo(nombre2);
			break;
		}
		return resul * sentido;
	}

}
