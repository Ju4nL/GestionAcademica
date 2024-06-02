 
package Vistas;

import java.awt.Color;

 
public class VistaLogin extends javax.swing.JFrame {
    
    int xMouse,yMouse;
    
    public VistaLogin() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Bg = new javax.swing.JPanel();
        loginBgForm = new Vistas.PanelRound(0, 20, 0, 20);
        loginTitle = new javax.swing.JLabel();
        loginUserLabel = new javax.swing.JLabel();
        loginUserInput = new javax.swing.JTextField();
        separador1 = new javax.swing.JSeparator();
        loginPasswordLabel = new javax.swing.JLabel();
        separador2 = new javax.swing.JSeparator();
        loginPasswordInput = new javax.swing.JPasswordField();
        loginBtn = new Vistas.PanelRound(10, 10, 10, 10);
        Login_BtnText = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        btnExit =  new Vistas.PanelRound(10, 10, 10, 10);
        IconExit = new javax.swing.JLabel();
        loginImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        Bg.setBackground(new java.awt.Color(255, 255, 255));
        Bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        loginUserLabel.setText("Usuario");
        loginBgForm.add(loginUserLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, -1, -1));

        loginUserInput.setBackground(new java.awt.Color(78, 69, 189));
        loginUserInput.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        loginUserInput.setForeground(new java.awt.Color(153, 153, 153));
        loginUserInput.setText("Ingrese su usuario");
        loginUserInput.setToolTipText("");
        loginUserInput.setBorder(null);
        loginUserInput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loginUserInputMousePressed(evt);
            }
        });
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
        loginPasswordInput.setForeground(new java.awt.Color(153, 153, 153));
        loginPasswordInput.setText("********");
        loginPasswordInput.setBorder(null);
        loginPasswordInput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loginPasswordInputMousePressed(evt);
            }
        });
        loginBgForm.add(loginPasswordInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 210, -1));

        loginBtn.setBackground(new java.awt.Color(56, 53, 122));

        Login_BtnText.setBackground(new java.awt.Color(56, 53, 122));
        Login_BtnText.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Login_BtnText.setForeground(new java.awt.Color(255, 255, 255));
        Login_BtnText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Login_BtnText.setText("Iniciar");
        Login_BtnText.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Login_BtnText.addMouseListener(new java.awt.event.MouseAdapter() {
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

        Bg.add(loginBgForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 500));

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.setForeground(new java.awt.Color(255, 255, 255));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnExit.setBackground(new java.awt.Color(255, 51, 51));
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });
        btnExit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        IconExit.setBackground(new java.awt.Color(255, 255, 255));
        IconExit.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        IconExit.setForeground(new java.awt.Color(255, 255, 255));
        IconExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IconExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Imagenes/Iconos/x.png"))); // NOI18N
        IconExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        IconExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        IconExit.setName(""); // NOI18N
        IconExit.setPreferredSize(new java.awt.Dimension(20, 20));
        IconExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IconExitMouseClicked(evt);
            }
        });
        btnExit.add(IconExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 8, 10, 10));

        header.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 5, 25, 25));

        Bg.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 30));

        loginImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Imagenes/img/LoginImage.png"))); // NOI18N
        Bg.add(loginImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 390, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
        
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x-xMouse,y-yMouse);
    }//GEN-LAST:event_headerMouseDragged
 
    private void IconExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IconExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_IconExitMouseClicked

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnExitMouseClicked

    private void Login_BtnTextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Login_BtnTextMouseEntered
         loginBtn.setBackground(new Color(64,58,152));
    }//GEN-LAST:event_Login_BtnTextMouseEntered

    private void Login_BtnTextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Login_BtnTextMouseExited
        loginBtn.setBackground(new Color(56,53,122));
    }//GEN-LAST:event_Login_BtnTextMouseExited

    
    private void loginUserInputMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginUserInputMousePressed
        if(loginUserInput.getText().equals("Ingrese su usuario")){
            loginUserInput.setText("");
            loginUserInput.setForeground(Color.white);
        }
        if(String.valueOf(loginPasswordInput.getPassword()).isEmpty()){
            loginPasswordInput.setText("********");
            loginPasswordInput.setForeground(Color.gray);
        }
    }//GEN-LAST:event_loginUserInputMousePressed

    private void loginPasswordInputMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginPasswordInputMousePressed
        if(String.valueOf(loginPasswordInput.getPassword()).equals("********")){
            loginPasswordInput.setText("");
            loginPasswordInput.setForeground(Color.white);
        }
        if(loginUserInput.getText().isEmpty()){
            loginUserInput.setText("Ingrese su usuario"); 
            loginUserInput.setForeground(Color.gray);
        }
    }//GEN-LAST:event_loginPasswordInputMousePressed


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Bg;
    private javax.swing.JLabel IconExit;
    private javax.swing.JLabel Login_BtnText;
    private javax.swing.JPanel btnExit;
    private javax.swing.JPanel header;
    private javax.swing.JPanel loginBgForm;
    private javax.swing.JPanel loginBtn;
    private javax.swing.JLabel loginImage;
    private javax.swing.JPasswordField loginPasswordInput;
    private javax.swing.JLabel loginPasswordLabel;
    private javax.swing.JLabel loginTitle;
    private javax.swing.JTextField loginUserInput;
    private javax.swing.JLabel loginUserLabel;
    private javax.swing.JSeparator separador1;
    private javax.swing.JSeparator separador2;
    // End of variables declaration//GEN-END:variables
}
