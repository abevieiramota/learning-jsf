package br.com.abevieiramota.jsf.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.abevieiramota.jsf.model.Usuario;

public class UsuarioDao {

	public boolean existe(Usuario usuario) {
		EntityManager em = new JPAUtil().getEntityManager();

		TypedQuery<Usuario> query = em
				.createQuery("SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha", Usuario.class);
		query.setParameter("email", usuario.getEmail());
		query.setParameter("senha", usuario.getSenha());

		try {
			query.getSingleResult();

			return true;
		} catch (NoResultException e) {
			return false;
		} finally {
			em.close();
		}
	}

}
