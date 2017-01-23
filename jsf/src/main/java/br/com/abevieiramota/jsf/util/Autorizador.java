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
		String paginaDestino = fc.getViewRoot().getViewId();

		System.out.println(paginaDestino);

		if ("/login.xhtml".equals(paginaDestino) || "/index.xhtml".equals(paginaDestino)) {
			return;
		}

		Usuario usuarioLogado = (Usuario) fc.getExternalContext().getSessionMap().get("usuarioLogado");

		if (usuarioLogado != null) {
			return;
		}
		
		fc.getExternalContext().getSessionMap().put("paginaDestino", paginaDestino);

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
