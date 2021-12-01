package model;

import java.time.LocalDate;
import java.util.Objects;

public class Buyer {
    private Integer id;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private String phone;

    public Buyer(Integer id, String name, String surname, LocalDate dateOfBirth, String phone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Buyer)) return false;
        Buyer buyer = (Buyer) o;
        return id.equals(buyer.id)
                && name.equals(buyer.name)
                && surname.equals(buyer.surname)
                && dateOfBirth.equals(buyer.dateOfBirth)
                && phone.equals(buyer.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, dateOfBirth, phone);
    }
}
