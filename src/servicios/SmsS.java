package servicios;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

public class SmsS {
    @FXML
    public static void error(String title, String header, String body) {
        Alert error = new Alert(Alert.AlertType.ERROR);
        error.setTitle(title);
        error.setHeaderText(header);
        error.setContentText(body);
        error.initStyle(StageStyle.UTILITY);
        error.showAndWait();
    }
}
