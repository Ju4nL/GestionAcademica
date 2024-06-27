package Controller;

import Model.Curso; 
import View.AdminPanelCursos;
import dao.CursoDAOImpl;
import java.util.List; 
import javax.swing.table.DefaultTableModel;

public class CursoController {
    private CursoDAOImpl cursoDao;
    private AdminPanelCursos adminPanelCursos;

    public CursoController() {
        cursoDao = new CursoDAOImpl();
        adminPanelCursos = new AdminPanelCursos(this);
        loadCursos();
    }

    public AdminPanelCursos getAdminPanelCursos() {
        return adminPanelCursos;
    }
    
    private void initController() {
        /*panel.getBtnAdd().addActionListener(e -> agregarCurso());
        panel.getBtnUpdate().addActionListener(e -> agregarCurso());
        panel.getBtnDelete().addActionListener(e -> agregarCurso());
        panel.getBtnSearch().addActionListener(e -> buscarCursos());*/
        loadCursos();
    }

    private void loadCursos() {
        try {
            List<Curso> cursos = cursoDao.getAllCursos();
            
            DefaultTableModel model = (DefaultTableModel) adminPanelCursos.getTblCursos().getModel();
            
            for (Curso curso : cursos) {
                System.out.println(curso.getNombre());
                model.addRow(new Object[]{curso.getID(), curso.getNombre(), curso.getDescripcion()});
            }
        } catch (Exception e) {
            adminPanelCursos.displayErrorMessage( "Error al cargar cursos: " + e.getMessage());
        }
    }
    
/*
    private void agregarCurso() {
        String nombre = JOptionPane.showInputDialog(panel, "Ingrese el nombre del curso:", "Agregar Curso", JOptionPane.PLAIN_MESSAGE);
        String descripcion = JOptionPane.showInputDialog(panel, "Ingrese la descripción del curso:", "Agregar Curso", JOptionPane.PLAIN_MESSAGE);
        if (nombre != null && descripcion != null && !nombre.isEmpty() && !descripcion.isEmpty()) {
            Curso curso = new Curso(0, nombre, descripcion);
            try {
                if (cursoDaoImpl.insertCurso(curso)) {
                    JOptionPane.showMessageDialog(panel, "Curso agregado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    cargarCursos();  // Recargar la lista de cursos
                } else {
                    JOptionPane.showMessageDialog(panel, "No se pudo agregar el curso", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(panel, "Error al agregar curso: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void buscarCursos() {
        String searchTerm = panel.getTxtSearch().getText();
        if (searchTerm != null && !searchTerm.trim().isEmpty()) {
            try {
                List<Curso> filteredCursos = cursoDaoImpl.searchCursosByName(searchTerm);
                DefaultTableModel model = (DefaultTableModel) panel.getJTable1().getModel();
                model.setRowCount(0);  // Limpiar la tabla
                for (Curso curso : filteredCursos) {
                    model.addRow(new Object[]{curso.getID(), curso.getNombre(), curso.getDescripcion()});
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(panel, "Error al buscar cursos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }*/
}
