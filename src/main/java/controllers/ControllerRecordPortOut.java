package controllers;

import com.sun.org.apache.bcel.internal.generic.I2F;
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
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.MembersOfShip;
import models.Products;
import models.Ships;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

public class ControllerRecordPortOut {
    Stage stage;
    private int countNumberMember = 0;
    private int countNumberOfPipo = 0;
    private int countNumberProduct = 0;
    private boolean checkComplete = false;
    private boolean checkDisable = false;
    LocalDate datePortout, birthDate;
    @FXML
    private Button submitBtn, addMemberButton, addProductButton, cancelButton, editButton;
    @FXML
    private TableView<MembersOfShip> membersOfShipTableView;
    @FXML
    private TableView<Products> productsTableView;
    @FXML
    private TextField numberOfShipTextField, nameOfShipTextField, hoursTextField, minutesTextField,
            typeOfShipTextField, nameOfMemberTextField, positionTextField, nameOfProductTextField, typeOfProductTextField, quantityOfProductTextField;
    @FXML
    private Label numberOfShipLabel, nameOfShipLabel, datePortOutLabel, timePortOutLabel, charTimeLabel,
            typeShipLabel, nameOfMemberLabel, positionOfMemberLabel, genderLabel, birthdayLabel, nameOfProductLabel,
            typeOfProductLabel, qtyOfProductLabel;
    @FXML
    private RadioButton maleRadioBtn, femaleRadioBtn;
    @FXML
    private DatePicker datePortoutPicker, birthdayPicker;

    DBShip dbShip = ControllerRecordPortIn.dbShip;
    DBMemberOfShip dbMemberOfShip = ControllerRecordPortIn.dbMemberOfShip;
    DBProducts dbProducts = ControllerRecordPortIn.dbProducts;
    ObservableList<Ships> shipsList = FXCollections.observableArrayList();
    ObservableList<MembersOfShip> membersList = FXCollections.observableArrayList();
    ObservableList<Products> productsList = FXCollections.observableArrayList();

