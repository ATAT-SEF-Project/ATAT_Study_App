package Controllers;

import Functional.AllUsers;
import Functional.ClassRoom;
import Functional.User;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AddClassController extends GeneralController{
    @FXML
    private Button exitButton;
    @FXML
    private Button createButton;
    @FXML
    private TextField classField;
    @FXML
    private Label outputLabel;

    public void exitButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void createButtonOnAction(ActionEvent event) {
        String classRoomName = classField.getText();

        if(classRoomName != null) {
            DirectoryController dir = new DirectoryController();
            String username = AllUsers.current_user.email();
            dir.create("Teachers/" + username + "/" + classRoomName);

            outputLabel.setText("Classroom created!");
            outputLabel.setTextFill(Color.rgb(0, 255, 10));

            Stage stage = (Stage) createButton.getScene().getWindow();
            PauseTransition delay = new PauseTransition(Duration.seconds(2));
            delay.setOnFinished(e -> stage.close());
            delay.play();
            }

        else{
            outputLabel.setText("Classroom name cannot be empty!");
            outputLabel.setTextFill(Color.rgb(255, 10, 10));
        }

    }

}
