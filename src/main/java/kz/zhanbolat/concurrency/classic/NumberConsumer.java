package kz.zhanbolat.concurrency.classic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class NumberConsumer implements Runnable {
    private static final Logger logger = LogManager.getLogger(NumberConsumer.class);
    private static final int SIZE = 10;
    private OperationPerSecondRegistry registry;
    private List<Integer> numbers;
    private NumberStorage storage;

    public NumberConsumer(OperationPerSecondRegistry registry, NumberStorage storage) {
        this.registry = registry;
        this.storage = storage;
        numbers = new ArrayList<>(SIZE);
    }

    @Override
    public void run() {
        while(true) {
            Integer number;
            synchronized (storage) {
                 number = storage.pop();
            }
            numbers.add(number);
            double average = 0;
            average = (double) numbers.stream().reduce(0, Integer::sum) / numbers.size();

            logger.info("Average of total: " + average);
            if (SIZE <= numbers.size()) {
                numbers = new ArrayList<>(SIZE);
            }
            registry.registry();
        }
    }
}