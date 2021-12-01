package db;

import dao.DaoFactory;
import dao.InMemoryDaoFactory;
import model.Buyer;
import model.Purchase;

import java.util.Map;
import java.util.TreeMap;

public class DataBase {

    public Map<Integer, Purchase> purchases;
    public Map<Integer, Buyer> buyers;

    public DataBase() {
        purchases = new TreeMap<>();
        buyers = new TreeMap<>();
    }

    public DaoFactory getDaoFactory() {
        return new InMemoryDaoFactory(this);
    }

}
