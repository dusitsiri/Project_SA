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

public class ControllerRecordPortOut {
    Stage stage;
    DBMemberOfShip dbMemberOfShip = new DBMemberOfShip();
    int countAddMembers = 0;
    LocalDate datePortOut,birthDate;
    @FXML private TableView<MembersOfShip> membersOfShipTableView;
    @FXML private TextField numberOfShipTextField,nameOfShipTextField,hoursTextField,minutesTextField,
            typeOfShip,nameOfMemberTextField,positionTextField,nameOfProductTextField,typeOfProductTextField
            ,quantityOfProductTextField;
    @FXML private RadioButton maleRadioBtn,femaleRadioBtn;
    @FXML private DatePicker datePortOutPicker,birthdayPicker;

    //init
    public void initialize(){
        datePortOutPicker.setOnAction((ActionEvent event) ->{
            datePortOut = datePortOutPicker.getValue();
        });
        birthdayPicker.setOnAction((ActionEvent event) ->{
            birthDate = birthdayPicker.getValue();
        });
        System.out.println(datePortOut);
        System.out.println(birthDate);
    }

    //Scenario : Add ship
    public void addShip(){
        int numberShip = Integer.parseInt(numberOfShipTextField.getText());
        String nameShip = nameOfShipTextField.getText();
        String datePI = datePortOut.toString();
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
    }
    public int setNumberOfMembers(int countAddMembers){
        int numberOfMembers = 0;
        if (countAddMembers == 0){
            numberOfMembers = dbMemberOfShip.getCreateNumberOfPipoReport();
            countAddMembers++;
        }
        else {
            numberOfMembers = membersOfShipTableView.getSelectionModel().getSelectedItem().getNopipo();
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

    //Scenario : Research ship
    public void searchShip(){

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

    public void canclePortOut(ActionEvent event) throws IOException {
        setStage(event);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainview.fxml"));
        stage.setScene(new Scene(loader.load()));
        stage.show();

    }

    public void savePortOut(ActionEvent event) {
    }
}
