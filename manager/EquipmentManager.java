package manager;

import java.util.ArrayList;

import domain.equipment.Category;
import domain.equipment.Equipment;
import domain.equipment.Status;

public class EquipmentManager {
    ArrayList<Equipment> equipList;

    void addEquipment(int equipmentID, String name, Category category, String description, float dailyCost,String categoryName, Status status){
        Equipment add = new Equipment(equipmentID, name, category, description, dailyCost, categoryName, status);
        }


    void removeEquipment(){}
    Equipment searchEquipment(){}
    void sellEquipment(){}
    void getEquipmentList(){
        
    }
    void writeEquipmentFile(){}
    Equipment readEquipmentFile(){}
}
