package database;

import Harbor.PortIn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.sql.*;

public class DatabaseHarbor {

    public ObservableList<PortIn> loadDatabase() throws SQLException {
        ObservableList<PortIn> data = FXCollections.observableArrayList();
        Connection conn=null;
        try {
            //setup
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:databaseportin.db";
            conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                System.out.println("Connected to the database....");
                // display database information
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                //execute SQL statements
                System.out.println("----- Data in Book table -----");
                String query = "select * from portin";
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
//                    int id = resultSet.getInt(1);
                    String datePortIn = resultSet.getString(1);
                    String timePortIn = resultSet.getString(2);
                    String shipNumber = resultSet.getString(3);
                    String typeShip = resultSet.getString(4);
                    String nameShip = resultSet.getString(5);
                    String nameDriver = resultSet.getString(6);
                    int numberOfSeaman = resultSet.getInt(7);
                    System.out.println(datePortIn+"  "+timePortIn+"  "+shipNumber+"  "+timePortIn+"  "+nameShip+"  "+nameDriver+"  "+nameDriver);
                    data.add(new PortIn(datePortIn, timePortIn, shipNumber, typeShip, nameShip, nameDriver, numberOfSeaman));
                }
                //close connection

            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            if (conn!=null) {
                conn.close();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Database is not connect.");
            }
        }
        return data;
    }

    public void saveDatabase(String datePortIn, String timePortIn, String shipNumber, String typeShip, String nameShip, String nameDriver, int numberOfSeaman) throws SQLException {
        Connection connection=null;
        try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:databaseportin.db";
            connection = DriverManager.getConnection(dbURL);
            if (connection != null) {
                String query = "insert into portin(datePortIn, timePortIn, shipNumber, typeShip, nameShip, nameDriver, " +
                        "numberOfSeaman) values ( \'" + datePortIn + "\', \'" + timePortIn + "\', " +
                        "\'" + shipNumber + "\', \'" + typeShip + "\', \'" + nameShip + "\'," +
                        "\'" + nameDriver + "\', \'" + numberOfSeaman + "')";
                PreparedStatement p = connection.prepareStatement(query);
                p.executeUpdate();
                System.out.println("Save Complete");

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"This Ship has Already.\nPlease check Ship number");
        }
        finally {
            if (connection!=null) {
                connection.close();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Database is not connect");
            }
        }

    }

//    public void editDatabase() {
//        try {
//            Class.forName("org.sqlite.JDBC");
//            String dbURL = "jdbc:sqlite:databaseportin.db";
//            Connection connection = DriverManager.getConnection(dbURL);
//            if (connection != null) {
//                String query = "update portin set date=\'" + dateString + "\' ,events=\'" + textEvent + "\' where id == \'" + id + "\'";
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

    public void deleteDatabase(String shipNumber) {
        try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:databaseportin.db";
            Connection connection = DriverManager.getConnection(dbURL);
            if (connection != null) {
                String query = "Delete from portin where shipNumber == \'" + shipNumber + "\'";
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

    public void deleteAllDatabase(){
        try{
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:databaseportin.db";
            Connection connection = DriverManager.getConnection(dbURL);
            if (connection != null){
                String query = "DELETE FROM portin";
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

}
