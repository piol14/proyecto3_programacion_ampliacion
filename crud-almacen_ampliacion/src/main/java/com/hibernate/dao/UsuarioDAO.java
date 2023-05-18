package com.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Producto;
import com.hibernate.model.Usuario;
import com.hibernate.util.HibernateUtil;


public class UsuarioDAO {
	
	
	public void insertUsuario(Usuario us) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.persist(us);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	public List<Usuario> selectAllUsuarios() {
		Transaction transaction = null;
		List<Usuario> usuarios = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			usuarios = session.createQuery("FROM Usuario",Usuario.class).getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return usuarios ;
	}
}
