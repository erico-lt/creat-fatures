import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;
import java.sql.*;

import db.DB;
import db.DbException;
import model.UI;
import model.entites.Clients;
import model.entites.Item;
import model.entites.Store;
import model.entites.client.PessoaJuridica;
import model.entites.intens.Pen;
import model.services.PaypalService;


public class Aplication {
    public static void main(String[] args){     
         
        Connection con = null;   
        Statement st = null;
        ResultSet rs = null;    
        PreparedStatement ps = null;
        try {

            con = DB.getConnection();
            con.setAutoCommit(false);
            st = con.createStatement();            
            rs = st.executeQuery("SELECT * FROM products WHERE cod = 0");
            if (rs.next()) {
                Item pen = new Pen(rs.getString("nome"), rs.getString("marca"), rs.getDouble("preco"), rs.getInt("quant"));
                Integer quantDeb = 50;     
                String nameItem = pen.getName().toLowerCase(); 

                String sql = "UPDATE products SET quant = ? WHERE (nome = ?)";
                
                ps = con.prepareStatement(sql);
                ps.setDouble(1, pen.getQuant() - quantDeb);
                ps.setString(2, nameItem);
                pen.setQuant(quantDeb);
                int rows = ps.executeUpdate();
                System.out.println("Success!!, Rows: " + rows);
            } else {
                throw new SQLException("No records found");
            }                        
            
            con.commit();
        } catch (SQLException e) {
            try {
                con.rollback();
                throw new DbException("[ERRO] failure update! cause by: " + e.getMessage());
            } catch (Exception e1) {
                throw new DbException("Rollback failure" + e1.getMessage());
            }            
        } finally {
            DB.closeConnection(con);
            DB.closeResult(rs);
            DB.closeStatment(st);
        }
        
        /* Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in); 
        PaypalService paypalService = new PaypalService();       
        Store store = new Store("Sport e Lazer", paypalService);   
        Clients adm = new PessoaJuridica(0, "Erico"); 
        store.addClients(adm);
        store.items();        
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
