package controllers;

import Harbor.PortIn;
import database.DBMemberOfShip;
import database.DatabaseHarbor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.MembersOfShip;

import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

public class ControllerRecordPortIn {
    Stage stage;
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

        System.out.println(birthdate);
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

    public void OnActionbtnLogOut(ActionEvent event) throws IOException {
        setStage(event);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/login.fxml"));
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }

    public void setStage(ActionEvent event){
        Button button = (Button) event.getSource();
        stage = (Stage) button.getScene().getWindow();
    }
}