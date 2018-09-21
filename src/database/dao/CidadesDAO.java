package database.dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import database.model.Cidades;
import generic.DaoGeneric;
import lib.ArquivoManipular;

public class CidadesDAO extends DaoGeneric<Cidades> {

	public CidadesDAO() {
		setNomeArquivo("\\Cidades.DAT");
		consultar(true);
	}

	@Override
	public boolean salvar(Cidades modelo) {
		
		Cidades cidade = existe(modelo);
		
		if (cidade == null) {
			
			lista.add(modelo);
			
		} else {

		}
		
		
		return salvar();
		
	}

	@Override
	public boolean excluir(Cidades modelo) {

		Cidades cidade = existe(modelo);
		
		if (cidade == null) return true;
		
		getLista().remove(cidade);
		
		return salvar();
	}

	@Override
	public Cidades consultar(Cidades modelo) {
		return existe(modelo);
	}

	@Override
	public List<Cidades> consultar(boolean novo) {

		if (novo) {

			setLista();

		}

		return getLista();

	}
	
	public List<Cidades> consultar(String uf){
	//	usuario -> usuario.getUsuario().equals(nmUsuario)
		
		return (List<Cidades>) getLista().stream().filter(cidade -> cidade.getEstado().equals(uf)).collect(Collectors.toList());
		
	}

	@Override
	protected List<Cidades> getLista() {
		return lista;
	}

	@Override
	protected void setLista() {
		lista = (List<Cidades>) ArquivoManipular.lerArquivoSerializado(getArquivo());
		
		if (lista == null) lista = new ArrayList();
	}

	@Override
	public Cidades existe(Cidades modelo) {
		
		if (getLista() == null || getLista().isEmpty()) return null;
		
		for (Cidades cidade : getLista()) {
			if (modelo.getCdCidade() == cidade.getCdCidade()) {
				return cidade;
			}
		}

		return null;
	}

	@Override
	protected boolean salvar() {
		return ArquivoManipular.escreverArquivoSerializado(getLista(), getArquivo());
	}

	@Override
	public Integer getMax() {
		return lista.isEmpty() ? 1 : lista.stream().max(Comparator.comparing(Cidades::getCdCidade)).get().getCdCidade() + 1;
	}


}
