package database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.MembersOfShip;

import javax.swing.*;
import java.sql.*;

public class DBMemberOfShip {

    public ObservableList<MembersOfShip> loadDBMembers(){
        ObservableList<MembersOfShip> data = FXCollections.observableArrayList();
        Connection conn=null;
        try {
            //setup
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:DBMembers.db";
            conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                System.out.println("Connected to the database....");
                // display database information
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                //execute SQL statements
                System.out.println("----- Data in Book table -----");
                String query = "select * from members";
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    int number = resultSet.getInt(1);
                    int numberOfPipoReport = resultSet.getInt(2);
                    String name = resultSet.getString(3);
                    String position = resultSet.getString(4);
                    String gender = resultSet.getString(5);
                    String birthday = resultSet.getString(6);
                    data.add(new MembersOfShip(number, numberOfPipoReport, name, position, gender, birthday));
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

    public void addMembersToDB(int number, int numberOfPipoReport, String name, String position, String gender, String birthday){
        try{
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:DBMembers.db";
            Connection connection = DriverManager.getConnection(dbURL);
            if (connection != null){
                String query = "insert into members(number, numberOfPipoReport, name, " +
                        "position, gender, birthday) values " +
                        "(\'" +number+ "\', \'" +numberOfPipoReport+ "\', \'" +name+ "\'," +
                        "\'" +position+ "\', \'" +gender+ "\', \'" +birthday+ "')";
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
            String dbURL = "jdbc:sqlite:DBMembers.db";
            Connection connection = DriverManager.getConnection(dbURL);
            if (connection != null){
                String query = "Select max(number) from members";
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

    public int getCreateNumberOfPipoReport(){
        int minNumberOfPipoReport = 0;
        try{
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:DBMembers.db";
            Connection connection = DriverManager.getConnection(dbURL);
            if (connection != null){
                String query = "Select max(nopipo) from members";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                minNumberOfPipoReport = resultSet.getInt(1);
                connection.close();
                return  minNumberOfPipoReport+1;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return minNumberOfPipoReport;
    }

//    public void deleteMembersInDB(int id){
//        try{
//            Class.forName("org.sqlite.JDBC");
//            String dbURL = "jdbc:sqlite:DBMembers.db";
//            Connection connection = DriverManager.getConnection(dbURL);
//            if (connection != null){
//                String query = "Delete from members where id == \'" +id+ "\'";
//                PreparedStatement p = connection.prepareStatement(query);
//                p.executeUpdate();
//                connection.close();
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

}
