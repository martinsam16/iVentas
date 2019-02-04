package vista;

import controlador.PersonaC;
import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;

public class PersonaV extends javax.swing.JFrame {

    PersonaC personaC = new PersonaC();

    public PersonaV() throws Exception {
        initComponents();
//        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        pnlCredenciales.setVisible(false);
    }
    
    private void actualizarInputDocumento(){        
        inptDocPer.setEnabled(true);
        personaC.limpiar();
        repaint();
        inptDocPer.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupTipDoc = new javax.swing.ButtonGroup();
        pnlEdEl = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnBusTipper = new javax.swing.JComboBox<String>();
        inptBuscar = new principal.MaterialTextField();
        btnReporte = new principal.MaterialButtomRectangle();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPer = new javax.swing.JTable();
        txtCantReg = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        inptNomPer = new principal.MaterialTextField();
        inptApePer = new principal.MaterialTextField();
        pnlCredenciales = new javax.swing.JPanel();
        inptUsr = new principal.MaterialTextField();
        inptPssw = new principal.MaterialTextField();
        inpTlfPer = new principal.MaterialTextField();
        cmbCodTel = new javax.swing.JComboBox<String>();
        inptDocPer = new principal.MaterialTextField();
        btnConsultar = new principal.MaterialButton();
        comboTipoDePersona = new javax.swing.JComboBox();
        cmbDepartamento = new javax.swing.JComboBox();
        comboProvincia = new javax.swing.JComboBox();
        comboDistrito = new javax.swing.JComboBox();
        inptDirPer = new principal.MaterialTextField();
        pnlBtns = new javax.swing.JPanel();
        btnEliminar = new principal.MaterialButtomRectangle();
        btnEditar = new principal.MaterialButtomRectangle();
        btnRegPer = new principal.MaterialButtomRectangle();
        jPanel8 = new javax.swing.JPanel();
        btnHome = new principal.MaterialButton();
        jPanel4 = new javax.swing.JPanel();
        btnNew = new principal.MaterialButtonCircle();
        jPanel1 = new javax.swing.JPanel();
        btnTipoDeDocumentoDni = new javax.swing.JRadioButton();
        btnTipoDeDocumentoRuc = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Persona");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        pnlEdEl.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        btnBusTipper.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todo", "Admin", "Inventariador", "Empresa", "Vendedor", "Cliente" }));
        btnBusTipper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusTipperActionPerformed(evt);
            }
        });

        inptBuscar.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        inptBuscar.setLabel("Buscar");
        inptBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inptBuscarKeyReleased(evt);
            }
        });

        btnReporte.setText("Reporte");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(inptBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBusTipper, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inptBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBusTipper)
                    .addComponent(btnReporte, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(254, 254, 254));

        tblPer.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        tblPer.setModel(this.personaC.listarPersonas('n', false)
        );
        tblPer.setGridColor(new java.awt.Color(204, 204, 204));
        tblPer.setOpaque(false);
        tblPer.getTableHeader().setReorderingAllowed(false);
        tblPer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPer);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtCantReg.setFont(new java.awt.Font("NewsGoth Lt BT", 1, 14)); // NOI18N
        txtCantReg.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtCantReg.setText(String.valueOf(tblPer.getRowCount()));

        javax.swing.GroupLayout pnlEdElLayout = new javax.swing.GroupLayout(pnlEdEl);
        pnlEdEl.setLayout(pnlEdElLayout);
        pnlEdElLayout.setHorizontalGroup(
            pnlEdElLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEdElLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEdElLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEdElLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtCantReg, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        pnlEdElLayout.setVerticalGroup(
            pnlEdElLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEdElLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCantReg)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(254, 254, 254));

        inptNomPer.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        inptNomPer.setToolTipText("");
        inptNomPer.setDoubleBuffered(true);
        inptNomPer.setLabel("Nombres");
        inptNomPer.setMinimumSize(new java.awt.Dimension(0, 9));
        inptNomPer.setNextFocusableComponent(inptApePer);

        inptApePer.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        inptApePer.setLabel("Apellidos");

        pnlCredenciales.setBackground(new java.awt.Color(255, 255, 255));
        pnlCredenciales.setMaximumSize(new java.awt.Dimension(315, 89));

        inptUsr.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        inptUsr.setFont(new java.awt.Font("Roboto Regular", 0, 14)); // NOI18N
        inptUsr.setLabel("User");
        inptUsr.setNextFocusableComponent(inptPssw);
        inptUsr.setSelectionColor(new java.awt.Color(255, 204, 102));

        inptPssw.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        inptPssw.setFont(new java.awt.Font("Roboto Regular", 0, 14)); // NOI18N
        inptPssw.setLabel("Password");
        inptPssw.setSelectionColor(new java.awt.Color(255, 204, 102));
        inptPssw.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                inptPsswCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout pnlCredencialesLayout = new javax.swing.GroupLayout(pnlCredenciales);
        pnlCredenciales.setLayout(pnlCredencialesLayout);
        pnlCredencialesLayout.setHorizontalGroup(
            pnlCredencialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCredencialesLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(inptUsr, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(inptPssw, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        pnlCredencialesLayout.setVerticalGroup(
            pnlCredencialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCredencialesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCredencialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inptUsr, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inptPssw, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        inpTlfPer.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        inpTlfPer.setLabel("Teléfono");
        inpTlfPer.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                inpTlfPerCaretUpdate(evt);
            }
        });

        cmbCodTel.setEditable(true);
        cmbCodTel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "+51", "+55", "+57", "+58" }));
        cmbCodTel.setNextFocusableComponent(inpTlfPer);

        inptDocPer.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        inptDocPer.setToolTipText("");
        inptDocPer.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        inptDocPer.setEnabled(false);
        inptDocPer.setLabel("Documento");
        inptDocPer.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                inptDocPerCaretUpdate(evt);
            }
        });

        btnConsultar.setBackground(new java.awt.Color(29, 232, 184));
        btnConsultar.setForeground(new java.awt.Color(254, 254, 254));
        btnConsultar.setText("*");
        btnConsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnConsultar.setDoubleBuffered(true);
        btnConsultar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConsultar.setType(principal.MaterialButton.Type.FLAT);
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        comboTipoDePersona.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Inventariador", "Vendedor", "Empresa", "Cliente" }));
        comboTipoDePersona.setToolTipText("Tipo de Persona");
        comboTipoDePersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoDePersonaActionPerformed(evt);
            }
        });

        cmbDepartamento.setModel(this.personaC.llenarComboUbigeo('4', null)
        );
        cmbDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDepartamentoActionPerformed(evt);
            }
        });

        comboProvincia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        comboProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProvinciaActionPerformed(evt);
            }
        });

        comboDistrito.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        comboDistrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDistritoActionPerformed(evt);
            }
        });

        inptDirPer.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        inptDirPer.setToolTipText("");
        inptDirPer.setDoubleBuffered(true);
        inptDirPer.setLabel("Direccion");
        inptDirPer.setMinimumSize(new java.awt.Dimension(0, 9));
        inptDirPer.setNextFocusableComponent(inptApePer);

        pnlBtns.setBackground(new java.awt.Color(255, 255, 255));

        btnEliminar.setBackground(new java.awt.Color(255, 51, 51));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(255, 255, 51));
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnRegPer.setBackground(new java.awt.Color(0, 255, 51));
        btnRegPer.setForeground(new java.awt.Color(255, 255, 255));
        btnRegPer.setText("Registrar");
        btnRegPer.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnRegPer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegPerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBtnsLayout = new javax.swing.GroupLayout(pnlBtns);
        pnlBtns.setLayout(pnlBtnsLayout);
        pnlBtnsLayout.setHorizontalGroup(
            pnlBtnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBtnsLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegPer, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        pnlBtnsLayout.setVerticalGroup(
            pnlBtnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBtnsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBtnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRegPer, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel8.setBackground(new java.awt.Color(254, 254, 254));

        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        btnNew.setBackground(new java.awt.Color(255, 153, 0));
        btnNew.setForeground(new java.awt.Color(255, 255, 255));
        btnNew.setText("+");
        btnNew.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        btnTipoDeDocumentoDni.setBackground(new java.awt.Color(254, 254, 254));
        btnGroupTipDoc.add(btnTipoDeDocumentoDni);
        btnTipoDeDocumentoDni.setText("DNI");
        btnTipoDeDocumentoDni.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTipoDeDocumentoDni.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnTipoDeDocumentoDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTipoDeDocumentoDniActionPerformed(evt);
            }
        });

        btnTipoDeDocumentoRuc.setBackground(new java.awt.Color(254, 254, 254));
        btnGroupTipDoc.add(btnTipoDeDocumentoRuc);
        btnTipoDeDocumentoRuc.setText("RUC");
        btnTipoDeDocumentoRuc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTipoDeDocumentoRuc.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnTipoDeDocumentoRuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTipoDeDocumentoRucActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnTipoDeDocumentoDni, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTipoDeDocumentoRuc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnTipoDeDocumentoDni)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(btnTipoDeDocumentoRuc))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(inptNomPer, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inptApePer, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(inptDocPer, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboTipoDePersona, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(pnlBtns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(cmbCodTel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inpTlfPer, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(inptDirPer, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(cmbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(comboProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(comboDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(pnlCredenciales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inptNomPer, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inptApePer, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inpTlfPer, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCodTel))
                .addGap(15, 15, 15)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(inptDocPer, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboTipoDePersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addComponent(pnlBtns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbDepartamento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(comboProvincia, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                                .addComponent(comboDistrito)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(inptDirPer, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlCredenciales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlEdEl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlEdEl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBusTipperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusTipperActionPerformed
        personaC.botonBuscarTipper();
    }//GEN-LAST:event_btnBusTipperActionPerformed

    private void tblPerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPerMouseClicked
        personaC.llenarCampos(tblPer);
        btnRegPer.setEnabled(false);
        btnEditar.setEnabled(true);
        btnEliminar.setEnabled(true);
    }//GEN-LAST:event_tblPerMouseClicked

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        personaC.limpiar();
        btnRegPer.setEnabled(true);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        tblPer.clearSelection();
        inptDocPer.requestFocus();
    }//GEN-LAST:event_btnNewActionPerformed

    private void inptDocPerCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_inptDocPerCaretUpdate
        if (btnTipoDeDocumentoDni.isSelected()) {
            personaC.inputSoloDigitos(inptDocPer, 8);
        } else if (btnTipoDeDocumentoRuc.isSelected()) {
            personaC.inputSoloDigitos(inptDocPer, 11);
        }
        this.repaint();
    }//GEN-LAST:event_inptDocPerCaretUpdate

    private void inpTlfPerCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_inpTlfPerCaretUpdate
        personaC.inputSoloDigitos(inpTlfPer, 9);
    }//GEN-LAST:event_inpTlfPerCaretUpdate

    private void inptPsswCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_inptPsswCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_inptPsswCaretUpdate

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        personaC.eliminarPersona();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        personaC.editarPersona();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRegPerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegPerActionPerformed
        personaC.registrarPersona();
    }//GEN-LAST:event_btnRegPerActionPerformed

    private void inptBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inptBuscarKeyReleased
        inptBuscar.setText(inptBuscar.getText().trim());
        personaC.buscar(inptBuscar.getText(), tblPer);
        PersonaV.txtCantReg.setText(String.valueOf(tblPer.getRowCount()));
    }//GEN-LAST:event_inptBuscarKeyReleased

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        try {
            tblPer.print();//Solucion más eficiente
        } catch (PrinterException e) {
            System.out.println(e.getMessage() + e.getMessage());
        }
    }//GEN-LAST:event_btnReporteActionPerformed

    private void cmbDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDepartamentoActionPerformed
        comboProvincia.setModel(this.personaC.llenarComboUbigeo('5', cmbDepartamento.getSelectedItem().toString()));
        comboProvincia.setSelectedIndex(0);
    }//GEN-LAST:event_cmbDepartamentoActionPerformed

    private void comboProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProvinciaActionPerformed
        comboDistrito.setModel(this.personaC.llenarComboUbigeo('6', comboProvincia.getSelectedItem().toString()));
    }//GEN-LAST:event_comboProvinciaActionPerformed

    private void comboTipoDePersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoDePersonaActionPerformed

    }//GEN-LAST:event_comboTipoDePersonaActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        MenuV home = new MenuV();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void comboDistritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDistritoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboDistritoActionPerformed

    private void btnTipoDeDocumentoDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTipoDeDocumentoDniActionPerformed
       inptApePer.setVisible(true);
        actualizarInputDocumento();
    }//GEN-LAST:event_btnTipoDeDocumentoDniActionPerformed

    private void btnTipoDeDocumentoRucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTipoDeDocumentoRucActionPerformed
        inptApePer.setVisible(false);
        actualizarInputDocumento();
    }//GEN-LAST:event_btnTipoDeDocumentoRucActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
       try {
            if (btnTipoDeDocumentoDni.isSelected() || btnTipoDeDocumentoRuc.isSelected()) { 
                //Hacer ping antes xd -- 
                personaC.autorrellenarCamposPorTipoDeDocumento();                
            }
        } catch (ParseException ex) {
            Logger.getLogger(PersonaV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

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
            java.util.logging.Logger.getLogger(PersonaV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PersonaV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PersonaV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PersonaV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    inptDocPer.setRequestFocusEnabled(true);
                    new PersonaV().setVisible(true);
                } catch (Exception e) {
                    System.out.println(e.getMessage() + e.getCause());
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> btnBusTipper;
    private principal.MaterialButton btnConsultar;
    private principal.MaterialButtomRectangle btnEditar;
    private principal.MaterialButtomRectangle btnEliminar;
    public static javax.swing.ButtonGroup btnGroupTipDoc;
    private principal.MaterialButton btnHome;
    public static principal.MaterialButtonCircle btnNew;
    private principal.MaterialButtomRectangle btnRegPer;
    private principal.MaterialButtomRectangle btnReporte;
    public static javax.swing.JRadioButton btnTipoDeDocumentoDni;
    public static javax.swing.JRadioButton btnTipoDeDocumentoRuc;
    public static javax.swing.JComboBox<String> cmbCodTel;
    public static javax.swing.JComboBox cmbDepartamento;
    public static javax.swing.JComboBox comboDistrito;
    public static javax.swing.JComboBox comboProvincia;
    public static javax.swing.JComboBox comboTipoDePersona;
    public static principal.MaterialTextField inpTlfPer;
    public static principal.MaterialTextField inptApePer;
    public static principal.MaterialTextField inptBuscar;
    public static principal.MaterialTextField inptDirPer;
    public static principal.MaterialTextField inptDocPer;
    public static principal.MaterialTextField inptNomPer;
    public static principal.MaterialTextField inptPssw;
    public static principal.MaterialTextField inptUsr;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlBtns;
    public static javax.swing.JPanel pnlCredenciales;
    private javax.swing.JPanel pnlEdEl;
    public static javax.swing.JTable tblPer;
    public static javax.swing.JLabel txtCantReg;
    // End of variables declaration//GEN-END:variables
}
