package database.model;

import java.util.Date;
import java.io.Serializable;

import database.dao.AlunosDAO;

public class Alunos implements Serializable{
	
	private static final long serialVersionUID = -5870304688930514247L;
	private Integer cdAluno;
	private String aluno;
	private Date dataNascimento;
	private String sexo;
	private double telefone;
	private double celular;
	private String email;
	private String observacao;
	private String endereco;
	private double numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String pais;
	private String cep;
	
	public Alunos () {
		setCdAluno(new AlunosDAO().getMax());
	}

	public Integer getCdAluno() {
		return cdAluno;
	}
	public void setCdAluno(Integer cdAluno) {
		this.cdAluno = cdAluno;
	}
	public String getAluno() {
		return aluno;
	}
	public void setAluno(String aluno) {
		this.aluno = aluno;
	}
	public Date getData_nascimento() {
		return dataNascimento;
	}
	public void setData_nascimento(Date data_nascimento) {
		this.dataNascimento = data_nascimento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public double getTelefone() {
		return telefone;
	}
	public void setTelefone(double telefone) {
		this.telefone = telefone;
	}
	public double getCelular() {
		return celular;
	}
	public void setCelular(double celular) {
		this.celular = celular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public double getNumero() {
		return numero;
	}
	public void setNumero(double numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public double getPais() {
		return pais;
	}
	public void setPais(double pais) {
		this.pais = pais;
	}
	public double getCep() {
		return cep;
	}
	public void setCep(double cep) {
		this.cep = cep;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		long temp;
		temp = Double.doubleToLongBits(celular);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(cep);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((cdAluno == null) ? 0 : cdAluno.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		temp = Double.doubleToLongBits(numero);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		temp = Double.doubleToLongBits(pais);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		temp = Double.doubleToLongBits(telefone);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Alunos other = (Alunos) obj;
		if (aluno == null) {
			if (other.aluno != null)
				return false;
		} else if (!aluno.equals(other.aluno))
			return false;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (Double.doubleToLongBits(celular) != Double.doubleToLongBits(other.celular))
			return false;
		if (Double.doubleToLongBits(cep) != Double.doubleToLongBits(other.cep))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (cdAluno == null) {
			if (other.cdAluno != null)
				return false;
		} else if (!cdAluno.equals(other.cdAluno))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (Double.doubleToLongBits(numero) != Double.doubleToLongBits(other.numero))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (Double.doubleToLongBits(pais) != Double.doubleToLongBits(other.pais))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		if (Double.doubleToLongBits(telefone) != Double.doubleToLongBits(other.telefone))
			return false;
		return true;
	}


	
}