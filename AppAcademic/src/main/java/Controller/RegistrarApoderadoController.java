package Controller;
//Model 

import Model.RegistrarApoderado;
import Dao.ApoderadoDAOImpl;

//View
import View.RegisterFrame;

//Controller
import Controller.RegistrarApoderadoController;
import View.LoginFrame;

//Utils
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class RegistrarApoderadoController {

    private RegisterFrame registerFrame;
    private ApoderadoDAOImpl apoderadoDAOImpl;
    private int usuarioID;
    private LoginFrame loginFrame;

    public RegistrarApoderadoController(RegisterFrame RegisterFrame, ApoderadoDAOImpl apoderadoDAOImpl, int usuarioID, LoginFrame loginFrame) {
        this.registerFrame = RegisterFrame;
        this.apoderadoDAOImpl = apoderadoDAOImpl;
        this.usuarioID = usuarioID;
        this.loginFrame = loginFrame;
        initController();
    }

    public void initController() {
        registerFrame.getBtnRegistrate().addActionListener(e -> registrate());

        addDocumentListeners();
    }

    private void addDocumentListeners() {
        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateEmail();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateEmail();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateEmail();
            }
        };

        registerFrame.getTxtName().getDocument().addDocumentListener(documentListener);
        registerFrame.getTxtLastName().getDocument().addDocumentListener(documentListener);
    }

    private void updateEmail() {
        String nombre = registerFrame.getTxtName().getText().trim();
        String apellidos = registerFrame.getTxtLastName().getText().trim();
        if (!nombre.isEmpty() && !apellidos.isEmpty()) {
            String email = nombre.toLowerCase() + "." + apellidos.toLowerCase() + "@jgp.edu.pe";
            registerFrame.getTxtEmail().setText(email);
        }
    }

    public void registrate() {
        try {

            String nombre = registerFrame.getTxtName().getText();
            String apellidos = registerFrame.getTxtLastName().getText();
            String dni = registerFrame.getTxtDni().getText();
            String genero = registerFrame.getCbxGender().getSelectedItem().toString().substring(0, 1); // Solo el primer carácter
            java.util.Date fechaNacDate = registerFrame.getJdcFechaNac().getDate();
            java.sql.Date sqlFechaNac = new java.sql.Date(fechaNacDate.getTime());

            String telefono = registerFrame.getTxtPhone().getText();
            String email = registerFrame.getTxtEmail().getText();
            String direccion = registerFrame.getTxtAddress().getText();
            String contrasena = new String(registerFrame.getPswPassword1().getPassword());

            if (dni.length() != 8 || !dni.matches("\\d+")) {
                throw new IllegalArgumentException("El DNI debe tener 8 dígitos.");
            }
            if (contrasena.length() < 6) {
                throw new IllegalArgumentException("La contraseña debe tener al menos 6 caracteres.");
            }

            RegistrarApoderado apoderado = new RegistrarApoderado(
                    nombre, apellidos, dni, genero,
                    fechaNacDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                    telefono, email, direccion, contrasena
            );

            boolean success = apoderadoDAOImpl.insertApoderado(apoderado);

            if (success) {

                registerFrame.displaySucessMessage("Apoderado registrado con éxito.");
                loginFrame.setVisible(true);
                registerFrame.setVisible(false);
                
            } else {

                registerFrame.displayErrorMessage("Error al registrar apoderado. Por favor, intente nuevamente.");
            }
        } catch (DateTimeParseException e) {

            registerFrame.displayErrorMessage("Formato de fecha incorrecto. Utilice el formato yyyy-MM-dd.");
        } catch (IllegalArgumentException e) {

            registerFrame.displayErrorMessage(e.getMessage());
        } catch (Exception e) {

            registerFrame.displayErrorMessage("Ocurrió un error al registrar el apoderado: " + e.getMessage());
        }
    }

}
