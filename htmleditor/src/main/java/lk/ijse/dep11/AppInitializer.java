package lk.ijse.dep11;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent splashRoot = FXMLLoader.load(getClass().getResource("/view/Splash.fxml"));
        Stage splashStage = new Stage();
        splashStage.initStyle(StageStyle.UNDECORATED);
        splashStage.setScene(new Scene(splashRoot));


        Task<Void> initializationTask = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                // Simulate initialization delay
                Thread.sleep(2000);
                // Perform actual initialization tasks
                return null;
            }
        };

        /*ProgressBar progressBar = new ProgressBar();
        initializationTask.getProgress(event -> {
            progressBar.setProgress();
        });*/

        FadeTransition fadeIn = new FadeTransition(Duration.seconds(2), splashRoot);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.play();


        initializationTask.setOnSucceeded(event -> {
            splashStage.close(); // Close the splash screen
            // Load and show the main application window
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/view/MainScene.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            primaryStage.setTitle("CodeCompose Studio");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        });

        // Start the task in a separate thread
        new Thread(initializationTask).start();

        splashStage.show(); // Show the splash screen
    }
}
