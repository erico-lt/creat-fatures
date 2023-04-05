package model.entites;

import java.util.ArrayList;
import java.util.List;

import db.DB;
import model.exception.StoreException;
import model.interfaces.OlinePaymentService;
import model.services.StoreServices;

public class Store {
    private String name;

    private List<Clients> clients = new ArrayList<Clients>();
    private Stock stock = new Stock("Stock #1");
    private List<PurchaseOrder> PurchaseOrder = new ArrayList<PurchaseOrder>();
    private StoreServices storeServices = new StoreServices();
    private OlinePaymentService olinePaymentService;

    public Store(String name, OlinePaymentService olinePaymentService) {
        this.setName(name);
        this.setOlinePaymentService(olinePaymentService);
    }

    public void addClients(Clients client) {
        if (this.clientExist(client.getCodCliente())) {
            throw new StoreException("Erro cliente já esxiste tente outro");
        } else {
            this.getClients().add(client);
        }
    }

    public boolean clientExist(Integer cod_Client) {
        if (this.getClients().stream().anyMatch(cli -> cli.getCodCliente().equals(cod_Client))) {
            return true;
        } else {
            return false;
        }
    }

    public Clients getClient(Integer codClient) {
        return this.getClients().stream().filter(cli -> cli.getCodCliente().equals(codClient)).findFirst().orElse(null);
    }    

    public void itemsForSale() {
        DB.viewItems("products");
    }

    public void installmentOfClients(Integer cod_Client) {
        if (this.getPurchaseOrder().stream().anyMatch(p -> p.getCod_Client().equals(cod_Client))) {
            PurchaseOrder purchase = this.getPurchaseOrder().stream().filter(p -> p.getCod_Client().equals(cod_Client)).findFirst().orElse(null);
            System.out.println("Cod Client: " + purchase.getCod_Client());
            System.out.println("Value order: " + purchase.getValueOrder());
            System.out.println("______________________");
            purchase.getListInstallment().forEach(System.out::println);
        }
    }

    public void addItemInStock(Integer codProduct, Integer quantity) {
        Item item = DB.verificItemForSale(codProduct, quantity);
        stock.addItem(item, codProduct, quantity);
    }

    public void checkHaveOrder(Integer codProduct, Integer quant, Clients client) {        
        Item itemForPurchaseOrder = DB.verificItemForSale(codProduct, quant);
        if (itemForPurchaseOrder != null) {
            storeServices.checkHaveOrderClient(this, client, itemForPurchaseOrder);
        }
    }

    public void viewItenOfClient(Clients client) {
        if (!this.clientExist(client.getCodCliente())) {
            throw new StoreException("[ERRO] client not exist");
        } else if (!this.orderExist(client.getCodCliente())) {
            throw new StoreException("[ERRO] Purchase order not exsist");
        }
        PurchaseOrder purch = this.getPurchaseOrder().stream().filter(p -> p.getCod_Client().equals(client.getCodCliente())).findFirst().orElse(null);
        System.out.println("Value order: " + purch.getValueOrder());
        purch.getRequestList().forEach(System.out::println);        
    }

    public boolean orderExist (Integer cod_Client) {
        return this.getPurchaseOrder().stream().anyMatch(p -> p.getCod_Client().equals(cod_Client));
    }

    public PurchaseOrder returnOrderForPayment (Integer cod_Clinet) {
        if(!this.orderExist(cod_Clinet)) {
            throw new StoreException("[ERRO] in order, verific cod client");
        } else {
            return this.getPurchaseOrder().stream().filter(p -> p.getCod_Client().equals(cod_Clinet)).findFirst().orElse(null);
        }
    }    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Clients> getClients() {
        return clients;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public List<PurchaseOrder> getPurchaseOrder() {
        return PurchaseOrder;
    }

    public OlinePaymentService getOlinePaymentService() {
        return olinePaymentService;
    }

    public void setOlinePaymentService(OlinePaymentService olinePaymentService) {
        this.olinePaymentService = olinePaymentService;
    }

    @Override
    public String toString() {
        return this.getName();
    }

}
