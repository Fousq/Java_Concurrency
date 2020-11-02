package kz.zhanbolat.concurrency.classic;

import kz.zhanbolat.concurrency.OperationPerSecondRegistry;

import java.util.Random;

public class NumberProducer implements Runnable {
    private OperationPerSecondRegistry registry;
    private NumberStorage storage;
    private Random random;

    public NumberProducer(OperationPerSecondRegistry registry, NumberStorage storage) {
        this.registry = registry;
        this.storage = storage;
        random = new Random(13);
    }

    @Override
    public void run() {
        while(registry.isRunnable()) {
            int number = random.nextInt();
            synchronized (storage) {
                storage.add(number);
            }
            registry.registry();
        }
    }
}
