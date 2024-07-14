package View;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JLabel;
import javax.swing.JTextField;
import Model.VacantModel;
import javax.swing.JOptionPane;
import View.ParentsHomeFrame;
import javax.swing.table.TableColumnModel;

public class ParentsPanelVacants extends javax.swing.JPanel {

    private VacantTableModel vacantTableModel;

    public ParentsPanelVacants() {
        initComponents();
        initFlat();
        initTable();
    }

    private void initFlat() {
        panelSearch.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:2,2,2,2;"
                + "arc:25");
    }

    private void initTable() {
        vacantTableModel = new VacantTableModel();
        tblVacantes.setModel(vacantTableModel);
        tblVacantes.setDefaultRenderer(Object.class, new ParentsPanelVacants.DefaultTableCellRendererImpl());
        tblVacantes.setRowHeight(30);  // Ajusta esto según necesites
        updateTableColumns();
    }

    private void updateTableColumns() {
        TableColumnModel columnModel = tblVacantes.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50); // ID
        columnModel.getColumn(1).setPreferredWidth(150); // Grado
        columnModel.getColumn(2).setPreferredWidth(150); // Vacantes Disponibles
        columnModel.getColumn(3).setPreferredWidth(150); // Solicitudes
    }

    public void cargarVacantes(List<String[]> vacantes) {
        vacantTableModel.setRowCount(0); // Limpiar la tabla antes de añadir nuevos datos

        for (String[] vacante : vacantes) {
            vacantTableModel.addVacant(
                    Integer.parseInt(vacante[0]), // id
                    vacante[1], // grado
                    vacante[2], // grado
                    Integer.parseInt(vacante[3]), // vacantesDisponibles
                    Integer.parseInt(vacante[4]) // solicitudes
            );
            // Mensaje de depuración
            System.out.println("Vacante añadida: " + vacante[0]
                    + ", " + vacante[1] + ", " + vacante[2] + ", " + vacante[3]);
        }
        // Forzar actualización de la tabla
        tblVacantes.revalidate();
        tblVacantes.repaint();
    }

    public JButton getBtnActualizar() {
        return btnSolicitar;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public JTextField getTxtBuscar() {
        return txtBuscar;
    }

    public JTable getTblVacantes() {
        return tblVacantes;
    }

    public JButton getBtnSolicitar() {
        return btnSolicitar;
    }

    public void displayErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error Vacantes", JOptionPane.ERROR_MESSAGE);
    }

    public void displaySucessMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titulo = new javax.swing.JLabel();
        btnSolicitar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        panelSearch = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVacantes = new javax.swing.JTable();

        setBackground(new java.awt.Color(240, 243, 253));

        Titulo.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        Titulo.setForeground(new java.awt.Color(51, 51, 51));
        Titulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Vacantes.png"))); // NOI18N
        Titulo.setText("Vacantes");

        btnSolicitar.setBackground(new java.awt.Color(56, 53, 122));
        btnSolicitar.setForeground(new java.awt.Color(255, 255, 255));
        btnSolicitar.setText("Solicitar");

        btnActualizar.setBackground(new java.awt.Color(56, 53, 122));
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");

        panelSearch.setBackground(new java.awt.Color(255, 255, 255));
        panelSearch.setPreferredSize(new java.awt.Dimension(400, 40));

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Search.png"))); // NOI18N
        btnBuscar.setBorder(null);

        txtBuscar.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscar.setToolTipText("");
        txtBuscar.setBorder(null);

        javax.swing.GroupLayout panelSearchLayout = new javax.swing.GroupLayout(panelSearch);
        panelSearch.setLayout(panelSearchLayout);
        panelSearchLayout.setHorizontalGroup(
            panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        panelSearchLayout.setVerticalGroup(
            panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tblVacantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblVacantes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(panelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSolicitar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(53, 53, 53)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSolicitar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSolicitar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelSearch;
    private javax.swing.JTable tblVacantes;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

    private class DefaultTableCellRendererImpl extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            ((JLabel) c).setHorizontalAlignment(JLabel.CENTER);
            return c;
        }
    }
}
