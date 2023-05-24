
	
	package com.hibernate.dao;

	import org.hibernate.Session;
	import org.hibernate.Transaction;

	import com.hibernate.model.Oferta;
	import com.hibernate.util.HibernateUtil;

	public class OfertaDAO {
		
		//Seleccion simple por id
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
		
		//Seleccion simple de la oferta con la id 
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



