package br.com.hdev.bean;

import java.io.Serializable;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.hdev.dao.MedicoDAO;
import br.com.hdev.dao.impl.MedicoDAOImpl;
import br.com.hdev.entity.Bairro;
import br.com.hdev.entity.Cidade;
import br.com.hdev.entity.Endereco;
import br.com.hdev.entity.Estado;
import br.com.hdev.entity.Medico;
import br.com.hdev.exceptions.DBCommitException;
import br.com.hdev.session.Session;
import br.com.hdev.singleton.EMFactorySingleton;

/**
 * 
 * Classe responsável pela comunicação com a entidade Medico e por suas
 * funcionalidades na página.
 * 
 * @author HDEV
 * 
 */
@ManagedBean
@RequestScoped
public class MedicoBean implements Serializable {

	private Medico medico;
	private MedicoDAO dao;
	private Session session;

	@PostConstruct
	private void init() {
		EntityManager em = EMFactorySingleton.getInstance();

		dao = new MedicoDAOImpl(em);
		medico = new Medico();

		medico.setDtaNascimento(Calendar.getInstance());

		session = new Session();
		System.out.println(session.retornaMedico());

		Endereco endereco = new Endereco();
		Bairro bairro = new Bairro();
		Cidade cidade = new Cidade();
		Estado estado = new Estado();

		cidade.setEstado(estado);
		bairro.setCidade(cidade);
		endereco.setBairro(bairro);

		medico.setEndereco(endereco);

	}

	public void cadastrar() {
		FacesMessage msg;

		try {
			dao.create(medico);
			msg = new FacesMessage("Cadastrado com Sucesso !");

		} catch (DBCommitException e) {

			e.printStackTrace();
			msg = new FacesMessage("Erro ao Cadastrar");
		}

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}
