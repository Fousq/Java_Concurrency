package kz.zhanbolat.concurrency.repository;

import kz.zhanbolat.concurrency.entity.ExchangeRate;

import java.io.File;
import java.util.List;

public interface ExchangeRateRepository {
    List<ExchangeRate> getExchangeRates(File file);
}
