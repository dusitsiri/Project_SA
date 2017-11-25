package models;

public class MembersOfShip {
    private int number;
    private int numberOfPipoReport;
    private String name;
    private String position;
    private String gender;
    private String birthday;

    public MembersOfShip(int number, int numberOfPipoReport, String name, String position, String gender, String birthday) {
        this.number = number;
        this.numberOfPipoReport = numberOfPipoReport;
        this.name = name;
        this.position = position;
        this.gender = gender;
        this.birthday = birthday;
    }

    public int getNumber() {
        return number;
    }

    public int getNumberOfPipoReport() {
        return numberOfPipoReport;
    }

    public String getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setNumberOfPipoReport(int numberOfPipoReport) {
        this.numberOfPipoReport = numberOfPipoReport;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setName(String name) {
        this.name = name;
    }
}
