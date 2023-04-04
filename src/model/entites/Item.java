package model.entites;

import model.enums.ItemTypes;

public abstract class Item implements Comparable<Item>{
    private String name;
    private String model;
    private Double price;
    private int quant;
    private Integer cod_Product;
    
    public Item(String nome, String model, Double price, Integer quant) {   
        this.setName(nome);
        this.setModel(model);
        this.setPrice(price);
        this.setQuant(quant);
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
