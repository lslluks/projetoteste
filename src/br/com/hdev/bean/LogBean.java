package br.com.hdev.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.hdev.dao.LogDAO;
import br.com.hdev.dao.impl.LogDAOImpl;
import br.com.hdev.entity.Log;
import br.com.hdev.exceptions.DBCommitException;
import br.com.hdev.singleton.EMFactorySingleton;

/**
 * 
 * Classe que se comunica com a entidade Log, responsável pelo seu cadastro.
 * 
 * @author HDEV
 * 
 */
@ManagedBean
@RequestScoped
public class LogBean implements Serializable {

	private Log log;
	private LogDAO dao;

	private int id;

	@PostConstruct
	private void init() {
		EntityManager em = EMFactorySingleton.getInstance();
		log = new Log();
		dao = new LogDAOImpl(em);
	}

	public void cadastrar() {
		FacesMessage msg;

		try {
			dao.create(log);
			msg = new FacesMessage("Cadastrado com Sucesso !");
		} catch (DBCommitException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro ao Cadastrar");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public Log getLog() {
		return log;
	}

	public void setLog(Log log) {
		this.log = log;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
