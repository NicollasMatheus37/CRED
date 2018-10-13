package database.model;

import java.io.Serializable;

import generic.ModeloGenerico;

public class Disciplinas extends ModeloGenerico implements Serializable {

	private static final long serialVersionUID = -2191621589985673858L;
	
	private Integer cdDisciplina;
	private String cdMatricula;
	private String diaSemana;
	private Integer qtProfessor;
	private Fases fase;
	public Integer getCdDisciplina() {
		return cdDisciplina;
	}
	public void setCdDisciplina(Integer cdDisciplina) {
		this.cdDisciplina = cdDisciplina;
	}
	public String getCdMatricula() {
		return cdMatricula;
	}
	public void setCdMatricula(String cdMatricula) {
		this.cdMatricula = cdMatricula;
	}
	public String getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}
	public Integer getQtProfessor() {
		return qtProfessor;
	}
	public void setQtProfessor(Integer qtProfessor) {
		this.qtProfessor = qtProfessor;
	}
	public Fases getFase() {
		return fase;
	}
	public void setFase(Fases fase) {
		this.fase = fase;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdDisciplina == null) ? 0 : cdDisciplina.hashCode());
		result = prime * result + ((cdMatricula == null) ? 0 : cdMatricula.hashCode());
		result = prime * result + ((diaSemana == null) ? 0 : diaSemana.hashCode());
		result = prime * result + ((fase == null) ? 0 : fase.hashCode());
		result = prime * result + ((qtProfessor == null) ? 0 : qtProfessor.hashCode());
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
		Disciplinas other = (Disciplinas) obj;
		if (cdDisciplina == null) {
			if (other.cdDisciplina != null)
				return false;
		} else if (!cdDisciplina.equals(other.cdDisciplina))
			return false;
		if (cdMatricula == null) {
			if (other.cdMatricula != null)
				return false;
		} else if (!cdMatricula.equals(other.cdMatricula))
			return false;
		if (diaSemana == null) {
			if (other.diaSemana != null)
				return false;
		} else if (!diaSemana.equals(other.diaSemana))
			return false;
		if (fase == null) {
			if (other.fase != null)
				return false;
		} else if (!fase.equals(other.fase))
			return false;
		if (qtProfessor == null) {
			if (other.qtProfessor != null)
				return false;
		} else if (!qtProfessor.equals(other.qtProfessor))
			return false;
		return true;
	}
	
	

}
