package model.entites;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.entites.intens.Ball;
import model.entites.intens.Bike;
import model.entites.intens.Pen;
import model.entites.intens.Skate;
import model.entites.intens.Tv;
import model.enums.ItemTypes;

public class Stock {
    private String name;    
    private List<Item> list = new ArrayList<>();   
    

    public Stock(String name) {
        this.setName(name);
    } 

    public void addItem(Item item, Integer cod_Product, Integer quant_Stock) {        
        item.setCod_Product(cod_Product);
        item.setQuant(quant_Stock);
        list.add(item);   
        Collections.sort(list);
    }

    public Item checkItemForSale(String name, int quant) {
        for(Item item: list) {
            if(item.getName().toUpperCase().equals(name) && item.getQuant() > 0 && item.getQuant() >= quant) {
                Item itemforSale = verificTypeItem(item); 
                itemforSale.setQuant(quant); 
                itemforSale.setCod_Product(item.getCod_Product());                              
                item.setQuant(item.getQuant() - quant);                
                return itemforSale;
            }
        }
        return null;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    

    public List<Item> getList() {
        return list;
    } 
    
    public void setList(List<Item> list) {
        this.list = list;
    }
  
}