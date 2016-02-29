package br.com.hdev.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Classe para objetos do tipo Agenda, onde serão contidos, valores e métodos
 * para o mesmo.
 * 
 * @author HDEV
 * @version 1.0
 * @deprecated
 */
@Entity
@Table(name = "TB_AGENDA")
@SequenceGenerator(name = "sqAgenda", sequenceName = "SQ_AGENDA", allocationSize = 1)
public class Agenda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sqAgenda")
	@Column(name = "cd_agenda")
	private int codigo;

	@OneToMany(mappedBy = "agenda")
	private List<Agendamento> agendamentos;

	@OneToOne
	private Medico medico;

	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

}