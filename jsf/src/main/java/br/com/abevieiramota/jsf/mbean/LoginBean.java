package br.com.abevieiramota.jsf.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.abevieiramota.jsf.dao.UsuarioDao;
import br.com.abevieiramota.jsf.model.Usuario;
import br.com.abevieiramota.jsf.util.RedirectView;

@ManagedBean
@ViewScoped
public class LoginBean {

	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return this.usuario;
	}

	public RedirectView efetuarLogin() {

		boolean usuarioExiste = new UsuarioDao().existe(this.usuario);
		
		if (usuarioExiste) {
			return new RedirectView("livro/cadastrar");
		}

		return null;
	}
}
