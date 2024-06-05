package genericos;

import java.util.ArrayList;
import java.util.List;

public class Matriz<T> {
	
	private List<List<T>> m;
	private int filas;
	private int cols;
	
	public Matriz(int filas, int cols, T valorInicial) {
		this.filas = filas;
		this.cols = cols;
		List<T> aux;
		
		// Crear el número de filas:
		m = new ArrayList<List<T>>(filas);
		
		// Para cada fila creamos las cols:
		for (int i = 0 ; i < cols ; i++) {
			
			// Crear una nueva fila, rellena con el valor inicial
			aux = new ArrayList<T>(cols);
			for (int j = 0 ; j < cols ; j++) {
				aux.add(valorInicial);
			}
			
			// Añadir la fila a la matriz: att m
			m.add(aux);
		}
	}
	

	public int getFilas() {
		return filas;
	}

	public int getCols() {
		return cols;
	}
	
	public void print() {
		for (List<T> fila : this.m) {
			for (T item : fila) {
				System.out.print(item + "  ");
			}
			System.out.println();
		}
	}

}
