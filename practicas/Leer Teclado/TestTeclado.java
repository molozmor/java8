
	public class TestTeclado {
	
		public static void main(String args[]){
			String texto="";
			int numero=0;
			double numero2=0;
			
			
			System.out.print("Introduce texto: ");
			texto = Teclado.readString();
			
			System.out.print("Introduce número entero: ");
			numero = Teclado.readint();
			
			System.out.print("Introduce número real: ");
			numero2 = Teclado.readdouble();
			
			System.out.println("He leido: texto --> " + texto + " numero -->  " + numero + " real --> " + numero2);	
		
		}
	}