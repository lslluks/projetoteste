package br.com.hdev.entity;

import java.util.Calendar;

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
 * Classe para objetos do tipo Agendamento, onde serão contidos, valores e
 * métodos para o mesmo.
 * 
 * @author HDEV
 * @version 1.0
 */
@Entity
@Table(name = "TB_AGENDAMENTO")
@SequenceGenerator(name = "seqAgendamento", sequenceName = "SEQ_AGENDAMENTO", allocationSize = 1)
public class Agendamento {

	@Id
	@GeneratedValue(generator = "seqAgendamento", strategy = GenerationType.SEQUENCE)
	@Column(name = "cd_agendamento", nullable = false)
	private int codigo;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_agendamento", nullable = false)
	private Calendar data;

	@OneToOne
	private Consulta consulta;

	@ManyToOne
	private Agenda agenda;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}
}
