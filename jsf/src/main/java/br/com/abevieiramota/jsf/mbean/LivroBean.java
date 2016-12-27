package br.com.abevieiramota.jsf.mbean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.abevieiramota.jsf.dao.DAO;
import br.com.abevieiramota.jsf.model.Livro;

@ManagedBean
public class LivroBean {

	@PostConstruct
	public void postConstruct() {
		System.out.println("Cabei de ser criado: " + this.getClass().getName());
	}

	private Livro livro = new Livro();

	public void gravar() {
		new DAO<>().add(this.livro);

		this.livro = new Livro();
	}

	public Livro getLivro() {
		return this.livro;
	}
}
