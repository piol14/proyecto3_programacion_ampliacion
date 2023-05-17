package com.hibernate.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.model.Categoria;
import com.hibernate.model.Oferta;
import com.hibernate.model.Producto;
import com.hibernate.util.HibernateUtil;

public class ProductoDAO {

	
	// Selección simple
		public Producto selectProductoById(int id) {
			Transaction transaction = null;
			Producto pr = null;
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				transaction = session.beginTransaction();
				pr = session.get(Producto.class, id);
				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
			}
			return pr;
		}

		//Insercion
		
		public void insertProducto(Producto pr) {
			Transaction transaction = null;
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				transaction = session.beginTransaction();
				session.persist(pr);
				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
			}
		}
	//Actualizacion
		
		public void updateProducto(Producto pr) {
			Transaction transaction = null;
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				transaction = session.beginTransaction();
				session.merge(pr);
				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
			}
		}

		//Eliminar
		public void deleteProducto(int id) {
			Transaction transaction = null;
			Producto pr = null;
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				transaction = session.beginTransaction();
				pr = session.get(Producto.class, id);
				session.remove(pr);
				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
			}
		}
		
		//Seleccion multiple
		public List<Producto> selectAllProductos() {
			Transaction transaction = null;
			List<Producto> productos = null;
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				transaction = session.beginTransaction();
				productos = session.createQuery("FROM Producto", Producto.class).getResultList();
				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
			}
			return productos;
		}
		
		public List<Producto> selectProductoByCategoria (Categoria categoria) {
			Transaction transaction = null;
			List<Producto> productos= null;
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				transaction = session.beginTransaction();
				Query<Producto> query=session.createQuery("FROM Producto WHERE categoria = :categoriaParam",Producto.class);
				query.setParameter("categoriaParam", categoria);
				 productos=query.getResultList();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
			}
			return productos;
		}

		public List<Producto> selectProductosSinStock() {
		    Transaction transaction = null;
		    List<Producto> productos = null;
		    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		        transaction = session.beginTransaction();
		        productos = session.createQuery("FROM Producto WHERE  existencias = 0", Producto.class).getResultList();
		        transaction.commit();
		    } catch (Exception e) {
		        if (transaction != null) {
		            transaction.rollback();
		        }
		    }
		    return productos;
		}
		
		public List<Producto> selectProductoByfecha(Period periodo) {
		    Transaction transaction = null;
		    List<Producto> productos = null;
		    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		        transaction = session.beginTransaction();
		        LocalDate fechaInicio = LocalDate.now().plus(periodo);
		        Query<Producto> query = session.createQuery("FROM Producto WHERE fecha_caducidad = :fechaParam", Producto.class);
		        query.setParameter("fechaParam", fechaInicio);
		        productos = query.getResultList();
		    } catch (Exception e) {
		        if (transaction != null) {
		            transaction.rollback();
		        }
		    }
		    return productos;
		}
		public List<Producto> selectProductosPorCategoria(String nombreCategoria) {
		    Transaction transaction = null;
		    List<Producto> productos = null;

		    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		        transaction = session.beginTransaction();
		        Query<Producto> query = session.createQuery("FROM Producto p JOIN p.categoria c WHERE c.nombre = :nombreCategoria", Producto.class);
		        query.setParameter("nombreCategoria", nombreCategoria);
		        productos = query.getResultList();
		        transaction.commit();
		    } catch (Exception e) {
		        if (transaction != null) {
		            transaction.rollback();
		        }
		        e.printStackTrace();
		    }

		    return productos;
		}
		public List<Producto> selectProductosPorCategoriaID (int id) {
		    Transaction transaction = null;
		    List<Producto> productos = null;

		    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		        transaction = session.beginTransaction();
		        Query<Producto> query = session.createQuery("FROM Producto WHERE categoria_id = :id", Producto.class);
		        query.setParameter("id", id);
		        productos = query.getResultList();
		        transaction.commit();
		    } catch (Exception e) {
		        if (transaction != null) {
		            transaction.rollback();
		        }
		        e.printStackTrace();
		    }

		    return productos;
		}
		
		public List<Producto> selectProductoByOfertaByID (int id) {
			Transaction transaction = null;
			List<Producto> productos= null;
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				transaction = session.beginTransaction();
				Query<Producto> query=session.createQuery("FROM Producto  WHERE oferta_idoferta= :id",Producto.class);
				query.setParameter("id", id);
				 productos=query.getResultList();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
			}
			return productos;
		}
}
		

