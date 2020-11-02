package kz.zhanbolat.concurrency.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class NumberStorage {
    private static final int SIZE = 10;
    private BlockingQueue<Integer> numbers;

    public NumberStorage() {
        numbers = new ArrayBlockingQueue<>(SIZE);
    }

    public void add(Integer number) throws InterruptedException {
        numbers.put(number);
    }

    public Integer pop() throws InterruptedException {
        return numbers.take();
    }
}
