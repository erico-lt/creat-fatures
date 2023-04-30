package model.dao;

import db.DB;
import model.dao.impl.*;

public class FactoryDAO{

    public static ClientDAO createClientJBDC() {
        return new ClientDaoJDBC(DB.getConnection());
    } 

    public static ItensDAO createItensJBDC() {
        return new ItensDaoJDBC();
    } 
}
