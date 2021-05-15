package Controllers;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RegisterController extends GeneralController{
    @FXML
    private Button exitButton;
    @FXML
    private Button createButton;
    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField confirmField;
    @FXML
    private Label outputLabel;

    public void initialize() {
        choiceBox.getItems().add("Teacher");
        choiceBox.getItems().add("Student");
        choiceBox.setValue("Teacher");
        choiceBox.setStyle("-fx-font: 14px \"System\";");
    }

    public void exitButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void createButtonOnAction(ActionEvent event) {
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirm = confirmField.getText();
        String choice = choiceBox.getValue();
        boolean valid = true;

        if (!valid) {
            outputLabel.setText("Invalid input!");
            outputLabel.setTextFill(Color.rgb(255, 10, 10));
        }
        else {
            outputLabel.setText("Success!");
            outputLabel.setTextFill(Color.rgb(10, 255, 10));

            changeWindow(createButton, "StartWindow.fxml", 600, 400);
        }
    }
}
