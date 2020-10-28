package kz.zhanbolat.concurrency.classic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.Queue;

public class NumberStorage {
    private static final Logger logger = LogManager.getLogger(NumberStorage.class);
    private static final int SIZE = 10;
    private Queue<Integer> numbers;

    public NumberStorage() {
        numbers = new LinkedList<>();
    }

    public void add(Integer number) {
        while (numbers.size() >= SIZE) {
            try {
                wait();
            } catch (InterruptedException e) {
                logger.error(e);
            }
        }
        notifyAll();
        numbers.add(number);
    }

    public Integer pop() {
        while(numbers.size() <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                logger.error(e);
            }
        }
        notifyAll();
        return numbers.poll();
    }
}
