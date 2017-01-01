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

	public String gravarAutor() {
		Autor autorSelecionado = new DAO<>(Autor.class).find(this.autorId);

		this.livro.addAutor(autorSelecionado);

		atualizarLivros();

		return null;
	}

	public void removerAutorDoLivro(Autor autor) {
		this.livro.removerAutor(autor);
	}

	private void atualizarLivros() {
		this.livros = new DAO<>(Livro.class).all();
	}

	public RedirectView formAutor() {
		System.out.println("oi");
		return new RedirectView("/autor/cadastrar.xhtml");
	}

	public String gravar() {
		if (this.livro.getAutores().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage("autor",
					new FacesMessage("Livro deve ter pelo menos 1 autor."));
			return null;
		} else {
			if (this.livro.getId() == null) {
				new DAO<>(Livro.class).add(this.livro);
			} else {
				new DAO<>(Livro.class).update(this.livro);
			}

			this.livro = new Livro();

			atualizarLivros();

			return null;
		}
	}

	public void remover(Livro livroParaApagar) {
		System.out.println("Removendo livro");
		new DAO<>(Livro.class).remove(livroParaApagar);

		atualizarLivros();
	}

	public void comecaComDigitoUm(FacesContext fc, UIComponent component, Object value) throws ValidatorException {
		String valor = value.toString();
		if (!valor.startsWith("1")) {
			throw new ValidatorException(new FacesMessage("Deveria começar com 1."));
		}
	}
	
	public void setLivro(Livro livro) {
		this.livro = livro;
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
