package Controllers;

import Canvas.CanvasApp;
import Functional.AllUsers;
import Functional.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class MyClassTableController extends GeneralController{
    @FXML
    private ListView<String> listView;

    @FXML
    private Button addClassRoomButton;

    public void initialize() {


        File directory = new File("Teachers/" + AllUsers.current_user.email());

        File[] fList = directory.listFiles();

        if(fList != null) {
            for (File file : fList) {
                if (file.isDirectory())
                    listView.getItems().add(file.getName());
            }
        }
        else{
            listView.getItems().add("(empty)");
        }
    }

    public void addClassRoomOnAction(ActionEvent event) throws IOException {
        URL resource = getClass().getClassLoader().getResource("AddClass.fxml");
        Stage stage = new Stage();
        if(resource != null) {
            Parent start_layout = FXMLLoader.load(resource);
            Stage addStage = new Stage();
            addStage.setTitle("Add Classroom");
            addStage.setScene(new Scene(start_layout, 600, 400));
            addStage.show();
        }
        else
        {
            System.out.println("Cannot add Classroom!");
        }
    }
    public void addStudentOnAction(ActionEvent event) throws IOException {
        URL resource = getClass().getClassLoader().getResource("AddStudent.fxml");
        Stage stage = new Stage();
        if(resource != null) {
            Parent start_layout = FXMLLoader.load(resource);
            Stage addStage = new Stage();
            addStage.setTitle("Add Student in Classroom");
            addStage.setScene(new Scene(start_layout, 600, 400));
            addStage.show();
        }
        else
        {
            System.out.println("Cannot add Classroom!");
        }
    }
}
