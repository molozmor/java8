
package colecciones;

import java.util.List;

public interface IContabilidad {

	
	public void addGasto(String diaSemana, Integer importe) throws ContabilidadException; 
	public List<Integer> getGastos(String diaSemana) throws ContabilidadException;
	public void print() throws ContabilidadException;	
}
