package clases.internas.estaticas;

public class Externa {
	
	private int externo;	
	private static double PI = 3.141516;

	public Externa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Externa(int externo) {
		super();
		this.externo = externo;
	}
	
	static class Interna {
		// La clase interna static puede acceder a los atributos
		// de la clase Externa siempre y cuando sean static:
		
		private int interno;
		
		public Interna() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Interna(int interno) {
			super();
			this.interno = interno;
		}
				
		public int getInterno() {
			return interno;
		}

		public void acceso() {
			System.out.println(PI);
		}
	}
	

}
