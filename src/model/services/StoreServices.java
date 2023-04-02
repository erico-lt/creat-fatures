package model.services;
import java.time.LocalDate;
import model.entites.Clients;
import model.entites.Item;
import model.entites.PurchaseOrder;
import model.entites.Store;
import model.entites.intens.Ball;
import model.entites.intens.Bike;
import model.entites.intens.Pen;
import model.entites.intens.Skate;
import model.entites.intens.Tv;
import model.enums.ItemTypes;

public class StoreServices {    

    public void addItensInStock(Store store) {
        store.addItemInStock(ItemTypes.BALL, "Cup", 20.50, 01, 50);
        store.addItemInStock(ItemTypes.BIKE, "Monark", 3000.00, 02, 200);
        store.addItemInStock(ItemTypes.PEN, "Faber Castel", 1.50, 03, 3200);
        store.addItemInStock(ItemTypes.SKATE, "Ace Trucks", 400.00, 04, 500);
        store.addItemInStock(ItemTypes.TV, "Samsung", 2500.00, 05, 500);
    }

    public Item verificItemOfAdd(ItemTypes type, String model, Double price) {
        if (type.equals(ItemTypes.BALL)) {
            return new Ball(model, price, ItemTypes.BALL);
        } else if (type.equals(ItemTypes.BIKE)) {
            return new Bike(model, price, ItemTypes.BIKE);
        } else if (type.equals(ItemTypes.PEN)) {
            return new Pen(model, price, ItemTypes.PEN);
        } else if (type.equals(ItemTypes.SKATE)) {
            return new Skate(model, price, ItemTypes.SKATE);
        } else if (type.equals(ItemTypes.TV)) {
            return new Tv(model, price, ItemTypes.TV);
        }
        return null;
    }

    public void checkHaveOrderClient(Store store, Clients client, Item item) {  //Estou verificando se na lojá já esxiste ordens de venda, caso não ouver, será criada  
        if (store.getPurchaseOrder().isEmpty()) {                               //uma lista na posição inicial e vai adicionar o item logo em seguida               
            store.getPurchaseOrder().add(new PurchaseOrder(LocalDate.now(), 0, client.getCodCliente()));
            store.getPurchaseOrder().get(0).addItemForSale(item);
        } else if (this.purchaseOrOrderExist(client.getCodCliente(), store)) {  // caso já exista ordens de venda desse cliente , vai buscar na lista, pela ordem e adicionar o item nela
            for (PurchaseOrder x : store.getPurchaseOrder()) {
                if (x.getCod_Client() == client.getCodCliente()) {
                    x.addItemForSale(item);
                }
            }
        } else {  // caso já exista ordem de venda mas não do usuario, o metodo vai criar uma nova ordem de venda para o cliente, em uma posição a mais do tamanha da lista de de ordens da loja
            store.getPurchaseOrder().add(new PurchaseOrder(LocalDate.now(), store.getPurchaseOrder().size() + 1, client.getCodCliente()));
            this.checkHaveOrderClient(store, client, item);
        }
    }  

    public boolean purchaseOrOrderExist(Integer cod_Client, Store store) {
        for (PurchaseOrder x : store.getPurchaseOrder()) {
            if (x.getCod_Client().equals(cod_Client)) {
                return true;
            }
        }
        return false;
    }    
}
