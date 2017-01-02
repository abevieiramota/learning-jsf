package br.com.abevieiramota.jsf.util;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.abevieiramota.jsf.model.Usuario;

public class Autorizador implements PhaseListener {
	@Override
	public void afterPhase(PhaseEvent event) {

		FacesContext fc = event.getFacesContext();
		String nomePagina = fc.getViewRoot().getViewId();

		System.out.println(nomePagina);

		if ("/login.xhtml".equals(nomePagina)) {
			return;
		}

		Usuario usuarioLogado = (Usuario) fc.getExternalContext().getSessionMap().get("usuarioLogado");

		if (usuarioLogado != null) {
			return;
		}

		NavigationHandler handler = fc.getApplication().getNavigationHandler();
		handler.handleNavigation(fc, null, "/login?faces-redirect=true");
		fc.renderResponse();
	}

	@Override
	public void beforePhase(PhaseEvent event) {
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
