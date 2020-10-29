package kz.zhanbolat.concurrency.classic;

import kz.zhanbolat.concurrency.OperationPerSecondRegistry;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    public static void main(String[] args) {
        OperationPerSecondRegistry registry = new OperationPerSecondRegistry();
        Runtime.getRuntime().addShutdownHook(registry);

        NumberStorage storage = new NumberStorage();
        NumberProducer producer = new NumberProducer(registry, storage);
        NumberConsumer consumer = new NumberConsumer(registry, storage);

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        executorService.execute(producer);
        executorService.execute(consumer);

        executorService.shutdown();
    }
}
