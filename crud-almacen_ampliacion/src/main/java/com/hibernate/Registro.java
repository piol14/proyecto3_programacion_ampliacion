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
        frameRegistro.setBounds(100, 100, 450, 500);
        frameRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameRegistro.getContentPane().setLayout(null);

        JLabel lblRegistro = new JLabel("Registro de Usuario");
        lblRegistro.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblRegistro.setBounds(131, 27, 183, 14);
        frameRegistro.getContentPane().add(lblRegistro);

        textFieldNombre = new JTextField();
        textFieldNombre.setBounds(223, 139, 164, 20);
        frameRegistro.getContentPane().add(textFieldNombre);
        textFieldNombre.setColumns(10);

        textFieldCorreoElectronico = new JTextField();
        textFieldCorreoElectronico.setBounds(223, 170, 164, 20);
        frameRegistro.getContentPane().add(textFieldCorreoElectronico);
        textFieldCorreoElectronico.setColumns(10);

        textFieldTelefono = new JTextField();
        textFieldTelefono.setBounds(223, 201, 164, 20);
        frameRegistro.getContentPane().add(textFieldTelefono);
        textFieldTelefono.setColumns(10);

        textFieldLocalizacion = new JTextField();
        textFieldLocalizacion.setBounds(223, 232, 164, 20);
        frameRegistro.getContentPane().add(textFieldLocalizacion);
        textFieldLocalizacion.setColumns(10);

        textFieldFechaNacimiento = new JTextField();
        textFieldFechaNacimiento.setBounds(223, 263, 164, 20);
        frameRegistro.getContentPane().add(textFieldFechaNacimiento);
        textFieldFechaNacimiento.setColumns(10);

        textFieldFechaInicio = new JTextField();
        textFieldFechaInicio.setBounds(223, 294, 164, 20);
        frameRegistro.getContentPane().add(textFieldFechaInicio);
        textFieldFechaInicio.setColumns(10);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(70, 142, 71, 14);
        frameRegistro.getContentPane().add(lblNombre);

        JLabel lblCorreoElectrnico = new JLabel("Correo Electrónico:");
        lblCorreoElectrnico.setBounds(70, 173, 124, 14);
        frameRegistro.getContentPane().add(lblCorreoElectrnico);

        JLabel lblTelfono = new JLabel("Teléfono:");
        lblTelfono.setBounds(70, 204, 71, 14);
        frameRegistro.getContentPane().add(lblTelfono);

        JLabel lblLocalizacin = new JLabel("Localización:");
        lblLocalizacin.setBounds(70, 235, 82, 14);
        frameRegistro.getContentPane().add(lblLocalizacin);

        JLabel lblFechaNacimiento = new JLabel("Fecha de Nacimiento:");
        lblFechaNacimiento.setBounds(70, 266, 124, 14);
        frameRegistro.getContentPane().add(lblFechaNacimiento);

        JLabel lblFechaInicio = new JLabel("Fecha de Inicio:");
        lblFechaInicio.setBounds(70, 297, 98, 14);
        frameRegistro.getContentPane().add(lblFechaInicio);

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
                String regex = "^(.+)@(.+)$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(correo);
                if (!matcher.matches()) {
                    JOptionPane.showMessageDialog(null, "Correo electrónico inválido");
                    textFieldCorreoElectronico.setText("Error");
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                textFieldCorreoElectronico.setText("");
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
                    JOptionPane.showMessageDialog(null, "Fecha de nacimiento inválida");
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
                    JOptionPane.showMessageDialog(null, "Fecha de inicio inválida");
                    textFieldFechaInicio.setText("Error");
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                textFieldFechaInicio.setText("");
            }
        });

        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (registrado) {
                        // Si el usuario ya está registrado, mostrar un mensaje o realizar acciones para actualizar el perfil
                        JOptionPane.showMessageDialog(null, "El perfil ya está registrado");
                        // Realizar las acciones necesarias para actualizar el perfil
                    } else {
                        // Realizar el registro del usuario
                    	 UsuarioDAO usuarioDao= new UsuarioDAO();
                        String nombre = textFieldNombre.getText();
                        String correo = textFieldCorreoElectronico.getText();
                        String telefono = textFieldTelefono.getText();
                        String localizacion = textFieldLocalizacion.getText();
                        String fechaNacimiento = textFieldFechaNacimiento.getText();
                        String fechaInicio = textFieldFechaInicio.getText();
                       Usuario usuario = new Usuario(nombre, correo, telefono, localizacion, fechaNacimiento,fechaInicio);
                        usuarioDao.insertUsuario(usuario);
                        

                       
                        registrado = true;

                        
                        JOptionPane.showMessageDialog(null, "Registro exitoso");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnEntrar.setBounds(166, 360, 89, 23);
        frameRegistro.getContentPane().add(btnEntrar);
    }
}

