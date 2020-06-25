package kioscopresentacion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Juan Sebastian Barreto Jimenez Juan Camilo Devia Bastos Nicolas
 * Javier Ramirez Beltran Valentina López Suárez Mayo 25 2020
 */
public class KioscoPresentacion extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLPantallaKiosco.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
   
    public static void main(String[] args) {
        launch(args);
    }
    
}
