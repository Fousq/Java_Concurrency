package kz.zhanbolat.concurrency;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class OperationPerSecondRegistry extends Thread {
    private static final Logger logger = LogManager.getLogger(OperationPerSecondRegistry.class);
    private static final int THRESHOLD = 100_000;
    private LocalTime startTime;
    private AtomicInteger count;
    private AtomicBoolean isRunnable;

    public OperationPerSecondRegistry() {
        count = new AtomicInteger(0);
        startTime = LocalTime.now();
        isRunnable = new AtomicBoolean(true);
    }

    public void registry() {
        if (count.incrementAndGet() > THRESHOLD) {
            isRunnable.set(false);
        }
    }

    public boolean isRunnable() {
        return isRunnable.get();
    }

    @Override
    public void run() {
        LocalTime endTime = LocalTime.now();
        double operationsPerSeconds = (double) count.get() / (endTime.toSecondOfDay() - startTime.toSecondOfDay());
        logger.info("Operations per seconds: " + operationsPerSeconds + " ops/sec");
    }
}
