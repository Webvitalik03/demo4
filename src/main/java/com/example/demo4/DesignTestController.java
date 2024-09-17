package com.example.demo4;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class DesignTestController implements Initializable {
    public PasswordField PasswordHidden;
    public TextField PasswordText;
    public CheckBox PassChekBox;



    int i = 0;
    public Text DurationView;
    TranslateTransition transition;
    public Button BackToMenuButton;
    public Circle AnimeCircle;
    public Button ActBut;


    @FXML
    public TableView<User> TableTest;
    @FXML
    public TableColumn<User,String> table_name;
    @FXML
    public TableColumn<User, Integer> table_age;
    @FXML
    public TableColumn<User, String> table_gender;

    public LineChart<?,?> TestChart;

    public Button AppendButt;
    public TextField TestAppend;

    ObservableList<User> list = FXCollections.observableArrayList(
            new User("Vi", 20, "Male"),
            new User("Ju", 18, "Female"),
            new User("Il", 20, "Male")
    );

    public void GoToSceneMenu(MouseEvent event) throws IOException {
        Stage stage = (Stage) BackToMenuButton.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Menu.fxml")));
        stage.setTitle("RubCalculus Mk III.Menu");
        stage.setScene(new Scene(root));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       transition  = new TranslateTransition();
        transition.setNode(AnimeCircle);
        transition.setToX(300);
        transition.setToY(100);
        transition.setDuration(Duration.millis(2000));
        transition.setAutoReverse(true);
        transition.setCycleCount(2);


        DurationView.setText(String.valueOf(i));

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1),e ->{
            i++;
            DurationView.setText(String.valueOf(i));
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        table_name.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
        table_age.setCellValueFactory(new PropertyValueFactory<User, Integer>("age"));
        table_gender.setCellValueFactory(new PropertyValueFactory<User, String>("gender"));
        TableTest.setItems(list);

        XYChart.Series series1 = new XYChart.Series();

        series1.getData().add(new XYChart.Data("1",2));
        series1.getData().add(new XYChart.Data("2",4));
        series1.getData().add(new XYChart.Data("3",6));


        XYChart.Series series2 = new XYChart.Series();

        series2.getData().add(new XYChart.Data("1",1));
        series2.getData().add(new XYChart.Data("2",4));
        series2.getData().add(new XYChart.Data("3",8));

        TestChart.getData().addAll(series1,series2);
        }

    public void StartAnime(ActionEvent event) {
        transition.play();
    }

    public void ChangeVisibility(ActionEvent event) {
        if (PassChekBox.isSelected()) {
            PasswordText.setText(PasswordHidden.getText());
            PasswordText.setVisible(true);
            PasswordHidden.setVisible(false);
            return;
        }

            PasswordHidden.setText(PasswordText.getText());
            PasswordHidden.setVisible(true);
            PasswordText.setVisible(false);
        }

    public void KeyInput(KeyEvent event) {
        if(event.getCode() == KeyCode.Q) {
            TestAppend.appendText("Q pressed ");
        } else if (event.getCode() == KeyCode.W) {
            TestAppend.appendText("W pressed ");
        }
    }
}
