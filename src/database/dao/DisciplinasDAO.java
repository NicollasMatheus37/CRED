package database.dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import database.model.*;
import generic.DaoGeneric;
import lib.ArquivoManipular;

public class DisciplinasDAO extends DaoGeneric<Disciplinas>{
	
	public DisciplinasDAO() {
		setNomeArquivo("\\Disciplinas.DAT");
		consultar(true);
	}

	@Override
	public boolean salvar(Disciplinas modelo) {
		Disciplinas fase = existe(modelo);
		
		if(fase == null) {
			lista.add(modelo);
		} else {
			fase.setDiaSemana(modelo.getDiaSemana());
			fase.setCdDisciplina(modelo.getCdDisciplina());
			fase.setDiaSemana(modelo.getDiaSemana());
			fase.setProfessores(modelo.getProfessores());
		}
		return salvar();
	}

	@Override
	protected boolean salvar() {
		return ArquivoManipular.escreverArquivoSerializado(getLista(), getArquivo());
	}

	@Override
	public boolean excluir(Disciplinas modelo) {
		Disciplinas fase = existe(modelo);
		if(fase == null) return true;
		getLista().remove(fase);
		return salvar();
	}

	@Override
	public Disciplinas consultar(Disciplinas modelo) {
		return existe(modelo);
	}

	@Override
	public List<Disciplinas> consultar(boolean novo) {
		if(novo) {
			setLista();
		}
		return getLista();
	}

	@Override
	public Disciplinas existe(Disciplinas modelo) {
		if(getLista() == null || getLista().isEmpty()) return null;
		for(Disciplinas disciplina : getLista()) {
			if(modelo.getMatricula().equals(disciplina.getMatricula())) {
				return disciplina;
			}
		}
		return null;
	}

	@Override
	protected List<Disciplinas> getLista() {
		return lista;
	}

	@Override
	protected void setLista() {
		lista = (List<Disciplinas>) ArquivoManipular.lerArquivoSerializado(getArquivo());
		if(lista == null) lista = new ArrayList();
	}

	@Override
	public Integer getMax() {
		return lista.isEmpty() ? 1 : lista.stream().max(Comparator.comparing(Disciplinas::getCdDisciplina)).get().getCdDisciplina();
	}

}
