package services;

import dao.DaoFactory;
import model.Buyer;
import model.Purchase;

import java.time.Month;
import java.util.Collection;
import java.util.stream.Collectors;

public class PurchaseServiceImpl implements PurchaseService {

    DaoFactory daoFactory;

    public PurchaseServiceImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void logPurchase(Purchase purchase) {
        daoFactory.getPurchaseDao().insert(purchase, true);
    }

    @Override
    public Collection<Purchase> findAllBuyerPurchase(Buyer buyer) {
        return daoFactory.getPurchaseDao().findAll()
                .stream()
                .filter(purchase -> purchase.getBuyer().equals(buyer))
                .collect(Collectors.toList());
    }

    @Override
    public boolean checkActiveBuyer(Buyer buyer) {
        return findAllBuyerPurchase(buyer)
                .stream()
                .anyMatch(purchase -> purchase.getMonth().equals(Month.AUGUST));
    }

    @Override
    public Collection<Purchase> getByMonth(Month month) {
        return daoFactory.getPurchaseDao().findAll()
                .stream()
                .filter(purchase -> purchase.getMonth() == month)
                .collect(Collectors.toList());
    }

    @Override
    public Purchase get(Integer id) {
        return daoFactory.getPurchaseDao().get(id);
    }

    @Override
    public Collection<Purchase> findAll() {
        return daoFactory.getPurchaseDao().findAll();
    }
}
