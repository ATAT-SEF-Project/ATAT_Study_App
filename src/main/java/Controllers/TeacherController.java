package Controllers;

import Canvas.CanvasApp;
import Functional.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TeacherController extends GeneralController{
    @FXML
    private Button exitButton;
    @FXML
    private BorderPane borderPane;


    public void exitButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void createTutorialButtonOnAction(ActionEvent event) {
        CanvasApp canvas = new CanvasApp();
        Stage stage = new Stage();
        canvas.start(stage);
    }

    public void showClassesOnAction(ActionEvent event) {
        changeScene(borderPane, "MyClassesTable.fxml");
    }
}
