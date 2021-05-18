package Controllers;

import javafx.animation.PauseTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.net.URL;

public class GeneralController {
    public void changeWindow(Button button, String windowName, int width, int height) {
        try {
            URL resource = getClass().getClassLoader().getResource(windowName);
            if (resource != null) {
                Parent register_layout = FXMLLoader.load(resource);
                Stage stage = (Stage) button.getScene().getWindow();
                PauseTransition delay = new PauseTransition(Duration.seconds(1));
                delay.setOnFinished(e -> stage.setScene(new Scene(register_layout, width, height)));
                delay.play();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeScene(BorderPane pane, String windowName) {
        try {
            URL resource = getClass().getClassLoader().getResource(windowName);
            if (resource != null) {
                Pane register_layout = FXMLLoader.load(resource);
                pane.setCenter(register_layout);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
