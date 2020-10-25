package kz.zhanbolat.concurrency.service;

import kz.zhanbolat.concurrency.entity.CalculationResult;
import kz.zhanbolat.concurrency.entity.Currency;
import kz.zhanbolat.concurrency.entity.ExchangeCurrency;
import kz.zhanbolat.concurrency.entity.UserAccount;
import kz.zhanbolat.concurrency.exception.FailedLoadUserAccountException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserAccountActualizator implements Runnable {
    private static final Logger logger = LogManager.getLogger(UserAccountActualizator.class);
    private final AccountManager accountManager;
    private final ExchangeRateManager exchangeRateManager;

    public UserAccountActualizator(AccountManager accountManager, ExchangeRateManager exchangeRateManager) {
        this.accountManager = accountManager;
        this.exchangeRateManager = exchangeRateManager;
    }

    @Override
    public void run() {
        while (true) {
            exchangeRateManager.loadExchangeRates();
            try {
                accountManager.loadAccount();
            } catch (FailedLoadUserAccountException e) {
                logger.error(e);
                break;
            }
            UserAccount userAccount = accountManager.getUserAccount();
            for (Currency currency : userAccount.getCurrencies()) {
                List<ExchangeCurrency> exchangeCurrencies = new ArrayList<>();
                for (ExchangeCurrency exchangeCurrency : currency.getExchangeCurrencies()) {
                    CalculationResult calculationResult = exchangeRateManager.calculateExchangeRateCurrencyAmount(currency.getAmount(),
                            currency.getName(), exchangeCurrency.getName());
                    ExchangeCurrency updateExchangeCurrency;
                    if (calculationResult.isHasWarning()) {
                        updateExchangeCurrency = new ExchangeCurrency(exchangeCurrency.getName(), exchangeCurrency.getAmount(),
                                calculationResult.getWarning(), exchangeCurrency.getExchangeDateTime());
                    } else {
                        updateExchangeCurrency = new ExchangeCurrency(exchangeCurrency.getName(), calculationResult.getAmount(),
                                "", LocalDateTime.now());
                    }
                    exchangeCurrencies.add(updateExchangeCurrency);
                }
                currency.setExchangeCurrencies(exchangeCurrencies);
            }
            accountManager.updateAccount(userAccount);
        }
    }
}
