package database.model.importation;

public class ResumoProfessor {
	
	private byte tipoRegistro;
	private String nomeProfessor;
	private int tituloDocente;
	
	public byte getTipoRegistro() {
		return tipoRegistro;
	}

	public void setTipoRegistro(byte tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	public int getTituloDocente() {
		return tituloDocente;
	}

	public void setTituloDocente(int tituloDocente) {
		this.tituloDocente = tituloDocente;
	}

}
