package Controller;

import Dao.CursoDAOImpl;
import Dao.SolicitudVacanteDAOImpl;
import Model.Curso;
import View.AdminPanelCursos;
import View.AdminPanelVacantes;
import View.PanelSolicitudes;
import View.ParentsPanelVacantsForm;
import View.SolicitudesTableModel;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class SolicitudesController {

    private AdminController principalController;
    private ParentController parentController;
    private SolicitudVacanteDAOImpl solicitudDao;
    private PanelSolicitudes panelsolicitudes;
    private int padre_id;
    private boolean is_admin;

    public SolicitudesController(AdminController principalController) {
        this.is_admin = true;
        this.principalController = principalController;
        this.solicitudDao = new SolicitudVacanteDAOImpl();
        this.panelsolicitudes = new PanelSolicitudes(is_admin, this);
        initController();

    }

    public SolicitudesController(ParentController parentController, int padre_id) {
        this.is_admin = false;
        this.padre_id = padre_id;
        this.parentController = parentController;
        this.solicitudDao = new SolicitudVacanteDAOImpl();
        this.panelsolicitudes = new PanelSolicitudes(is_admin, this);
        initController();
    }

    private void initController() {
        if (is_admin) {
            panelsolicitudes.getBtnAprobar().addActionListener(e -> updateSolicitud("Aprobada"));
            panelsolicitudes.getBtnRechazar().addActionListener(e -> updateSolicitud("Rechazada"));
            panelsolicitudes.getBtnVer().addActionListener(e -> displayformSolicitud());

        } else {
            panelsolicitudes.getBtnCancelar().addActionListener(e -> updateSolicitud("Cancelada"));
        }

        loadSolicitudes();
    }

    public PanelSolicitudes getPanelSolicitudes() {
        return panelsolicitudes;
    }

    public void loadSolicitudes() {
        try {
            List<String[]> solicitudes;
            if (is_admin) {
                solicitudes = solicitudDao.getAllSolicitudes();
            } else {
                solicitudes = solicitudDao.getSolicitudesByPadreId(padre_id);
            }
            SolicitudesTableModel solicitudesTableModel = new SolicitudesTableModel();
            solicitudesTableModel.setRowCount(0);
            for (String[] solicitud : solicitudes) {
                solicitudesTableModel.addSolicitud(solicitud[0], solicitud[1], solicitud[2], solicitud[3], solicitud[4]);
            }
            panelsolicitudes.getTblSolicitudes().setModel(solicitudesTableModel);
        } catch (Exception e) {
            panelsolicitudes.displayErrorMessage("Error al cargar cursos: " + e.getMessage());
        }
    }

    public void updateSolicitud(String valor) {
        int rowIndex = this.panelsolicitudes.getTblSolicitudes().getSelectedRow();
        if (rowIndex == -1) {
            System.out.println("No row selected");
            return;
        }

        int id = Integer.parseInt(panelsolicitudes.getTblSolicitudes().getValueAt(rowIndex, 0).toString());

        if (solicitudDao.updateEstadoSolicitud(id, valor)) {
            this.principalController.displaySucessMessage("Se actualizo la solicitud ");
            loadSolicitudes();
        } else {
            this.principalController.displayErrorMessage("No se actualizo la solicitud ");
        }
    }

    private void displayformSolicitud() {
        int rowIndex = this.panelsolicitudes.getTblSolicitudes().getSelectedRow();
        if (rowIndex == -1) {
            System.out.println("No row selected");
            return;
        }
        int id = Integer.parseInt(panelsolicitudes.getTblSolicitudes().getValueAt(rowIndex, 0).toString());

        List<String[]> detailSolicitud = solicitudDao.getDetailsSolicitud(id);

        if (!detailSolicitud.isEmpty()) {
            String[] detalle = detailSolicitud.get(0); // Obtener el primer elemento de la lista
            ParentsPanelVacantsForm formView = new ParentsPanelVacantsForm();
            this.principalController.showPanel(formView);
            
            formView.getTxtDni().setText(detalle[0]);
            formView.getTxtName().setText(detalle[1]);
            formView.getTxtLastName().setText(detalle[2]);
            formView.getJdcFechaNac().setDate(java.sql.Date.valueOf(detalle[5]));
            formView.getCbxSexo().setSelectedItem(detalle[6]);
            formView.getTxtAddress().setText(detalle[3]);
            formView.getTxtPhone().setText(detalle[4]);
            formView.getTxtEmail().setText(detalle[7]);
            formView.getPswPassword().setText(detalle[8]);
        } else {
            System.out.println("Curso not found with ID: " + id);
        }
    }

    /*
    private void registerAlumno() {
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

            RegistrarAlumno alumno = new RegistrarAlumno(dni, nombre, apellidos, fechaNacimiento, sexo, direccion, telefono, correo, contraseña, grado);

            if (registrarAlumnoDAO.insertAlumno(alumno)) {
                parentsPanelVacantsForm.displaySucessMessage("Alumno registrado con éxito.");
            } else {
                parentsPanelVacantsForm.displayErrorMessage("Error al registrar alumno.");
            }
        } catch (Exception e) {
            parentsPanelVacantsForm.displayErrorMessage("Error: " + e.getMessage());
        }
    }
     */
}
