
package colecciones;

import java.util.List;

public interface IContabilidad {

	
	public void addGasto(String diaSemana, Integer importe); 
	public List<Integer> getGastos(String diaSemana);
	public void print();	
}
