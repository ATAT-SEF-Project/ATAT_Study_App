package Controllers;

import Functional.AllUsers;
import Functional.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class StudentController extends GeneralController{
    @FXML
    private Button exitButton;
    @FXML
    private BorderPane borderPane;

    public void exitButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void showTeachersOnAction(ActionEvent event) {
        changeScene(borderPane, "TeacherTableWindow.fxml");
    }
}
