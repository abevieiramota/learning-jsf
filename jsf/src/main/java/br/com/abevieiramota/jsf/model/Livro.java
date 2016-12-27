package br.com.abevieiramota.jsf.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Livro {

	@Id
	@GeneratedValue
	private Integer id;
	private String titulo;
	private String isbn;
	private BigInteger preco;
	private String dataLancamento;
	@ManyToMany
	private List<Autor> autores = new ArrayList<Autor>();

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public BigInteger getPreco() {
		return this.preco;
	}

	public void setPreco(BigInteger preco) {
		this.preco = preco;
	}

	public String getDataLancamento() {
		return this.dataLancamento;
	}

	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Integer getId() {
		return id;
	}

	public void addAutor(Autor autor) {
		this.autores.add(autor);
	}
	
	public List<Autor> getAutores() {
		return Collections.unmodifiableList(this.autores);
	}
}