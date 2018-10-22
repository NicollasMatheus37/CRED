package database.model.importation;

import java.util.ArrayList;
import java.util.List;

public class ResumoDisciplina {
	
	private int tipoRegistro;
	private String codigoDisciplina;
	private String diaSemana;
	private String quantidadeProfessor;
	private List<ResumoProfessor> professores = new ArrayList<ResumoProfessor>();
	private transient int linha;
	
	public int getTipoRegistro() {
		return tipoRegistro;
	}
	public void setTipoRegistro(int tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}
	public String getCodigoDisciplina() {
		return codigoDisciplina;
	}
	public void setCodigoDisciplina(String codigoDisciplina) {
		this.codigoDisciplina = codigoDisciplina;
	}
	public String getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}
	public String getQuantidadeProfessor() {
		return quantidadeProfessor;
	}
	public void setQuantidadeProfessor(String quantidadeProfessor) {
		this.quantidadeProfessor = quantidadeProfessor;
	}
	public List<ResumoProfessor> getProfessores() {
		return professores;
	}
	public void setProfessores(List<ResumoProfessor> professores) {
		this.professores = professores;
	}
	public int getLinha() {
		return linha;
	}
	public void setLinha(int linha) {
		this.linha = linha;
	}
	
	
	
}
