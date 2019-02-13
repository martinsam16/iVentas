package vista;

import controlador.CompraC;

public class CompraV extends javax.swing.JFrame {

    public CompraV() {
        initComponents();
        setLocationRelativeTo(null);
        pnlDetalleProducto.setVisible(false);
    }
    CompraC controlador = new CompraC();
    boolean mostrar = false;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlProducto = new javax.swing.JPanel();
        lblPrecioProducto = new principal.MaterialButtomRectangle();
        lblNombreProducto = new javax.swing.JLabel();
        lblImagenProducto = new javax.swing.JLabel();
        materialButtonCircle1 = new principal.MaterialButtonCircle();
        materialButtonCircle2 = new principal.MaterialButtonCircle();
        jButton1 = new javax.swing.JButton();
        btnMostrarPnlDetVenta = new javax.swing.JToggleButton();
        pnlDetalleProducto = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetTecnico = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("aComprar!");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        pnlProducto.setBackground(new java.awt.Color(254, 254, 254));
        pnlProducto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPrecioProducto.setBackground(new java.awt.Color(10, 250, 121));
        lblPrecioProducto.setForeground(new java.awt.Color(254, 254, 254));
        lblPrecioProducto.setText("Precio");
        lblPrecioProducto.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        pnlProducto.add(lblPrecioProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 170, 50));

        lblNombreProducto.setBackground(new java.awt.Color(46, 46, 46));
        lblNombreProducto.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblNombreProducto.setForeground(new java.awt.Color(254, 254, 254));
        lblNombreProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreProducto.setText("Nombre");
        lblNombreProducto.setOpaque(true);
        pnlProducto.add(lblNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 390, 46));

        lblImagenProducto.setBackground(new java.awt.Color(254, 254, 254));
        lblImagenProducto.setBorder(null);
        lblImagenProducto.setOpaque(true);
        pnlProducto.add(lblImagenProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 390, 280));

        materialButtonCircle1.setBackground(new java.awt.Color(21, 236, 223));
        materialButtonCircle1.setForeground(new java.awt.Color(254, 254, 254));
        materialButtonCircle1.setText(">");
        materialButtonCircle1.setFont(new java.awt.Font("Roboto Medium", 1, 17)); // NOI18N
        materialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialButtonCircle1ActionPerformed(evt);
            }
        });
        pnlProducto.add(materialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 150, 77, 77));

        materialButtonCircle2.setBackground(new java.awt.Color(21, 236, 223));
        materialButtonCircle2.setForeground(new java.awt.Color(254, 254, 254));
        materialButtonCircle2.setText("<");
        materialButtonCircle2.setFont(new java.awt.Font("Roboto Medium", 1, 17)); // NOI18N
        materialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialButtonCircle2ActionPerformed(evt);
            }
        });
        pnlProducto.add(materialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 77, 77));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/addToCar.png"))); // NOI18N
        jButton1.setEnabled(false);
        pnlProducto.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 54, 46));

        btnMostrarPnlDetVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/technical.png"))); // NOI18N
        btnMostrarPnlDetVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarPnlDetVentaActionPerformed(evt);
            }
        });
        pnlProducto.add(btnMostrarPnlDetVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, 61, 46));

        pnlDetalleProducto.setBackground(new java.awt.Color(254, 254, 254));

        tblDetTecnico.setBackground(new java.awt.Color(254, 254, 254));
        tblDetTecnico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDetTecnico.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblDetTecnico.setGridColor(new java.awt.Color(254, 254, 254));
        tblDetTecnico.setRowHeight(150);
        tblDetTecnico.getTableHeader().setResizingAllowed(false);
        tblDetTecnico.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblDetTecnico);

        javax.swing.GroupLayout pnlDetalleProductoLayout = new javax.swing.GroupLayout(pnlDetalleProducto);
        pnlDetalleProducto.setLayout(pnlDetalleProductoLayout);
        pnlDetalleProductoLayout.setHorizontalGroup(
            pnlDetalleProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        pnlDetalleProductoLayout.setVerticalGroup(
            pnlDetalleProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
                    .addComponent(pnlDetalleProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDetalleProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostrarPnlDetVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarPnlDetVentaActionPerformed
        mostrar = !mostrar;
        pnlDetalleProducto.setVisible(mostrar);
    }//GEN-LAST:event_btnMostrarPnlDetVentaActionPerformed

    private void materialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialButtonCircle2ActionPerformed
        this.controlador.accionBtns('I');
        repaint();
    }//GEN-LAST:event_materialButtonCircle2ActionPerformed

    private void materialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialButtonCircle1ActionPerformed
       this.controlador.accionBtns('D');
       repaint();
    }//GEN-LAST:event_materialButtonCircle1ActionPerformed

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
            java.util.logging.Logger.getLogger(CompraV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompraV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompraV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompraV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompraV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnMostrarPnlDetVenta;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblImagenProducto;
    public static javax.swing.JLabel lblNombreProducto;
    public static principal.MaterialButtomRectangle lblPrecioProducto;
    private principal.MaterialButtonCircle materialButtonCircle1;
    private principal.MaterialButtonCircle materialButtonCircle2;
    private javax.swing.JPanel pnlDetalleProducto;
    private javax.swing.JPanel pnlProducto;
    public static javax.swing.JTable tblDetTecnico;
    // End of variables declaration//GEN-END:variables
}
