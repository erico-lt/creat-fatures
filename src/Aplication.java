import java.util.Locale;
import java.util.Scanner;

import db.DB;
import model.UI;
import model.entites.Store;
import model.services.PaypalService;


public class Aplication {
    public static void main(String[] args){

        try{
            DB.creatTableProduct();
        }
        finally {
            
        }        

        /*Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in); 
        PaypalService paypalService = new PaypalService();       
        Store store = new Store("Sport e Lazer", paypalService);           
        store.items();        
        while(true) {
            try {
                UI.initialLogin(store, input);
            }
            catch(RuntimeException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            }
        }*/
        
    }
}
