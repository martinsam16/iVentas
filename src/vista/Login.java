package vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import dao.Conexion;
import javafx.stage.StageStyle;
import servicios.SmsS;

public class Login extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Conexion.conectar();
        if (Conexion.estado()) {
            Conexion.desconectar();
            Parent root = FXMLLoader.load(getClass().getResource("LoginV.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Login");
            stage.centerOnScreen();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
        }else{
            SmsS.error("Error", "Error de conexión.", "Tal vez el servicio MySql de Xampp esté apagado o las credenciales estén mal.");
            System.exit(0);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);       
        
    }

}
