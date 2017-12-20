package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class ControllerMainView {
    Stage stage;
    @FXML private Button  btnRecordPortIn,btnRecordPortOut,
            btnReportPortOutNextDay,btnReportPipoDaily,btnOrganizeData;

    public void initialize(){
        if (ControllerLogin.user.equals("pipo")){
            btnRecordPortIn.setDisable(true);
            btnRecordPortOut.setDisable(true);
        }
    }

    public void setStage(ActionEvent event){
        Button button = (Button) event.getSource();
        stage = (Stage) button.getScene().getWindow();
    }
    public void recordPortIn(ActionEvent event) throws IOException{
        setStage(event);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../recordshipportin.fxml"));
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }

    public void recordPortOut(ActionEvent event) throws IOException {
        setStage(event);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../recordshipportout.fxml"));
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }

    public void showReportOfPortOutNextDay(ActionEvent event) throws IOException{
        setStage(event);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../reportportoutnextday.fxml"));
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }

    public void showReportPortInPortOutOfDaily(ActionEvent event) throws IOException {
        setStage(event);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../reportpipodaily.fxml"));
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }

    public void clickedOrganizeData(ActionEvent event) throws IOException {
        setStage(event);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../organizedata.fxml"));
        stage.setScene(new Scene(loader.load()));
        stage.show();
        Alert alert =  new Alert(Alert.AlertType.WARNING, "กรุณากรอกเลขใบ PIPO", ButtonType.CLOSE);
        Optional optional = alert.showAndWait();

    }
}
