package br.com.hdev.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.hdev.dao.AgendaDAO;
import br.com.hdev.dao.impl.AgendaDAOImpl;
import br.com.hdev.entity.Agenda;
import br.com.hdev.singleton.EMFactorySingleton;

/**
 * 
 * Classe responsável para listagem de Agenda
 * 
 * @author HDEV
 * @deprecated
 */

@ManagedBean
@RequestScoped
public class ListaAgendaBean implements Serializable {

	private AgendaDAO dao;

	private List<Agenda> lista;

	private int codigo;

	@PostConstruct
	private void init() {
		EntityManager em = EMFactorySingleton.getInstance();
		dao = new AgendaDAOImpl(em);

		lista = dao.listar();

	}

	public void excluir() {
		FacesMessage msg;
		try {
			dao.delete(getCodigo());
			msg = new FacesMessage("Excluido!");
			lista = dao.listar(); // Atualizar a tabela...
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro..");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public List<Agenda> getLista() {
		return lista;
	}

	public void setLista(List<Agenda> lista) {
		this.lista = lista;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
