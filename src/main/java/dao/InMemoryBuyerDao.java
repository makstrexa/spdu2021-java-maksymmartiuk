package dao;

import db.DataBase;
import model.Buyer;

public class InMemoryBuyerDao extends InMemoryAbstractDao<Buyer> implements BuyerDao {

    InMemoryBuyerDao(DataBase dataBase) {
        super(dataBase.buyers,
                Buyer::getId,
                Buyer::setId,
                dataBase);
    }

}
