package com.example.demo4;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ProtoProjController {

    public Button GoBackButton;

    public void GoBackFunc(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) GoBackButton.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Menu.fxml")));
        stage.setTitle("RubCalculus Mk III.Menu");
        stage.setScene(new Scene(root));
    }
}
