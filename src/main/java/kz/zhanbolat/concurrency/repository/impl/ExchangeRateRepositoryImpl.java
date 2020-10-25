package kz.zhanbolat.concurrency.repository.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.zhanbolat.concurrency.entity.ExchangeRate;
import kz.zhanbolat.concurrency.entity.ExchangeRateList;
import kz.zhanbolat.concurrency.repository.ExchangeRateRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExchangeRateRepositoryImpl extends AbstractRepository implements ExchangeRateRepository {
    private static final Logger logger = LogManager.getLogger(ExchangeRateRepositoryImpl.class);

    public ExchangeRateRepositoryImpl(ObjectMapper objectMapper) {
        super(objectMapper);
    }

    @Override
    public List<ExchangeRate> getExchangeRates(File file) {
        List<ExchangeRate> exchangeRates = new ArrayList<>();
        checkParameters(file);
        try {
            exchangeRates.addAll(objectMapper.readValue(file, ExchangeRateList.class).getExchangeRates());
        } catch (IOException e) {
            logger.error("Failed to read file " + file.getPath() + ". Caused by " + e);
        }
        return exchangeRates;
    }
}
