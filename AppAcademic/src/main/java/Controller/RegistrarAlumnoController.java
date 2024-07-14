package Controller;

import Dao.AlumnoDAOImpl;
import Model.RegistrarAlumno;
import Model.VacantModel;
import View.ParentsPanelVacantsForm;
import javax.swing.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class RegistrarAlumnoController {

    private AlumnoDAOImpl registrarAlumnoDAO;
    private ParentController principalController;
    private ParentsPanelVacantsForm parentsPanelVacantsForm;

    public RegistrarAlumnoController(ParentController principalController) {
        this.registrarAlumnoDAO = new AlumnoDAOImpl();
        this.principalController = principalController;
    }

    public void displayRegistrarAlumnoForm(int vacanteId, String grado, String seccion) {
        // Crear una nueva instancia del formulario de registro
        parentsPanelVacantsForm = new ParentsPanelVacantsForm(vacanteId, grado, seccion);

        // Deshabilitar el campo de texto del correo
        parentsPanelVacantsForm.setEmailFieldEnabled(false);

        // Mostrar el formulario de registro
        principalController.showPanel(parentsPanelVacantsForm);

        // Agregar el action listener para el botón de registro
        parentsPanelVacantsForm.getBtnRegistrarSolicitud().addActionListener(e -> registerAlumno());

        parentsPanelVacantsForm.getTxtName().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                updateEmail();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateEmail();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateEmail();
            }
        });

        parentsPanelVacantsForm.getTxtLastName().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                updateEmail();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateEmail();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateEmail();
            }
        });
    }

    private void updateEmail() {
        String nombre = parentsPanelVacantsForm.getTxtName().getText().trim();
        String apellidos = parentsPanelVacantsForm.getTxtLastName().getText().trim();
        if (!nombre.isEmpty() && !apellidos.isEmpty()) {
            String email = nombre.toLowerCase() + "." + apellidos.toLowerCase().replace(" ", "") + "@jgp.edu.pe";
            parentsPanelVacantsForm.getTxtEmail().setText(email);
        }

    }

    public void registerAlumno() {
        try {
            String dni = parentsPanelVacantsForm.getTxtDni().getText();

            // Verificar la longitud del DNI
            if (dni.length() > 8) {
                parentsPanelVacantsForm.displayErrorMessage("El DNI debe ser de 8 dígitos.");
                return;
            }

            String nombre = parentsPanelVacantsForm.getTxtName().getText();
            String apellidos = parentsPanelVacantsForm.getTxtLastName().getText();
            LocalDate fechaNacimiento = parentsPanelVacantsForm.getJdcFechaNac().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            String sexo = parentsPanelVacantsForm.getCbxSexo().getSelectedItem().toString();
            String direccion = parentsPanelVacantsForm.getTxtAddress().getText();
            String telefono = parentsPanelVacantsForm.getTxtPhone().getText();
            String correo = parentsPanelVacantsForm.getTxtEmail().getText();
            String contrasena = new String(parentsPanelVacantsForm.getPswPassword().getPassword());
            if (contrasena.length() < 6) {
                throw new IllegalArgumentException("La contraseña debe tener al menos 6 caracteres.");
            }
            String grado = parentsPanelVacantsForm.getGrado();
            String seccion = parentsPanelVacantsForm.getSeccion();

            RegistrarAlumno alumno = new RegistrarAlumno(dni, nombre, apellidos, fechaNacimiento, sexo, direccion, telefono, correo, contrasena, grado, seccion);
            alumno.setPadre_id(principalController.getId());
            if (registrarAlumnoDAO.insertAlumno(alumno)) {

                parentsPanelVacantsForm.displaySucessMessage("Alumno registrado con éxito.");
                principalController.showVacantePanel();
            } else {
                parentsPanelVacantsForm.displayErrorMessage("Error al registrar alumno.");
            }
        } catch (Exception e) {
            parentsPanelVacantsForm.displayErrorMessage("Error: " + e.getMessage());
        }
    }
}
