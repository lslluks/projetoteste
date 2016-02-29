package br.com.hdev.listener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

/**
 * Classe que herda de PhaseListener, que monitora e "ouve" as ações efetuadas
 * nas páginas que utilizam a sessão do login.
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
		
		/**Verifica a página de destino do usuário*/
		String pagina = context.getViewRoot().getViewId();

		if (pagina.contains("paciente-cadastro")) {
			return;

		} else if (pagina.contains("medico-cadastro")) {
			return;
		}

		/** Recuperar a sessão do usuário */
		HttpSession sessao = (HttpSession) context.getExternalContext()
				.getSession(false);

		/** Valida se o usuário não possui sessão */
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
