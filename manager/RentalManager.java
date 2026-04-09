package manager;

import java.util.ArrayList;

import domain.rental.Rental;

public class RentalManager {
    dataconn data = new dataconn();
    ArrayList<Rental> rentList = data.getRentalList();

    void addRental(int rentalID, int customerID, int equipmentID, String currentDate, String rentalDate, String returnDate, float cost){
        Rental add = new Rental(rentalID, customerID, equipmentID, currentDate, rentalDate, returnDate, cost);
        data.addRentalsql(rentalID, customerID, equipmentID, currentDate, rentalDate, returnDate, cost);
        rentList.add(add);
        }

    void removeRental(int rentalID){
        Rental select = searchRental(rentalID);
        data.deleteRentalsql(rentalID);
        rentList.remove(select);
    }

    void updateRental(int rentalID){}


    Rental searchRental(int rentalID){
        for(Rental iter:rentList){
            if(iter.getRentalID()==rentalID)
                return iter;
        }

        return null;
    }

    ArrayList<Rental> getRentalList(){
        return rentList;
    }
}
