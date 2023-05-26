package com.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Producto;
import com.hibernate.model.Usuario;
import com.hibernate.util.HibernateUtil;


public class UsuarioDAO {
	
/**
 * Método público insertUsuario de tipo void utilizado para insertar un Usuario
 * @param us parámetro pasado desde la clase App para poder insertar el usuario
 */
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
	
	/**
	 * Método público List<Usuario> selectAllUsuarios utilizado para seleccionar todos los usuarios de la base de datos
	 * @return usuarios que es una lista con todos los usuarios creados en la base de datos
	 */
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
	
	/**
	 * Método público updateUsuario de tipo void 
	 * @param u objeto pasado desde la calse producto que representa al usuario seleccionado
	 */

	public void updateUsuario(Usuario u) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.merge(u);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	/**
	 * Método público Usuario selectUsuarioById utilizado para seleccionar un usuario según su id
	 * @param id parámetro utilizado para seleccionar un usuario
	 * @return u un objeto de usuario
	 */
	public Usuario selectUsuarioByID(int id) {
		Transaction transaction = null;
		Usuario u = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			u = session.get(Usuario.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return u;
	}
	 /**
	  * Método público deleteUsuario de tipo void utilizado para borrar un usuario por su id
	  * @param id parámetro id utilizado para seleccionar un usuario
	  */
	public void deleteUsuario(int id) {
		Transaction transaction = null;
		Usuario u = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			u = session.get(Usuario.class, id);
			session.remove(u);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

}
