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
	
	public void set(int f, int c, T valor) {
		
		// Recuperar la fila:
		List<T> fila = this.m.get(f);
		
		// Dentro de la fila, modificar la columna:
		fila.set(c, valor);
	}
	
	
	public Matriz<T> traspuesta(){
		T valor = this.m.get(0).get(0);
		List<T> fila;
		//List<T> filaT;
		
		Matriz<T> aux = new Matriz<T>(this.cols, this.filas, valor);
		
		for (int i = 0 ; i < this.cols ; i++) {
			
			for (int j = 0 ; j < this.filas ; j++) {
				
				fila = aux.m.get(i);
				fila.set(j, this.m.get(j).get(i));
			}			
		}
		
		return aux;
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
