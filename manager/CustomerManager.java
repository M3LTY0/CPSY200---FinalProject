package manager;

import java.util.ArrayList;
import java.util.Scanner;

import domain.customer.Customer;
import exceptions.CustomerNotFoundException;

public class CustomerManager {
    Scanner input = new Scanner(System.in);
    dataconn data = new dataconn();
    public ArrayList<Customer> custList = data.getCustomerList();

    public void addCustomer(int customerID, String firstName, String lastName, int contactPhone, String email,String isBanned){
        Customer add = new Customer(customerID, firstName, lastName, contactPhone, email, isBanned);
        data.addCustomersql(customerID, firstName, lastName, contactPhone, email, isBanned);
        custList.add(add);
        }

    public void removeCustomer(int customerID){
          Customer select = null;
        try {
            select = searchCustomer(customerID);
        } catch (CustomerNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }
        data.deleteCustomersql(customerID);
        custList.remove(select);
    }

    public void updateCustomer(int customerID){
        Customer select = null;
        try {
            select = searchCustomer(customerID);
        } catch (CustomerNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }

        int choice = 50;
        do {
            System.out.println("What would you like to change:");
            System.out.println("1: customerID");
            System.out.println("2: firstName");
            System.out.println("3: lastName");
            System.out.println("4: phone");
            System.out.println("5: email");
            System.out.println("6: banned");
            System.out.println("0: Quit");

            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                System.out.println("Please enter new value for customerID");
                int newCustomerID = input.nextInt();
                input.nextLine();
                select.setCustomerID(newCustomerID);
            } else if (choice == 2) {
                System.out.println("Please enter new value for firstName");
                select.setFirstName(input.nextLine());
            } else if (choice == 3) {
                System.out.println("Please enter new value for lastName");
                select.setLastName(input.nextLine());
            } else if (choice == 4) {
                System.out.println("Please enter new value for phone");
                select.setContactPhone(input.nextInt());
                input.nextLine();
            } else if (choice == 5) {
                System.out.println("Please enter new value for email");
                select.setEmail(input.nextLine());
            }else if (choice == 6) {
                System.out.println("Please enter new value for banned");
                select.setIsBanned(input.nextLine());
            }

        } while (choice != 0);

        data.updateCustomersql(select.getCustomerID(), select.getFirstName(), select.getLastName(),
                select.getContactPhone(), select.getEmail(), select.getIsBanned());
    }

    public Customer searchCustomer(int customerID) throws CustomerNotFoundException{
        for(Customer iter:custList){
            if(iter.getCustomerID()==customerID)
                return iter;
        }
        throw new CustomerNotFoundException("No customer found with ID: "+customerID);
    }

    ArrayList<Customer> getCustomerList(){
        return custList;
    }
}
