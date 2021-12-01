package dao;

public interface DaoFactory {

    BuyerDao getBuyerDao();

    PurchaseDao getPurchaseDao();

}
