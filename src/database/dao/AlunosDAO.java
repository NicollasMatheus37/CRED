package database.dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import database.model.Alunos;
import database.model.Usuarios;
import generic.DaoGeneric;
import lib.ArquivoManipular;

public class AlunosDAO extends DaoGeneric<Alunos> {

	public AlunosDAO() {
		setNomeArquivo("\\Alunos.DAT");
		consultar(true);
	}

	@Override
	public boolean salvar(Alunos modelo) {
		
		Alunos aluno = existe(modelo);
		
		if (aluno == null) {
			
			lista.add(modelo);
			
		} else {
			
			aluno.setAluno(modelo.getAluno());
			aluno.setBairro(modelo.getBairro());
			aluno.setCelular(modelo.getCelular());
			aluno.setCep(modelo.getCep());
			aluno.setCidade(modelo.getCidade());
			aluno.setComplemento(modelo.getComplemento());
			aluno.setDataNascimento(modelo.getDataNascimento());
			aluno.setEmail(modelo.getEmail());
			aluno.setEndereco(modelo.getEndereco());
			aluno.setNumero(modelo.getNumero());
			aluno.setObservacao(modelo.getObservacao());
			aluno.setCidade(modelo.getCidade());
			aluno.setSexo(modelo.getSexo());
			aluno.setTelefone(modelo.getTelefone());
		}
		
		
		return salvar();
		
	}

	@Override
	public boolean excluir(Alunos modelo) {

		Alunos Aluno = existe(modelo);
		
		if (Aluno == null) return true;
		
		getLista().remove(Aluno);
		
		return salvar();
	}

	@Override
	public Alunos consultar(Alunos modelo) {
		return existe(modelo);
	}
	public List<Alunos> consultar(Integer CdAluno){
		//	usuario -> usuario.getUsuario().equals(nmUsuario)
			
			return (List<Alunos>) getLista().stream().filter(aluno -> aluno.getCdAluno().equals(CdAluno)).collect(Collectors.toList());
			
		}
		public List<Alunos> consultar(String nmAluno){
			//	usuario -> usuario.getUsuario().equals(nmUsuario)
				
				return (List<Alunos>) getLista().stream().filter(aluno -> aluno.getAluno().toLowerCase().contains(nmAluno.toLowerCase())).collect(Collectors.toList());
				
			}

	@Override
	public List<Alunos> consultar(boolean novo) {

		if (novo) {

			setLista();

		}

		return getLista();

	}

	@Override
	protected List<Alunos> getLista() {
		return lista;
	}

	@Override
	protected void setLista() {
		lista = (List<Alunos>) ArquivoManipular.lerArquivoSerializado(getArquivo());
		
		if (lista == null) lista = new ArrayList();
	}

	@Override
	public Alunos existe(Alunos modelo) {
		
		if (getLista() == null || getLista().isEmpty()) return null;
		
		for (Alunos aluno : getLista()) {
			if (modelo.getCdAluno().equals(aluno.getCdAluno())) {
				return aluno;
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
		return lista.isEmpty() ? 1 : lista.stream().max(Comparator.comparing(Alunos::getCdAluno)).get().getCdAluno() + 1;
	}


}
