package a4_gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("fxCalculator.fxml"));

            Scene scene = new Scene(root);
            primaryStage.setTitle("Desktop Calculator");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
            ex.printStackTrace();
        }
    }//start

    public static void main(String[] args) {
        launch(args);
    }

}
