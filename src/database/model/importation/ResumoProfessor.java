package database.model.importation;

public class ResumoProfessor {
	 
	private int tipoRegistro;
	private String nomeProfessor;
	private String tituloDocente;
	private transient int linha;
	
	public int getTipoRegistro() {
		return tipoRegistro;
	}

	public void setTipoRegistro(int tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	public String getTituloDocente() {
		return tituloDocente;
	}

	public void setTituloDocente(String tituloDocente) {
		this.tituloDocente = tituloDocente;
	}

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

}
