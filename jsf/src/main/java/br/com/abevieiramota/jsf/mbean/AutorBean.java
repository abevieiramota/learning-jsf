package br.com.abevieiramota.jsf.mbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.abevieiramota.jsf.dao.DAO;
import br.com.abevieiramota.jsf.model.Autor;

@ManagedBean
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
		new DAO<>(Autor.class).add(this.autor);

		this.autor = new Autor();

		atualizarAutores();

		return "/autor/listar.xhtml";
	}

	public List<Autor> getAll() {
		return this.autores;
	}

	public Autor getAutor() {
		return autor;
	}

}
