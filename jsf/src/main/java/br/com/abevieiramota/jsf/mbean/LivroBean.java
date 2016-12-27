package br.com.abevieiramota.jsf.mbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.abevieiramota.jsf.dao.DAO;
import br.com.abevieiramota.jsf.model.Autor;
import br.com.abevieiramota.jsf.model.Livro;

@ManagedBean
@ViewScoped
public class LivroBean {

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

		return "livro/listar.xhtml";
	}

	private void atualizarLivros() {
		this.livros = new DAO<>(Livro.class).all();
	}

	public String gravar() {
		if (this.livro.getAutores().isEmpty()) {
			throw new RuntimeException("Livro deve ter pelo menos 1 autor");
		}

		new DAO<>(Livro.class).add(this.livro);

		this.livro = new Livro();

		atualizarLivros();

		return "/livro/listar.xhtml";
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
