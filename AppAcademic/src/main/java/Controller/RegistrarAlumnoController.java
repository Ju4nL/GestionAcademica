package Controller;

import Dao.AlumnoDAOImpl;
import Model.RegistrarAlumno;
import Model.VacantModel;
import View.ParentsPanelVacantsForm;
import javax.swing.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

public class RegistrarAlumnoController {

    private AlumnoDAOImpl registrarAlumnoDAO;
    private ParentController principalController;
    private ParentsPanelVacantsForm parentsPanelVacantsForm;

    public RegistrarAlumnoController(ParentController principalController) {
        this.registrarAlumnoDAO = new AlumnoDAOImpl();
        this.principalController = principalController;
    }

    public void displayRegistrarAlumnoForm(int vacanteId, String grado , String seccion) {
        // Crear una nueva instancia del formulario de registro
        parentsPanelVacantsForm = new ParentsPanelVacantsForm(vacanteId, grado,seccion);

        // Mostrar el formulario de registro
        principalController.showPanel(parentsPanelVacantsForm);

        // Agregar el action listener para el botón de registro
        parentsPanelVacantsForm.getBtnRegistrarSolicitud().addActionListener(e -> registerAlumno());
    }

    public void registerAlumno() {
        try {
            String dni = parentsPanelVacantsForm.getTxtDni().getText();

            // Verificar la longitud del DNI
            if (dni.length() > 8) { 
                parentsPanelVacantsForm.displayErrorMessage("El DNI es demasiado largo.");
                return;
            }

            String nombre = parentsPanelVacantsForm.getTxtName().getText();
            String apellidos = parentsPanelVacantsForm.getTxtLastName().getText();
            LocalDate fechaNacimiento = parentsPanelVacantsForm.getJdcFechaNac().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            String sexo = parentsPanelVacantsForm.getCbxSexo().getSelectedItem().toString();
            String direccion = parentsPanelVacantsForm.getTxtAddress().getText();
            String telefono = parentsPanelVacantsForm.getTxtPhone().getText();
            String correo = parentsPanelVacantsForm.getTxtEmail().getText();
            String contraseña = new String(parentsPanelVacantsForm.getPswPassword().getPassword());
            String grado = parentsPanelVacantsForm.getGrado();
            String seccion = parentsPanelVacantsForm.getSeccion();

            RegistrarAlumno alumno = new RegistrarAlumno(dni, nombre, apellidos, fechaNacimiento, sexo, direccion, telefono, correo, contraseña, grado,seccion);

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
