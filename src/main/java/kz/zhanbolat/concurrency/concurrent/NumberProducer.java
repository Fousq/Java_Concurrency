package kz.zhanbolat.concurrency.concurrent;

import kz.zhanbolat.concurrency.OperationPerSecondRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class NumberProducer implements Runnable {
    private static final Logger logger = LogManager.getLogger(NumberProducer.class);
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
        while(true) {
            int number = random.nextInt();
            try {
                storage.add(number);
            } catch (InterruptedException e) {
                logger.error(e);
                continue;
            }
            registry.registry();
        }
    }
}
