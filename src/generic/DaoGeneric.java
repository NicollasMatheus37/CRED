package generic;

import java.util.List;

import util.Util;

public abstract class DaoGeneric <ModeloGenerico> {
	
	protected List<ModeloGenerico> lista = null;
	private String nomeArquivo;
	
	public abstract boolean salvar(ModeloGenerico modelo); 
	protected abstract boolean salvar(); 
	public abstract boolean excluir(ModeloGenerico modelo); 
	public abstract ModeloGenerico consultar(ModeloGenerico modelo); 
	public abstract List<ModeloGenerico> consultar(boolean novo);
	public abstract ModeloGenerico existe(ModeloGenerico modelo);
	
	protected abstract List<ModeloGenerico> getLista();
	protected abstract void setLista();
	
	public String getNomeArquivo() {
		return nomeArquivo;
	}
	
	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	} 
	
	protected String getArquivo() {
		return new StringBuilder().append(Util.getDiretorioDados()).append(getNomeArquivo()).toString();
	}
	
	public abstract Integer getMax();	
	
}
