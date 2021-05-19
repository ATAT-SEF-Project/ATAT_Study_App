package Controllers;

import Functional.AllUsers;
import Functional.User;
import ImageViewer.ImageViewer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;

import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

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
    public void openTutorialOnAction(ActionEvent event) {
        ImageViewer tut = new ImageViewer();
        tut.setPath("picture.png");
        Stage stage = new Stage();
        try {
            tut.start(stage);
        }
        catch (Exception ex) {
            System.out.println("Error!");
        }
    };
}
