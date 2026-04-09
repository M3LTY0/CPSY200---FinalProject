package manager;

import java.util.ArrayList;

import domain.equipment.Category;
import domain.equipment.Equipment;

public class EquipmentManager {
    dataconn data = new dataconn();
    ArrayList<Equipment> equipList = data.getEquipmentList();

    void addEquipment(int equipmentID, String name, int categoryID, String description, float dailyCost, String status){
        Equipment add = new Equipment(equipmentID, name, categoryID, description, dailyCost, status);
        data.addEquipmentsql(equipmentID, name, categoryID, description, dailyCost, status);
        equipList.add(add);
        }

    void removeEquipment(int equipmentID){
        Equipment select = searchEquipment(equipmentID);
        data.deleteEquipmentsql(equipmentID);
        equipList.remove(select);
    }
    
    void updateEquipment(int equipmentID){
        
    }
    
    void sellEquipment(int equipmentID){
        Equipment select = searchEquipment(equipmentID);
        System.out.println(select.getName()+" Was Sold for $"+(select.getDailyCost()*100));
        removeEquipment(equipmentID);
    }

    Equipment searchEquipment(int equipmentID){
        for(Equipment iter:equipList){
            if(iter.getEquipmentID()==equipmentID)
                return iter;
        }

        return null;
    }
    
    ArrayList<Equipment> getEquipmentList(){
        return equipList;
    }
}
