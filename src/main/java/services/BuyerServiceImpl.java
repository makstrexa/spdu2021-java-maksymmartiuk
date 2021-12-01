package services;

import dao.DaoFactory;
import model.Buyer;
import model.Purchase;

import java.util.Collection;
import java.util.stream.Collectors;

public class BuyerServiceImpl implements BuyerService {

    DaoFactory daoFactory;

    public BuyerServiceImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void registerBuyer(Buyer buyer) {
        daoFactory.getBuyerDao().insert(buyer, true);
    }

    @Override
    public Collection<Buyer> findAll() {
        return daoFactory.getBuyerDao().findAll();
    }

    @Override
    public Buyer get(Integer id) {
        return daoFactory.getBuyerDao().get(id);
    }
}
