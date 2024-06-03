package colecciones;

public enum Direcciones {

	Norte(10), Sur(20), Este(30), Oeste(40);
	
	private int value;
	
	Direcciones(int value) {
		this.value = value;
	}
	
	int getValue() {
		return this.value;
	}
}
