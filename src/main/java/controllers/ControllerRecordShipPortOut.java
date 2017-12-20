package controllers;

import database.DBMemberOfShip;
import database.DBProducts;
import database.DBShip;
import database.DBShipPipo;
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
import java.util.Calendar;
import java.util.Optional;

public class ControllerRecordShipPortOut {
    Stage stage;
    private int countNumberOfPipo = 0;
    LocalDate datePortOut;
    String[] datePOArray;
    @FXML
    private Button submitBtn;
    @FXML
    private Label numberPipoLabel, unitShip;
    @FXML
    private TextField numberOfShipTextField, nameOfShipTextField, sizeOfShipTextField;
    @FXML
    private DatePicker datePortOutPicker;
    @FXML
    private MenuButton hoursMenu, minutesMenu, typeOfShip;
    @FXML
    private MenuItem h00, h01, h02, h03, h04, h05, h06, h07, h08, h09, h10, h11, h12, h13, h14, h15, h16, h17, h18, h19,
            h20, h21, h22, h23, m00, m01, m02, m03, m04, m05, m06, m07, m08, m09, m10, m11, m12, m13, m14, m15, m16, m17, m18,
            m19, m20, m21, m22, m23, m24, m25, m26, m27, m28, m29, m30, m31, m32, m33, m34, m35, m36, m37, m38, m39, m40, m41, m42, m43, m44, m45,
            m46, m47, m48, m49, m50, m51, m52, m53, m54, m55, m56, m57, m58, m59,tp1,tp2,tp3,tp4,tp5,tp6,tp7,tp8;
    @FXML
    private String hoursText, minutesText, typeShipText;


    static DBShip dbShip = new DBShip();
    static DBShipPipo dbShipPipo = new DBShipPipo();
    static ObservableList<Ships> shipsList = FXCollections.observableArrayList();
    static Calendar calendar = Calendar.getInstance();
    static int year = calendar.get(Calendar.YEAR);
    static int month = calendar.get(Calendar.MONTH) + 1;
    static int date = calendar.get(Calendar.DATE);

