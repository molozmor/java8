package es.curso.genericos;

public class ObjectWrapper {
	private Object ref;

	public ObjectWrapper(Object ref) {
		this.ref = ref;
	}

	public Object get() {
		return ref;
	}

	public void set(Object reference) {
		this.ref = reference;
	}
}
