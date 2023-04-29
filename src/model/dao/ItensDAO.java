package model.dao;

import model.entites.Item;

public interface ItensDAO {
    
    abstract void insetProduct(Item item);
    abstract void removeItemByCod(Integer cod);
    abstract Item getItemfindCod(Integer cod); 
    abstract void updateItemByCod(Integer cod);
    abstract void findByAll();
}
