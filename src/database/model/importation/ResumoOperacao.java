package database.model.importation;

import java.util.ArrayList;
import java.util.List;

public class ResumoOperacao {
	
	private byte tipoRegistro;
	private String fase;
	private int quantidadeDisciplina;
	private int quantidadeProfessor;
	private List<ResumoDisciplina> disciplinas = new ArrayList<ResumoDisciplina>();
	
	public byte getTipoRegistro() {
		return tipoRegistro;
	}
	public void setTipoRegistro(byte tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}
	public String getFase() {
		return fase;
	}
	public void setFase(String fase) {
		this.fase = fase;
	}
	public int getQuantidadeDisciplina() {
		return quantidadeDisciplina;
	}
	public void setQuantidadeDisciplina(int quantidadeDisciplina) {
		this.quantidadeDisciplina = quantidadeDisciplina;
	}
	public int getQuantidadeProfessor() {
		return quantidadeProfessor;
	}
	public void setQuantidadeProfessor(int quantidadeProfessor) {
		this.quantidadeProfessor = quantidadeProfessor;
	}
	public List<ResumoDisciplina> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(List<ResumoDisciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	

}
