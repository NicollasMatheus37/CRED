package database.model.importation;

import java.util.List;

public class Arquivo {
	private Header header;
	private List<ResumoOperacao> resumos;
	private Trailer trailer;
	
	public Header getHeader() {
		return header;
	}
	public void setHeader(Header header) {
		this.header = header;
	}
	public List<ResumoOperacao> getResumos() {
		return resumos;
	}
	public void setResumos(List<ResumoOperacao> resumos) {
		this.resumos = resumos;
	}
	public Trailer getTrailer() {
		return trailer;
	}
	public void setTrailer(Trailer trailer) {
		this.trailer = trailer;
	}
	
	

}
