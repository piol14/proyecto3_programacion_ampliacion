package com.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.hibernate.model.PedidoVenta;
import com.hibernate.util.HibernateUtil;

/***
 *
 * Clase PedidoVentaDAO utilizado para realizar distintas acciones con la clase
 * PedidoVenta
 * 
 * @author Mónica Alcañiz y Elena Ortega
 *
 */

public class PedidoVentaDAO {

	/**
	 * Método público insertPedidoVenta de tipo void utilizado para insertar pedidos
	 * 
	 * @param pv objeto utilizado para poder insertar un pedido
	 */

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

	


}
