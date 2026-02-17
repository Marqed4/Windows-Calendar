import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage prim) {
        Group root = new Group();
        Scene scene = new Scene(root, 500, 500, Color.LIGHTGRAY);

        prim.setTitle("Windows Calendar");
        prim.setScene(scene);


        prim.show();
    }
}