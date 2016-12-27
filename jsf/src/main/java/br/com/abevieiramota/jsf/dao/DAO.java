package br.com.abevieiramota.jsf.dao;

import javax.persistence.EntityManager;

public class DAO<T> {

	public void add(T t) {
		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();

		em.persist(t);

		em.getTransaction().commit();

		em.close();
	}

}
