package colecciones;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OrdenarDiaSemana implements Comparator<String> {

	public static final List<String> DIAS = Arrays.asList(
			"lunes", "martes",
			"miercoles","jueves",
			"viernes","sabado",
			"domingo");
	
	@Override
	public int compare(String dia1, String dia2) {
				
		Integer pos1 = DIAS.indexOf(dia1);
		Integer pos2 = DIAS.indexOf(dia2);
		
		return pos1.compareTo(pos2);
	}

}
