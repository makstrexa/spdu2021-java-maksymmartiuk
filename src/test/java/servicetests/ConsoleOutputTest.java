package servicetests;

import console.Process;
import dao.DaoFactory;
import dao.InMemoryTestData;
import db.DataBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.BuyerService;
import services.BuyerServiceImpl;
import services.PurchaseService;
import services.PurchaseServiceImpl;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ConsoleOutputTest {

    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    private static final String expected = "active buyers:\r\n" +
            "JUNE\r\n" +
            "- Adam Brown (097 111 22 33): $300\r\n" +
            "JULY\r\n" +
            "- none\r\n" +
            "AUGUST\r\n" +
            "- Adam Brown (097 111 22 33): $800\r\n" +
            "- Alex Fox (050 111 22 33): $500\r\n" +
            "- Robert C. Martin (097 111 33 22): $250\r\n" +
            "non-active buyers:\r\n" +
            "JUNE\r\n" +
            "- Tom Hanks (096 222 33 44): $200\r\n" +
            "JULY\r\n" +
            "- Bill Gates (097 777 77 77): $1000\r\n" +
            "AUGUST\r\n" +
            "- none\r\n";

    static BuyerService buyerService;
    static PurchaseService purchaseService;

    @Before
    public void initData() {
        DataBase dataBase = new DataBase();

        InMemoryTestData.generateTo(dataBase);
        DaoFactory daoFactory = dataBase.getDaoFactory();
        buyerService = new BuyerServiceImpl(daoFactory);
        purchaseService = new PurchaseServiceImpl(daoFactory);
    }


    @Test
    public void checkOutput() {
        Process.outputLogicWithAlreadyGeneratedDB(purchaseService, buyerService);
        Assert.assertEquals(expected, output.toString());
    }

}
