package br.com.hdev.session;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.hdev.entity.Medico;
import br.com.hdev.entity.Paciente;

/**
 * Classe respons�vel por gerenciar o retorno dos Objetos Paciente e M�dico como usu�rios da sess�o
 * @author HDEV
 *
 */
public class Session {
	
	public Paciente retornaPaciente(){
		
		HttpSession sessao = (HttpSession) FacesContext
				.getCurrentInstance().getExternalContext().getSession(true);

		return (Paciente) sessao.getAttribute("usuario");
	}
	
	public Medico retornaMedico(){
		
		HttpSession sessao = (HttpSession) FacesContext
				.getCurrentInstance().getExternalContext().getSession(true);

		return (Medico) sessao.getAttribute("usuario");
	}
}
