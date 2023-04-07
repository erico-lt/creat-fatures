import java.util.Locale;
import java.util.Scanner;

import model.UI;
import model.entites.Clients;
import model.entites.Store;
import model.entites.client.PessoaJuridica;
import model.services.PaypalService;

public class Aplication {
    public static void main(String[] args){                 
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in); 
        PaypalService paypalService = new PaypalService();       
        Store store = new Store("Sport e Lazer", paypalService);   
        Clients adm = new PessoaJuridica(0, "Erico"); 
        Clients adm2 = new PessoaJuridica(1, "julia"); 
        store.addClients(adm2);
        store.addClients(adm);              
        while(true) {
            try {
                UI.initialLogin(store, input);
            }
            catch(RuntimeException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            }
        } 
        
    }
}

