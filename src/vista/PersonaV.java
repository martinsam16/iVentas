package vista;

import controlador.PersonaC;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import javax.swing.JOptionPane;

public class PersonaV extends javax.swing.JFrame {

    PersonaC personaC = new PersonaC();

    public PersonaV() throws Exception {
        initComponents();
//        this.setLocationRelativeTo(this);
        this.setExtendedState(MAXIMIZED_BOTH);
        pnlCredenciales.setVisible(false);
    }

    public void btnAccion() {
        if (tblPer.getSelectedRow() != -1) {
            pnlCredenciales.setVisible(true);
            inptUsr.setText("");
            inptPssw.setText("");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupTipPer = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cmbCodTel = new javax.swing.JComboBox<>();
        inptNomPer = new principal.MaterialTextField();
        inptApePer = new principal.MaterialTextField();
        inptDniPer = new principal.MaterialTextField();
        inpTlfPer = new principal.MaterialTextField();
        jPanel2 = new javax.swing.JPanel();
        btnTipPerAdministrador = new javax.swing.JRadioButton();
        btnTipPerVendedor = new javax.swing.JRadioButton();
        btnTipPerCliente = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        pnlCredenciales = new javax.swing.JPanel();
        inptUsr = new principal.MaterialTextField();
        inptPssw = new principal.MaterialTextField();
        jPanel4 = new javax.swing.JPanel();
        btnNew = new principal.MaterialButtonCircle();
        pnlBtns = new javax.swing.JPanel();
        btnEliminar = new principal.MaterialButtomRectangle();
        btnEditar = new principal.MaterialButtomRectangle();
        btnRegPer = new principal.MaterialButtomRectangle();
        pnlEdEl = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPer = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnBusTipper = new javax.swing.JComboBox<>();
        inptBuscar = new principal.MaterialTextField();
        btnReporte = new principal.MaterialButtomRectangle();
        txtCantReg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Persona");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMinimumSize(new java.awt.Dimension(427, 611));

        cmbCodTel.setEditable(true);
        cmbCodTel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "+51", "+55", "+57", "+58" }));
        cmbCodTel.setNextFocusableComponent(inpTlfPer);

        inptNomPer.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        inptNomPer.setToolTipText("");
        inptNomPer.setDoubleBuffered(true);
        inptNomPer.setLabel("Nombres");
        inptNomPer.setMinimumSize(new java.awt.Dimension(0, 9));
        inptNomPer.setNextFocusableComponent(inptApePer);

        inptApePer.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        inptApePer.setLabel("Apellidos");

        inptDniPer.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        inptDniPer.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        inptDniPer.setLabel("DNI");
        inptDniPer.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                inptDniPerCaretUpdate(evt);
            }
        });

        inpTlfPer.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        inpTlfPer.setLabel("Teléfono");
        inpTlfPer.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                inpTlfPerCaretUpdate(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnTipPerAdministrador.setBackground(new java.awt.Color(255, 255, 255));
        btnGroupTipPer.add(btnTipPerAdministrador);
        btnTipPerAdministrador.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnTipPerAdministrador.setText("Administrador");
        btnTipPerAdministrador.setNextFocusableComponent(btnTipPerVendedor);
        btnTipPerAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTipPerAdministradorActionPerformed(evt);
            }
        });

        btnTipPerVendedor.setBackground(new java.awt.Color(255, 255, 255));
        btnGroupTipPer.add(btnTipPerVendedor);
        btnTipPerVendedor.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnTipPerVendedor.setText("Vendedor");
        btnTipPerVendedor.setNextFocusableComponent(btnTipPerCliente);
        btnTipPerVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTipPerVendedorActionPerformed(evt);
            }
        });

        btnTipPerCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnGroupTipPer.add(btnTipPerCliente);
        btnTipPerCliente.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnTipPerCliente.setText("Cliente");
        btnTipPerCliente.setNextFocusableComponent(inptUsr);
        btnTipPerCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTipPerClienteActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.setMinimumSize(new java.awt.Dimension(0, 0));

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
                .addContainerGap()
                .addComponent(inptUsr, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(inptPssw, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlCredencialesLayout.setVerticalGroup(
            pnlCredencialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCredencialesLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlCredencialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inptUsr, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inptPssw, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(pnlCredenciales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCredenciales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btnTipPerAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnTipPerVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTipPerCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTipPerAdministrador)
                    .addComponent(btnTipPerVendedor)
                    .addComponent(btnTipPerCliente))
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addContainerGap())
        );

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inptNomPer, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(inptDniPer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(cmbCodTel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(inpTlfPer, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(inptApePer, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pnlBtns, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inptNomPer, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(inptApePer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(53, 53, 53)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inptDniPer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inpTlfPer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbCodTel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBtns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlEdEl.setBackground(new java.awt.Color(255, 255, 255));

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

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        btnBusTipper.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todo", "Admin", "Vendedor", "Cliente" }));
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
                .addGap(130, 130, 130)
                .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inptBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBusTipper, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)))
                .addContainerGap())
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEdElLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtCantReg, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlEdElLayout.setVerticalGroup(
            pnlEdElLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEdElLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCantReg)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(pnlEdEl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlEdEl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBusTipperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusTipperActionPerformed
        boolean temp = true;
        inptBuscar.setText("");
        if (btnBusTipper.getSelectedIndex() == 0) {
            temp = false;
        }
        tblPer.setModel(personaC.listarPersonas(btnBusTipper.getItemAt(btnBusTipper.getSelectedIndex()).charAt(0), temp));
        PersonaV.txtCantReg.setText(String.valueOf(tblPer.getRowCount()));
    }//GEN-LAST:event_btnBusTipperActionPerformed

    private void tblPerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPerMouseClicked
        personaC.llenarCampos(tblPer);
        btnRegPer.setEnabled(false);
        btnEditar.setEnabled(true);
        btnEliminar.setEnabled(true);
    }//GEN-LAST:event_tblPerMouseClicked

    private void btnTipPerVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTipPerVendedorActionPerformed
        btnAccion();
    }//GEN-LAST:event_btnTipPerVendedorActionPerformed

    private void btnTipPerAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTipPerAdministradorActionPerformed
        btnAccion();
    }//GEN-LAST:event_btnTipPerAdministradorActionPerformed

    private void btnTipPerClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTipPerClienteActionPerformed
        pnlCredenciales.setVisible(false);
    }//GEN-LAST:event_btnTipPerClienteActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        personaC.limpiar();
        btnRegPer.setEnabled(true);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        tblPer.clearSelection();
        inptNomPer.requestFocus();
    }//GEN-LAST:event_btnNewActionPerformed

    private void inptDniPerCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_inptDniPerCaretUpdate
        inptDniPer.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b') || inptDniPer.getText().length() >= 8) {
                    e.consume();
                }
            }
        });
    }//GEN-LAST:event_inptDniPerCaretUpdate

    private void inpTlfPerCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_inpTlfPerCaretUpdate
        inpTlfPer.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b') || inpTlfPer.getText().length() >= 9) {
                    e.consume();
                }
            }
        });
    }//GEN-LAST:event_inpTlfPerCaretUpdate

    private void inptPsswCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_inptPsswCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_inptPsswCaretUpdate

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            tblPer.clearSelection();
            if (personaC.validar()) {
                personaC.variablesM();
                personaC.accionPersona("EL");
                personaC.limpiar();
                btnBusTipper.setSelectedIndex(btnBusTipper.getSelectedIndex());
            }
        } catch (Exception e) {
            System.out.println("Error btnEliminar");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            tblPer.clearSelection();
            if (personaC.validar()) {
                personaC.variablesM();
                personaC.accionPersona("ED");
                if (pnlCredenciales.isVisible()) {
                    if (personaC.validarLogin()) {
                        personaC.variablesMl();
                        personaC.editartLogin();
                        personaC.accionPersona("ED");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se actualizarón las credenciales porque los campos estaban vacios.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                personaC.limpiar();
                btnBusTipper.setSelectedIndex(btnBusTipper.getSelectedIndex());
            }
        } catch (HeadlessException e) {
            System.out.println("Error btnEditar" +e.getMessage());
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRegPerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegPerActionPerformed
        try {
            if (personaC.validar()) {
                personaC.variablesM();
                personaC.accionPersona("RE");
                personaC.limpiar();
                btnBusTipper.setSelectedIndex(btnBusTipper.getSelectedIndex());
            }
        } catch (Exception e) {
            System.out.println("Error btnRegPErV");
        }
    }//GEN-LAST:event_btnRegPerActionPerformed

    private void inptBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inptBuscarKeyReleased
        inptBuscar.setText(inptBuscar.getText().trim());
        personaC.buscar(inptBuscar.getText(), tblPer);
        PersonaV.txtCantReg.setText(String.valueOf(tblPer.getRowCount()));
    }//GEN-LAST:event_inptBuscarKeyReleased

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        try {
//            servicios.report r = new report();
//            r.toPdf(tblPer,JOptionPane.showInputDialog("Ingrese el nombre con el que desea guardarlo"));
            tblPer.print();//Solucion más eficiente
        } catch (PrinterException e) {
            System.out.println(e.getMessage() + e.getMessage());
        }
    }//GEN-LAST:event_btnReporteActionPerformed

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
                    new PersonaV().setVisible(true);
                } catch (Exception e) {
                    System.out.println(e.getMessage() + e.getCause());
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> btnBusTipper;
    private principal.MaterialButtomRectangle btnEditar;
    private principal.MaterialButtomRectangle btnEliminar;
    public static javax.swing.ButtonGroup btnGroupTipPer;
    public static principal.MaterialButtonCircle btnNew;
    private principal.MaterialButtomRectangle btnRegPer;
    private principal.MaterialButtomRectangle btnReporte;
    public static javax.swing.JRadioButton btnTipPerAdministrador;
    public static javax.swing.JRadioButton btnTipPerCliente;
    public static javax.swing.JRadioButton btnTipPerVendedor;
    public static javax.swing.JComboBox<String> cmbCodTel;
    public static principal.MaterialTextField inpTlfPer;
    public static principal.MaterialTextField inptApePer;
    private principal.MaterialTextField inptBuscar;
    public static principal.MaterialTextField inptDniPer;
    public static principal.MaterialTextField inptNomPer;
    public static principal.MaterialTextField inptPssw;
    public static principal.MaterialTextField inptUsr;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlBtns;
    public static javax.swing.JPanel pnlCredenciales;
    private javax.swing.JPanel pnlEdEl;
    public static javax.swing.JTable tblPer;
    public static javax.swing.JLabel txtCantReg;
    // End of variables declaration//GEN-END:variables
}
