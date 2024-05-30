package es.curso.interfaces;

public interface IOperaciones {
	
	public void grabarCliente(Cliente cliente);
	public void borrarCliente(String cif);
	public Cliente buscarCliente(String cif);
	public void actualizarCliente(Cliente cliente);
}
