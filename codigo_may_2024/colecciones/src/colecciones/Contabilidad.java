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
	public void addGasto(String diaSemana, Integer importe) throws ContabilidadException {

		String clave = diaSemana.toLowerCase();

		if (!OrdenarDiaSemana.DIAS.contains(clave)) {
			throw new ContabilidadException("Dia de la semana: " + diaSemana + " incorrecto");

		} else {

			// Inicializa la lista si no existe la clave:
			gastos.putIfAbsent(clave, new ArrayList<>());

			// Añade el importe a la lista del día de la semana:
			gastos.get(clave).add(importe);
		}
	}

	@Override
	public List<Integer> getGastos(String diaSemana) throws ContabilidadException {
		// Si la clave existe devolvemos los gastos de este día
		// No exista la clave porque no tenemos gastos ese día pero la clave es valida
		// Un dia de la semana equivocado lanzar una excepción

		String clave = diaSemana.toLowerCase();

		if (!OrdenarDiaSemana.DIAS.contains(clave)) {
			throw new ContabilidadException("Dia de la semana: " + diaSemana + " incorrecto");

		} else {
			return gastos.get(clave);
		}
	}

	@Override
	public void print() throws ContabilidadException {
		// TODO Auto-generated method stub

		for (String dia : gastos.keySet()) {
			System.out.println(dia);
			System.out.println(this.getGastos(dia));
		}
	}

}
