package database.dao.importation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import database.model.importation.Header;
import generic.DaoGeneric;
import lib.ArquivoManipular;

public class HeaderDAO extends DaoGeneric<Header> {

	public HeaderDAO() {
		setNomeArquivo("\\ArquivoHistorico.DAT");
		consultar(true);
	}
	
	@Override
	public boolean salvar(Header modelo) {
		Header header = existe(modelo);
		
		if (header == null) {
			
			lista.add(modelo);
			
		} else {
			
			header.setCurso(modelo.getCurso());
			header.setDataProcessamento(modelo.getDataProcessamento());
			header.setPeriodoFinal(modelo.getPeriodoFinal());
			header.setPeriodoInicial(modelo.getPeriodoInicial());
			header.setSequencia(modelo.getSequencia());
			header.setTipoRegistro(modelo.getTipoRegistro());
			header.setVersaoLayout(modelo.getVersaoLayout());
			
		}
		
		
		return salvar();
	}

	@Override
	protected boolean salvar() {
		return ArquivoManipular.escreverArquivoSerializado(getLista(), getArquivo());
	}

	@Override
	public boolean excluir(Header modelo) {
		Header Aluno = existe(modelo);
		
		if (Aluno == null) return true;
		
		getLista().remove(Aluno);
		
		return salvar();
	}

	@Override
	public Header consultar(Header modelo) {
		return existe(modelo);
	}

	@Override
	public List<Header> consultar(boolean novo) {
		if (novo) {

			setLista();

		}

		return getLista();
	}

	@Override
	public Header existe(Header modelo) {
		if (getLista() == null || getLista().isEmpty())
			return null;

		for (Header header : getLista()) {
			if (modelo.getSequencia() == header.getSequencia()) {
				return header;
			}
		}
		return null;
	}

	@Override
	protected List<Header> getLista() {
		return lista;
	}

	@Override
	protected void setLista() {
		lista = (List<Header>) ArquivoManipular.lerArquivoSerializado(getArquivo());

		if (lista == null)
			lista = new ArrayList();
		
	}

	@Override
	public Integer getMax() {
		return lista.isEmpty() ? 1
				: lista.stream().max(Comparator.comparing(Header::getSequencia)).get().getSequencia();
	}

}
