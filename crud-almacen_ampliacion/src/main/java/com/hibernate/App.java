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
import com.hibernate.dao.DetalleVentaDAO;
import com.hibernate.dao.OfertaDAO;
import com.hibernate.dao.PedidoVentaDAO;
import com.hibernate.dao.ProductoDAO;
import com.hibernate.dao.UsuarioDAO;
import com.hibernate.model.Categoria;
import com.hibernate.model.DetalleVenta;
import com.hibernate.model.Oferta;
import com.hibernate.model.PedidoVenta;
import com.hibernate.model.Producto;
import com.hibernate.model.Usuario;

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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
	PedidoVentaDAO pedidoDAO = new PedidoVentaDAO();
	DetalleVentaDAO detalleDAO = new DetalleVentaDAO();
	

	private JFrame frameAlmacen;
	private JTable tableProductos;
	
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTextField txtStock;
	static  LocalDate ultimaFechaEjecucion;
	
	private JTextField textFieldNombre;
	private JTextField textFieldCorreo;
	private JTextField textFieldTelefono;
	private JTextField textFieldLocalizacion;
	private JTextField textFieldFechaNac;
	private JTextField textFieldFechaInicio;
	
	
	
	

	ButtonGroup g1 = new ButtonGroup();
	 // Variable para controlar el estado de registro
    static UsuarioDAO usuarioDao= new UsuarioDAO();
    private JTextField textFieldNombreLogin;
    private JTextField textFieldCorreoLogin;
    private JTable tablePedidos;
    private JTextField textFieldNombrePedido;
    private JTextField textFieldPrecioPedido;
    private JTextField textFieldCantidad;
    private JButton btnGuardarPedido;
	
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
		
		
	
	    aplicarOfertasProductos();
	        
		

		borrarProductosCaducados();
		initialize();

	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	 JComboBox comboBoxSeleccionarCategoria = new JComboBox();
		
		comboBoxSeleccionarCategoria.setVisible(false);
		frameAlmacen = new JFrame();
		frameAlmacen.getContentPane().setBackground(new Color(51, 204, 204));
		frameAlmacen.setBackground(new Color(50, 204, 204));
		frameAlmacen.setBounds(100, 100, 1500, 788);
		frameAlmacen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameAlmacen.getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("El Rincón de los Sabores");
		lblTitulo.setForeground(new Color(255, 153, 102));
		lblTitulo.setBackground(new Color(0, 153, 153));
		lblTitulo.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 25));
		lblTitulo.setBounds(282, 0, 403, 31);
		frameAlmacen.getContentPane().add(lblTitulo);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(512, 118, 164, 20);
		frameAlmacen.getContentPane().add(textFieldNombre);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setColumns(10);
		textFieldCorreo.setBounds(512, 149, 164, 20);
		frameAlmacen.getContentPane().add(textFieldCorreo);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(512, 180, 164, 20);
		frameAlmacen.getContentPane().add(textFieldTelefono);
		
		textFieldLocalizacion = new JTextField();
		textFieldLocalizacion.setColumns(10);
		textFieldLocalizacion.setBounds(512, 214, 164, 20);
		frameAlmacen.getContentPane().add(textFieldLocalizacion);
		
		textFieldFechaNac = new JTextField();
		textFieldFechaNac.setColumns(10);
		textFieldFechaNac.setBounds(512, 242, 164, 20);
		frameAlmacen.getContentPane().add(textFieldFechaNac);
		
		textFieldFechaInicio = new JTextField();
		textFieldFechaInicio.setColumns(10);
		textFieldFechaInicio.setBounds(512, 276, 164, 20);
		frameAlmacen.getContentPane().add(textFieldFechaInicio);
		
		JLabel lblNombreRegistro = new JLabel("Nombre:");
		lblNombreRegistro.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNombreRegistro.setBounds(272, 124, 71, 14);
		frameAlmacen.getContentPane().add(lblNombreRegistro);
		
		JLabel lblCorreoRegistro = new JLabel("Correo Electrónico:");
		lblCorreoRegistro.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCorreoRegistro.setBounds(272, 155, 185, 14);
		frameAlmacen.getContentPane().add(lblCorreoRegistro);
		
		JLabel lblTelfono = new JLabel("Teléfono:");
		lblTelfono.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTelfono.setBounds(272, 186, 154, 14);
		frameAlmacen.getContentPane().add(lblTelfono);
		
		JLabel lblNombreLogin = new JLabel("Nombre:");
		lblNombreLogin.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNombreLogin.setBounds(272, 487, 71, 14);
		frameAlmacen.getContentPane().add(lblNombreLogin);
		
		JLabel lblCorreoRegistroUsuario = new JLabel("Correo Electrónico:");
		lblCorreoRegistroUsuario.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCorreoRegistroUsuario.setBounds(272, 513, 185, 14);
		frameAlmacen.getContentPane().add(lblCorreoRegistroUsuario);
		
		textFieldNombreLogin = new JTextField();
		textFieldNombreLogin.setColumns(10);
		textFieldNombreLogin.setBounds(512, 481, 164, 20);
		frameAlmacen.getContentPane().add(textFieldNombreLogin);
		

		JLabel lblDatos = new JLabel("INTRODUCIR DATOS");
		lblDatos.setFont(new Font("Dialog", Font.BOLD, 20));
		lblDatos.setBounds(10, 263, 284, 31);
		frameAlmacen.getContentPane().add(lblDatos);
		lblDatos.setVisible(false);
		
		JLabel lblDatosPedido = new JLabel("INTRODUCIR DATOS");
		lblDatosPedido.setFont(new Font("Dialog", Font.BOLD, 20));
		lblDatosPedido.setBounds(707, 263, 284, 31);
		frameAlmacen.getContentPane().add(lblDatosPedido);
		lblDatosPedido.setVisible(false);
		
		
		JLabel lblNombrePedido = new JLabel("Nombre Proveedor");
		lblNombrePedido.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNombrePedido.setBounds(707, 289, 138, 31);
		frameAlmacen.getContentPane().add(lblNombrePedido);
		lblNombrePedido.setVisible(false);
		
		JLabel lblProductoPedido = new JLabel("Producto");
		lblProductoPedido.setFont(new Font("Dialog", Font.BOLD, 15));
		lblProductoPedido.setBounds(707, 315, 117, 31);
		frameAlmacen.getContentPane().add(lblProductoPedido);
		lblProductoPedido.setVisible(false);
		
		JLabel lblPrecioPedido = new JLabel("Precio");
		
		lblPrecioPedido.setFont(new Font("Dialog", Font.BOLD, 15));
		lblPrecioPedido.setBounds(707, 367, 126, 31);
		frameAlmacen.getContentPane().add(lblPrecioPedido);
		lblPrecioPedido.setVisible(false);
		
		JLabel lblCantidadPedido= new JLabel("Cantidad");
		lblCantidadPedido.setFont(new Font("Dialog", Font.BOLD, 15));
		lblCantidadPedido.setBounds(707, 332, 79, 40);
		frameAlmacen.getContentPane().add(lblCantidadPedido);
		lblCantidadPedido.setVisible(false);
		
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Dialog", Font.BOLD, 15));
		lblId.setBounds(10, 305, 117, 15);
		frameAlmacen.getContentPane().add(lblId);
		lblId.setVisible(false);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNombre.setBounds(10, 331, 117, 15);
		frameAlmacen.getContentPane().add(lblNombre);
		lblNombre.setVisible(false);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Dialog", Font.BOLD, 15));
		lblCategoria.setBounds(10, 357, 117, 15);
		frameAlmacen.getContentPane().add(lblCategoria);
		lblCategoria.setVisible(false);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Dialog", Font.BOLD, 15));
		lblPrecio.setBounds(10, 383, 117, 15);
		frameAlmacen.getContentPane().add(lblPrecio);
		lblPrecio.setVisible(false);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setFont(new Font("Dialog", Font.BOLD, 15));
		lblStock.setBounds(10, 409, 117, 15);
		frameAlmacen.getContentPane().add(lblStock);
		lblStock.setVisible(false);
		
		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setBounds(137, 301, 151, 19);
		frameAlmacen.getContentPane().add(txtId);
		txtId.setColumns(10);
		txtId.setVisible(false);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(137, 327, 215, 19);
		frameAlmacen.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		txtNombre.setVisible(false);
		
		txtPrecio = new JTextField();
		txtPrecio.setText("");
		txtPrecio.setBounds(137, 379, 151, 19);
		frameAlmacen.getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		txtPrecio.setVisible(false);
		
		txtStock = new JTextField();
		txtStock.setBounds(137, 405, 151, 19);
		frameAlmacen.getContentPane().add(txtStock);
		txtStock.setColumns(10);
		txtStock.setVisible(false);

		
		textFieldCorreoLogin = new JTextField();
		textFieldCorreoLogin.setColumns(10);
		textFieldCorreoLogin.setBounds(512, 507, 164, 20);
		frameAlmacen.getContentPane().add(textFieldCorreoLogin);
		
		JComboBox comboBoxPedido = new JComboBox();
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Dialog", Font.BOLD, 20));
		lblLogin.setBounds(397, 435, 70, 15);
		frameAlmacen.getContentPane().add(lblLogin);
		
		
		JLabel lblLocalizacin = new JLabel("Localización:");
		lblLocalizacin.setFont(new Font("Dialog", Font.BOLD, 14));
		lblLocalizacin.setBounds(272, 217, 154, 14);
		frameAlmacen.getContentPane().add(lblLocalizacin);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha de Nacimiento:");
		lblFechaNacimiento.setFont(new Font("Dialog", Font.BOLD, 14));
		lblFechaNacimiento.setBounds(272, 248, 185, 14);
		frameAlmacen.getContentPane().add(lblFechaNacimiento);
		
		JLabel lblFechaInicio = new JLabel("Fecha de Inicio:");
		lblFechaInicio.setFont(new Font("Dialog", Font.BOLD, 14));
		lblFechaInicio.setBounds(272, 279, 185, 17);
		frameAlmacen.getContentPane().add(lblFechaInicio);
		
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					 
						
	                    String nombre = textFieldNombre.getText();
	                    String correo = textFieldCorreo.getText();
	                    String telefono = textFieldTelefono.getText();
	                    String localizacion = textFieldLocalizacion.getText();
	                    String fechaNacimiento = textFieldFechaNac.getText();
	                    String fechaInicio = textFieldFechaInicio.getText();
	                    
	                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	                    LocalDate fechaNacimientoFormateada = LocalDate.parse(fechaNacimiento, formatter);
	                    LocalDate fechaInicioFormateada = LocalDate.parse(fechaInicio, formatter);
	                    Period edad = Period.between(LocalDate.parse(fechaNacimiento, formatter), LocalDate.parse(fechaInicio, formatter));
	                    
	                        if (fechaInicioFormateada.isBefore(fechaNacimientoFormateada)) {
	                            JOptionPane.showMessageDialog(null, "La fecha de inicio debe ser posterior a la fecha de nacimiento");
	                        } else if (Period.between(fechaNacimientoFormateada, fechaInicioFormateada).getYears() < 18) {
	                            JOptionPane.showMessageDialog(null, "El empleado es menor de edad");
	                        } else if (nombre.equals("Error") || correo.equals("Error") || telefono.equals("Error") || localizacion.equals("Error")
	                                || fechaNacimiento.equals("Error") || fechaInicio.equals("Error")) {
	                            JOptionPane.showMessageDialog(null, "Hay datos erróneos");
	                        } else {
	                        	
	                            // Realizar el registro del usuario
	                           
	                            Usuario usuario = new Usuario(nombre, correo, telefono, localizacion, fechaNacimiento, fechaInicio);
	                            
	                                usuarioDao.insertUsuario(usuario);
	                                JOptionPane.showMessageDialog(null, "Registro exitoso");
	                                

		                            // Mostrar elementos de la interfaz para administrar productos, pedidos, etc.
	                                
		                    	
		                       
	                            

				 
	                    
	                    }
	                }catch(DateTimeParseException error ) {
	                	JOptionPane.showMessageDialog(null, "Fechas mal introducidas");
	                }catch(NullPointerException error2) {
	                	JOptionPane.showMessageDialog(null, "Hay casillas vacias");
	                }
			}
		});
		
		btnRegistrarse.setBackground(new Color(245, 222, 179));
		btnRegistrarse.setBounds(336, 348, 164, 25);
		frameAlmacen.getContentPane().add(btnRegistrarse);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBackground(new Color(245, 222, 179));
		btnEntrar.setBounds(336, 594, 164, 25);
		frameAlmacen.getContentPane().add(btnEntrar);
		

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
		tableProductos.setVisible(false);
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
		scrollPaneProductos.setVisible(false);
		
		
	
		JComboBox comboBoxSeleccionarTiempo = new JComboBox();
		 comboBoxSeleccionarTiempo.setVisible(false);
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
		comboBoxSeleccionarTiempo.setBounds(456, 593, 215, 19);
		frameAlmacen.getContentPane().add(comboBoxSeleccionarTiempo);
		
		JRadioButton rdbtnMostrarProductosCaducados = new JRadioButton("Mostrar productos que van a caducar");
		 rdbtnMostrarProductosCaducados.setVisible(false);
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
		 lblSeleccionarPeriodoDe.setVisible(false);
		 
		JRadioButton rdbtnMostrarTodos = new JRadioButton("Mostrar todos los productos", true);
		rdbtnMostrarTodos.setVisible(false);
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

		comboBoxSeleccionarCategoria.setBounds(445, 513, 215, 19);
		frameAlmacen.getContentPane().add(comboBoxSeleccionarCategoria);

		JLabel lblSeleccionarCategoria = new JLabel("Seleccionar Categoria");
		lblSeleccionarCategoria.setFont(new Font("Dialog", Font.BOLD, 15));
		lblSeleccionarCategoria.setBounds(137, 511, 188, 19);
		frameAlmacen.getContentPane().add(lblSeleccionarCategoria);
		lblSeleccionarCategoria.setVisible(false);
		JRadioButton rdbtnMostrarProductosCategoria = new JRadioButton("Mostrar productos por categoría");
		rdbtnMostrarProductosCategoria.setVisible(false);
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
		 rdbtnMostrarProductosSinUnidades.setVisible(false);
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
		comboBoxEscogerCategoria.setVisible(false);
		JButton btnGuardar = new JButton("Guardar");
		 btnGuardar.setVisible(false);
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
					
					comboBoxPedido.removeAllItems();
					List<Producto> selectProductos = productoDAO.selectAllProductos();
					

					for (Producto pr : selectProductos) {
						comboBoxPedido.addItem(pr.getIdProducto());
						

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
		btnActualizar.setVisible(false);
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
		modelPedidos.addColumn("Proveedor");
		modelPedidos.addColumn("Producto");
		modelPedidos.addColumn("Cantidad");
		modelPedidos.addColumn("Precio");
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setVisible(false);
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
					
					
					
					

					modelTabla.removeRow(filaSeleccionada);
					
					JOptionPane.showMessageDialog(null, "Producto borrado correctamente");
					txtNombre.setText("");
					txtPrecio.setText("");
					txtStock.setText("");
					txtId.setText("");
					modelPedidos.setRowCount(0);
					
					comboBoxPedido.removeAllItems();
					List<Producto> selectProductos = productoDAO.selectAllProductos();
					

					for (Producto pr : selectProductos) {
						comboBoxPedido.addItem(pr.getIdProducto());
						

					}
					
					List<DetalleVenta> pedidoSelect = detalleDAO.selectAllPedidos();
					for (DetalleVenta dv : pedidoSelect) {
						
						
						
						
					    Object[] fila = {dv.getPedidoVenta().getIdpedidoVenta(), dv.getProveedor(), dv.getProducto().getIdProducto(),dv.getCantidad(),dv.getPrecio()};
					    modelPedidos.addRow(fila);
						
					}
				} catch (ArrayIndexOutOfBoundsException e1) {
					JOptionPane.showMessageDialog(null, "No hay ningun producto o no se ha seleccionado ninguno");
				}
			}
		});
		btnBorrar.setBackground(new Color(245, 222, 179));
		btnBorrar.setBounds(433, 633, 121, 25);
		JButton btnActualizarPedido = new JButton("Actualizar");
		btnActualizarPedido.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			        int selectedRow = tablePedidos.getSelectedRow();
			 
			        try {
			            int id = (int) tablePedidos.getValueAt(selectedRow, 0);

			            String nombre = textFieldNombrePedido.getText();
			            String indice = comboBoxPedido.getSelectedItem().toString();
			            int numeroSeleccionado = Integer.parseInt(indice);
			            int cantidad = Integer.parseInt(textFieldCantidad.getText());
			            
			            Producto producto = productoDAO.selectProductoById(numeroSeleccionado);
			            double precio = producto.getPrecio()*cantidad;
			            int stockProducto= producto.getExistencias()-cantidad;
			            if(cantidad> producto.getExistencias())
			            {
			            	 JOptionPane.showMessageDialog(null, "Hay menos stock del que pide ");
			            }
			            else {
			            	producto.setExistencias(stockProducto);
			            	productoDAO.updateProducto(producto);
			            PedidoVenta pedidoVenta = new PedidoVenta();
			            pedidoDAO.insertPedidoVenta(pedidoVenta);

			            DetalleVenta pedido = new DetalleVenta(pedidoVenta, nombre, producto, cantidad, precio);
			            detalleDAO.insertDetalleVenta(pedido);

			            JOptionPane.showMessageDialog(null, "Producto actualizado correctamente");

			            pedido.setProveedor(nombre);
			            pedido.setProducto(producto);
			            pedido.setCantidad(cantidad);
			            pedido.setPrecio(precio);

			            int idOferta = MostrarIdOferta(producto);
			            Oferta oferta = ofertaDAO.selectOfertaId(idOferta);
			            double precioOferta = CalcularOferta(producto);

			            productoDAO.updateProducto(producto);

			            DefaultTableModel modelPedidos = (DefaultTableModel) tablePedidos.getModel();
			            modelPedidos.setValueAt(nombre, selectedRow, 1);
			            modelPedidos.setValueAt(producto.getIdProducto(), selectedRow, 2);
			            modelPedidos.setValueAt(cantidad, selectedRow, 3);
			            modelPedidos.setValueAt(precio, selectedRow, 4);
			        	List<Producto> productoSelect = productoDAO.selectAllProductos();
			        	modelTabla.setRowCount(0);
			            for (Producto pr : productoSelect) {

							Object[] fila = { pr.getIdProducto(), pr.getNombre(), pr.getPrecio(), pr.getExistencias(),
									pr.getCategoria().getIdCategoria(), pr.getFecha_caducidad(),pr.getOferta().getIdOferta()};

							modelTabla.addRow(fila);
						}

			            textFieldNombrePedido.setText("");
			            textFieldPrecioPedido.setText("");
			            textFieldCantidad.setText("");
			            }
			        } catch (ArrayIndexOutOfBoundsException e1) {
			            JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna casilla o no hay ningún pedido");
			        } catch (NumberFormatException e1) {
			            JOptionPane.showMessageDialog(null, "¡Error! Hay casillas vacías o datos mal introducidos.");
			        }
			    }
			});
	
		
		
		
		
	
		
		List<DetalleVenta> pedidoSelect = detalleDAO.selectAllPedidos();
		for (DetalleVenta dv : pedidoSelect) {
		 

		    Object[] fila = {dv.getPedidoVenta().getIdpedidoVenta(),dv.getProveedor() , dv.getProducto().getIdProducto(),dv.getCantidad(),dv.getProducto().getPrecio()};
		    modelPedidos.addRow(fila);
		
		}

		tablePedidos = new JTable(modelPedidos);
		tablePedidos.setVisible(false);
		tablePedidos.setBounds(26, 251, 489, -159);
		frameAlmacen.getContentPane().add(tablePedidos);
		
		JScrollPane scrollPanePedidos = new JScrollPane(tablePedidos);
		scrollPanePedidos.setBounds(707, 43, 619, 220);
		frameAlmacen.getContentPane().add(scrollPanePedidos);
		scrollPanePedidos.setVisible(false);
	
		btnActualizarPedido.setBounds(958, 633, 117, 25);
		frameAlmacen.getContentPane().add(btnActualizarPedido);
		
		
		JButton btnBorrarPedido = new JButton("Borrar");
		btnBorrarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			

					try {

						int filaSeleccionada = tablePedidos.getSelectedRow();
						int idPedido = (int) tablePedidos.getValueAt(filaSeleccionada, 0);

						detalleDAO.deleteDetalleVenta(idPedido);
		
						modelPedidos.removeRow(filaSeleccionada);
						JOptionPane.showMessageDialog(null, "Pedido borrado correctamente");
						textFieldNombrePedido.setText("");
						textFieldCantidad.setText("");
						textFieldPrecioPedido.setText("");
						

					} catch (ArrayIndexOutOfBoundsException e1) {
						JOptionPane.showMessageDialog(null, "No hay ningun pedido o no se ha seleccionado ninguno");
					}
				}
			});
				
		
		btnBorrarPedido.setVisible(false);
		btnBorrarPedido.setBounds(1209, 633, 117, 25);
		frameAlmacen.getContentPane().add(btnBorrarPedido);
		btnActualizarPedido.setVisible(false);
		ImageIcon imagenBorrar = new ImageIcon(App.class.getResource("/imagenes/borrar.png"));
		Image imagenRedimensionada3 = imagenBorrar.getImage().getScaledInstance(LONGITUD_BTN_BORRAR, ALTURA_BTN_BORRAR,
				java.awt.Image.SCALE_SMOOTH);
		btnBorrar.setIcon(new ImageIcon(imagenRedimensionada3));
		frameAlmacen.getContentPane().add(btnBorrar);
	
		
		
		textFieldNombrePedido = new JTextField();
		textFieldNombrePedido.setBounds(901, 301, 215, 19);
		frameAlmacen.getContentPane().add(textFieldNombrePedido);
		textFieldNombrePedido.setColumns(10);
		textFieldNombrePedido.setVisible(false);
	
		lblPrecioPedido.setVisible(false);
		textFieldPrecioPedido = new JTextField();
		textFieldPrecioPedido.setEnabled(false);
		textFieldPrecioPedido.setBounds(901, 379, 215, 19);
		frameAlmacen.getContentPane().add(textFieldPrecioPedido);
		textFieldPrecioPedido.setColumns(10);
		textFieldPrecioPedido.setVisible(false);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setBounds(901, 353, 215, 19);
		textFieldCantidad.setVisible(false);
		frameAlmacen.getContentPane().add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
		
		JLabel lblMostrarDatos = new JLabel("MOSTRAR DATOS");
		lblMostrarDatos.setVisible(false);
		lblMostrarDatos.setFont(new Font("Dialog", Font.BOLD, 20));
		lblMostrarDatos.setBounds(10, 435, 284, 31);
		frameAlmacen.getContentPane().add(lblMostrarDatos);
		
		JLabel lblRegistro_1 = new JLabel("Registro de Usuario");
		lblRegistro_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblRegistro_1.setBounds(371, 53, 256, 54);
		frameAlmacen.getContentPane().add(lblRegistro_1);
		
		
				
		comboBoxPedido.removeAllItems();
				List<Producto> selectProductos = productoDAO.selectAllProductos();
				

				for (Producto pr : selectProductos) {
					comboBoxPedido.addItem(pr.getIdProducto());
					

				}
				
			
	
		comboBoxPedido.setBounds(901, 327, 215, 19);
		comboBoxPedido.setVisible(false);
		frameAlmacen.getContentPane().add(comboBoxPedido);
		
		btnGuardarPedido = new JButton("Guardar");
		btnGuardarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				String nombre = textFieldNombrePedido.getText();
				String indice = comboBoxPedido.getSelectedItem().toString();
				int numeroSeleccionado = Integer.parseInt(indice);
				int cantidad = Integer.parseInt(textFieldCantidad.getText());
			  
				
				Producto producto = productoDAO.selectProductoById(numeroSeleccionado);
				double precio = producto.getPrecio()*cantidad;
				
				
               
                
                
				
				 if( producto.getExistencias() < cantidad)
				 {
					 JOptionPane.showMessageDialog(null, "Error: hay menos stock del que pide");
				 }
				 else if( cantidad == 0)
				 {
					 JOptionPane.showMessageDialog(null, "Error: la cantidad no puede ser 0");
				 }
				 else
				 {
					 int stockProductos= producto.getExistencias()-cantidad;
					 producto.setExistencias(stockProductos);
					 productoDAO.updateProducto(producto);
					 PedidoVenta pedidoVenta = new PedidoVenta();
		                pedidoDAO.insertPedidoVenta(pedidoVenta);
					 DetalleVenta pedido = new DetalleVenta( pedidoVenta, nombre, producto,cantidad ,  precio);
				detalleDAO.insertDetalleVenta(pedido);
				List<DetalleVenta> pedidoSelect = detalleDAO.selectAllPedidos();
				List<Producto> productoSelect = productoDAO.selectAllProductos();
				
				modelPedidos.setRowCount(0);
				modelTabla.setRowCount(0);
				for (DetalleVenta dv : pedidoSelect) {
					
					
					
					
				    Object[] fila = {dv.getPedidoVenta().getIdpedidoVenta(), dv.getProveedor(), dv.getProducto().getIdProducto(),dv.getCantidad(),dv.getPrecio()};
				    modelPedidos.addRow(fila);
					
				}
				for (Producto pr : productoSelect) {

					Object[] fila = { pr.getIdProducto(), pr.getNombre(), pr.getPrecio(), pr.getExistencias(),
							pr.getCategoria().getIdCategoria(), pr.getFecha_caducidad(),pr.getOferta().getIdOferta()};

					modelTabla.addRow(fila);
				}

				JOptionPane.showMessageDialog(null, "Pedido añadido");
				textFieldNombrePedido.setText("");
				textFieldCantidad.setText("");
				textFieldPrecioPedido.setText("");
				 }
				
				
				
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "¡Error hay casillas vacías o datos mal introducidos!");
			}

				
			}
		});
		btnGuardarPedido.setBounds(707, 633, 117, 25);
		btnGuardarPedido.setVisible(false);
		frameAlmacen.getContentPane().add(btnGuardarPedido);
		List<Categoria> Categoria = categoriaDAO.selectAllCategoria();
		for (Categoria cg : Categoria) {
			comboBoxEscogerCategoria.addItem(cg.getNombreCategoria());
		}
		comboBoxEscogerCategoria.setBounds(137, 353, 215, 19);
		frameAlmacen.getContentPane().add(comboBoxEscogerCategoria);
		
		
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setBackground(new Color(245, 222, 179));
		btnCerrarSesion.setVisible(false);
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCerrarSesion.setVisible(false);
				btnActualizarPedido.setVisible(false);
				textFieldCantidad.setVisible(false);
				textFieldPrecioPedido.setVisible(false);
				btnGuardarPedido.setVisible(false);
				textFieldNombrePedido.setVisible(false);
				textFieldNombreLogin.setVisible(true);
            	textFieldCorreoLogin.setVisible(true);
            	lblCorreoRegistroUsuario.setVisible(true);
            	lblLogin.setVisible(true);
            	scrollPanePedidos.setVisible(false);
            	lblCantidadPedido.setVisible(false);
            	lblPrecioPedido.setVisible(false);
            	
            	textFieldNombrePedido.setVisible(false);
            	btnBorrarPedido.setVisible(false);
            	lblPrecioPedido.setVisible(true);
            	lblNombreLogin.setVisible(true);
            	comboBoxPedido.setVisible(false);
            	textFieldCantidad.setVisible(false);
				textFieldNombre.setVisible(true);
				textFieldCorreo.setVisible(true);
				textFieldTelefono.setVisible(true);
				textFieldLocalizacion.setVisible(true);
				textFieldFechaNac.setVisible(true);
				textFieldFechaInicio.setVisible(true);
				btnEntrar.setVisible(true);
				lblNombreRegistro.setVisible(true);
				lblCorreoRegistro.setVisible(true);
				lblTelfono.setVisible(true);
				lblLocalizacin.setVisible(true);
				lblFechaInicio.setVisible(true);
				lblFechaNacimiento.setVisible(true);
				btnRegistrarse.setVisible(true);
				btnGuardarPedido.setVisible(false);
				lblRegistro_1.setVisible(true);
				btnCerrarSesion.setVisible(false);
				lblProductoPedido.setVisible(false);
				tableProductos.setVisible(false);
				lblDatosPedido.setVisible(false);
				lblNombrePedido.setVisible(false);
				lblProductoPedido.setVisible(false);
				lblProductoPedido.setVisible(false);
				
				txtId.setVisible(false);
				txtNombre.setVisible(false);
				txtPrecio.setVisible(false);
				txtStock.setVisible(false);
				comboBoxSeleccionarCategoria.setVisible(false);
				lblTitulo.setVisible(false);
				lblNombre.setVisible(false);
				lblCategoria.setVisible(false);
				lblPrecio.setVisible(false);
				lblStock.setVisible(false);
				lblMostrarDatos.setVisible(false);
				lblSeleccionarPeriodoDe.setVisible(false);
				lblSeleccionarCategoria.setVisible(false);
				comboBoxEscogerCategoria.setVisible(false);
				comboBoxSeleccionarTiempo.setVisible(false);
				rdbtnMostrarTodos.setVisible(false);
				rdbtnMostrarProductosCategoria.setVisible(false);
				rdbtnMostrarProductosSinUnidades.setVisible(false);
				rdbtnMostrarProductosCaducados.setVisible(false);
				btnGuardar.setVisible(false);
				btnActualizar.setVisible(false);
				btnBorrar.setVisible(false);
				scrollPaneProductos.setVisible(false);
				
				
				textFieldNombreLogin.setText("");
            	textFieldCorreoLogin.setText("");
            	textFieldNombre.setText("");
				textFieldCorreo.setText("");
				textFieldTelefono.setText("");
				textFieldLocalizacion.setText("");
				textFieldFechaNac.setText("");
				textFieldFechaInicio.setText("");
            	
			}
		});
		btnCerrarSesion.setBounds(220, 697, 151, 23);
		frameAlmacen.getContentPane().add(btnCerrarSesion);
		
		
		
		
		
		
		
	
		
	
		
		
		 textFieldNombre.addFocusListener(new FocusAdapter() {
	        	@Override
	        	public void focusLost(FocusEvent e) {
	        		Pattern pat = Pattern.compile("^[A-Za-zÑñÁáÉéÍíÓóÚúÜü ]{1,50}$");
					Matcher mat = pat.matcher(textFieldNombre.getText());
					if (!mat.matches()) {
						textFieldNombre.setText("Error");
		
					}
	        	}
	        	
	        	
	        });

	     
	        
	        
	        textFieldNombreLogin.addFocusListener(new FocusAdapter() {
	        	@Override
	        	public void focusLost(FocusEvent e) {
	        		Pattern pat = Pattern.compile("^[A-Za-zÑñÁáÉéÍíÓóÚúÜü ]{1,50}$");
					Matcher mat = pat.matcher(textFieldNombreLogin.getText());
					if (!mat.matches()) {
						textFieldNombreLogin.setText("Error");
		
					}
	        	}
	        	
	        	
	        });

	

	        textFieldCorreo.addFocusListener(new FocusAdapter() {
	            @Override
	            public void focusLost(FocusEvent e) {
	                String correo = textFieldCorreo.getText();
	                String regex = "^\\w+@\\w+\\.[a-z]{2,3}$";
	                Pattern pattern = Pattern.compile(regex);
	                Matcher matcher = pattern.matcher(correo);
	                if (!matcher.matches()) {
	               
	                	textFieldCorreo.setText("Error");
	                }
	            }

	          
	        });
	        
	        textFieldCorreoLogin.addFocusListener(new FocusAdapter() {
	            @Override
	            public void focusLost(FocusEvent e) {
	                String correo = textFieldCorreoLogin.getText();
	                String regex = "^\\w+@\\w+\\.[a-z]{2,3}$";
	                Pattern pattern = Pattern.compile(regex);
	                Matcher matcher = pattern.matcher(correo);
	                if (!matcher.matches()) {
	               
	                	textFieldCorreoLogin.setText("Error");
	                }
	            }

	        });
	        
	        textFieldTelefono.addFocusListener(new FocusAdapter() {
	        	@Override
	        	public void focusLost(FocusEvent e) {
	        		Pattern pat = Pattern.compile("^[67]\\d{8}$");
					Matcher mat = pat.matcher(textFieldTelefono.getText());
					if (!mat.matches()) {
						textFieldTelefono.setText("Error");
					
	        	}
	        		
	        	}
	        
	       
	    });
	        
	        textFieldLocalizacion.addFocusListener(new FocusAdapter() {
	        	@Override
	        	public void focusLost(FocusEvent e) {
	        		Pattern pat = Pattern.compile("^[A-Za-zÑñÁáÉéÍíÓóÚúÜü ]{1,50}$");
					Matcher mat = pat.matcher(textFieldLocalizacion.getText());
					if (!mat.matches()) {
						textFieldLocalizacion.setText("Error");
					
	        	}
	        		
	        	}
	        
	        

	 
	    });

	        textFieldFechaNac.addFocusListener(new FocusAdapter() {
	            @Override
	            public void focusLost(FocusEvent e) {
	                String fechaNacimiento = textFieldFechaNac.getText();
	                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	                try {
	                    LocalDate.parse(fechaNacimiento, formatter);
	                } catch (DateTimeParseException ex) {
	                 
	                	textFieldFechaNac.setText("Error");
	                }
	            }

	        });

	        textFieldFechaInicio.addFocusListener(new FocusAdapter() {
	            @Override
	            public void focusLost(FocusEvent e) {
	                String fechaInicio = textFieldFechaInicio.getText();
	                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	                try {
	                    LocalDate.parse(fechaInicio, formatter);
	                } catch (DateTimeParseException ex) {
	                  
	                    textFieldFechaInicio.setText("Error");
	                }
	            }

	        });

	       
	        btnEntrar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            
	            	List<Usuario> selectUsuarios = usuarioDao.selectAllUsuarios();
	            	boolean usuarioEncontrado = false;

	            	if(selectUsuarios.isEmpty())
	            	{
	            		JOptionPane.showMessageDialog(null, "No hay ningun usuario creado");
	            	}
	            	else 
	            		for (Usuario u :selectUsuarios)
	            		{
	            			String nombreBD = u.getNombre();
		                    String correoBD = u.getCorreoElectronico() ;
		                   
		                    String nombre = textFieldNombreLogin.getText();
		                    String correo = textFieldCorreoLogin.getText();
		                  
		                    if(nombreBD.equals(nombre) && correoBD.equals(correo))
		                    {
		                    	usuarioEncontrado = true;
		                    	break;
		                    }
	            		}
	            	if (usuarioEncontrado) {
	            		textFieldPrecioPedido.setVisible(true);
	            		textFieldCantidad.setVisible(true);
		                    	textFieldNombreLogin.setVisible(false);
		                    	textFieldCorreoLogin.setVisible(false);
		                    	lblCorreoRegistroUsuario.setVisible(false);
		                    	lblLogin.setVisible(false);
		                    	btnGuardarPedido.setVisible(true);
		                    	btnActualizarPedido.setVisible(true);
		                    	lblNombreLogin.setVisible(false);
			            	textFieldNombre.setVisible(false);
		              	  textFieldCorreo.setVisible(false);
		              	  textFieldTelefono.setVisible(false);
		              	  textFieldLocalizacion.setVisible(false);
		              	  textFieldFechaNac.setVisible(false);
		              	  textFieldFechaInicio.setVisible(false);
		              	 btnEntrar.setVisible(false);
		              	 btnBorrarPedido.setVisible(true);
		              	textFieldNombrePedido.setVisible(true);
		              		  lblNombreRegistro.setVisible(false);
		              		  lblCorreoRegistro.setVisible(false);
		              		  lblTelfono.setVisible(false);
		              		  lblLocalizacin.setVisible(false);
		              		  lblFechaInicio.setVisible(false);
		              		  lblFechaNacimiento.setVisible(false);
		              		  btnRegistrarse.setVisible(false);
		              		scrollPanePedidos.setVisible(true);
		              		lblRegistro_1.setVisible(false);
		              		lblDatosPedido.setVisible(true);
		                  frameAlmacen.setVisible(true);
		                  tableProductos.setVisible(true);
		                  tablePedidos.setVisible(true);
		                  btnCerrarSesion.setVisible(true);
		                  txtId.setVisible(true);
		                  txtNombre.setVisible(true);
		                  txtPrecio.setVisible(true);
		                  txtStock.setVisible(true);
		          		comboBoxPedido.setVisible(true);
		                  comboBoxSeleccionarCategoria.setVisible(true);
		                  lblTitulo.setVisible(true);
		                  lblNombre.setVisible(true);
		                  lblCategoria.setVisible(true);
		                  lblPrecio.setVisible(true);
		                  lblStock.setVisible(true);
		                  lblMostrarDatos.setVisible(true);
		          	  lblSeleccionarPeriodoDe.setVisible(true);
		          	  lblSeleccionarCategoria.setVisible(true);
		          	  comboBoxEscogerCategoria.setVisible(true);
		          	  comboBoxSeleccionarTiempo.setVisible(true);
		          	  rdbtnMostrarTodos.setVisible(true);
		          	  rdbtnMostrarProductosCategoria.setVisible(true);
		          	  rdbtnMostrarProductosSinUnidades.setVisible(true);
		          	  rdbtnMostrarProductosCaducados.setVisible(true);
		          	  btnGuardar.setVisible(true);
		          	  btnActualizar.setVisible(true);
		          	  btnBorrar.setVisible(true);
		          	  scrollPaneProductos.setVisible(true);
		          	lblNombrePedido.setVisible(true);
		          	lblCantidadPedido.setVisible(true);
		          	lblPrecioPedido.setVisible(true);
		          	lblProductoPedido.setVisible(true);
		          	lblDatosPedido.setVisible(true);
		          	lblId.setVisible(true);
	            		}
		                    else
		                    {
		                    	JOptionPane.showMessageDialog(null, "Hay datos incorrectos");
		                    }
	            	
	            }
	        });
	     
	      
		
		
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
			/**
			 * Este evento sirve para que cuando el usuario le de a una fila de la tabla se
			 * muestre en los text field
			 * 
			 */
			public void mouseClicked(MouseEvent e) {
				int índice = tablePedidos.getSelectedRow();
				TableModel model = tablePedidos.getModel();
				textFieldNombrePedido.setText(model.getValueAt(índice, 1).toString());
				Object valorSeleccionado = model.getValueAt(índice, 2); // obtiene el valor de la columna de la producto
				 comboBoxPedido.setSelectedItem(valorSeleccionado.toString());
                textFieldCantidad.setText(model.getValueAt(índice, 3).toString());
                textFieldPrecioPedido.setText(model.getValueAt(índice, 4).toString());
				;
				
				
			
			}
		});
		
		 
	
	}
	}