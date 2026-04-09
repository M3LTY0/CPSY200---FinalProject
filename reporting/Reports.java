package reporting;


import domain.equipment.Equipment;
import domain.rental.Rental;
import manager.CustomerManager;
import manager.EquipmentManager;
import manager.RentalManager;

public class Reports {

    EquipmentManager em = new EquipmentManager();
    CustomerManager cm = new CustomerManager();
    RentalManager rm = new RentalManager();

    void getItems(int categoryID){
        for(Equipment iter : em.equipList){
            if(iter.getCategoryID()==categoryID){
                iter.toString();

            }
        }
    }

    void getSales(String date){
        for(Rental iter : rm.rentList){
            if(iter.getRentalDate().equals(date)){
                iter.toString();
            }
        }


    }

    void getSales(int customerID){
         for(Rental iter : rm.rentList){
            if(iter.getCustomerID()==customerID){
                iter.toString();
            }
        }
    }

   
    
}
