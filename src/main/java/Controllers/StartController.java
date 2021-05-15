package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class StartController extends GeneralController{
    @FXML
    private Button exitButton;
    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label outputLabel;

    public void exitButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void loginButtonOnAction(ActionEvent event) throws Exception{
        String username = usernameField.getText();
        String password = passwordField.getText();
        boolean valid = true;

        if (!valid) {
            outputLabel.setText("Invalid input!");
            outputLabel.setTextFill(Color.rgb(255, 10, 10));
        }
        else {
            outputLabel.setText("Success!");
            outputLabel.setTextFill(Color.rgb(10, 255, 10));
        }
    }

    public void registerButtonOnAction(ActionEvent event) {
        changeWindow(registerButton, "RegisterWindow.fxml", 600, 400);
    }
}
