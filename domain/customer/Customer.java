package domain.customer;
public class Customer{

    public Customer(int customerID, String firstName, String lastName, int contactPhone, String email,String isBanned) {
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
    private int contactPhone;
    private String email;
    private String isBanned;
    
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
    public int getContactPhone() {
        return contactPhone;
    }
    public void setContactPhone(int contactPhone) {
        this.contactPhone = contactPhone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getIsBanned() {
        return isBanned;
    }
    public void setIsBanned(String isBanned) {
        this.isBanned = isBanned;
    }

    


}
