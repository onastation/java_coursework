package model;

public class Plant {
    int plantID;
    String name;
    String type;
    String species;
    String subspecies;
    float price;
    int amount;

    public Plant(int plantID, String name, String type, String species, String subspecies, float price, int amount) {
        this.plantID=plantID;
        this.name=name;
        this.type=type;
        this.species=species;
        this.subspecies=subspecies;
        this.price=price;
        this.amount=amount;
    }

    public void setPlantID(int plantID) {
        this.plantID = plantID;
    }
    public void setName(String name) {
        this.name=name;
    }
    public void setType(String type){
        this.type=type;
    }
    public void setSpecies(String species){
        this.species=species;
    }
    public void setSubspecies(String subspecies){
        this.subspecies=subspecies;
    }
    public void setPrice(float price){
        this.price=price;
    }
    public void setAmount(int amount){
        this.amount=amount;
    }
    public int getPlantID() {
        return plantID;
    }
    public String getName(){
        return name;
    }
    public String getType(){
        return type;
    }
    public String getSpecies(){
        return species;
    }
    public String getSubspecies(){
        return subspecies;
    }
    public float getPrice() {
        return price;
    }
    public int getAmount() {
        return amount;
    }

}