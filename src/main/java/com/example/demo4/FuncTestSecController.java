package com.example.demo4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class FuncTestSecController implements Initializable {

    public Text ToggleView;
    public ToggleButton TogBut1;
    public ToggleButton TogBut2;
    public ToggleGroup TogBut;
    TextAnimator textAnimator;
    Thread thread;

    public Button GoMenuButton;
    public Button StartAnimeBut;
    public Button StopAnimeBut;

    public void GoBack(MouseEvent event) throws IOException {
        Stage stage = (Stage) GoMenuButton.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Menu.fxml")));
        stage.setTitle("RubCalculus Mk III.Menu");
        stage.setScene(new Scene(root));
    }

    public void StartAnimatia(MouseEvent event) {
        thread = new Thread(textAnimator);
        thread.start();
    }

    public void StopAnimatia(MouseEvent event) {
        thread.interrupt();
    }
    @FXML
    private Text text;;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textAnimator = new TextAnimator(text,100);
    }

    public void ToggleButton(ActionEvent event) {
        if(event.getSource() == TogBut1){
            ToggleView.setText("Var1");
        }

        if(event.getSource() == TogBut2){
            ToggleView.setText("Var2");
        }

    }
}
