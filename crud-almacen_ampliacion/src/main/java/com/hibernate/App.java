         //Monica Alcañiz y Elena Ortega

package com.hibernate;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.hibernate.dao.CategoriaDAO;
import com.hibernate.dao.OfertaDAO;
import com.hibernate.dao.ProductoDAO;
import com.hibernate.model.Categoria;
import com.hibernate.model.Oferta;
import com.hibernate.model.Producto;

import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;

public class App {

	static final int LONGITUD_BTN_GUARDAR = 18;
	static final int ALTURA_BTN_GUARDAR = 18;

	static final int LONGITUD_BTN_ACTUALIZAR = 20;
	static final int ALTURA_BTN_ACTUALIZAR = 20;

	static final int LONGITUD_BTN_BORRAR = 20;
	static final int ALTURA_BTN_BORRAR = 20;

	static ProductoDAO productoDAO = new ProductoDAO();
	CategoriaDAO categoriaDAO = new CategoriaDAO();
	static OfertaDAO ofertaDAO = new OfertaDAO();
	

	private JFrame frameAlmacen;
	private JTable tableProductos;
	private JTable tablePedidos;
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTextField txtStock;
	static  LocalDate ultimaFechaEjecucion;

	ButtonGroup g1 = new ButtonGroup();
	private JTextField textFieldNombreProveedor;
	private JTextField textFieldCantidad;
	private JTextField textFieldPrecioPedido;
	
	 static double ComprobarOferta (Producto producto)
	 {
		 LocalDate hoy = LocalDate.now();
		 ultimaFechaEjecucion =LocalDate.now();
		    DayOfWeek semana = hoy.getDayOfWeek();
		    int numeroSemana = semana.getValue();
		    Categoria categoria = producto.getCategoria();
		    List<Producto> productosCategoria = productoDAO.selectProductoByCategoria(categoria);
	switch(numeroSemana)
	{
	 case 1:
	        	
	            for(  Producto pr :productosCategoria)
	            {
		          if (pr.getCategoria().getIdCategoria()==1){
		                double precioConDescuentoBebidas = pr.getPrecio() * ofertaDAO.selectOfertaById(2);
		               double precioFinal= pr.getPrecio() - precioConDescuentoBebidas;
		             double precioFinalRedondeado = Math.round(precioFinal*100.0)/100.0;
		             pr.setPrecio(precioFinalRedondeado);
		             productoDAO.updateProducto(pr);
		               
		           
		            
		          }else if  (pr.getCategoria().getIdCategoria()==9) {
		                double precioConDescuentoCongelados = pr.getPrecio() * ofertaDAO.selectOfertaById(8);
		                double precioFinal2= pr.getPrecio() - precioConDescuentoCongelados;
		                double precioFinalRedondeado = Math.round(precioFinal2*100.0)/100.0;
		                pr.setPrecio(precioFinalRedondeado);
		                productoDAO.updateProducto(pr);
		              
		          }
		          else {
		        	  if(producto.getOferta().getIdOferta()!=1)
		        	  {
		        	  double precioOriginal = pr.getPrecio() / ofertaDAO.selectOfertaById(pr.getOferta().getIdOferta());
		              double precioOriginalRedondeado = Math.round(precioOriginal * 100.0) / 100.0;
		              pr.setPrecio(precioOriginalRedondeado);
		              productoDAO.updateProducto(pr);
		        	  }
		          }
	            }
	        
	            break;
	            
	        case 2:
	        	 for(  Producto pr :productosCategoria)
		            {
	        	if (pr.getCategoria().getIdCategoria()==8){
	                double precioConDescuentoPescado = pr.getPrecio() * ofertaDAO.selectOfertaById(14);
	               double precioFinal= pr.getPrecio() - precioConDescuentoPescado;
	             double precioFinalRedondeado = Math.round(precioFinal*100.0)/100.0;
	             pr.setPrecio(precioFinalRedondeado);
	             productoDAO.updateProducto(pr);
	        	}
	        	else {
	        		  if(producto.getOferta().getIdOferta()!=1)
		        	  {
		        	  double precioOriginal = pr.getPrecio() / ofertaDAO.selectOfertaById(pr.getOferta().getIdOferta());
		              double precioOriginalRedondeado = Math.round(precioOriginal * 100.0) / 100.0;
		              pr.setPrecio(precioOriginalRedondeado);
		              productoDAO.updateProducto(pr);
		        	  }
	          }
		            }
	        	
	        	break;
	        	
	        case 3:
	        	
	        	 for(  Producto pr :productosCategoria)
		            {  
	          if (pr.getCategoria().getIdCategoria()==10){
	                double precioConDescuentoLimpieza = pr.getPrecio() * ofertaDAO.selectOfertaById(3);
	               double precioFinal= pr.getPrecio() - precioConDescuentoLimpieza;
	             double precioFinalRedondeado = Math.round(precioFinal*100.0)/100.0;
	             pr.setPrecio(precioFinalRedondeado);
	             productoDAO.updateProducto(pr);
	          
	              
	            
	          }else if  (pr.getCategoria().getIdCategoria()==4) {
	                double precioConDescuentoLacteos = pr.getPrecio() * ofertaDAO.selectOfertaById(16);
	                double precioFinal2= pr.getPrecio() - precioConDescuentoLacteos;
	                double precioFinalRedondeado = Math.round(precioFinal2*100.0)/100.0;
	                pr.setPrecio(precioFinalRedondeado);
	                productoDAO.updateProducto(pr);
	              
	          }
	          else {
	        	  if(producto.getOferta().getIdOferta()!=1)
	        	  {
	        	  double precioOriginal = pr.getPrecio() / ofertaDAO.selectOfertaById(pr.getOferta().getIdOferta());
	              double precioOriginalRedondeado = Math.round(precioOriginal * 100.0) / 100.0;
	              pr.setPrecio(precioOriginalRedondeado);
	              productoDAO.updateProducto(pr);
		            }
	          }
		            }
	            break;
	        case 4:
	        	 for(  Producto pr :productosCategoria)
		            {
	        	if (pr.getCategoria().getIdCategoria()==7){
	                double precioConDescuentoFrutasyVerduras = pr.getPrecio() * ofertaDAO.selectOfertaById(7);
	               double precioFinal= pr.getPrecio() - precioConDescuentoFrutasyVerduras;
	             double precioFinalRedondeado = Math.round(precioFinal*100.0)/100.0;
	             pr.setPrecio(precioFinalRedondeado);
	             productoDAO.updateProducto(pr);
	        	}
	                else {
	                	  if(producto.getOferta().getIdOferta()!=1)
			        	  {
			        	  double precioOriginal = pr.getPrecio() / ofertaDAO.selectOfertaById(pr.getOferta().getIdOferta());
			              double precioOriginalRedondeado = Math.round(precioOriginal * 100.0) / 100.0;
			              pr.setPrecio(precioOriginalRedondeado);
			              productoDAO.updateProducto(pr);
	                }
	                }
	            
	          }
		            
	        	break;
	        	
	        case 5:
	        	 for(  Producto pr :productosCategoria)
		            {
	        	 if (pr.getCategoria().getIdCategoria()==2){
		                double precioConDescuentoCondimentos = pr.getPrecio() * ofertaDAO.selectOfertaById(8);
		               double precioFinal= producto.getPrecio() - precioConDescuentoCondimentos;
		             double precioFinalRedondeado = Math.round(precioFinal*100.0)/100.0;
		             pr.setPrecio(precioFinalRedondeado);
		             productoDAO.updateProducto(pr);
		            
		            
		          }else if  (pr.getCategoria().getIdCategoria()==3) {
		                double precioConDescuentoReposteria = pr.getPrecio() * ofertaDAO.selectOfertaById(10);
		                double precioFinal2= pr.getPrecio() - precioConDescuentoReposteria;
		                double precioFinalRedondeado = Math.round(precioFinal2*100.0)/100.0;
		                pr.setPrecio(precioFinalRedondeado);
		                productoDAO.updateProducto(pr);
		             
		               
		          }
		          else {
		        	  if(producto.getOferta().getIdOferta()!=1)
		        	  {
		        	  double precioOriginal = pr.getPrecio() / ofertaDAO.selectOfertaById(pr.getOferta().getIdOferta());
		              double precioOriginalRedondeado = Math.round(precioOriginal * 100.0) / 100.0;
		              pr.setPrecio(precioOriginalRedondeado);
		              productoDAO.updateProducto(pr);
		        	  }
		          }
		            }
		            
	        	break;
	        	
	        case 6:
	        	 for(  Producto pr :productosCategoria)
		            {
	        	 if (pr.getCategoria().getIdCategoria()==5){
		                double precioConDescuentoLimpieza = pr.getPrecio() * ofertaDAO.selectOfertaById(11);
		               double precioFinal= pr.getPrecio() - precioConDescuentoLimpieza;
		             double precioFinalRedondeado = Math.round(precioFinal*100.0)/100.0;
		             pr.setPrecio(precioFinalRedondeado);
		             productoDAO.updateProducto(pr);
		             
		          }
	        	 else {
	        		  if(producto.getOferta().getIdOferta()!=1)
		        	  {
		        	  double precioOriginal = pr.getPrecio() / ofertaDAO.selectOfertaById(pr.getOferta().getIdOferta());
		              double precioOriginalRedondeado = Math.round(precioOriginal * 100.0) / 100.0;
		              pr.setPrecio(precioOriginalRedondeado);
		              productoDAO.updateProducto(pr);
               }
	        	 }
		            }
	        	break;
	        	
	        case 7:
	        	 for(  Producto pr :productosCategoria)
		            {
	        	 if (pr.getCategoria().getIdCategoria()==6){
		                double precioConDescuentoLimpieza = pr.getPrecio() * ofertaDAO.selectOfertaById(12);
		               double precioFinal= pr.getPrecio() - precioConDescuentoLimpieza;
		             double precioFinalRedondeado = Math.round(precioFinal*100.0)/100.0;
		                pr.setPrecio(precioFinalRedondeado);
		                productoDAO.updateProducto(pr);
		              
		          }
	        	 else {
	        		  if(producto.getOferta().getIdOferta()!=1)
		        	  {
		        	  double precioOriginal = producto.getPrecio() / ofertaDAO.selectOfertaById(producto.getOferta().getIdOferta());
		              double precioOriginalRedondeado = Math.round(precioOriginal * 100.0) / 100.0;
		              pr.setPrecio(precioOriginalRedondeado);
		              productoDAO.updateProducto(pr);
		        	  }
	        	 }
		            
		            }
	        break;
	    }

	    return producto.getPrecio();
	}  
		    
		    
		  
		 
	 
