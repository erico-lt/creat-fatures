import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.UI;
import model.dao.ClientDAO;
import model.dao.FactoryDAO;
import model.entites.Clients;
import model.entites.Store;
import model.services.PaypalService;

public class Aplication {
    public static void main(String[] args){    
        
        ClientDAO clientDao = FactoryDAO.createClientJBDC();
        List<Clients> client = clientDao.findByAll();
        client.forEach(System.out::println);        
               
       /*  Locale.setDefault(Locale.US);        
        Scanner input = new Scanner(System.in); 
        PaypalService paypalService = new PaypalService();       
        Store store = new Store("Sport e Lazer", paypalService);                   
        while(true) {
            try {
                UI.initialLogin(store, input);
            }
            catch(RuntimeException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            }
        } */  
        
    }
}

