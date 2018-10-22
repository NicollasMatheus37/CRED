package database.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import generic.ModeloGenerico;

public class Disciplinas extends ModeloGenerico implements Serializable {

	private static final long serialVersionUID = -2191621589985673858L;
	
	private Integer cdDisciplina;
	private String matricula;
	private List<Professores> professores = new ArrayList<Professores>();
	private String diaSemana;
	private Fases fase;
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public Integer getCdDisciplina() {
		return cdDisciplina;
	}
	public void setCdDisciplina(Integer cdDisciplina) {
		this.cdDisciplina = cdDisciplina;
	}
	public List<Professores> getProfessores() {
		return professores;
	}
	public void setProfessores(List<Professores> professores) {
		this.professores = professores;
	}
	public String getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
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
		result = prime * result + ((diaSemana == null) ? 0 : diaSemana.hashCode());
		result = prime * result + ((fase == null) ? 0 : fase.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((professores == null) ? 0 : professores.hashCode());
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
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (professores == null) {
			if (other.professores != null)
				return false;
		} else if (!professores.equals(other.professores))
			return false;
		return true;
	}

	
}
