package servicetests;

import dao.DaoFactory;
import dao.InMemoryTestData;
import db.DataBase;
import model.Buyer;
import model.Purchase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.BuyerService;
import services.BuyerServiceImpl;
import services.PurchaseService;
import services.PurchaseServiceImpl;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ServiceTest {

    BuyerService buyerService;
    PurchaseService purchaseService;

    @Before
    public void init() {
        DataBase dataBase = new DataBase();

        InMemoryTestData.generateTo(dataBase);
        DaoFactory daoFactory = dataBase.getDaoFactory();
        buyerService = new BuyerServiceImpl(daoFactory);
        purchaseService = new PurchaseServiceImpl(daoFactory);
    }

    @Test
    public void testCheckActiveBuyer() {
        Buyer buyer = buyerService.get(1);
        Assert.assertTrue(purchaseService.checkActiveBuyer(buyer));
    }

    @Test
    public void testGetByMonth() {
        Collection<Purchase> augustBuyers = Arrays.asList(purchaseService.get(2),
                purchaseService.get(3), purchaseService.get(4));
        Assert.assertEquals(augustBuyers, purchaseService.getByMonth(Month.AUGUST));
    }

    @Test
    public void testLogPurchase() {
        Purchase purchase = new Purchase(-1, Month.JULY, buyerService.get(1), 1233);
        purchaseService.logPurchase(purchase);
        ArrayList<Purchase> purchases = new ArrayList<>(purchaseService.findAll());
        Assert.assertEquals(purchase, purchases.get(purchases.size() - 1));
    }

    @Test
    public void testRegBuyer() {
        Buyer buyer = new Buyer(-1, "new", "new", LocalDate.now(), "111-111");
        buyerService.registerBuyer(buyer);
        List<Buyer> buyers = new ArrayList<>(buyerService.findAll());
        Assert.assertEquals(buyer, buyers.get(buyers.size() - 1));
    }

}
