package View;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;

public class LoginFrame extends javax.swing.JFrame {

    public LoginFrame() {
        initComponents();
        initFlat();
    }

    private void initFlat() {
        FlatLightLaf.setup();
        pswContrasena.putClientProperty(FlatClientProperties.STYLE,""+
                "showRevealButton:true");
        txtEmail.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Ingrese su email");
        pswContrasena.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Ingrese su password");
        
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        loginTitle = new javax.swing.JLabel();
        loginUserLabel = new javax.swing.JLabel();
        loginPasswordLabel = new javax.swing.JLabel();
        pswContrasena = new javax.swing.JPasswordField();
        txtEmail = new javax.swing.JTextField();
        btnRegistrate = new javax.swing.JButton();
        btnIniciarSesion = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(78, 69, 189));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginTitle.setBackground(new java.awt.Color(255, 255, 255));
        loginTitle.setFont(new java.awt.Font("Roboto", 1, 32)); // NOI18N
        loginTitle.setForeground(new java.awt.Color(255, 255, 255));
        loginTitle.setText("Iniciar Sesión");
        jPanel1.add(loginTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, -1, -1));

        loginUserLabel.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        loginUserLabel.setForeground(new java.awt.Color(255, 255, 255));
        loginUserLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/User.png"))); // NOI18N
        loginUserLabel.setText("Email");
        jPanel1.add(loginUserLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, -1, -1));

        loginPasswordLabel.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        loginPasswordLabel.setForeground(new java.awt.Color(255, 255, 255));
        loginPasswordLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Lock.png"))); // NOI18N
        loginPasswordLabel.setText("Contraseña");
        jPanel1.add(loginPasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, -1, -1));

        pswContrasena.setBackground(new java.awt.Color(78, 69, 189));
        pswContrasena.setForeground(new java.awt.Color(255, 255, 255));
        pswContrasena.setBorder(null);
        jPanel1.add(pswContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 190, -1));

        txtEmail.setBackground(new java.awt.Color(78, 69, 189));
        txtEmail.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(255, 255, 255));
        txtEmail.setBorder(null);
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 190, -1));

        btnRegistrate.setBackground(new java.awt.Color(56, 53, 122));
        btnRegistrate.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnRegistrate.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrate.setText("Registrate");
        jPanel1.add(btnRegistrate, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 190, 40));

        btnIniciarSesion.setBackground(new java.awt.Color(56, 53, 122));
        btnIniciarSesion.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciarSesion.setText("Iniciar Sesion");
        jPanel1.add(btnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 190, 40));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 190, 20));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 253, 190, 20));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 253, 190, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 500));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LoginImage.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(431, 0, 380, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btnRegistrate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel loginPasswordLabel;
    private javax.swing.JLabel loginTitle;
    private javax.swing.JLabel loginUserLabel;
    private javax.swing.JPasswordField pswContrasena;
    private javax.swing.JTextField txtEmail;
    // End of variables declaration//GEN-END:variables
}
