package br.com.abevieiramota.jsf.mbean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class AppBean {

	private Integer valor = 10;
	private Integer[] indexed = {1, 2, 3};

	public Integer getValor() {
		System.out.println("Pegou appBean.valor");
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public Integer[] getIndexed() {
		return indexed;
	}

}
