package domain.rental;
public class Rental {
    
    public Rental(int rentalID, int customerID, int equipmentID, String currentDate, String rentalDate,
            String returnDate, float cost) {
        this.rentalID = rentalID;
        this.customerID = customerID;
        this.equipmentID = equipmentID;
        this.currentDate = currentDate;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.cost = cost;
    }

    private int  rentalID;
    private int customerID;
    private int equipmentID;
    private String currentDate;
    private String rentalDate;
    private String returnDate;
    private float cost;
    
    public int getRentalID() {
        return rentalID;
    }
    public void setRentalID(int rentalID) {
        this.rentalID = rentalID;
    }
    public int getCustomerID() {
        return customerID;
    }
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
    public int getEquipmentID() {
        return equipmentID;
    }
    public void setEquipmentID(int equipmentID) {
        this.equipmentID = equipmentID;
    }
    public String getCurrentDate() {
        return currentDate;
    }
    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }
    public String getRentalDate() {
        return rentalDate;
    }
    public void setRentalDate(String rentalDate) {
        this.rentalDate = rentalDate;
    }
    public String getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }

    

    
    
}
