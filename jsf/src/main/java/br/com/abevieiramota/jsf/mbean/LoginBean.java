package br.com.abevieiramota.jsf.mbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.abevieiramota.jsf.dao.UsuarioDao;
import br.com.abevieiramota.jsf.model.Usuario;

@ManagedBean
@ViewScoped
public class LoginBean {

	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return this.usuario;
	}

	public String efetuarLogin() {

		boolean usuarioExiste = new UsuarioDao().existe(this.usuario);

		FacesContext fc = FacesContext.getCurrentInstance();

		if (usuarioExiste) {
			fc.getExternalContext().getSessionMap().put("usuarioLogado", this.usuario);

			Object paginaDestino = fc.getExternalContext().getSessionMap().remove("paginaDestino");

			return paginaDestino + "?faces-redirect=true";
		}

		// como faz um redirect, perde a mensagem
		// código para manter as mensagens por mais uma request
		fc.getExternalContext().getFlash().setKeepMessages(true);
		fc.addMessage(null, new FacesMessage("Usuário não encontrado"));

		return "login?faces-redirect=true";
	}

	public String deslogar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.getExternalContext().getSessionMap().remove("usuarioLogado");

		// FIXME: não redireciona para login... mantém na mesma página, retorna código 200
		return "login?faces-redirect=true";
	}
}
