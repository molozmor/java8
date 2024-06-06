package genericos;

public class Wrapper<T> {
	
	private T instancia;

	public Wrapper(T instancia) {
		super();
		this.instancia = instancia;
	}

	public T getInstancia() {
		return instancia;
	}

	public void setInstancia(T instancia) {
		this.instancia = instancia;
	}

	@Override
	public String toString() {
		return "Wrapper [instancia=" + instancia + "]";
	}


}
