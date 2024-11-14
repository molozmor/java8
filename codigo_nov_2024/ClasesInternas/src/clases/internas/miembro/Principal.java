package clases.internas.miembro;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Externa ie = new Externa(10);
		Externa.Interna i = ie.new Interna(100);
		i.acceso();
	}

}
