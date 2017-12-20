package database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Ships;

import java.sql.*;

public class DBShip {

    public ObservableList<Ships> loadDBShips() {
        ObservableList<Ships> data = FXCollections.observableArrayList();
        Connection conn = null;
        try {
            //setup
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:DBShip.db";
            conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                System.out.println("Connected to the database....");
                // display database information
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                //execute SQL statements
                System.out.println("----- Data in Book table -----");
                String query = "select * from ships";
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    int nopipo = resultSet.getInt(1);
                    String noship = resultSet.getString(2);
                    String nameship = resultSet.getString(3);
                    String typeship = resultSet.getString(4);
                    int sizeShip = resultSet.getInt(5);
                    data.add(new Ships(nopipo, noship, nameship, typeship, sizeShip));
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

    public void addShipToDB(int nopipo, String noship, String nameship,
                            String typeship, int sizeShip) {
        try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:DBShip.db";
            Connection connection = DriverManager.getConnection(dbURL);
            if (connection != null) {
                String query = "insert into ships(nopipo, noship, " +
                        "nameship, typeship, sizeship) values " +
                        "(\'" + nopipo + "\', \'" + noship + "\'," +
                        "\'" + nameship + "\', \'" + typeship + "\', " +
                        "\'" + sizeShip + "')";
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

    public int getCreateNoPipo() {
        int minNumber = 0;
        try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:DBShip.db";
            Connection connection = DriverManager.getConnection(dbURL);
            if (connection != null) {
                String query = "Select max(nopipo) from ships";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                minNumber = resultSet.getInt(1);
                connection.close();
                return minNumber + 1;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return minNumber;
    }

    public void deleteShipInDB(int nopipo) {
        try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:DBShip.db";
            Connection connection = DriverManager.getConnection(dbURL);
            if (connection != null) {
                String query = "Delete from ships where nopipo == \'" + nopipo + "\'";
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
