package model.entites.intens;

import model.entites.Item;

public class Tv extends Item {

    public Tv(String model, Double price, Integer quant) {
        super(model, price, quant);
    }

    @Override
    public int compareTo(Item item) {
        return this.getCod_Product().compareTo(item.getCod_Product());
    }
}
