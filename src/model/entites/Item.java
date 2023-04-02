package model.entites;

import model.enums.ItemTypes;

public abstract class Item implements Comparable<Item>{
    private String name;
    private String model;
    private Double price;
    private int quant;
    private Integer cod_Product;
    private ItemTypes type;
  
    public Item(String model, Double price, ItemTypes type) {  
        if(type.equals(ItemTypes.BALL)) {
            this.setName("Ball");
        } else if(type.equals(ItemTypes.BIKE)) {
            this.setName("Bike");
        } else if(type.equals(ItemTypes.PEN)) {
            this.setName("Pen");
        } else if(type.equals(ItemTypes.SKATE)) {
            this.setName("Skate");
        } else {
            this.setName("Tv");
        }        
        this.setModel(model);
        this.setPrice(price);
        this.setType(type);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    
    }    
    public void setPrice(double price) {
        this.price = price;
    }

    public ItemTypes getType() {
        return type;
    }

    public void setType(ItemTypes type) {
        this.type = type;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public Integer getCod_Product() {
        return cod_Product;
    }

    public void setCod_Product(Integer cod_Product) {
        this.cod_Product = cod_Product;
    }    

    @Override 
    public String toString() {
        return "Name: " + this.getName() +
        "\nModel: " + this.getModel() + 
        "\nPrice: " + this.getPrice() + 
        "\nQuantity: " + this.getQuant() + 
        "\n_____________________";       
    }

}
