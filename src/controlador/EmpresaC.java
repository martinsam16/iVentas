
package controlador;

import dao.EmpresaD;
import javax.swing.table.DefaultTableModel;
import modelo.PersonaM;

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
    
}
