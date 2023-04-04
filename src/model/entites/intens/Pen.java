package model.entites.intens;

import model.entites.Item;

public class Pen extends Item{

    public Pen(String nome, String model, Double price, Integer quant) {
        super(nome, model, price, quant);       
    }

    @Override
    public int compareTo(Item item) {        
        return this.getCod_Product().compareTo(item.getCod_Product());
    }
    
}
