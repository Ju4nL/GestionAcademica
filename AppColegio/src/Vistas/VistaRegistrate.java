 
package Vistas;

import java.awt.Color;

 
public class VistaRegistrate extends javax.swing.JFrame {
    
    int xMouse,yMouse;
    
    public VistaRegistrate() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Bg = new javax.swing.JPanel();
        loginBgForm = new Vistas.PanelRound(0, 20, 0, 20);
        loginTitle = new javax.swing.JLabel();
        loginPasswordLabel = new javax.swing.JLabel();
        separador2 = new javax.swing.JSeparator();
        loginPasswordInput = new javax.swing.JPasswordField();
        loginBtn = new Vistas.PanelRound(10, 10, 10, 10);
        Login_BtnText = new javax.swing.JLabel();
        loginUserInput1 = new javax.swing.JTextField();
        separador3 = new javax.swing.JSeparator();
        loginUserLabel1 = new javax.swing.JLabel();
        loginUserInput2 = new javax.swing.JTextField();
        separador4 = new javax.swing.JSeparator();
        loginUserLabel2 = new javax.swing.JLabel();
        loginUserInput3 = new javax.swing.JTextField();
        separador5 = new javax.swing.JSeparator();
        loginUserLabel3 = new javax.swing.JLabel();
        loginUserInput5 = new javax.swing.JTextField();
        separador7 = new javax.swing.JSeparator();
        loginUserLabel5 = new javax.swing.JLabel();
        loginUserLabel6 = new javax.swing.JLabel();
        loginUserInput7 = new javax.swing.JTextField();
        separador9 = new javax.swing.JSeparator();
        loginUserLabel7 = new javax.swing.JLabel();
        loginUserInput8 = new javax.swing.JTextField();
        separador10 = new javax.swing.JSeparator();
        loginUserLabel8 = new javax.swing.JLabel();
        loginUserInput9 = new javax.swing.JTextField();
        loginUserLabel9 = new javax.swing.JLabel();
        separador11 = new javax.swing.JSeparator();
        separador12 = new javax.swing.JSeparator();
        loginPasswordInput1 = new javax.swing.JPasswordField();
        loginPasswordLabel1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
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
        loginTitle.setText("Registrate");
        loginBgForm.add(loginTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        loginPasswordLabel.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        loginPasswordLabel.setForeground(new java.awt.Color(255, 255, 255));
        loginPasswordLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Imagenes/Iconos/Lock.png"))); // NOI18N
        loginPasswordLabel.setText("Contraseña");
        loginBgForm.add(loginPasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        separador2.setBackground(new java.awt.Color(78, 69, 189));
        separador2.setForeground(new java.awt.Color(255, 255, 255));
        loginBgForm.add(separador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 160, -1));

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
        loginBgForm.add(loginPasswordInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 160, -1));

        loginBtn.setBackground(new java.awt.Color(56, 53, 122));

