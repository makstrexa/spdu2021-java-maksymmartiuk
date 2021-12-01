package dao;

import db.DataBase;
import model.Buyer;
import model.Purchase;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class InMemoryTestData {
    public static void generateTo(DataBase dataBase) {
        dataBase.buyers.clear();
        dataBase.purchases.clear();

        Buyer adamB = new Buyer(1, "Adam", "Brown",
                LocalDate.of(1990, Month.APRIL, 23), "097 111 22 33");
        Buyer alexF = new Buyer(2, "Alex", "Fox",
                LocalDate.of(1990, Month.APRIL, 23), "050 111 22 33");
        Buyer robertC = new Buyer(3, "Robert", "C. Martin",
                LocalDate.of(1990, Month.APRIL, 23), "097 111 33 22");
        Buyer tomH = new Buyer(4, "Tom", "Hanks",
                LocalDate.of(1990, Month.APRIL, 23), "096 222 33 44");
        Buyer billG = new Buyer(5, "Bill", "Gates",
                LocalDate.of(1990, Month.APRIL, 23), "097 777 77 77");

        List<Buyer> buyers = Arrays.asList(adamB, alexF, robertC, tomH, billG);
        buyers.forEach(buyer -> dataBase.buyers.put(buyer.getId(), buyer));


        Purchase purchase1 = new Purchase(1, Month.JUNE, adamB, 300);
        Purchase purchase2 = new Purchase(2, Month.AUGUST, adamB, 800);
        Purchase purchase3 = new Purchase(3, Month.AUGUST, alexF, 500);
        Purchase purchase4 = new Purchase(4, Month.AUGUST, robertC, 250);
        Purchase purchase5 = new Purchase(5, Month.JUNE, tomH, 200);
        Purchase purchase6 = new Purchase(6, Month.JULY, billG, 1000);
        List<Purchase> purchases = Arrays.asList(purchase1, purchase2, purchase3, purchase4, purchase5, purchase6);
        purchases.forEach(purchase -> dataBase.purchases.put(purchase.getId(), purchase));
    }
}
