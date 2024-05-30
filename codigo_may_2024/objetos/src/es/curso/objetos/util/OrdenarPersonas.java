package es.curso.objetos.util;

import java.util.Comparator;

import es.curso.objetos.Persona;

/**
 * Clase para ordenar personas con un par de criterios:
 * Se puede ordenar por nombre o por altura. En sentido 
 * ascendente o descendente.
 */
public class OrdenarPersonas implements Comparator<Persona> {
	
	/**
	 * Ordenar por nombre
	 */
	public static final int ORD_NOMBRE = 0;
	
	/**
	 * Ordenar por altura
	 */
	public static final int ORD_ALTURA = 1;
	
	/**
	 * Ascendente
	 */
	public static final int ASC = 1;
	
	/**
	 * Descendente
	 */
	public static final int DESC = -1;
	
	private int criterio;
	private int sentido;	
	

	/**
	 * Constructor por defecto, ordena por nombre asc.
	 */
	public OrdenarPersonas() {
		// Por defecto ordena por nombre, ascendentemente.
		this(ORD_NOMBRE, ASC);
	}


	/**
	 * Ordenar por un criterio y sentido
	 * @param criterio
	 * @param sentido
	 */
	public OrdenarPersonas(int criterio, int sentido) {
		super();
		this.criterio = criterio;
		this.sentido = sentido;
	}


	/**
	 * Método para comparar
	 */
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
