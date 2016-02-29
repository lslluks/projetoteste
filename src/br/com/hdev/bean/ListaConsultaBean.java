package br.com.hdev.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.hdev.dao.ConsultaDAO;
import br.com.hdev.dao.impl.ConsultaDAOImpl;
import br.com.hdev.entity.Consulta;
import br.com.hdev.session.Session;
import br.com.hdev.singleton.EMFactorySingleton;

/**
 * 
 * Classe responsável pela listagem e exclusão de Consultas
 * 
 * @author HDEV
 *
 */

@ManagedBean
@ViewScoped
public class ListaConsultaBean implements Serializable {

	private ConsultaDAO dao;

	private List<Consulta> lista;

	private int codigo;

	private Session session;

	@PostConstruct
	private void init() {
		EntityManager em = EMFactorySingleton.getInstance();
		dao = new ConsultaDAOImpl(em);
		session = new Session();

		/** Carregar as consultas de acordo com o tipo do médico que está logado no sistema.*/
		//lista = dao.listarPorTipoDeMedico(session.retornaMedico().getTipo());
		
		/** Carregar as consultas de acordo com o médico que está logado no sistema.*/
		lista = dao.listarPorNome(session.retornaMedico().getNome());
	}

	public void excluir() {
		FacesMessage msg;
		try {
			dao.delete(codigo);
			System.out.println(codigo);
			msg = new FacesMessage("Excluido!");
			/** Atualiza a Lista após deletar um item*/
			lista = dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro...");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public List<Consulta> getLista() {
		return lista;
	}

	public void setLista(List<Consulta> lista) {
		this.lista = lista;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}