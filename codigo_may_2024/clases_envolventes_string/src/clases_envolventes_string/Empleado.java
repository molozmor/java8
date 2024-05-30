package clases_envolventes_string;

public class Empleado {
	
	private int id;
	private String nombre;
	private String cargo;
	
	
	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Empleado(int id, String nombre, String cargo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cargo = cargo;
	}


	public Empleado(String csv, String sep) {
		// TODO Auto-generated constructor stub
		String[] datos;
		
		// Partir la cadena por el separador.
		datos = csv.split(sep);
		
		this.id = Integer.parseInt(datos[0]);
		this.nombre = datos[1];
		this.cargo = datos[2];	
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", cargo=" + cargo + "]";
	}
	
	

}
