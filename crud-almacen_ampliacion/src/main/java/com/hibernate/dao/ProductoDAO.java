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

/**
 * Clase ProductoDAO utilizada para poder realizar distintas acciones en la clase producto
 * @author Mónica Alcañiz y Elena Ortega
 *
 */
public class ProductoDAO {

	/**
	 * Método público Producto selectProductoById utilizado para selccionar los productos según su id
	 * @param id utilizado para seleccionar un producto en concreto
	 * @return pr
	 */
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

/**
 * Método público insertProducto de tipo void utilizado para insertar un producto
 * @param pr representa el objeto que se va a insertar
 */
		
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

	/**
	 * Método público updateProducto de tipo void utilizado para actualizar los productos
	 * @param pr representa el objeto que se va a actualizar
	 */
		
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

	/**
	 * Método público deleteProducto de tipo void utilizado para borrar un producto según su id
	 * @param id utilizado para seleccionar un producto en concreto
	 */
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
		
	/**
	 * Método público List<Producto> selectAllProductos utilizado para seleccionar todos los productos de la base de datos
	 * @return productos
	 */
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
		
		/**
		 * Método público List<Producto> selectProductosByCategoria utilizado para seleccionar los productos según la categoria
		 * @param categoria objeto de la clase Categoria que representa la categoria seleccionada
		 * @return productos
		 */
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
/**
 * Método público List<Producto> selectProductosSinExistencias utilizado para seleccionar los productos de los que no quedan existencias
 * @return productos
 */
		public List<Producto> selectProductosSinExistencias() {
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
		
		
		/**
		 * Método List<Producto> selectProductoByfecha utilizado para selccionar un producto según su fecha de caducidad
		 * @param periodo objeto que representa el tiempo selecionado
		 * @return productos
		 */
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
		
		
/**
 * Metodo publico de la clase producto que selecciona los productos por su categoria y devuelve la lista de productos con esa categoria_id
 * @param id la id que selecciona el usuario
 * @return  productos
 */
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
	/**
	 * Metodo publico de la clase producto que selecciona los productos con una id, devuelve los productos con esa id 
	 * @param id la id que selecciona el usuario
	 * @return productos
	 */
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
		

