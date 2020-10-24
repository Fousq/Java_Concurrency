package kz.zhanbolat.concurrency;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class SyncSummarizer implements Runnable {
    private static final Logger logger = LogManager.getLogger(SyncSummarizer.class);
    private ThreadMap threadMap;

    public SyncSummarizer(ThreadMap threadMap) {
        this.threadMap = threadMap;
    }

    @Override
    public void run() {
        while (true) {
            long sum;
            synchronized (threadMap) {
                sum = threadMap.values().stream().reduce(0, Integer::sum);
            }
            logger.info("Summery: " + sum);
            try {
                TimeUnit.MILLISECONDS.sleep(2);
            } catch (InterruptedException e) {
                logger.error(e);
            }
        }
    }
}
