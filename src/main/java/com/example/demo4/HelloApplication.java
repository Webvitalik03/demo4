package com.example.demo4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {


    @Override
    public void start(Stage primaryStage) throws IOException {
      Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AESLogin.fxml")));
        primaryStage.setTitle("RubCalculus Login Mk III");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        File file = new File("C:\\IdealniyProj\\demo4\\src\\main\\resources\\com\\example\\demo4\\text.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        launch(args);}

}