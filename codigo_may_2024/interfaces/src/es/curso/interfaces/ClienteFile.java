package es.curso.interfaces;

public class ClienteFile implements IOperaciones {

	@Override
	public void grabarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		System.out.println("Grabando en file: "+cliente);
	}

	@Override
	public void borrarCliente(String cif) {
		// TODO Auto-generated method stub
		System.out.println("borrar cliente en file: "+cif);
	}

	@Override
	public Cliente buscarCliente(String cif) {
		// TODO Auto-generated method stub
		return new Cliente(cif, "nombreClienteFile");
	}

	@Override
	public void actualizarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		System.out.println("Actualizando en File: "+cliente);
	}

}
