package Controller;

import Dao.AulaDAOImpl;
import Model.Grado;
import Model.Seccion;
import Model.Aula;
import View.AdminPanelAulas;
import View.AdminPanelAulasCursoForm;
import View.AdminPanelAulasForm;
import java.sql.Time;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class AulaController {

    private AdminController principalController;
    private AulaDAOImpl aulaDao;
    private AdminPanelAulas adminPanelAulas;

    public AulaController(AdminController principalController) {
        this.principalController = principalController;
        this.aulaDao = new AulaDAOImpl();
        this.adminPanelAulas = new AdminPanelAulas(this);
        initController();
    }

    public AdminPanelAulas getAdminPanelAulas() {
        return adminPanelAulas;
    }

    private void initController() {
        adminPanelAulas.getBtnAdd().addActionListener(e -> displayFormAulaCreate());

        adminPanelAulas.getBtnUpdate().addActionListener(e -> displayFormAulaUpdate());
        loadAulas();
    }

    public void loadAulas() {
        try {
            List<Aula> aulas = aulaDao.getAllAulas();

            DefaultTableModel model = (DefaultTableModel) adminPanelAulas.getTblAulas().getModel();
            model.setColumnIdentifiers(new Object[]{"ID", "Nombre", "Año", "Grado", "Sección", "Tutor"});
            TableColumnModel columnModel = adminPanelAulas.getTblAulas().getColumnModel();
            columnModel.getColumn(0).setMaxWidth(100);

            model.setRowCount(0);
            for (Aula aula : aulas) {
                model.addRow(new Object[]{
                    aula.getID(),
                    aula.getNombre(),
                    aula.getAnio(),
                    aula.getGrado().getNombre(),
                    aula.getSeccion().getNombre(),
                    aula.getTutor()
                });
            }
        } catch (Exception e) {
            principalController.displayErrorMessage("Error al cargar aulas: " + e.getMessage());
        }
    }

    private void displayFormAulaCreate() {
        AdminPanelAulasForm formCreate = new AdminPanelAulasForm(false);
        fillComboBoxes(formCreate);
        this.principalController.showPanel(formCreate);
        formCreate.getBtnSave().addActionListener(e -> addAula(formCreate));
    }

    private void displayFormAulaUpdate() {
        int rowIndex = this.adminPanelAulas.getTblAulas().getSelectedRow();
        if (rowIndex == -1) {
            System.out.println("No row selected");
            principalController.displayErrorMessage("Seleccion un registro");
            return;
        }

        try {
            int aulaId = Integer.parseInt(adminPanelAulas.getTblAulas().getValueAt(rowIndex, 0).toString());
            Aula aula = aulaDao.getAulaById(aulaId);

            if (aula == null) {
                principalController.displayErrorMessage("No se pudo encontrar la aula seleccionada.");
                return;
            }

            AdminPanelAulasForm formUpdate = new AdminPanelAulasForm(true);
            fillComboBoxes(formUpdate);

            formUpdate.getCbxGrado().setSelectedItem(aula.getGrado());
            formUpdate.getCbxSeccion().setSelectedItem(aula.getSeccion());
            formUpdate.getCbxTutor().setSelectedItem(aula.getTutor());

            this.principalController.showPanel(formUpdate);
            formUpdate.getBtnSave().addActionListener(e -> updateAula(formUpdate, aula.getID()));
            formUpdate.getBtnAddCourse().addActionListener(e -> displayFormAulaCurso(formUpdate, aulaId));
            loadAulaCursos(aulaId, formUpdate);
        } catch (Exception e) {
            principalController.displayErrorMessage("Error al actualizar aula: " + e.getMessage());
        }
    }

    public void loadAulaCursos(int aulaId, AdminPanelAulasForm form) {
        try {
            List<String[]> horarios = aulaDao.obtenerHorariosPorAula(aulaId);

            DefaultTableModel model = (DefaultTableModel) form.getTblCourses().getModel();
            model.setColumnIdentifiers(new Object[]{"ID", "Curso", "Aula", "Docente", "Día", "Horario Inicio", "Horario Fin"});
            TableColumnModel columnModel = adminPanelAulas.getTblAulas().getColumnModel();
            columnModel.getColumn(0).setMaxWidth(100);

            model.setRowCount(0);
            for (String[] horario : horarios) {
                model.addRow(horario);
            }
        } catch (Exception e) {
            principalController.displayErrorMessage("Error al cargar los horarios de aula: " + e.getMessage());
        }
    }

    private void displayFormAulaCurso(AdminPanelAulasForm formUpdate, int aulaId) {
        AdminPanelAulasCursoForm formCurso = new AdminPanelAulasCursoForm(false);
        fillComboBoxesCurso(formCurso);

        this.principalController.showPanel(formCurso);
        formCurso.getBtnAddCourse().addActionListener(e -> addCursoHorario(formCurso, aulaId));
    }

    private void addCursoHorario(AdminPanelAulasCursoForm formCurso, int aulaId) {
        try {
            String curso = formCurso.getCbxCurso().getSelectedItem().toString();
            String docente = formCurso.getCbxDocente().getSelectedItem().toString();
            String horarioInicioStr = formCurso.getTxtHorarioIni().getText();
            String horarioFinStr = formCurso.getTxtHorarioFin().getText();
            String dia = formCurso.getCbxDia().getSelectedItem().toString();

            Time horarioInicio = Time.valueOf(horarioInicioStr + ":00");
            Time horarioFin = Time.valueOf(horarioFinStr + ":00");

            aulaDao.insertHorarioCurso(aulaId, curso, docente, dia, horarioInicio, horarioFin);
            
            principalController.displaySucessMessage("Curso y horario añadidos con éxito");
            principalController.showAulasPanel();
            
        } catch (Exception e) {
            principalController.displayErrorMessage("Error al añadir curso y horario: " + e.getMessage());
        }
    }

    private void addAula(AdminPanelAulasForm form) {
        try {

            Grado grado = (Grado) form.getCbxGrado().getSelectedItem();
            Seccion seccion = (Seccion) form.getCbxSeccion().getSelectedItem();
            String nombre = grado.getNombre() + " " + seccion.getNombre();
            String tutor = (String) form.getCbxTutor().getSelectedItem();

            Aula aula = new Aula(0, nombre, 2024, grado, seccion, tutor);
            aulaDao.insertAula(aula);

            principalController.displaySucessMessage("Aula añadida con éxito");
            principalController.showAulasPanel();
            loadAulas();
        } catch (Exception e) {
            principalController.displayErrorMessage("Error al añadir aula: " + e.getMessage());
        }
    }

    private void updateAula(AdminPanelAulasForm form, int aulaId) {
        try {
            Grado grado = (Grado) form.getCbxGrado().getSelectedItem();
            Seccion seccion = (Seccion) form.getCbxSeccion().getSelectedItem();
            String nombre = grado.getNombre() + " " + seccion.getNombre();
            String tutor = (String) form.getCbxTutor().getSelectedItem();

            Aula aula = new Aula(aulaId, nombre, 2024, grado, seccion, tutor);
            aulaDao.updateAula(aula);

            principalController.displaySucessMessage("Aula actualizada con éxito");
            principalController.showAulasPanel();
            loadAulas();
        } catch (Exception e) {
            principalController.displayErrorMessage("Error al actualizar aula: " + e.getMessage());
        }
    }

    private void fillComboBoxes(AdminPanelAulasForm form) {
        List<Grado> grados = aulaDao.getAllGrados();
        List<Seccion> secciones = aulaDao.getAllSecciones();
        List<String> tutores = aulaDao.getAllTutores();

        form.getCbxGrado().removeAllItems();
        form.getCbxSeccion().removeAllItems();
        form.getCbxTutor().removeAllItems();

        for (Grado grado : grados) {
            form.getCbxGrado().addItem(grado);
        }

        for (Seccion seccion : secciones) {
            form.getCbxSeccion().addItem(seccion);
        }

        for (String tutor : tutores) {
            form.getCbxTutor().addItem(tutor);
        }
    }

    private void fillComboBoxesCurso(AdminPanelAulasCursoForm formCurso) {
        List<String> cursos = aulaDao.getAllCursos();
        List<String> docentes = aulaDao.getAllTutores();

        formCurso.getCbxCurso().removeAllItems();
        formCurso.getCbxDocente().removeAllItems();

        for (String curso : cursos) {
            formCurso.getCbxCurso().addItem(curso);
        }

        for (String docente : docentes) {
            formCurso.getCbxDocente().addItem(docente);
        }

    }

}
