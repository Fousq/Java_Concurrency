package kz.zhanbolat.concurrency;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class SquareRooter implements Runnable {
    private static final Logger logger = LogManager.getLogger(SquareRooter.class);
    private List<Integer> numbers;

    public SquareRooter(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        while (true) {
            long sum = 0L;
            synchronized (numbers) {
                for (Integer number : numbers) {
                    sum += (number * number);
                }
            }
            logger.info("Square root of sum of squares: " + Math.sqrt(sum));
        }
    }
}
