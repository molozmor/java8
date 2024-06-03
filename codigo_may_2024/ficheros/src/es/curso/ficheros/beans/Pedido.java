package es.curso.ficheros.beans;

public class Pedido {

	private int idPedido;
	private String idCliente;
	private int idEmpleado;
	private int idEmpresaEnvio;
	private double importe;
	private String pais;
	
	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pedido(int idPedido, String idCliente, int idEmpleado, int idEmpresaEnvio, double importe, String pais) {
		super();
		this.idPedido = idPedido;
		this.idCliente = idCliente;
		this.idEmpleado = idEmpleado;
		this.idEmpresaEnvio = idEmpresaEnvio;
		this.importe = importe;
		this.pais = pais;
	}
	
	public Pedido(String linea) {
		this(linea, ";");
	}
	
	public Pedido(String linea, String sep) {
		String datos[];
		
		datos = linea.split(sep);
		this.idPedido = Integer.parseInt(datos[0]);
		this.idCliente = datos[1];
		this.idEmpleado = Integer.parseInt(datos[2]);
		this.idEmpresaEnvio = Integer.parseInt(datos[3]);
		this.importe = Double.parseDouble(datos[4].replace(",", "."));
		this.pais = datos[5];
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public int getIdEmpresaEnvio() {
		return idEmpresaEnvio;
	}

	public void setIdEmpresaEnvio(int idEmpresaEnvio) {
		this.idEmpresaEnvio = idEmpresaEnvio;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", idCliente=" + idCliente + ", idEmpleado=" + idEmpleado
				+ ", idEmpresaEnvio=" + idEmpresaEnvio + ", importe=" + importe + ", pais=" + pais + "]";
	}		
	
}
