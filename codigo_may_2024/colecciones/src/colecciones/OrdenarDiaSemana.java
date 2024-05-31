package colecciones;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OrdenarDiaSemana implements Comparator<String> {

	public static final List<String> dias = Arrays.asList(
			"Lunes", "Martes",
			"Miercoles","Jueves",
			"Viernes","Sabado",
			"Domingo");
	
	@Override
	public int compare(String dia1, String dia2) {
		
		
		Integer pos1 = dias.indexOf(dia1);
		Integer pos2 = dias.indexOf(dia2);
		
		return pos1.compareTo(pos2);
	}

}
