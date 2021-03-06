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
    @FXML private PasswordField passwordField;
    @FXML private Label passwordLabel;
    @FXML private Button staffButton;
    @FXML private Button pipoButton;
    @FXML private Button loginButton;
    static String user = null;

    public void initialize(){
        staffButton.setOnMouseClicked((MouseEvent e) -> {
            setOption();
            staffButton.setMnemonicParsing(true);
            pipoButton.setMnemonicParsing(false);
            staffButton.setDisable(true);
            pipoButton.setDisable(false);
            user = "staff";
        });
        pipoButton.setOnMouseClicked((MouseEvent e) -> {
            setOption();
            pipoButton.setMnemonicParsing(true);
            staffButton.setMnemonicParsing(false);
            pipoButton.setDisable(true);
            staffButton.setDisable(false);
            user = "pipo";
        });
        passwordField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER){
                    PasswordField passwordField = (PasswordField) event.getSource();
                    Stage stage = (Stage) passwordField.getScene().getWindow();
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
        showBlockInputPassword();
        passwordField.setText("");
        passwordField.requestFocus();
    }

    public void showBlockInputPassword(){
        passwordLabel.setVisible(true);
        passwordField.setVisible(true);
    }

    public void loginOnClick(ActionEvent event) throws IOException{
        Button button = (Button) event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        this.checkUserAndPassword(stage);
    }

    public void checkUserAndPassword(Stage stage) throws IOException {
        if (passwordField.getText().toLowerCase().equals("staff") && staffButton.isMnemonicParsing()){
            loginComplete(stage);
        }
        else if (passwordField.getText().toLowerCase().equals("pipo") && pipoButton.isMnemonicParsing()){
            loginComplete(stage);
        }

        else if (staffButton.isMnemonicParsing()&& passwordField.getText().toLowerCase().equals("")
                || pipoButton.isMnemonicParsing() && passwordField.getText().toLowerCase().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "กรุณากรอกรหัสผ่าน", ButtonType.CLOSE);
            Optional optional = alert.showAndWait();
        }

        else if (staffButton.isMnemonicParsing() && !passwordField.getText().toLowerCase().equals("staff")
                || pipoButton.isMnemonicParsing() && !passwordField.getText().toLowerCase().equals("pipo")) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "รหัสผ่านไม่ถูกต้อง", ButtonType.CLOSE);
            Optional optional = alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "กรุณาเลือกหน่วยงาน", ButtonType.CLOSE);
            Optional optional = alert.showAndWait();
        }
    }

    public void loginComplete(Stage stage) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "รหัสผ่านถูกต้อง", ButtonType.OK);
        Optional optional = alert.showAndWait();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../mainview.fxml"));
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }



}
