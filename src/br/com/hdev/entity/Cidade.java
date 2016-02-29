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
 * Classe para objetos do tipo Cidade, onde serão contidos, valores e métodos
 * para o mesmo.
 * 
 * @author HDEV
 * @version 1.0
 */
@Entity
@Table(name = "TB_CIDADE")
@SequenceGenerator(name = "seqCidade", sequenceName = "SEQ_CIDADE", allocationSize = 1)
public class Cidade {

	@Id
	@GeneratedValue(generator = "seqCidade", strategy = GenerationType.SEQUENCE)
	@Column(name = "cd_cidade")
	private int codigo;

	@Column(name = "nm_cidade")
	private String nome;

	@OneToMany(mappedBy = "cidade")
	private List<Bairro> bairros;

	@ManyToOne(cascade = CascadeType.ALL)
	private Estado estado;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
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

	public List<Bairro> getBairros() {
		return bairros;
	}

	public void setBairros(List<Bairro> bairros) {
		this.bairros = bairros;
	}

}
