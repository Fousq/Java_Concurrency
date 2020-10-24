package kz.zhanbolat.concurrency;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Summarizer implements Runnable {
    private static final Logger logger = LogManager.getLogger(Summarizer.class);
    private List<Integer> numbers;

    public Summarizer(List<Integer> numbers) {
        this.numbers = numbers;
    }


    @Override
    public void run() {
        while (true) {
            Integer sum = 0;
            synchronized (numbers) {
                for (Integer number : numbers) {
                    sum += number;
                }
            }
            logger.info("Sum: " + sum);
        }
    }
}
