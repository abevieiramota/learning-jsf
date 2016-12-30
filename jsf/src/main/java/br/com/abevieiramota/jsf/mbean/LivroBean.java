package br.com.abevieiramota.jsf.mbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.com.abevieiramota.jsf.dao.DAO;
import br.com.abevieiramota.jsf.model.Autor;
import br.com.abevieiramota.jsf.model.Livro;
import br.com.abevieiramota.jsf.util.RedirectView;

@ManagedBean
@ViewScoped
public class LivroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Livro> livros;
	private int autorId;
	private Livro livro = new Livro();

	@PostConstruct
	public void postConstruct() {
		atualizarLivros();
	}

	public void gravarAutor() {
		Autor autorSelecionado = new DAO<>(Autor.class).find(this.autorId);

		this.livro.addAutor(autorSelecionado);

		atualizarLivros();
	}

	private void atualizarLivros() {
		this.livros = new DAO<>(Livro.class).all();
	}

	public RedirectView	 formAutor() {
		System.out.println("oi");
		return new RedirectView("/autor/cadastrar.xhtml");
	}

	public void gravar() {
		if (this.livro.getAutores().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage("autor",
					new FacesMessage("Livro deve ter pelo menos 1 autor."));
		} else {
			new DAO<>(Livro.class).add(this.livro);

			this.livro = new Livro();

			atualizarLivros();
		}
	}

	public void comecaComDigitoUm(FacesContext fc, UIComponent component, Object value) throws ValidatorException {
		String valor = value.toString();
		if (!valor.startsWith("1")) {
			throw new ValidatorException(new FacesMessage("Deveria começar com 1."));
		}
	}

	public Livro getLivro() {
		return this.livro;
	}

	public List<Livro> getAll() {
		return this.livros;
	}

	public int getAutorId() {
		return autorId;
	}

	public void setAutorId(int autorId) {
		this.autorId = autorId;
	}
}
