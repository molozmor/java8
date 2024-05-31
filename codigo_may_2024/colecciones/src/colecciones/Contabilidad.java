package colecciones;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Contabilidad implements IContabilidad {

	private Map<String, List<Integer>> gastos;
	

	public Contabilidad() {
		super();
		gastos = new TreeMap<String, List<Integer>>(new OrdenarDiaSemana());
	}

	@Override
	public void addGasto(String diaSemana, Integer importe) {
		
		// Inicializa la lista si no existe la clave:
		gastos.putIfAbsent(diaSemana.toLowerCase(), new ArrayList<>());
		
		// Añade el importe a la lista del día de la semana:
		gastos.get(diaSemana).add(importe);		
	}

	@Override
	public List<Integer> getGastos(String diaSemana) throws ContabilidadException {
		// Si la clave existe devolvemos los gastos de este día
		// No exista la clave porque no tenemos gastos ese día pero la clave es valida
		// Un dia de la semana equivocado lanzar una excepción
		
		if (!OrdenarDiaSemana.DIAS.contains(diaSemana.toLowerCase())) {
			throw new ContabilidadException("Dia de la semana: "+diaSemana+" incorrecto");
		}
		return null;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}
	
	
}
