package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getClientfindByCod'");
    }

    @Override
    public void findByAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByAll'");
    }
    
}
