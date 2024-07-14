package View;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.util.List;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import Dao.AlumnoDAOImpl;
import Model.RegistrarAlumno;

public class ParentsPanelVacantsForm extends javax.swing.JPanel {

    private int vacanteId;
    private String grado;
    private String seccion;
    private AlumnoDAOImpl registrarAlumnoDAO;

    public ParentsPanelVacantsForm(int vacanteId, String grado,String seccion) {
        this.vacanteId = vacanteId;
        this.grado = grado;
        this.seccion=seccion;
        registrarAlumnoDAO = new AlumnoDAOImpl();

        initComponents();
        initFlat();
    }
    
     public ParentsPanelVacantsForm() {
        
        initComponents();
        initFlat();
        lblTitulo.setText("Vista Solicitud");
    }
     
    private void initFlat() {
        panelSolicitar.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:2,2,2,2;"
                + "arc:25");
    }

    public JTextField getTxtAddress() {
        return txtAddress;
    }

    public JTextField getTxtPhone() {
        return txtPhone;
    }

    public JButton getBtnRegistrarSolicitud() {
        return btnRegistrarSolicitud;
    }

    public JComboBox<String> getCbxSexo() {
        return cbxSexo;
    }

    public JDateChooser getJdcFechaNac() {
        return jdcFechaNac;
    }

    public JPasswordField getPswPassword() {
        return pswPassword;
    }

    public JTextField getTxtDni() {
        return txtDni;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public JTextField getTxtLastName() {
        return txtLastName;
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public String getGrado() {
        return grado;
    }
    
    public String getSeccion() {
        return seccion;
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

        jPanel2 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        panelSolicitar = new javax.swing.JPanel();
        btnRegistrarSolicitud = new javax.swing.JButton();
        Titulo1 = new javax.swing.JLabel();
        Titulo2 = new javax.swing.JLabel();
        Titulo3 = new javax.swing.JLabel();
        Titulo4 = new javax.swing.JLabel();
        Titulo5 = new javax.swing.JLabel();
        Titulo6 = new javax.swing.JLabel();
        Titulo7 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jdcFechaNac = new com.toedter.calendar.JDateChooser();
        Titulo8 = new javax.swing.JLabel();
        cbxSexo = new javax.swing.JComboBox<>();
        pswPassword = new javax.swing.JPasswordField();
        Titulo10 = new javax.swing.JLabel();
        Titulo11 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();

        setBackground(new java.awt.Color(240, 243, 253));

        jPanel2.setBackground(new java.awt.Color(240, 243, 253));

        lblTitulo.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(51, 51, 51));
        lblTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Vacantes.png"))); // NOI18N
        lblTitulo.setText("Solicitar vacante");

        panelSolicitar.setBackground(new java.awt.Color(255, 255, 255));

        btnRegistrarSolicitud.setBackground(new java.awt.Color(56, 53, 122));
        btnRegistrarSolicitud.setText("Registrar solicitud");

        Titulo1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Titulo1.setForeground(new java.awt.Color(51, 51, 51));
        Titulo1.setText("Nombre");

        Titulo2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        Titulo2.setForeground(new java.awt.Color(51, 51, 51));
        Titulo2.setText("1° Grado");

        Titulo3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Titulo3.setForeground(new java.awt.Color(51, 51, 51));
        Titulo3.setText("Fecha de nacimiento");

        Titulo4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Titulo4.setForeground(new java.awt.Color(51, 51, 51));
        Titulo4.setText("DNI");

        Titulo5.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Titulo5.setForeground(new java.awt.Color(51, 51, 51));
        Titulo5.setText("Correo");

        Titulo6.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Titulo6.setForeground(new java.awt.Color(51, 51, 51));
        Titulo6.setText("Apellidos");

        Titulo7.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Titulo7.setForeground(new java.awt.Color(51, 51, 51));
        Titulo7.setText("Contraseña");

        txtName.setBackground(new java.awt.Color(240, 243, 253));
        txtName.setForeground(new java.awt.Color(51, 51, 51));

        txtLastName.setBackground(new java.awt.Color(240, 243, 253));
        txtLastName.setForeground(new java.awt.Color(51, 51, 51));

        txtDni.setBackground(new java.awt.Color(240, 243, 253));
        txtDni.setForeground(new java.awt.Color(51, 51, 51));

        txtEmail.setBackground(new java.awt.Color(240, 243, 253));
        txtEmail.setForeground(new java.awt.Color(51, 51, 51));

        jdcFechaNac.setBackground(new java.awt.Color(240, 243, 253));
        jdcFechaNac.setForeground(new java.awt.Color(51, 51, 51));
        jdcFechaNac.setMaxSelectableDate(new java.util.Date(253370786486000L));

        Titulo8.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Titulo8.setForeground(new java.awt.Color(51, 51, 51));
        Titulo8.setText("Sexo");

        cbxSexo.setBackground(new java.awt.Color(240, 243, 253));
        cbxSexo.setForeground(new java.awt.Color(51, 51, 51));
        cbxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "F", "M" }));

        pswPassword.setBackground(new java.awt.Color(240, 243, 253));
        pswPassword.setForeground(new java.awt.Color(51, 51, 51));

        Titulo10.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Titulo10.setForeground(new java.awt.Color(51, 51, 51));
        Titulo10.setText("Dirección");

        Titulo11.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Titulo11.setForeground(new java.awt.Color(51, 51, 51));
        Titulo11.setText("Telefono");

        txtAddress.setBackground(new java.awt.Color(240, 243, 253));
        txtAddress.setForeground(new java.awt.Color(51, 51, 51));

        txtPhone.setBackground(new java.awt.Color(240, 243, 253));
        txtPhone.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout panelSolicitarLayout = new javax.swing.GroupLayout(panelSolicitar);
        panelSolicitar.setLayout(panelSolicitarLayout);
        panelSolicitarLayout.setHorizontalGroup(
            panelSolicitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSolicitarLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panelSolicitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSolicitarLayout.createSequentialGroup()
                        .addComponent(btnRegistrarSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSolicitarLayout.createSequentialGroup()
                        .addGroup(panelSolicitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelSolicitarLayout.createSequentialGroup()
                                .addComponent(Titulo4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtDni))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelSolicitarLayout.createSequentialGroup()
                                .addComponent(Titulo5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtEmail))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelSolicitarLayout.createSequentialGroup()
                                .addComponent(Titulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtName))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelSolicitarLayout.createSequentialGroup()
                                .addComponent(Titulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelSolicitarLayout.createSequentialGroup()
                                .addComponent(Titulo7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pswPassword))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelSolicitarLayout.createSequentialGroup()
                                .addGroup(panelSolicitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelSolicitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(Titulo6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Titulo10, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Titulo11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelSolicitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtLastName)
                                    .addComponent(txtAddress)
                                    .addComponent(txtPhone)))
                            .addGroup(panelSolicitarLayout.createSequentialGroup()
                                .addComponent(Titulo3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jdcFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Titulo8, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94)
                                .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38))))
        );
        panelSolicitarLayout.setVerticalGroup(
            panelSolicitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSolicitarLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(Titulo2)
                .addGap(26, 26, 26)
                .addGroup(panelSolicitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Titulo4)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(panelSolicitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Titulo1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(panelSolicitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Titulo6)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 24, Short.MAX_VALUE)
                .addGroup(panelSolicitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Titulo10)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(panelSolicitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Titulo11)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(panelSolicitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Titulo3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdcFechaNac, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSolicitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Titulo8)))
                .addGap(28, 28, 28)
                .addGroup(panelSolicitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Titulo5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelSolicitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Titulo7)
                    .addComponent(pswPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(btnRegistrarSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(panelSolicitar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblTitulo)
                .addGap(29, 29, 29)
                .addComponent(panelSolicitar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo1;
    private javax.swing.JLabel Titulo10;
    private javax.swing.JLabel Titulo11;
    private javax.swing.JLabel Titulo2;
    private javax.swing.JLabel Titulo3;
    private javax.swing.JLabel Titulo4;
    private javax.swing.JLabel Titulo5;
    private javax.swing.JLabel Titulo6;
    private javax.swing.JLabel Titulo7;
    private javax.swing.JLabel Titulo8;
    private javax.swing.JButton btnRegistrarSolicitud;
    private javax.swing.JComboBox<String> cbxSexo;
    private javax.swing.JPanel jPanel2;
    private com.toedter.calendar.JDateChooser jdcFechaNac;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelSolicitar;
    private javax.swing.JPasswordField pswPassword;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables

}
