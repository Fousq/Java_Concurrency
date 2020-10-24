package kz.zhanbolat.concurrency;

public class NoSuchTopicException extends Exception {
    public NoSuchTopicException(String message) {
        super(message);
    }
}
