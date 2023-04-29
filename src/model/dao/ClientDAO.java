package model.dao;

import model.entites.Clients;

public interface ClientDAO {

    abstract void insertClient(Clients client);
    abstract Clients getClientfindByCod(Integer cod);
    abstract void findByAll();
}
