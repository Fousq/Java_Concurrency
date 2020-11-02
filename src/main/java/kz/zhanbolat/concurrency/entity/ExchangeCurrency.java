package kz.zhanbolat.concurrency.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class ExchangeCurrency {
    private String name;
    private BigDecimal amount;
    // This field is used to write warning if the exchange rate for this currency is not defined
    private String warning;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime exchangeDateTime;

    public ExchangeCurrency() {
    }

    public ExchangeCurrency(String name, BigDecimal amount, String warning, LocalDateTime timestamp) {
        this.name = name;
        this.amount = amount;
        this.warning = warning;
        this.exchangeDateTime = timestamp;
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

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    public LocalDateTime getExchangeDateTime() {
        return exchangeDateTime;
    }

    public void setExchangeDateTime(LocalDateTime exchangeDateTime) {
        this.exchangeDateTime = exchangeDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExchangeCurrency that = (ExchangeCurrency) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(warning, that.warning) &&
                Objects.equals(exchangeDateTime, that.exchangeDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amount, warning, exchangeDateTime);
    }

    @Override
    public String toString() {
        return "ExchangeCurrency{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", warning='" + warning + '\'' +
                ", timestamp=" + exchangeDateTime +
                '}';
    }
}
