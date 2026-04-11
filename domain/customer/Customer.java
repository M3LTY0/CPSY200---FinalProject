package domain.customer;
public class Customer{

    public Customer(int customerID, String firstName, String lastName, String contactPhone, String email, boolean isBanned) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactPhone = contactPhone;
        this.email = email;
        this.isBanned = isBanned;
    }

    private int customerID;
    private String firstName;
    private String lastName;
    private String contactPhone;
    private String email;
    private boolean isBanned;
    
    public int getCustomerID() {
        return customerID;
    }
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getContactPhone() {
        return contactPhone;
    }
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public boolean getIsBanned() {
        return isBanned;
    }
    public void setIsBanned(boolean isBanned) {
        this.isBanned = isBanned;
    }
    @Override
    public String toString() {
        return firstName + " " + lastName + " [ID: " + customerID + ", Phone Number: " + contactPhone + ", Email: " + email + ", Banned: " + isBanned;
    }

    


}
