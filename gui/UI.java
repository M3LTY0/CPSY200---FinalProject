package gui;

import java.util.Scanner;

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
        int choice = 50;
        do {
            System.out.println("Please choose an option:");
            System.out.println("1: Customer page");
            System.out.println("2: Equipment page");
            System.out.println("3: Rental page");
            System.out.println("4: Report page");
            System.out.println("0: Quit");
            
            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                choice = 50;
                do {
                    System.out.println("-------------");
                    System.out.println("Customer Page");
                    System.out.println("-------------");
                    System.out.println("Please choose an option:");
                    System.out.println("1: Add a customer");
                    System.out.println("2: Search for a customer");
                    System.out.println("3: Update a customer");
                    System.out.println("4: Remove a customer");
                    System.out.println("5: Show all customers");
                    System.out.println("0: Back to Home Page");

                    choice = input.nextInt();
                    input.nextLine();

                    if (choice == 1) {
                        
                    } else if (choice == 2) {
                        System.out.println("What is the customer ID?");
                        int customerID = input.nextInt();
                        CM.searchCustomer(customerID);
                    } else if (choice == 3) {
                        
                    } else if (choice == 4) {
                        
                    } else if (choice == 5) {
                        
                    } else if (choice != 0) {
                        System.out.println("Please choose a valid option");
                    }
                } while (choice != 0);
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