	static int MostrarIdOferta(Producto producto1)
	{
		
		 LocalDate hoy = LocalDate.now();
		    DayOfWeek semana = hoy.getDayOfWeek();
		    int numeroSemana = semana.getValue();

		    
		     int idOferta = 1;
		    

		    // Aplicar las ofertas en función del día de la semana
		    switch (numeroSemana) {
		       
		        case 1:
		        	
		            
			          if (producto1.getCategoria().getIdCategoria()==1){
			               idOferta =2;
			          
			               
			         
			                
			            
			          }else if  (producto1.getCategoria().getIdCategoria()==9) {
			        	idOferta =8;
			           
			               
			          }
			          
		            break;
		            
		        case 2:
		        	if (producto1.getCategoria().getIdCategoria()==8){
		        		  idOferta = 14;
			             
		            
		          }
		        
		        	
		        	break;
		        	
		        case 3:
		        	
		               
		          if (producto1.getCategoria().getIdCategoria()==10){
		        	  idOferta=3;
		             
		          
		          
		            
		          }else if  (producto1.getCategoria().getIdCategoria()==4) {
		        	  idOferta=16;
		             
		          }
		            
		      
		            break;
		        case 4:
		        	
		        	if (producto1.getCategoria().getIdCategoria()==7){
		        		idOferta=7;
			          
		              
		            
		          }
		        
		        	break;
		        	
		        case 5:
		        	
		        	 if (producto1.getCategoria().getIdCategoria()==2){
		        		 idOferta=8;
			              
			            
			          }else if  (producto1.getCategoria().getIdCategoria()==3) {
			        	  idOferta=10;
			           
			             
			               
			          }
			        
		        	break;
		        	
		        case 6:
		        	 if (producto1.getCategoria().getIdCategoria()==5){
		        		 Oferta oferta = ofertaDAO.selectOfertaId(11);
		        		 producto1.setOferta(oferta);
			         
			            
			          }
		        
		        	break;
		        	
		        case 7:
		        	 if (producto1.getCategoria().getIdCategoria()==6){
		        		idOferta=12;
			            
			            
			          }
		        	
		        	
		        break;
		        default:
		        
				    
				    	idOferta=1;
			       
				    
	        break;
		        	
		    }
		    producto1.setOferta(ofertaDAO.selectOfertaId(idOferta));
		    
		    return producto1.getOferta().getIdOferta();
		}
		
