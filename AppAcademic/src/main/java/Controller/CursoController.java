package Controller;

import Model.Curso;
import Interface.CursoDAO;
import View.AdminPanelCursos;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CursoController {

    private AdminPanelCursos panel;
    private CursoDAO cursoDao;

    public CursoController(AdminPanelCursos panel, CursoDAO cursoDao) {
        this.panel = panel;
        this.cursoDao = cursoDao;
        initController();
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
            
            DefaultTableModel model = (DefaultTableModel) panel.getTblCursos().getModel();
            
            for (Curso curso : cursos) {
                System.out.println(curso.getNombre());
                model.addRow(new Object[]{curso.getID(), curso.getNombre(), curso.getDescripcion()});
            }
        } catch (Exception e) {
            panel.displayErrorMessage( "Error al cargar cursos: " + e.getMessage());
        }
    }
    
/*
    private void agregarCurso() {
        String nombre = JOptionPane.showInputDialog(panel, "Ingrese el nombre del curso:", "Agregar Curso", JOptionPane.PLAIN_MESSAGE);
        String descripcion = JOptionPane.showInputDialog(panel, "Ingrese la descripción del curso:", "Agregar Curso", JOptionPane.PLAIN_MESSAGE);
        if (nombre != null && descripcion != null && !nombre.isEmpty() && !descripcion.isEmpty()) {
            Curso curso = new Curso(0, nombre, descripcion);
            try {
                if (cursoDao.insertCurso(curso)) {
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
                List<Curso> filteredCursos = cursoDao.searchCursosByName(searchTerm);
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
