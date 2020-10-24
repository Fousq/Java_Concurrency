package kz.zhanbolat.concurrency;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;

public class Summarizer implements Runnable {
    private static final Logger logger = LogManager.getLogger(Summarizer.class);
    private ThreadMap threadMap;

    public Summarizer(ThreadMap threadMap) {
        this.threadMap = threadMap;
    }

    @Override
    public void run() {
        while (true) {
            Collection<Integer> values = threadMap.values();
            Integer sum = 0;
            for (Integer value : values) {
                sum = value;
            }
            logger.info("Summery: " + sum);
        }
    }
}
