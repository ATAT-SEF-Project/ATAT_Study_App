package ImageViewer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class ImageViewer extends Application  {

    public String path;
    public void setPath(String url)
    {
        path = url;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("TutorialViewer");

        FileInputStream input = new FileInputStream(path);
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);

        HBox hbox = new HBox(imageView);

        Scene scene = new Scene(hbox, 1200, 800);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}