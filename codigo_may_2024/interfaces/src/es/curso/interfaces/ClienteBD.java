package es.curso.interfaces;

public class ClienteBD implements IOperaciones {

	@Override
	public void grabarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		System.out.println("Grabando en BD: " + cliente);
	}

	@Override
	public void borrarCliente(String cif) {
		// TODO Auto-generated method stub
		System.out.println("Borrar cliente BD: "+cif);
	}

	@Override
	public Cliente buscarCliente(String cif) {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente(cif, "nombreClienteBD");
		return cliente;
	}

	@Override
	public void actualizarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		System.out.println("Actualizando en BD: " + cliente);
	}

}
