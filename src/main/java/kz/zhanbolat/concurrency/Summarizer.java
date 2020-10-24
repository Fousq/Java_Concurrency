package kz.zhanbolat.concurrency;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class Summarizer implements Runnable {
    private static final Logger logger = LogManager.getLogger(Summarizer.class);
    private ThreadMap threadMap;

    public Summarizer(ThreadMap threadMap) {
        this.threadMap = threadMap;
    }

    @Override
    public void run() {
        while (true) {
            long sum = threadMap.values().stream().reduce(0, Integer::sum);
            logger.info("Summery: " + sum);
            try {
                TimeUnit.MILLISECONDS.sleep(2);
            } catch (InterruptedException e) {
                logger.error(e);
            }
        }
    }
}
