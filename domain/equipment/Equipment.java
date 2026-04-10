package domain.equipment;
public class Equipment {
    
    public Equipment(int equipmentID, String name, int categoryID, String description, float dailyCost, String status) {
        this.equipmentID = equipmentID;
        this.name = name;
        this.categoryID = categoryID;
        this.description = description;
        this.dailyCost = dailyCost;
        this.status = status;
    }

    private int equipmentID;
    private String name;
    private int categoryID;
    private String description;
    private float dailyCost;
    private String status;
    
    public int getEquipmentID() {
        return equipmentID;
    }
    public void setEquipmentID(int equipmentID) {
        this.equipmentID = equipmentID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCategoryID() {
        return categoryID;
    }
    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public float getDailyCost() {
        return dailyCost;
    }
    public void setDailyCost(float dailyCost) {
        this.dailyCost = dailyCost;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "Equipment [equipmentID=" + equipmentID + ", name=" + name + ", categoryID=" + categoryID
                + ", description=" + description + ", dailyCost=" + dailyCost + ", status=" + status + "]";
    }

    
    

    
}
