package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerLogin {
    @FXML private TextField passwordTextField;
    @FXML private Label passwordLabel;
    @FXML private Button staffButton;
    @FXML private Button pipoButton;
    @FXML private Button loginButton;

    public void initialize(){
        staffButton.setOnMouseClicked((MouseEvent e) -> {
            showBlockInputPassword();
            staffButton.setMnemonicParsing(true);
        });
        pipoButton.setOnMouseClicked((MouseEvent e) -> {
            showBlockInputPassword();
            pipoButton.setMnemonicParsing(true);
        });
    }

    public void showBlockInputPassword(){
        passwordLabel.setVisible(true);
        passwordTextField.setVisible(true);
    }

    public void clickedLoginButton(ActionEvent event) throws IOException {
        if (passwordTextField.getText().toLowerCase().equals("staff") && staffButton.isMnemonicParsing()){
            loginComplete(event);
        }
        else if (passwordTextField.getText().toLowerCase().equals("pipo") && pipoButton.isMnemonicParsing()){
            loginComplete(event);
        }
    }

    public void loginComplete(ActionEvent event) throws IOException {
        Button button = (Button) event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../portin.fxml"));
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
}
