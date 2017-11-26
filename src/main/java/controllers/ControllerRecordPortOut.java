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
import java.util.Optional;

public class ControllerRecordPortOut {
    Stage stage;
    private int countNumberMember = 1;
    private int countNumberOfPipo = 0;
    LocalDate datePortOut,birthDate;
    @FXML private TableView<MembersOfShip> membersOfShipTableView;
    @FXML private TextField numberOfShipTextField,nameOfShipTextField,hoursTextField,minutesTextField,
            typeOfShip,nameOfMemberTextField,positionTextField,nameOfProductTextField,typeOfProductTextField,quantityOfProductTextField;
    @FXML private RadioButton maleRadioBtn,femaleRadioBtn;
    @FXML private DatePicker datePortOutPicker,birthdayPicker;
    DBMemberOfShip dbMemberOfShip = new DBMemberOfShip();
    ObservableList<MembersOfShip> membersList = FXCollections.observableArrayList();

    //init
    public void initialize(){
        datePortOutPicker.setOnAction((ActionEvent event) ->{
            datePortOut = datePortOutPicker.getValue();
        });
        birthdayPicker.setOnAction((ActionEvent event) ->{
            birthDate = birthdayPicker.getValue();
        });
        maleRadioBtn.setOnAction((ActionEvent event) -> {

        });
        femaleRadioBtn.setOnAction((ActionEvent event) -> {

        });
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
    public void clickAddMember() {
        int number = setNumber(countNumberMember);
        int numberOfMembers = 1;
        String name = nameOfMemberTextField.getText();
        String position = positionTextField.getText();
        String gender = checkGender();
        String birthday = birthDate.toString();
        membersList.add(new MembersOfShip(number, numberOfMembers, name, position, gender, birthday));
        membersOfShipTableView.setItems(membersList);
        int row = membersList.size() - 1;
        membersOfShipTableView.getSelectionModel().select(row);
        membersOfShipTableView.getFocusModel().focus(row);
    }

    public void setCountNumberMember(int countNumberMember){
        this.countNumberMember = countNumberMember+1;
    }

    public int setNumber(int countNumberMember) {
        if (membersOfShipTableView.getSelectionModel().getSelectedItem() != null) {
            setCountNumberMember(countNumberMember);
            return countNumberMember+1;
        }
        return countNumberMember;
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
