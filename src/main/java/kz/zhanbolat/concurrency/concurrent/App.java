package kz.zhanbolat.concurrency.concurrent;

import kz.zhanbolat.concurrency.OperationPerSecondRegistry;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    public static void main(String[] args) {
        NumberStorage storage = new NumberStorage();
        OperationPerSecondRegistry registry = new OperationPerSecondRegistry();

        NumberProducer producer = new NumberProducer(registry, storage);
        NumberConsumer consumer = new NumberConsumer(registry, storage);

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        executorService.execute(producer);
        executorService.execute(consumer);

        Runtime.getRuntime().addShutdownHook(registry);
    }
}
