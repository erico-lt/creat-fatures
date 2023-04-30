package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;
import db.DbException;
import model.dao.ClientDAO;
import model.entites.Clients;

public class ClientDaoJDBC implements ClientDAO{

    private Connection conn;

    public ClientDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertClient(Clients client) {
        PreparedStatement ps = null;
        String dml = "INSERT INTO clients("
        + "name, email, telephone, address, cpf_cnpj, cod)"
        + " VALUES (?,?,?,?,?,?);";       

        try {
            ps = conn.prepareStatement(dml);
            ps.setString(1, client.getName());
            ps.setString(2, client.getEmail());
            ps.setLong(3, client.getTelephone()); 
            ps.setString(4, client.getAddress());
            ps.setLong(5, client.getCpf_cnpj());
            ps.setInt(6, client.getCodCliente());  
            int rowsAfected = ps.executeUpdate();        
            System.out.printf("Success!!, rows affected %d \n", rowsAfected);  
        } catch (SQLException e) {
            throw new DbException("[ERRO] By: " + e.getMessage());
        } finally {
            DB.closeStatment(ps);
        }
    }

    @Override
    public Clients getClientfindByCod(Integer cod) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Clients client = null;
        String dql = "SELECT * FROM clients WHERE (cod = ?);";

        try {
            ps = conn.prepareStatement(dql);
            ps.setInt(1, cod);
            rs = ps.executeQuery();
            if(rs.next()) {
                client = instantClients(rs);
            }        

            return client;
        } catch (SQLException e) {
            throw new DbException("[ERRO] by: " + e.getMessage());
        } finally {
            DB.closeResult(rs);
            DB.closeStatment(ps);
        }
    }

    @Override
    public void findByAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByAll'");
    }

    public Clients instantClients(ResultSet rs) throws SQLException {
        String name = rs.getString("name");
        String email = rs.getString("email");
        long telephone = rs.getLong("telephone");
        String address = rs.getString("address");
        long cpf_cnpj = rs.getLong("cpf_cnpj");
        Integer cod = rs.getInt("cod");
        return new Clients(name, telephone, email, address, cod, cpf_cnpj);
    }
    
}
