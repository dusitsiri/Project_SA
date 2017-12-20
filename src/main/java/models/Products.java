package models;

public class Products {
    private int no;
    private int nopipo;
    private String nameproduct;
    private String typeproduct;
    private String qtyproduct;
    private String unitproduct;

    public Products(int no, int nopipo, String nameproduct, String typeproduct, String qtyproduct, String unitproduct) {
        this.no = no;
        this.nopipo = nopipo;
        this.nameproduct = nameproduct;
        this.typeproduct = typeproduct;
        this.qtyproduct = qtyproduct;
        this.unitproduct = unitproduct;
    }

    public Products(int no, int nopipo, String nameproduct){
        this.no = no;
        this.nopipo = nopipo;
        this.nameproduct = nameproduct;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getNopipo() {
        return nopipo;
    }

    public void setNopipo(int nopipo) {
        this.nopipo = nopipo;
    }

    public String getNameproduct() {
        return nameproduct;
    }

    public void setNameproduct(String nameproduct) {
        this.nameproduct = nameproduct;
    }

    public String getTypeproduct() {
        return typeproduct;
    }

    public void setTypeproduct(String typeproduct) {
        this.typeproduct = typeproduct;
    }

    public String getQtyproduct() {
        return qtyproduct;
    }

    public void setQtyproduct(String qtyproduct) {
        this.qtyproduct = qtyproduct;
    }

    public String getUnitproduct() {
        return unitproduct;
    }

    public void setUnitproduct(String unitproduct) {
        this.unitproduct = unitproduct;
    }
}
