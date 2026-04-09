package domain.equipment;
public class Equipment {
    
    public Equipment(int equipmentID, String name, Category category, String description, float dailyCost,
            String categoryName, Status status) {
        this.equipmentID = equipmentID;
        this.name = name;
        this.category = category;
        this.description = description;
        this.dailyCost = dailyCost;
        this.categoryName = categoryName;
        this.status = status;
    }

    private int equipmentID;
    private String name;
    private Category category;
    private String description;
    private float dailyCost;
    private String categoryName;
    private Status status;
    
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
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
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
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    

    
}
