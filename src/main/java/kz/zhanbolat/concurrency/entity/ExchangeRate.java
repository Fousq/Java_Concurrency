package kz.zhanbolat.concurrency.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;

import java.math.BigDecimal;
import java.util.Objects;

public class ExchangeRate {
    private String from;
    private String to;
    @JsonDeserialize(using = NumberDeserializers.BigDecimalDeserializer.class)
    private BigDecimal value;

    public ExchangeRate() {
    }

    public ExchangeRate(String from, String to, BigDecimal rate) {
        this.from = from;
        this.to = to;
        this.value = rate;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExchangeRate that = (ExchangeRate) o;
        return Objects.equals(from, that.from) &&
                Objects.equals(to, that.to) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, value);
    }

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", value=" + value +
                '}';
    }
}
