package database.model.importation;

public class Trailer {
	
	private byte tipoRegistro;
	private Integer totalRegistro;
	private transient int linha;
	
	public byte getTipoRegistro() {
		return tipoRegistro;
	}
	public void setTipoRegistro(byte tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}
	public Integer getTotalRegistro() {
		return totalRegistro;
	}
	public void setTotalRegistro(Integer totalRegistro) {
		this.totalRegistro = totalRegistro;
	}
	public int getLinha() {
		return linha;
	}
	public void setLinha(int linha) {
		this.linha = linha;
	}
	
}