        Login_BtnText.setBackground(new java.awt.Color(56, 53, 122));
        Login_BtnText.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Login_BtnText.setForeground(new java.awt.Color(255, 255, 255));
        Login_BtnText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Login_BtnText.setText("Registrase");
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
            .addComponent(Login_BtnText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        loginBgForm.add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 210, 35));

        loginUserInput1.setBackground(new java.awt.Color(78, 69, 189));
        loginUserInput1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        loginUserInput1.setForeground(new java.awt.Color(153, 153, 153));
        loginUserInput1.setText("Ingrese su nombre");
        loginUserInput1.setToolTipText("");
        loginUserInput1.setBorder(null);
        loginUserInput1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loginUserInput1MousePressed(evt);
            }
        });
        loginBgForm.add(loginUserInput1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 160, -1));

        separador3.setBackground(new java.awt.Color(78, 69, 189));
        separador3.setForeground(new java.awt.Color(255, 255, 255));
        loginBgForm.add(separador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 160, -1));

        loginUserLabel1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        loginUserLabel1.setForeground(new java.awt.Color(255, 255, 255));
        loginUserLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Imagenes/Iconos/User.png"))); // NOI18N
        loginUserLabel1.setText("Nombre");
        loginBgForm.add(loginUserLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        loginUserInput2.setBackground(new java.awt.Color(78, 69, 189));
        loginUserInput2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        loginUserInput2.setForeground(new java.awt.Color(153, 153, 153));
        loginUserInput2.setText("Ingrese su dni");
        loginUserInput2.setToolTipText("");
        loginUserInput2.setBorder(null);
        loginUserInput2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loginUserInput2MousePressed(evt);
            }
        });
        loginBgForm.add(loginUserInput2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 160, -1));

        separador4.setBackground(new java.awt.Color(78, 69, 189));
        separador4.setForeground(new java.awt.Color(255, 255, 255));
        loginBgForm.add(separador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 160, -1));

        loginUserLabel2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        loginUserLabel2.setForeground(new java.awt.Color(255, 255, 255));
        loginUserLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Imagenes/Iconos/User.png"))); // NOI18N
        loginUserLabel2.setText("Dni");
        loginBgForm.add(loginUserLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        loginUserInput3.setBackground(new java.awt.Color(78, 69, 189));
        loginUserInput3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        loginUserInput3.setForeground(new java.awt.Color(153, 153, 153));
        loginUserInput3.setText("Ingrese su usuario");
        loginUserInput3.setToolTipText("");
        loginUserInput3.setBorder(null);
        loginUserInput3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loginUserInput3MousePressed(evt);
            }
        });
        loginBgForm.add(loginUserInput3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 160, -1));

        separador5.setBackground(new java.awt.Color(78, 69, 189));
        separador5.setForeground(new java.awt.Color(255, 255, 255));
        loginBgForm.add(separador5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 160, -1));

        loginUserLabel3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        loginUserLabel3.setForeground(new java.awt.Color(255, 255, 255));
        loginUserLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Imagenes/Iconos/User.png"))); // NOI18N
        loginUserLabel3.setText("FechaNacimiento");
        loginBgForm.add(loginUserLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        loginUserInput5.setBackground(new java.awt.Color(78, 69, 189));
        loginUserInput5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        loginUserInput5.setForeground(new java.awt.Color(153, 153, 153));
        loginUserInput5.setText("Ingrese sus apellidos");
        loginUserInput5.setToolTipText("");
        loginUserInput5.setBorder(null);
        loginUserInput5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loginUserInput5MousePressed(evt);
            }
        });
        loginBgForm.add(loginUserInput5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 160, -1));

        separador7.setBackground(new java.awt.Color(78, 69, 189));
        separador7.setForeground(new java.awt.Color(255, 255, 255));
        loginBgForm.add(separador7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 160, -1));

        loginUserLabel5.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        loginUserLabel5.setForeground(new java.awt.Color(255, 255, 255));
        loginUserLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Imagenes/Iconos/User.png"))); // NOI18N
        loginUserLabel5.setText("Apellidos");
        loginBgForm.add(loginUserLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, -1, -1));

        loginUserLabel6.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        loginUserLabel6.setForeground(new java.awt.Color(255, 255, 255));
        loginUserLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Imagenes/Iconos/User.png"))); // NOI18N
        loginUserLabel6.setText("Genero");
        loginBgForm.add(loginUserLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, -1, -1));

        loginUserInput7.setBackground(new java.awt.Color(78, 69, 189));
        loginUserInput7.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        loginUserInput7.setForeground(new java.awt.Color(153, 153, 153));
        loginUserInput7.setText("Ingrese su usuario");
        loginUserInput7.setToolTipText("");
        loginUserInput7.setBorder(null);
        loginUserInput7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loginUserInput7MousePressed(evt);
            }
        });
        loginBgForm.add(loginUserInput7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 160, -1));

        separador9.setBackground(new java.awt.Color(78, 69, 189));
        separador9.setForeground(new java.awt.Color(255, 255, 255));
        loginBgForm.add(separador9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 160, -1));

        loginUserLabel7.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        loginUserLabel7.setForeground(new java.awt.Color(255, 255, 255));
        loginUserLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Imagenes/Iconos/User.png"))); // NOI18N
        loginUserLabel7.setText("Telefono");
        loginBgForm.add(loginUserLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, -1, -1));

        loginUserInput8.setBackground(new java.awt.Color(78, 69, 189));
        loginUserInput8.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        loginUserInput8.setForeground(new java.awt.Color(153, 153, 153));
        loginUserInput8.setText("Ingrese su usuario");
        loginUserInput8.setToolTipText("");
        loginUserInput8.setBorder(null);
        loginUserInput8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loginUserInput8MousePressed(evt);
            }
        });
        loginBgForm.add(loginUserInput8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 160, -1));

        separador10.setBackground(new java.awt.Color(78, 69, 189));
        separador10.setForeground(new java.awt.Color(255, 255, 255));
        loginBgForm.add(separador10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 160, -1));

        loginUserLabel8.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        loginUserLabel8.setForeground(new java.awt.Color(255, 255, 255));
        loginUserLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Imagenes/Iconos/User.png"))); // NOI18N
        loginUserLabel8.setText("Email");
        loginBgForm.add(loginUserLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        loginUserInput9.setBackground(new java.awt.Color(78, 69, 189));
        loginUserInput9.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        loginUserInput9.setForeground(new java.awt.Color(153, 153, 153));
        loginUserInput9.setText("Ingrese su usuario");
        loginUserInput9.setToolTipText("");
        loginUserInput9.setBorder(null);
        loginUserInput9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loginUserInput9MousePressed(evt);
            }
        });
        loginBgForm.add(loginUserInput9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 160, -1));

        loginUserLabel9.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        loginUserLabel9.setForeground(new java.awt.Color(255, 255, 255));
        loginUserLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Imagenes/Iconos/User.png"))); // NOI18N
        loginUserLabel9.setText("Direccion");
        loginBgForm.add(loginUserLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, -1, -1));

        separador11.setBackground(new java.awt.Color(78, 69, 189));
        separador11.setForeground(new java.awt.Color(255, 255, 255));
        loginBgForm.add(separador11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 160, -1));

        separador12.setBackground(new java.awt.Color(78, 69, 189));
        separador12.setForeground(new java.awt.Color(255, 255, 255));
        loginBgForm.add(separador12, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, 160, -1));

        loginPasswordInput1.setBackground(new java.awt.Color(78, 69, 189));
        loginPasswordInput1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        loginPasswordInput1.setForeground(new java.awt.Color(153, 153, 153));
        loginPasswordInput1.setText("********");
        loginPasswordInput1.setBorder(null);
        loginPasswordInput1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loginPasswordInput1MousePressed(evt);
            }
        });
        loginBgForm.add(loginPasswordInput1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, 160, -1));

        loginPasswordLabel1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        loginPasswordLabel1.setForeground(new java.awt.Color(255, 255, 255));
        loginPasswordLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Imagenes/Iconos/Lock.png"))); // NOI18N
        loginPasswordLabel1.setText("Contraseña");
        loginBgForm.add(loginPasswordLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, -1, -1));

        jComboBox2.setBackground(new java.awt.Color(78, 69, 189));
        jComboBox2.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Femenino", "Masculino" }));
        jComboBox2.setBorder(null);
        jComboBox2.setFocusable(false);
        loginBgForm.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 160, -1));

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

        loginImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Imagenes/img/RegisterImage.png"))); // NOI18N
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

    
    private void loginPasswordInputMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginPasswordInputMousePressed
        if(String.valueOf(loginPasswordInput.getPassword()).equals("********")){
            loginPasswordInput.setText("");
            loginPasswordInput.setForeground(Color.white);
        }
        //if(loginUserInput.getText().isEmpty()){
        //    loginUserInput.setText("Ingrese su usuario"); 
        //    loginUserInput.setForeground(Color.gray);
        //}
    }//GEN-LAST:event_loginPasswordInputMousePressed

    private void loginUserInput1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginUserInput1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginUserInput1MousePressed

    private void loginUserInput2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginUserInput2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginUserInput2MousePressed

    private void loginUserInput3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginUserInput3MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginUserInput3MousePressed

    private void loginUserInput5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginUserInput5MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginUserInput5MousePressed

    private void loginUserInput7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginUserInput7MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginUserInput7MousePressed

    private void loginUserInput8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginUserInput8MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginUserInput8MousePressed

    private void loginUserInput9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginUserInput9MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginUserInput9MousePressed

    private void loginPasswordInput1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginPasswordInput1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginPasswordInput1MousePressed


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
            java.util.logging.Logger.getLogger(VistaRegistrate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaRegistrate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaRegistrate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaRegistrate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaRegistrate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Bg;
    private javax.swing.JLabel IconExit;
    private javax.swing.JLabel Login_BtnText;
    private javax.swing.JPanel btnExit;
    private javax.swing.JPanel header;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JPanel loginBgForm;
    private javax.swing.JPanel loginBtn;
    private javax.swing.JLabel loginImage;
    private javax.swing.JPasswordField loginPasswordInput;
    private javax.swing.JPasswordField loginPasswordInput1;
    private javax.swing.JLabel loginPasswordLabel;
    private javax.swing.JLabel loginPasswordLabel1;
    private javax.swing.JLabel loginTitle;
    private javax.swing.JTextField loginUserInput1;
    private javax.swing.JTextField loginUserInput2;
    private javax.swing.JTextField loginUserInput3;
    private javax.swing.JTextField loginUserInput5;
    private javax.swing.JTextField loginUserInput7;
    private javax.swing.JTextField loginUserInput8;
    private javax.swing.JTextField loginUserInput9;
    private javax.swing.JLabel loginUserLabel1;
    private javax.swing.JLabel loginUserLabel2;
    private javax.swing.JLabel loginUserLabel3;
    private javax.swing.JLabel loginUserLabel5;
    private javax.swing.JLabel loginUserLabel6;
    private javax.swing.JLabel loginUserLabel7;
    private javax.swing.JLabel loginUserLabel8;
    private javax.swing.JLabel loginUserLabel9;
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
