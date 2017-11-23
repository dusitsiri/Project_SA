package controllers;

import Harbor.PortIn;
import database.DatabaseHarbor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public class ControllerPortIn {
    @FXML
    TextField portInHour, portInMinute, portInShipNumber, portInTypeShip, portInNameShip, portInNameDriver, portInNumberSeaMan;
    @FXML
    Button btnPortIn,btnEditProduct,btnPortOut,btnRePort,btnPrintPipo,btnLongOut,btnDelete,btnDeleteAll;
    @FXML
    DatePicker portInDate;
    @FXML
    TableView<PortIn> tablePortIn;

    DatabaseHarbor databaseHarbor = new DatabaseHarbor();
//    ArrayList<PortIn> library = new ArrayList<>();
//    int row = 1;


    public void initialize() throws SQLException {
        tablePortIn.setItems(databaseHarbor.loadDatabase());

    }

    public void onActionbtnPortIn(ActionEvent event) {
        String type = portInTypeShip.getText();
        String hour = portInHour.getText();
        String minute = portInMinute.getText();
        String nameDriver  = portInNameDriver.getText();

        String nameShip = portInNameShip.getText();
        String numberSeaMan = portInNumberSeaMan.getText();
        String numberShip = portInShipNumber.getText();
        String date = portInDate.getEditor().getText();
        if (type.equals("") || hour.equals("") || minute.equals("") || nameDriver.equals("") || nameShip.equals("") || numberSeaMan.equals("")||numberShip.equals("") || date.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please fill in the blank.");
        }
        else {
            PortIn portIn = new PortIn(date, hour + ":" + minute, numberShip, type, nameShip, nameDriver, Integer.parseInt(numberSeaMan));
            this.addToLibrary(portIn);

//        tablePortIn.edit;
        }
    }
    public void addToLibrary(PortIn portIn)
    {
//        library.add(portIn);
        try {
            databaseHarbor.saveDatabase(portIn.getDatePortIn(), portIn.getTimePortIn(), portIn.getShipNumber(), portIn.getTypeShip(), portIn.getNameShip(), portIn.getNameDriver(), portIn.getNumberOfSeaman());
            tablePortIn.setItems(databaseHarbor.loadDatabase());

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

//        columnDate.setCellValueFactory(new PropertyValueFactory<>(portIn.getDatePortIn()));

    }


//    public ArrayList<PortIn> getLibrary() {
//        return library;
//    }
    public void onActionbtnDeleteProduct(ActionEvent event) throws IOException {
        if (tablePortIn.getSelectionModel().getSelectedItem() != null && event.getSource().equals(btnDelete)){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to delete " + tablePortIn.getSelectionModel().getSelectedItem().getNameShip() + "?",
                    ButtonType.OK, ButtonType.CANCEL);
            Optional optional = alert.showAndWait();
            if (optional.get() == ButtonType.OK){
                databaseHarbor.deleteDatabase(tablePortIn.getSelectionModel().getSelectedItem().getShipNumber());
                this.refreshPage(event);
            }
        }
        else if (tablePortIn.getSelectionModel().getSelectedItem() == null && event.getSource().equals(btnDeleteAll)){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to delete all information?",
                    ButtonType.OK, ButtonType.CANCEL);
            Optional optional = alert.showAndWait();
            if (optional.get() == ButtonType.OK){
                databaseHarbor.deleteAllDatabase();
                this.refreshPage(event);
            }
        }
    }

    public void onActionbtnEditProduct(ActionEvent event) {
    }

    public void onActionbtnPortOut(ActionEvent event) {
    }

    public void onActionbtnRePort(ActionEvent event) {
    }

    public void onActionbtnPrintPipo(ActionEvent event) {
    }

    public void OnActionbtnLongOut(ActionEvent event) {

    }

    public void refreshPage(ActionEvent event) throws IOException {
        Button button = (Button) event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/portin.fxml"));
        stage.setScene(new Scene(loader.load(), 1600, 900));
        stage.show();
    }
}
