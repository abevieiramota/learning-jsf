package br.com.abevieiramota.jsf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Autor {

	@Id
	@GeneratedValue
	private Integer id;
	private String nome;
	private String email;

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		System.out.println("Setando nome");
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		System.out.println("Setando email");
		this.email = email;
	}
}
