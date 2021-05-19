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

public class AddStudentController extends GeneralController{
    @FXML
    private Button exitButton;
    @FXML
    private Button createButton;
    @FXML
    private TextField classField;
    @FXML
    private TextField studentField;
    @FXML
    private Label outputLabel;

    public void exitButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void createButtonOnAction(ActionEvent event) {
        String studentName = studentField.getText();
        String classRoomName = classField.getText();

        User user = new User(studentName, "", "none");
        User search = user.find();

        String username = AllUsers.current_user.email;

        if(classRoomName != null && search != null && search.type() != "Teacher")
        {
            DirectoryController dir = new DirectoryController();
            dir.create("Teachers/" + username + "/" + classRoomName + "/" + studentName);
            outputLabel.setText("Student added in classroom!");
            outputLabel.setTextFill(Color.rgb(0, 255, 10));

            Stage stage = (Stage) createButton.getScene().getWindow();
            PauseTransition delay = new PauseTransition(Duration.seconds(2));
            delay.setOnFinished(e -> stage.close());
            delay.play();
        }
        else if(search != null && classRoomName == null){
            outputLabel.setText("Classroom name cannot be empty! Try again!");
            outputLabel.setTextFill(Color.rgb(255, 10, 10));
        }
        else if(classRoomName != null && search != null && search.type() != "Student")
        {
            outputLabel.setText("Please add a student to your classroom, not a Teacher");
            outputLabel.setTextFill(Color.rgb(255, 10, 10));
        }
        else{
            outputLabel.setText("Student not found!" + search.email() + " " + classRoomName );
            outputLabel.setTextFill(Color.rgb(255, 10, 10));
        }
    }

}
