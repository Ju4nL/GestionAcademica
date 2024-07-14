package View;

import com.formdev.flatlaf.FlatClientProperties;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterFrame extends javax.swing.JFrame {

    public RegisterFrame() {
        initComponents();
        initFlat();
        setLocationRelativeTo(null);
    }

    private void initFlat() {
        panelBg.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:20,2,2,2;"
                + "arc:10");
        pswPassword1.putClientProperty(FlatClientProperties.STYLE, ""
                + "showRevealButton:true");

        txtEmail.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ingrese su email");
        pswPassword1.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ingrese su contraseña");
        txtEmail.setEnabled(false);

    }

    public JButton getBtnRegistrate() {
        return btnRegistrate;
    }

    public JComboBox<String> getCbxGender() {
        return cbxGender;
    }

    public JPasswordField getPswPassword1() {
        return pswPassword1;
    }


    public JTextField getTxtAddress() {
        return txtAddress;
    }

    public JDateChooser getJdcFechaNac() {
        return jdcFechaNac;
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

    public JTextField getTxtPhone() {
        return txtPhone;
    }

    public void displayErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error Registrate", JOptionPane.ERROR_MESSAGE);
    }

    public void displaySucessMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBg = new javax.swing.JPanel();
        btnRegistrate = new javax.swing.JButton();
        rgTitle = new javax.swing.JLabel();
        rgNombreLb = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        separador3 = new javax.swing.JSeparator();
        rgDniLb = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        separador4 = new javax.swing.JSeparator();
        rgFechaNacLb = new javax.swing.JLabel();
        rgEmailLb = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        separador10 = new javax.swing.JSeparator();
        rgPasswordLb = new javax.swing.JLabel();
        pswPassword1 = new javax.swing.JPasswordField();
        separador2 = new javax.swing.JSeparator();
        rgApellidosLb = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        separador7 = new javax.swing.JSeparator();
        rgGeneroLb = new javax.swing.JLabel();
        cbxGender = new javax.swing.JComboBox<>();
        rgTelLb = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        separador9 = new javax.swing.JSeparator();
        rgDirLb = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        separador11 = new javax.swing.JSeparator();
        jdcFechaNac = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        panelBg.setBackground(new java.awt.Color(78, 69, 189));
        panelBg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegistrate.setBackground(new java.awt.Color(56, 53, 122));
        btnRegistrate.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnRegistrate.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrate.setText("Registrate");
        panelBg.add(btnRegistrate, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 190, 40));

        rgTitle.setBackground(new java.awt.Color(255, 255, 255));
        rgTitle.setFont(new java.awt.Font("Roboto", 1, 32)); // NOI18N
        rgTitle.setForeground(new java.awt.Color(255, 255, 255));
        rgTitle.setText("Registrate");
        panelBg.add(rgTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        rgNombreLb.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        rgNombreLb.setForeground(new java.awt.Color(255, 255, 255));
        rgNombreLb.setText("Nombre");
        panelBg.add(rgNombreLb, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        txtName.setBackground(new java.awt.Color(78, 69, 189));
        txtName.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtName.setForeground(new java.awt.Color(255, 255, 255));
        txtName.setToolTipText("");
        txtName.setBorder(null);
        panelBg.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 160, -1));

        separador3.setBackground(new java.awt.Color(78, 69, 189));
        separador3.setForeground(new java.awt.Color(255, 255, 255));
        panelBg.add(separador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 160, -1));

        rgDniLb.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        rgDniLb.setForeground(new java.awt.Color(255, 255, 255));
        rgDniLb.setText("Dni");
        panelBg.add(rgDniLb, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        txtDni.setBackground(new java.awt.Color(78, 69, 189));
        txtDni.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtDni.setForeground(new java.awt.Color(255, 255, 255));
        txtDni.setToolTipText("");
        txtDni.setBorder(null);
        panelBg.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 160, -1));

        separador4.setBackground(new java.awt.Color(78, 69, 189));
        separador4.setForeground(new java.awt.Color(255, 255, 255));
        panelBg.add(separador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 160, -1));

        rgFechaNacLb.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        rgFechaNacLb.setForeground(new java.awt.Color(255, 255, 255));
        rgFechaNacLb.setText("FechaNacimiento");
        panelBg.add(rgFechaNacLb, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        rgEmailLb.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        rgEmailLb.setForeground(new java.awt.Color(255, 255, 255));
        rgEmailLb.setText("Email");
        panelBg.add(rgEmailLb, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        txtEmail.setBackground(new java.awt.Color(78, 69, 189));
        txtEmail.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(255, 255, 255));
        txtEmail.setToolTipText("");
        txtEmail.setBorder(null);
        panelBg.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 160, -1));

        separador10.setBackground(new java.awt.Color(78, 69, 189));
        separador10.setForeground(new java.awt.Color(255, 255, 255));
        panelBg.add(separador10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 160, -1));

        rgPasswordLb.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        rgPasswordLb.setForeground(new java.awt.Color(255, 255, 255));
        rgPasswordLb.setText("Contraseña");
        panelBg.add(rgPasswordLb, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        pswPassword1.setBackground(new java.awt.Color(78, 69, 189));
        pswPassword1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        pswPassword1.setForeground(new java.awt.Color(255, 255, 255));
        pswPassword1.setBorder(null);
        panelBg.add(pswPassword1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 160, -1));

        separador2.setBackground(new java.awt.Color(78, 69, 189));
        separador2.setForeground(new java.awt.Color(255, 255, 255));
        panelBg.add(separador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 160, -1));

        rgApellidosLb.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        rgApellidosLb.setForeground(new java.awt.Color(255, 255, 255));
        rgApellidosLb.setText("Apellidos");
        panelBg.add(rgApellidosLb, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, -1, -1));

        txtLastName.setBackground(new java.awt.Color(78, 69, 189));
        txtLastName.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtLastName.setForeground(new java.awt.Color(255, 255, 255));
        txtLastName.setToolTipText("");
        txtLastName.setBorder(null);
        panelBg.add(txtLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 160, -1));

        separador7.setBackground(new java.awt.Color(78, 69, 189));
        separador7.setForeground(new java.awt.Color(255, 255, 255));
        panelBg.add(separador7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 160, -1));

        rgGeneroLb.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        rgGeneroLb.setForeground(new java.awt.Color(255, 255, 255));
        rgGeneroLb.setText("Genero");
        panelBg.add(rgGeneroLb, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, -1, -1));

        cbxGender.setBackground(new java.awt.Color(78, 69, 189));
        cbxGender.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        cbxGender.setForeground(new java.awt.Color(255, 255, 255));
        cbxGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Femenino", "Masculino" }));
        cbxGender.setBorder(null);
        cbxGender.setFocusable(false);
        panelBg.add(cbxGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 160, -1));

        rgTelLb.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        rgTelLb.setForeground(new java.awt.Color(255, 255, 255));
        rgTelLb.setText("Telefono");
        panelBg.add(rgTelLb, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, -1, -1));

        txtPhone.setBackground(new java.awt.Color(78, 69, 189));
        txtPhone.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtPhone.setForeground(new java.awt.Color(255, 255, 255));
        txtPhone.setToolTipText("");
        txtPhone.setBorder(null);
        panelBg.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 160, -1));

        separador9.setBackground(new java.awt.Color(78, 69, 189));
        separador9.setForeground(new java.awt.Color(255, 255, 255));
        panelBg.add(separador9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 160, -1));

        rgDirLb.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        rgDirLb.setForeground(new java.awt.Color(255, 255, 255));
        rgDirLb.setText("Direccion");
        panelBg.add(rgDirLb, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, -1, -1));

        txtAddress.setBackground(new java.awt.Color(78, 69, 189));
        txtAddress.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtAddress.setForeground(new java.awt.Color(255, 255, 255));
        txtAddress.setToolTipText("");
        txtAddress.setBorder(null);
        panelBg.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 160, -1));

        separador11.setBackground(new java.awt.Color(78, 69, 189));
        separador11.setForeground(new java.awt.Color(255, 255, 255));
        panelBg.add(separador11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 160, -1));
        panelBg.add(jdcFechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 140, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/RegisterImage.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(421, 421, 421)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(panelBg, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
            .addComponent(panelBg, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrate;
    private javax.swing.JComboBox<String> cbxGender;
    private javax.swing.JLabel jLabel1;
    private com.toedter.calendar.JDateChooser jdcFechaNac;
    private javax.swing.JPanel panelBg;
    private javax.swing.JPasswordField pswPassword1;
    private javax.swing.JLabel rgApellidosLb;
    private javax.swing.JLabel rgDirLb;
    private javax.swing.JLabel rgDniLb;
    private javax.swing.JLabel rgEmailLb;
    private javax.swing.JLabel rgFechaNacLb;
    private javax.swing.JLabel rgGeneroLb;
    private javax.swing.JLabel rgNombreLb;
    private javax.swing.JLabel rgPasswordLb;
    private javax.swing.JLabel rgTelLb;
    private javax.swing.JLabel rgTitle;
    private javax.swing.JSeparator separador10;
    private javax.swing.JSeparator separador11;
    private javax.swing.JSeparator separador2;
    private javax.swing.JSeparator separador3;
    private javax.swing.JSeparator separador4;
    private javax.swing.JSeparator separador7;
    private javax.swing.JSeparator separador9;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
