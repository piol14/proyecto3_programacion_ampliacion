package com.hibernate;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;



import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registro {

	private JFrame frameRegistro;
	private JTextField textFieldNombre;
	private JTextField textFieldCorreoElectronico;
	private JTextField textFieldTelefono;
	private JTextField textFieldLocalizacion;
	private JTextField textFieldFechaNacimiento;
	private JTextField textFieldFechaInicio;

	/**
	 * Launch the application.
	 */

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro window = new Registro();
					window.frameRegistro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public Registro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameRegistro = new JFrame();
		frameRegistro.getContentPane().setBackground(new Color(255, 255, 204));
		frameRegistro.setBounds(100, 100, 631, 543);
		frameRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameRegistro.getContentPane().setLayout(null);

		JLabel lblBienvenida = new JLabel("Bienvenido al rincón de los Sabores");
		lblBienvenida.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBienvenida.setBounds(122, 27, 410, 31);
		frameRegistro.getContentPane().add(lblBienvenida);

		JLabel lblRegistro = new JLabel("REGISTRO");
		lblRegistro.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblRegistro.setBounds(223, 69, 174, 42);
		frameRegistro.getContentPane().add(lblRegistro);

		textFieldNombre = new JTextField();
		textFieldNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		textFieldNombre.setBounds(293, 135, 191, 20);
		frameRegistro.getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);

		textFieldCorreoElectronico = new JTextField();
		textFieldCorreoElectronico.setBounds(293, 166, 191, 20);
		frameRegistro.getContentPane().add(textFieldCorreoElectronico);
		textFieldCorreoElectronico.setColumns(10);

		textFieldTelefono = new JTextField();
		textFieldTelefono.setBounds(293, 197, 191, 20);
		frameRegistro.getContentPane().add(textFieldTelefono);
		textFieldTelefono.setColumns(10);

		textFieldLocalizacion = new JTextField();
		textFieldLocalizacion.setBounds(293, 228, 191, 20);
		frameRegistro.getContentPane().add(textFieldLocalizacion);
		textFieldLocalizacion.setColumns(10);

		textFieldFechaNacimiento = new JTextField();
		textFieldFechaNacimiento.setBounds(293, 259, 191, 20);
		frameRegistro.getContentPane().add(textFieldFechaNacimiento);
		textFieldFechaNacimiento.setColumns(10);

		textFieldFechaInicio = new JTextField();
		textFieldFechaInicio.setBounds(293, 290, 191, 20);
		frameRegistro.getContentPane().add(textFieldFechaInicio);
		textFieldFechaInicio.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre Usuario");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(83, 141, 200, 14);
		frameRegistro.getContentPane().add(lblNombre);

		JLabel lblCorreo = new JLabel("Correo Electronico");
		lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCorreo.setBounds(83, 172, 183, 14);
		frameRegistro.getContentPane().add(lblCorreo);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefono.setBounds(83, 203, 200, 14);
		frameRegistro.getContentPane().add(lblTelefono);

		JLabel lblLocalizacion = new JLabel("Localización");
		lblLocalizacion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLocalizacion.setBounds(83, 234, 200, 14);
		frameRegistro.getContentPane().add(lblLocalizacion);

		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFechaNacimiento.setBounds(83, 265, 183, 14);
		frameRegistro.getContentPane().add(lblFechaNacimiento);

		JLabel lblFechaIncorporacion = new JLabel("Fecha Incorporacion");
		lblFechaIncorporacion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFechaIncorporacion.setBounds(83, 296, 200, 14);
		frameRegistro.getContentPane().add(lblFechaIncorporacion);

		textFieldLocalizacion.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Pattern pat = Pattern.compile("^[A-Za-zÑñÁáÉéÍíÓóÚúÜü ]{1,50}$");
				Matcher mat = pat.matcher(textFieldLocalizacion.getText());
				if (!mat.matches()) {
					textFieldLocalizacion.setText("Error");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				textFieldLocalizacion.setText("");
			}
		});

		textFieldNombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Pattern pat = Pattern.compile("^[A-Za-zÑñÁáÉéÍíÓóÚúÜü ]{1,50}$");
				Matcher mat = pat.matcher(textFieldNombre.getText());
				if (!mat.matches()) {
					textFieldNombre.setText("Error");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				textFieldNombre.setText("");
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

			@Override
			public void focusGained(FocusEvent e) {
				textFieldTelefono.setText("");
			}
		});

		
		textFieldCorreoElectronico.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Pattern pat = Pattern.compile("^\\w+@\\w+\\.[a-z]{2,3}$");
				Matcher mat = pat.matcher(textFieldCorreoElectronico.getText());
				if (!mat.matches()) {
					textFieldCorreoElectronico.setText("Error");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				textFieldCorreoElectronico.setText("");
			}
		});

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {	
				    	String fechaNacimiento = textFieldFechaNacimiento.getText();
						SimpleDateFormat formatoNacimiento = new SimpleDateFormat("dd/MM/yyyy");
						
						String fechaIncorporacion = textFieldFechaInicio.getText();
						SimpleDateFormat formatoIncorporacion = new SimpleDateFormat("dd/MM/yyyy");
						
						if (fechaNacimiento.equals("")) {
							

						} else {
							LocalDate comprobarFechaNacimiento = LocalDate.parse(fechaNacimiento,
									DateTimeFormatter.ofPattern("dd/MM/yyyy"));
							
							LocalDate comprobarFechaIncorporacion = LocalDate.parse(fechaIncorporacion,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
							
							Period edad = Period.between(comprobarFechaNacimiento, comprobarFechaIncorporacion);
							
							if (edad.getYears() < 18) {
								JOptionPane.showMessageDialog(null, "El usuario es menor de edad");
							
						}else if (textFieldNombre.getText().isEmpty() || textFieldFechaNacimiento.getText().isEmpty() ||
								textFieldCorreoElectronico.getText().isEmpty() ||  textFieldTelefono.getText().isEmpty() ||  textFieldLocalizacion.getText().isEmpty()
										|| textFieldFechaInicio.getText().isEmpty()) {
									JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
									
							} else if (textFieldNombre.getText().equals("Error") || textFieldFechaNacimiento.getText().equals("Error") 
									|| textFieldCorreoElectronico.getText().equals("Error") || textFieldTelefono.getText().equals("Error")
									|| textFieldLocalizacion.getText().equals("Error") || textFieldFechaInicio.getText().equals("Error"))
									 {
								    JOptionPane.showMessageDialog(null, "Hay datos erróneos");
							}
						
						else {
								
								 
					    	  	 
					    	  
					    	      JOptionPane.showMessageDialog(null, "Perfil creado correctamente !!!");
					    	
					    	    
					    	        
							}
						}
						 
				    }catch(DateTimeParseException error ) {
				    	JOptionPane.showMessageDialog(null, "Fechas mal introducidas");
				    }catch(NullPointerException error2) {
				    	JOptionPane.showMessageDialog(null, "Departamento está vacío");
				    }
			}
		});
		btnEntrar.setBounds(223, 383, 164, 23);
		frameRegistro.getContentPane().add(btnEntrar);

	}
}
