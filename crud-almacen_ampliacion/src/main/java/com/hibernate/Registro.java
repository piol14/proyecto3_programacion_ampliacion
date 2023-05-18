package com.hibernate;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import com.hibernate.dao.OfertaDAO;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import com.hibernate.model.Usuario;
import com.hibernate.dao.UsuarioDAO;
import java.awt.Color;
public class Registro {

    private JFrame frameRegistro;
    private JTextField textFieldNombre;
    private JTextField textFieldCorreoElectronico;
    private JTextField textFieldTelefono;
    private JTextField textFieldLocalizacion;
    private JTextField textFieldFechaNacimiento;
    private JTextField textFieldFechaInicio;
    private boolean registrado = false; // Variable para controlar el estado de registro
    static UsuarioDAO usuarioDao= new UsuarioDAO();
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

    public Registro() {
        initialize();
    }

    private void initialize() {
        frameRegistro = new JFrame();
        frameRegistro.getContentPane().setBackground(Color.PINK);
        frameRegistro.setBounds(100, 100, 627, 659);
        frameRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameRegistro.getContentPane().setLayout(null);

        JLabel lblRegistro = new JLabel("Registro de Usuario");
        lblRegistro.setFont(new Font("Dialog", Font.BOLD, 20));
        lblRegistro.setBounds(192, 56, 256, 54);
        frameRegistro.getContentPane().add(lblRegistro);

        textFieldNombre = new JTextField();
        textFieldNombre.setBounds(310, 136, 164, 20);
        frameRegistro.getContentPane().add(textFieldNombre);
        textFieldNombre.setColumns(10);

        textFieldCorreoElectronico = new JTextField();
        textFieldCorreoElectronico.setBounds(310, 167, 164, 20);
        frameRegistro.getContentPane().add(textFieldCorreoElectronico);
        textFieldCorreoElectronico.setColumns(10);

        textFieldTelefono = new JTextField();
        textFieldTelefono.setBounds(310, 198, 164, 20);
        frameRegistro.getContentPane().add(textFieldTelefono);
        textFieldTelefono.setColumns(10);

        textFieldLocalizacion = new JTextField();
        textFieldLocalizacion.setBounds(310, 232, 164, 20);
        frameRegistro.getContentPane().add(textFieldLocalizacion);
        textFieldLocalizacion.setColumns(10);

        textFieldFechaNacimiento = new JTextField();
        textFieldFechaNacimiento.setBounds(310, 260, 164, 20);
        frameRegistro.getContentPane().add(textFieldFechaNacimiento);
        textFieldFechaNacimiento.setColumns(10);

        textFieldFechaInicio = new JTextField();
        textFieldFechaInicio.setBounds(310, 294, 164, 20);
        frameRegistro.getContentPane().add(textFieldFechaInicio);
        textFieldFechaInicio.setColumns(10);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Dialog", Font.BOLD, 14));
        lblNombre.setBounds(70, 142, 71, 14);
        frameRegistro.getContentPane().add(lblNombre);

        JLabel lblCorreoElectrnico = new JLabel("Correo Electrónico:");
        lblCorreoElectrnico.setFont(new Font("Dialog", Font.BOLD, 14));
        lblCorreoElectrnico.setBounds(70, 173, 185, 14);
        frameRegistro.getContentPane().add(lblCorreoElectrnico);

        JLabel lblTelfono = new JLabel("Teléfono:");
        lblTelfono.setFont(new Font("Dialog", Font.BOLD, 14));
        lblTelfono.setBounds(70, 204, 154, 14);
        frameRegistro.getContentPane().add(lblTelfono);

        JLabel lblLocalizacin = new JLabel("Localización:");
        lblLocalizacin.setFont(new Font("Dialog", Font.BOLD, 14));
        lblLocalizacin.setBounds(70, 235, 154, 14);
        frameRegistro.getContentPane().add(lblLocalizacin);

        JLabel lblFechaNacimiento = new JLabel("Fecha de Nacimiento:");
        lblFechaNacimiento.setFont(new Font("Dialog", Font.BOLD, 14));
        lblFechaNacimiento.setBounds(70, 266, 185, 14);
        frameRegistro.getContentPane().add(lblFechaNacimiento);

        JLabel lblFechaInicio = new JLabel("Fecha de Inicio:");
        lblFechaInicio.setFont(new Font("Dialog", Font.BOLD, 14));
        lblFechaInicio.setBounds(70, 297, 185, 17);
        frameRegistro.getContentPane().add(lblFechaInicio);
        
        
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

        textFieldNombre.addFocusListener(new FocusAdapter() {
        	
        	
            @Override
            public void focusGained(FocusEvent e) {
                textFieldNombre.setText("");
            }
        });

        textFieldCorreoElectronico.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String correo = textFieldCorreoElectronico.getText();
                String regex = "^\\w+@\\w+\\.[a-z]{2,3}$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(correo);
                if (!matcher.matches()) {
               
                    textFieldCorreoElectronico.setText("Error");
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                textFieldCorreoElectronico.setText("");
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

        textFieldFechaNacimiento.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String fecha = textFieldFechaNacimiento.getText();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                try {
                    LocalDate.parse(fecha, formatter);
                } catch (DateTimeParseException ex) {
                 
                    textFieldFechaNacimiento.setText("Error");
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                textFieldFechaNacimiento.setText("");
            }
        });

