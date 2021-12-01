package dao;

import db.DataBase;

public class InMemoryDaoFactory implements DaoFactory {

    DataBase dataBase;

    PurchaseDao purchaseDao;
    BuyerDao buyerDao;

    public InMemoryDaoFactory(DataBase dataBase) {
        this.dataBase = dataBase;

        purchaseDao = new InMemoryPurchaseDao(dataBase);
        buyerDao = new InMemoryBuyerDao(dataBase);
    }

    @Override
    public PurchaseDao getPurchaseDao() {
        return purchaseDao;
    }

    @Override
    public BuyerDao getBuyerDao() {
        return buyerDao;
    }
}
