package View;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class LoginFrame extends javax.swing.JFrame {

    public LoginFrame() {
        initComponents();
        initFlat();
        setLocationRelativeTo(null);
    }
   
    private void initFlat() { 
        panelBg.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:20,2,2,2;" 
                + "arc:10");
        pswPassword.putClientProperty(FlatClientProperties.STYLE,""+
                "showRevealButton:true");
        txtUsername.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Ingrese su email");
        pswPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Ingrese su password");
         
    }
    
    public JTextField getTxtUsername() {
        return txtUsername;
    }
    
    public JPasswordField getPswPassword() {
        return pswPassword;
    }
    
    public void setLoginAction(ActionListener action){
        btnIniciarSesion.addActionListener(action);
    }
    
    public void setRegisterAction(ActionListener action){
        btnRegistrate.addActionListener(action);
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

        panelBg = new javax.swing.JPanel();
        loginTitle = new javax.swing.JLabel();
        loginUserLabel = new javax.swing.JLabel();
        loginPasswordLabel = new javax.swing.JLabel();
        pswPassword = new javax.swing.JPasswordField();
        txtUsername = new javax.swing.JTextField();
        btnRegistrate = new javax.swing.JButton();
        btnIniciarSesion = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBg.setBackground(new java.awt.Color(78, 69, 189));
        panelBg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginTitle.setBackground(new java.awt.Color(255, 255, 255));
        loginTitle.setFont(new java.awt.Font("Roboto", 1, 32)); // NOI18N
        loginTitle.setForeground(new java.awt.Color(255, 255, 255));
        loginTitle.setText("Iniciar Sesión");
        panelBg.add(loginTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, -1, -1));

        loginUserLabel.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        loginUserLabel.setForeground(new java.awt.Color(255, 255, 255));
        loginUserLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/User.png"))); // NOI18N
        loginUserLabel.setText("Email");
        panelBg.add(loginUserLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, -1, -1));

        loginPasswordLabel.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        loginPasswordLabel.setForeground(new java.awt.Color(255, 255, 255));
        loginPasswordLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Lock.png"))); // NOI18N
        loginPasswordLabel.setText("Contraseña");
        panelBg.add(loginPasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, -1, -1));

        pswPassword.setBackground(new java.awt.Color(78, 69, 189));
        pswPassword.setForeground(new java.awt.Color(255, 255, 255));
        pswPassword.setBorder(null);
        panelBg.add(pswPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 190, -1));

        txtUsername.setBackground(new java.awt.Color(78, 69, 189));
        txtUsername.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(255, 255, 255));
        txtUsername.setBorder(null);
        panelBg.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 190, -1));

        btnRegistrate.setBackground(new java.awt.Color(56, 53, 122));
        btnRegistrate.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnRegistrate.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrate.setText("Registrate");
        panelBg.add(btnRegistrate, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 190, 40));

        btnIniciarSesion.setBackground(new java.awt.Color(56, 53, 122));
        btnIniciarSesion.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciarSesion.setText("Iniciar Sesion");
        panelBg.add(btnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 190, 40));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        panelBg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 190, 20));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        panelBg.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 253, 190, 20));
        panelBg.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 253, 190, 20));

        getContentPane().add(panelBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 500));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LoginImage.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(421, 0, 390, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btnRegistrate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel loginPasswordLabel;
    private javax.swing.JLabel loginTitle;
    private javax.swing.JLabel loginUserLabel;
    private javax.swing.JPanel panelBg;
    private javax.swing.JPasswordField pswPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
