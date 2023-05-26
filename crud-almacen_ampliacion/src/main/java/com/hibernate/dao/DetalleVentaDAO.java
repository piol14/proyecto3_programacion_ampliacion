package com.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.DetalleVenta;
import com.hibernate.model.PedidoVenta;
import com.hibernate.model.Producto;
import com.hibernate.util.HibernateUtil;



/**
 *
 * Clase DetalleVentaDAO para poder realizar distintas acciones con la clase DetalleVenta
 *@author Mónica Alcañiz y Elena Ortega
 */

public class DetalleVentaDAO {
	
    /**
     * Método insertDetalleVenta público de tipo void utilizado para insertar pedidos
     * @param dv es el objeto que se utiliza para poder insertar un pedido en la base de datos
     */

	
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
    
    /**
     * Método updateDetalleVenta público de tipo void  utilizado para actualizar los pedidos
     * @param dv objeto que se utiliza para poder actualizar un objeto en concreto
     */

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

    /**
     * Método deleteDetalleVenta de tipo público y void utilizado para borrar un pedido por su id
     * @param id paraḿetro utilizado para poder identificar el pedido que queremos borrar
     */

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
	  /**
     * Método List<DetalleVenta> selectAllPedidos de tipo público utilizado para seleccionar todos los pedidos de la base de datos.
     * @return pedidos
     */

		public List<DetalleVenta> selectAllPedidos() {
			Transaction transaction = null;
			List<DetalleVenta> pedidos = null;
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				transaction = session.beginTransaction();
				pedidos = session.createQuery("FROM DetalleVenta", DetalleVenta.class).getResultList();
				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
			}
			return pedidos;
		}
		 
	   	 /**
	   	  * Método DetalleVenta selectDetalleVentaById utilizado para seleccionar un pedido según su id
	   	  * @param idDealleVenta parámetro utilizado para identificar el pedido que queremos seleccionar
	   	  * @return dv
	   	  */
		public DetalleVenta selectDetalleVentaById(int idDealleVenta) {
			Transaction transaction = null;
			DetalleVenta dv = null;
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				transaction = session.beginTransaction();
				dv = session.get(DetalleVenta.class, idDealleVenta);
				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
			}
			return dv;
		}
}
