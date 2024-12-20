package es.curso.objetos;

import java.util.Objects;

public class Direccion {
	
	private String calle;
	private int numero;
	private int cp;
	private String poblacion;
	
	private static int contador = 0;
	
	
	public Direccion() {
		super();
		// TODO Auto-generated constructor stub
		
		contador++;
	}


	public Direccion(String calle, int numero, int cp, String poblacion) {
		super();
		this.calle = calle;
		this.numero = numero;
		this.cp = cp;
		this.poblacion = poblacion;		
		
		contador++;
	}
	
	/**
	 * Contructor copia. Sirve para copiar objetos
	 * @param dir el origen
	 */
	public Direccion(Direccion dir) {
		this(dir.calle, dir.numero, dir.cp, dir.poblacion);
	}
	
	public static int getNumInstancias() {
		return contador;
	}


	/**
	 * @return the calle
	 */
	public String getCalle() {
		return calle;
	}


	/**
	 * @param calle the calle to set
	 */
	public void setCalle(String calle) {
		this.calle = calle;
	}


	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}


	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}


	/**
	 * @return the cp
	 */
	public int getCp() {
		return cp;
	}


	/**
	 * @param cp the cp to set
	 */
	public void setCp(int cp) {
		this.cp = cp;
	}


	/**
	 * @return the poblacion
	 */
	public String getPoblacion() {
		return poblacion;
	}


	/**
	 * @param poblacion the poblacion to set
	 */
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	
	


	@Override
	public int hashCode() {
		return Objects.hash(calle, cp, numero, poblacion);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Direccion other = (Direccion) obj;
		return Objects.equals(calle, other.calle) && cp == other.cp && numero == other.numero
				&& Objects.equals(poblacion, other.poblacion);
	}


	@Override
	public String toString() {
		return "Direccion [calle=" + calle + ", numero=" + numero + ", cp=" + cp + ", poblacion=" + poblacion + "]";
	}
	
}
