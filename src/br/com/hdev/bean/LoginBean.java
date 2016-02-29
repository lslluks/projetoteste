package br.com.hdev.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import br.com.hdev.dao.MedicoDAO;
import br.com.hdev.dao.PacienteDAO;
import br.com.hdev.dao.impl.MedicoDAOImpl;
import br.com.hdev.dao.impl.PacienteDAOImpl;
import br.com.hdev.entity.Medico;
import br.com.hdev.entity.Paciente;
import br.com.hdev.singleton.EMFactorySingleton;

/**
 * 
 * Classe que monitora e gerencia a sess�o dos logins e logouts efetuados no
 * sistema.
 * 
 * @author HDEV
 * 
 */
@ManagedBean
@RequestScoped
public class LoginBean {

	private PacienteDAO pacienteDAO;
	private MedicoDAO medicoDAO;
	private Paciente paciente;
	private Medico medico;

	private String login;
	private String senha;

	@PostConstruct
	private void init() {
		EntityManager em = EMFactorySingleton.getInstance();
		pacienteDAO = new PacienteDAOImpl(em);
		medicoDAO = new MedicoDAOImpl(em);
	}

	public String sair() {
		/**Recupera a Sess�o do Usu�rio*/
		HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		/**Invalida a Sess�o*/
		sessao.invalidate();
		/**Redireciona para a P�gina login.xhtml */
		return "login";
	}

	public String logar() {
		System.out.println("1");
		/**Criar uma sess�o para o Paciente */
		if (pacienteDAO.logar(login, senha)) {
			System.out.println("2");
			
			/**Busca o Paciente pelo login e senha*/
			paciente = pacienteDAO.buscarPorLogin(login, senha);

			HttpSession sessao = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext().getSession(true);
			
			/**Adiciona um atributo na sess�o (Paciente)*/
			sessao.setAttribute("usuario", paciente);
			
			/**Redireciona para a P�gina paciente-perfil.xhtml */
			return "paciente-perfil";
		} else {
			/**Criar uma sess�o para o M�dico */
			if (medicoDAO.logar(login, senha)) {
				System.out.println("3");
				
				/**Busca o M�dico pelo login e senha*/
				medico = medicoDAO.buscarPorLogin(login, senha);

				HttpSession sessao = (HttpSession) FacesContext
						.getCurrentInstance().getExternalContext()
						.getSession(true);
				
				/**Adiciona um atributo na sess�o (M�dico)*/
				sessao.setAttribute("usuario", medico);
				
				/**Redireciona para a P�gina medico-perfil.xhtml */
				return "medico-perfil";
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage("Login e/ou senha inv�lidos"));
				return "login";
			}
		}
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
}
