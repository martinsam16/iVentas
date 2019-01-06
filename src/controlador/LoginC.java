package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import modelo.LoginM;
import modelo.PersonaM;
import vista.MenuV;
import dao.LoginD;
import javafx.scene.control.CheckBox;

/**
 *
 * @author Martin Alexis Saman Arata
 */
public class LoginC extends LoginM{

    private final LoginM LOGIN = new LoginM();
    private final LoginD DAO = new LoginD();
    private final PersonaM PERSONA = new PersonaM();

    @FXML
    private TextField inptUsr;

    @FXML
    private PasswordField inptPsw;

    @FXML
    private CheckBox btnRcrd;

    @FXML
    private void btnIngresar(ActionEvent e) {
        try {
            LOGIN.setUsrper(inptUsr.getText());
            LOGIN.setPswper(inptPsw.getText());

            if (DAO.autenticacion(LOGIN, PERSONA)) {

                if (!btnRcrd.isSelected()) {
                    inptUsr.clear();
                    inptPsw.clear();
                }
                
                MenuV menu = new MenuV(); 
                switch (PERSONA.getTipper()) {
                    case "A":
                        menu.setVisible(true);
                        break;
                    case "V":
                        menu.pnlPersonas.setVisible(false);
                        menu.pnlProducto.setVisible(false);
                        menu.setVisible(true);
                        break;
                    case "I":
                        menu.pnlPersonas.setVisible(false);
                        menu.pnlVentas.setVisible(false);
                        menu.setVisible(true);
                        break;
                    default:
                        break;
                }
            } else {
                servicios.SmsS.error("Error", "Usuario y/o contaseña incorrecto.", "Tal vez se equivocó o no esté registrado.");
            }

        } catch (Exception ej) {
            System.out.println("error btnIngresar()" + ej.getMessage());
        }
    }  
    
    @FXML
    private void btnSalir(ActionEvent e){
        System.exit(0);
    }

}
