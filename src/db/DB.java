package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Properties;

import model.enums.ItemTypes;

public class DB {
    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);
                System.out.println("Connection sucess");
            } catch (SQLException erro) {
                throw new DbException(erro.getMessage());
            }

        }
        return conn;
    }   

    //Crianção da tabela de productos
    public static void creatTableProducts() {
       String sql =  "CREATE TABLE products("
        + "id INT(4) NOT NULL AUTO_INCREMENT PRIMARY KEY,"
        + "nome VARCHAR(20) NOT NULL," 
        + "marca VARCHAR(220) NOT NULL,"
        + "preco DECIMAL(10,2) NOT NULL,"
        + "quant INT(5) NOT NULL,"
        + "cod INT(5) NOT NULL);";
        try {
            Statement stm = getConnection().createStatement();
            stm.executeUpdate(sql);
            System.out.println("Table create success");                         
            stm.close();            
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        
    }

    //Merodo para adicionar itens na table de productos
    public static void insertProduct(String nome, String marca, Double preco, Integer quant, Integer cod) {       
        try {
            PreparedStatement ps = getConnection().prepareStatement("INSERT INTO products" + 
           "(nome, marca, preco, quant, cod)"
            + "VALUE (?,?,?,?,?)");

           ps.setString(1, nome);
           ps.setString(2, marca);
           ps.setDouble(3, preco);
           ps.setInt(4, quant);
           ps.setInt(5, cod);           

           int value = ps.executeUpdate();
           System.out.println("rows affected: " + value);

        } catch (Exception e) {
            throw new DbException(e.getMessage());
        }
        
    }

    public static Properties loadProperties() {
        try (FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException erro) {
            throw new DbException(erro.getMessage());
        }
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Conecction is closed");
            } catch (SQLException erro) {
                throw new DbException(erro.getMessage());
            }
        }

    }

    public static void closeStatment(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void viewItems(ResultSet rs) {
        try {
            while (rs.next()) {
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
            }
        }
        catch(SQLException e) {
            throw new DbException(e.getMessage());
        }
        
    }

    public static void closeResult(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    /*
     * public static int ExectQuery(String sql) {
     * try {
     * return sqlmgr.executeUpdate(sql); // insert/delete/create
     * } catch (SQLException erro) {
     * System.out.println("[ERRO] erro in database" + erro.getMessage());
     * }
     * 
     * return -1;
     * }
     */
}
