package br.com.hdev.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Classe para objetos do tipo Bairro, onde serão contidos, valores e
 * métodos para o mesmo.
 * 
 * @author HDEV
 * @version 1.0
 */

@Entity
@Table(name = "TB_BAIRRO")
@SequenceGenerator(name = "seqBairro", sequenceName = "SEQ_BAIRRO", allocationSize = 1)
public class Bairro {

	@Id
	@GeneratedValue(generator = "seqBairro", strategy = GenerationType.SEQUENCE)
	@Column(name = "cd_bairro")
	private int codigo;

	@Column(name = "nm_bairro", nullable = false)
	private String nome;

	@OneToMany(mappedBy = "bairro")
	private List<Endereco> enderecos;

	@ManyToOne(cascade = CascadeType.ALL)
	private Cidade cidade;

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

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

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

}
