package controlador;

import dao.LoginD;
import dao.PersonaD;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.LoginM;
import modelo.PersonaM;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import servicios.ConsultaGob;
import servicios.TablasS;
import vista.PersonaV;

public class PersonaC {

    PersonaM persona = new PersonaM();
    LoginM login = new LoginM();
    PersonaD dao = new PersonaD();
    LoginD daoL = new LoginD();

    public void accionPersona(String tipoDeAccion) {
        try {
            dao.accionPersona(persona, tipoDeAccion);
        } catch (Exception e) {
            System.out.println("Error RegPer() C" + e.getMessage());
        }
    }

    public void editartLogin() {
        try {
            daoL.editarLogin(login, persona.getDniper());
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
        if (!"".equals(PersonaV.inptNomPer.getText()) && !"".equals(PersonaV.inptApePer.getText()) && PersonaV.inptDniPer.getText().length() == 8) {
            if (PersonaV.btnTipPerAdministrador.isSelected() || PersonaV.btnTipPerCliente.isSelected() || PersonaV.btnTipPerVendedor.isSelected()) {
                est = true;
            }
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

    public void variablesM() {
        persona.setNomper(PersonaV.inptNomPer.getText().toUpperCase());
        persona.setApeper(PersonaV.inptApePer.getText().toUpperCase());
        persona.setDniper(PersonaV.inptDniPer.getText());
        persona.setTelfper(PersonaV.cmbCodTel.getItemAt(PersonaV.cmbCodTel.getSelectedIndex()) + PersonaV.inpTlfPer.getText());
        String tipo = "N";
        if (PersonaV.btnTipPerVendedor.isSelected()) {
            tipo = "V";
        } else if (PersonaV.btnTipPerAdministrador.isSelected()) {
            tipo = "A";
        } else if (PersonaV.btnTipPerCliente.isSelected()) {
            tipo = "C";
        }
        persona.setTipper(tipo);
//        System.out.println(persona.toString());
    }

    public void variablesMl() {
        login.setUsrper(PersonaV.inptUsr.getText());
        login.setPswper(PersonaV.inptPssw.getText());
    }

    public void llenarCampos(JTable tbl) {
        int fila = tbl.getSelectedRow();
        if (fila != -1) {
            //"CODIGO","NOMBRES", "APELLIDOS", "DNI", "TELEFONO","TIPO"
            PersonaV.inptNomPer.setText(String.valueOf(tbl.getValueAt(fila, 1)));
            PersonaV.inptApePer.setText(String.valueOf(tbl.getValueAt(fila, 2)));
            PersonaV.inptDniPer.setText(String.valueOf(tbl.getValueAt(fila, 3)));
            PersonaV.cmbCodTel.setSelectedItem(String.valueOf(tbl.getValueAt(fila, 4)).substring(0, 3));
            PersonaV.inpTlfPer.setText(String.valueOf(tbl.getValueAt(fila, 4)).substring(3));
            switch (String.valueOf(tbl.getValueAt(fila, 5))) {
                case "A":
                    PersonaV.pnlCredenciales.setVisible(false);
                    PersonaV.btnTipPerAdministrador.setSelected(true);
                    break;
                case "V":
                    if (PersonaV.btnBusTipper.getSelectedIndex() == 2) {
                        PersonaV.pnlCredenciales.setVisible(true);
                        PersonaV.inptUsr.setText(String.valueOf(tbl.getValueAt(fila, 6)));
                        PersonaV.inptPssw.setText(String.valueOf(tbl.getValueAt(fila, 7)));
                    }
                    PersonaV.btnTipPerVendedor.setSelected(true);
                    break;
                case "C":
                    PersonaV.pnlCredenciales.setVisible(false);
                    PersonaV.btnTipPerCliente.setSelected(true);
                    break;
                default:
                    break;
            }
        }
    }

    public void autorrellenarCamposPorDni() throws ParseException {
        if (PersonaV.inptDniPer.getText().length() == 8) {
            JSONObject datos = ConsultaGob.getDatosDni(PersonaV.inptDniPer.getText());
            PersonaV.inptApePer.setText(datos.get("apellido_paterno").toString() + " " + datos.get("apellido_materno").toString());
            PersonaV.inptNomPer.setText(datos.get("nombres").toString());
        }

    }

    public void buscar(String consulta, JTable tbl) {
        TablasS.buscar(consulta, tbl);
    }

    public void limpiar() {
        PersonaV.inptNomPer.setText("");
        PersonaV.inptApePer.setText("");
        PersonaV.inptDniPer.setText("");
        PersonaV.inpTlfPer.setText("");
        PersonaV.inptUsr.setText("");
        PersonaV.btnGroupTipPer.clearSelection();
        PersonaV.inptUsr.setText("");
        PersonaV.inptPssw.setText("");
        PersonaV.pnlCredenciales.setVisible(false);
    }

}
