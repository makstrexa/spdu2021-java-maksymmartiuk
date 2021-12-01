package services;

import model.Buyer;
import model.Purchase;

import java.time.Month;
import java.util.Collection;

public interface PurchaseService {

    void logPurchase(Purchase purchase);

    Collection<Purchase> findAllBuyerPurchase(Buyer buyer);

    boolean checkActiveBuyer(Buyer buyer);

    Collection<Purchase> getByMonth(Month month);

    Purchase get(Integer id);

    Collection<Purchase> findAll();

}
