package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainSceneController {
    public MenuItem mnuOpen;
    public MenuItem mnuNew;
    public MenuItem mnuSave;
    public MenuItem mnuSaveAs;
    public MenuItem mnuPrint;
    public MenuItem mnuExit;
    public MenuItem mnuCut;
    public MenuItem mnuCopy;
    public MenuItem mnuPaste;
    public MenuItem mnuSelectAll;
    public MenuItem mnuUserGuid;
    public MenuItem mnuAboutUs;
    public HTMLEditor htmlEditor;
    public AnchorPane root;

    public void mnuNewOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane mainSceneRoot = FXMLLoader.load(getClass().getResource("/view/MainScene.fxml"));
        Scene mainScene = new Scene(mainSceneRoot);

        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(mainScene);
        stage.setTitle("New Stage");
        stage.show();
    }

    public void mnuOpenOnAction(ActionEvent actionEvent) {
    }

    public void mnuSaveOnAction(ActionEvent actionEvent) {

    }

    public void mnuSaveAsOnAction(ActionEvent actionEvent) {
    }

    public void mnuPrintOnAction(ActionEvent actionEvent) {
    }

    public void mnuExitOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }


    public void mnuCutOnAction(ActionEvent actionEvent) {
    }

    public void mnuCopyOnAction(ActionEvent actionEvent) {
    }

    public void mnuPasteOnAction(ActionEvent actionEvent) {
        
    }

    public void mnuSelectAllOnAction(ActionEvent actionEvent) {
    }

    public void mnuUserGuidOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane userGuideRoot = FXMLLoader.load(getClass().getResource("/view/UserGuid.fxml"));
        Scene scene1 = new Scene(userGuideRoot);

        Stage stage = new Stage();

        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(root.getScene().getWindow());

        stage.setScene(scene1);
        stage.setTitle("User Guide");
        stage.show();
    }
    double xOffset = 0;
    double yOffset = 0;

    public void mnuAboutUsOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane aboutUsRoot = FXMLLoader.load(getClass().getResource("/view/AboutUs.fxml"));
        Scene scene1 = new Scene(aboutUsRoot);
        Stage stage = new Stage();
        stage.setScene(scene1);

        stage.initStyle(StageStyle.TRANSPARENT);
        aboutUsRoot.setBackground(Background.fill(Color.TRANSPARENT));
        scene1.setFill(Color.TRANSPARENT);

        //mouse drag


        aboutUsRoot.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        // Mouse Drag Event
        aboutUsRoot.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });

        stage.centerOnScreen();
        stage.show();


    }
}