    //init
    public void initialize() {
        numberPipoLabel.setText(String.valueOf(dbShip.getCreateNoPipo()));
        datePortOutPicker.setOnAction((ActionEvent event) -> {
            if (datePortOutPicker.getValue() != null) {
                datePOArray = datePortOutPicker.getValue().toString().split("-");
                if (Integer.parseInt(datePOArray[0]+"" + datePOArray[1]+"" + datePOArray[2]) <= Integer.parseInt(year + "" + month + "" + date) + 3
                        && Integer.parseInt(datePOArray[0]+"" + datePOArray[1] +""+ datePOArray[2]) >= Integer.parseInt(year + "" + month + "" + date)) {
                    datePortOut = datePortOutPicker.getValue();
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "กรุณาเลือกวันที่ใหม่อีกครั้ง", ButtonType.CLOSE);
                    Optional optional = alert.showAndWait();
                    datePortOutPicker.setValue(null);
                }
            }
        });
    }

    public void chooseHours(ActionEvent event) {
        if (event.getTarget().equals(h00)) {
            hoursText = h00.getText();
        } else if (event.getTarget().equals(h01)) {
            hoursText = h01.getText();
        } else if (event.getTarget().equals(h02)) {
            hoursText = h02.getText();
        } else if (event.getTarget().equals(h03)) {
            hoursText = h03.getText();
        } else if (event.getTarget().equals(h04)) {
            hoursText = h04.getText();
        } else if (event.getTarget().equals(h05)) {
            hoursText = h05.getText();
        } else if (event.getTarget().equals(h06)) {
            hoursText = h06.getText();
        } else if (event.getTarget().equals(h07)) {
            hoursText = h07.getText();
        } else if (event.getTarget().equals(h08)) {
            hoursText = h08.getText();
        } else if (event.getTarget().equals(h09)) {
            hoursText = h09.getText();
        } else if (event.getTarget().equals(h10)) {
            hoursText = h10.getText();
        } else if (event.getTarget().equals(h11)) {
            hoursText = h11.getText();
        } else if (event.getTarget().equals(h12)) {
            hoursText = h12.getText();
        } else if (event.getTarget().equals(h13)) {
            hoursText = h13.getText();
        } else if (event.getTarget().equals(h14)) {
            hoursText = h14.getText();
        } else if (event.getTarget().equals(h15)) {
            hoursText = h15.getText();
        } else if (event.getTarget().equals(h16)) {
            hoursText = h16.getText();
        } else if (event.getTarget().equals(h17)) {
            hoursText = h17.getText();
        } else if (event.getTarget().equals(h18)) {
            hoursText = h18.getText();
        } else if (event.getTarget().equals(h19)) {
            hoursText = h19.getText();
        } else if (event.getTarget().equals(h20)) {
            hoursText = h20.getText();
        } else if (event.getTarget().equals(h21)) {
            hoursText = h21.getText();
        } else if (event.getTarget().equals(h22)) {
            hoursText = h22.getText();
        } else if (event.getTarget().equals(h23)) {
            hoursText = h23.getText();
        }
        hoursMenu.setText(hoursText);
    }

    public void chooseMinutes(ActionEvent event) {
        if (event.getTarget().equals(m00)) {
            minutesText = m00.getText();
        } else if (event.getTarget().equals(m01)) {
            minutesText = m01.getText();
        } else if (event.getTarget().equals(m02)) {
            minutesText = m02.getText();
        } else if (event.getTarget().equals(m03)) {
            minutesText = m03.getText();
        } else if (event.getTarget().equals(m04)) {
            minutesText = m04.getText();
        } else if (event.getTarget().equals(m05)) {
            minutesText = m05.getText();
        } else if (event.getTarget().equals(m06)) {
            minutesText = m06.getText();
        } else if (event.getTarget().equals(m07)) {
            minutesText = m07.getText();
        } else if (event.getTarget().equals(m08)) {
            minutesText = m08.getText();
        } else if (event.getTarget().equals(m09)) {
            minutesText = m09.getText();
        } else if (event.getTarget().equals(m10)) {
            minutesText = m10.getText();
        } else if (event.getTarget().equals(m11)) {
            minutesText = m11.getText();
        } else if (event.getTarget().equals(m12)) {
            minutesText = m12.getText();
        } else if (event.getTarget().equals(m13)) {
            minutesText = m13.getText();
        } else if (event.getTarget().equals(m14)) {
            minutesText = m14.getText();
        } else if (event.getTarget().equals(m15)) {
            minutesText = m15.getText();
        } else if (event.getTarget().equals(m16)) {
            minutesText = m16.getText();
        } else if (event.getTarget().equals(m17)) {
            minutesText = m17.getText();
        } else if (event.getTarget().equals(m18)) {
            minutesText = m18.getText();
        } else if (event.getTarget().equals(m19)) {
            minutesText = m19.getText();
        } else if (event.getTarget().equals(m20)) {
            minutesText = m20.getText();
        } else if (event.getTarget().equals(m21)) {
            minutesText = m21.getText();
        } else if (event.getTarget().equals(m22)) {
            minutesText = m22.getText();
        } else if (event.getTarget().equals(m23)) {
            minutesText = m23.getText();
        } else if (event.getTarget().equals(m24)) {
            minutesText = m24.getText();
        } else if (event.getTarget().equals(m25)) {
            minutesText = m25.getText();
        } else if (event.getTarget().equals(m26)) {
            minutesText = m26.getText();
        } else if (event.getTarget().equals(m27)) {
            minutesText = m27.getText();
        } else if (event.getTarget().equals(m28)) {
            minutesText = m28.getText();
        } else if (event.getTarget().equals(m29)) {
            minutesText = m29.getText();
        } else if (event.getTarget().equals(m30)) {
            minutesText = m30.getText();
        } else if (event.getTarget().equals(m31)) {
            minutesText = m31.getText();
        } else if (event.getTarget().equals(m32)) {
            minutesText = m32.getText();
        } else if (event.getTarget().equals(m33)) {
            minutesText = m33.getText();
        } else if (event.getTarget().equals(m34)) {
            minutesText = m34.getText();
        } else if (event.getTarget().equals(m35)) {
            minutesText = m35.getText();
        } else if (event.getTarget().equals(m36)) {
            minutesText = m36.getText();
        } else if (event.getTarget().equals(m37)) {
            minutesText = m37.getText();
        } else if (event.getTarget().equals(m38)) {
            minutesText = m38.getText();
        } else if (event.getTarget().equals(m39)) {
            minutesText = m39.getText();
        } else if (event.getTarget().equals(m40)) {
            minutesText = m40.getText();
        } else if (event.getTarget().equals(m41)) {
            minutesText = m41.getText();
        } else if (event.getTarget().equals(m42)) {
            minutesText = m42.getText();
        } else if (event.getTarget().equals(m43)) {
            minutesText = m43.getText();
        } else if (event.getTarget().equals(m44)) {
            minutesText = m44.getText();
        } else if (event.getTarget().equals(m45)) {
            minutesText = m45.getText();
        } else if (event.getTarget().equals(m46)) {
            minutesText = m46.getText();
        } else if (event.getTarget().equals(m47)) {
            minutesText = m47.getText();
        } else if (event.getTarget().equals(m48)) {
            minutesText = m48.getText();
        } else if (event.getTarget().equals(m49)) {
            minutesText = m49.getText();
        } else if (event.getTarget().equals(m50)) {
            minutesText = m50.getText();
        } else if (event.getTarget().equals(m51)) {
            minutesText = m51.getText();
        } else if (event.getTarget().equals(m52)) {
            minutesText = m52.getText();
        } else if (event.getTarget().equals(m53)) {
            minutesText = m53.getText();
        } else if (event.getTarget().equals(m54)) {
            minutesText = m54.getText();
        } else if (event.getTarget().equals(m55)) {
            minutesText = m55.getText();
        } else if (event.getTarget().equals(m56)) {
            minutesText = m56.getText();
        } else if (event.getTarget().equals(m57)) {
            minutesText = m57.getText();
        } else if (event.getTarget().equals(m58)) {
            minutesText = m58.getText();
        } else if (event.getTarget().equals(m59)) {
            minutesText = m59.getText();
        }
        minutesMenu.setText(minutesText);
    }

    //Scenario : choose type ship
    public void chooseTypeShip(ActionEvent event){
        if (event.getTarget().equals(tp1))
            typeShipText = tp1.getText();
        else if (event.getTarget().equals(tp2))
            typeShipText = tp2.getText();
        else if (event.getTarget().equals(tp3))
            typeShipText = tp3.getText();
        else if (event.getTarget().equals(tp4))
            typeShipText = tp4.getText();
        else if (event.getTarget().equals(tp5))
            typeShipText = tp5.getText();
        else if (event.getTarget().equals(tp6))
            typeShipText = tp6.getText();
        else if (event.getTarget().equals(tp7))
            typeShipText = tp7.getText();
        else if (event.getTarget().equals(tp8))
            typeShipText = tp8.getText();
        typeOfShip.setText(typeShipText);
    }

    //Scenario : Add ship
    public boolean addShip() {
        if (numberOfShipTextField.getText() != null && nameOfShipTextField.getText() != null &&
                typeOfShip.getText() != null && datePortOutPicker.getValue() != null) {
            int nopipo = dbShip.getCreateNoPipo();
            String pipo = "PO";
            String numberShip = numberOfShipTextField.getText();
            String nameShip = nameOfShipTextField.getText();
            String typeShip = typeOfShip.getText();
            String sizeShip = sizeOfShipTextField.getText();
            String datePi = datePortOut.toString();
            if (hoursMenu.getText().matches("[0-9][0-9]") && minutesMenu.getText().matches("[0-9][0-9]")) {
                String time = hoursMenu.getText() + ":" + minutesMenu.getText();
                if (!sizeShip.matches("[1-9][0-9]*")) {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "กรุณากรอกขนาดเรือด้วยตัวเลขเท่านั้น", ButtonType.CLOSE);
                    Optional optional = alert.showAndWait();
                    sizeOfShipTextField.setText("");
                    sizeOfShipTextField.requestFocus();
                }else {
                    dbShip.addShipToDB(nopipo, numberShip, nameShip, typeShip, Integer.parseInt(sizeShip));
                    dbShipPipo.addShipToDBShipPipo(nopipo, pipo, numberShip, datePi, time);
                    return true;
                }

            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING, "กรุณากรอกเวลาในรูปแบบ hh-mm", ButtonType.CLOSE);
                Optional optional = alert.showAndWait();
            }
            return false;
        }
        return false;
    }

    //Scenario : Save Port Out
    public void savePortOut(ActionEvent event) throws IOException {
        if (!numberOfShipTextField.getText().equals("") && !nameOfShipTextField.getText().equals("")
                && !hoursMenu.getText().equals("") && !minutesMenu.getText().equals("")
                && !typeOfShip.getText().equals("") && datePortOutPicker.getValue() != null) {
            if (addShip()) {
                goToRecordMembersPortOut(event);
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "กรุณากรอกข้อมูลให้ครบถ้วน", ButtonType.CLOSE);
            Optional optional = alert.showAndWait();
        }
    }
    public void goToRecordMembersPortOut(ActionEvent event) throws IOException {
        setStage(event);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/recordmemberportout.fxml"));
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }

    //Scenario : Cancel Port Out
    public void cancelPortout(ActionEvent event) throws IOException {
        setStage(event);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainview.fxml"));
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }

    public void setStage(ActionEvent event) {
        Button button = (Button) event.getSource();
        stage = (Stage) button.getScene().getWindow();
    }


    @FXML
    private TextField noShipTextField;
    private Boolean checkNoShip = false;

    //Scenario : search ship
    public void searchShip() {
        String noship = noShipTextField.getText();
        String nameShip = null;
        ObservableList<Ships> identificationOfShip = dbShip.loadDBShips();
        for (Ships ships : identificationOfShip) {
            if (ships.getNoship().equals(noship)) {
                this.checkNoShip = true;
                nameShip = ships.getNameship();
            }
        }
        if (checkNoShip == true) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "พบเลขเรือ", ButtonType.OK);
            Optional optional = alert.showAndWait();
            numberOfShipTextField.setText(noship);
            nameOfShipTextField.setText(nameShip);
//            numberOfShipLabel.setVisible(true);
//            numberOfShipTextField.setVisible(true);
//            nameOfShipLabel.setVisible(true);
//            nameOfShipTextField.setVisible(true);
//            datePortOutLabel.setVisible(true);
//            datePortoutPicker.setVisible(true);
//            timePortOutLabel.setVisible(true);
//            hoursTextField.setVisible(true);
//            charTimeLabel.setVisible(true);
//            minutesTextField.setVisible(true);
//            typeShipLabel.setVisible(true);
//            typeOfShipTextField.setVisible(true);
            submitBtn.setVisible(true);
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
