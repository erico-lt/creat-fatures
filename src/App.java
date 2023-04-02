import java.sql.*;
import db.DB;

public class App {
    public static void main(String[] args){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DB.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from department seller");            
            DB.viewItems(rs);
        }
        catch (SQLException erro) {
            erro.printStackTrace();
        } 
        finally {
            DB.closeResult(rs);
            DB.closeStatment(st);
            DB.closeConnection();
        }
    }
}
