package manager;

import java.sql.*;
import java.util.ArrayList;

import domain.customer.Customer;
import domain.equipment.Equipment;
import domain.rental.Rental;

public class dataconn {

    private Connection conn = null;
    private ArrayList<Customer> Customers = new ArrayList<>();
    private ArrayList<Equipment> Equipments = new ArrayList<>();
    private ArrayList<Rental> Rentals = new ArrayList<>();
    private final String SERVER = "localhost";
    private final int PORT = 3306;
    private static String DATABASE = "village_rentals";
    private final String USERNAME = "root";
    private final String PASSWORD = "password";

    public dataconn() {
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
        String sql = "SELECT * FROM customer";
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
            System.out.println("Error loading customers: " + e.getMessage());
        }
        return Customers;
    }

    public void addCustomersql(int customerID, String firstName, String lastName, int contactPhone, String email, String isBanned){
        String sql = "INSERT INTO customer(customerID, firstName, lastName, contactPhone, email, isBanned) VALUES (?, ?, ?, ?, ?, ?)";
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
            System.out.println("Error inserting customer: " + e.getMessage());
        }
    }

    public void updateCustomersql(int customerID, String firstName, String lastName, int contactPhone, String email, String isBanned) {
        String sql = "UPDATE customer SET firstName=?, lastName=?, contactPhone=?, email=?, isBanned=? WHERE customerID=?";
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
            System.out.println("Error updating customer: " + e.getMessage());
        }
    }

    public void deleteCustomersql(int customerID) {
        String sql = "DELETE FROM customer WHERE customerID=?";
        try {
            PreparedStatement pst = prepared(sql);
            pst.setInt(1, customerID);
            int count = updated(pst);
            System.out.println(count + " row deleted");
        } catch (SQLException e) {
            System.out.println("Error deleting customer: " + e.getMessage());
        }
    }

    //equipment stuff
    public ArrayList<Equipment> getEquipmentList() {
        String sql = "SELECT * FROM equipment";
        try {
            PreparedStatement pst = prepared(sql);
            ResultSet rs = query(pst);
            while (rs.next()) {
                Equipments.add(new Equipment(
                        rs.getInt("equipmentID"),
                        rs.getString("name"),
                        rs.getInt("categoryID"),
                        rs.getString("description"),
                        rs.getFloat("dailyCost"),
                        rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error loading equipment: " + e.getMessage());
        }
        return Equipments;
    }

    public void addEquipmentsql(int equipmentID, String name, int categoryID, String description, float dailyCost, String status){
        String sql = "INSERT INTO equipment (equipmentID, name, categoryID, description, dailyCost,status) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = prepared(sql);
            pst.setInt(1, equipmentID);
            pst.setString(2, name);
            pst.setInt(3, categoryID);
            pst.setString(4, description);
            pst.setFloat(5, dailyCost);
            pst.setString(6, status);
            int count = updated(pst);
            System.out.println(count + " row inserted");
        } catch (SQLException e) {
            System.out.println("Error inserting equipment: " + e.getMessage());
        }
    }

    public void updateEquipmentsql(int equipmentID, String name, int categoryID, String description, float dailyCost, String status) {
        String sql = "UPDATE equipment SET name=?, categoryID=?, description=?, dailyCost=?, status=? WHERE equipmentID=?";
        try {
            PreparedStatement pst = prepared(sql);
            pst.setString(1, name);
            pst.setInt(2, categoryID);
            pst.setString(3, description);
            pst.setFloat(4, dailyCost);
            pst.setString(5, status);
            pst.setInt(6, equipmentID);
            int count = updated(pst);
            System.out.println(count + " row updated");
        } catch (SQLException e) {
            System.out.println("Error updating equipment: " + e.getMessage());
        }
    }

    public void deleteEquipmentsql(int equipmentID) {
        String sql = "DELETE FROM equipment WHERE equipmentID=?";
        try {
            PreparedStatement pst = prepared(sql);
            pst.setInt(1, equipmentID);
            int count = updated(pst);
            System.out.println(count + " row deleted");
        } catch (SQLException e) {
            System.out.println("Error deleting equipment: " + e.getMessage());
        }
    }

    //rental stuff
    public ArrayList<Rental> getRentalList() {
        String sql = "SELECT * FROM rental";
        try {
            PreparedStatement pst = prepared(sql);
            ResultSet rs = query(pst);
            while (rs.next()) {
                Rentals.add(new Rental(
                        rs.getInt("rentalID"),
                        rs.getInt("customerID"),
                        rs.getInt("equipmentID"),
                        rs.getString("currentDate"),
                        rs.getString("rentalDate"),
                        rs.getString("returnDate"),
                        rs.getFloat("cost")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error loading rentals: " + e.getMessage());
        }
        return Rentals;
    }

    public void addRentalsql(int rentalID, int customerID, int equipmentID, String currentDate, String rentalDate, String returnDate, float cost){
        String sql = "INSERT INTO rental (rentalID, customerID, equipmentID, currentDate, rentalDate, returnDate, cost) VALUES (?, ?, ?, ?, ?, ?,?)";
        try {
            PreparedStatement pst = prepared(sql);
            pst.setInt(1, rentalID);
            pst.setInt(2, customerID);
            pst.setInt(3, equipmentID);
            pst.setString(4, currentDate);
            pst.setString(5, rentalDate);
            pst.setString(6, returnDate);
            pst.setFloat(7, cost);

            int count = updated(pst);
            System.out.println(count + " row inserted");
        } catch (SQLException e) {
            System.out.println("Error inserting rental: " + e.getMessage());
        }
    }

    public void updateRentalsql(int rentalID, int customerID, int equipmentID, String currentDate, String rentalDate, String returnDate, float cost) {
        String sql = "UPDATE equipment SET customerID=?, equipmentID=?, currentDate=?, rentalDate=?, returnDate=?, cost=?, WHERE rentalID=?";
        try {
            PreparedStatement pst = prepared(sql);
            pst.setInt(1, customerID);
            pst.setInt(2, equipmentID);
            pst.setString(3, currentDate);
            pst.setString(4, rentalDate);
            pst.setString(5, returnDate);
            pst.setFloat(6, cost);
            pst.setInt(7, rentalID);

            int count = updated(pst);
            System.out.println(count + " row updated");
        } catch (SQLException e) {
            System.out.println("Error updating rental: " + e.getMessage());
        }
    }

    public void deleteRentalsql(int rentalID) {
        String sql = "DELETE FROM rental WHERE rentalID=?";
        try {
            PreparedStatement pst = prepared(sql);
            pst.setInt(1, rentalID);
            int count = updated(pst);
            System.out.println(count + " row deleted");
        } catch (SQLException e) {
            System.out.println("Error deleting Rental: " + e.getMessage());
        }
    }




    
}