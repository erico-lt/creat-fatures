package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
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

    public static void insertSeller(PreparedStatement ps, String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        try {
           ps = getConnection().prepareStatement("INSERT INTO seller " + 
           "(Name, Email, BirthDate, BaseSalary, DepartamentId)"
            + "VALUE (?,?,?,?,?)");

           ps.setString(1, "Erico");
           ps.setString(2, "erico.blp@gmail.com");
           ps.setDate(3, new java.sql.Date(sdf.parse(date).getTime()));
           ps.setDouble(4, 3500);
           ps.setInt(5, 2);

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
