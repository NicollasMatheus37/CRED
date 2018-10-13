package database.model;

import java.io.Serializable;

import generic.ModeloGenerico;

public class Cursos extends ModeloGenerico implements Serializable {

	private static final long serialVersionUID = 1621610155370528217L;
	
	private Integer cdCurso;
	private String nmCurso;

	public Integer getCdCurso() {
		return cdCurso;
	}
	public void setCdCurso(Integer cdCurso) {
		this.cdCurso = cdCurso;
	}
	public String getNmCurso() {
		return nmCurso;
	}
	public void setNmCurso(String nmCurso) {
		this.nmCurso = nmCurso;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdCurso == null) ? 0 : cdCurso.hashCode());
		result = prime * result + ((nmCurso == null) ? 0 : nmCurso.hashCode());
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
		Cursos other = (Cursos) obj;
		if (cdCurso == null) {
			if (other.cdCurso != null)
				return false;
		} else if (!cdCurso.equals(other.cdCurso))
			return false;
		if (nmCurso == null) {
			if (other.nmCurso != null)
				return false;
		} else if (!nmCurso.equals(other.nmCurso))
			return false;
		
		return true;
	}
	
	
}
