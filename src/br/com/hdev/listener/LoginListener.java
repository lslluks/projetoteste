package br.com.hdev.listener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

/**
 * Classe que herda de PhaseListener, que monitora e "ouve" as a��es efetuadas
 * nas p�ginas que utilizam a sess�o do login.
 * 
 * @author HDEV
 *
 */
public class LoginListener implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent arg0) {
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		FacesContext context = arg0.getFacesContext();
		
		/**Verifica a p�gina de destino do usu�rio*/
		String pagina = context.getViewRoot().getViewId();

		if (pagina.contains("paciente-cadastro")) {
			return;

		} else if (pagina.contains("medico-cadastro")) {
			return;
		}

		/** Recuperar a sess�o do usu�rio */
		HttpSession sessao = (HttpSession) context.getExternalContext()
				.getSession(false);

		/** Valida se o usu�rio n�o possui sess�o */
		if (sessao == null || sessao.getAttribute("paciente") == null
				|| sessao.getAttribute("medico") == null) {
			/** Redireciona para a tela de login */
			NavigationHandler navegacao = context.getApplication()
					.getNavigationHandler();
			navegacao.handleNavigation(context, null, "login");
		}

	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

}
