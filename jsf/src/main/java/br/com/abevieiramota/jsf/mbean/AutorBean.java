package br.com.abevieiramota.jsf.mbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.abevieiramota.jsf.dao.DAO;
import br.com.abevieiramota.jsf.model.Autor;

@ManagedBean
@ViewScoped
public class AutorBean {

	private Autor autor = new Autor();
	private List<Autor> autores;

	@PostConstruct
	public void postConstruct() {
		atualizarAutores();
	}

	private void atualizarAutores() {
		this.autores = new DAO<>(Autor.class).all();
	}

	public String gravar() {
		if (this.autor.getId() == null) {
			new DAO<>(Autor.class).add(this.autor);
		} else {
			new DAO<>(Autor.class).update(autor);
		}

		this.autor = new Autor();

		atualizarAutores();

		return "/livro/cadastrar.xhtml?faces-redirect=true";
	}

	public void remover(Autor autor) {
		new DAO<>(Autor.class).remove(autor);

		atualizarAutores();
	}

	public List<Autor> getAll() {
		return this.autores;
	}

	public Autor getAutor() {
		return autor;
	}

}
