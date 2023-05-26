
	
	package com.hibernate.dao;

	import org.hibernate.Session;
	import org.hibernate.Transaction;

	import com.hibernate.model.Oferta;
	import com.hibernate.util.HibernateUtil;

	public class OfertaDAO {
		
		/**
		 * Método público Oferta selectOfertaId utilizado para seleccionar las ofertas según su id
		 * @param id parámetro utilizado para seleccionar una oferta en concreto
		 * @return o
		 */
		public Oferta selectOfertaId(int id) {
			Transaction transaction = null;
		Oferta o = null;
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				transaction = session.beginTransaction();
				o = session.get(Oferta.class, id);
				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
			}
			return o;
		}
		
		/**
		 * Método público selectOfertaById de tipo double  utilizado para seleccionar la oferta por su id y además devolver la oferta
		 * @param id parámetro utilizado para seleccionar una oferta  en concreto
		 * @return value
		 */
		    public double selectOfertaById(int id) {
		        Transaction transaction = null;
		        double value = 0.0;
		        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		            transaction = session.beginTransaction();
		            Oferta oferta = session.get(Oferta.class, id);
		            if (oferta != null) {
		                value = oferta.getOferta(); 
		            }
		            transaction.commit();
		        } catch (Exception e) {
		            if (transaction != null) {
		                transaction.rollback();
		            }
		        }
		        return value;
		    }
		    
			
	}



