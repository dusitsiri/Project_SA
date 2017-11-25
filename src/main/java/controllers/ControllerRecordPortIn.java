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
import java.util.Optional;

public class ControllerRecordPortIn {
    Stage stage;
    @FXML
    TextField portInHour, portInMinute, portInShipNumber, portInTypeShip, portInNameShip, portInNameDriver, portInNumberSeaMan;
    @FXML
    Button btnLongOut,btnDelete,btnDeleteAll;
    @FXML
    DatePicker portInDate;
    @FXML
    TableView<PortIn> tablePortIn;

    DatabaseHarbor databaseHarbor = new DatabaseHarbor();
//    ArrayList<PortIn> library = new ArrayList<>();
//    int row = 1;


//    public void initialize() throws SQLException {
//        tablePortIn.setItems(databaseHarbor.loadDatabase());
//
//    }

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

    public void OnActionbtnLogOut(ActionEvent event) throws IOException {
        setStage(event);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/login.fxml"));
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }

    public void refreshPage(ActionEvent event) throws IOException {
        setStage(event);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/recordportin.fxml"));
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }

    public void setStage(ActionEvent event){
        Button button = (Button) event.getSource();
        stage = (Stage) button.getScene().getWindow();
    }
}
