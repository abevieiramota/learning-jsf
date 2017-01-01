package br.com.abevieiramota.jsf.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Livro {

	@Id
	@GeneratedValue
	private Integer id;
	private String titulo;
	private String isbn;
	private BigInteger preco;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataLancamento = Calendar.getInstance();
	@ManyToMany(fetch = FetchType.EAGER)
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

	public Calendar getDataLancamento() {
		return this.dataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
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

	public void removerAutor(Autor autor) {
		this.autores.remove(autor);
	}
}