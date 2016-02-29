package br.com.hdev.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe para objetos do tipo Consulta, onde serão contidos, valores e métodos
 * para o mesmo.
 * 
 * @author HDEV
 * @version 1.0
 */
@Entity
@Table(name = "TB_CONSULTA")
@SequenceGenerator(name = "seqConsulta", sequenceName = "SEQ_CONSULTA", allocationSize = 1)
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqConsulta")
	@Column(name = "cd_consulta")
	private int codigo;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_data")
	private Date data;

	@Temporal(TemporalType.TIME)
	@Column(name = "dt_hora")
	private Date hora;

	@ManyToOne
	private Paciente paciente;

	@ManyToOne
	private Medico medico;

	@OneToOne(cascade = CascadeType.ALL)
	private Agendamento agendamento;

	@OneToOne
	private Log log;

	public Log getLog() {
		return log;
	}

	public void setLog(Log log) {
		this.log = log;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Agendamento getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

}
