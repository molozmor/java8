package clases.internas.miembro;

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
	
	class Interna {
		// Desde la clase interna podemos acceder los atributos de la clase Externa
		// ya sean static  o no.
		// Y por supuesto a los internos.
		
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
			System.out.println("att interno:"+this.interno);
			System.out.println("att externo:"+Externa.this.externo);
		}
	}
	

}
