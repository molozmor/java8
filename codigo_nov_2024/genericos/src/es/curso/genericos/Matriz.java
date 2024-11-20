package es.curso.genericos;

import java.util.ArrayList;
import java.util.List;

public class Matriz<T> {
	
	// Las dimensiones
	private int filas;
	private int cols;
	
	// Los elementos los almacenamos en listas:
	private List<List<T>> m;
	
	
	public Matriz(int filas, int cols, T valorInicial) {
		List<T> fila;
		
		this.filas = filas;
		this.cols = cols;
		
		this.m = new ArrayList<List<T>>(filas);
		
		// Recorrer cada fila, añadiendo las columnas:
		for (int i = 0 ; i < filas ; i++) {
			
			// Crear las columnas:
			fila = new ArrayList<T>(cols);
			
			// Recorrer las columnas colocando el valor inicial:
			for (int j = 0 ; j < cols ; j++) {
				fila.add(valorInicial);
			}
			
			// Añadir la fila a la matriz:
			this.m.add(fila);
					
		}		
	}


	/**
	 * @return the filas
	 */
	public int getFilas() {
		return filas;
	}


	/**
	 * @return the cols
	 */
	public int getCols() {
		return cols;
	}
	
	public void print() {
		
		for (List<T> fila : this.m) {
			
			for (T item : fila) {
				System.out.print(item+"\t");
			}
			System.out.println();
		}
	}
}
