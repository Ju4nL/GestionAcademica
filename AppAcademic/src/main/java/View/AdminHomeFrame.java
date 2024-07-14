package View;

import Controller.CursoController;
import Controller.AdminController;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AdminHomeFrame extends javax.swing.JFrame {

    private AdminController principalController;
    //private CursoController cursoController;

    public AdminHomeFrame() {
        initComponents();
        initFlat();
        setLocationRelativeTo(null); 
    }

    public void setController(AdminController controller) {
        this.principalController = controller; 
    }
    
     private void ShowJPanel(JPanel panel) {
        panel.setSize(815, 580);
        panel.setLocation(0, 0);

        content.removeAll();
        content.add(panel, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
     }

    private void initFlat() {
        panelBgMenu.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:20,2,2,2;"
                + "arc:30");
    }

    public JPanel getContentPanel() {
        return content;
    }

    public JButton getBtnAlumnos() {
        return btnAlumnos;
    }

    public JButton getBtnAulas() {
        return btnAulas;
    }

    public JButton getBtnCerrarSesion() {
        return btnCerrarSesion;
    }

    public JButton getBtnCursos() {
        return btnCursos;
    }

    public JButton getBtnDocentes() {
        return btnDocentes;
    }

    public JButton getBtnSolicitudes() {
        return btnSolicitudes;
    }

    public JButton getBtnVacantes() {
        return btnVacantes;
    }

       
    public void displayErrorMessage(String message){
        JOptionPane.showMessageDialog(this, message, "Error Login", JOptionPane.ERROR_MESSAGE);
    }
    
    public void displaySucessMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelBgMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelBtns = new javax.swing.JPanel();
        btnVacantes = new javax.swing.JButton();
        btnSolicitudes = new javax.swing.JButton();
        btnDocentes = new javax.swing.JButton();
        btnAulas = new javax.swing.JButton();
        btnAlumnos = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnCursos = new javax.swing.JButton();
        content = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(800, 600));

        jPanel1.setBackground(new java.awt.Color(240, 243, 253));

        panelBgMenu.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Icon.png"))); // NOI18N
        jLabel1.setText("Admin");

        panelBtns.setBackground(new java.awt.Color(255, 255, 255));

        btnVacantes.setBackground(new java.awt.Color(255, 255, 255));
        btnVacantes.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnVacantes.setForeground(new java.awt.Color(51, 51, 51));
        btnVacantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Vacantes.png"))); // NOI18N
        btnVacantes.setText("Vacantes");
        btnVacantes.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 30, 1, 1, new java.awt.Color(0, 0, 0)));
        btnVacantes.setBorderPainted(false);
        btnVacantes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVacantes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnVacantes.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnVacantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnVacantesMousePressed(evt);
            }
        });

        btnSolicitudes.setBackground(new java.awt.Color(255, 255, 255));
        btnSolicitudes.setForeground(new java.awt.Color(51, 51, 51));
        btnSolicitudes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Solicitudes.png"))); // NOI18N
        btnSolicitudes.setText("Solicitudes");
        btnSolicitudes.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 30, 1, 1, new java.awt.Color(0, 0, 0)));
        btnSolicitudes.setBorderPainted(false);
        btnSolicitudes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSolicitudes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSolicitudes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSolicitudesMousePressed(evt);
            }
        });

        btnDocentes.setBackground(new java.awt.Color(255, 255, 255));
        btnDocentes.setForeground(new java.awt.Color(51, 51, 51));
        btnDocentes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/teacher.png"))); // NOI18N
        btnDocentes.setText("Docentes");
        btnDocentes.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 30, 1, 1, new java.awt.Color(0, 0, 0)));
        btnDocentes.setBorderPainted(false);
        btnDocentes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDocentes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDocentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnDocentesMousePressed(evt);
            }
        });

        btnAulas.setBackground(new java.awt.Color(255, 255, 255));
        btnAulas.setForeground(new java.awt.Color(51, 51, 51));
        btnAulas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/class.png"))); // NOI18N
        btnAulas.setText("Aulas");
        btnAulas.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 30, 1, 1, new java.awt.Color(0, 0, 0)));
        btnAulas.setBorderPainted(false);
        btnAulas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAulas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnAlumnos.setBackground(new java.awt.Color(255, 255, 255));
        btnAlumnos.setForeground(new java.awt.Color(51, 51, 51));
        btnAlumnos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/student.png"))); // NOI18N
        btnAlumnos.setText("Alumnos");
        btnAlumnos.setToolTipText("");
        btnAlumnos.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 30, 1, 1, new java.awt.Color(0, 0, 0)));
        btnAlumnos.setBorderPainted(false);
        btnAlumnos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlumnos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAlumnosMousePressed(evt);
            }
        });

        btnCerrarSesion.setBackground(new java.awt.Color(255, 255, 255));
        btnCerrarSesion.setForeground(new java.awt.Color(51, 51, 51));
        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Logout.png"))); // NOI18N
        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.setToolTipText("");
        btnCerrarSesion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 30, 1, 1, new java.awt.Color(0, 0, 0)));
        btnCerrarSesion.setBorderPainted(false);
        btnCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrarSesion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));

        btnCursos.setBackground(new java.awt.Color(255, 255, 255));
        btnCursos.setForeground(new java.awt.Color(51, 51, 51));
        btnCursos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/course.png"))); // NOI18N
        btnCursos.setText("Cursos");
        btnCursos.setToolTipText("");
        btnCursos.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 30, 1, 1, new java.awt.Color(0, 0, 0)));
        btnCursos.setBorderPainted(false);
        btnCursos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCursos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCursosMousePressed(evt);
            }
        });

        javax.swing.GroupLayout panelBtnsLayout = new javax.swing.GroupLayout(panelBtns);
        panelBtns.setLayout(panelBtnsLayout);
        panelBtnsLayout.setHorizontalGroup(
            panelBtnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnVacantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSolicitudes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnDocentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnAulas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnAlumnos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelBtnsLayout.createSequentialGroup()
                .addGroup(panelBtnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                    .addGroup(panelBtnsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1)))
                .addContainerGap())
            .addComponent(btnCursos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelBtnsLayout.setVerticalGroup(
            panelBtnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtnsLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnVacantes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnSolicitudes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnDocentes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnAulas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout panelBgMenuLayout = new javax.swing.GroupLayout(panelBgMenu);
        panelBgMenu.setLayout(panelBgMenuLayout);
        panelBgMenuLayout.setHorizontalGroup(
            panelBgMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBtns, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelBgMenuLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
        );
        panelBgMenuLayout.setVerticalGroup(
            panelBgMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBgMenuLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(panelBtns, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        content.setBackground(new java.awt.Color(240, 243, 253));
        content.setPreferredSize(new java.awt.Dimension(815, 580));
        content.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBgMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBgMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlumnosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlumnosMousePressed
        principalController.showAlumnosPanel();
    }//GEN-LAST:event_btnAlumnosMousePressed

    private void btnCursosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCursosMousePressed
        principalController.showCursoPanel();
    }//GEN-LAST:event_btnCursosMousePressed

    private void btnVacantesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVacantesMousePressed
        principalController.showVacantePanel();
    }//GEN-LAST:event_btnVacantesMousePressed

    private void btnSolicitudesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSolicitudesMousePressed
        principalController.showSolicitudesPanel();
    }//GEN-LAST:event_btnSolicitudesMousePressed

    private void btnDocentesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDocentesMousePressed
        principalController.showDocentesPanel();
    }//GEN-LAST:event_btnDocentesMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlumnos;
    private javax.swing.JButton btnAulas;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnCursos;
    private javax.swing.JButton btnDocentes;
    private javax.swing.JButton btnSolicitudes;
    private javax.swing.JButton btnVacantes;
    private javax.swing.JPanel content;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelBgMenu;
    private javax.swing.JPanel panelBtns;
    // End of variables declaration//GEN-END:variables
}
