package br.com.hdev.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;

import br.com.hdev.dao.PacienteDAO;
import br.com.hdev.dao.impl.PacienteDAOImpl;
import br.com.hdev.entity.Paciente;
import br.com.hdev.singleton.EMFactorySingleton;

/**
 * 
 * Classe responsável para listagem de Pacientes e efetuar o autocomplete.
 * 
 * @author HDEV
 * 
 */
@ManagedBean
@RequestScoped
public class ListaPacienteBean {

	private PacienteDAO dao;

	private Paciente paciente;

	private List<Paciente> lista;

	/**
	 * String que recebe o input do usuário na pagina
	 */
	private String nomeBusca;

	@PostConstruct
	private void init() {
		EntityManager em = EMFactorySingleton.getInstance();
		dao = new PacienteDAOImpl(em);

		lista = dao.listar();
	}

	public void buscar() {
		lista = dao.buscarPorNome(nomeBusca);
	}

	public List<String> completarNome(String nome) {
		return dao.autoCompletePorNome(nome);
	}

	public String getNomeBusca() {
		return nomeBusca;
	}

	public void setNomeBusca(String nomeBusca) {
		this.nomeBusca = nomeBusca;
	}

	public List<Paciente> getLista() {
		return lista;
	}

	public void setLista(List<Paciente> lista) {
		this.lista = lista;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}
