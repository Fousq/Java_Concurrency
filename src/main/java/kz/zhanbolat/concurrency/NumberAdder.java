package kz.zhanbolat.concurrency;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NumberAdder implements Runnable {
    private static final Logger logger = LogManager.getLogger(NumberAdder.class);
    private ThreadMap threadMap;
    private int counter;

    public NumberAdder(ThreadMap threadMap) {
        this.threadMap = threadMap;
        this.counter = 0;
    }

    @Override
    public void run() {
        while (true) {
            Integer number = generateNextNumber();
            threadMap.put(number, number);
        }
    }

    private Integer generateNextNumber() {
        return ++counter;
    }
}
