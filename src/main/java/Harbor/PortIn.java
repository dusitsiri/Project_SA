package Harbor;

import javafx.scene.control.TableColumn;

public class PortIn {

//    private int id;
    private String datePortIn;
    private String timePortIn;
    private String shipNumber;

    private String typeShip;
    private String nameShip;
    private String nameDriver;
    private int numberOfSeaman;

    public PortIn(String datePortIn, String timePortIn, String shipNumber, String typeShip, String nameShip, String nameDriver, int numberOfSeaman) {
//        this.id = id;
        this.datePortIn = datePortIn;
        this.timePortIn = timePortIn;
        this.shipNumber = shipNumber;
        this.typeShip = typeShip;
        this.nameShip = nameShip;
        this.nameDriver = nameDriver;
        this.numberOfSeaman = numberOfSeaman;
    }

//    public int getId() { return id; }

//    public void setId(int id) { this.id = id; }

    public String getDatePortIn() {
        return datePortIn;
    }

    public void setDatePortIn(String datePortIn) {
        this.datePortIn = datePortIn;
    }

    public String getTimePortIn() {
        return timePortIn;
    }

    public void setTimePortIn(String timePortIn) {
        this.timePortIn = timePortIn;
    }

    public String getShipNumber() {
        return shipNumber;
    }

    public void setShipNumber(String shipNumber) {
        this.shipNumber = shipNumber;
    }

    public String getTypeShip() {
        return typeShip;
    }

    public void setTypeShip(String typeShip) {
        this.typeShip = typeShip;
    }

    public String getNameShip() {
        return nameShip;
    }

    public void setNameShip(String nameShip) {
        this.nameShip = nameShip;
    }

    public String getNameDriver() {
        return nameDriver;
    }

    public void setNameDriver(String nameDriver) {
        this.nameDriver = nameDriver;
    }

    public int getNumberOfSeaman() {
        return numberOfSeaman;
    }

    public void setNumberOfSeaman(int numberOfSeaman) {
        this.numberOfSeaman = numberOfSeaman;
    }
}
