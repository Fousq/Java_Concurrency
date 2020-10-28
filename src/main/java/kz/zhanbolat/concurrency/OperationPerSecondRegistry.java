package kz.zhanbolat.concurrency;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicInteger;

public class OperationPerSecondRegistry extends Thread {
    private static final Logger logger = LogManager.getLogger(OperationPerSecondRegistry.class);
    private LocalTime startTime;
    private AtomicInteger count;

    public OperationPerSecondRegistry() {
        count = new AtomicInteger(0);
        startTime = LocalTime.now();
    }

    public void registry() {
        count.incrementAndGet();
    }

    @Override
    public void run() {
        LocalTime endTime = LocalTime.now();
        double operationsPerSeconds = (double) count.get() / (endTime.toSecondOfDay() - startTime.toSecondOfDay());
        logger.info("Operations per seconds: " + operationsPerSeconds + " ops/sec");
    }
}