        textFieldFechaInicio.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String fecha = textFieldFechaInicio.getText();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                try {
                    LocalDate.parse(fecha, formatter);
                } catch (DateTimeParseException ex) {
                  
                    textFieldFechaInicio.setText("Error");
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                textFieldFechaInicio.setText("");
            }
        });

        JButton btnEntrar = new JButton("Registrarse");
        btnEntrar.setBackground(new Color(176, 224, 230));
        btnEntrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	 
                 
                try {
                	
                	String nombre = textFieldNombre.getText();
                    String correo = textFieldCorreoElectronico.getText();
                    String telefono = textFieldTelefono.getText();
                    String localizacion = textFieldLocalizacion.getText();
                    String fechaNacimiento = textFieldFechaNacimiento.getText();
                    String fechaInicio = textFieldFechaInicio.getText();
                    
                    if (registrado) {
                        // Si el usuario ya está registrado, mostrar un mensaje o realizar acciones para actualizar el perfil
                        JOptionPane.showMessageDialog(null, "El perfil ya está registrado");
                        // Realizar las acciones necesarias para actualizar el perfil
                    } else if (nombre.equals("Error")|| correo.equals("Error") || telefono.equals("Error") || localizacion.equals("Error")
                    		|| fechaNacimiento.equals("Error")|| fechaInicio.equals("Error")){
                    	JOptionPane.showMessageDialog(null, "Hay datos erróneos");
                
                    }else {
                    
                        // Realizar el registro del usuario
                    	 UsuarioDAO usuarioDao= new UsuarioDAO();
                       
                       Usuario usuario = new Usuario(nombre, correo, telefono, localizacion, fechaNacimiento,fechaInicio);
                       if(usuarioDao.selectAllUsuarios().isEmpty())
                       {
                        usuarioDao.insertUsuario(usuario);
                        JOptionPane.showMessageDialog(null, "Registro exitoso");
                       }
                       else
                       {
                    	   JOptionPane.showMessageDialog(null, "Ya hay un usuario creado ");
                       }
                       
                        registrado = true;

                        
                       
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnEntrar.setBounds(70, 360, 154, 25);
        frameRegistro.getContentPane().add(btnEntrar);
        
        JButton btnActualizarUsuario = new JButton("Actualizar usuario");
        btnActualizarUsuario.setBackground(new Color(176, 224, 230));
        btnActualizarUsuario.setBounds(310, 360, 176, 25);
        frameRegistro.getContentPane().add(btnActualizarUsuario);
        
        JButton btnEntrar_1 = new JButton("Entrar");
        btnEntrar_1.setBackground(new Color(176, 224, 230));
        btnEntrar_1.setBounds(187, 458, 176, 25);
        frameRegistro.getContentPane().add(btnEntrar_1);
    }
}

