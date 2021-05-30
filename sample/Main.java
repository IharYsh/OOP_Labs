package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Shapes.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group group = new Group();
        Scene scene = new Scene(group,800,800);

        primaryStage.setScene(scene);
        primaryStage.show();

        new Test(group);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
