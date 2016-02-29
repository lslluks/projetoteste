package br.com.hdev.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe que realiza a herança para as classes Médico e Paciente.
 * 
 * @author HDEV
 * @version 1.0
 */

@Entity
@Table(name = "TB_PESSOA")
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name = "seqPessoa", sequenceName = "SEQ_PESSOA", allocationSize = 1)
public abstract class Pessoa {

	@Id
	@GeneratedValue(generator = "seqPessoa", strategy = GenerationType.SEQUENCE)
	@Column(name = "CD_PESSOA")
	private int codigo;

	@Column(name = "ds_nome", nullable = false)
	private String nome;

	@Column(name = "ds_login", nullable = false)
	private String login;

	@Column(name = "ds_senha", nullable = false)
	private String senha;

	@Column(name = "ds_sexo", nullable = false)
	private String sexo;

	@Column(name = "ds_rg", nullable = false)
	private String rg;

	@Column(name = "ds_telefone")
	private String telefone;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_nascimento")
	private Calendar dtaNascimento;

	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Calendar getDtaNascimento() {
		return dtaNascimento;
	}

	public void setDtaNascimento(Calendar dtaNascimento) {
		this.dtaNascimento = dtaNascimento;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}