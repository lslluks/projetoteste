package br.com.hdev.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Classe para objetos do tipo Estado, onde serão contidos, valores e métodos
 * para o mesmo.
 * 
 * @author HDEV
 * @version 1.0
 */

@Entity
@Table(name = "TB_ESTADO")
@SequenceGenerator(name = "seqEstado", sequenceName = "SEQ_ESTADO", allocationSize = 1)
public class Estado {

	@Id
	@GeneratedValue(generator = "seqEstado", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Column(name = "ds_estado", nullable = false)
	private String nome;

	@OneToMany(mappedBy = "estado")
	private List<Cidade> cidades;

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

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
}
