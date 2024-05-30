package es.curso.interfaces;

public class Aplicacion {

	private IOperaciones app;

	public static final int BASE_DATOS = 0;
	public static final int FICHERO = 1;

	public Aplicacion(String tipo) {
		// TODO Auto-generated constructor stub
		if (tipo.equalsIgnoreCase("BD"))
				app = new ClienteBD();
		else
				app = new ClienteFile();
	}

	// java es.curso.interfaces.Aplicacion BD --> base de datos
	// java es.curso.interfaces.Aplicacion FILE --> ficheros

	public void operar() {
		int op;

		while (true) {
			System.out.println("Menu:");
			System.out.println("1.grabar");
			System.out.println("2.borrar");
			System.out.println("3.buscar");
			System.out.println("4.actualizar");
			System.out.println("5.salir");
			System.out.println("opcion:");			
			op = Teclado.readint();
			
			switch (op) {
			case 1:
				app.grabarCliente(new Cliente("2343322A", "nuevoCliente"));
				break;
				
			case 2:
				app.borrarCliente("2343322A");
				break;
				
			case 3:
				app.buscarCliente("2343322A");
				break;
				
			case 4:
				app.actualizarCliente(new Cliente("2343322A", "nuevoCliente"));
				break;
				
			case 5:
				System.exit(0);
				

			default:
				break;
			}

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Se pueden definir variables del tipo de la interface pero si se instancian
		 * hay que hacerlo con una clase anónima.
		 */
		// IOperaciones operaciones;

		/*
		 * Un objeto de tipo interface puede referenciar a un objeto de una clase que lo
		 * implementa ClienteBD ES UN IOperaciones ClienteFile ES UN IOperaciones
		 */
		// IOperaciones clienteBD = new ClienteBD();
		// IOperaciones clienteFile = new ClienteFile();
		
		Aplicacion aplicacion = new Aplicacion("BD");
		aplicacion.operar();

	}

}
