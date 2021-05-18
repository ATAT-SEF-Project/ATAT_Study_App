package Controllers;

import Functional.AllUsers;
import Functional.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

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
        for (String type : AllUsers.Types) {
            if (!type.equals("none"))
                choiceBox.getItems().add(type);
        }
        choiceBox.setValue(AllUsers.Types.get(0));
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
        boolean valid = false;

        User user = new User(email, password, choice);
        valid = user.checkMail() && user.checkPassword();

        if (!valid) {
            outputLabel.setText("Invalid input!");
            outputLabel.setTextFill(Color.rgb(255, 10, 10));
        }
        else{
            if (!password.equals(confirm)) {
                outputLabel.setText("Passwords don't match!");
                outputLabel.setTextFill(Color.rgb(255, 10, 10));
            }
            else {
                User search = user.find();
                if (search != null) {
                    outputLabel.setText("User already exists!");
                    outputLabel.setTextFill(Color.rgb(255, 10, 10));
                }
                else {
                    user.add();
                    outputLabel.setText("Success!");
                    outputLabel.setTextFill(Color.rgb(10, 255, 10));
                    changeWindow(createButton, "StartWindow.fxml", 600, 400);
                }
            }
        }
    }
}
