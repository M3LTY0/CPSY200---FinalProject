package gui;

import java.util.Scanner;

import domain.customer.Customer;
import exceptions.CustomerNotFoundException;
import manager.CustomerManager;

public class UI {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws CustomerNotFoundException {
        mainMenu();
    }

    public static void mainMenu() throws CustomerNotFoundException {
        CustomerManager CM = new CustomerManager();
        System.out.println("---------------------------");
        System.out.println("Welcome to Village Rentals!");
        System.out.println("---------------------------");
        int choice = -1;
        do {
            System.out.println("\nPlease choose an option:");
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
                System.out.println("Equipment Page");
            } else if (choice == 3) {
                System.out.println("Rental Page");
            } else if (choice == 4) {
                System.out.println("Report Page");
            } else if (choice != 0) {
                System.out.println("Please choose a valid option");
            }
        } while (choice != 0);
    }
}
