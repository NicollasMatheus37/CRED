package database.dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import database.model.*;
import generic.DaoGeneric;
import lib.ArquivoManipular;

public class FaseDAO extends DaoGeneric<Fases>{
	
	public FaseDAO() {
		setNomeArquivo("\\Fase.DAT");
		consultar(true);
	}

	@Override
	public boolean salvar(Fases modelo) {
		Fases fase = existe(modelo);
		
		if(fase == null) {
			if(getLista().stream().filter(fas -> fas.getCdFase().equals(modelo.getCdFase())).collect(Collectors.toList()).size() != 0) {
				JOptionPane.showMessageDialog(null, "Já existe um registro com essa Fase");
				return false;
			}
			lista.add(modelo);
		} else {
			fase.setCdFase(modelo.getCdFase());
			fase.setNrFase(modelo.getNrFase());
		}
		return salvar();
	}

	@Override
	protected boolean salvar() {
		return ArquivoManipular.escreverArquivoSerializado(getLista(), getArquivo());
	}

	@Override
	public boolean excluir(Fases modelo) {
		Fases fase = existe(modelo);
		if(fase == null) return true;
		getLista().remove(fase);
		return salvar();
	}

	@Override
	public Fases consultar(Fases modelo) {
		return existe(modelo);
	}

	@Override
	public List<Fases> consultar(boolean novo) {
		if(novo) {
			setLista();
		}
		return getLista();
	}

	@Override
	public Fases existe(Fases modelo) {
		if(getLista() == null || getLista().isEmpty()) return null;
		for(Fases fase : getLista()) {
			if(modelo.getCdFase().equals(fase.getCdFase())) {
				return fase;
			}
		}
		return null;
	}

	@Override
	protected List<Fases> getLista() {
		return lista;
	}

	@Override
	protected void setLista() {
		lista = (List<Fases>) ArquivoManipular.lerArquivoSerializado(getArquivo());
		if(lista == null) lista = new ArrayList();
	}

	@Override
	public Integer getMax() {
		return lista.isEmpty() ? 1 : lista.stream().max(Comparator.comparing(Fases::getCdFase)).get().getCdFase();
	}

}
