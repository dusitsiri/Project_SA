package database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Products;

import java.sql.*;

public class DBProducts {

    public ObservableList<Products> loadDBProducts(){
        ObservableList<Products> data = FXCollections.observableArrayList();
        Connection conn=null;
        try {
            //setup
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:DBProduct.db";
            conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                System.out.println("Connected to the database....");
                // display database information
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                //execute SQL statements
                System.out.println("----- Data in Book table -----");
                String query = "select * from products";
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    int no = resultSet.getInt(1);
                    int nopipo = resultSet.getInt(2);
                    String nameProduct = resultSet.getString(3);
                    String typeProduct = resultSet.getString(4);
                    String qtyProduct = resultSet.getString(5);
                    String unitProduct = resultSet.getString(6);
                    data.add(new Products(no,nopipo,nameProduct,typeProduct,qtyProduct,unitProduct));
                }
                //close connection

            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return data;
    }

    public void addProductToDB(int no, int nopipo, String nameproduct, String typeproduct, String qtyproduct, String unitproduct){
        try{
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:DBProduct.db";
            Connection connection = DriverManager.getConnection(dbURL);
            if (connection != null){
                String query = "insert into products(no, nopipo, nameproduct, " +
                        "typeproduct, qtyproduct, unitproduct) values " +
                        "(\'" +no+ "\', \'" +nopipo+ "\', \'" +nameproduct+ "\'," +
                        "\'" +typeproduct+ "\', \'" +qtyproduct+ "\', \'" +unitproduct+ "')";
                PreparedStatement p = connection.prepareStatement(query);
                p.executeUpdate();
                connection.close();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProductInDB(int nopipo) {
        try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:DBProduct.db";
            Connection connection = DriverManager.getConnection(dbURL);
            if (connection != null) {
                String query = "Delete from products where nopipo == \'" + nopipo + "\'";
                PreparedStatement p = connection.prepareStatement(query);
                p.executeUpdate();
                connection.close();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getCreateNumber(){
        int minNumber = 0;
        try{
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:DBProduct.db";
            Connection connection = DriverManager.getConnection(dbURL);
            if (connection != null){
                String query = "Select max(no) from products";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                minNumber = resultSet.getInt(1);
                connection.close();
                return  minNumber+1;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return minNumber;
    }
}
