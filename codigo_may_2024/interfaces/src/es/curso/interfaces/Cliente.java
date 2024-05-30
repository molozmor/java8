package es.curso.interfaces;

public class Cliente {
	
	private String cif;
	private String empresa;
	
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Cliente(String cif, String empresa) {
		super();
		this.cif = cif;
		this.empresa = empresa;
	}


	public String getCif() {
		return cif;
	}


	public void setCif(String cif) {
		this.cif = cif;
	}


	public String getEmpresa() {
		return empresa;
	}


	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}


	@Override
	public String toString() {
		return "Cliente [cif=" + cif + ", empresa=" + empresa + "]";
	}
	
}
