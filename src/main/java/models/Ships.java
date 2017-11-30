package models;

public class Ships {
    private int nopipo;
    private String pipo;
    private String noship;
    private String nameship;
    private String typeship;
    private String date;
    private String time;

    public Ships(int nopipo, String pipo, String noship, String nameship, String typeship, String date, String time) {
        this.nopipo = nopipo;
        this.pipo = pipo;
        this.noship = noship;
        this.nameship = nameship;
        this.typeship = typeship;
        this.date = date;
        this.time = time;
    }

    public int getNopipo() {
        return nopipo;
    }

    public void setNopipo(int nopipo) {
        this.nopipo = nopipo;
    }

    public String getPipo() {
        return pipo;
    }

    public void setPipo(String pipo) {
        this.pipo = pipo;
    }

    public String getNoship() {
        return noship;
    }

    public void setNoship(String noship) {
        this.noship = noship;
    }

    public String getNameship() {
        return nameship;
    }

    public void setNameship(String nameship) {
        this.nameship = nameship;
    }

    public String getTypeship() {
        return typeship;
    }

    public void setTypeship(String typeship) {
        this.typeship = typeship;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
