package modelo;


	 public class RaizException extends Exception {
	 
	 	private String msg;
		 
		
		public RaizException(){
			msg = "No hay solución, raíz no válida";
		}
		
		
		public String getMessage(){ return msg; }
	} 