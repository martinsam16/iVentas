package controlador;

import dao.PersonaD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import modelo.PersonaM;
import vista.MenuV;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

/**
 * Controlador del Login en JavaFx
 *
 * @author Martín Alexis Samán Arata
 * @version 0.0.1
 */
public class LoginC {

    private final PersonaD DAO = new PersonaD();
    private final PersonaM PERSONA = new PersonaM();
    public static String tipoDePersona, usuario;

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
                
                tipoDePersona=PERSONA.getTipper();
                usuario = PERSONA.getUsrper();

                MenuV menu = new MenuV();
                menu.setVisible(true);
                
                final Node source = (Node) e.getSource();
                final Stage stage = (Stage) source.getScene().getWindow();
                stage.close();

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
