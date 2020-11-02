package kz.zhanbolat.concurrency.service;

import kz.zhanbolat.concurrency.entity.CalculationResult;

import java.math.BigDecimal;

public interface ExchangeRateManager {
    void loadExchangeRates();
    CalculationResult calculateExchangeRateCurrencyAmount(BigDecimal amount, String fromCurrency, String toCurrency);
}
