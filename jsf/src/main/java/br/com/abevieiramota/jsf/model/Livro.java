package br.com.abevieiramota.jsf.model;

import java.math.BigInteger;

public class Livro {
	private String titulo;
	private String isbn;
	private BigInteger preco;
	private String dataLancamento;

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
}