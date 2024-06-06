package hilos;

public class Mensajes extends Thread {

	private int n;

	public Mensajes(int n, String nombre) {
		super(nombre);
		this.n = n;
	}

	@Override
	public void run() {
		
		for (int i = 0 ; i < this.n ; i++) {
			System.out.println(this.getName()+" mensaje: "+(i+1));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(getName()+" termina");
	}
}
