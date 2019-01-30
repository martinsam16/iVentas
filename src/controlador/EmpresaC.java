
package controlador;

import dao.EmpresaD;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.PersonaM;
import org.json.simple.JSONObject;
import servicios.CombosAnidados;
import static vista.EmpresaV.comboDepartamento;
import static vista.EmpresaV.inputDireccionEmpresa;
import static vista.EmpresaV.inputNombreEmpresa;
import static vista.EmpresaV.inputRucEmpresa;
import static vista.PersonaV.comboDistrito;
import static vista.PersonaV.comboProvincia;

public class EmpresaC {
    EmpresaD dao = new EmpresaD();
    PersonaM persona = new PersonaM();
    
    public DefaultTableModel listarEmpresas(){
        try {
            return dao.listarPro();
        } catch (Exception e) {
            System.out.println("Error listarEmpresas C"+e.getMessage());
        }
        return null;
    }
    
    public DefaultComboBoxModel llenarComboUbigeo(char tipo, String nombre) {
        try {
            servicios.CombosAnidados combo = new CombosAnidados();
            return combo.listarCombo(tipo, nombre);
        } catch (Exception e) {
            return null;
        }
    }
    
    public void autorrellenarCamposPorRuc(){
        try {
            if (!servicios.ConsultaGob.existeDocumento(inputRucEmpresa.getText(), '2')) {
                JSONObject datosEmpresa= servicios.ConsultaGob.getDatosRuc(inputRucEmpresa.getText());
                inputNombreEmpresa.setText(datosEmpresa.get("razon_social").toString());
                String[] domicilio = servicios.ConsultaGob.separarDomicilio(datosEmpresa.get("domicilio_fiscal").toString());
                comboDepartamento.setSelectedItem(domicilio[0]);
                comboProvincia.setSelectedItem(domicilio[1]);
                comboDistrito.setSelectedItem(domicilio[2]);
                inputDireccionEmpresa.setText(domicilio[3]);
                System.out.println(datosEmpresa.get("representante_legal").toString());
            }else{
                JOptionPane.showMessageDialog(null, "Ya existe");
            }
        } catch (Exception e) {
        }
    }
    
}
