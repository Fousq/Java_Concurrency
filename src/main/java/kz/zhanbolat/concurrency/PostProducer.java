package kz.zhanbolat.concurrency;

import kz.zhanbolat.concurrency.entity.Post;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PostProducer implements Runnable {
    private static final Logger logger = LogManager.getLogger(PostProducer.class);
    private Random random;
    private MessageBus messageBus;

    public PostProducer(MessageBus messageBus) {
        this.messageBus = messageBus;
        random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            int topicId = random.nextInt(13) % TopicType.values().length;
            TopicType topicType = TopicType.values()[topicId];
            synchronized (messageBus) {
                logger.info("Post about " + topicType.getName() + " will be generated");
                messageBus.add(new Post(topicType.getName(), topicType.getName()));
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    logger.error(e);
                }
            }
        }
    }
}
