package kz.zhanbolat.concurrency.service.impl;

import kz.zhanbolat.concurrency.entity.CalculationResult;
import kz.zhanbolat.concurrency.entity.ExchangeRate;
import kz.zhanbolat.concurrency.repository.ExchangeRateRepository;
import kz.zhanbolat.concurrency.service.ExchangeRateManager;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class ExchangeRateManagerImpl implements ExchangeRateManager {
    private String path;
    private List<ExchangeRate> exchangeRates;
    private ExchangeRateRepository exchangeRateRepository;

    public ExchangeRateManagerImpl(String path, ExchangeRateRepository exchangeRateRepository) {
        this.path = path;
        this.exchangeRateRepository = exchangeRateRepository;
        exchangeRates = new ArrayList<>();
    }

    @Override
    public void loadExchangeRates() {
        exchangeRates = exchangeRateRepository.getExchangeRates(new File(path));
    }

    @Override
    public CalculationResult calculateExchangeRateCurrencyAmount(BigDecimal amount, String fromCurrency, String toCurrency) {
        return exchangeRates.stream()
                .filter(exRate -> exRate.getFrom().equals(fromCurrency) && exRate.getTo().equals(toCurrency))
                .findFirst()
                .map(rate -> new CalculationResult(amount.divide(rate.getValue(), RoundingMode.CEILING), "", false))
                .orElseGet(() -> new CalculationResult(BigDecimal.ZERO, "No such exchange rate presented", true));
    }
}
