package br.com.hdev.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.hdev.dao.AgendaDAO;
import br.com.hdev.dao.impl.AgendaDAOImpl;
import br.com.hdev.entity.Agenda;
import br.com.hdev.singleton.EMFactorySingleton;

/**
 * 
 * @author HDEV Classe responsável pela comunicação com a classe Agenda.
 * @deprecated
 */
@ManagedBean
@ViewScoped
public class AgendaBean implements Serializable {

	private AgendaDAO dao;

	private List<Agenda> lista;

	private int codigo; // Remoção

	private String logradouro; // Mapa

	@PostConstruct
	private void init() {
		EntityManager em = EMFactorySingleton.getInstance();

		dao = new AgendaDAOImpl(em);

		lista = dao.listar();

	}

	/**
	 * 
	 * método para exclusão de uma agenda.
	 */
	public void excluir() {
		FacesMessage msg;
		try {
			dao.delete(codigo);
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

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

}
