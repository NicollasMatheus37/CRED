package database.model;

import java.io.Serializable;

import generic.ModeloGenerico;

public class Fases extends ModeloGenerico implements Serializable{

	private static final long serialVersionUID = -6074848719916354528L;
	
	private Integer cdFase;
	private Integer nrFase;
	private Cursos curso;
	public Integer getCdFase() {
		return cdFase;
	}
	public void setCdFase(Integer cdFase) {
		this.cdFase = cdFase;
	}
	public Integer getNrFase() {
		return nrFase;
	}
	public void setNrFase(Integer nrFase) {
		this.nrFase = nrFase;
	}
	public Cursos getCurso() {
		return curso;
	}
	public void setCurso(Cursos curso) {
		this.curso = curso;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdFase == null) ? 0 : cdFase.hashCode());
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((nrFase == null) ? 0 : nrFase.hashCode());
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
		Fases other = (Fases) obj;
		if (cdFase == null) {
			if (other.cdFase != null)
				return false;
		} else if (!cdFase.equals(other.cdFase))
			return false;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (nrFase == null) {
			if (other.nrFase != null)
				return false;
		} else if (!nrFase.equals(other.nrFase))
			return false;
		return true;
	}
	
	
}
