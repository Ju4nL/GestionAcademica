/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.JButton;
import javax.swing.JTable;

/**
 *
 * @author LOZADA
 */
public class PanelSolicitudes extends javax.swing.JPanel {

 
    public PanelSolicitudes(boolean is_admin) { 
        initComponents(); 
        configureButtons(is_admin);
    }
    private void configureButtons(boolean is_admin) {
        if (is_admin) {
            btnAprobar.setVisible(true);
            btnRechazar.setVisible(true);
            btnVer.setVisible(true);
            btnCancelar.setVisible(false);
        } else {
            btnAprobar.setVisible(false);
            btnRechazar.setVisible(false);
            btnVer.setVisible(false);
            btnCancelar.setVisible(true);
        }
    }

    public JButton getBtnAprobar() {
        return btnAprobar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public JButton getBtnRechazar() {
        return btnRechazar;
    }

    public JButton getBtnVer() {
        return btnVer;
    }

    public JTable getTblSolicitudes() {
        return tblSolicitudes;
    }
    
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Titulo = new javax.swing.JLabel();
        scrool = new javax.swing.JScrollPane();
        tblSolicitudes = new javax.swing.JTable();
        btnVer = new javax.swing.JButton();
        btnAprobar = new javax.swing.JButton();
        btnRechazar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setBackground(new java.awt.Color(240, 243, 253));
        setPreferredSize(new java.awt.Dimension(815, 588));

        jPanel1.setBackground(new java.awt.Color(240, 243, 253));

        Titulo.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        Titulo.setForeground(new java.awt.Color(51, 51, 51));
        Titulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Solicitudes.png"))); // NOI18N
        Titulo.setText("Solicitudes");

        tblSolicitudes.setModel(new javax.swing.table.DefaultTableModel(
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
        scrool.setViewportView(tblSolicitudes);

        btnVer.setBackground(new java.awt.Color(56, 53, 122));
        btnVer.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        btnVer.setForeground(new java.awt.Color(255, 255, 255));
        btnVer.setText("Ver");
        btnVer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });

        btnAprobar.setBackground(new java.awt.Color(56, 53, 122));
        btnAprobar.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        btnAprobar.setForeground(new java.awt.Color(255, 255, 255));
        btnAprobar.setText("Aprobar");
        btnAprobar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnRechazar.setBackground(new java.awt.Color(255, 102, 102));
        btnRechazar.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        btnRechazar.setForeground(new java.awt.Color(255, 255, 255));
        btnRechazar.setText("Rechazar");
        btnRechazar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnCancelar.setBackground(new java.awt.Color(255, 102, 102));
        btnCancelar.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrool, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRechazar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAprobar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(Titulo)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAprobar)
                    .addComponent(btnVer)
                    .addComponent(btnRechazar)
                    .addComponent(btnCancelar))
                .addGap(18, 18, 18)
                .addComponent(scrool, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton btnAprobar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRechazar;
    private javax.swing.JButton btnVer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane scrool;
    private javax.swing.JTable tblSolicitudes;
    // End of variables declaration//GEN-END:variables
}
