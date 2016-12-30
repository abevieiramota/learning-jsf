package br.com.abevieiramota.jsf.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

@SuppressWarnings("serial")
public class LogPhaseListener implements PhaseListener {
	
	/*
	 * Primeiro GET:
	 * 	RESTORE_VIEW
	 * 	RENDER_RESPONSE
	 * 
	 * Todas as fases:
	 * 	RESTORE_VIEW
	 * 	APPLY_REQUEST_VALUES
	 * 	PROCESS_VALIDATIONS
	 * 	>> se ok: UPDATE_MODEL_VALUES
	 * 	>> se ok: INVOKE_APPLICATION
	 * 	RENDER_RESPONSE
	 */
	
	@Override
	public void afterPhase(PhaseEvent event) {
		System.out.println("Fim da fase: " + event.getPhaseId());
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		System.out.println("Início da fase: " + event.getPhaseId());
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
