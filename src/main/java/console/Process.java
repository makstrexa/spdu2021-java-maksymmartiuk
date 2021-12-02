package console;

import dao.DaoFactory;
import dao.InMemoryTestData;
import db.DataBase;
import model.Purchase;
import services.BuyerService;
import services.BuyerServiceImpl;
import services.PurchaseService;
import services.PurchaseServiceImpl;

import java.time.Month;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Process {

    static BuyerService buyerService;
    static PurchaseService purchaseService;

    void init(){
        DataBase dataBase = new DataBase();

        InMemoryTestData.generateTo(dataBase);
        DaoFactory daoFactory = dataBase.getDaoFactory();
        buyerService = new BuyerServiceImpl(daoFactory);
        purchaseService = new PurchaseServiceImpl(daoFactory);
    }

    public static void main(String[] args) {
        new Process().init();

        purchaseService.logPurchase(new Purchase(-1, Month.AUGUST, buyerService.get(1), 13000));

        outputLogicWithAlreadyGeneratedDB(purchaseService, buyerService);

    }

    public static void outputLogicWithAlreadyGeneratedDB(
            PurchaseService purchaseService, BuyerService buyerService
    ) {
        List<Month> months = Arrays.asList(Month.JUNE, Month.JULY, Month.AUGUST);
        System.out.println("active buyers:");
        for (Month month: months) {
            System.out.println(month);
            Collection<Purchase> byMonth = purchaseService.getByMonth(month)
                    .stream()
                    .filter(purchase -> purchaseService.checkActiveBuyer(purchase.getBuyer()))
                    .sorted(Comparator.comparing(Purchase::getPrice).reversed())
                    .collect(Collectors.toList());
            if (byMonth.isEmpty()) System.out.println("- none");
            for (Purchase purchase: byMonth) {
                System.out.println(purchase);
            }
        }

        System.out.println("non-active buyers:");
        for (Month month: months) {
            System.out.println(month);
            Collection<Purchase> byMonth = purchaseService.getByMonth(month)
                    .stream()
                    .filter(purchase -> !purchaseService.checkActiveBuyer(purchase.getBuyer()))
                    .sorted(Comparator.comparing(Purchase::getPrice).reversed())
                    .collect(Collectors.toList());
            if (byMonth.isEmpty()) System.out.println("- none");
            for (Purchase purchase: byMonth) {
                System.out.println(purchase);
            }
        }
    }

}
