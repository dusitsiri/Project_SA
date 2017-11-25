package controllers;

import Harbor.PortIn;
import database.DBMemberOfShip;
import database.DatabaseHarbor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ControllerRecordPortIn {
    Stage stage;
    int countAddMembers = 0;
    LocalDate datePortIn,birthDate;
    @FXML private TableView<MembersOfShip> membersOfShipTableView;
    @FXML private TextField numberOfShipTextField,nameOfShipTextField,hoursTextField,minutesTextField,
            typeOfShip,nameOfMemberTextField,positionTextField,nameOfProductTextField,typeOfProductTextField
            ,quantityOfProductTextField;
    @FXML private RadioButton maleRadioBtn,femaleRadioBtn;
    @FXML private DatePicker datePortInPicker,birthdayPicker;
    DBMemberOfShip dbMemberOfShip = new DBMemberOfShip();
    ObservableList<MembersOfShip> membersList = FXCollections.observableArrayList();

    //init
    public void initialize(){
        datePortInPicker.setOnAction((ActionEvent event) ->{
            datePortIn = datePortInPicker.getValue();
        });
        birthdayPicker.setOnAction((ActionEvent event) ->{
            birthDate = birthdayPicker.getValue();
        });
    }

    //Scenario : Add ship
    public void addShip(){
        int numberShip = Integer.parseInt(numberOfShipTextField.getText());
        String nameShip = nameOfShipTextField.getText();
        String datePI = datePortIn.toString();
        String time = hoursTextField.getText()+":"+minutesTextField.getText();
        String typeShip = typeOfShip.getText();
    }


    //Sccenario : Add members
    public void clickAddMember(){
        int number = dbMemberOfShip.getCreateNumber();
        int numberOfMembers = setNumberOfMembers(countAddMembers);
        String name = nameOfMemberTextField.getText();
        String position =  positionTextField.getText();
        String gender = checkGender();
        String birthday = birthDate.toString();
        membersList.add(new MembersOfShip(number,numberOfMembers,name,position,gender,birthday));
        membersOfShipTableView.setItems(membersList);

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
        else if (femaleRadioBtn.isSelected())gender = "F";
        return gender;
    }

    //Scenario : Add products
    public void clickAddProduct(){
        String nameProduct = nameOfProductTextField.getText();
        String typeProduct = typeOfProductTextField.getText();
        int quantityProduct = Integer.parseInt(quantityOfProductTextField.getText());
    }

    //Scenario : Log out
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
