package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import model.entites.Item;

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

    public static Properties loadProperties() {
        try (FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException erro) {
            throw new DbException(erro.getMessage());
        }
    }

    // Crianção da tabela de productos
    public static void creatTableProducts() {
        String sql = "CREATE TABLE products("
                + "id INT(4) NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                + "name VARCHAR(20) NOT NULL,"
                + "model VARCHAR(220) NOT NULL,"
                + "price DECIMAL(10,2) NOT NULL,"
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

    // Merodo para adicionar itens na table de productos
    public static void insertProduct(String name, String marca, Double preco, Integer quant, Integer cod) {
        try {
            PreparedStatement ps = getConnection().prepareStatement("INSERT INTO products" +
                    "(name, model, price, quant, cod)"
                    + "VALUE (?,?,?,?,?)");

            ps.setString(1, name);
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

    public static void removeItem(String table, Integer cod_ProOrItem) {
        PreparedStatement ps = null;
        Connection con = null;
        String sql = "DELETE FROM " + table + " WHERE id = ?";
        try {
            con = getConnection();
            con.setAutoCommit(false);
            ps = getConnection().prepareStatement(sql);
            ps.setInt(1, cod_ProOrItem);
            int rowsAffected = ps.executeUpdate();
            con.commit();
            System.out.println("Deleted with success! rows: " + rowsAffected);
        } catch (SQLException e) {
            try {
                con.rollback();
                throw new DbException("[ERRO] failured delete, rollback! Erro by: " + e.getMessage());                
            } catch (Exception e1) {
                throw new DbException("[Erro] rollback erro!");
            }
        }

    }

    public static void viewItems(String tableName) {
        try {
            Statement st = getConnection().createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM " + tableName);
            while (rs.next()) {
                System.out.println(rs.getInt("Id") + ", " + rs.getString("name"));
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

    }

    public static Item verificItemForSale(Integer codProduct, Integer quant) {
        Item item = null;
        if (quant <= 0) {
            throw new DbException("Qauntity required is equals 0 or less than 0");
        }
        String cod = Integer.toString(codProduct);
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            con = getConnection();
            con.setAutoCommit(false);
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM products WHERE cod = " + cod);

            if (rs.next()) {
                if (rs.getInt("quant") <= quant) {
                    throw new DbException("[ERRO] quantity not disponible in stock");
                } else {
                    item = new Item(rs.getString("name"), rs.getString("model"), rs.getDouble("price"),            
                    rs.getInt("quant") - (rs.getInt("quant") - quant));
                    ps = con.prepareStatement("UPDATE products SET quant = ? WHERE (cod = ?)");
                    ps.setInt(1, rs.getInt("quant") - quant);
                    ps.setInt(2, item.getCod_Product());
                    int rows = ps.executeUpdate();
                    System.out.println("Success!!, Rows: " + rows);
                    con.commit();
                }
            }            

        } catch (SQLException e) {
            try {
                con.rollback();
                throw new DbException("[ERRO] order rolled back! Caused by: " + e.getMessage());
            } catch (SQLException e1) {
                throw new DbException("[ERRO] failure in rollback! " + e1.getMessage());
            }
        } finally {
            closeConnection(con);
            closeResult(rs);
            closeStatment(st);
            closeStatment(ps);
        }
        return item;
    }

    public static void closeConnection(Connection conn) {
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
