package kz.zhanbolat.concurrency;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/** * Pool that block when it has not any items or it full */
public class BlockingObjectPool {
    private static final Logger logger = LogManager.getLogger(BlockingObjectPool.class);
    private BlockingQueue<Object> blockingQueue;

    /** Creates filled pool of passed size
     *  @param size of pool */
    public BlockingObjectPool(int size) {
        blockingQueue = new ArrayBlockingQueue<>(size);
    }

    /** Gets object from pool or blocks if pool is empty
     *  @return object from pool
     */
    public Object get() throws InterruptedException {
        return blockingQueue.take();
    }

    /** Puts object to pool or blocks if pool is full
     * @param object to be taken back to pool */
    public void take(Object object) throws InterruptedException {
        try {
            blockingQueue.put(object);
        } catch (InterruptedException e) {
            logger.error(e);
            throw e;
        }
    }
}
