import java.io.*;

/** Esta clase nos ofrece la funcionalidad para leer datos de teclado
Podemos leer texto, números enteros y números reales.*/

	public class Teclado {
	
	
		/** Este método lee un String de teclado y lo devuelve */
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
		
		/** Este método lee un número entero de teclado y lo devuelve */	
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
		
		/** Este método lee un double de teclado y lo devuelve */
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