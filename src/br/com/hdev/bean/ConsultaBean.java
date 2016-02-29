package br.com.hdev.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.hdev.dao.ConsultaDAO;
import br.com.hdev.dao.MedicoDAO;
import br.com.hdev.dao.impl.ConsultaDAOImpl;
import br.com.hdev.dao.impl.MedicoDAOImpl;
import br.com.hdev.entity.Agendamento;
import br.com.hdev.entity.Consulta;
import br.com.hdev.entity.Medico;
import br.com.hdev.exceptions.DBCommitException;
import br.com.hdev.session.Session;
import br.com.hdev.singleton.EMFactorySingleton;

/**
 * @author HDEV Classe que se comunica com a entidade Consulta.
 *
 */
@ManagedBean
@RequestScoped
public class ConsultaBean implements Serializable {

	private Consulta consulta;
	private ConsultaDAO dao;
	private Session session;
	private List<Medico> medicos;
	private MedicoDAO medicoDAO;
	private int codigo;

	@PostConstruct
	private void init() {
		EntityManager em = EMFactorySingleton.getInstance();

		dao = new ConsultaDAOImpl(em);
		consulta = new Consulta();
		session = new Session();

		Agendamento agendamento = new Agendamento();
		agendamento.setData(Calendar.getInstance());
		consulta.setAgendamento(agendamento);

		setMedicos(new ArrayList<Medico>());

		medicoDAO = new MedicoDAOImpl(em);
		medicos = medicoDAO.listar();
	}

	/**
	 * Método para cadastro de uma nova consulta, utilizando da sessão para
	 * retornar o paciente que cadastrou-a e de uma busca por código para
	 * relaciona-la a um tipo de médico específico.
	 */
	public void cadastrar() {
		FacesMessage msg;

		try {
			consulta.setMedico(medicoDAO.findById(codigo));
			consulta.setPaciente(session.retornaPaciente());
			dao.create(consulta);
			msg = new FacesMessage("Cadastrado com Sucesso !");

		} catch (DBCommitException e) {

			e.printStackTrace();
			msg = new FacesMessage("Erro ao Cadastrar");
		}

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