	static double CalcularOferta(Producto producto) {
	      LocalDate hoy = LocalDate.now();
	    DayOfWeek semana = hoy.getDayOfWeek();
	    int numeroSemana = semana.getValue();

	    

	    // Aplicar las ofertas en función del día de la semana
	    switch (numeroSemana) {
	       
	        case 1:
	        	
	            
		          if (producto.getCategoria().getIdCategoria()==1){
		                double precioConDescuentoBebidas = producto.getPrecio() * ofertaDAO.selectOfertaById(2);
		               double precioFinal= producto.getPrecio() - precioConDescuentoBebidas;
		             double precioFinalRedondeado = Math.round(precioFinal*100.0)/100.0;
		                producto.setPrecio(precioFinalRedondeado);
		               
		                
		            
		          }else if  (producto.getCategoria().getIdCategoria()==9) {
		                double precioConDescuentoCongelados = producto.getPrecio() * ofertaDAO.selectOfertaById(8);
		                double precioFinal2= producto.getPrecio() - precioConDescuentoCongelados;
		                double precioFinalRedondeado = Math.round(precioFinal2*100.0)/100.0;
		                producto.setPrecio(precioFinalRedondeado);
		              
		          }
	        
	            break;
	            
	        case 2:
	        	if (producto.getCategoria().getIdCategoria()==8){
	                double precioConDescuentoPescado = producto.getPrecio() * ofertaDAO.selectOfertaById(14);
	               double precioFinal= producto.getPrecio() - precioConDescuentoPescado;
	             double precioFinalRedondeado = Math.round(precioFinal*100.0)/100.0;
	                producto.setPrecio(precioFinalRedondeado);
	                
	            
	          }
	        	
	        	
	        	break;
	        	
	        case 3:
	        	
	               
	          if (producto.getCategoria().getIdCategoria()==10){
	                double precioConDescuentoLimpieza = producto.getPrecio() * ofertaDAO.selectOfertaById(3);
	               double precioFinal= producto.getPrecio() - precioConDescuentoLimpieza;
	             double precioFinalRedondeado = Math.round(precioFinal*100.0)/100.0;
	                producto.setPrecio(precioFinalRedondeado);
	          
	              
	            
	          }else if  (producto.getCategoria().getIdCategoria()==4) {
	                double precioConDescuentoLacteos = producto.getPrecio() * ofertaDAO.selectOfertaById(16);
	                double precioFinal2= producto.getPrecio() - precioConDescuentoLacteos;
	                double precioFinalRedondeado = Math.round(precioFinal2*100.0)/100.0;
	                producto.setPrecio(precioFinalRedondeado);
	              
	          }
	            
	       
	            break;
	        case 4:
	        	
	        	if (producto.getCategoria().getIdCategoria()==7){
	                double precioConDescuentoFrutasyVerduras = producto.getPrecio() * ofertaDAO.selectOfertaById(7);
	               double precioFinal= producto.getPrecio() - precioConDescuentoFrutasyVerduras;
	             double precioFinalRedondeado = Math.round(precioFinal*100.0)/100.0;
	                producto.setPrecio(precioFinalRedondeado);
	            
	              
	            
	          }
	        	break;
	        	
	        case 5:
	        	
	        	 if (producto.getCategoria().getIdCategoria()==2){
		                double precioConDescuentoCondimentos = producto.getPrecio() * ofertaDAO.selectOfertaById(8);
		               double precioFinal= producto.getPrecio() - precioConDescuentoCondimentos;
		             double precioFinalRedondeado = Math.round(precioFinal*100.0)/100.0;
		                producto.setPrecio(precioFinalRedondeado);
		            
		            
		          }else if  (producto.getCategoria().getIdCategoria()==3) {
		                double precioConDescuentoReposteria = producto.getPrecio() * ofertaDAO.selectOfertaById(10);
		                double precioFinal2= producto.getPrecio() - precioConDescuentoReposteria;
		                double precioFinalRedondeado = Math.round(precioFinal2*100.0)/100.0;
		                producto.setPrecio(precioFinalRedondeado);
		             
		               
		          }
		            
	        	break;
	        	
	        case 6:
	        	 if (producto.getCategoria().getIdCategoria()==5){
		                double precioConDescuentoLimpieza = producto.getPrecio() * ofertaDAO.selectOfertaById(11);
		               double precioFinal= producto.getPrecio() - precioConDescuentoLimpieza;
		             double precioFinalRedondeado = Math.round(precioFinal*100.0)/100.0;
		                producto.setPrecio(precioFinalRedondeado);
		             
		          }
	        	
	        	break;
	        	
	        case 7:
	        	 if (producto.getCategoria().getIdCategoria()==6){ //6
		                double precioConDescuentoLimpieza = producto.getPrecio() * ofertaDAO.selectOfertaById(12);
		               double precioFinal= producto.getPrecio() - precioConDescuentoLimpieza;
		             double precioFinalRedondeado = Math.round(precioFinal*100.0)/100.0;
		                producto.setPrecio(precioFinalRedondeado);
		              
		          }
		            
	        	
	        break;
	    }

	    return producto.getPrecio();
	}

	/**
	 * Metodo calcularCaducidad utilizado para calcular la fecha de caducidad de los
	 * productos según la categoría a la que pertenecen
	 * 
	 * @param indice
	 * @return fechaCaducidad
	 */
	
	static LocalDate calcularCaducidad(int indice) {

		LocalDate hoy = LocalDate.now();
		LocalDate fechaCaducidad = null;

		switch (indice) {
		case 1:
			fechaCaducidad = hoy.plusMonths(9);

			break;
		case 2:
			fechaCaducidad = hoy.plusYears(4);
			break;
		case 3:
			fechaCaducidad = hoy.plusDays(20);
			break;
		case 4:
			fechaCaducidad = hoy.plusDays(24);
			break;
		case 5:
			fechaCaducidad = hoy.plusMonths(7);
			break;
		case 6:
			fechaCaducidad = hoy.plusDays(3);
			break;
		case 7:
			fechaCaducidad = hoy.plusDays(4);
			break;
		case 8:
			fechaCaducidad = hoy.plusDays(1);
			break;
		case 9:
			fechaCaducidad = hoy.plusMonths(6);
			break;
		case 10:
			fechaCaducidad = hoy.plusMonths(6);
			break;

		}
		return fechaCaducidad;

	}

	/**
	 * Método borrarProductosCaducados de tipo void, es decir no devuelve nada,
	 * utilizado para borrar los productos en función de su fecha de caducidad.
	 */

	static void borrarProductosCaducados() {

		LocalDate hoy = LocalDate.now();
		List<Producto> selectProducto = productoDAO.selectAllProductos();

		for (Producto pr : selectProducto) {
			LocalDate fechaCaducidad = pr.getFecha_caducidad();
			if (hoy.isEqual(fechaCaducidad)) {
				productoDAO.deleteProducto(pr.getIdProducto());
			}

		}
	}
	static void aplicarOfertasProductos() {
	    List<Producto> productos = productoDAO.selectAllProductos();
	    
	    for (Producto producto : productos) {
	        ComprobarOferta(producto);
	    }
	}
	
	public  LocalDate obtenerUltimaFechaEjecucion() {
     
		ultimaFechaEjecucion = LocalDate.now();
        return ultimaFechaEjecucion;
    }
	

	/**
	 * Launch the application.
	 */
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					App window = new App();

