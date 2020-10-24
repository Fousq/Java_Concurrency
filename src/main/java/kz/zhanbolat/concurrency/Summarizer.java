package kz.zhanbolat.concurrency;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.Iterator;

public class Summarizer implements Runnable {
    private static final Logger logger = LogManager.getLogger(Summarizer.class);
    private ThreadMap threadMap;

    public Summarizer(ThreadMap threadMap) {
        this.threadMap = threadMap;
    }

    @Override
    public void run() {
        while (true) {
            Iterator<Integer> values = threadMap.values().iterator();
            Integer sum = 0;
            synchronized (values) {
                while (values.hasNext()) {
                    sum += values.next();
                }
            }
            logger.info("Summery: " + sum);
        }
    }
}
