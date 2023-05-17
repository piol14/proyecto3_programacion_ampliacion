package com.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Categoria;
import com.hibernate.model.Producto;
import com.hibernate.util.HibernateUtil;

public class CategoriaDAO {
	
	//Seleccion multiple
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