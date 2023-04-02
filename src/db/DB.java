package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

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

    public static Properties loadProperties() {
        try (FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException erro) {
            throw new DbException(erro.getMessage());
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
