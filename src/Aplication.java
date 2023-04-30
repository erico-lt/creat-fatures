import model.dao.ClientDAO;
import model.dao.FactoryDAO;
import model.entites.Clients;

public class Aplication {
    public static void main(String[] args){    
        
        ClientDAO clientDao = FactoryDAO.createClientJBDC();
        Clients client = clientDao.getClientfindByCod(1);
        System.out.println(client.toString());
               
        /* Locale.setDefault(Locale.US);        
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
        }  */
        
    }
}

