package controllers;

import database.DBShip;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import models.Ships;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Calendar;

public class ControllerReportPipoDaily {
    @FXML TableView<Ships> reportPipoDailyTableView;
    DBShip dbShip = new DBShip();
    ObservableList<Ships> loadShip = dbShip.loadDBShips();
    ObservableList<Ships> setShip = FXCollections.observableArrayList();
    Calendar calendar = Calendar.getInstance();

//    public void initialize(){
//        int year = calendar.get(Calendar.YEAR);
//        int month = calendar.get(Calendar.MONTH)+1;
//        int date = calendar.get(Calendar.DATE);
//        LocalDate now = LocalDate.of(year, month, date);
//        for (Ships ships: loadShip){
//            if (ships.getDate().equals(now.toString())){
//                setShip.add(new Ships(ships.getNopipo(),ships.getPipo(),ships.getNoship(),
//                        ships.getNameship(),ships.getTypeship(),ships.getDate(),ships.getTime()));
//            }
//        }
//        reportPipoDailyTableView.setItems(setShip);
//    }

    public void backToMainView(ActionEvent event) throws IOException {
        Button button = (Button) event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader( getClass().getResource( "/mainview.fxml" ) );
        stage.setScene( new Scene( loader.load() ) );
        stage.show();
    }
}
