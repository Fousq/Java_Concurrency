package kz.zhanbolat.concurrency.entity;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class UserAccount {
    private long id;
    private List<Currency> currencies;

    public UserAccount() {
    }

    public UserAccount(long id, List<Currency> currencies) {
        this.id = id;
        this.currencies = currencies;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Currency> getCurrencies() {
        return Collections.unmodifiableList(currencies);
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccount that = (UserAccount) o;
        return id == that.id &&
                Objects.equals(currencies, that.currencies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, currencies);
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", currencies=" + currencies +
                '}';
    }
}
