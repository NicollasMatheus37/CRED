package database.dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import database.model.Alunos;
import database.model.Usuarios;
import generic.DaoGeneric;
import lib.ArquivoManipular;

public class UsuariosDAO extends DaoGeneric<Usuarios> {

	public UsuariosDAO() {
		setNomeArquivo("\\Usuarios.DAT");
		consultar(true);
	}

	@Override
	public boolean salvar(Usuarios modelo) {
		
		Usuarios usuario = existe(modelo);
		
		if (usuario == null) {
			
			if (getLista().stream().filter(usu -> usu.getUsuario().equals(modelo.getUsuario())).collect(Collectors.toList()).size() != 0) {
				JOptionPane.showMessageDialog(null, "Já existe um registro com esse 'Usuário'");
				return false;
			} 	
			
			lista.add(modelo);
						
		} else {
			usuario.setPerfil(modelo.getPerfil());
			usuario.setUsuario(modelo.getUsuario());
			usuario.setSenha(modelo.getSenha());
		}
				
		return salvar();
		
	}

	@Override
	public boolean excluir(Usuarios modelo) {

		Usuarios usuario = existe(modelo);
		
		if (usuario == null) return true;
		
		getLista().remove(usuario);
		
		return salvar();
	}

	@Override
	public Usuarios consultar(Usuarios modelo) {
		return existe(modelo);
	}

	@Override
	public List<Usuarios> consultar(boolean novo) {

		if (novo) {

			setLista();

		}

		return getLista();

	}

	@Override
	protected List<Usuarios> getLista() {
		return lista;
	}

	@Override
	protected void setLista() {
		lista = (List<Usuarios>) ArquivoManipular.lerArquivoSerializado(getArquivo());
		
		if (lista == null) lista = new ArrayList();
	}

	@Override
	public Usuarios existe(Usuarios modelo) {
		
		if (getLista() == null || getLista().isEmpty()) return null;
		
		for (Usuarios usuario : getLista()) {
			if (modelo.getCdUsuario().equals(usuario.getCdUsuario())) {
				return usuario;
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
		return lista.isEmpty() ? 1 : lista.stream().max(Comparator.comparing(Usuarios::getCdUsuario)).get().getCdUsuario() + 1;
	}


}
