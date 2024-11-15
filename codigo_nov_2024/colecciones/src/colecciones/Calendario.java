package colecciones;

import java.util.Arrays;
import java.util.List;

public class Calendario implements Comparable<Calendario> {
	
	private int dia;
	private String mes;
	
	private static final List<String> meses = Arrays.asList(
			"Enero","Febrero","Marzo",
			"Abril","Mayo","Junio",
			"Julio","Agosto","Septiembre",
			"Octubre","Noviembre","Diciembre");
	
	
	public Calendario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Calendario(int dia, String mes) {
		super();
		this.dia = dia;
		this.mes = mes;
	}

	/**
	 * @return the dia
	 */
	public int getDia() {
		return dia;
	}

	/**
	 * @param dia the dia to set
	 */
	public void setDia(int dia) {
		this.dia = dia;
	}

	/**
	 * @return the mes
	 */
	public String getMes() {
		return mes;
	}

	/**
	 * @param mes the mes to set
	 */
	public void setMes(String mes) {
		this.mes = mes;
	}

	@Override
	public String toString() {
		return "Calendario [dia=" + dia + ", mes=" + mes + "]";
	}

	@Override
	public int compareTo(Calendario cal) {
		// TODO Auto-generated method stub
		Integer mes1, mes2;
		Integer dia1, dia2;
		int resul;
		
		mes1 = Calendario.meses.indexOf(this.mes);
		mes2 = Calendario.meses.indexOf(cal.mes);
		
		resul = mes1.compareTo(mes2);
		if (resul == 0) {
			// Es el mismo mes:
			dia1 = this.dia;
			dia2 = cal.dia;
			return dia1.compareTo(dia2);
			
		} else
			return resul;
	}
}
