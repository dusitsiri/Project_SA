package controllers;

import database.DBMemberOfShip;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.MembersOfShip;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ControllerRecordPortOut {

    Stage stage;
    DBMemberOfShip dbMemberOfShip = new DBMemberOfShip();
    int countAddMembers = 0;
    LocalDate dateportOut,birthdate;
    @FXML private TableView<MembersOfShip> membersOfShipTableView;
    @FXML private TextField numberOfShipTextField,nameOfShipTextField,hoursTextField,minutesTextField,
            typeOfShip,nameTextField,positionOfMemberTextField;
    @FXML private RadioButton maleRadioBtn,femaleRadioBtn;
    @FXML private DatePicker dateportOutPicker,birthdayPicker;

    //init
    public void initialize(){
        dateportOutPicker.setOnAction((ActionEvent event) ->{
            dateportOut = dateportOutPicker.getValue();
        });
        dateportOutPicker.setOnAction((ActionEvent event) ->{
            dateportOut = dateportOutPicker.getValue();
        });
        System.out.println(dateportOut);
        System.out.println(birthdate);
    }

    //Scenario : Add ship
    public void addShip(){
        int numberShip = Integer.parseInt(numberOfShipTextField.getText());
        String nameShip = nameOfShipTextField.getText();
        String datePI = dateportOut.toString();
        String time = hoursTextField.getText()+":"+minutesTextField.getText();
        String typeShip = typeOfShip.getText();
        System.out.print(nameShip);
        System.out.println(datePI);
        System.out.println(time);
        System.out.println(typeShip);
    }


    //Sccenario : Add members
    public void clickAddMember(ActionEvent event){
        int number = dbMemberOfShip.getCreateNumber();
        int numberOfMembers = setNumberOfMembers(countAddMembers);
        String name = nameTextField.getText();
        System.out.println("name+"+name);
        String position =  positionOfMemberTextField.getText();
//        String gender = checkGender();
//        String birthday = birthdate.toString();
        System.out.println("number+"+number );
        System.out.println("numberofmember+"+numberOfMembers );

        System.out.println("position+"+position);
        System.out.println("dateofpick+"+dateportOut);
//        System.out.println(gender);
//        System.out.println(birthday);
//        dbMemberOfShip.addMembersToDB(number, numberOfMembers, name, position, gender, birthday);
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
//    public String checkGender(){
//        String gender = "";
//        if (maleRadioBtn.isSelected()) gender = "M";
//        else gender = "F";
//        return gender;
//    }
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
