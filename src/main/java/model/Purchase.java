package model;

import java.time.Month;
import java.util.Objects;

public class Purchase {
    private Integer id;
    private Month month;
    private Buyer buyer;
    private Integer price;

    public Purchase(Integer id, Month month, Buyer buyer, Integer price) {
        this.id = id;
        this.month = month;
        this.buyer = buyer;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchase)) return false;
        Purchase purchase = (Purchase) o;
        return id.equals(purchase.id) && month == purchase.month && buyer.equals(purchase.buyer) && price.equals(purchase.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, month, buyer, price);
    }

    @Override
    public String toString() {
        return "- " + buyer.getName() +
                " " + buyer.getSurname() + " (" +
                buyer.getPhone() + "): $" +
                price;
    }
}
