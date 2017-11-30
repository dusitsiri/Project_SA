package controllers;

import database.DBMemberOfShip;
import database.DBProducts;
import database.DBShip;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import models.Ships;

import java.io.IOException;
import java.util.Optional;

public class ControllerOrganizeData {
    Stage stage;
    @FXML
    private TableView<Ships> shipsTableView;
    @FXML
    private TextField pipoNumberTextField;
    DBShip dbShip = ControllerRecordPortIn.dbShip;
    DBMemberOfShip dbMemberOfShip = ControllerRecordPortIn.dbMemberOfShip;
    DBProducts dbProducts = ControllerRecordPortIn.dbProducts;
    ObservableList<Ships> loadShips = dbShip.loadDBShips();
    ObservableList<Ships> setShip = FXCollections.observableArrayList();

    public void initialize() {
        pipoNumberTextField.requestFocus();
        pipoNumberTextField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    searchPipoNumber();
                    pipoNumberTextField.setText("");
                    pipoNumberTextField.requestFocus();
                }
            }
        });
        shipsTableView.setItems(setShip);
    }

    public void searchPipoNumber() {
        for (Ships ships : loadShips) {
            if (Integer.parseInt(pipoNumberTextField.getText()) == ships.getNopipo()) {
                if (setShip.size() == 0){
                    setShip.add(new Ships(ships.getNopipo(), ships.getPipo(), ships.getNoship(),
                            ships.getNameship(), ships.getTypeship(), ships.getDate(), ships.getTime()));
                }
                else  if (setShip.size() > 0){
                    setShip.clear();
                    setShip.add(new Ships(ships.getNopipo(), ships.getPipo(), ships.getNoship(),
                            ships.getNameship(), ships.getTypeship(), ships.getDate(), ships.getTime()));
                }
            }
        }
        pipoNumberTextField.setText("");
        pipoNumberTextField.requestFocus();
    }

    public void deleteShip(ActionEvent event) throws IOException {
        int noPipo = setShip.get(0).getNopipo();
        dbShip.deleteShipInDB(noPipo);
        dbMemberOfShip.deleteMemberInDB(noPipo);
        dbProducts.deleteProductInDB(noPipo);
        refresh(event);
    }

    public void setStage(ActionEvent event) {
        Button button = (Button) event.getSource();
        stage = (Stage) button.getScene().getWindow();
    }

    public void refresh(ActionEvent event) throws IOException {
        setStage(event);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/organizedata.fxml"));
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }

    public void backToMainView(ActionEvent event) throws IOException {
        setStage(event);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainview.fxml"));
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }

}
