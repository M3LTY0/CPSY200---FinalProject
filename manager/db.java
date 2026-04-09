package manager;

import java.sql.*;
import java.util.ArrayList;

import domain.customer.Customer;
import domain.equipment.Equipment;
import domain.rental.Rental;

public class db {

    private Connection conn = null;
    private ArrayList<Customer> Customers = new ArrayList<>();
    private ArrayList<Equipment> Equipments = new ArrayList<>();
    private ArrayList<Rental> Rentals = new ArrayList<>();
    private final String SERVER = "localhost";
    private final int PORT = 3306;
    private static String DATABASE = "village_rentals";
    private final String USERNAME = "root";
    private final String PASSWORD = "password";

    public db() {
        connect();
    }

    public void connect() {
        final String DB_URL = String.format("jdbc:mariadb://%s:%d/%s?user=%s&password=%s",
                SERVER, PORT, DATABASE, USERNAME, PASSWORD);
        try {
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("DB connection established");
        } catch (SQLException e) {
            System.out.println("Problem with connection to DB: " + e.getMessage());
        }
    }

    public void disconnect() {
        try {
            conn.close();
            System.out.println("Thank you for using our app. Goodbye!");
        } catch (SQLException e) {
            System.out.println("Error while disconnecting from DB: " + e.getMessage());
        }
    }

    public PreparedStatement prepared(String sql) {
        try {
            return conn.prepareStatement(sql);
        } catch (SQLException e) {
            System.out.println("Problem preparing statement: " + e.getMessage());
            return null;
        }
    }

    public int updated(PreparedStatement pst) {
        try {
            return pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Problem executing update: " + e.getMessage());
            return 0;
        }
    }

    public ResultSet query(PreparedStatement pst) {
        try {
            return pst.executeQuery();
        } catch (SQLException e) {
            System.out.println("Problem executing query: " + e.getMessage());
            return null;
        }
    }


    //customer stuff
    public ArrayList<Customer> getCustomerList() {
        String sql = "SELECT * FROM Customers";
        try {
            PreparedStatement pst = prepared(sql);
            ResultSet rs = query(pst);
            while (rs.next()) {
                Customers.add(new Customer(
                        rs.getInt("customerID"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getInt("contactPhone"),
                        rs.getString("email"),
                        rs.getString("isBanned")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error loading Customers: " + e.getMessage());
        }
        return Customers;
    }

    public void addCustomersql(int customerID, String firstName, String lastName, int contactPhone, String email, String isBanned){
        String sql = "INSERT INTO Customers(customerID, firstName, lastName, contactPhone, email, isBanned) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = prepared(sql);
            pst.setInt(1, customerID);
            pst.setString(2, firstName);
            pst.setString(3, lastName);
            pst.setInt(4, contactPhone);
            pst.setString(5, email);
            pst.setString(6, isBanned);
            int count = updated(pst);
            System.out.println(count + " row inserted");
        } catch (SQLException e) {
            System.out.println("Error inserting Customer: " + e.getMessage());
        }
    }

    public void updateCustomersql(int customerID, String firstName, String lastName, int contactPhone, String email, String isBanned) {
        String sql = "UPDATE Customers SET firstName=?, lastName=?, contactPhone=?, email=?, isBanned=? WHERE customerID=?";

        String sql = "UPDATE Customers SET title=?, genre=?, publisher=?, status=?, quality=? WHERE ISBN=?";
        try {
            PreparedStatement pst = prepared(sql);
            pst.setString(1, firstName);
            pst.setString(2, lastName);
            pst.setInt(3, contactPhone);
            pst.setString(4, email);
            pst.setString(5, isBanned);
            pst.setInt(6, customerID);
            int count = updated(pst);
            System.out.println(count + " row updated");
        } catch (SQLException e) {
            System.out.println("Error updating Customer: " + e.getMessage());
        }
    }

    public void deleteCustomersql(int customerID) {
        String sql = "DELETE FROM Customers WHERE customerID=?";
        try {
            PreparedStatement pst = prepared(sql);
            pst.setInt(1, customerID);
            int count = updated(pst);
            System.out.println(count + " row deleted");
        } catch (SQLException e) {
            System.out.println("Error deleting Customer: " + e.getMessage());
        }
    }




    
}
