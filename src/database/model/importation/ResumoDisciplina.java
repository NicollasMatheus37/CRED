package database.model.importation;

import java.util.ArrayList;
import java.util.List;

public class ResumoDisciplina {
	
	private byte tipoRegistro;
	private String codigoDisciplina;
	private int diaSemana;
	private int quantidadeProfessor;
	private List<ResumoProfessor> professores = new ArrayList<ResumoProfessor>();
	
	public byte getTipoRegistro() {
		return tipoRegistro;
	}
	public void setTipoRegistro(byte tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}
	public String getCodigoDisciplina() {
		return codigoDisciplina;
	}
	public void setCodigoDisciplina(String codigoDisciplina) {
		this.codigoDisciplina = codigoDisciplina;
	}
	public int getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(int diaSemana) {
		this.diaSemana = diaSemana;
	}
	public int getQuantidadeProfessor() {
		return quantidadeProfessor;
	}
	public void setQuantidadeProfessor(int quantidadeProfessor) {
		this.quantidadeProfessor = quantidadeProfessor;
	}
	public List<ResumoProfessor> getProfessores() {
		return professores;
	}
	public void setProfessores(List<ResumoProfessor> professores) {
		this.professores = professores;
	}
	
	
	
}
