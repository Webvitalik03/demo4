package com.example.demo4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

import static javafx.application.Application.launch;

public class HelloController {
    @FXML

    private Label ShowMessageLabel;

    public void GetUnitButtonClick() {
        ShowMessageLabel.setText("Подразделение: АКАДЕМИЯ ГПС МЧС РОССИИ");
    }

    public void GetAuthorButtonClick() {
        ShowMessageLabel.setText("Автор: рядовой внутренней службы Цыплаков Виталий Сергеевич");
    }

    public void GetChiefButtonClick() {
        ShowMessageLabel.setText("Руководитель проекта: майор внутренней службы Смирнов Андрей Владимирович");
    }

    public void GetVersionButtonClick() {
        ShowMessageLabel.setText("Версия: Mk III");
    }

    public void GetPOVersionButtonClick() {
        ShowMessageLabel.setText("Используемое ПО при разработке:\n Java API of version 22\n JavaFX 11.0.2\n SceneBuilder 22.0\n JetBrains: Intellij IDEA");
    }

    public void GetDescriptionButtonClick() {
        ShowMessageLabel.setText("ПО для проведения расчётов оператора БПЛА");
    }

    @FXML
    private Button GoMenuViewButton;
    @FXML
    private Button GoExitButton;
    @FXML
    public void GoSceneMenu(MouseEvent event) throws IOException {
        Stage stage = (Stage) GoMenuViewButton.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Menu.fxml")));
        stage.setTitle("RubCalculus Mk III.Menu");
        stage.setScene (new Scene(root));

    }
    public static  void main(String[] args) { launch(args);
    }

    public void GoExitFunc(MouseEvent event) throws IOException {
        Stage stage = (Stage) GoExitButton.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AESLogin.fxml")));
        stage.setTitle("RubCalculus Mk III.Login");
        stage.setScene(new Scene(root));
    }

}