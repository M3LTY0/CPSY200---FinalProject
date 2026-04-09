package manager;

import java.util.ArrayList;

import domain.customer.Customer;

public class CustomerManager {
    dataconn data = new dataconn();
    ArrayList<Customer> custList = data.getCustomerList();

    void addCustomer(int customerID, String firstName, String lastName, int contactPhone, String email,String isBanned){
        Customer add = new Customer(customerID, firstName, lastName, contactPhone, email, isBanned);
        data.addCustomersql(customerID, firstName, lastName, contactPhone, email, isBanned);
        custList.add(add);
        }

    void removeCustomer(int customerID){
        Customer select = searchCustomer(customerID);
        data.deleteCustomersql(customerID);
        custList.remove(select);
    }

    void updateCustomer(int customerID){}


    Customer searchCustomer(int customerID){
        for(Customer iter:custList){
            if(iter.getCustomerID()==customerID)
                return iter;
        }

        return null;
    }

    ArrayList<Customer> getCustomerList(){
        return custList;
    }
}
