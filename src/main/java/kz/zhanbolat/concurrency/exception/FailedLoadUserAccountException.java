package kz.zhanbolat.concurrency.exception;

public class FailedLoadUserAccountException extends Exception {
    public FailedLoadUserAccountException(String message) {
        super(message);
    }
}
