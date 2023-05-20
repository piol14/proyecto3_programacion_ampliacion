package com.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.hibernate.model.PedidoVenta;
import com.hibernate.model.Producto;
import com.hibernate.util.HibernateUtil;

public class PedidoVentaDAO {
	
	public void insertPedidoVenta(PedidoVenta pv) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.persist(pv);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
//Actualizacion
	
	public void updatePedidoVenta(PedidoVenta pv) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.merge(pv);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	//Eliminar
	public void deletePedidoVenta(int id) {
		Transaction transaction = null;
		PedidoVenta pv = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			pv = session.get(PedidoVenta.class, id);
			session.remove(pv);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	//Seleccion multiple
	public List<PedidoVenta> selectAllPedidos() {
		Transaction transaction = null;
		List<PedidoVenta> pedidos = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			pedidos = session.createQuery("FROM PedidoVenta", PedidoVenta.class).getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return pedidos;
	}
	

	
	

}
