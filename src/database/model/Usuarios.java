package database.model;

import java.io.Serializable;
import java.util.List;

import database.dao.UsuariosDAO;

public class Usuarios implements Serializable {

	private static final long serialVersionUID = 3699199325196816535L;
	private Integer cdUsuario;
	private String usuario;
	private String senha;
	private String perfil;

	private final transient String USUARIO_ADMIN = "admin";
	private final transient String SENHA_ADMIN = "admin";
	
	public Usuarios() {
		setCdUsuario(new UsuariosDAO().getMax());
	}
	
	public void setCdUsuario(Integer cdUsuario) {
		this.cdUsuario = cdUsuario;
	}

	public Integer getCdUsuario() {
		return cdUsuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cdUsuario;
		result = prime * result + ((perfil == null) ? 0 : perfil.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuarios other = (Usuarios) obj;
		if (cdUsuario != other.cdUsuario)
			return false;
		if (perfil == null) {
			if (other.perfil != null)
				return false;
		} else if (!perfil.equals(other.perfil))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	public boolean validarLogin(Usuarios usuarioLogin) {

		UsuariosDAO usuariosDAO = new UsuariosDAO();
		List<Usuarios> usuarios = usuariosDAO.consultar(false);

		if (usuarios == null || usuarios.isEmpty()) {

			return usuarioLogin.getUsuario().equals(USUARIO_ADMIN) && usuarioLogin.getSenha().equals(SENHA_ADMIN);

		} else {

			for (Usuarios usuario : usuarios) {
				if (usuarioLogin.getUsuario().equals(usuario.getUsuario())
						&& usuarioLogin.getSenha().equals(usuario.getSenha())) {
					return true;
				}
			}
		}

		return false;
	}

}
