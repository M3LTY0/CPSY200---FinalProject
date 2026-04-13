package gui;

import java.util.Scanner;

import domain.customer.Customer;
import domain.equipment.Equipment;
import domain.rental.Rental;
import exceptions.CustomerNotFoundException;
import exceptions.EquipmentNotFoundException;
import exceptions.RentalNotFoundException;
import manager.CustomerManager;
import manager.EquipmentManager;
import manager.RentalManager;
import reporting.Reports;

public class UI {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws CustomerNotFoundException, EquipmentNotFoundException, RentalNotFoundException {
        mainMenu();
    }

    public static void mainMenu() throws CustomerNotFoundException, EquipmentNotFoundException, RentalNotFoundException {
        CustomerManager CM = new CustomerManager();
        EquipmentManager EM = new EquipmentManager();
        RentalManager RM = new RentalManager();
        Reports reports = new Reports(CM, EM, RM);
        System.out.println("---------------------------");
        System.out.println("Welcome to Village Rentals!");
        System.out.println("---------------------------");
        int choice = -1;
        do {
            System.out.println("\n---------");
            System.out.println("Home Page");
            System.out.println("---------");
            System.out.println("Please choose an option:");
            System.out.println("1: Customer page");
            System.out.println("2: Equipment page");
            System.out.println("3: Rental page");
            System.out.println("4: Report page");
            System.out.println("0: Quit");
            
            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                int customerChoice = -1;
                do {
                    System.out.println("\n-------------");
                    System.out.println("Customer Page");
                    System.out.println("-------------");
                    System.out.println("Please choose an option:");
                    System.out.println("1: Add a customer");
                    System.out.println("2: Search for a customer");
                    System.out.println("3: Update a customer");
                    System.out.println("4: Remove a customer");
                    System.out.println("5: Show all customers");
                    System.out.println("0: Back to Home Page");

                    customerChoice = input.nextInt();
                    input.nextLine();

                    if (customerChoice == 1) {
                        System.out.print("Enter the customer ID: ");
                        int customerID = input.nextInt();
                        input.nextLine();

                        System.out.print("Enter the first name: ");
                        String firstName = input.nextLine();

                        System.out.print("Enter the last name: ");
                        String lastName = input.nextLine();

                        System.out.print("Enter the phone number: ");
                        String contactPhone = input.nextLine();

                        System.out.print("Enter the email: ");
                        String email = input.nextLine();

                        boolean isBanned = false;

                        CM.addCustomer(customerID, firstName, lastName, contactPhone, email, isBanned);
                        System.out.println(firstName + " " + lastName + " was added to the system");
                    } else if (customerChoice == 2) {
                        System.out.print("Enter a customer ID: ");
                        int customerID = input.nextInt();
                        Customer c = CM.searchCustomer(customerID);
                        System.out.println(c.toString());
                    } else if (customerChoice == 3) {
                        System.out.print("Enter a customer ID: ");
                        int customerID = input.nextInt();
                        CM.updateCustomer(customerID);
                        Customer c = CM.searchCustomer(customerID);
                        System.out.println("Customer was updated");
                    } else if (customerChoice == 4) {
                        System.out.print("Enter a customer ID: ");
                        int customerID = input.nextInt();
                        CM.removeCustomer(customerID);
                        System.out.println("The customer was removed");
                    } else if (customerChoice == 5) {
                        for (Customer c : CM.custList) {
                            System.out.println(c.toString());
                        }
                    } else if (customerChoice != 0) {
                        System.out.println("Please choose a valid option");
                    }
                } while (customerChoice != 0);
            } else if (choice == 2) {
                int equipmentChoice = -1;
                do {
                    System.out.println("\n--------------");
                    System.out.println("Equipment Page");
                    System.out.println("--------------");
                    System.out.println("Please choose an option:");
                    System.out.println("1: Add equipment");
                    System.out.println("2: Search for equipment");
                    System.out.println("3: Update equipment");
                    System.out.println("4: Sell equipment");
                    System.out.println("5: Remove equipment");
                    System.out.println("6: Show all equipment");
                    System.out.println("0: Back to Home Page");

                    equipmentChoice = input.nextInt();
                    input.nextLine();

                    if (equipmentChoice == 1) {
                        System.out.print("Enter the equipment ID: ");
                        int equipmentID = input.nextInt();
                        input.nextLine();

                        System.out.print("Enter the equipment name: ");
                        String name = input.nextLine();

                        System.out.print("Enter the category ID: ");
                        int categoryID = input.nextInt();
                        input.nextLine();

                        System.out.print("Enter the description: ");
                        String description = input.nextLine();

                        System.out.print("Enter the daily cost: ");
                        float dailyCost = input.nextFloat();

                        System.out.print("Enter the status: ");
                        String status = input.nextLine();

                        EM.addEquipment(equipmentID, name, categoryID, description, dailyCost, status);
                        System.out.println(name + " was added to the system");
                    } else if (equipmentChoice == 2) {
                        System.out.print("Enter an equipment ID: ");
                        int equipmentID = input.nextInt();
                        Equipment e = EM.searchEquipment(equipmentID);
                        System.out.println(e.toString());
                    } else if (equipmentChoice == 3) {
                        System.out.print("Enter an equipment ID: ");
                        int equipmentID = input.nextInt();
                        EM.updateEquipment(equipmentID);
                        Equipment e = EM.searchEquipment(equipmentID);
                        System.out.println("Equipment was updated");
                    } else if (equipmentChoice == 4) {
                        System.out.print("Enter an equipment ID: ");
                        int equipmentID = input.nextInt();
                        EM.sellEquipment(equipmentID);
                    } else if (equipmentChoice == 5) {
                        System.out.print("Enter an equipment ID: ");
                        int equipmentID = input.nextInt();
                        EM.removeEquipment(equipmentID);
                        System.out.println("The equipment was removed");
                    } else if (equipmentChoice == 6) {
                        for (Equipment e : EM.equipList) {
                            System.out.println(e.toString());
                        }
                    } else if (equipmentChoice != 0) {
                        System.out.println("Please choose a valid option");
                    }
                } while (equipmentChoice != 0);
            } else if (choice == 3) {
                int rentalChoice = -1;
                do {
                    System.out.println("\n-----------");
                    System.out.println("Rental Page");
                    System.out.println("-----------");
                    System.out.println("Please choose an option:");
                    System.out.println("1: Add a rental");
                    System.out.println("2: Search for a rental");
                    System.out.println("3: Update a rental");
                    System.out.println("4: Remove a rental");
                    System.out.println("5: Show all rentals");
                    System.out.println("0: Back to Home Page");

                    rentalChoice = input.nextInt();
                    input.nextLine();

                    if (rentalChoice == 1) {
                        System.out.print("Enter the rental ID: ");
                        int rentalID = input.nextInt();
                        input.nextLine();

                        System.out.print("Enter the customer ID: ");
                        int customerID = input.nextInt();
                        input.nextLine();

                        System.out.print("Enter the equipment ID: ");
                        int equipmentID = input.nextInt();
                        input.nextLine();

                        System.out.print("Enter the current date: ");
                        String currentDate = input.nextLine();

                        System.out.print("Enter the rental date: ");
                        String rentalDate = input.nextLine();

                        System.out.print("Enter the return date: ");
                        String returnDate = input.nextLine();

                        System.out.print("Enter the cost: ");
                        float cost = input.nextFloat();

                        RM.addRental(rentalID, customerID, equipmentID, currentDate, rentalDate, returnDate, cost);
                        System.out.println("Rental " + rentalID + " was added to the system");
                    } else if (rentalChoice == 2) {
                        System.out.print("Enter a rental ID: ");
                        int rentalID = input.nextInt();
                        Rental r = RM.searchRental(rentalID);
                        System.out.println(r.toString());
                    } else if (rentalChoice == 3) {
                        System.out.print("Enter a rental ID: ");
                        int rentalID = input.nextInt();
                        RM.updateRental(rentalID);
                        Rental r = RM.searchRental(rentalID);
                        System.out.println("Rental was updated");
                    } else if (rentalChoice == 4) {
                        System.out.print("Enter a rental ID: ");
                        int rentalID = input.nextInt();
                        RM.removeRental(rentalID);
                        System.out.println("The rental was removed");
                    } else if (rentalChoice == 5) {
                        for (Rental r : RM.rentList) {
                            System.out.println(r.toString());
                        }
                    } else if (rentalChoice != 0) {
                        System.out.println("Please choose a valid option");
                    }
                } while (rentalChoice != 0);
            } else if (choice == 4) {
                int reportChoice = -1;
                do {
                    System.out.println("\n-----------");
                    System.out.println("Report Page");
                    System.out.println("-----------");
                    System.out.println("Please choose an option:");
                    System.out.println("1: List items by category");
                    System.out.println("2: List sales by date");
                    System.out.println("3: List sales by customer");
                    System.out.println("0: Back to Home Page");

                    reportChoice = input.nextInt();
                    input.nextLine();

                    if (reportChoice == 1) {
                        System.out.print("Enter a category ID: ");
                        int categoryID = input.nextInt();
                        reports.getItems(categoryID);
                    } else if (reportChoice == 2) {
                        System.out.print("Enter a date (yyyy-mm-dd): ");
                        String date = input.nextLine();
                        reports.getSales(date);
                    } else if (reportChoice == 3) {
                        System.out.print("Enter a customer ID: ");
                        int customerID = input.nextInt();
                        reports.getSales(customerID);
                    } else if (reportChoice != 0) {
                        System.out.println("Please choose a valid option");
                    }
                } while (reportChoice != 0);
            } else if (choice != 0) {
                System.out.println("Please choose a valid option");
            }
        } while (choice != 0);
    }
}
