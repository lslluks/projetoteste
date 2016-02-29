package br.com.hdev.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Classe para objetos do tipo Medico que se estende de Pessoa, onde serão
 * contidos, valores e métodos para o mesmo.
 * 
 * @author HDEV
 * @version 1.0
 */

@Entity
@Table(name = "TB_MEDICO")
@PrimaryKeyJoinColumn(name = "CD_PESSOA")
public class Medico extends Pessoa {

	@OneToMany(mappedBy = "medico")
	private List<Consulta> consultas;

	@Column(name = "ds_crm", nullable = false)
	private String crm;

	@Column(name = "ds_tipo_medico", nullable = false)
	private String tipo;

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
