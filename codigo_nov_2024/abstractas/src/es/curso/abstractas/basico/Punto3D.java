package es.curso.abstractas.basico;

// final corta la herencia.
public final class Punto3D extends Punto2D {
	
	private double z;
	
	
	public Punto3D() {
		this(0.0, 0.0, 0.0);
	}


	public Punto3D(double x1, double y1, double z) {
		super(x1, y1);
		this.z = z;
	}
	
	public Punto3D(Punto3D p) {
		this(p.x, p.y, p.z);
	}
	
	// Implementar el método desplazar (reutilizando el de la clase Padre)

	/**
	 * @return the z
	 */
	public double getZ() {
		return z;
	}


	@Override
	public void desplazar(double escalar) {
		// TODO Auto-generated method stub
		super.desplazar(escalar);
		this.z *= escalar;
	}
	
	@Override
	public void desplazar(Punto2D p) {
		
		if (p instanceof Punto3D) {
			Punto3D q = (Punto3D) p;
			
			this.x += q.x;
			this.y += q.y;
			this.z += q.z;
			
		} else {
			super.desplazar(p);
		}
	}


	/**
	 * @param z the z to set
	 */
	public void setZ(double z) {
		this.z = z;
	}


	@Override
	public String toString() {
		return "(" + x + ", " + y + ", " + z + ")";
	}
}
