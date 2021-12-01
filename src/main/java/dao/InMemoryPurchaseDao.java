package dao;

import db.DataBase;
import model.Purchase;

public class InMemoryPurchaseDao extends InMemoryAbstractDao<Purchase> implements PurchaseDao {
    public InMemoryPurchaseDao(DataBase dataBase){
        super(dataBase.purchases,
                Purchase::getId,
                Purchase::setId,
                dataBase);
    }

}
