package controlador;

import dao.PersonaD;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.PersonaM;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import servicios.CombosAnidados;
import servicios.ConsultaGob;
import servicios.TablasS;
import vista.PersonaV;
import static vista.PersonaV.btnBusTipper;
import static vista.PersonaV.btnTipoDeDocumentoDni;
import static vista.PersonaV.btnTipoDeDocumentoRuc;
import static vista.PersonaV.inptDocPer;
import static vista.PersonaV.pnlCredenciales;
import static vista.PersonaV.tblPer;
/**
 * Une el modelo de la Persona con su dao
 * @author Martín Alexis Samán Arata
 */
public class PersonaC {

    PersonaM persona = new PersonaM();
    PersonaD dao = new PersonaD();

    public void accionPersona(char tipoDeAccion) {
        try {
            dao.accionPersona(persona, tipoDeAccion);
        } catch (Exception e) {
            System.out.println("Error RegPer() C" + e.getMessage());
        }
    }

    public void editartLogin() {
        try {
            dao.accionPersona(persona, '2');
        } catch (Exception e) {
            System.out.println("Error EditLog()");
            System.out.println(e.getMessage());
        }
    }

    public DefaultTableModel listarPersonas(char tipper, boolean estado) {
        try {
            return dao.listarPersonas(tipper, estado);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean validar() {
        boolean est = false;
        if (!"".equals(PersonaV.inptNomPer.getText()) && (PersonaV.inptDocPer.getText().length() == 8 || PersonaV.inptDocPer.getText().length() == 11) && !"".equals(PersonaV.inptDirPer.getText())) {
            est = true;
        }
        return est;
    }

    public boolean validarLogin() {
        boolean est = false;
        if (!"".equals(PersonaV.inptUsr.getText()) && !"".equals(PersonaV.inptPssw.getText())) {
            est = true;
        }
        return est;
    }

    public void registrarPersona() {
        try {
            if (validar()) {
                variablesM();
                accionPersona('1');
                limpiar();
                btnBusTipper.setSelectedIndex(btnBusTipper.getSelectedIndex());
                persona.clear();
            }
        } catch (Exception e) {
            System.out.println("Error btnRegPErV");
        }
    }

    public void botonBuscarTipper() {
        boolean temp = true;
        PersonaV.inptBuscar.setText("");
        if (btnBusTipper.getSelectedIndex() == 0) {
            temp = false;
        }
        tblPer.setModel(listarPersonas(btnBusTipper.getItemAt(btnBusTipper.getSelectedIndex()).charAt(0), temp));
        PersonaV.txtCantReg.setText(String.valueOf(tblPer.getRowCount()));
    }

    public void editarPersona() {
        try {
            tblPer.clearSelection();
            if (validar()) {
                variablesM();
                if (pnlCredenciales.isVisible()) {
                    if (!validarLogin()) {
                        return;
                    }
                } else {
                    persona.setUsrper(persona.getDocper());
                    persona.setPswper("@" + persona.getDocper());
                }
                accionPersona('2');
                limpiar();
                btnBusTipper.setSelectedIndex(btnBusTipper.getSelectedIndex());
                persona.clear();
            }
        } catch (HeadlessException e) {
            System.out.println("Error Editar" + e.getMessage());
        }
    }

    public void eliminarPersona() {
        try {
            tblPer.clearSelection();
            if (!"".equals(inptDocPer.getText())) {
                variablesM();
                accionPersona('3');
                limpiar();
                btnBusTipper.setSelectedIndex(btnBusTipper.getSelectedIndex());
                persona.clear();
            }
        } catch (Exception e) {
            System.out.println("Error btnEliminar");
        }
    }

    public void variablesM() {
        persona.setNomper(PersonaV.inptNomPer.getText().toUpperCase());
        persona.setApeper(PersonaV.inptApePer.getText().toUpperCase());
        persona.setDocper(PersonaV.inptDocPer.getText());
        persona.setTelfper(PersonaV.cmbCodTel.getItemAt(PersonaV.cmbCodTel.getSelectedIndex()) + PersonaV.inpTlfPer.getText());
        String tipo = String.valueOf(PersonaV.comboTipoDePersona.getSelectedItem().toString().charAt(0));
        persona.setTipper(tipo);
        persona.setNomdis(PersonaV.comboDistrito.getSelectedItem().toString());
        persona.setDir(PersonaV.inptDirPer.getText().toUpperCase());
        persona.setUsrper(PersonaV.inptUsr.getText());
        persona.setPswper(PersonaV.inptPssw.getText());
    }

    public void llenarCampos(JTable tbl) {
        int fila = tbl.getSelectedRow();
        if (fila != -1) {
            //CÓDIGO,NOMBRES,APELLIDOS,DNI,TELÉFONO,DEPARTAMENTO,PROVINCIA,DISTRITO,DIRECCION,TIPO
            //USUARIO, CONTRA
            if (String.valueOf(tbl.getValueAt(fila, 3)).length() == 8) {
                btnTipoDeDocumentoDni.setSelected(true);
                PersonaV.inptApePer.setVisible(true);
            } else if (String.valueOf(tbl.getValueAt(fila, 3)).length() == 11) {
                btnTipoDeDocumentoRuc.setSelected(true);
                PersonaV.inptApePer.setVisible(false);
            }
            PersonaV.inptNomPer.setText(String.valueOf(tbl.getValueAt(fila, 1)));
            PersonaV.inptApePer.setText(String.valueOf(tbl.getValueAt(fila, 2)));
            PersonaV.inptDocPer.setText(String.valueOf(tbl.getValueAt(fila, 3)));

            PersonaV.cmbCodTel.setSelectedItem(String.valueOf(tbl.getValueAt(fila, 4)).substring(0, 3));
            PersonaV.inpTlfPer.setText(String.valueOf(tbl.getValueAt(fila, 4)).substring(3));

            PersonaV.cmbDepartamento.setSelectedItem(String.valueOf(tbl.getValueAt(fila, 5)));
            PersonaV.comboProvincia.setSelectedItem(String.valueOf(tbl.getValueAt(fila, 6)));
            PersonaV.comboDistrito.setSelectedItem(String.valueOf(tbl.getValueAt(fila, 7)));
            PersonaV.inptDirPer.setText(String.valueOf(tbl.getValueAt(fila, 8)));

            String tipoDePersona = String.valueOf(tbl.getValueAt(fila, 9));
            if (null != tipoDePersona) {
                switch (tipoDePersona) {
                    case "A":
                    case "C":
                    case "E":
                        PersonaV.pnlCredenciales.setVisible(false);
                        break;
                    case "V":
                    case "I":
                        if (PersonaV.btnBusTipper.getSelectedIndex() == 2 || PersonaV.btnBusTipper.getSelectedIndex() == 4) {
                            PersonaV.pnlCredenciales.setVisible(true);
                            PersonaV.inptUsr.setText(String.valueOf(tbl.getValueAt(fila, 10)));
                            PersonaV.inptPssw.setText(String.valueOf(tbl.getValueAt(fila, 11)));
                        }
                        break;
                }
            }
            switch (tipoDePersona) {
                case "A":
                    tipoDePersona = "Administrador";
                    break;
                case "C":
                    tipoDePersona = "Cliente";
                    break;
                case "I":
                    tipoDePersona = "Inventariador";
                    break;
                case "V":
                    tipoDePersona = "Vendedor";
                    break;
                case "E":
                    tipoDePersona = "Empresa";
                    break;
            }
            PersonaV.comboTipoDePersona.setSelectedItem(tipoDePersona);
        }
    }

    public void autorrellenarCamposPorTipoDeDocumento() throws ParseException {

        try {
            if (!ConsultaGob.existeDocumento(PersonaV.inptDocPer.getText())) {
                JSONObject datos = null;
                if (PersonaV.inptDocPer.getText().length() == 8) {
                    datos = ConsultaGob.getDatosDni(PersonaV.inptDocPer.getText());
                    PersonaV.inptApePer.setText(datos.get("apellido_paterno").toString() + " " + datos.get("apellido_materno").toString());
                    PersonaV.inptNomPer.setText(datos.get("nombres").toString());
                } else if (PersonaV.inptDocPer.getText().length() == 11) {
                    datos = ConsultaGob.getDatosRuc(PersonaV.inptDocPer.getText());
                    PersonaV.inptNomPer.setText(datos.get("razon_social").toString());
                    String[] ubigeo = ConsultaGob.separarDomicilio(datos.get("domicilio_fiscal").toString());
                    PersonaV.cmbDepartamento.setSelectedItem(ubigeo[0]);
                    PersonaV.comboProvincia.setSelectedItem(ubigeo[1]);
                    PersonaV.comboDistrito.setSelectedItem(ubigeo[2]);
                    PersonaV.inptDirPer.setText(ubigeo[3]);

                }

            } else {
                JOptionPane.showMessageDialog(null, "El documento ingresado ya existe en la Base de Datos");
            }

        } catch (Exception e) {
            System.out.println("Error autorrellenarCamposPorTipoDeDocumento " + e.getMessage());
        }

    }

    public DefaultComboBoxModel llenarComboUbigeo(char tipo, String nombre) {
        try {
            servicios.CombosAnidados combo = new CombosAnidados();
            return combo.listarCombo(tipo, nombre);
        } catch (Exception e) {
            return null;
        }
    }

    public void buscar(String consulta, JTable tbl) {
        TablasS.buscar(consulta, tbl, '0');
    }

    public void inputSoloDigitos(JTextField input, int cantidadDeDigitos) {
        input.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b') || input.getText().length() >= cantidadDeDigitos) {
                    e.consume();
                }
            }
        });
    }

    public void limpiar() {
        PersonaV.inptNomPer.setText("");
        PersonaV.inptApePer.setText("");
        PersonaV.inptDocPer.setText("");
        PersonaV.inpTlfPer.setText("");
        PersonaV.inptDirPer.setText("");

        PersonaV.inptUsr.setText("");
        PersonaV.inptPssw.setText("");
        PersonaV.pnlCredenciales.setVisible(false);
    }

}
