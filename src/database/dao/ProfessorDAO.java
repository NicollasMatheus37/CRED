package database.dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import database.model.*;
import generic.DaoGeneric;
import lib.ArquivoManipular;

public class ProfessorDAO extends DaoGeneric<Professores>{
	
	public ProfessorDAO() {
		setNomeArquivo("\\Professor.DAT");
		consultar(true);
	}

	@Override
	public boolean salvar(Professores modelo) {
		Professores professor = existe(modelo);
		
		if(professor == null) {
			if(getLista().stream().filter(prof -> prof.getCdProfessor().equals(modelo.getCdProfessor())).collect(Collectors.toList()).size() != 0) {
				JOptionPane.showMessageDialog(null, "Já existe um registro com esse Professor");
				return false;
			}
			lista.add(modelo);
		} else {
			professor.setCdProfessor(modelo.getCdProfessor());
			professor.setNmProfessor(modelo.getNmProfessor());
		}
		return salvar();
	}

	@Override
	protected boolean salvar() {
		return ArquivoManipular.escreverArquivoSerializado(getLista(), getArquivo());
	}

	@Override
	public boolean excluir(Professores modelo) {
		Professores professor = existe(modelo);
		if(professor == null) return true;
		getLista().remove(professor);
		return salvar();
	}

	@Override
	public Professores consultar(Professores modelo) {
		return existe(modelo);
	}

	@Override
	public List<Professores> consultar(boolean novo) {
		if(novo) {
			setLista();
		}
		return getLista();
	}

	@Override
	public Professores existe(Professores modelo) {
		if(getLista() == null || getLista().isEmpty()) return null;
		for(Professores professor : getLista()) {
			if(modelo.getCdProfessor().equals(professor.getCdProfessor())) {
				return professor;
			}
		}
		return null;
	}

	@Override
	protected List<Professores> getLista() {
		return lista;
	}

	@Override
	protected void setLista() {
		lista = (List<Professores>) ArquivoManipular.lerArquivoSerializado(getArquivo());
		if(lista == null) lista = new ArrayList();
		
	}

	@Override
	public Integer getMax() {
		return lista.isEmpty() ? 1 : lista.stream().max(Comparator.comparing(Professores::getCdProfessor)).get().getCdProfessor() + 1;
	}
}
