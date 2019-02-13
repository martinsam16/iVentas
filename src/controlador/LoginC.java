package controlador;

import dao.PersonaD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import modelo.PersonaM;
import vista.MenuV;
import javafx.scene.control.CheckBox;

/**
 * Controlador del Login en JavaFx
 *
 * @author Martín Alexis Samán Arata
 * @version 0.0.1
 */
public class LoginC {

    private final PersonaD DAO = new PersonaD();
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
            PERSONA.setUsrper(inptUsr.getText());
            PERSONA.setPswper(inptPsw.getText());

            if (DAO.autenticar(PERSONA)) {

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
                        MenuV.pnlPersonas.setVisible(false);
                        MenuV.pnlProducto.setVisible(false);
                        menu.setVisible(true);
                        break;
                    case "I":
                        MenuV.pnlPersonas.setVisible(false);
                        MenuV.pnlVentas.setVisible(false);
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
    private void btnSalir(ActionEvent e) {
        System.exit(0);
    }

}
