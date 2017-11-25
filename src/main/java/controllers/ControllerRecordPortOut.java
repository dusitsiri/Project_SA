package controllers;

import database.DBMemberOfShip;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ControllerRecordPortOut {

    DBMemberOfShip dbMemberOfShip = new DBMemberOfShip();

    @FXML private TableView membersOfShipTableView;
    @FXML private TextField nameTextField,positionTextField,genderTextField,birthdayTextField;

    public void clickAddMember(ActionEvent event){
        int number = dbMemberOfShip.getCreateNumber();
        int numberOfMembers = dbMemberOfShip.getCreateNumberOfPipoReport();
        dbMemberOfShip.addMembersToDB(number, numberOfMembers, nameTextField.getText(),positionTextField.getText(),
                genderTextField.getText(),birthdayTextField.getText());
    }
}
