package com.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Categoria;
import com.hibernate.model.Producto;
import com.hibernate.util.HibernateUtil;

/**
 *
 * @author Mónica Alcañiz y Elena Ortega Clase CategoriaDAO utilizada para poder
 *         realizar acciones con la clase Categoria
 *
 */

public class CategoriaDAO {
	/**
	 * Método público List<Categoria> selectAllCategoria Este método es utilizado
	 * para leer todas las categorias guardas en la base de datos
	 * 
	 * @return categorias 
	 */

	public List<Categoria> selectAllCategoria() {
		Transaction transaction = null;
		List<Categoria> categorias = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			categorias = session.createQuery("FROM Categoria", Categoria.class).getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return categorias;
	}

	/**
	 * Método público Categoria selectCategoriaById para seleccionar las categorias
	 * segun su id
	 * 
	 * @param id utilizado para identificar la categoria
	 * @return cg
	 */
	public Categoria selectCategoriaById(int id) {
		Transaction transaction = null;
		Categoria cg = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			cg = session.get(Categoria.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return cg;
	}

}