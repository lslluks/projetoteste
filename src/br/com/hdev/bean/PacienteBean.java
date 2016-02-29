package br.com.hdev.bean;

import java.io.Serializable;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.hdev.dao.PacienteDAO;
import br.com.hdev.dao.impl.PacienteDAOImpl;
import br.com.hdev.entity.Bairro;
import br.com.hdev.entity.Cidade;
import br.com.hdev.entity.Endereco;
import br.com.hdev.entity.Estado;
import br.com.hdev.entity.Paciente;
import br.com.hdev.exceptions.DBCommitException;
import br.com.hdev.singleton.EMFactorySingleton;

/**
 * 
 * Classe que efetua a comunicação com a entidade Paciente e suas
 * funcionalidades em página
 * 
 * @author HDEV
 * 
 */
@ManagedBean
@RequestScoped
public class PacienteBean implements Serializable {

	private Paciente paciente;
	private PacienteDAO dao;

	@PostConstruct
	private void init() {
		EntityManager em = EMFactorySingleton.getInstance();

		dao = new PacienteDAOImpl(em);
		paciente = new Paciente();

		paciente.setDtaNascimento(Calendar.getInstance());

		Endereco endereco = new Endereco();
		Bairro bairro = new Bairro();
		Cidade cidade = new Cidade();
		Estado estado = new Estado();

		cidade.setEstado(estado);
		bairro.setCidade(cidade);
		endereco.setBairro(bairro);

		paciente.setEndereco(endereco);

	}

	public void cadastrar() {
		FacesMessage msg;

		try {
			dao.create(paciente);
			msg = new FacesMessage("Cadastrado com Sucesso !");

		} catch (DBCommitException e) {

			e.printStackTrace();
			msg = new FacesMessage("Erro ao Cadastrar");
		}

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	// GET'S SET'S

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}
