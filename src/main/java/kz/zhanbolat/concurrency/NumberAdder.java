package kz.zhanbolat.concurrency;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class NumberAdder implements Runnable {
    private static final Logger logger = LogManager.getLogger(NumberAdder.class);
    private final List<Integer> numbers;
    private final Random random;

    public NumberAdder(List<Integer> numbers) {
        this.numbers = numbers;
        random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            synchronized (numbers) {
                numbers.add(random.nextInt(13));
            }
            try {
                TimeUnit.NANOSECONDS.sleep(10);
            } catch (InterruptedException e) {
                logger.error(e);
            }
        }
    }
}
