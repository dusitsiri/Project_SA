package controllers;

import database.DBMemberOfShip;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import models.MembersOfShip;

import java.time.LocalDate;
import java.util.ArrayList;

public class ControllerRecordPortOut {

    DBMemberOfShip dbMemberOfShip = new DBMemberOfShip();
    int countAddMembers = 0;
    LocalDate birthdate;
    @FXML private TableView<MembersOfShip> membersOfShipTableView;
    @FXML private TextField nameTextField,positionTextField;
    @FXML private RadioButton maleRadioBtn,femaleRadioBtn;
    @FXML private DatePicker birthdayPicker;

    public void initialize(){
        birthdayPicker.setOnAction((ActionEvent event) ->{
            birthdate = birthdayPicker.getValue();
        });

    }
    public void clickAddMember(){
        int number = dbMemberOfShip.getCreateNumber();
        int numberOfMembers = setNumberOfMembers(countAddMembers);
        String name = nameTextField.getText();
        String position =  positionTextField.getText();
        String gender = checkGender();
        String birthday = birthdate.toString();
        dbMemberOfShip.addMembersToDB(number, numberOfMembers, name, position, gender, birthday);
    }

    public int setNumberOfMembers(int countAddMembers){
        int numberOfMembers = 0;
        if (countAddMembers == 0){
            numberOfMembers = dbMemberOfShip.getCreateNumberOfPipoReport();
            countAddMembers++;
        }
        else {
            numberOfMembers = membersOfShipTableView.getSelectionModel().getSelectedItem().getNumberOfPipoReport();
        }
        return numberOfMembers;
    }

    public String checkGender(){
        String gender = "";
        if (maleRadioBtn.isSelected()) gender = "M";
        else gender = "F";
        return gender;
    }
}
