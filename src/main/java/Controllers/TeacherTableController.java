package Controllers;

import Functional.AllUsers;
import Functional.User;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class TeacherTableController {
    @FXML
    private ListView<String> listView;

    public void initialize() {
        for (User teacher : AllUsers.TeacherList) {
            listView.getItems().add(teacher.email());
        }
    }
}