    //init
    public void initialize() {
        noShipTextField.requestFocus();
        datePortoutPicker.setOnAction((ActionEvent event) -> {
            datePortout = datePortoutPicker.getValue();
        });
        birthdayPicker.setOnAction((ActionEvent event) -> {
            birthDate = birthdayPicker.getValue();
        });
        membersOfShipTableView.setItems(membersList);
        membersOfShipTableView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton() == MouseButton.SECONDARY) {
                    deleteMember();
                }
            }
            public void deleteMember() {
                if (membersOfShipTableView.getSelectionModel().getSelectedItem() != null) {
                    membersList.remove(membersOfShipTableView.getSelectionModel().getSelectedIndex());
                    membersOfShipTableView.setItems(membersList);
                }
            }
        });
        productsTableView.setItems(productsList);
        productsTableView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton() == MouseButton.SECONDARY) {
                    deleteProduct();
                }
            }

            public void deleteProduct() {
                if (productsTableView.getSelectionModel().getSelectedItem() != null) {
                    productsList.remove(productsTableView.getSelectionModel().getSelectedIndex());
                    productsTableView.setItems(productsList);
                }
            }
        });
    }

    //Scenario : Add ship
    public void addShip() {
        if (numberOfShipTextField.getText() != null && nameOfShipTextField.getText() != null &&
                typeOfShipTextField.getText() != null && datePortoutPicker.getValue() != null) {
            int nopipo = dbShip.getCreateNoPipo();
            String pipo = "PO";
            String numberShip = numberOfShipTextField.getText();
            String nameShip = nameOfShipTextField.getText();
            String typeShip = typeOfShipTextField.getText();
            String datePi = datePortout.toString();
            String time = hoursTextField.getText() + ":" + minutesTextField.getText();
            dbShip.addShipToDB(nopipo, pipo, numberShip, nameShip, typeShip, datePi, time);
        }
    }


    //Sccenario : Add members
    public void clickAddMember() {
        int number = setNumber();
        int numberOfMembers = dbShip.getCreateNoPipo();
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

    public int setNumber() {
        if (membersOfShipTableView.getSelectionModel().getSelectedItem() == null) {
            this.countNumberMember = dbMemberOfShip.getCreateNumber();
        } else {
            this.countNumberMember = membersOfShipTableView.getSelectionModel().getSelectedItem().getNumber() + 1;
        }
        return countNumberMember;
    }

    public String checkGender() {
        String gender = "";
        if (maleRadioBtn.isSelected()) gender = "M";
        else if (femaleRadioBtn.isSelected()) gender = "F";
        return gender;
    }


    //Scenario : Add products
    public void clickAddProduct() {
        int noProduct = setNoProduct();
        int noPipo = dbShip.getCreateNoPipo();
        String nameProduct = nameOfProductTextField.getText();
        String typeProduct = typeOfProductTextField.getText();
        String quantityProduct = quantityOfProductTextField.getText();
        productsList.add(new Products(noProduct, noPipo, nameProduct, typeProduct, quantityProduct));
        productsTableView.setItems(productsList);
        int row = productsList.size() - 1;
        productsTableView.getSelectionModel().select(row);
        productsTableView.getFocusModel().focus(row);
    }

    public int setNoProduct() {
        if (productsTableView.getSelectionModel().getSelectedItem() == null) {
            this.countNumberProduct = dbProducts.getCreateNumber();
        } else {
            this.countNumberProduct = productsTableView.getSelectionModel().getSelectedItem().getNo() + 1;
        }
        return countNumberProduct;
    }


    //Scenario : Log out
    public void OnActionbtnLogOut(ActionEvent event) throws IOException {
        setStage(event);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/login.fxml"));
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }

    public void setStage(ActionEvent event) {
        Button button = (Button) event.getSource();
        stage = (Stage) button.getScene().getWindow();
    }

    //Scenario : Cancel Port Out
    public void cancelPortout(ActionEvent event) throws IOException {
        setStage(event);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainview.fxml"));
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }

    //Scenario : Edit data
    public void editData() {
        numberOfShipTextField.setDisable(false);
        nameOfShipTextField.setDisable(false);
        datePortoutPicker.setDisable(false);
        hoursTextField.setDisable(false);
        minutesTextField.setDisable(false);
        typeOfShipTextField.setDisable(false);
        nameOfMemberTextField.setDisable(false);
        positionTextField.setDisable(false);
        maleRadioBtn.setDisable(false);
        femaleRadioBtn.setDisable(false);
        birthdayPicker.setDisable(false);
        nameOfProductTextField.setDisable(false);
        typeOfProductTextField.setDisable(false);
        quantityOfProductTextField.setDisable(false);
        checkDisable = false;
        submitBtn.setText("บันทึกการแจ้งเรือออก");
    }

    //Scenario : Save Port Out
    public void savePortOut() {
        if (checkComplete == false && checkDisable == false) {
            numberOfShipTextField.setDisable(true);
            nameOfShipTextField.setDisable(true);
            datePortoutPicker.setDisable(true);
            hoursTextField.setDisable(true);
            minutesTextField.setDisable(true);
            typeOfShipTextField.setDisable(true);
            nameOfMemberTextField.setDisable(true);
            positionTextField.setDisable(true);
            maleRadioBtn.setDisable(true);
            femaleRadioBtn.setDisable(true);
            birthdayPicker.setDisable(true);
            nameOfProductTextField.setDisable(true);
            typeOfProductTextField.setDisable(true);
            quantityOfProductTextField.setDisable(true);
            checkDisable = true;
            submitBtn.setText("ยืนยันข้อมูล");
        } else if (checkDisable == true && checkComplete == false) {
            recordPortOutComplete();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "บันทึกเรียบร้อย", ButtonType.OK);
            Optional optional = alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "กรุณากรอกข้อมูลให้ครบถ้วน", ButtonType.CLOSE);
            Optional optional = alert.showAndWait();
        }
    }

    public void recordPortOutComplete() {
        if (!numberOfShipTextField.getText().equals("") && !nameOfShipTextField.getText().equals("")
                && !hoursTextField.getText().equals("") && !minutesTextField.getText().equals("")
                && !typeOfShipTextField.getText().equals("") && datePortoutPicker.getValue() != null
                && membersOfShipTableView.getItems() != null) {
            addShip();
            addMembers();
            addProducts();
            membersList.clear();
            productsList.clear();
            membersOfShipTableView.setItems(membersList);
            productsTableView.setItems(productsList);
            numberOfShipTextField.setDisable(true);
        }
    }

    public void addMembers() {
        if (membersList.size() > 0) {
            for (MembersOfShip members : membersList) {
                dbMemberOfShip.addMembersToDB(members.getNumber(), members.getNopipo(), members.getName(),
                        members.getPosition(), members.getGender(), members.getBirthday());
            }
        }
    }

    public void addProducts() {
        if (productsList.size() > 0) {
            for (Products products : productsList) {
                dbProducts.addProductToDB(products.getNo(), products.getNopipo(), products.getNameproduct(),
                        products.getTypeproduct(), products.getQtyproduct());
            }
        }
    }

    @FXML
    private TextField noShipTextField;
    private Boolean checkNoShip = false;
    //Scenario : search ship
    public void searchShip() {
        String noship = noShipTextField.getText();
        ObservableList<Ships> identificationOfShip = dbShip.loadDBShips();
        for (Ships ships : identificationOfShip) {
            if (ships.getNoship().equals(noship)) {
                this.checkNoShip = true;
            }
        }
        if (checkNoShip == true) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "พบเลขเรือ", ButtonType.OK);
            Optional optional = alert.showAndWait();
            numberOfShipTextField.setText(noship);
            numberOfShipLabel.setVisible(true);
            numberOfShipTextField.setVisible(true);
            nameOfShipLabel.setVisible(true);
            nameOfShipTextField.setVisible(true);
            datePortOutLabel.setVisible(true);
            datePortoutPicker.setVisible(true);
            timePortOutLabel.setVisible(true);
            hoursTextField.setVisible(true);
            charTimeLabel.setVisible(true);
            minutesTextField.setVisible(true);
            typeShipLabel.setVisible(true);
            typeOfShipTextField.setVisible(true);
            membersOfShipTableView.setVisible(true);
            nameOfMemberLabel.setVisible(true);
            nameOfMemberTextField.setVisible(true);
            positionOfMemberLabel.setVisible(true);
            positionTextField.setVisible(true);
            genderLabel.setVisible(true);
            maleRadioBtn.setVisible(true);
            femaleRadioBtn.setVisible(true);
            birthdayLabel.setVisible(true);
            birthdayPicker.setVisible(true);
            addMemberButton.setVisible(true);
            productsTableView.setVisible(true);
            nameOfProductLabel.setVisible(true);
            nameOfProductTextField.setVisible(true);
            typeOfProductLabel.setVisible(true);
            typeOfProductTextField.setVisible(true);
            qtyOfProductLabel.setVisible(true);
            quantityOfProductTextField.setVisible(true);
            addProductButton.setVisible(true);
            cancelButton.setVisible(true);
            submitBtn.setVisible(true);
            editButton.setVisible(true);
        } else if (checkNoShip == false && noShipTextField.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "กรุณากรอกเลขเรือ", ButtonType.CLOSE);
            Optional optional = alert.showAndWait();
            noShipTextField.setText("");
            noShipTextField.requestFocus();
        } else if (checkNoShip == false && noShipTextField.getText() != null) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "ไม่พบเลขเรือ", ButtonType.CLOSE);
            Optional optional = alert.showAndWait();
            noShipTextField.setText("");
            noShipTextField.requestFocus();
        }
    }
}
