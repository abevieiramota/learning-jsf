package br.com.abevieiramota.jsf.mbean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Produto {

	private String produto = "Abelardo Vieira Mota";

	public String getProduto() {
		return produto;
	}
}
