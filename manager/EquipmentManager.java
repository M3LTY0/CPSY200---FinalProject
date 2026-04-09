package manager;

import java.util.ArrayList;

import domain.equipment.Category;
import domain.equipment.Equipment;

public class EquipmentManager {
    ArrayList<Equipment> equipList;

    void addEquipment(int equipmentID, String name, int categoryID, String description, float dailyCost, String status){
        Equipment add = new Equipment(equipmentID, name, categoryID, description, dailyCost, status);
        }


    void removeEquipment(){}
    Equipment searchEquipment(){}
    void sellEquipment(){}
    void getEquipmentList(){

    }
    void writeEquipmentFile(){}
    Equipment readEquipmentFile(){}
}
