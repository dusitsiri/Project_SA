package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerMainView {
    Stage stage;
    @FXML private Button  btnRecordPortIn,btnRecordPortOut,
            btnReportPortOutNextDay,btnReportPipoDaily;

    public void setStage(ActionEvent event){
        Button button = (Button) event.getSource();
        stage = (Stage) button.getScene().getWindow();
    }
    public void recordPortIn(ActionEvent event) throws IOException{
        setStage(event);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../portin.fxml"));
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }

    public void recordPortOut(ActionEvent event) throws IOException {
        setStage(event);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../portout.fxml"));
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

}
