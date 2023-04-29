package model.dao;

import model.dao.impl.*;

public class FactoryDAO{

    public static ClientDAO createClientJBDC() {
        return new ClientDaoJDBC();
    } 

    public static ItensDAO createItensJBDC() {
        return new ItensDaoJDBC();
    } 
}
