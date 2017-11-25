package models;

public class MembersOfShip {
    private int number;
    private int nopipo;
    private String name;
    private String position;
    private String gender;
    private String birthday;

    public MembersOfShip(int number, int nopipo, String name, String position, String gender, String birthday) {
        this.number = number;
        this.nopipo = nopipo;
        this.name = name;
        this.position = position;
        this.gender = gender;
        this.birthday = birthday;
    }

    public int getNumber() {
        return number;
    }

    public int getNopipo() {
        return nopipo;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
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

    public void setNopipo(int nopipo) {
        this.nopipo = nopipo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
