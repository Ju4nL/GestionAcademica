package Controller;

import Dao.DocenteDAOImpl;
import Model.Docente;
import View.AdminPanelDocentes;
import View.AdminPanelDocentesForm;
import java.time.LocalDate;
import java.util.Date;
import java.time.ZoneId;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class DocenteController {

    private AdminController principalController;
    private DocenteDAOImpl docenteDao;
    private AdminPanelDocentes adminPanelDocentes;

    public DocenteController(AdminController principalController) {
        this.principalController = principalController;
        this.docenteDao = new DocenteDAOImpl();
        this.adminPanelDocentes = new AdminPanelDocentes(this);
        initController();
    }

    public AdminPanelDocentes getAdminPanelDocentes() {
        return adminPanelDocentes;
    }

    private void initController() {

        adminPanelDocentes.getBtnAdd().addActionListener(e -> displayformDocenteCreate());
        adminPanelDocentes.getBtnUpdate().addActionListener(e -> displayformDocenteUpdate());
        adminPanelDocentes.getBtnSearch().addActionListener(e -> searchDocente());
        adminPanelDocentes.getBtnActivar().addActionListener(e -> setDocenteActive(true));
        adminPanelDocentes.getBtnDesactivate().addActionListener(e -> setDocenteActive(false));
        loadDocentes();
    }

    public void loadDocentes() {
        try {
            List<Docente> docentes = docenteDao.getAllDocentes();

            DefaultTableModel model = (DefaultTableModel) adminPanelDocentes.getTblDocentes().getModel();
            model.setColumnIdentifiers(new Object[]{"ID", "Nombre", "Activo?", "Email", "Telefono", "Tutor Aula"});
            TableColumnModel columnModel = adminPanelDocentes.getTblDocentes().getColumnModel();
            columnModel.getColumn(0).setMaxWidth(100);

            model.setRowCount(0);
            for (Docente docente : docentes) {
                model.addRow(new Object[]{docente.getId(), docente.getNombre(), docente.isActive(), docente.getEmail(), docente.getTelefono(), docente.getTutorAulaNombre()});
            }
        } catch (Exception e) {
            principalController.displayErrorMessage("Error al cargar docentes: " + e.getMessage());
        }
    }

    private void setDocenteActive(boolean is_Active) {
        int rowIndex = this.adminPanelDocentes.getTblDocentes().getSelectedRow();
        if (rowIndex == -1) {
            System.out.println("No row selected");
            return;
        }

        try {
            int docenteId = Integer.parseInt(adminPanelDocentes.getTblDocentes().getValueAt(rowIndex, 0).toString());
            docenteDao.setDocenteActive(docenteId, is_Active);
            principalController.displaySucessMessage("Se actualizo el estado del docente: ");
            loadDocentes();

        } catch (Exception e) {
            principalController.displayErrorMessage("Error al actualizar docente: " + e.getMessage());
        }
    }

    private void displayformDocenteCreate() {
        AdminPanelDocentesForm formCreate = new AdminPanelDocentesForm(true); 
        formCreate.setEmailFieldEnabled(false);
        this.principalController.showPanel(formCreate);
        
        formCreate.getBtnGuardar().addActionListener(e -> addDocente(formCreate));
        
        formCreate.getTxtName().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                updateEmail(formCreate);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateEmail(formCreate);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateEmail(formCreate);
            }
        });

        formCreate.getTxtLastName().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                updateEmail(formCreate);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateEmail(formCreate);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateEmail(formCreate);
            }
        });
    }
    
    private void updateEmail(AdminPanelDocentesForm formCreate) {
        String nombre = formCreate.getTxtName().getText().trim();
        String apellidos = formCreate.getTxtLastName().getText().trim();
        if (!nombre.isEmpty() && !apellidos.isEmpty()) {
            String email = nombre.toLowerCase() + "." + apellidos.toLowerCase().replace(" ", "") + "@jgp.edu.pe";
            formCreate.getTxtEmail().setText(email);
        }

    }

    private void addDocente(AdminPanelDocentesForm form) {
        Date date = form.getJdcFechaNac().getDate();
        LocalDate fechaNacimiento = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        Docente docente = new Docente(0,
                form.getTxtName().getText(),
                form.getTxtLastName().getText(),
                form.getTxtDni().getText(),
                form.getCbxSexo().getSelectedItem().toString(),
                fechaNacimiento,
                form.getTxtPhone().getText(),
                form.getTxtAddress().getText(),
                form.getTxtEmail().getText(),
                form.getTxtEmail().getText(),
                new String(form.getPswPassword().getPassword()),
                "docente",
                true,
                "-");

        if (docenteDao.insertDocente(docente)) {
            this.principalController.displaySucessMessage("Se creo el docente " + docente.getNombre());
            this.principalController.showDocentesPanel();
            loadDocentes();
        } else {
            this.principalController.displayErrorMessage("No se creo el docente " + docente.getNombre());
        }
    }

    private void displayformDocenteUpdate() {
        int rowIndex = this.adminPanelDocentes.getTblDocentes().getSelectedRow();
        if (rowIndex == -1) {
            System.out.println("No row selected");
            return;
        }

        try {
            int docenteId = Integer.parseInt(adminPanelDocentes.getTblDocentes().getValueAt(rowIndex, 0).toString());
            Docente docente = docenteDao.getDocenteById(docenteId);

            if (docente == null) {
                principalController.displayErrorMessage("No se pudo encontrar la docente seleccionada.");
                return;
            }

            AdminPanelDocentesForm formUpdate = new AdminPanelDocentesForm(true);

            formUpdate.getTxtDni().setText(docente.getDni());
            formUpdate.getTxtName().setText(docente.getNombre());
            formUpdate.getTxtLastName().setText(docente.getApellidos());
            formUpdate.getJdcFechaNac().setDate(java.sql.Date.valueOf(docente.getFechaNacimiento()));
            formUpdate.getCbxSexo().setSelectedItem(docente.getSexo());
            formUpdate.getTxtAddress().setText(docente.getDireccion());
            formUpdate.getTxtPhone().setText(docente.getTelefono());
            formUpdate.getTxtEmail().setText(docente.getEmail());
            formUpdate.getPswPassword().setText(docente.getPassword());
            
            formUpdate.getPswPassword().setEnabled(false);
            this.principalController.showPanel(formUpdate);
            formUpdate.getBtnGuardar().addActionListener(e -> updateDocente(formUpdate, docente.getId()));

        } catch (Exception e) {
            principalController.displayErrorMessage("Error al actualizar docente: " + e.getMessage());
        }
    }

    private void updateDocente(AdminPanelDocentesForm form, int docenteId) {
        Date date = form.getJdcFechaNac().getDate();
        LocalDate fechaNacimiento = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        Docente docente = new Docente(docenteId,
                form.getTxtName().getText(),
                form.getTxtLastName().getText(),
                form.getTxtDni().getText(),
                form.getCbxSexo().getSelectedItem().toString(),
                fechaNacimiento,
                form.getTxtPhone().getText(),
                form.getTxtAddress().getText(),
                form.getTxtEmail().getText(),
                form.getTxtEmail().getText(),
                new String(form.getPswPassword().getPassword()),
                "docente",
                true,
                "-");

        try {
            docenteDao.updateDocente(docente);
            principalController.displaySucessMessage("Docente actualizada con éxito");
            principalController.showDocentesPanel();
            loadDocentes();
        } catch (Exception e) {
            principalController.displayErrorMessage("Error al actualizar docente: " + e.getMessage());
        }
    }

    private void searchDocente() {
        String searchTerm = this.adminPanelDocentes.getTxtSearch().getText();
        try {
            List<Docente> docentes = docenteDao.getDocentesByName(searchTerm);

            DefaultTableModel model = (DefaultTableModel) adminPanelDocentes.getTblDocentes().getModel();
            model.setColumnIdentifiers(new Object[]{"ID", "Nombre", "Activo?", "Email", "Telefono", "Tutor Aula"});
            TableColumnModel columnModel = adminPanelDocentes.getTblDocentes().getColumnModel();
            columnModel.getColumn(0).setMaxWidth(100);

            model.setRowCount(0);
            for (Docente docente : docentes) {
                model.addRow(new Object[]{docente.getId(), docente.getNombre(), docente.isActive(), docente.getEmail(), docente.getTelefono(), docente.getTutorAulaNombre()});
            }
        } catch (Exception e) {
            principalController.displayErrorMessage("Error al cargar docentes: " + e.getMessage());
        }
    }

}
