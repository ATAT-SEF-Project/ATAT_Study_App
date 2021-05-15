import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent start_layout = FXMLLoader.load(getClass().getClassLoader().getResource("StartWindow.fxml"));

        primaryStage.setTitle("Study App");
        primaryStage.setScene(new Scene(start_layout, 600, 400));
        primaryStage.show();
    }
}