 
package com.myapp.appacademico.Vistas;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;

  
public class VistaRegister extends javax.swing.JPanel {
    private VistaRun frame;
   
    public VistaRegister(VistaRun frame) {
        this.frame = frame;
        initComponents();
        init();
    }
    
    private void init(){
        FlatLightLaf.setup();
        rgPasswordInput.putClientProperty(FlatClientProperties.STYLE,""+
                "showRevealButton:true");
        rgPassword2Input.putClientProperty(FlatClientProperties.STYLE,""+
                "showRevealButton:true");
        
        rgNombreInput.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Ingrese su nombre");
        rgApellidosInput.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Ingrese sus apellidos");
        rgDniInput.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Ingrese su Dni");
        rgFechaNacInput.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"dd/mm/yyy");
        rgEmailInput.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Ingrese su email");
        rgTelInput.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Ingrese su telefono");
        rgDirInput.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Ingrese su direccion");
        
        rgPasswordInput.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Ingrese una contraseña");
        rgPassword2Input.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Repita la contraseña");
        
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registerImage = new javax.swing.JLabel();
        registerForm = new Vistas.PanelRound(0, 20, 0, 20);
        loginBtn = new Vistas.PanelRound(10, 10, 10, 10);
        Login_BtnText = new javax.swing.JLabel();
        rgTitle = new javax.swing.JLabel();
        rgNombreLb = new javax.swing.JLabel();
        rgNombreInput = new javax.swing.JTextField();
        separador3 = new javax.swing.JSeparator();
        rgDniLb = new javax.swing.JLabel();
        rgDniInput = new javax.swing.JTextField();
        separador4 = new javax.swing.JSeparator();
        rgFechaNacLb = new javax.swing.JLabel();
        rgFechaNacInput = new javax.swing.JTextField();
        separador5 = new javax.swing.JSeparator();
        rgEmailLb = new javax.swing.JLabel();
        rgEmailInput = new javax.swing.JTextField();
        separador10 = new javax.swing.JSeparator();
        rgPasswordLb = new javax.swing.JLabel();
        rgPasswordInput = new javax.swing.JPasswordField();
        separador2 = new javax.swing.JSeparator();
        rgApellidosLb = new javax.swing.JLabel();
        rgApellidosInput = new javax.swing.JTextField();
        separador7 = new javax.swing.JSeparator();
        rgGeneroLb = new javax.swing.JLabel();
        rgGeneroInput = new javax.swing.JComboBox<>();
        rgTelLb = new javax.swing.JLabel();
        rgTelInput = new javax.swing.JTextField();
        separador9 = new javax.swing.JSeparator();
        rgDirLb = new javax.swing.JLabel();
        rgDirInput = new javax.swing.JTextField();
        separador11 = new javax.swing.JSeparator();
        rgPassword2Lb = new javax.swing.JLabel();
        rgPassword2Input = new javax.swing.JPasswordField();
        separador12 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));

        registerImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Imagenes/img/RegisterImage.png"))); // NOI18N

        registerForm.setBackground(new java.awt.Color(78, 69, 189));
        registerForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginBtn.setBackground(new java.awt.Color(56, 53, 122));

        Login_BtnText.setBackground(new java.awt.Color(56, 53, 122));
        Login_BtnText.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Login_BtnText.setForeground(new java.awt.Color(255, 255, 255));
        Login_BtnText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Login_BtnText.setText("Registrase");
        Login_BtnText.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Login_BtnText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Login_BtnTextMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Login_BtnTextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Login_BtnTextMouseExited(evt);
            }
        });

        javax.swing.GroupLayout loginBtnLayout = new javax.swing.GroupLayout(loginBtn);
        loginBtn.setLayout(loginBtnLayout);
        loginBtnLayout.setHorizontalGroup(
            loginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Login_BtnText, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
        );
        loginBtnLayout.setVerticalGroup(
            loginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Login_BtnText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        registerForm.add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 210, 35));

        rgTitle.setBackground(new java.awt.Color(255, 255, 255));
        rgTitle.setFont(new java.awt.Font("Roboto", 1, 32)); // NOI18N
        rgTitle.setForeground(new java.awt.Color(255, 255, 255));
        rgTitle.setText("Registrate");
        registerForm.add(rgTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        rgNombreLb.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        rgNombreLb.setForeground(new java.awt.Color(255, 255, 255));
        rgNombreLb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Imagenes/Iconos/User.png"))); // NOI18N
        rgNombreLb.setText("Nombre");
        registerForm.add(rgNombreLb, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        rgNombreInput.setBackground(new java.awt.Color(78, 69, 189));
        rgNombreInput.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        rgNombreInput.setForeground(new java.awt.Color(255, 255, 255));
        rgNombreInput.setToolTipText("");
        rgNombreInput.setBorder(null);
        registerForm.add(rgNombreInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 160, -1));

        separador3.setBackground(new java.awt.Color(78, 69, 189));
        separador3.setForeground(new java.awt.Color(255, 255, 255));
        registerForm.add(separador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 160, -1));

        rgDniLb.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        rgDniLb.setForeground(new java.awt.Color(255, 255, 255));
        rgDniLb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Imagenes/Iconos/User.png"))); // NOI18N
        rgDniLb.setText("Dni");
        registerForm.add(rgDniLb, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        rgDniInput.setBackground(new java.awt.Color(78, 69, 189));
        rgDniInput.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        rgDniInput.setForeground(new java.awt.Color(255, 255, 255));
        rgDniInput.setToolTipText("");
        rgDniInput.setBorder(null);
        registerForm.add(rgDniInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 160, -1));

        separador4.setBackground(new java.awt.Color(78, 69, 189));
        separador4.setForeground(new java.awt.Color(255, 255, 255));
        registerForm.add(separador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 160, -1));

        rgFechaNacLb.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        rgFechaNacLb.setForeground(new java.awt.Color(255, 255, 255));
        rgFechaNacLb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Imagenes/Iconos/User.png"))); // NOI18N
        rgFechaNacLb.setText("FechaNacimiento");
        registerForm.add(rgFechaNacLb, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        rgFechaNacInput.setBackground(new java.awt.Color(78, 69, 189));
        rgFechaNacInput.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        rgFechaNacInput.setForeground(new java.awt.Color(255, 255, 255));
        rgFechaNacInput.setToolTipText("");
        rgFechaNacInput.setBorder(null);
        registerForm.add(rgFechaNacInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 160, -1));

        separador5.setBackground(new java.awt.Color(78, 69, 189));
        separador5.setForeground(new java.awt.Color(255, 255, 255));
        registerForm.add(separador5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 160, -1));

        rgEmailLb.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        rgEmailLb.setForeground(new java.awt.Color(255, 255, 255));
        rgEmailLb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Imagenes/Iconos/User.png"))); // NOI18N
        rgEmailLb.setText("Email");
        registerForm.add(rgEmailLb, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        rgEmailInput.setBackground(new java.awt.Color(78, 69, 189));
        rgEmailInput.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        rgEmailInput.setForeground(new java.awt.Color(255, 255, 255));
        rgEmailInput.setToolTipText("");
        rgEmailInput.setBorder(null);
        registerForm.add(rgEmailInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 160, -1));

        separador10.setBackground(new java.awt.Color(78, 69, 189));
        separador10.setForeground(new java.awt.Color(255, 255, 255));
        registerForm.add(separador10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 160, -1));

        rgPasswordLb.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        rgPasswordLb.setForeground(new java.awt.Color(255, 255, 255));
        rgPasswordLb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Imagenes/Iconos/Lock.png"))); // NOI18N
        rgPasswordLb.setText("Contraseña");
        registerForm.add(rgPasswordLb, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        rgPasswordInput.setBackground(new java.awt.Color(78, 69, 189));
        rgPasswordInput.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        rgPasswordInput.setForeground(new java.awt.Color(255, 255, 255));
        rgPasswordInput.setBorder(null);
        registerForm.add(rgPasswordInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 160, -1));

        separador2.setBackground(new java.awt.Color(78, 69, 189));
        separador2.setForeground(new java.awt.Color(255, 255, 255));
        registerForm.add(separador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 160, -1));

        rgApellidosLb.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        rgApellidosLb.setForeground(new java.awt.Color(255, 255, 255));
        rgApellidosLb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Imagenes/Iconos/User.png"))); // NOI18N
        rgApellidosLb.setText("Apellidos");
        registerForm.add(rgApellidosLb, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, -1, -1));

        rgApellidosInput.setBackground(new java.awt.Color(78, 69, 189));
        rgApellidosInput.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        rgApellidosInput.setForeground(new java.awt.Color(255, 255, 255));
        rgApellidosInput.setToolTipText("");
        rgApellidosInput.setBorder(null);
        registerForm.add(rgApellidosInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 160, -1));

        separador7.setBackground(new java.awt.Color(78, 69, 189));
        separador7.setForeground(new java.awt.Color(255, 255, 255));
        registerForm.add(separador7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 160, -1));

        rgGeneroLb.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        rgGeneroLb.setForeground(new java.awt.Color(255, 255, 255));
        rgGeneroLb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Imagenes/Iconos/User.png"))); // NOI18N
        rgGeneroLb.setText("Genero");
        registerForm.add(rgGeneroLb, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, -1, -1));

        rgGeneroInput.setBackground(new java.awt.Color(78, 69, 189));
        rgGeneroInput.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        rgGeneroInput.setForeground(new java.awt.Color(255, 255, 255));
        rgGeneroInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Femenino", "Masculino" }));
        rgGeneroInput.setBorder(null);
        rgGeneroInput.setFocusable(false);
        registerForm.add(rgGeneroInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 160, -1));

        rgTelLb.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        rgTelLb.setForeground(new java.awt.Color(255, 255, 255));
        rgTelLb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Imagenes/Iconos/User.png"))); // NOI18N
        rgTelLb.setText("Telefono");
        registerForm.add(rgTelLb, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, -1, -1));

        rgTelInput.setBackground(new java.awt.Color(78, 69, 189));
        rgTelInput.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        rgTelInput.setForeground(new java.awt.Color(255, 255, 255));
        rgTelInput.setToolTipText("");
        rgTelInput.setBorder(null);
        registerForm.add(rgTelInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 160, -1));

        separador9.setBackground(new java.awt.Color(78, 69, 189));
        separador9.setForeground(new java.awt.Color(255, 255, 255));
        registerForm.add(separador9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 160, -1));

        rgDirLb.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        rgDirLb.setForeground(new java.awt.Color(255, 255, 255));
        rgDirLb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Imagenes/Iconos/User.png"))); // NOI18N
        rgDirLb.setText("Direccion");
        registerForm.add(rgDirLb, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, -1, -1));

        rgDirInput.setBackground(new java.awt.Color(78, 69, 189));
        rgDirInput.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        rgDirInput.setForeground(new java.awt.Color(255, 255, 255));
        rgDirInput.setToolTipText("");
        rgDirInput.setBorder(null);
        registerForm.add(rgDirInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 160, -1));

        separador11.setBackground(new java.awt.Color(78, 69, 189));
        separador11.setForeground(new java.awt.Color(255, 255, 255));
        registerForm.add(separador11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 160, -1));

        rgPassword2Lb.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        rgPassword2Lb.setForeground(new java.awt.Color(255, 255, 255));
        rgPassword2Lb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Imagenes/Iconos/Lock.png"))); // NOI18N
        rgPassword2Lb.setText("Repetir contraseña");
        registerForm.add(rgPassword2Lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, -1, -1));

        rgPassword2Input.setBackground(new java.awt.Color(78, 69, 189));
        rgPassword2Input.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        rgPassword2Input.setForeground(new java.awt.Color(255, 255, 255));
        rgPassword2Input.setBorder(null);
        registerForm.add(rgPassword2Input, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, 160, -1));

        separador12.setBackground(new java.awt.Color(78, 69, 189));
        separador12.setForeground(new java.awt.Color(255, 255, 255));
        registerForm.add(separador12, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, 160, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(registerForm, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(registerImage, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registerForm, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(registerImage)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Login_BtnTextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Login_BtnTextMouseEntered
        loginBtn.setBackground(new Color(64,58,152));
    }//GEN-LAST:event_Login_BtnTextMouseEntered

    private void Login_BtnTextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Login_BtnTextMouseExited
        loginBtn.setBackground(new Color(56,53,122));
    }//GEN-LAST:event_Login_BtnTextMouseExited

    private void Login_BtnTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Login_BtnTextMouseClicked
   
        frame.changeContent(frame.loginPanel);
    }//GEN-LAST:event_Login_BtnTextMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Login_BtnText;
    private javax.swing.JPanel loginBtn;
    private javax.swing.JPanel registerForm;
    private javax.swing.JLabel registerImage;
    private javax.swing.JTextField rgApellidosInput;
    private javax.swing.JLabel rgApellidosLb;
    private javax.swing.JTextField rgDirInput;
    private javax.swing.JLabel rgDirLb;
    private javax.swing.JTextField rgDniInput;
    private javax.swing.JLabel rgDniLb;
    private javax.swing.JTextField rgEmailInput;
    private javax.swing.JLabel rgEmailLb;
    private javax.swing.JTextField rgFechaNacInput;
    private javax.swing.JLabel rgFechaNacLb;
    private javax.swing.JComboBox<String> rgGeneroInput;
    private javax.swing.JLabel rgGeneroLb;
    private javax.swing.JTextField rgNombreInput;
    private javax.swing.JLabel rgNombreLb;
    private javax.swing.JPasswordField rgPassword2Input;
    private javax.swing.JLabel rgPassword2Lb;
    private javax.swing.JPasswordField rgPasswordInput;
    private javax.swing.JLabel rgPasswordLb;
    private javax.swing.JTextField rgTelInput;
    private javax.swing.JLabel rgTelLb;
    private javax.swing.JLabel rgTitle;
    private javax.swing.JSeparator separador10;
    private javax.swing.JSeparator separador11;
    private javax.swing.JSeparator separador12;
    private javax.swing.JSeparator separador2;
    private javax.swing.JSeparator separador3;
    private javax.swing.JSeparator separador4;
    private javax.swing.JSeparator separador5;
    private javax.swing.JSeparator separador7;
    private javax.swing.JSeparator separador9;
    // End of variables declaration//GEN-END:variables
}
