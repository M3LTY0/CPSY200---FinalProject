package manager;

import java.util.ArrayList;
import java.util.Scanner;

import domain.equipment.Equipment;
import exceptions.EquipmentNotFoundException;

public class EquipmentManager {
    Scanner input = new Scanner(System.in);
    dataconn data = new dataconn();
    public ArrayList<Equipment> equipList = data.getEquipmentList();

    public void addEquipment(int equipmentID, String name, int categoryID, String description, float dailyCost, String status){
        Equipment add = new Equipment(equipmentID, name, categoryID, description, dailyCost, status);
        data.addEquipmentsql(equipmentID, name, categoryID, description, dailyCost, status);
        equipList.add(add);
        }

    public void removeEquipment(int equipmentID){
        Equipment select = null;
        try {
            select = searchEquipment(equipmentID);
        } catch (EquipmentNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }
        data.deleteEquipmentsql(equipmentID);
        equipList.remove(select);
    }
    
    public void updateEquipment(int equipmentID){
        Equipment select = null;
        try {
            select = searchEquipment(equipmentID);
        } catch (EquipmentNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }

        int choice = 50;
        do {
            System.out.println("What would you like to change:");
            System.out.println("1: equipmentID");
            System.out.println("2: name");
            System.out.println("3: categoryID");
            System.out.println("4: description");
            System.out.println("5: daily cost");
            System.out.println("6: status");
            System.out.println("0: Quit");

            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                System.out.println("Please enter new value for equipmentID");
                int newEquipmentID = input.nextInt();
                input.nextLine();
                select.setEquipmentID(newEquipmentID);
            } else if (choice == 2) {
                System.out.println("Please enter new value for name");
                select.setName(input.nextLine());
            } else if (choice == 3) {
                System.out.println("Please enter new value for categoryID");
                select.setCategoryID(input.nextInt());
                input.nextLine();
            } else if (choice == 4) {
                System.out.println("Please enter new value for description");
                select.setDescription(input.nextLine());
            } else if (choice == 5) {
                System.out.println("Please enter new value for daily cost");
                select.setDailyCost(input.nextFloat());
                input.nextLine();
            } else if (choice == 6) {
                System.out.println("Please enter new value for status");
                select.setStatus(input.nextLine());
            } 
        } while (choice != 0);
        data.updateEquipmentsql(select.getEquipmentID(), select.getName(), select.getCategoryID(), select.getDescription(), select.getDailyCost(), select.getStatus());
        
    }
    
    public void sellEquipment(int equipmentID){
        Equipment select = null;
        try {
            select = searchEquipment(equipmentID);
        } catch (EquipmentNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println(select.getName()+" Was Sold for $"+(select.getDailyCost()*100));
        removeEquipment(equipmentID);
    }

    public Equipment searchEquipment(int equipmentID) throws EquipmentNotFoundException{
        for(Equipment iter:equipList){
            if(iter.getEquipmentID()==equipmentID)
                return iter;
        }
        throw new EquipmentNotFoundException("No equipment found with ID: "+equipmentID);
    }

    
    public ArrayList<Equipment> getEquipmentList(){
        return equipList;
    }
}
