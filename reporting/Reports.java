package reporting;


import domain.equipment.Equipment;
import domain.rental.Rental;
import manager.CustomerManager;
import manager.EquipmentManager;
import manager.RentalManager;

public class Reports {

    EquipmentManager em;
    CustomerManager cm;
    RentalManager rm;

    public Reports(CustomerManager cm, EquipmentManager em,  RentalManager rm) {
        this.cm = cm;
        this.em = em;
        this.rm = rm;
    }

    public void getItems(int categoryID){
        for(Equipment iter : em.equipList){
            if(iter.getCategoryID()==categoryID){
                System.out.println(iter.toString());

            }
        }
    }

    public void getSales(String date){
        for(Rental iter : rm.rentList){
            if(iter.getRentalDate().equals(date)){
                System.out.println(iter.toString());
            }
        }


    }

    public void getSales(int customerID){
         for(Rental iter : rm.rentList){
            if(iter.getCustomerID()==customerID){
                System.out.println(iter.toString());
            }
        }
    }

   
    
}
