package com.example.demo4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;

public class FuncTestController implements Initializable {

    public Button TextSaveButton;
    public ProgressBar ProgressTestBar;
    public Text ChoiceViewerNoButton;
    double points = 0;
    public Button AddButton;
    public Button RemoveButton;
    public Text PointProgressTextShow;
    FileChooser fileChooser = new FileChooser();
    //
    @FXML
    public Button GoMenuViewButton;
    @FXML
    public ImageView mchslogo1;
    @FXML
    public ImageView mchslogo2;
    //
    @FXML
    public Text TextFieldTestOut;
    @FXML
    public TextField TextFieldTestIn;
    @FXML
    public Button TestTextInButton;
    //
    @FXML
    public RadioButton variant1;
    @FXML
    public RadioButton variant2;
    @FXML
    public Text YourRadioChoice;
    @FXML
    public Button MakeRadioChoiceButton;
    @FXML
    public ToggleGroup Variants;
    //
    @FXML
    public Slider SliderIncr;
    @FXML
    public Text ShowSliderValue;
    //
    @FXML
    public TextField ListInField;
    @FXML
    public Button AddToListViewButton;
    @FXML
    public Button RemoveFromListViewButton;
    @FXML
    public ListView<String> TestListView;
    //
    public Button SpinValueApplyButton;
    public Text SpinnerValue;
    public Spinner<Integer> TestSpinner;
    public Text InvisOrVisText;
    public Button DisableVisibilityButton;
    public Button EnableVisibilityButton;

    public Button KeyCodeTestButton;
    public Text KeyCodeViewer;
    //
    public Button EnterDateButton;
    public DatePicker DateChoserTest;
    public Text DateShowText;
    //
    public ChoiceBox<String> ChoiceBoxTest;
    public Text ChoiceShowerTestField;
    public Button ChoiceMakeButton;
    //
    public Button ChooseColorTestButton;
    public ColorPicker ButtonPickerTest;
    public TextArea TextGetArea;
    public Button TextGetButton;

    SpinnerValueFactory<Integer> svf
            = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
    //

    public void GoSceneMenu(MouseEvent event) throws IOException {
        Stage stage = (Stage) GoMenuViewButton.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Menu.fxml")));
        stage.setTitle("RubCalculus Mk III.Menu");
        stage.setScene(new Scene(root));

    }

    public void ShowInvisibleImage(MouseEvent event) {
        mchslogo2.setVisible(true);
    }

    public void MakeInvisibleImage(MouseEvent event) {
        mchslogo2.setVisible(false);
    }

    public void TestTextInFunc(MouseEvent event) {
        TextFieldTestOut.setText(TextFieldTestIn.getText());
    }

    @FXML
    public void MakeRadioChoice(MouseEvent event) {
        if (Variants.getSelectedToggle().equals(variant1)) {
            YourRadioChoice.setText("Вариант 1");
        } else if (Variants.getSelectedToggle().equals(variant2)) {
            YourRadioChoice.setText("Вариант 2");
        }
    }

    @FXML
    public void GetSliderValue(MouseEvent event) {
        ShowSliderValue.setText(String.valueOf((int) SliderIncr.getValue()));
    }

    @FXML
    public void AddToListViewFunc(MouseEvent event) {
        TestListView.getItems().add(ListInField.getText());
    }

    @FXML
    public void RemoveFromListViewFunc(MouseEvent event) {
        int selectedID = TestListView.getSelectionModel().getSelectedIndex();
        TestListView.getItems().remove(selectedID);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TestSpinner.setValueFactory(svf);
        ChoiceBoxTest.getItems().addAll("Вариант 1", "Вариант 2", "Вариант 3");

        ChoiceBoxTest.setOnAction(actionEvent -> {
            ChoiceViewerNoButton.setText(ChoiceBoxTest.getValue());
        });

    }

    public void SpinValueApplyFunc(MouseEvent event) {
        int number = TestSpinner.getValue();
        SpinnerValue.setText(String.valueOf(number));
        fileChooser.setInitialDirectory(new File("C:\\IdealniyProj\\demo4\\src\\main\\resources\\com\\example\\demo4\\text.txt"));
    }

    public void DisableVisibility(MouseEvent event) {
        InvisOrVisText.setVisible(false);
    }

    public void EnableVisibility(MouseEvent event) {
        InvisOrVisText.setVisible(true);
    }

    public void ShowMessageByKeyCode(KeyEvent event) {
        if (event.getCode() == KeyCode.SPACE) {
            KeyCodeViewer.setText("Space");
        } else if (event.getCode() == KeyCode.ENTER) {
            KeyCodeViewer.setText("Enter");
        }

    }

    public void EnterDateFunc(MouseEvent event) {
        LocalDate time = DateChoserTest.getValue();
        DateShowText.setText(String.valueOf(time));
    }

    public void MakeAChoiceFunc(MouseEvent event) {
        String Choice = ChoiceBoxTest.getSelectionModel().getSelectedItem();
        ChoiceShowerTestField.setText(Choice);
    }

    public void ChooseColorFunc(MouseEvent event) {
        Color col = ButtonPickerTest.getValue();
        ChooseColorTestButton.setTextFill(col);
    }

    public void saveSystem(File file, String content) {
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(content);
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void GetTextFunc(MouseEvent event) {
       File file = fileChooser.showOpenDialog(new Stage());
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                TextGetArea.appendText(scanner.nextLine() + "\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void SaveTextFunc(MouseEvent event) {
        File file = fileChooser.showSaveDialog(new Stage());
        if(file !=null){
            saveSystem(file, TextGetArea.getText());

        }
    }

    public void AddPointFunc(MouseEvent event) {
    points = points + 0.1;
    ProgressTestBar.setProgress(points);
    PointProgressTextShow.setText(Double.toString(Math.round(points*100.0)/100.0));
    }

    public void RemovePointFunc(MouseEvent event) {
    points = points - 0.1;
    ProgressTestBar.setProgress(points);
        PointProgressTextShow.setText(Double.toString(Math.round(points*100.0)/100.0));
    }
}