					window.frameAlmacen.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application. 
	 * Borrar productos automáticamente
	 */
	public App() {
		
		ultimaFechaEjecucion = obtenerUltimaFechaEjecucion();
             
	        LocalDate fechaActual = LocalDate.now();
	        
	        ultimaFechaEjecucion = LocalDate.now();
	        if (!fechaActual.isEqual(ultimaFechaEjecucion)) {
	            aplicarOfertasProductos();
	        }
		

		borrarProductosCaducados();
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		JComboBox comboBoxSeleccionarCategoria = new JComboBox();

		frameAlmacen = new JFrame();
		frameAlmacen.getContentPane().setBackground(new Color(51, 204, 204));
		frameAlmacen.setBackground(new Color(50, 204, 204));
		frameAlmacen.setBounds(100, 100, 1664, 788);
		frameAlmacen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameAlmacen.getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("El Rincón de los Sabores");
		lblTitulo.setForeground(new Color(255, 153, 102));
		lblTitulo.setBackground(new Color(0, 153, 153));
		lblTitulo.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 25));
		lblTitulo.setBounds(492, 11, 403, 31);
		frameAlmacen.getContentPane().add(lblTitulo);
		

		textFieldCantidad = new JTextField();
		textFieldCantidad.setBounds(892, 404, 215, 20);
		frameAlmacen.getContentPane().add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
		
		JLabel lblCantidadProducto = new JLabel("Cantidad Producto");
		lblCantidadProducto.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCantidadProducto.setBounds(702, 410, 180, 14);
		frameAlmacen.getContentPane().add(lblCantidadProducto);
		
		textFieldPrecioPedido = new JTextField();
		textFieldPrecioPedido.setEditable(false);
		textFieldPrecioPedido.setText("");
		textFieldPrecioPedido.setColumns(10);
		textFieldPrecioPedido.setBounds(892, 379, 215, 19);
		frameAlmacen.getContentPane().add(textFieldPrecioPedido);
		
		JLabel lblPrecioPedido = new JLabel("Precio pedido");
		lblPrecioPedido.setFont(new Font("Dialog", Font.BOLD, 15));
		lblPrecioPedido.setBounds(702, 383, 117, 15);
		frameAlmacen.getContentPane().add(lblPrecioPedido);
		

		DefaultTableModel modelTabla = new DefaultTableModel() {

			@Override
			/**
			 * Este metodo sirve para que las celdas de la tabla no sean editables
			 * 
			 * @param filas:    este parametro son las filas de la tabla
			 * @param columnas: las columnas de la tabla
			 * @return: false, asi no se pueden editar las celdas
			 */
			public boolean isCellEditable(int filas, int columnas) {
				return false;
			}
		};
        //Añadir las columnas a la tabla Productos
		
		modelTabla.addColumn("Producto");
		modelTabla.addColumn("Nombre");
		modelTabla.addColumn("Precio");
		modelTabla.addColumn("Existencias");
		modelTabla.addColumn("Categoria");
		modelTabla.addColumn("Caducidad");
		modelTabla.addColumn("Oferta");
		
		tableProductos = new JTable(modelTabla);

		tableProductos.setBounds(26, 251, 489, -159);
		frameAlmacen.getContentPane().add(tableProductos);

		 //Leer los productos guardados en la base de datos mediante la función productoDAO.selectAllProductos() y mostrarlos en la tabla
		
		List<Producto> selectProducto = productoDAO.selectAllProductos();
		for (Producto pr : selectProducto) {
			Object[] fila = { pr.getIdProducto(), pr.getNombre(), pr.getPrecio(), pr.getExistencias(),
					pr.getCategoria().getIdCategoria(), pr.getFecha_caducidad() };
			modelTabla.addRow(fila);
		}

		JScrollPane scrollPaneProductos = new JScrollPane(tableProductos);
		scrollPaneProductos.setBounds(10, 43, 619, 220);
		frameAlmacen.getContentPane().add(scrollPaneProductos);

		JLabel lblDatos = new JLabel("INTRODUCIR DATOS");
		lblDatos.setFont(new Font("Dialog", Font.BOLD, 20));
		lblDatos.setBounds(10, 263, 284, 31);
		frameAlmacen.getContentPane().add(lblDatos);

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Dialog", Font.BOLD, 15));
		lblId.setBounds(10, 305, 117, 15);
		frameAlmacen.getContentPane().add(lblId);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNombre.setBounds(10, 331, 117, 15);
		frameAlmacen.getContentPane().add(lblNombre);

		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Dialog", Font.BOLD, 15));
		lblCategoria.setBounds(10, 357, 117, 15);
		frameAlmacen.getContentPane().add(lblCategoria);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Dialog", Font.BOLD, 15));
		lblPrecio.setBounds(10, 383, 117, 15);
		frameAlmacen.getContentPane().add(lblPrecio);

		JLabel lblStock = new JLabel("Stock");
		lblStock.setFont(new Font("Dialog", Font.BOLD, 15));
		lblStock.setBounds(10, 409, 117, 15);
		frameAlmacen.getContentPane().add(lblStock);

		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setBounds(137, 301, 151, 19);
		frameAlmacen.getContentPane().add(txtId);
		txtId.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setBounds(137, 327, 215, 19);
		frameAlmacen.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		txtPrecio = new JTextField();
		txtPrecio.setText("");
		txtPrecio.setBounds(137, 379, 151, 19);
		frameAlmacen.getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);

		txtStock = new JTextField();
		txtStock.setBounds(137, 405, 151, 19);
		frameAlmacen.getContentPane().add(txtStock);
		txtStock.setColumns(10);
		
		DefaultTableModel modelPedidos = new DefaultTableModel() {

			@Override
			/**
			 * Este metodo sirve para que las celdas de la tabla no sean editables
			 * 
			 * @param filas:    este parametro son las filas de la tabla
			 * @param columnas: las columnas de la tabla
			 * @return: false, asi no se pueden editar las celdas
			 */
			public boolean isCellEditable(int filas, int columnas) {
				return false;
			}
		};
        //Añadir las columnas a la tabla Productos
		
		modelPedidos.addColumn("Pedido");
		modelPedidos.addColumn("Nombre Proveedor");
		modelPedidos.addColumn("Producto");
		modelPedidos.addColumn("Precio");
		modelPedidos.addColumn("Cantidad");
		

		
		tablePedidos = new JTable(modelPedidos);

		tablePedidos.setBounds(26, 251, 489, -159);
		frameAlmacen.getContentPane().add(tablePedidos);
		
		
		
		JScrollPane scrollPanePedidos = new JScrollPane(tablePedidos);
		scrollPanePedidos.setBounds(697, 43, 619, 220);
		frameAlmacen.getContentPane().add(scrollPanePedidos);
		
		textFieldNombreProveedor = new JTextField();
		textFieldNombreProveedor.setBounds(892, 326, 215, 20);
		frameAlmacen.getContentPane().add(textFieldNombreProveedor);
		textFieldNombreProveedor.setColumns(10);
		
		JLabel lblNombreProveedor = new JLabel("Nombre Proveedor");
		lblNombreProveedor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombreProveedor.setBounds(702, 332, 180, 14);
		frameAlmacen.getContentPane().add(lblNombreProveedor);
		
		JComboBox comboBoxProductos = new JComboBox();
		
				List<Producto> Productos = productoDAO.selectAllProductos();
				for (Producto pr : Productos) {
					comboBoxProductos.addItem(pr.getIdProducto());
				}
		
		comboBoxProductos.setBounds(892, 352, 215, 20);
		frameAlmacen.getContentPane().add(comboBoxProductos);
		
		JLabel lblProductosEnStock = new JLabel("Productos en Stock");
		lblProductosEnStock.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblProductosEnStock.setBounds(702, 358, 180, 14);
		frameAlmacen.getContentPane().add(lblProductosEnStock);
		
		JButton btnGuardarPedido = new JButton("Guardar Pedido");
		ImageIcon imagenGuardar4 = new ImageIcon(App.class.getResource("/imagenes/guardar.png"));
		Image imagenRedimensionada4 = imagenGuardar4.getImage().getScaledInstance(LONGITUD_BTN_GUARDAR,
				ALTURA_BTN_GUARDAR, java.awt.Image.SCALE_SMOOTH);
		btnGuardarPedido.setIcon(new ImageIcon(imagenRedimensionada4));
		btnGuardarPedido.setBackground(new Color(245, 222, 179));
		btnGuardarPedido.setBounds(697, 634, 180, 25);
		frameAlmacen.getContentPane().add(btnGuardarPedido);
		
		
		
		
		
		JButton btnActualizarPedido = new JButton("Actualizar Pedido");	
		ImageIcon imagenActualizarPedido = new ImageIcon(App.class.getResource("/imagenes/actualizar.png"));
		Image imagenRedimensionada6 = imagenActualizarPedido.getImage().getScaledInstance(LONGITUD_BTN_ACTUALIZAR,
				ALTURA_BTN_ACTUALIZAR, java.awt.Image.SCALE_SMOOTH);
		btnActualizarPedido.setIcon(new ImageIcon(imagenRedimensionada6));
		btnActualizarPedido.setBackground(new Color(245, 222, 179));
		btnActualizarPedido.setBounds(910, 634, 191, 25);
		frameAlmacen.getContentPane().add(btnActualizarPedido);
		
		JButton btnBorrarPedido = new JButton("Borrar Pedido");
		ImageIcon imagenBorrar2 = new ImageIcon(App.class.getResource("/imagenes/borrar.png"));
		Image imagenRedimensionada5 = imagenBorrar2.getImage().getScaledInstance(LONGITUD_BTN_BORRAR, ALTURA_BTN_BORRAR,
				java.awt.Image.SCALE_SMOOTH);
		btnBorrarPedido.setBackground(new Color(245, 222, 179));
		btnBorrarPedido.setBounds(1145, 634, 171, 25);
	
		
	
		btnBorrarPedido.setIcon(new ImageIcon(imagenRedimensionada5));
		frameAlmacen.getContentPane().add(btnBorrarPedido);

	
		JComboBox comboBoxSeleccionarTiempo = new JComboBox();
		
		/**
		 * Evento sobre el comboBoxSeleccionarPeriodo utilizado seleccionar el periodo de tiempo para saber los productos que 
		 * caducarán en 1 dia, 1 año, 1 mes o 4 años
		 */
		comboBoxSeleccionarTiempo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
				int indice = comboBoxSeleccionarTiempo.getSelectedIndex() + 1;

				LocalDate hoy = LocalDate.now();

				switch (indice) {

				case 1:
					LocalDate mañana = hoy.plusDays(1);
					Period pmañana = Period.between(hoy, mañana);
					List<Producto> productosCaducanMañana = productoDAO.selectProductoByfecha(pmañana);
					modelTabla.setRowCount(0);

					
					for (Producto pr : productosCaducanMañana) {
						Object[] fila = { pr.getIdProducto(), pr.getNombre(), pr.getPrecio(), pr.getExistencias(),
								pr.getCategoria().getIdCategoria(), pr.getFecha_caducidad(),pr.getOferta().getIdOferta() };
						modelTabla.addRow(fila);

					}
					if (productosCaducanMañana.isEmpty()) {
						JOptionPane.showMessageDialog(null,
								"No hay productos que caduquen en el período seleccionado.");
					}

					break;

				case 2:

					LocalDate mes = hoy.plusMonths(1);
					Period pmes = Period.between(hoy, mes);
					List<Producto> productosCaducan1Mes = productoDAO.selectProductoByfecha(pmes);
					modelTabla.setRowCount(0);

					for (Producto pr : productosCaducan1Mes) {
						Object[] fila = { pr.getIdProducto(), pr.getNombre(), pr.getPrecio(), pr.getExistencias(),
								pr.getCategoria().getIdCategoria(), pr.getFecha_caducidad(),pr.getOferta().getIdOferta() };
						modelTabla.addRow(fila);

					}
					
					if (productosCaducan1Mes.isEmpty()) {
						JOptionPane.showMessageDialog(null,
								"No hay productos que caduquen en el período seleccionado.");
					}
					break;

				case 3:
					LocalDate año = hoy.plusYears(1);
					Period paño = Period.between(hoy, año);
					List<Producto> productosCaducanAlAño = productoDAO.selectProductoByfecha(paño);
					modelTabla.setRowCount(0);

					for (Producto pr : productosCaducanAlAño) {
						Object[] fila = { pr.getIdProducto(), pr.getNombre(), pr.getPrecio(), pr.getExistencias(),
								pr.getCategoria().getIdCategoria(), pr.getFecha_caducidad(),pr.getOferta().getIdOferta() };
						modelTabla.addRow(fila);

					}
					if (productosCaducanAlAño.isEmpty()) {
						JOptionPane.showMessageDialog(null,
								"No hay productos que caduquen en el período seleccionado.");
					}

					break;

				case 4:
					LocalDate años = hoy.plusYears(4);
					Period paños = Period.between(hoy, años);
					List<Producto> productosCaducan5Años = productoDAO.selectProductoByfecha(paños);
					modelTabla.setRowCount(0);

					for (Producto pr : productosCaducan5Años) {
						Object[] fila = { pr.getIdProducto(), pr.getNombre(), pr.getPrecio(), pr.getExistencias(),
								pr.getCategoria().getIdCategoria(), pr.getFecha_caducidad(),pr.getOferta().getIdOferta() };
						modelTabla.addRow(fila);

					}
					if (productosCaducan5Años.isEmpty()) {
						JOptionPane.showMessageDialog(null,
								"No hay productos que caduquen en el período seleccionado.");
					}
					

					break;

				}
			}

		});
		comboBoxSeleccionarTiempo
				.setModel(new DefaultComboBoxModel(new String[] { "1 dia", "1 mes", "1 año ", "4 años" }));
		comboBoxSeleccionarTiempo.setEnabled(false);
		comboBoxSeleccionarTiempo.setBounds(413, 588, 215, 24);
		frameAlmacen.getContentPane().add(comboBoxSeleccionarTiempo);
		
		JRadioButton rdbtnMostrarProductosCaducados = new JRadioButton("Mostrar productos que van a caducar");
		
		/**
		 * Evento sobre el rdbtnMostrarProductosCaducados utilizado para mostrar los productos caducados según el periodo 
		 * de tiempo seleccionado en el comboBoxSeleccionarPeriodo
		 */
		rdbtnMostrarProductosCaducados.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {

				if (rdbtnMostrarProductosCaducados.isSelected()) {
					modelTabla.setRowCount(0);

					comboBoxSeleccionarTiempo.setEnabled(true);

					int indicePeriodo = comboBoxSeleccionarTiempo.getSelectedIndex() + 1;

					Period periodoSeleccionado = null;

					switch (indicePeriodo) {

					case 1:
						periodoSeleccionado = Period.ofDays(1);

						break;
					case 2:
						periodoSeleccionado = Period.ofMonths(1);
						break;
					case 3:
						periodoSeleccionado = Period.ofYears(1);

						break;
					case 4:
						periodoSeleccionado = Period.ofYears(4);
						break;

					}
					List<Producto> productosCaducados = productoDAO.selectProductoByfecha(periodoSeleccionado);
				
					if (productosCaducados.isEmpty()) {
						JOptionPane.showMessageDialog(null,
								"No hay productos que caduquen en el período seleccionado.");
					}
					for (Producto pr : productosCaducados) {
						Object[] fila = { pr.getIdProducto(), pr.getNombre(), pr.getPrecio(), pr.getExistencias(),
								pr.getCategoria().getIdCategoria(), pr.getFecha_caducidad(),pr.getOferta().getIdOferta() };
						modelTabla.addRow(fila);
					}
					
				} else {
					comboBoxSeleccionarTiempo.setEnabled(false);
				}
			}
		});
		rdbtnMostrarProductosCaducados.setFont(new Font("Dialog", Font.BOLD, 15));
		rdbtnMostrarProductosCaducados.setBackground(new Color(51, 204, 204));
		rdbtnMostrarProductosCaducados.setBounds(10, 563, 495, 23);
		frameAlmacen.getContentPane().add(rdbtnMostrarProductosCaducados);

		JLabel lblSeleccionarPeriodoDe = new JLabel("Seleccionar Periodo de tiempo");
		lblSeleccionarPeriodoDe.setFont(new Font("Dialog", Font.BOLD, 15));
		lblSeleccionarPeriodoDe.setBounds(137, 593, 252, 19);
		frameAlmacen.getContentPane().add(lblSeleccionarPeriodoDe);

		JRadioButton rdbtnMostrarTodos = new JRadioButton("Mostrar todos los productos", true);
		rdbtnMostrarTodos.addActionListener(new ActionListener() {
			/**
			 * Esta funcion muestra todos los productos de la lista Productos cuando le das al
			 * radioButton: rdbtnMostrarTodos
			 * 
			 * @param arg0
			 */
			public void actionPerformed(ActionEvent arg0) {

				modelTabla.setRowCount(0);
				List<Producto> selectProducto = productoDAO.selectAllProductos();
				if (selectProducto.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No hay productos");
				}
				for (Producto pr : selectProducto) {
					Object[] fila = { pr.getIdProducto(), pr.getNombre(), pr.getPrecio(), pr.getExistencias(),
							pr.getCategoria().getIdCategoria(), pr.getFecha_caducidad(),pr.getOferta().getIdOferta() };
					modelTabla.addRow(fila);
					modelTabla.fireTableDataChanged();
				}

			}
		});
		rdbtnMostrarTodos.setBackground(new Color(51, 204, 204));
		rdbtnMostrarTodos.setFont(new Font("Dialog", Font.BOLD, 15));
		rdbtnMostrarTodos.setBounds(10, 462, 284, 23);

		frameAlmacen.getContentPane().add(rdbtnMostrarTodos);

		comboBoxSeleccionarCategoria.addActionListener(new ActionListener() {
			/**
			 * Esta funcion muestra los productos por su categoria cuando se selecciona una
			 * categoria del comboBox comboBoxSeleccionarCategoria
			 * 
			 */
			public void actionPerformed(ActionEvent arg0) {
				modelTabla.setRowCount(0);

				if (!comboBoxSeleccionarCategoria.isEnabled()) {
					List<Producto> selectProducto = productoDAO.selectAllProductos();

					for (Producto pr : selectProducto) {
						Object[] fila = { pr.getIdProducto(), pr.getNombre(), pr.getPrecio(), pr.getExistencias(),
								pr.getCategoria().getIdCategoria(), pr.getFecha_caducidad(), pr.getOferta().getIdOferta()};
						modelTabla.addRow(fila);
						modelTabla.fireTableDataChanged();
					}

				} else {
					int indice = comboBoxSeleccionarCategoria.getSelectedIndex() + 1;
					Categoria categoria = categoriaDAO.selectCategoriaById(indice);
					List<Producto> selectProducto = productoDAO.selectProductoByCategoria(categoria);
					if (selectProducto.isEmpty()) {
						JOptionPane.showMessageDialog(null, "No hay productos en esa categoria");
					}
					for (Producto pr : selectProducto) {
						Object[] fila = { pr.getIdProducto(), pr.getNombre(), pr.getPrecio(), pr.getExistencias(),
								pr.getCategoria().getIdCategoria(), pr.getFecha_caducidad(), pr.getOferta().getIdOferta()};
						modelTabla.addRow(fila);
						modelTabla.fireTableDataChanged();
					}
				}

			}
		});

		comboBoxSeleccionarCategoria.setEnabled(false);

		List<Categoria> selectCategoria = categoriaDAO.selectAllCategoria();
		for (Categoria cg : selectCategoria) {
			comboBoxSeleccionarCategoria.addItem(cg.getNombreCategoria());
		}

		comboBoxSeleccionarCategoria.setBounds(413, 506, 215, 24);
		frameAlmacen.getContentPane().add(comboBoxSeleccionarCategoria);

		JLabel lblSeleccionarCategoria = new JLabel("Seleccionar Categoria");
		lblSeleccionarCategoria.setFont(new Font("Dialog", Font.BOLD, 15));
		lblSeleccionarCategoria.setBounds(137, 511, 188, 19);
		frameAlmacen.getContentPane().add(lblSeleccionarCategoria);

		JRadioButton rdbtnMostrarProductosCategoria = new JRadioButton("Mostrar productos por categoría");
		/**
		 * Esta funcion habilita el comboBox comboBoxSeleccionarCategoria para que
		 * muestre los productos segun la categoria seleccionada
		 */
		rdbtnMostrarProductosCategoria.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {

				if (rdbtnMostrarProductosCategoria.isSelected()) {
					modelTabla.setRowCount(0);
					comboBoxSeleccionarCategoria.setEnabled(true);
					int indice = comboBoxSeleccionarCategoria.getSelectedIndex() + 1;
					Categoria categoria = categoriaDAO.selectCategoriaById(indice);
					List<Producto> selectProducto = productoDAO.selectProductoByCategoria(categoria);
					if (selectProducto.isEmpty()) {
						JOptionPane.showMessageDialog(null, "No hay productos en esa categoria");
					}
					for (Producto pr : selectProducto) {
						Object[] fila = { pr.getIdProducto(), pr.getNombre(), pr.getPrecio(), pr.getExistencias(),
								pr.getCategoria().getIdCategoria(), pr.getFecha_caducidad(),pr.getOferta().getIdOferta() };
						modelTabla.addRow(fila);
					}
				} else {
					comboBoxSeleccionarCategoria.setEnabled(false);
				}
			}

		});

		rdbtnMostrarProductosCategoria.setBackground(new Color(51, 204, 204));
		rdbtnMostrarProductosCategoria.setFont(new Font("Dialog", Font.BOLD, 15));
		rdbtnMostrarProductosCategoria.setBounds(10, 488, 324, 23);
		frameAlmacen.getContentPane().add(rdbtnMostrarProductosCategoria);

		JRadioButton rdbtnMostrarProductosSinUnidades = new JRadioButton(
				"Mostrar productos de los que ya no quede unidades");
		rdbtnMostrarProductosSinUnidades.addActionListener(new ActionListener() {
			/**
			 * Esta funcion muestra los productos sin stock al darle al radioButton
			 * rdbtnMostrarProductosSinUnidades
			 */
			public void actionPerformed(ActionEvent e) {

				modelTabla.setRowCount(0);
				List<Producto> selectProducto = productoDAO.selectProductosSinStock();
				if (selectProducto.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No hay productos sin stock.");
				}
				for (Producto pr : selectProducto) {
					Object[] fila = { pr.getIdProducto(), pr.getNombre(), pr.getPrecio(), pr.getExistencias(),
							pr.getCategoria().getIdCategoria(), pr.getFecha_caducidad(),pr.getOferta().getIdOferta() };
					modelTabla.addRow(fila);
					modelTabla.fireTableDataChanged();

				}
			}

		});

		rdbtnMostrarProductosSinUnidades.setBackground(new Color(51, 204, 204));
		rdbtnMostrarProductosSinUnidades.setFont(new Font("Dialog", Font.BOLD, 15));
		rdbtnMostrarProductosSinUnidades.setBounds(10, 537, 495, 23);
		frameAlmacen.getContentPane().add(rdbtnMostrarProductosSinUnidades);
		g1.add(rdbtnMostrarProductosCategoria);
		g1.add(rdbtnMostrarProductosSinUnidades);
		g1.add(rdbtnMostrarTodos);
		g1.add(rdbtnMostrarProductosCaducados);

		JComboBox comboBoxEscogerCategoria = new JComboBox();

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			/**
			 * Esta funcion inserta un producto cuando los datos están introducidos
			 * correctamente, tras darle al boton guardar
			 * 
			 */
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					String nombre = txtNombre.getText();

					int indice = comboBoxEscogerCategoria.getSelectedIndex() + 1;
					Categoria categoria = categoriaDAO.selectCategoriaById(indice);
					double precio = Double.parseDouble(txtPrecio.getText());
					int existencias = Integer.parseInt(txtStock.getText());
			        Oferta oferta=null;
					
					
					LocalDate hoy = LocalDate.now();
					LocalDate fechaCaducidad = calcularCaducidad(indice);
					
			       
					Producto producto1 = new Producto(nombre, precio, existencias, categoria, fechaCaducidad,oferta);
					int idOferta = MostrarIdOferta(producto1);
					 double precioOferta = CalcularOferta(producto1);
					 oferta= ofertaDAO.selectOfertaId(idOferta);
					 producto1.setOferta(oferta);

				        // Actualizar el precio si hay una oferta disponible
				        if (precio != precioOferta) {
				            precio = precioOferta;
				            
				        }
				        productoDAO.insertProducto(producto1);
					
					modelTabla.setRowCount(0);
					List<Producto> productoSelect = productoDAO.selectAllProductos();
					for (Producto pr : productoSelect) {

						Object[] fila = { pr.getIdProducto(), pr.getNombre(), pr.getPrecio(), pr.getExistencias(),
								pr.getCategoria().getIdCategoria(), pr.getFecha_caducidad(),pr.getOferta().getIdOferta()};

						modelTabla.addRow(fila);
					}
					
					comboBoxProductos.removeAllItems();
					List<Producto> Productos = productoDAO.selectAllProductos();
					for (Producto pr : Productos) {
						comboBoxProductos.addItem(pr.getIdProducto());
					}
					
					JOptionPane.showMessageDialog(null, "Producto añadido");
					txtNombre.setText("");
					txtPrecio.setText("");
					txtStock.setText("");
					txtId.setText("");

					if (rdbtnMostrarProductosSinUnidades.isSelected()) {
						modelTabla.setRowCount(0);
						List<Producto> selectProducto = productoDAO.selectProductosSinStock();
						if (selectProducto.isEmpty()) {
							JOptionPane.showMessageDialog(null, "No hay productos sin  stock");
						}
						for (Producto pr : selectProducto) {
							Object[] fila = { pr.getIdProducto(), pr.getNombre(), pr.getPrecio(), pr.getExistencias(),
									pr.getCategoria().getIdCategoria(), pr.getFecha_caducidad() };
							modelTabla.addRow(fila);
							modelTabla.fireTableDataChanged();

						}

					} else if (rdbtnMostrarProductosCategoria.isSelected()) {
						modelTabla.setRowCount(0);
						comboBoxSeleccionarCategoria.setEnabled(true);
						int indice2 = comboBoxSeleccionarCategoria.getSelectedIndex() + 1;
						Categoria categoria2 = categoriaDAO.selectCategoriaById(indice2);
						List<Producto> selectProducto = productoDAO.selectProductoByCategoria(categoria2);
						if (selectProducto.isEmpty()) {
							JOptionPane.showMessageDialog(null, "No hay productos en esa categoria");
						}
						for (Producto pr : selectProducto) {
							Object[] fila = { pr.getIdProducto(), pr.getNombre(), pr.getPrecio(), pr.getExistencias(),
									pr.getCategoria().getIdCategoria(), pr.getFecha_caducidad(),pr.getOferta().getIdOferta() };
							modelTabla.addRow(fila);
						}
					} else if (rdbtnMostrarProductosCaducados.isSelected()) {
						modelTabla.setRowCount(0);

						comboBoxSeleccionarTiempo.setEnabled(true);

						int indicePeriodo = comboBoxSeleccionarTiempo.getSelectedIndex() + 1;

						Period periodoSeleccionado = null;

						switch (indicePeriodo) {

						case 1:
							periodoSeleccionado = Period.ofDays(1);

							break;
						case 2:
							periodoSeleccionado = Period.ofMonths(1);
							break;
						case 3:
							periodoSeleccionado = Period.ofYears(1);

							break;
						case 4:
							periodoSeleccionado = Period.ofYears(4);
							break;

						}
						List<Producto> productosCaducados = productoDAO.selectProductoByfecha(periodoSeleccionado);
						if (productosCaducados.isEmpty()) {
							JOptionPane.showMessageDialog(null,
									"No hay productos que caduquen en el período seleccionado.");
						}
						for (Producto pr : productosCaducados) {
							Object[] fila = { pr.getIdProducto(), pr.getNombre(), pr.getPrecio(), pr.getExistencias(),
									pr.getCategoria().getIdCategoria(), pr.getFecha_caducidad(),pr.getOferta().getIdOferta() };
							modelTabla.addRow(fila);
						}
					}

					else {
						comboBoxSeleccionarCategoria.setEnabled(false);
					}

				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "¡Error hay casillas vacías o datos mal introducidos!");
				}

			}
		});
		btnGuardar.setBackground(new Color(245, 222, 179));
		btnGuardar.setBounds(10, 633, 121, 25);

		ImageIcon imagenGuardar = new ImageIcon(App.class.getResource("/imagenes/guardar.png"));
		Image imagenRedimensionada = imagenGuardar.getImage().getScaledInstance(LONGITUD_BTN_GUARDAR,
				ALTURA_BTN_GUARDAR, java.awt.Image.SCALE_SMOOTH);
		btnGuardar.setIcon(new ImageIcon(imagenRedimensionada));
		frameAlmacen.getContentPane().add(btnGuardar);

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			/**
			 * Esta funcion actualiza un producto tras seleccionarlo, cambiar un valor de un
			 * textField o del comboBox y despues se le da al boton Actualizar, si los datos
			 * estan introducidos correctamente se actualiza, sino, sale un mensaje de
			 * error.
			 */
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tableProductos.getSelectedRow();
				 
				 
				try {
					int id = (int) tableProductos.getValueAt(selectedRow, 0);
		
					
					 
			        
					String nombre = txtNombre.getText();
					int indice = comboBoxEscogerCategoria.getSelectedIndex() + 1;
					Categoria categoria = categoriaDAO.selectCategoriaById(indice);
					double precio = Double.parseDouble(txtPrecio.getText());
					 //double precioOriginal = productoOriginal.getPrecio();
			         //pedido.getProducto().setPrecio(precioOriginal);
					Oferta oferta=null;
					
					

				        // Actualizar el precio si hay una oferta disponible
				      
					int existencias = Integer.parseInt(txtStock.getText());
					Producto producto = productoDAO.selectProductoById(id);
					
					
					
					 
					JOptionPane.showMessageDialog(null, "Producto actualizado correctamente");
					producto.setNombre(nombre);
					producto.setCategoria(categoria);
					producto.setPrecio(precio);
					producto.setExistencias(existencias);
				int idOferta = MostrarIdOferta(producto);
				
				 oferta= ofertaDAO.selectOfertaId(idOferta);
					 double precioOferta = CalcularOferta(producto);
				
					productoDAO.updateProducto(producto);
				
					tableProductos.setValueAt(nombre, selectedRow, 1);
					tableProductos.setValueAt(precioOferta, selectedRow, 2);
					tableProductos.setValueAt(existencias, selectedRow, 3);
					tableProductos.setValueAt(indice, selectedRow, 4);
				
					txtNombre.setText("");
					txtPrecio.setText("");
					txtStock.setText("");
					txtId.setText("");
				} catch (ArrayIndexOutOfBoundsException e1) {
					JOptionPane.showMessageDialog(null,
							"No se ha seleccionado ninguna casilla o no hay ningun producto");

				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "¡Error hay casillas vacías o datos mal introducidos!");
				}
			}

		});
		btnActualizar.setBackground(new Color(245, 222, 179));
		btnActualizar.setBounds(216, 633, 151, 25);

		ImageIcon imagenActualizar = new ImageIcon(App.class.getResource("/imagenes/actualizar.png"));
		Image imagenRedimensionada2 = imagenActualizar.getImage().getScaledInstance(LONGITUD_BTN_ACTUALIZAR,
				ALTURA_BTN_ACTUALIZAR, java.awt.Image.SCALE_SMOOTH);
		btnActualizar.setIcon(new ImageIcon(imagenRedimensionada2));
		frameAlmacen.getContentPane().add(btnActualizar);

		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			/**
			 * Este evento borra el producto seleccionando cuando le das al boton de borrar
			 * 
			 */
			public void actionPerformed(ActionEvent arg0) {

				try {

					int filaSeleccionada = tableProductos.getSelectedRow();
					int idProducto = (int) tableProductos.getValueAt(filaSeleccionada, 0);

					productoDAO.deleteProducto(idProducto);
					
					comboBoxProductos.removeAllItems();
					List<Producto> Productos = productoDAO.selectAllProductos();
					for (Producto pr : Productos) {
						comboBoxProductos.addItem(pr.getIdProducto());
					}
					

					modelTabla.removeRow(filaSeleccionada);
					JOptionPane.showMessageDialog(null, "Producto borrado correctamente");
					txtNombre.setText("");
					txtPrecio.setText("");
					txtStock.setText("");
					txtId.setText("");

				} catch (ArrayIndexOutOfBoundsException e1) {
					JOptionPane.showMessageDialog(null, "No hay ningun producto o no se ha seleccionado ninguno");
				}
			}
		});
		btnBorrar.setBackground(new Color(245, 222, 179));
		btnBorrar.setBounds(506, 633, 121, 25);

		ImageIcon imagenBorrar = new ImageIcon(App.class.getResource("/imagenes/borrar.png"));
		Image imagenRedimensionada3 = imagenBorrar.getImage().getScaledInstance(LONGITUD_BTN_BORRAR, ALTURA_BTN_BORRAR,
				java.awt.Image.SCALE_SMOOTH);
		btnBorrar.setIcon(new ImageIcon(imagenRedimensionada3));
		frameAlmacen.getContentPane().add(btnBorrar);

		JLabel lblMostrarDatos = new JLabel("MOSTRAR DATOS");
		lblMostrarDatos.setFont(new Font("Dialog", Font.BOLD, 20));
		lblMostrarDatos.setBounds(10, 435, 284, 31);
		frameAlmacen.getContentPane().add(lblMostrarDatos);

		List<Categoria> Categoria = categoriaDAO.selectAllCategoria();
		for (Categoria cg : Categoria) {
			comboBoxEscogerCategoria.addItem(cg.getNombreCategoria());
		}
		comboBoxEscogerCategoria.setBounds(137, 353, 215, 19);
		frameAlmacen.getContentPane().add(comboBoxEscogerCategoria);
		
		
		tableProductos.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Este evento sirve para que cuando el usuario le de a una fila de la tabla se
			 * muestre en los text field
			 * 
			 */
			public void mouseClicked(MouseEvent e) {
				int índice = tableProductos.getSelectedRow();
				TableModel model = tableProductos.getModel();
				txtId.setText(model.getValueAt(índice, 0).toString());
				txtNombre.setText(model.getValueAt(índice, 1).toString());
				txtPrecio.setText(model.getValueAt(índice, 2).toString());
				txtStock.setText(model.getValueAt(índice, 3).toString());
				Object valorSeleccionado = model.getValueAt(índice, 4); // obtiene el valor de la columna de la
																		// categoría
				comboBoxEscogerCategoria.setSelectedIndex((int) valorSeleccionado - 1);
				
			
			}
		});
		tablePedidos.addMouseListener(new MouseAdapter() {
			@Override
		public void mouseClicked(MouseEvent e) {
			int índice = tablePedidos.getSelectedRow();
			TableModel model = tablePedidos.getModel();
		
			textFieldNombreProveedor.setText(model.getValueAt(índice, 1).toString());
			
			Object valorSeleccionado = model.getValueAt(índice, 2);
			comboBoxProductos.setSelectedItem((int) valorSeleccionado -1);
			
			textFieldPrecioPedido.setText(model.getValueAt(índice, 3).toString());
			
			textFieldCantidad.setText(model.getValueAt(índice, 4).toString());
		
		}
	});
		
		 

	}
}