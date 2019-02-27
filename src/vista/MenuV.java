package vista;

import controlador.LoginC;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import servicios.BackupDb;

public class MenuV extends javax.swing.JFrame {

    public MenuV() throws FileNotFoundException, IOException {
        
        initComponents();
        setLocationRelativeTo(null);
//        this.setExtendedState(MAXIMIZED_BOTH);
        pnlSupport.setVisible(false);
        switch (LoginC.tipoDePersona) {
            case "A":
                pnlSupport.setVisible(true);
                break;
            case "V":
                pnlPersonas.setVisible(false);
                pnlProducto.setVisible(false);
                break;
            case "I":
                pnlPersonas.setVisible(false);
                pnlVentas.setVisible(false);
                break;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlSupport = new javax.swing.JPanel();
        materialButtonCircle1 = new principal.MaterialButtonCircle();
        btnBackup = new principal.MaterialButton();
        jPanel2 = new javax.swing.JPanel();
        pnlPersonas = new javax.swing.JPanel();
        btnPersonas = new principal.MaterialButton();
        jLabel2 = new javax.swing.JLabel();
        pnlProducto = new javax.swing.JPanel();
        btnVentas1 = new principal.MaterialButton();
        jLabel1 = new javax.swing.JLabel();
        pnlVentas = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnVentas = new principal.MaterialButton();
        pnlVentas1 = new javax.swing.JPanel();
        btnVista = new principal.MaterialButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú");
        setBackground(new java.awt.Color(0, 204, 0));
        setFocusTraversalPolicyProvider(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(13, 231, 169));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        materialButtonCircle1.setBackground(new java.awt.Color(64, 232, 234));
        materialButtonCircle1.setForeground(new java.awt.Color(254, 254, 254));
        materialButtonCircle1.setText("?");
        materialButtonCircle1.setBorderPainted(false);

        btnBackup.setText("Backup");
        btnBackup.setFont(new java.awt.Font("Roboto Medium", 0, 10)); // NOI18N
        btnBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSupportLayout = new javax.swing.GroupLayout(pnlSupport);
        pnlSupport.setLayout(pnlSupportLayout);
        pnlSupportLayout.setHorizontalGroup(
            pnlSupportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSupportLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBackup, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addComponent(materialButtonCircle1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlSupportLayout.setVerticalGroup(
            pnlSupportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSupportLayout.createSequentialGroup()
                .addGroup(pnlSupportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(materialButtonCircle1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBackup, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(pnlSupport, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 310, -1));

        jPanel2.setBackground(new java.awt.Color(254, 254, 254));

        pnlPersonas.setBackground(new java.awt.Color(254, 254, 254));

        btnPersonas.setBackground(new java.awt.Color(254, 254, 254));
        btnPersonas.setForeground(new java.awt.Color(60, 60, 60));
        btnPersonas.setText("Personas");
        btnPersonas.setFont(new java.awt.Font("Roboto Medium", 0, 10)); // NOI18N
        btnPersonas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPersonas.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonasActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/conexion.png"))); // NOI18N

        javax.swing.GroupLayout pnlPersonasLayout = new javax.swing.GroupLayout(pnlPersonas);
        pnlPersonas.setLayout(pnlPersonasLayout);
        pnlPersonasLayout.setHorizontalGroup(
            pnlPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPersonasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(btnPersonas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPersonasLayout.setVerticalGroup(
            pnlPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPersonasLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addGap(21, 21, 21))
            .addGroup(pnlPersonasLayout.createSequentialGroup()
                .addComponent(btnPersonas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlProducto.setBackground(new java.awt.Color(254, 254, 254));

        btnVentas1.setBackground(new java.awt.Color(254, 254, 254));
        btnVentas1.setForeground(new java.awt.Color(60, 60, 60));
        btnVentas1.setText("PRODUCTOS");
        btnVentas1.setFont(new java.awt.Font("Roboto Medium", 0, 10)); // NOI18N
        btnVentas1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnVentas1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnVentas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentas1ActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/productos.png"))); // NOI18N

        javax.swing.GroupLayout pnlProductoLayout = new javax.swing.GroupLayout(pnlProducto);
        pnlProducto.setLayout(pnlProductoLayout);
        pnlProductoLayout.setHorizontalGroup(
            pnlProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductoLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(btnVentas1, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
        );
        pnlProductoLayout.setVerticalGroup(
            pnlProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductoLayout.createSequentialGroup()
                .addGroup(pnlProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnVentas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlVentas.setBackground(new java.awt.Color(254, 254, 254));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carro.png"))); // NOI18N

        btnVentas.setBackground(new java.awt.Color(254, 254, 254));
        btnVentas.setForeground(new java.awt.Color(60, 60, 60));
        btnVentas.setText("Ventas");
        btnVentas.setFont(new java.awt.Font("Roboto Medium", 0, 10)); // NOI18N
        btnVentas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnVentas.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlVentasLayout = new javax.swing.GroupLayout(pnlVentas);
        pnlVentas.setLayout(pnlVentasLayout);
        pnlVentasLayout.setHorizontalGroup(
            pnlVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVentasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(btnVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlVentasLayout.setVerticalGroup(
            pnlVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
            .addGroup(pnlVentasLayout.createSequentialGroup()
                .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pnlVentas1.setBackground(new java.awt.Color(254, 254, 254));

        btnVista.setBackground(new java.awt.Color(254, 254, 254));
        btnVista.setForeground(new java.awt.Color(60, 60, 60));
        btnVista.setText("CARRUSEL");
        btnVista.setFont(new java.awt.Font("Roboto Medium", 0, 10)); // NOI18N
        btnVista.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnVista.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnVista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVistaActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carrusel.png"))); // NOI18N

        javax.swing.GroupLayout pnlVentas1Layout = new javax.swing.GroupLayout(pnlVentas1);
        pnlVentas1.setLayout(pnlVentas1Layout);
        pnlVentas1Layout.setHorizontalGroup(
            pnlVentas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVentas1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(btnVista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlVentas1Layout.setVerticalGroup(
            pnlVentas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnVista, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlPersonas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlProducto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlVentas1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlVentas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlVentas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 310, 440));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPersonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonasActionPerformed

        try {
            PersonaV persona = new PersonaV();
            persona.setVisible(true);
            dispose();
        } catch (Exception ex) {
            Logger.getLogger(MenuV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPersonasActionPerformed

    private void btnVentas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentas1ActionPerformed
        try {
            ProductoV producto = new ProductoV();
            producto.setVisible(true);
            dispose();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnVentas1ActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        try {
            VentaV venta = new VentaV();
            venta.setVisible(true);
            dispose();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnVentasActionPerformed

    private void btnVistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVistaActionPerformed
        try {
            CompraV carrusel = new CompraV();
            carrusel.setVisible(true);
            dispose();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnVistaActionPerformed

    private void btnBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackupActionPerformed
        try {
            servicios.BackupDb bu = new BackupDb();
            bu.backup();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnBackupActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MenuV().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(MenuV.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private principal.MaterialButton btnBackup;
    private principal.MaterialButton btnPersonas;
    private principal.MaterialButton btnVentas;
    public static principal.MaterialButton btnVentas1;
    private principal.MaterialButton btnVista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private principal.MaterialButtonCircle materialButtonCircle1;
    public static javax.swing.JPanel pnlPersonas;
    public static javax.swing.JPanel pnlProducto;
    private javax.swing.JPanel pnlSupport;
    public static javax.swing.JPanel pnlVentas;
    public static javax.swing.JPanel pnlVentas1;
    // End of variables declaration//GEN-END:variables
}
