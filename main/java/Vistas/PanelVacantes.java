 
package com.myapp.appacademico.Vistas;
public class PanelVacantes extends javax.swing.JPanel {

    /**
     * Creates new form PanelVacantes
     */
    public PanelVacantes() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Bg = new javax.swing.JPanel();
        Titulo = new javax.swing.JLabel();
        Icon = new javax.swing.JLabel();
        Bg_busqueda = new Vistas.PanelRound(10, 10, 10, 10);
        Icon_busqueda = new javax.swing.JLabel();
        busqueda_vacantes = new javax.swing.JTextField();
        Tabla_vacantes = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Actualizar_vacantes = new javax.swing.JButton();

        setBackground(new java.awt.Color(240, 243, 253));
        setPreferredSize(new java.awt.Dimension(896, 576));

        Bg.setBackground(new java.awt.Color(240, 243, 253));

        Titulo.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        Titulo.setForeground(new java.awt.Color(51, 51, 51));
        Titulo.setText("Vacantes");

        Icon.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Imagenes/Iconos/Vacantes.png"))); // NOI18N
        Icon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Bg_busqueda.setBackground(new java.awt.Color(255, 255, 255));
        Bg_busqueda.setMaximumSize(new java.awt.Dimension(500, 32767));
        Bg_busqueda.setMinimumSize(new java.awt.Dimension(200, 100));

        Icon_busqueda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Icon_busqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Imagenes/Iconos/Search.png"))); // NOI18N

        busqueda_vacantes.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        busqueda_vacantes.setForeground(new java.awt.Color(51, 51, 51));
        busqueda_vacantes.setText("jTextField1");
        busqueda_vacantes.setBorder(null);

        javax.swing.GroupLayout Bg_busquedaLayout = new javax.swing.GroupLayout(Bg_busqueda);
        Bg_busqueda.setLayout(Bg_busquedaLayout);
        Bg_busquedaLayout.setHorizontalGroup(
            Bg_busquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Bg_busquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Icon_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(busqueda_vacantes, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addContainerGap())
        );
        Bg_busquedaLayout.setVerticalGroup(
            Bg_busquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Bg_busquedaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Bg_busquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(busqueda_vacantes, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Icon_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        Tabla_vacantes.setViewportView(jTable1);

        Actualizar_vacantes.setBackground(new java.awt.Color(56, 53, 122));
        Actualizar_vacantes.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        Actualizar_vacantes.setForeground(new java.awt.Color(255, 255, 255));
        Actualizar_vacantes.setText("Actualizar");
        Actualizar_vacantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Actualizar_vacantesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BgLayout = new javax.swing.GroupLayout(Bg);
        Bg.setLayout(BgLayout);
        BgLayout.setHorizontalGroup(
            BgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BgLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(BgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BgLayout.createSequentialGroup()
                        .addComponent(Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BgLayout.createSequentialGroup()
                        .addGroup(BgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(BgLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(Bg_busqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(285, 285, 285)
                                .addComponent(Actualizar_vacantes, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Tabla_vacantes))
                        .addGap(27, 27, 27))))
        );
        BgLayout.setVerticalGroup(
            BgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BgLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(BgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Titulo)
                    .addComponent(Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Bg_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Actualizar_vacantes, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tabla_vacantes, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Bg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Bg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Actualizar_vacantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Actualizar_vacantesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Actualizar_vacantesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar_vacantes;
    private javax.swing.JPanel Bg;
    private javax.swing.JPanel Bg_busqueda;
    private javax.swing.JLabel Icon;
    private javax.swing.JLabel Icon_busqueda;
    private javax.swing.JScrollPane Tabla_vacantes;
    private javax.swing.JLabel Titulo;
    private javax.swing.JTextField busqueda_vacantes;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
