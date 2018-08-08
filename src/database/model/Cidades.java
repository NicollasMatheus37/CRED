package database.model;

import java.io.Serializable;

public class Cidades implements Serializable{

	private static final long serialVersionUID = 1L;
	private String cidade;
	private String estado;
	private String pais;
	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	
	
}
