package net.yorkjr.jareau.service.exceptions;

/**
 * Created by lijunbo on 15/1/19.
 */
public class ServiceException extends RuntimeException {
    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable throwable) {
        super(throwable);
    }

    public ServiceException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
