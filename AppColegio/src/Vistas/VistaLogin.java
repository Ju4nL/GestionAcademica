 
package Vistas;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;

 
public class VistaLogin extends javax.swing.JPanel {
    private VistaRun frame;
    int xMouse,yMouse;
 
    public VistaLogin(VistaRun frame) {
        this.frame = frame;
        initComponents();
        init();
    }
    
    private void init(){
         
        loginPasswordInput.putClientProperty(FlatClientProperties.STYLE,""+
                "showRevealButton:true");
        loginUserInput.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Ingrese su email");
        loginPasswordInput.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Ingrese su password");
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginBgForm = new Vistas.PanelRound(0, 20, 0, 20);
        loginTitle = new javax.swing.JLabel();
        loginUserLabel = new javax.swing.JLabel();
        loginUserInput = new javax.swing.JTextField();
        separador1 = new javax.swing.JSeparator();
        loginPasswordLabel = new javax.swing.JLabel();
        separador2 = new javax.swing.JSeparator();
        loginPasswordInput = new javax.swing.JPasswordField();
        registerBtn = new Vistas.PanelRound(10, 10, 10, 10);
        registerBtnText = new javax.swing.JLabel();
        loginBtn = new Vistas.PanelRound(10, 10, 10, 10);
        Login_BtnText = new javax.swing.JLabel();
        loginImage = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        loginBgForm.setBackground(new java.awt.Color(78, 69, 189));
        loginBgForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginTitle.setBackground(new java.awt.Color(255, 255, 255));
        loginTitle.setFont(new java.awt.Font("Roboto", 1, 32)); // NOI18N
        loginTitle.setForeground(new java.awt.Color(255, 255, 255));
        loginTitle.setText("Iniciar Sesión");
        loginBgForm.add(loginTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, -1, -1));

        loginUserLabel.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        loginUserLabel.setForeground(new java.awt.Color(255, 255, 255));
        loginUserLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Imagenes/Iconos/User.png"))); // NOI18N
        loginUserLabel.setText("Email");
        loginBgForm.add(loginUserLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, -1, -1));

        loginUserInput.setBackground(new java.awt.Color(78, 69, 189));
        loginUserInput.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        loginUserInput.setForeground(new java.awt.Color(255, 255, 255));
        loginUserInput.setToolTipText("");
        loginUserInput.setBorder(null);
        loginBgForm.add(loginUserInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 210, -1));

        separador1.setBackground(new java.awt.Color(78, 69, 189));
        separador1.setForeground(new java.awt.Color(255, 255, 255));
        loginBgForm.add(separador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 210, -1));

        loginPasswordLabel.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        loginPasswordLabel.setForeground(new java.awt.Color(255, 255, 255));
        loginPasswordLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Imagenes/Iconos/Lock.png"))); // NOI18N
        loginPasswordLabel.setText("Contraseña");
        loginBgForm.add(loginPasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, -1, -1));

        separador2.setBackground(new java.awt.Color(78, 69, 189));
        separador2.setForeground(new java.awt.Color(255, 255, 255));
        loginBgForm.add(separador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 210, -1));

        loginPasswordInput.setBackground(new java.awt.Color(78, 69, 189));
        loginPasswordInput.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        loginPasswordInput.setForeground(new java.awt.Color(255, 255, 255));
        loginPasswordInput.setActionCommand("<Not Set>");
        loginPasswordInput.setBorder(null);
        loginBgForm.add(loginPasswordInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 210, -1));

        registerBtn.setBackground(new java.awt.Color(56, 53, 122));

        registerBtnText.setBackground(new java.awt.Color(56, 53, 122));
        registerBtnText.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        registerBtnText.setForeground(new java.awt.Color(255, 255, 255));
        registerBtnText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registerBtnText.setText("Registrate");
        registerBtnText.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registerBtnText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerBtnTextMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerBtnTextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registerBtnTextMouseExited(evt);
            }
        });

        javax.swing.GroupLayout registerBtnLayout = new javax.swing.GroupLayout(registerBtn);
        registerBtn.setLayout(registerBtnLayout);
        registerBtnLayout.setHorizontalGroup(
            registerBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registerBtnText, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
        );
        registerBtnLayout.setVerticalGroup(
            registerBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registerBtnText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        loginBgForm.add(registerBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 210, 35));

        loginBtn.setBackground(new java.awt.Color(56, 53, 122));

        Login_BtnText.setBackground(new java.awt.Color(56, 53, 122));
        Login_BtnText.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Login_BtnText.setForeground(new java.awt.Color(255, 255, 255));
        Login_BtnText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Login_BtnText.setText("Iniciar Sesion");
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
            .addComponent(Login_BtnText, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        loginBgForm.add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 210, 35));

        loginImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Imagenes/img/LoginImage.png"))); // NOI18N
        loginImage.setMaximumSize(new java.awt.Dimension(810, 500));
        loginImage.setMinimumSize(new java.awt.Dimension(810, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(loginBgForm, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(loginImage, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginBgForm, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void registerBtnTextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerBtnTextMouseEntered
        registerBtn.setBackground(new Color(64,58,152));
    }//GEN-LAST:event_registerBtnTextMouseEntered

    private void registerBtnTextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerBtnTextMouseExited
        registerBtn.setBackground(new Color(56,53,122));
    }//GEN-LAST:event_registerBtnTextMouseExited

    private void Login_BtnTextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Login_BtnTextMouseEntered
        loginBtn.setBackground(new Color(64,58,152));
    }//GEN-LAST:event_Login_BtnTextMouseEntered

    private void Login_BtnTextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Login_BtnTextMouseExited
        loginBtn.setBackground(new Color(56,53,122));
    }//GEN-LAST:event_Login_BtnTextMouseExited

    private void registerBtnTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerBtnTextMouseClicked
        
       frame.changeContent(frame.registerPanel);
    }//GEN-LAST:event_registerBtnTextMouseClicked

    private void Login_BtnTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Login_BtnTextMouseClicked
       frame.changeContent(frame.homePanel,1100,600);
    }//GEN-LAST:event_Login_BtnTextMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Login_BtnText;
    private javax.swing.JPanel loginBgForm;
    private javax.swing.JPanel loginBtn;
    private javax.swing.JLabel loginImage;
    private javax.swing.JPasswordField loginPasswordInput;
    private javax.swing.JLabel loginPasswordLabel;
    private javax.swing.JLabel loginTitle;
    private javax.swing.JTextField loginUserInput;
    private javax.swing.JLabel loginUserLabel;
    private javax.swing.JPanel registerBtn;
    private javax.swing.JLabel registerBtnText;
    private javax.swing.JSeparator separador1;
    private javax.swing.JSeparator separador2;
    // End of variables declaration//GEN-END:variables
}
