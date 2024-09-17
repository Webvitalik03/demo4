package com.example.demo4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

public class MenuController {
    @FXML
    public Button GoTestDesignViewButton;
    @FXML
    public Button GoTestFuncSecaViewButton;
    @FXML
    public Button AlarmClockButt;
    @FXML
    public Button AESButton;
    @FXML
    public Button GoHelloViewButton;
    @FXML
    public Button GoTDESAESButton;
    @FXML
    public Button GoProjButton;

    @FXML
    public void GoSceneHello(MouseEvent event) throws IOException {
        Stage stage = (Stage) GoHelloViewButton.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        stage.setTitle("RubCalculus Mk III");
        stage.setScene(new Scene(root));
    }

    @FXML
    public Button GoTestFuncViewButton;
    @FXML
    public void GoSceneTest(MouseEvent event) throws IOException {
        Stage stage = (Stage) GoTestFuncViewButton.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FuncTest.fxml")));
        stage.setTitle("RubCalculus Mk III.FuncTest");
        stage.setScene(new Scene(root));
    }

    public void GoSceneTestDesign(MouseEvent event) throws IOException {
        Stage stage = (Stage) GoTestDesignViewButton.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("DesignTest.fxml")));
        stage.setTitle("RubCalculus Mk III.DesignTest");
        stage.setScene(new Scene(root));
    }

    public void GoSceneTestSeca(MouseEvent event) throws IOException {
        Stage stage = (Stage) GoTestFuncSecaViewButton.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FuncTestSec.fxml")));
        stage.setTitle("RubCalculus Mk III.FuncTestSeca");
        stage.setScene(new Scene(root));
    }

    public void GoAlarmClock(MouseEvent event) throws IOException {
        Stage stage = (Stage) AlarmClockButt.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AlarmClock.fxml")));
        stage.setTitle("RubCalculus Mk III.AlarmClock");
        stage.setScene(new Scene(root));
    }

    public void GoAes(MouseEvent event) throws IOException {
        Stage stage = (Stage) AESButton.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AES.fxml")));
        stage.setTitle("RubCalculus Mk III.AES");
        stage.setScene(new Scene(root));
    }
    public void GoTDESAESFunc(MouseEvent event) throws IOException{
        Stage stage = (Stage) GoTDESAESButton.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TDESAES.fxml")));
        stage.setTitle("RubCalculus Mk III.TDESAES");
        stage.setScene(new Scene(root));
    }

    public void ShowDialogInfo(ActionEvent actionEvent) {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Message");
        alert.setContentText("JavaFX API of version 22 by JavaFX runtime of version 11.0.2");
        Optional<ButtonType> result = alert.showAndWait();
        }

    public void GoProject(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) GoProjButton.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ProtoProj.fxml")));
        stage.setTitle("RubCalculus Mk IV.Proto");
        stage.setScene(new Scene(root));

    }
}
