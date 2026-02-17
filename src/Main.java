import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage application) {
        Group root = new Group();
        Scene scene = new Scene(root, 500, 500, Color.LIGHTGRAY);

        application.setTitle("Windows Calendar");
        application.setScene(scene);
        application.show();
    }
}