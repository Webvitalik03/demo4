package com.example.demo4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Objects;

public class TDESAESController {

    EncryptorTDESAES encryptorAES = new EncryptorTDESAES();
    EncryptorTDES encryptorTripleDES = new EncryptorTDES();

    @FXML
    private TextField keyTextField;

    @FXML
    private TextField inputTextField;

    @FXML
    private TextField outputTextField;

    @FXML
    private RadioButton aseRadio;

    @FXML
    private ToggleGroup encryptionDecryptionType;

    @FXML
    private Button GoBack;

    @FXML
    private RadioButton tripleDSERadio;

    public TDESAESController() throws InvalidKeySpecException, InvalidKeyException, NoSuchAlgorithmException {
    }

    @FXML
    void decryptButton(ActionEvent event) throws NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {

        String input = inputTextField.getText();
        String key = keyTextField.getText();
        String encryptedString = null;

        if(encryptionDecryptionType.getSelectedToggle() == aseRadio){
            encryptedString = encryptorAES.decrypt(input,key);
        } else if(encryptionDecryptionType.getSelectedToggle() == tripleDSERadio){
            encryptedString = encryptorTripleDES.decrypt(input,key);
        }
        outputTextField.setText(encryptedString);
    }


    @FXML
    void encryptButton(ActionEvent event) throws NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, UnsupportedEncodingException {

        String key = keyTextField.getText();
        String input = inputTextField.getText();
        String encryptedString = null;
        if(encryptionDecryptionType.getSelectedToggle() == aseRadio){
            encryptedString = encryptorAES.encrypt(input,key);
        } else if(encryptionDecryptionType.getSelectedToggle() == tripleDSERadio){
            encryptedString = encryptorTripleDES.encrypt(input,key);
        }
        outputTextField.setText(encryptedString);

    }
        @FXML
        public void GoBackFunc(MouseEvent event) throws IOException {
        Stage stage = (Stage) GoBack.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Menu.fxml")));
        stage.setTitle("RubCalculus Mk III.Menu");
        stage.setScene(new Scene(root));
    }

}