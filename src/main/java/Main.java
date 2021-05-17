import Functional.AllUsers;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AllUsers.initialize();
        URL resource = getClass().getClassLoader().getResource("StartWindow.fxml");
        if (resource != null) {
            System.out.println("Hmmmmmmmm");
            FXMLLoader loader = new FXMLLoader(resource);
            Parent start_layout = loader.load(resource);
            System.out.println("Hmmmmmmmm");
            primaryStage.setTitle("Study App");
            System.out.println("Hmmmmmmmm");
            primaryStage.setScene(new Scene(start_layout, 600, 400));
            primaryStage.show();
        }
        else
        {
            System.out.println("F*ck");
            System.exit(-1);
        }
    }
}
