package database.dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import database.model.Alunos;
import database.model.Cidades;
import database.model.Usuarios;
import generic.DaoGeneric;
import lib.ArquivoManipular;
import database.model.Cursos;

public class CursosDAO extends DaoGeneric<Cursos>{
	
	public CursosDAO() {
		setNomeArquivo("\\Cursos.DAT");
		consultar(true);
	}

	@Override
	public boolean salvar(Cursos modelo) {
		Cursos curso = existe(modelo);
		
		if(curso == null) {
			if(getLista().stream().filter(cur -> cur.getCdCurso().equals(modelo.getCdCurso())).collect(Collectors.toList()).size() != 0) {
				JOptionPane.showMessageDialog(null, "Já existe um registro com esse Curso");
				return false;
			}
			lista.add(modelo);
		} else {
			curso.setCdCurso(modelo.getCdCurso());
			curso.setNmCurso(modelo.getNmCurso());
		}
		return salvar();
	}

	@Override
	protected boolean salvar() {
		return ArquivoManipular.escreverArquivoSerializado(getLista(), getArquivo());
	}

	@Override
	public boolean excluir(Cursos modelo) {
		Cursos curso = existe(modelo);
		if(curso == null) return true;
		getLista().remove(curso);
		return salvar();
	}

	@Override
	public Cursos consultar(Cursos modelo) {
		return existe(modelo);
	}

	@Override
	public List<Cursos> consultar(boolean novo) {
		if(novo) {
			setLista();
		}
		return getLista();
	}

	@Override
	public Cursos existe(Cursos modelo) {
		if(getLista() == null || getLista().isEmpty()) return null;
		for(Cursos curso : getLista()) {
			if(modelo.getNmCurso().equals(curso.getNmCurso())) {
				return curso;
			}
		}
		return null;
	}

	@Override
	protected List<Cursos> getLista() {
		return lista;
	}

	@Override
	protected void setLista() {
		lista = (List<Cursos>) ArquivoManipular.lerArquivoSerializado(getArquivo());
		if(lista == null) lista = new ArrayList();
	}

	@Override
	public Integer getMax() {
		return lista.isEmpty() ? 1 : lista.stream().max(Comparator.comparing(Cursos::getCdCurso)).get().getCdCurso() + 1;
	}

}
