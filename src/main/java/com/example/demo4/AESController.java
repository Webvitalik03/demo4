package com.example.demo4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class AESController {


    public Button GoMenuButton;
    AESEncryptor encryptor = new AESEncryptor();

    @FXML
    public TextField keyTextField;
    @FXML
    public TextField inputTextField;
    @FXML
    public TextField outputTextField;

    public void encryptButton(ActionEvent event) throws NoSuchPaddingException, InvalidKeyException,
            NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
        byte[] key = encryptor.stringToByteArray(keyTextField.getText());
        String input = inputTextField.getText();
        String encryptedString = encryptor.decrypt(input,key);
        outputTextField.setText(encryptedString);
    }

    public void decryptButton(ActionEvent event) throws NoSuchPaddingException, InvalidKeyException,
            NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
        byte[] key = encryptor.stringToByteArray(keyTextField.getText());
        String input = inputTextField.getText();

        String encryptedString = encryptor.encrypt(input,key);
        outputTextField.setText(encryptedString);
    }


    public void GoMenuFunction(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) GoMenuButton.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Menu.fxml")));
        stage.setTitle("RubCalculus Mk III.Menu");
        stage.setScene(new Scene(root));
    }
}
