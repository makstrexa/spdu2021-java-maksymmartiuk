package services;

import model.Buyer;

import java.util.Collection;

public interface BuyerService {

    void registerBuyer(Buyer buyer);

    Collection<Buyer> findAll();

    Buyer get(Integer id);

}
