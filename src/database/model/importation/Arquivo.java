package database.model.importation;

import java.util.List;

//odeio essa merda de merge conflict
public class Arquivo {
	private List<Header> header;
	private List<ResumoOperacao> resumos;
	private List<Trailer> trailer;
	
	public List<Header> getHeader() {
		return header;
	}
	public void setHeader(List<Header> header) {
		this.header = header;
	}
	public List<ResumoOperacao> getResumos() {
		return resumos;
	}
	public void setResumos(List<ResumoOperacao> resumos) {
		this.resumos = resumos;
	}
	public List<Trailer> getTrailer() {
		return trailer;
	}
	public void setTrailer(List<Trailer> trailer) {
		this.trailer = trailer;
	}
	
	

}
