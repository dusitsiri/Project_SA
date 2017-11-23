package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class ControllerLogin {
    @FXML private TextField passwordTextField;
    @FXML private Label passwordLabel;
    @FXML private Button staffButton;
    @FXML private Button pipoButton;
    @FXML private Button loginButton;

    public void initialize(){
        staffButton.setOnMouseClicked((MouseEvent e) -> {
            setOption();
            staffButton.setMnemonicParsing(true);
            pipoButton.setMnemonicParsing(false);
        });
        pipoButton.setOnMouseClicked((MouseEvent e) -> {
            setOption();
            pipoButton.setMnemonicParsing(true);
            staffButton.setMnemonicParsing(false);

        });

        passwordTextField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER){
                    TextField textField = (TextField) event.getSource();
                    Stage stage = (Stage) textField.getScene().getWindow();
                    try {
                        checkUserAndPassword(stage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void setOption(){
        passwordTextField.requestFocus();
        showBlockInputPassword();
        passwordTextField.setText("");
    }

    public void showBlockInputPassword(){
        passwordLabel.setVisible(true);
        passwordTextField.setVisible(true);
    }

    public void loginOnClick(ActionEvent event) throws IOException{
        Button button = (Button) event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        this.checkUserAndPassword(stage);
    }

    public void checkUserAndPassword(Stage stage) throws IOException {
        if (passwordTextField.getText().toLowerCase().equals("staff") && staffButton.isMnemonicParsing()){
            loginComplete(stage);
        }
        else if (passwordTextField.getText().toLowerCase().equals("pipo") && pipoButton.isMnemonicParsing()){
            loginComplete(stage);
        }

        else if (staffButton.isMnemonicParsing()&& passwordTextField.getText().toLowerCase().equals("")
                || pipoButton.isMnemonicParsing() && passwordTextField.getText().toLowerCase().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "กรุณากรอกรหัสผ่าน", ButtonType.CLOSE);
            Optional optional = alert.showAndWait();
        }

        else if (staffButton.isMnemonicParsing() && !passwordTextField.getText().toLowerCase().equals("staff")
                || pipoButton.isMnemonicParsing() && !passwordTextField.getText().toLowerCase().equals("pipo")) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "รหัสผ่านไม่ถูกต้อง", ButtonType.CLOSE);
            Optional optional = alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "กรุณาเลือกหน่วยงาน", ButtonType.CLOSE);
            Optional optional = alert.showAndWait();
        }
    }

    public void loginComplete(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../portin.fxml"));
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }



}
