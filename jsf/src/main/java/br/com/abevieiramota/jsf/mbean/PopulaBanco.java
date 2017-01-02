package br.com.abevieiramota.jsf.mbean;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.com.abevieiramota.jsf.dao.DAO;
import br.com.abevieiramota.jsf.model.Autor;
import br.com.abevieiramota.jsf.model.Livro;

@ManagedBean(eager = true)
@ApplicationScoped
public class PopulaBanco {

	@PostConstruct
	public void populaBanco() {
		Autor autor1 = new Autor();
		autor1.setNome("Abelardo");
		autor1.setEmail("abevieiramota@gmail.com");

		Autor autor2 = new Autor();
		autor2.setNome("Lovecraft");
		autor2.setEmail("lovecraft@gmail.com");

		DAO<Autor> autorDao = new DAO<>(Autor.class);
		autorDao.add(autor1);
		autorDao.add(autor2);

		Livro livro1 = new Livro();
		livro1.setDataLancamento(parseData("10/10/2012"));
		livro1.setIsbn("1234");
		livro1.setPreco(new BigInteger("100"));
		livro1.setTitulo("A hora da verdade");
		livro1.addAutor(autor1);

		Livro livro2 = new Livro();
		livro2.setDataLancamento(parseData("23/02/2016"));
		livro2.setIsbn("1233");
		livro2.setPreco(new BigInteger("450"));
		livro2.setTitulo("O poder do agora");
		livro2.addAutor(autor2);

		DAO<Livro> livroDao = new DAO<>(Livro.class);
		livroDao.add(livro1);
		livroDao.add(livro2);
	}

	private static DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	private static Calendar parseData(String data) {
		try {
			Date date = df.parse(data);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar;
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}
}
