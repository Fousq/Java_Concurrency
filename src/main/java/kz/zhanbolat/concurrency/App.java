/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package kz.zhanbolat.concurrency;

import kz.zhanbolat.concurrency.repository.ExchangeRateRepository;
import kz.zhanbolat.concurrency.repository.ObjectMapperFactory;
import kz.zhanbolat.concurrency.repository.UserAccountRepository;
import kz.zhanbolat.concurrency.repository.impl.ExchangeRateRepositoryImpl;
import kz.zhanbolat.concurrency.repository.impl.UserAccountRepositoryImpl;
import kz.zhanbolat.concurrency.service.AccountManager;
import kz.zhanbolat.concurrency.service.ExchangeRateManager;
import kz.zhanbolat.concurrency.service.UserAccountActualizator;
import kz.zhanbolat.concurrency.service.impl.AccountManagerImpl;
import kz.zhanbolat.concurrency.service.impl.ExchangeRateManagerImpl;
import kz.zhanbolat.concurrency.util.YamlFileLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) {
        ExchangeRateRepository exchangeRateRepository = new ExchangeRateRepositoryImpl(ObjectMapperFactory.INSTANCE.createYmlObjectMapper());
        UserAccountRepository userAccountRepository = new UserAccountRepositoryImpl(ObjectMapperFactory.INSTANCE.createYmlObjectMapper());
        ExchangeRateManager exchangeRateManager = new ExchangeRateManagerImpl("src/main/resources/exchangeRates/exchangeRates.yml", exchangeRateRepository);
        List<UserAccountActualizator> actualizators = new ArrayList<>();
        // load user accounts
        for (File loadYamlFile : YamlFileLoader.loadYamlFiles("src/main/resources/accounts")) {
            AccountManager accountManager = new AccountManagerImpl(loadYamlFile, userAccountRepository);
            actualizators.add(new UserAccountActualizator(accountManager, exchangeRateManager));
        }
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
        actualizators.forEach(actualizator -> executorService.schedule(actualizator, 1, TimeUnit.SECONDS));
        executorService.shutdown();
    }
}
