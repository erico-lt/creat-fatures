package model.services;
import java.time.LocalDate;
import model.entites.Clients;
import model.entites.Item;
import model.entites.PurchaseOrder;
import model.entites.Store;

public class StoreServices {       

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
        } else {  // caso já exista ordem de venda mas não do usuario, o metodo vai criar uma nova ordem de venda para o cliente, na posição seguinte do tamanho total lista de de ordens da loja
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
