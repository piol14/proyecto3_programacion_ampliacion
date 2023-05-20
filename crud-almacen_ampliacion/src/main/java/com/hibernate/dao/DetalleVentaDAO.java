package com.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.DetalleVenta;
import com.hibernate.util.HibernateUtil;

public class DetalleVentaDAO {
	
	//Insercion
	
	public void insertDetalleVenta(DetalleVenta dv) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.persist(dv);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
//Actualizacion
	
	public void updateDetalleVenta(DetalleVenta dv) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.merge(dv);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	//Eliminar
	public void deleteDetalleVenta(int id) {
		Transaction transaction = null;
		DetalleVenta dv = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			dv = session.get(DetalleVenta.class, id);
			session.remove(dv);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

}
