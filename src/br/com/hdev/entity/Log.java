package br.com.hdev.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Classe para objetos do tipo Log, onde serão contidos, valores e métodos para
 * o mesmo.
 * 
 * @author HDEV
 * @version 1.0
 */

@Entity
@Table(name = "TB_LOG")
@SequenceGenerator(name = "seqLog", sequenceName = "SEQ_LOG", allocationSize = 1)
public class Log {

	@Id
	@GeneratedValue(generator = "seqLog", strategy = GenerationType.SEQUENCE)
	@Column(name = "cd_log")
	private int codigo;

	@Column(name = "ds_anamnese", nullable = false)
	private String anamnese;

	@Column(name = "ds_descricao")
	private String descricao;

	@OneToOne
	private Consulta consulta;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getAnamnese() {
		return anamnese;
	}

	public void setAnamnese(String anamnese) {
		this.anamnese = anamnese;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

}
