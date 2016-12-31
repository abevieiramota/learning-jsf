package br.com.abevieiramota.jsf.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import br.com.abevieiramota.jsf.model.Livro;

public class DAO<T> {

	private Class<T> clazz;

	public DAO(Class<T> clazz) {
		this.clazz = clazz;
	}

	public void add(T t) {
		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();

		em.persist(t);

		em.getTransaction().commit();

		em.close();
	}

	public List<T> all() {
		EntityManager em = new JPAUtil().getEntityManager();

		CriteriaQuery<T> cq = em.getCriteriaBuilder().createQuery(this.clazz);
		cq.from(this.clazz);

		List<T> all = em.createQuery(cq).getResultList();

		em.close();

		return all;
	}

	public T find(int id) {
		EntityManager em = new JPAUtil().getEntityManager();

		T entity = em.find(this.clazz, id);

		em.close();

		return entity;
	}

	public void remover(Livro livro) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();

		em.remove(em.merge(livro));
		
		em.getTransaction().commit();
		
		em.close();
	}

}
