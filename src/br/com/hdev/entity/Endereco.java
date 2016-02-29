package br.com.hdev.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Classe para objetos do tipo Endereco, onde serão contidos, valores e métodos
 * para o mesmo.
 * 
 * @author HDEV
 * @version 1.0
 */
@Entity
@Table(name = "TB_ENDERECO")
@SequenceGenerator(name = "seqEndereco", sequenceName = "SEQ_ENDERECO", allocationSize = 1)
public class Endereco {

	@Id
	@GeneratedValue(generator = "seqEndereco", strategy = GenerationType.SEQUENCE)
	@Column(name = "cd_endereco")
	private int codigo;

	@Column(name = "vl_numero", nullable = false)
	private int numero;

	@Column(name = "ds_logradouro", nullable = false)
	private String logradouro;

	@Column(name = "ds_complemento")
	private String complemento;

	@ManyToOne(cascade = CascadeType.ALL)
	private Bairro bairro;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

}
