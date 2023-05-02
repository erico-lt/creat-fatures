package model.dao;

import java.util.List;

import model.entites.Clients;

public interface ClientDAO {
    
    abstract void insertClient(Clients client);
    abstract Clients getClientfindByCod(Integer cod);
    abstract List<Clients> findByAll();
}
