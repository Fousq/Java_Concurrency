package kz.zhanbolat.concurrency;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class SyncNumberAdder implements Runnable {
    private static final Logger logger = LogManager.getLogger(SyncNumberAdder.class);
    private ThreadMap threadMap;
    private int counter;

    public SyncNumberAdder(ThreadMap threadMap) {
        this.threadMap = threadMap;
        this.counter = 0;
    }

    @Override
    public void run() {
        while (true) {
            Integer number = generateNextNumber();
            synchronized (threadMap) {
                threadMap.put(number, number);
            }
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                logger.error(e);
            }
        }
    }

    private Integer generateNextNumber() {
        return ++counter;
    }
}
