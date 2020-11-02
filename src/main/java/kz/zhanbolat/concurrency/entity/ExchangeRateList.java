package kz.zhanbolat.concurrency.entity;

import java.util.List;

public class ExchangeRateList {
    private List<ExchangeRate> exchangeRates;

    public ExchangeRateList() {
    }

    public List<ExchangeRate> getExchangeRates() {
        return exchangeRates;
    }

    public void setExchangeRates(List<ExchangeRate> exchangeRates) {
        this.exchangeRates = exchangeRates;
    }

}
