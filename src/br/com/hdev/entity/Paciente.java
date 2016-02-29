package br.com.hdev.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Classe para objetos do tipo Paciente que se estende de Pessoa, onde serão
 * contidos, valores e métodos para o mesmo.
 * 
 * @author HDEV
 * @version 1.0
 */

@Entity
@Table(name = "TB_PACIENTE")
@PrimaryKeyJoinColumn(name = "CD_PESSOA")
public class Paciente extends Pessoa {

	@Column(name = "ds_cpf", nullable = false)
	private String cpf;
	
	@Column(name = "ds_convenio", nullable = false)
	private String convenio;

	@Column(name = "ds_tipo_convenio", nullable = false)
	private String tipoConvenio;

	@OneToMany(mappedBy = "paciente")
	private List<Consulta> consultas;

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getConvenio() {
		return convenio;
	}

	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}

	public String getTipoConvenio() {
		return tipoConvenio;
	}

	public void setTipoConvenio(String tipoConvenio) {
		this.tipoConvenio = tipoConvenio;
	}

}