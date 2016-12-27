package br.com.abevieiramota.jsf.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("PU");

	public EntityManager getEntityManager() {
		return EMF.createEntityManager();
	}

}
