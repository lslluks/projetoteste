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
 * Classe que monitora e gerencia a sessão dos logins e logouts efetuados no
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
		/**Recupera a Sessão do Usuário*/
		HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		/**Invalida a Sessão*/
		sessao.invalidate();
		/**Redireciona para a Página login.xhtml */
		return "login";
	}

	public String logar() {
		System.out.println("1");
		/**Criar uma sessão para o Paciente */
		if (pacienteDAO.logar(login, senha)) {
			System.out.println("2");
			
			/**Busca o Paciente pelo login e senha*/
			paciente = pacienteDAO.buscarPorLogin(login, senha);

			HttpSession sessao = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext().getSession(true);
			
			/**Adiciona um atributo na sessão (Paciente)*/
			sessao.setAttribute("usuario", paciente);
			
			/**Redireciona para a Página paciente-perfil.xhtml */
			return "paciente-perfil";
		} else {
			/**Criar uma sessão para o Médico */
			if (medicoDAO.logar(login, senha)) {
				System.out.println("3");
				
				/**Busca o Médico pelo login e senha*/
				medico = medicoDAO.buscarPorLogin(login, senha);

				HttpSession sessao = (HttpSession) FacesContext
						.getCurrentInstance().getExternalContext()
						.getSession(true);
				
				/**Adiciona um atributo na sessão (Médico)*/
				sessao.setAttribute("usuario", medico);
				
				/**Redireciona para a Página medico-perfil.xhtml */
				return "medico-perfil";
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage("Login e/ou senha inválidos"));
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
