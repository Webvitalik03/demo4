package com.example.demo4;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class AlarmClockController implements Initializable {

    public TextField alarmTime;
    public Text timer;
    AlarmTime time = new AlarmTime(new AlarmCurrentTime().currentTime());
    public Button GoBack;
    public Text TextMessage;

    public void GoMenu(MouseEvent event) throws IOException {
        Stage stage = (Stage) GoBack.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Menu.fxml")));
        stage.setTitle("RubCalculus Mk III.Menu");
        stage.setScene(new Scene(root));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        timer.setText(time.getCurrentTime());

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(1),
                    e->{
                if (time.getCurrentTime().equals(alarmTime.getText())){
                    TextMessage.setText("ALARM!!!");
                }
                time.oneSecondPassed();
                timer.setText(time.getCurrentTime());
                    }));
}
