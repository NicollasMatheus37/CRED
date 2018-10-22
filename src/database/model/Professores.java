package database.model;

import java.io.Serializable;

import generic.ModeloGenerico;

public class Professores extends ModeloGenerico implements Serializable {

	private static final long serialVersionUID = 2399530080090998341L;
	
	private Integer cdProfessor;
	private String nmProfessor;
	private String titulo;
	public Integer getCdProfessor() {
		return cdProfessor;
	}
	public void setCdProfessor(Integer cdProfessor) {
		this.cdProfessor = cdProfessor;
	}
	public String getNmProfessor() {
		return nmProfessor;
	}
	public void setNmProfessor(String nmProfessor) {
		this.nmProfessor = nmProfessor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdProfessor == null) ? 0 : cdProfessor.hashCode());
		result = prime * result + ((nmProfessor == null) ? 0 : nmProfessor.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professores other = (Professores) obj;
		if (cdProfessor == null) {
			if (other.cdProfessor != null)
				return false;
		} else if (!cdProfessor.equals(other.cdProfessor))
			return false;
		if (nmProfessor == null) {
			if (other.nmProfessor != null)
				return false;
		} else if (!nmProfessor.equals(other.nmProfessor))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
	
	

}
