package es.curso.interfaces;


import java.io.*;

/** Esta clase nos ofrece la funcionalidad para leer datos de teclado
Podemos leer texto, n�meros enteros y n�meros reales.*/

	public class Teclado {
	
	
		/** Este m�todo lee un String de teclado y lo devuelve */
		public static String readString(){
			BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
			String cadena="";
			try {
				cadena = teclado.readLine();
			} catch (Exception e){
				return "";
			}
			return(cadena);
		}
		
		/** Este m�todo lee un n�mero entero de teclado y lo devuelve */	
		public static int readint(){
			BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
			String cadena="";
			int entero=0;
			
			try {
				cadena = teclado.readLine();
				entero = Integer.parseInt(cadena);
				
			} catch (Exception e){
				return 0;
			}
			
			return(entero);
		}
		
		/** Este m�todo lee un double de teclado y lo devuelve */
		public static double readdouble(){
			BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
			String cadena="";
			double real=0.0;
			
			try {
				cadena = teclado.readLine();
				real = Double.parseDouble(cadena);
			} catch (Exception e){
				return 0.0;
			}
			return(real);
		}
		
	}