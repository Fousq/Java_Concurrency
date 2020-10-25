package kz.zhanbolat.concurrency.entity;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Currency {
    private String name;
    private BigDecimal amount;
    private List<ExchangeCurrency> exchangeCurrencies;

    public Currency() {
    }

    public Currency(String name, BigDecimal amount, List<ExchangeCurrency> exchangeCurrencies) {
        this.name = name;
        this.amount = amount;
        this.exchangeCurrencies = exchangeCurrencies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public List<ExchangeCurrency> getExchangeCurrencies() {
        return Collections.unmodifiableList(exchangeCurrencies);
    }

    public void setExchangeCurrencies(List<ExchangeCurrency> exchangeCurrencies) {
        this.exchangeCurrencies = exchangeCurrencies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return Objects.equals(name, currency.name) &&
                Objects.equals(amount, currency.amount) &&
                Objects.equals(exchangeCurrencies, currency.exchangeCurrencies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amount, exchangeCurrencies);
    }

    @Override
    public String toString() {
        return "Currency{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", exchangeCurrencies=" + exchangeCurrencies +
                '}';
    }
}
