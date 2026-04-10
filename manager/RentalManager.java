package manager;
import java.util.ArrayList;
import java.util.Scanner;

import domain.rental.Rental;
import exceptions.RentalNotFoundException;

public class RentalManager {
    Scanner input = new Scanner(System.in);
    dataconn data = new dataconn();
    public ArrayList<Rental> rentList = data.getRentalList();

    void addRental(int rentalID, int customerID, int equipmentID, String currentDate, String rentalDate, String returnDate, float cost){
        Rental add = new Rental(rentalID, customerID, equipmentID, currentDate, rentalDate, returnDate, cost);
        data.addRentalsql(rentalID, customerID, equipmentID, currentDate, rentalDate, returnDate, cost);
        rentList.add(add);
        }

    void removeRental(int rentalID){
        Rental select = null;
        try {
            select = searchRental(rentalID);
        } catch (RentalNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }

        data.deleteRentalsql(rentalID);
        rentList.remove(select);
    }

    void updateRental(int rentalID){
        Rental select = null;
        try {
            select = searchRental(rentalID);
        } catch (RentalNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }

        int choice = 50;
        do {
            System.out.println("What would you like to change:");
            System.out.println("1: rentalID");
            System.out.println("2: customerID");
            System.out.println("3: equipmentID");
            System.out.println("4: current date");
            System.out.println("6: rental date");
            System.out.println("7: return date");
            System.out.println("8: cost");
            System.out.println("0: Quit");

            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                System.out.println("Please enter new value for rentalID");
                int newRentalID = input.nextInt();
                input.nextLine();
                select.setRentalID(newRentalID);
            } else if (choice == 2) {
                System.out.println("Please enter new value for customerID");
                select.setCustomerID(input.nextInt());
                input.nextLine();
            } else if (choice == 3) {
                System.out.println("Please enter new value for equipmentID");
                select.setEquipmentID(input.nextInt());
                input.nextLine();
            } else if (choice == 4) {
                System.out.println("Please enter new value for current date");
                select.setCurrentDate(input.nextLine());
            } else if (choice == 5) {
                System.out.println("Please enter new value for rental date");
                select.setRentalDate(input.nextLine());
            } else if (choice == 6) {
                System.out.println("Please enter new value for return date");
                select.setReturnDate(input.nextLine());
            } else if (choice == 7) {
                System.out.println("Please enter new value for cost");
                select.setCost(input.nextFloat());
                input.nextLine();
            }

        } while (choice != 0);

        data.updateRentalsql(select.getRentalID(), select.getCustomerID(), select.getEquipmentID(), select.getCurrentDate(), select.getRentalDate(), select.getReturnDate(), select.getCost());
    }

    Rental searchRental(int rentalID) throws RentalNotFoundException{

        for(Rental iter:rentList){
            if(iter.getRentalID()==rentalID)
                return iter;
        }
        throw new RentalNotFoundException("No rental found with ID: "+rentalID);

    }

    ArrayList<Rental> getRentalList(){
        return rentList;
    }
}
