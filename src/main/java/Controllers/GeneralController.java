package Controllers;

import javafx.animation.PauseTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GeneralController {

    public void changeWindow(Button button, String windowName, int width, int height) {
        try {
            Parent register_layout = FXMLLoader.load(getClass().getClassLoader().getResource(windowName));
            Stage stage = (Stage) button.getScene().getWindow();
            PauseTransition delay = new PauseTransition(Duration.seconds(1));
            delay.setOnFinished( e -> stage.setScene(new Scene(register_layout, width, height)) );
            delay.play();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
