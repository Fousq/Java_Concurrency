package kz.zhanbolat.concurrency;

import kz.zhanbolat.concurrency.entity.Post;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MessageConsumer implements Runnable {
    private static final Logger logger = LogManager.getLogger(MessageConsumer.class);
    private MessageBus messageBus;
    private Random random;

    public MessageConsumer(MessageBus messageBus) {
        this.messageBus = messageBus;
        random = new Random();
    }

    @Override
    public void run() {
        boolean isTopicFound = true;
        String storedTopic = "";
        while (true) {
            String topic;
            if (isTopicFound) {
                int topicId = random.nextInt(13) % TopicType.values().length;
                topic = TopicType.values()[topicId].getName();
            } else {
                topic = storedTopic;
            }
            try {
                Post post = messageBus.get(topic);
                logger.info("Found post about " + post.getTopic() + ", with message: " + post.getMsg());
                isTopicFound = true;
            } catch (NoSuchTopicException e) {
                logger.error(e);
                isTopicFound = false;
                storedTopic = topic;
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException ex) {
                    logger.error(ex);
                }
            }
        }
    }
}
